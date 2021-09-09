package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Date;

public class DateIntegerType extends BaseDateType {
    private static final DateIntegerType singleTon = new DateIntegerType();

    public boolean isEscapedValue() {
        return false;
    }

    public static DateIntegerType getSingleton() {
        return singleTon;
    }

    private DateIntegerType() {
        super(SqlType.INTEGER);
    }

    protected DateIntegerType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default date-integer value: " + str, e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Integer.valueOf(databaseResults.getInt(i));
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return new Date(((long) ((Integer) obj).intValue()) * 1000);
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Integer.valueOf((int) (((Date) obj).getTime() / 1000));
    }

    public Class<?> getPrimaryClass() {
        return Date.class;
    }
}
