/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.codegen.task;

import io.nop.api.core.exceptions.NopException;
import io.nop.commons.util.ClassHelper;
import io.nop.commons.util.FileHelper;
import io.nop.commons.util.StringHelper;
import io.nop.core.reflect.aop.AopAnnotationsLoader;
import io.nop.core.reflect.aop.AopCodeGenerator;
import io.nop.core.reflect.aop.IAopProxy;
import io.nop.core.resource.scan.FileScanHelper;
import io.nop.javac.jdk.JavaCompileResult;
import io.nop.javac.jdk.JavaSourceCode;
import io.nop.javac.jdk.JdkJavaCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import static io.nop.codegen.CodeGenErrors.ARG_MESSAGE;
import static io.nop.codegen.CodeGenErrors.ERR_GEN_AOP_PROXY_FAIL;

/**
 * 查找target/classes目录下的类，如果发现它们使用了已注册的annotation，则为它们生成对应的Proxy类， 存放到target/generated-source目录下。
 */
public class GenAopProxy {
    static final Logger LOG = LoggerFactory.getLogger(GenAopProxy.class);

    public void execute(File projectDir, boolean forTest) {
        File classesDir;
        File sourceDir;

        if (forTest) {
            classesDir = new File(projectDir, "target/test-classes");
            sourceDir = new File(projectDir, "target/generated-test-sources");
        } else {
            classesDir = new File(projectDir, "target/classes");
            sourceDir = new File(projectDir, "target/generated-sources");
        }

        generate(classesDir, sourceDir);
    }

    ClassLoader buildExtClassLoader(File classesDir) {
        URLClassLoader classLoader = new URLClassLoader(new URL[]{FileHelper.toURL(classesDir)}, ClassHelper.getDefaultClassLoader());
        return classLoader;
    }

    public void generate(File classesDir, File sourceDir) {
        List<String> classNames = findClassNames(classesDir);
        ClassLoader classLoader = buildExtClassLoader(classesDir);

        Class<?>[] annClasses = AopAnnotationsLoader.getAnnotationClasses().toArray(new Class<?>[0]);

        List<JavaSourceCode> sources = new ArrayList<>();
        classNames.forEach(className -> {
            try {
                Class<?> clazz = ClassHelper.forName(className, classLoader);
                if (Modifier.isAbstract(clazz.getModifiers()))
                    return;
                if (IAopProxy.class.isAssignableFrom(clazz))
                    return;

                AopCodeGenerator gen = new AopCodeGenerator();
                String code = gen.build(clazz, annClasses);
                if (code == null)
                    return;

                String aopClassName = AopCodeGenerator.getAopClassName(clazz);
                saveCode(sourceDir, aopClassName, code, sources);
            } catch (Exception e) {
                throw NopException.adapt(e);
            }
        });

        if (!sources.isEmpty()) {
            JdkJavaCompiler compiler = new JdkJavaCompiler();
            List<String> classPaths = JdkJavaCompiler.getDefaultClassPaths();
            JavaCompileResult result = compiler.compile(sources, classPaths);
            if (!result.isSuccess())
                throw new NopException(ERR_GEN_AOP_PROXY_FAIL)
                        .param(ARG_MESSAGE, result.getErrorMessage());
            result.saveGenerated(classesDir);
        }
    }

    String getSourceFileName(String aopClassName) {
        return aopClassName.replace('.', '/') + ".java";
    }

    void saveCode(File sourceDir, String aopClassName, String code, List<JavaSourceCode> sources) {
        File file = new File(sourceDir, getSourceFileName(aopClassName));
        LOG.info("nop.aop.gen-proxy-code:file={}", file);

        if (file.length() > 0) {
            String text = FileHelper.readText(file, null);
            if (code.equals(text))
                return;
        }
        FileHelper.writeText(file, code, null);

        sources.add(new JavaSourceCode(aopClassName, code));

//        Compiler compiler = new Compiler();
//        compiler.setSourcePath(new File[]{sourceDir});
//        compiler.setIClassLoader(new ClassLoaderIClassLoader(ClassHelper.getDefaultClassLoader()));
//        compiler.setDestinationDirectory(classesDir, true);
//        compiler.setEncoding(StringHelper.CHARSET_UTF8);
//        compiler.setVerbose(false);
//        compiler.setDebugSource(true);
//        compiler.setDebugLines(true);
//        compiler.setDebugVars(true);
//
//        try {
//            compiler.compile(new File[]{file});
//        } catch (Exception e) {
//            throw NopException.adapt(e);
//        }
    }

    List<String> findClassNames(File classesDir) {
        List<String> classNames = new ArrayList<>();
        FileScanHelper.scanDir(classesDir, file -> {
            if (file.getName().endsWith(".class")) {
                String relativePath = FileHelper.getRelativePath(classesDir, file);
                String className = StringHelper.removeTail(relativePath, ".class").replace('/', '.');
                classNames.add(className);
            }
        });
        return classNames;
    }
}
