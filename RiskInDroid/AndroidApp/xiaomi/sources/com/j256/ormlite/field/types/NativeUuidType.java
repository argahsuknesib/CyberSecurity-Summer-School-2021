package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class NativeUuidType extends UuidType {
    private static final NativeUuidType singleTon = new NativeUuidType();

    public static NativeUuidType getSingleton() {
        return singleTon;
    }

    private NativeUuidType() {
        super(SqlType.UUID);
    }

    protected NativeUuidType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }
}
