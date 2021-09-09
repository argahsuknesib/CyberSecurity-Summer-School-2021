package io.realm.internal;

import _m_j.irp;

public class OsObjectStore {
    private static native boolean nativeCallWithLock(String str, Runnable runnable);

    private static native boolean nativeDeleteTableForObject(long j, String str);

    private static native String nativeGetPrimaryKeyForObject(long j, String str);

    private static native long nativeGetSchemaVersion(long j);

    private static native void nativeSetPrimaryKeyForObject(long j, String str, String str2);

    private static native void nativeSetSchemaVersion(long j, long j2);

    public static String O000000o(OsSharedRealm osSharedRealm, String str) {
        return nativeGetPrimaryKeyForObject(osSharedRealm.getNativePtr(), str);
    }

    public static void O000000o(OsSharedRealm osSharedRealm) {
        nativeSetSchemaVersion(osSharedRealm.getNativePtr(), -1);
    }

    public static long O00000Oo(OsSharedRealm osSharedRealm) {
        return nativeGetSchemaVersion(osSharedRealm.getNativePtr());
    }

    public static boolean O000000o(irp irp, Runnable runnable) {
        return nativeCallWithLock(irp.O00000oO, runnable);
    }
}
