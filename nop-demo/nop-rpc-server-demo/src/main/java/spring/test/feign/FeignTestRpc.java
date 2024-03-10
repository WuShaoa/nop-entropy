/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package spring.test.feign;

import io.nop.api.core.beans.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * nop-rpc-server-demo和nop-rpc-client-demo相互调用。
 * 这里是Spring服务通过Feign接口调用nop-rpc-client-demo中的NopGraphQL服务
 */
@FeignClient(name = "my-service", url = "http://localhost:9092")
public interface FeignTestRpc {

    @PostMapping("/r/TestRpc__myMethod")
    ApiResponse<MyResponse> myMethod(@RequestBody MyRequest request, @RequestParam("%40selection") String selection);
}