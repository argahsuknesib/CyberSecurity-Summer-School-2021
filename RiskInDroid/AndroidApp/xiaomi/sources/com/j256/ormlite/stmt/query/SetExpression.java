package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class SetExpression extends BaseComparison {
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

    public SetExpression(String str, FieldType fieldType, String str2) throws SQLException {
        super(str, fieldType, str2, true);
    }

    public void appendOperation(StringBuilder sb) {
        sb.append("= ");
    }

    /* access modifiers changed from: protected */
    public void appendArgOrValue(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, List<ArgumentHolder> list, Object obj) {
        sb.append(obj);
        sb.append(' ');
    }
}
