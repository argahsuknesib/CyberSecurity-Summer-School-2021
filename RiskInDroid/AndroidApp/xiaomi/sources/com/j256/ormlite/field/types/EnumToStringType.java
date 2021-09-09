package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class EnumToStringType extends EnumStringType {
    private static final EnumToStringType singleTon = new EnumToStringType();

    public static EnumToStringType getSingleton() {
        return singleTon;
    }

    private EnumToStringType() {
        super(SqlType.STRING, new Class[]{Enum.class});
    }

    protected EnumToStringType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    /* access modifiers changed from: protected */
    public String getEnumName(Enum<?> enumR) {
        return enumR.toString();
    }
}
