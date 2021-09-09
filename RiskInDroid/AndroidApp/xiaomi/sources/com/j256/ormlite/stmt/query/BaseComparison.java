package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.ColumnArg;
import com.j256.ormlite.stmt.SelectArg;
import java.sql.SQLException;
import java.util.List;

abstract class BaseComparison implements Comparison {
    protected final String columnName;
    protected final FieldType fieldType;
    private final Object value;

    public abstract void appendOperation(StringBuilder sb);

    protected BaseComparison(String str, FieldType fieldType2, Object obj, boolean z) throws SQLException {
        if (!z || fieldType2 == null || fieldType2.isComparable()) {
            this.columnName = str;
            this.fieldType = fieldType2;
            this.value = obj;
            return;
        }
        throw new SQLException("Field '" + str + "' is of data type " + fieldType2.getDataPersister() + " which can not be compared");
    }

    public void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        if (str != null) {
            databaseType.appendEscapedEntityName(sb, str);
            sb.append('.');
        }
        databaseType.appendEscapedEntityName(sb, this.columnName);
        sb.append(' ');
        appendOperation(sb);
        appendValue(databaseType, sb, list);
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        appendArgOrValue(databaseType, this.fieldType, sb, list, this.value);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    public void appendArgOrValue(DatabaseType databaseType, FieldType fieldType2, StringBuilder sb, List<ArgumentHolder> list, Object obj) throws SQLException {
        if (obj != null) {
            boolean z = false;
            if (obj instanceof ArgumentHolder) {
                sb.append('?');
                ArgumentHolder argumentHolder = (ArgumentHolder) obj;
                argumentHolder.setMetaInfo(this.columnName, fieldType2);
                list.add(argumentHolder);
            } else if (obj instanceof ColumnArg) {
                ColumnArg columnArg = (ColumnArg) obj;
                String tableName = columnArg.getTableName();
                if (tableName != null) {
                    databaseType.appendEscapedEntityName(sb, tableName);
                    sb.append('.');
                }
                databaseType.appendEscapedEntityName(sb, columnArg.getColumnName());
            } else if (fieldType2.isArgumentHolderRequired()) {
                sb.append('?');
                SelectArg selectArg = new SelectArg();
                selectArg.setMetaInfo(this.columnName, fieldType2);
                selectArg.setValue(obj);
                list.add(selectArg);
            } else if (fieldType2.isForeign() && fieldType2.getType().isAssignableFrom(obj.getClass())) {
                FieldType foreignIdField = fieldType2.getForeignIdField();
                appendArgOrValue(databaseType, foreignIdField, sb, list, foreignIdField.extractJavaFieldValue(obj));
                if (!z) {
                    sb.append(' ');
                    return;
                }
                return;
            } else if (fieldType2.isEscapedValue()) {
                databaseType.appendEscapedWord(sb, fieldType2.convertJavaFieldToSqlArgValue(obj).toString());
            } else if (fieldType2.isForeign()) {
                String obj2 = fieldType2.convertJavaFieldToSqlArgValue(obj).toString();
                if (obj2.length() <= 0 || "0123456789.-+".indexOf(obj2.charAt(0)) >= 0) {
                    sb.append(obj2);
                } else {
                    throw new SQLException("Foreign field " + fieldType2 + " does not seem to be producing a numerical value '" + obj2 + "'. Maybe you are passing the wrong object to comparison: " + this);
                }
            } else {
                sb.append(fieldType2.convertJavaFieldToSqlArgValue(obj));
            }
            z = true;
            if (!z) {
            }
        } else {
            throw new SQLException("argument for '" + fieldType2.getFieldName() + "' is null");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.columnName);
        sb.append(' ');
        appendOperation(sb);
        sb.append(' ');
        sb.append(this.value);
        return sb.toString();
    }
}
