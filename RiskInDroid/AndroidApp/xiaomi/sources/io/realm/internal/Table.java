package io.realm.internal;

import _m_j.isb;
import _m_j.isc;
import io.realm.RealmFieldType;

public class Table implements isc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final int f15353O000000o = (63 - O00000o0.length());
    private static final long O00000o = nativeGetFinalizerPtr();
    private static final String O00000o0 = Util.O000000o();
    final OsSharedRealm O00000Oo;
    private final long O00000oO;
    private final isb O00000oo;

    private native long nativeAddColumn(long j, int i, String str, boolean z);

    private native long nativeAddColumnLink(long j, int i, String str, long j2);

    private native long nativeAddPrimitiveListColumn(long j, int i, String str, boolean z);

    private native void nativeAddSearchIndex(long j, long j2);

    private native void nativeClear(long j, boolean z);

    private native void nativeConvertColumnToNotNullable(long j, long j2, boolean z);

    private native void nativeConvertColumnToNullable(long j, long j2, boolean z);

    private native long nativeCountDouble(long j, long j2, double d);

    private native long nativeCountFloat(long j, long j2, float f);

    private native long nativeCountLong(long j, long j2, long j3);

    private native long nativeCountString(long j, long j2, String str);

    private native long nativeFindFirstBool(long j, long j2, boolean z);

    private native long nativeFindFirstDouble(long j, long j2, double d);

    private native long nativeFindFirstFloat(long j, long j2, float f);

    public static native long nativeFindFirstInt(long j, long j2, long j3);

    public static native long nativeFindFirstNull(long j, long j2);

    public static native long nativeFindFirstString(long j, long j2, String str);

    private native long nativeFindFirstTimestamp(long j, long j2, long j3);

    private native boolean nativeGetBoolean(long j, long j2, long j3);

    private native byte[] nativeGetByteArray(long j, long j2, long j3);

    private native long nativeGetColumnCount(long j);

    private native long nativeGetColumnIndex(long j, String str);

    private native String nativeGetColumnName(long j, long j2);

    private native int nativeGetColumnType(long j, long j2);

    private native double nativeGetDouble(long j, long j2, long j3);

    private static native long nativeGetFinalizerPtr();

    private native float nativeGetFloat(long j, long j2, long j3);

    private native long nativeGetLink(long j, long j2, long j3);

    private native long nativeGetLinkTarget(long j, long j2);

    private native long nativeGetLong(long j, long j2, long j3);

    private native String nativeGetName(long j);

    private native String nativeGetString(long j, long j2, long j3);

    private native long nativeGetTimestamp(long j, long j2, long j3);

    private native boolean nativeHasSameSchema(long j, long j2);

    private native boolean nativeHasSearchIndex(long j, long j2);

    public static native void nativeIncrementLong(long j, long j2, long j3, long j4);

    private static native void nativeInsertColumn(long j, long j2, int i, String str);

    private native boolean nativeIsColumnNullable(long j, long j2);

    private native boolean nativeIsNull(long j, long j2, long j3);

    private native boolean nativeIsNullLink(long j, long j2, long j3);

    private native boolean nativeIsValid(long j);

    private static native void nativeMigratePrimaryKeyTableIfNeeded(long j);

    private native void nativeMoveLastOver(long j, long j2);

    public static native void nativeNullifyLink(long j, long j2, long j3);

    private native void nativeRemoveColumn(long j, long j2);

    private native void nativeRemoveSearchIndex(long j, long j2);

    private native void nativeRenameColumn(long j, long j2, String str);

    public static native void nativeSetBoolean(long j, long j2, long j3, boolean z, boolean z2);

    public static native void nativeSetByteArray(long j, long j2, long j3, byte[] bArr, boolean z);

    public static native void nativeSetDouble(long j, long j2, long j3, double d, boolean z);

    public static native void nativeSetFloat(long j, long j2, long j3, float f, boolean z);

    public static native void nativeSetLink(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetLong(long j, long j2, long j3, long j4, boolean z);

    public static native void nativeSetNull(long j, long j2, long j3, boolean z);

    public static native void nativeSetString(long j, long j2, long j3, String str, boolean z);

    public static native void nativeSetTimestamp(long j, long j2, long j3, long j4, boolean z);

    private native long nativeSize(long j);

    private native long nativeWhere(long j);

    /* access modifiers changed from: package-private */
    public native long nativeGetRowPtr(long j, long j2);

    Table(OsSharedRealm osSharedRealm, long j) {
        this.O00000oo = osSharedRealm.context;
        this.O00000Oo = osSharedRealm;
        this.O00000oO = j;
        this.O00000oo.O000000o(this);
    }

    public long getNativePtr() {
        return this.O00000oO;
    }

    public long getNativeFinalizerPtr() {
        return O00000o;
    }

    public final String O000000o(long j) {
        return nativeGetColumnName(this.O00000oO, j);
    }

    public final long O000000o(String str) {
        if (str != null) {
            return nativeGetColumnIndex(this.O00000oO, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public final RealmFieldType O00000Oo(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.O00000oO, j));
    }

    public final Table O00000o0(long j) {
        return new Table(this.O00000Oo, nativeGetLinkTarget(this.O00000oO, j));
    }

    public final UncheckedRow O00000o(long j) {
        return UncheckedRow.O000000o(this.O00000oo, this, j);
    }

    public static void O000000o(OsSharedRealm osSharedRealm) {
        nativeMigratePrimaryKeyTableIfNeeded(osSharedRealm.getNativePtr());
    }

    public final String O000000o() {
        return nativeGetName(this.O00000oO);
    }

    public static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        if (!str.startsWith(O00000o0)) {
            return str;
        }
        return str.substring(O00000o0.length());
    }

    public static String O00000o0(String str) {
        if (str == null) {
            return null;
        }
        return O00000o0 + str;
    }

    public String toString() {
        long nativeGetColumnCount = nativeGetColumnCount(this.O00000oO);
        String O000000o2 = O000000o();
        StringBuilder sb = new StringBuilder("The Table ");
        if (O000000o2 != null && !O000000o2.isEmpty()) {
            sb.append(O000000o());
            sb.append(" ");
        }
        sb.append("contains ");
        sb.append(nativeGetColumnCount);
        sb.append(" columns: ");
        int i = 0;
        while (true) {
            long j = (long) i;
            if (j < nativeGetColumnCount) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(O000000o(j));
                i++;
            } else {
                sb.append(".");
                sb.append(" And ");
                sb.append(nativeSize(this.O00000oO));
                sb.append(" rows.");
                return sb.toString();
            }
        }
    }
}
