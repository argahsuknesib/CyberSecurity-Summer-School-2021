package com.google.android.gms.internal.clearcut;

public enum zzfq {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzbb.zzfi),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzlj;

    private zzfq(Object obj) {
        this.zzlj = obj;
    }
}
