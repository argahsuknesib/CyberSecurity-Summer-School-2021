package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

public class DeleteBuilder<T, ID> extends StatementBuilder<T, ID> {
    /* access modifiers changed from: protected */
    public void appendStatementEnd(StringBuilder sb, List<ArgumentHolder> list) {
    }

    public DeleteBuilder(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        super(databaseType, tableInfo, dao, StatementBuilder.StatementType.DELETE);
    }

    public PreparedDelete<T> prepare() throws SQLException {
        return super.prepareStatement(null, false);
    }

    public int delete() throws SQLException {
        return this.dao.delete(prepare());
    }

    public void reset() {
        super.reset();
    }

    /* access modifiers changed from: protected */
    public void appendStatementStart(StringBuilder sb, List<ArgumentHolder> list) {
        sb.append("DELETE FROM ");
        this.databaseType.appendEscapedEntityName(sb, this.tableInfo.getTableName());
        sb.append(' ');
    }
}
