package com.j256.ormlite.stmt.mapped;

import android.support.v4.app.NotificationCompat;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;

public class MappedDeleteCollection<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedDeleteCollection(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    public static <T, ID> int deleteObjects(DatabaseType databaseType, TableInfo<T, ID> tableInfo, DatabaseConnection databaseConnection, Collection<T> collection, ObjectCache objectCache) throws SQLException {
        MappedDeleteCollection<T, ID> build = build(databaseType, tableInfo, collection.size());
        Object[] objArr = new Object[collection.size()];
        FieldType idField = tableInfo.getIdField();
        int i = 0;
        for (T extractJavaFieldToSqlArgValue : collection) {
            objArr[i] = idField.extractJavaFieldToSqlArgValue(extractJavaFieldToSqlArgValue);
            i++;
        }
        return updateRows(databaseConnection, tableInfo.getDataClass(), build, objArr, objectCache);
    }

    public static <T, ID> int deleteIds(DatabaseType databaseType, TableInfo<T, ID> tableInfo, DatabaseConnection databaseConnection, Collection<ID> collection, ObjectCache objectCache) throws SQLException {
        MappedDeleteCollection<T, ID> build = build(databaseType, tableInfo, collection.size());
        Object[] objArr = new Object[collection.size()];
        FieldType idField = tableInfo.getIdField();
        int i = 0;
        for (ID convertJavaFieldToSqlArgValue : collection) {
            objArr[i] = idField.convertJavaFieldToSqlArgValue(convertJavaFieldToSqlArgValue);
            i++;
        }
        return updateRows(databaseConnection, tableInfo.getDataClass(), build, objArr, objectCache);
    }

    private static <T, ID> MappedDeleteCollection<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo, int i) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            appendTableName(databaseType, sb, "DELETE FROM ", tableInfo.getTableName());
            FieldType[] fieldTypeArr = new FieldType[i];
            appendWhereIds(databaseType, idField, sb, i, fieldTypeArr);
            return new MappedDeleteCollection<>(tableInfo, sb.toString(), fieldTypeArr);
        }
        throw new SQLException("Cannot delete " + tableInfo.getDataClass() + " because it doesn't have an id field defined");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.Object[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    private static <T, ID> int updateRows(DatabaseConnection databaseConnection, Class<T> cls, MappedDeleteCollection<T, ID> mappedDeleteCollection, Object[] objArr, ObjectCache objectCache) throws SQLException {
        try {
            int delete = databaseConnection.delete(mappedDeleteCollection.statement, objArr, mappedDeleteCollection.argFieldTypes);
            if (delete > 0 && objectCache != null) {
                for (Object remove : objArr) {
                    objectCache.remove(cls, remove);
                }
            }
            logger.debug("delete-collection with statement '{}' and {} args, changed {} rows", mappedDeleteCollection.statement, Integer.valueOf(objArr.length), Integer.valueOf(delete));
            if (objArr.length > 0) {
                logger.trace("delete-collection arguments: {}", (Object) objArr);
            }
            return delete;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run delete collection stmt: " + mappedDeleteCollection.statement, e);
        }
    }

    private static void appendWhereIds(DatabaseType databaseType, FieldType fieldType, StringBuilder sb, int i, FieldType[] fieldTypeArr) {
        sb.append("WHERE ");
        databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
        sb.append(" IN (");
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append('?');
            if (fieldTypeArr != null) {
                fieldTypeArr[i2] = fieldType;
            }
        }
        sb.append(") ");
    }
}
