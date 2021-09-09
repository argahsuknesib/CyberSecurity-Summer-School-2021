package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class RawRowMapperImpl<T, ID> implements RawRowMapper<T> {
    private final TableInfo<T, ID> tableInfo;

    public RawRowMapperImpl(TableInfo<T, ID> tableInfo2) {
        this.tableInfo = tableInfo2;
    }

    public T mapRow(String[] strArr, String[] strArr2) throws SQLException {
        T createObject = this.tableInfo.createObject();
        for (int i = 0; i < strArr.length; i++) {
            if (i < strArr2.length) {
                FieldType fieldTypeByColumnName = this.tableInfo.getFieldTypeByColumnName(strArr[i]);
                fieldTypeByColumnName.assignField(createObject, fieldTypeByColumnName.convertStringToJavaField(strArr2[i], i), false, null);
            }
        }
        return createObject;
    }
}
