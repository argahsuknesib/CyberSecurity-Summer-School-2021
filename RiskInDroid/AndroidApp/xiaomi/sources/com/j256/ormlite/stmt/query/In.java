package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class In extends BaseComparison {

    /* renamed from: in  reason: collision with root package name */
    private final boolean f4500in;
    private Iterable<?> objects;

    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public In(String str, FieldType fieldType, Iterable<?> iterable, boolean z) throws SQLException {
        super(str, fieldType, null, true);
        this.objects = iterable;
        this.f4500in = z;
    }

    public In(String str, FieldType fieldType, Object[] objArr, boolean z) throws SQLException {
        super(str, fieldType, null, true);
        this.objects = Arrays.asList(objArr);
        this.f4500in = z;
    }

    public void appendOperation(StringBuilder sb) {
        if (this.f4500in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        sb.append('(');
        boolean z = true;
        for (Object next : this.objects) {
            if (next != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                super.appendArgOrValue(databaseType, this.fieldType, sb, list, next);
            } else {
                throw new IllegalArgumentException("one of the IN values for '" + this.columnName + "' is null");
            }
        }
        sb.append(") ");
    }
}
