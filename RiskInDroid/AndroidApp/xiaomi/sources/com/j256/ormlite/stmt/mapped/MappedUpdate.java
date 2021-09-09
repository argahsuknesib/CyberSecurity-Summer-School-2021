package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
    private final FieldType versionFieldType;
    private final int versionFieldTypeIndex;

    private MappedUpdate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType fieldType, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.versionFieldType = fieldType;
        this.versionFieldTypeIndex = i;
    }

    public static <T, ID> MappedUpdate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        DatabaseType databaseType2 = databaseType;
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(64);
            appendTableName(databaseType2, sb, "UPDATE ", tableInfo.getTableName());
            FieldType fieldType = null;
            int i = 0;
            int i2 = -1;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldUpdatable(fieldType2, idField)) {
                    if (fieldType2.isVersion()) {
                        i2 = i;
                    } else {
                        fieldType2 = fieldType;
                    }
                    i++;
                    fieldType = fieldType2;
                }
            }
            int i3 = i + 1;
            if (fieldType != null) {
                i3++;
            }
            FieldType[] fieldTypeArr = new FieldType[i3];
            int i4 = 0;
            boolean z = true;
            for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
                if (isFieldUpdatable(fieldType3, idField)) {
                    if (z) {
                        sb.append("SET ");
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    appendFieldColumnName(databaseType2, sb, fieldType3, null);
                    fieldTypeArr[i4] = fieldType3;
                    sb.append("= ?");
                    i4++;
                }
            }
            sb.append(' ');
            appendWhereFieldEq(databaseType2, idField, sb, null);
            int i5 = i4 + 1;
            fieldTypeArr[i4] = idField;
            if (fieldType != null) {
                sb.append(" AND ");
                appendFieldColumnName(databaseType2, sb, fieldType, null);
                sb.append("= ?");
                fieldTypeArr[i5] = fieldType;
            }
            return new MappedUpdate(tableInfo, sb.toString(), fieldTypeArr, fieldType, i2);
        }
        throw new SQLException("Cannot update " + tableInfo.getDataClass() + " because it doesn't have an id field");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.Object[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        Object obj;
        T t2;
        try {
            if (this.argFieldTypes.length <= 1) {
                return 0;
            }
            Object[] fieldObjects = getFieldObjects(t);
            if (this.versionFieldType != null) {
                obj = this.versionFieldType.moveToNextValue(this.versionFieldType.extractJavaFieldValue(t));
                fieldObjects[this.versionFieldTypeIndex] = this.versionFieldType.convertJavaFieldToSqlArgValue(obj);
            } else {
                obj = null;
            }
            int update = databaseConnection.update(this.statement, fieldObjects, this.argFieldTypes);
            if (update > 0) {
                if (obj != null) {
                    this.versionFieldType.assignField(t, obj, false, null);
                }
                if (!(objectCache == null || (t2 = objectCache.get(this.clazz, this.idField.extractJavaFieldValue(t))) == null || t2 == t)) {
                    for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
                        if (fieldType != this.idField) {
                            fieldType.assignField(t2, fieldType.extractJavaFieldValue(t), false, objectCache);
                        }
                    }
                }
            }
            logger.debug("update data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(update));
            if (fieldObjects.length > 0) {
                logger.trace("update arguments: {}", (Object) fieldObjects);
            }
            return update;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run update stmt on object " + ((Object) t) + ": " + this.statement, e);
        }
    }

    private static boolean isFieldUpdatable(FieldType fieldType, FieldType fieldType2) {
        return fieldType != fieldType2 && !fieldType.isForeignCollection() && !fieldType.isReadOnly();
    }
}
