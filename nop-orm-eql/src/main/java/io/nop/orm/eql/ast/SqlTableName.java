/**
 * Copyright (c) 2017-2024 Nop Platform. All rights reserved.
 * Author: canonical_entropy@163.com
 * Blog:   https://www.zhihu.com/people/canonical-entropy
 * Gitee:  https://gitee.com/canonical-entropy/nop-entropy
 * Github: https://github.com/entropy-cloud/nop-entropy
 */
package io.nop.orm.eql.ast;

import io.nop.commons.util.objects.PropPath;
import io.nop.core.lang.ast.ASTNode;
import io.nop.orm.eql.ast._gen._SqlTableName;
import io.nop.orm.eql.meta.ISqlSelectionMeta;

public class SqlTableName extends _SqlTableName {
    private ISqlSelectionMeta resolvedTableMeta;
    private SqlSelect resolvedCte;

    public ISqlSelectionMeta getResolvedTableMeta() {
        return resolvedTableMeta;
    }

    public void setResolvedTableMeta(ISqlSelectionMeta resolvedTableMeta) {
        this.resolvedTableMeta = resolvedTableMeta;
    }

    public SqlSelect getResolvedCte() {
        return resolvedCte;
    }

    public void setResolvedCte(SqlSelect resolvedCte) {
        this.resolvedCte = resolvedCte;
    }

    @Override
    protected void copyExtFieldsTo(ASTNode node) {
        super.copyExtFieldsTo(node);
        SqlTableName table = (SqlTableName) node;
        table.resolvedCte = resolvedCte;
        table.resolvedTableMeta = resolvedTableMeta;
    }

    public String getFullName() {
        if (getOwner() == null)
            return getName();

        StringBuilder sb = new StringBuilder();
        getOwner().getFullName(sb);
        sb.append('.');
        sb.append(getName());
        return sb.toString();
    }

    public PropPath toPropPath() {
        if (owner == null)
            return new PropPath(getName());
        return owner.toPropPath(new PropPath(getName()));
    }
}
