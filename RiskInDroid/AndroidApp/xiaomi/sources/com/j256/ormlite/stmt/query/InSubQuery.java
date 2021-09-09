package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.List;

public class InSubQuery extends BaseComparison {

    /* renamed from: in  reason: collision with root package name */
    private final boolean f4501in;
    private final QueryBuilder.InternalQueryBuilderWrapper subQueryBuilder;

    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public InSubQuery(String str, FieldType fieldType, QueryBuilder.InternalQueryBuilderWrapper internalQueryBuilderWrapper, boolean z) throws SQLException {
        super(str, fieldType, null, true);
        this.subQueryBuilder = internalQueryBuilderWrapper;
        this.f4501in = z;
    }

    public void appendOperation(StringBuilder sb) {
        if (this.f4501in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        sb.append('(');
        this.subQueryBuilder.appendStatementString(sb, list);
        FieldType[] resultFieldTypes = this.subQueryBuilder.getResultFieldTypes();
        if (resultFieldTypes != null) {
            if (resultFieldTypes.length != 1) {
                throw new SQLException("There must be only 1 result column in sub-query but we found " + resultFieldTypes.length);
            } else if (this.fieldType.getSqlType() != resultFieldTypes[0].getSqlType()) {
                throw new SQLException("Outer column " + this.fieldType + " is not the same type as inner column " + resultFieldTypes[0]);
            }
        }
        sb.append(") ");
    }
}
