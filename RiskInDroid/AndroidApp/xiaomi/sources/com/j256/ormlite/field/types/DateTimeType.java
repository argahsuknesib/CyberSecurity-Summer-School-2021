package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class DateTimeType extends BaseDataType {
    private static final String[] associatedClassNames = {"org.joda.time.DateTime"};
    private static Class<?> dateTimeClass = null;
    private static Method getMillisMethod = null;
    private static Constructor<?> millisConstructor = null;
    private static final DateTimeType singleTon = new DateTimeType();

    public boolean isAppropriateId() {
        return false;
    }

    public boolean isEscapedValue() {
        return false;
    }

    public boolean isValidForVersion() {
        return true;
    }

    private DateTimeType() {
        super(SqlType.LONG);
    }

    protected DateTimeType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static DateTimeType getSingleton() {
        return singleTon;
    }

    public String[] getAssociatedClassNames() {
        return associatedClassNames;
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        return extractMillis(obj);
    }

    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            throw SqlExceptionUtil.create("Problems with field " + fieldType + " parsing default DateTime value: " + str, e);
        }
    }

    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return Long.valueOf(databaseResults.getLong(i));
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException {
        return createInstance((Long) obj);
    }

    public Class<?> getPrimaryClass() {
        try {
            return getDateTimeClass();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public Object moveToNextValue(Object obj) throws SQLException {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return createInstance(Long.valueOf(currentTimeMillis));
        }
        if (currentTimeMillis == extractMillis(obj).longValue()) {
            return createInstance(Long.valueOf(currentTimeMillis + 1));
        }
        return createInstance(Long.valueOf(currentTimeMillis));
    }

    private Object createInstance(Long l) throws SQLException {
        try {
            if (millisConstructor == null) {
                millisConstructor = getDateTimeClass().getConstructor(Long.TYPE);
            }
            return millisConstructor.newInstance(l);
        } catch (Exception e) {
            throw SqlExceptionUtil.create("Could not use reflection to construct a Joda DateTime", e);
        }
    }

    private Long extractMillis(Object obj) throws SQLException {
        try {
            if (getMillisMethod == null) {
                getMillisMethod = getDateTimeClass().getMethod("getMillis", new Class[0]);
            }
            if (obj == null) {
                return null;
            }
            return (Long) getMillisMethod.invoke(obj, new Object[0]);
        } catch (Exception e) {
            throw SqlExceptionUtil.create("Could not use reflection to get millis from Joda DateTime: ".concat(String.valueOf(obj)), e);
        }
    }

    private Class<?> getDateTimeClass() throws ClassNotFoundException {
        if (dateTimeClass == null) {
            dateTimeClass = Class.forName("org.joda.time.DateTime");
        }
        return dateTimeClass;
    }
}
