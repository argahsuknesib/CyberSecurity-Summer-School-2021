package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedRefresh<T, ID> extends MappedQueryForFieldEq<T, ID> {
    private MappedRefresh(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2, "refresh");
    }

    public int executeRefresh(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        Object execute = super.execute(databaseConnection, this.idField.extractJavaFieldValue(t), null);
        if (execute == null) {
            return 0;
        }
        for (FieldType fieldType : this.resultsFieldTypes) {
            if (fieldType != this.idField) {
                fieldType.assignField(t, fieldType.extractJavaFieldValue(execute), false, objectCache);
            }
        }
        return 1;
    }

    public static <T, ID> MappedRefresh<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField != null) {
            return new MappedRefresh<>(tableInfo, buildStatement(databaseType, tableInfo, idField), new FieldType[]{tableInfo.getIdField()}, tableInfo.getFieldTypes());
        }
        throw new SQLException("Cannot refresh " + tableInfo.getDataClass() + " because it doesn't have an id field");
    }
}
