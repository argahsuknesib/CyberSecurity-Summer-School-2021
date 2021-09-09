package io.realm.internal;

import _m_j.isc;

public class OsObjectSchemaInfo implements isc {
    private static final long O00000Oo = nativeGetFinalizerPtr();

    /* renamed from: O000000o  reason: collision with root package name */
    public long f15346O000000o;

    public static native void nativeAddProperties(long j, long[] jArr, long[] jArr2);

    private static native long nativeCreateRealmObjectSchema(String str);

    private static native String nativeGetClassName(long j);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetPrimaryKeyProperty(long j);

    private static native long nativeGetProperty(long j, String str);

    public long getNativePtr() {
        return this.f15346O000000o;
    }

    public long getNativeFinalizerPtr() {
        return O00000Oo;
    }
}
