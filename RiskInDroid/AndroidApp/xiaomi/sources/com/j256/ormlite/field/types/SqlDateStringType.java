package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.SQLException;

public class SqlDateStringType extends DateStringType {
    private static final SqlDateStringType singleTon = new SqlDateStringType();

    public static SqlDateStringType getSingleton() {
        return singleTon;
    }

    private SqlDateStringType() {
        super(SqlType.STRING);
    }

    protected SqlDateStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        return new Date(((java.util.Date) super.sqlArgToJava(fieldType, obj, i)).getTime());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return super.javaToSqlArg(fieldType, new java.util.Date(((Date) obj).getTime()));
    }

    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }
}
