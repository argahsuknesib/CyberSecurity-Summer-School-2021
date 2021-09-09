package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BaseDateType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;

public class SqlDateType extends DateType {
    private static final SqlDateType singleTon = new SqlDateType();
    private static final BaseDateType.DateStringFormatConfig sqlDateFormatConfig = new BaseDateType.DateStringFormatConfig("yyyy-MM-dd");

    public static SqlDateType getSingleton() {
        return singleTon;
    }

    private SqlDateType() {
        super(SqlType.DATE, new Class[]{Date.class});
    }

    protected SqlDateType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Object sqlArgToJava(FieldType fieldType, Object obj, int i) {
        return new Date(((Timestamp) obj).getTime());
    }

    public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Timestamp(((Date) obj).getTime());
    }

    /* access modifiers changed from: protected */
    public BaseDateType.DateStringFormatConfig getDefaultDateFormatConfig() {
        return sqlDateFormatConfig;
    }

    public boolean isValidForField(Field field) {
        return field.getType() == Date.class;
    }
}
