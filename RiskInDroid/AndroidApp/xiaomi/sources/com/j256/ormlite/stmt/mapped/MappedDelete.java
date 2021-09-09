package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedDelete<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedDelete(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
    }

    public static <T, ID> MappedDelete<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(64);
            appendTableName(databaseType, sb, "DELETE FROM ", tableInfo.getTableName());
            appendWhereFieldEq(databaseType, idField, sb, null);
            return new MappedDelete<>(tableInfo, sb.toString(), new FieldType[]{idField});
        }
        throw new SQLException("Cannot delete from " + tableInfo.getDataClass() + " because it doesn't have an id field");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.Object[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    public int delete(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        try {
            Object[] fieldObjects = getFieldObjects(t);
            int delete = databaseConnection.delete(this.statement, fieldObjects, this.argFieldTypes);
            logger.debug("delete data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(delete));
            if (fieldObjects.length > 0) {
                logger.trace("delete arguments: {}", (Object) fieldObjects);
            }
            if (delete > 0 && objectCache != null) {
                objectCache.remove(this.clazz, this.idField.extractJavaFieldToSqlArgValue(t));
            }
            return delete;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run delete stmt on object " + ((Object) t) + ": " + this.statement, e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.debug(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int, java.lang.Integer]
     candidates:
      com.j256.ormlite.logger.Logger.debug(java.lang.Throwable, java.lang.String, java.lang.Object, java.lang.Object):void
      com.j256.ormlite.logger.Logger.debug(java.lang.String, java.lang.Object, java.lang.Object, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.Object[]]
     candidates:
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object[]):void
      com.j256.ormlite.logger.Logger.trace(java.lang.Throwable, java.lang.String):void
      com.j256.ormlite.logger.Logger.trace(java.lang.String, java.lang.Object):void */
    public int deleteById(DatabaseConnection databaseConnection, ID id, ObjectCache objectCache) throws SQLException {
        try {
            Object[] objArr = {convertIdToFieldObject(id)};
            int delete = databaseConnection.delete(this.statement, objArr, this.argFieldTypes);
            logger.debug("delete data with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) 1, (Object) Integer.valueOf(delete));
            logger.trace("delete arguments: {}", (Object) objArr);
            if (delete > 0 && objectCache != null) {
                objectCache.remove(this.clazz, id);
            }
            return delete;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run deleteById stmt on id " + ((Object) id) + ": " + this.statement, e);
        }
    }
}
