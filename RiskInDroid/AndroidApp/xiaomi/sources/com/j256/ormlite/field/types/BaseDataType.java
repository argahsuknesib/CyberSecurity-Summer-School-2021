package com.j256.ormlite.field.types;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract class BaseDataType extends BaseFieldConverter implements DataPersister {
    private static final Class<?>[] NO_CLASSES = new Class[0];
    private final Class<?>[] classes;
    private final SqlType sqlType;

    public Object convertIdNumber(Number number) {
        return null;
    }

    public String[] getAssociatedClassNames() {
        return null;
    }

    public int getDefaultWidth() {
        return 0;
    }

    public String getSqlOtherType() {
        return null;
    }

    public boolean isAppropriateId() {
        return true;
    }

    public boolean isArgumentHolderRequired() {
        return false;
    }

    public boolean isComparable() {
        return true;
    }

    public boolean isEscapedValue() {
        return true;
    }

    public boolean isPrimitive() {
        return false;
    }

    public boolean isSelfGeneratedId() {
        return false;
    }

    public boolean isValidForVersion() {
        return false;
    }

    public boolean isValidGeneratedType() {
        return false;
    }

    public Object makeConfigObject(FieldType fieldType) throws SQLException {
        return null;
    }

    public Object moveToNextValue(Object obj) throws SQLException {
        return null;
    }

    public BaseDataType(SqlType sqlType2, Class<?>[] clsArr) {
        this.sqlType = sqlType2;
        this.classes = clsArr;
    }

    public BaseDataType(SqlType sqlType2) {
        this.sqlType = sqlType2;
        this.classes = NO_CLASSES;
    }

    public boolean isValidForField(Field field) {
        Class<?>[] clsArr = this.classes;
        if (clsArr.length == 0) {
            return true;
        }
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(field.getType())) {
                return true;
            }
        }
        return false;
    }

    public Class<?> getPrimaryClass() {
        Class<?>[] clsArr = this.classes;
        if (clsArr.length == 0) {
            return null;
        }
        return clsArr[0];
    }

    public SqlType getSqlType() {
        return this.sqlType;
    }

    public Class<?>[] getAssociatedClasses() {
        return this.classes;
    }

    public boolean isEscapedDefaultValue() {
        return isEscapedValue();
    }

    public Object generateId() {
        throw new IllegalStateException("Should not have tried to generate this type");
    }

    public boolean dataIsEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        return sqlArgToJava(fieldType, parseDefaultString(fieldType, str), i);
    }
}
