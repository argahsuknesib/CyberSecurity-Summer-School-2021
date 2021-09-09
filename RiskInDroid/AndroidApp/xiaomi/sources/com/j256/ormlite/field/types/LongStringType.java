package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class LongStringType extends StringType {
    private static final LongStringType singleTon = new LongStringType();

    public int getDefaultWidth() {
        return 0;
    }

    public boolean isAppropriateId() {
        return false;
    }

    public static LongStringType getSingleton() {
        return singleTon;
    }

    private LongStringType() {
        super(SqlType.LONG_STRING);
    }

    protected LongStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public Class<?> getPrimaryClass() {
        return String.class;
    }
}
