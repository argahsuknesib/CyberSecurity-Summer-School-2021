package com.j256.ormlite.stmt.mapped;

import android.support.v4.app.NotificationCompat;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    private MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.Object[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[Catch:{ SQLException -> 0x0121, SQLException -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A[Catch:{ SQLException -> 0x0121, SQLException -> 0x0139 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A[Catch:{ SQLException -> 0x0121, SQLException -> 0x0139 }] */
    public int insert(DatabaseType databaseType, DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        KeyHolder keyHolder;
        Object[] fieldObjects;
        Object obj;
        int insert;
        Object extractRawJavaFieldValue;
        if (this.idField != null) {
            boolean z = !this.idField.isAllowGeneratedIdInsert() || this.idField.isObjectsFieldValueDefault(t);
            if (!this.idField.isSelfGeneratedId() || !this.idField.isGeneratedId()) {
                if (!this.idField.isGeneratedIdSequence() || !databaseType.isSelectSequenceBeforeInsert()) {
                    if (this.idField.isGeneratedId() && z) {
                        keyHolder = new KeyHolder();
                        if (this.tableInfo.isForeignAutoCreate()) {
                            for (FieldType fieldType : this.tableInfo.getFieldTypes()) {
                                if (fieldType.isForeignAutoCreate() && (extractRawJavaFieldValue = fieldType.extractRawJavaFieldValue(t)) != null && fieldType.getForeignIdField().isObjectsFieldValueDefault(extractRawJavaFieldValue)) {
                                    fieldType.createWithForeignDao(extractRawJavaFieldValue);
                                }
                            }
                        }
                        fieldObjects = getFieldObjects(t);
                        if (this.versionFieldTypeIndex >= 0 || fieldObjects[this.versionFieldTypeIndex] != null) {
                            obj = null;
                        } else {
                            FieldType fieldType2 = this.argFieldTypes[this.versionFieldTypeIndex];
                            obj = fieldType2.moveToNextValue(null);
                            fieldObjects[this.versionFieldTypeIndex] = fieldType2.convertJavaFieldToSqlArgValue(obj);
                        }
                        insert = databaseConnection.insert(this.statement, fieldObjects, this.argFieldTypes, keyHolder);
                        logger.debug("insert data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(insert));
                        if (fieldObjects.length > 0) {
                            logger.trace("insert arguments: {}", (Object) fieldObjects);
                        }
                        if (insert > 0) {
                            if (obj != null) {
                                this.argFieldTypes[this.versionFieldTypeIndex].assignField(t, obj, false, null);
                            }
                            if (keyHolder != null) {
                                Number key = keyHolder.getKey();
                                if (key == null) {
                                    throw new SQLException("generated-id key was not set by the update call, maybe a schema mismatch between entity and database table?");
                                } else if (key.longValue() != 0) {
                                    assignIdValue(t, key, "keyholder", objectCache);
                                } else {
                                    throw new SQLException("generated-id key must not be 0 value, maybe a schema mismatch between entity and database table?");
                                }
                            }
                            if (objectCache != null && foreignCollectionsAreAssigned(this.tableInfo.getForeignCollections(), t)) {
                                objectCache.put(this.clazz, this.idField.extractJavaFieldValue(t), t);
                            }
                        }
                        return insert;
                    }
                } else if (z) {
                    assignSequenceId(databaseConnection, t, objectCache);
                }
            } else if (z) {
                this.idField.assignField(t, this.idField.generateId(), false, objectCache);
            }
        }
        keyHolder = null;
        try {
            if (this.tableInfo.isForeignAutoCreate()) {
            }
            fieldObjects = getFieldObjects(t);
            if (this.versionFieldTypeIndex >= 0) {
            }
            obj = null;
            insert = databaseConnection.insert(this.statement, fieldObjects, this.argFieldTypes, keyHolder);
            logger.debug("insert data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(insert));
            if (fieldObjects.length > 0) {
            }
            if (insert > 0) {
            }
            return insert;
        } catch (SQLException e) {
            logger.debug("insert data with statement '{}' and {} args, threw exception: {}", this.statement, Integer.valueOf(fieldObjects.length), e);
            if (fieldObjects.length > 0) {
                logger.trace("insert arguments: {}", (Object) fieldObjects);
            }
            throw e;
        } catch (SQLException e2) {
            throw SqlExceptionUtil.create("Unable to run insert stmt on object " + ((Object) t) + ": " + this.statement, e2);
        }
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
        appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        int i = 0;
        int i2 = -1;
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i2 = i;
                }
                i++;
            }
        }
        FieldType[] fieldTypeArr = new FieldType[i];
        if (i == 0) {
            databaseType.appendInsertNoColumns(sb);
        } else {
            sb.append('(');
            boolean z = true;
            int i3 = 0;
            for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, fieldType2)) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    appendFieldColumnName(databaseType, sb, fieldType2, null);
                    fieldTypeArr[i3] = fieldType2;
                    i3++;
                }
            }
            sb.append(") VALUES (");
            boolean z2 = true;
            for (FieldType isFieldCreatable : tableInfo.getFieldTypes()) {
                if (isFieldCreatable(databaseType, isFieldCreatable)) {
                    if (z2) {
                        z2 = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append('?');
                }
            }
            sb.append(')');
        }
        return new MappedCreate(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i2);
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) throws SQLException {
        for (FieldType extractJavaFieldValue : fieldTypeArr) {
            if (extractJavaFieldValue.extractJavaFieldValue(obj) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection() || fieldType.isReadOnly()) {
            return false;
        }
        if ((!databaseType.isIdSequenceNeeded() || !databaseType.isSelectSequenceBeforeInsert()) && fieldType.isGeneratedId() && !fieldType.isSelfGeneratedId() && !fieldType.isAllowGeneratedIdInsert()) {
            return false;
        }
        return true;
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        String generatedIdSequence;
        if (fieldType == null || (generatedIdSequence = fieldType.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(queryForLong), this.queryNextSequenceStmt);
        if (queryForLong != 0) {
            assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
            return;
        }
        throw new SQLException("Should not have returned 0 for stmt: " + this.queryNextSequenceStmt);
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(t, number, objectCache);
        if (logger.isLevelEnabled(Log.Level.DEBUG)) {
            logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }

    static class KeyHolder implements GeneratedKeyHolder {
        Number key;

        private KeyHolder() {
        }

        public Number getKey() {
            return this.key;
        }

        public void addKey(Number number) throws SQLException {
            if (this.key == null) {
                this.key = number;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", now set to " + number);
        }
    }
}
