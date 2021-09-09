package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract class BaseEnumType extends BaseDataType {
    protected BaseEnumType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    protected BaseEnumType(SqlType sqlType) {
        super(sqlType);
    }

    protected static Enum<?> enumVal(FieldType fieldType, Object obj, Enum<?> enumR, Enum<?> enumR2) throws SQLException {
        if (enumR != null) {
            return enumR;
        }
        if (enumR2 != null) {
            return enumR2;
        }
        throw new SQLException("Cannot get enum value of '" + obj + "' for field " + fieldType);
    }

    public boolean isValidForField(Field field) {
        return field.getType().isEnum();
    }
}
