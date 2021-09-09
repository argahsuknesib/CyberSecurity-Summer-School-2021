package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

public class Exists implements Clause {
    private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;

    public Exists(QueryBuilder.InternalQueryBuilderWrapper internalQueryBuilderWrapper) {
        this.subQueryBuilder = internalQueryBuilderWrapper;
    }

    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        sb.append("EXISTS (");
        this.subQueryBuilder.appendStatementString(sb, list);
        sb.append(") ");
    }
}
