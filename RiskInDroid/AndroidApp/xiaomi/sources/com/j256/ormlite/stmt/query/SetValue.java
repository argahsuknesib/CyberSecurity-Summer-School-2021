package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.NullArgHolder;
import java.sql.SQLException;
import java.util.List;

public class SetValue extends BaseComparison {
    private static final ArgumentHolder nullValue = new NullArgHolder();

    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    public /* bridge */ /* synthetic */ void appendValue(DatabaseType databaseType, StringBuilder sb, List list) throws SQLException {
        super.appendValue(databaseType, sb, list);
    }

    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetValue(String str, FieldType fieldType, Object obj) throws SQLException {
        super(str, fieldType, obj == null ? nullValue : obj, false);
    }

    public void appendOperation(StringBuilder sb) {
        sb.append("= ");
    }
}
