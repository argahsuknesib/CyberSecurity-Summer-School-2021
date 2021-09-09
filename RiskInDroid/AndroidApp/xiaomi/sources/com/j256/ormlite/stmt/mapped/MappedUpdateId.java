package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdateId<T, ID> extends BaseMappedStatement<T, ID> {
    private MappedUpdateId(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        super(tableInfo, str, fieldTypeArr);
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
    public int execute(DatabaseConnection databaseConnection, T t, ID id, ObjectCache objectCache) throws SQLException {
        T updateId;
        try {
            Object[] objArr = {convertIdToFieldObject(id), extractIdToFieldObject(t)};
            int update = databaseConnection.update(this.statement, objArr, this.argFieldTypes);
            if (update > 0) {
                if (!(objectCache == null || (updateId = objectCache.updateId(this.clazz, this.idField.extractJavaFieldValue(t), id)) == null || updateId == t)) {
                    this.idField.assignField(updateId, id, false, objectCache);
                }
                this.idField.assignField(t, id, false, objectCache);
            }
            logger.debug("updating-id with statement '{}' and {} args, changed {} rows", (Object) this.statement, (Object) 2, (Object) Integer.valueOf(update));
            logger.trace("updating-id arguments: {}", (Object) objArr);
            return update;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run update-id stmt on object " + ((Object) t) + ": " + this.statement, e);
        }
    }

    public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            StringBuilder sb = new StringBuilder(64);
            appendTableName(databaseType, sb, "UPDATE ", tableInfo.getTableName());
            sb.append("SET ");
            appendFieldColumnName(databaseType, sb, idField, null);
            sb.append("= ? ");
            appendWhereFieldEq(databaseType, idField, sb, null);
            return new MappedUpdateId<>(tableInfo, sb.toString(), new FieldType[]{idField, idField});
        }
        throw new SQLException("Cannot update-id in " + tableInfo.getDataClass() + " because it doesn't have an id field");
    }

    private Object extractIdToFieldObject(T t) throws SQLException {
        return this.idField.extractJavaFieldToSqlArgValue(t);
    }
}
