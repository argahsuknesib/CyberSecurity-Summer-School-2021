package io.realm.internal;

import _m_j.isb;
import _m_j.isc;
import _m_j.ise;
import io.realm.internal.ObservableCollection;
import io.realm.internal.OsObject;

public class OsList implements isc, ObservableCollection {
    private static final long O00000o = nativeGetFinalizerPtr();

    /* renamed from: O000000o  reason: collision with root package name */
    public final long f15343O000000o;
    private final isb O00000Oo;
    private final Table O00000o0;
    private final ise<ObservableCollection.O00000Oo> O00000oO = new ise<>();

    private static native void nativeAddBinary(long j, byte[] bArr);

    private static native void nativeAddBoolean(long j, boolean z);

    private static native void nativeAddDate(long j, long j2);

    private static native void nativeAddDouble(long j, double d);

    private static native void nativeAddFloat(long j, float f);

    private static native void nativeAddLong(long j, long j2);

    private static native void nativeAddNull(long j);

    private static native void nativeAddRow(long j, long j2);

    private static native void nativeAddString(long j, String str);

    private static native long[] nativeCreate(long j, long j2, long j3);

    private static native void nativeDelete(long j, long j2);

    private static native void nativeDeleteAll(long j);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetQuery(long j);

    private static native long nativeGetRow(long j, long j2);

    private static native Object nativeGetValue(long j, long j2);

    private static native void nativeInsertBinary(long j, long j2, byte[] bArr);

    private static native void nativeInsertBoolean(long j, long j2, boolean z);

    private static native void nativeInsertDate(long j, long j2, long j3);

    private static native void nativeInsertDouble(long j, long j2, double d);

    private static native void nativeInsertFloat(long j, long j2, float f);

    private static native void nativeInsertLong(long j, long j2, long j3);

    private static native void nativeInsertNull(long j, long j2);

    private static native void nativeInsertRow(long j, long j2, long j3);

    private static native void nativeInsertString(long j, long j2, String str);

    private static native boolean nativeIsValid(long j);

    private static native void nativeMove(long j, long j2, long j3);

    private static native void nativeRemove(long j, long j2);

    private static native void nativeRemoveAll(long j);

    private static native void nativeSetBinary(long j, long j2, byte[] bArr);

    private static native void nativeSetBoolean(long j, long j2, boolean z);

    private static native void nativeSetDate(long j, long j2, long j3);

    private static native void nativeSetDouble(long j, long j2, double d);

    private static native void nativeSetFloat(long j, long j2, float f);

    private static native void nativeSetLong(long j, long j2, long j3);

    private static native void nativeSetNull(long j, long j2);

    private static native void nativeSetRow(long j, long j2, long j3);

    private static native void nativeSetString(long j, long j2, String str);

    public static native long nativeSize(long j);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public OsList(UncheckedRow uncheckedRow, long j) {
        OsSharedRealm osSharedRealm = uncheckedRow.getTable().O00000Oo;
        long[] nativeCreate = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.getNativePtr(), j);
        this.f15343O000000o = nativeCreate[0];
        this.O00000Oo = osSharedRealm.context;
        this.O00000Oo.O000000o(this);
        if (nativeCreate[1] != 0) {
            this.O00000o0 = new Table(osSharedRealm, nativeCreate[1]);
        } else {
            this.O00000o0 = null;
        }
    }

    public long getNativePtr() {
        return this.f15343O000000o;
    }

    public long getNativeFinalizerPtr() {
        return O00000o;
    }

    public void notifyChangeListeners(long j) {
        OsCollectionChangeSet osCollectionChangeSet = new OsCollectionChangeSet(j);
        if (!osCollectionChangeSet.O0000O0o()) {
            this.O00000oO.O000000o((ise.O000000o<OsObject.O00000Oo>) new ObservableCollection.O000000o(osCollectionChangeSet));
        }
    }
}
