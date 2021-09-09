package io.realm.internal;

import _m_j.isb;
import _m_j.isc;
import _m_j.isi;
import io.realm.RealmFieldType;
import java.util.Date;

public class UncheckedRow implements isc, isi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final long f15354O000000o = nativeGetFinalizerPtr();
    private final isb O00000Oo;
    private final long O00000o;
    private final Table O00000o0;

    private static native long nativeGetFinalizerPtr();

    /* access modifiers changed from: protected */
    public native boolean nativeGetBoolean(long j, long j2);

    /* access modifiers changed from: protected */
    public native byte[] nativeGetByteArray(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnCount(long j);

    /* access modifiers changed from: protected */
    public native long nativeGetColumnIndex(long j, String str);

    /* access modifiers changed from: protected */
    public native String nativeGetColumnName(long j, long j2);

    /* access modifiers changed from: protected */
    public native int nativeGetColumnType(long j, long j2);

    /* access modifiers changed from: protected */
    public native double nativeGetDouble(long j, long j2);

    /* access modifiers changed from: protected */
    public native float nativeGetFloat(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetIndex(long j);

    /* access modifiers changed from: protected */
    public native long nativeGetLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j, long j2);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j, long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeHasColumn(long j, String str);

    /* access modifiers changed from: protected */
    public native boolean nativeIsAttached(long j);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNull(long j, long j2);

    /* access modifiers changed from: protected */
    public native boolean nativeIsNullLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeNullifyLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetBoolean(long j, long j2, boolean z);

    /* access modifiers changed from: protected */
    public native void nativeSetByteArray(long j, long j2, byte[] bArr);

    /* access modifiers changed from: protected */
    public native void nativeSetDouble(long j, long j2, double d);

    /* access modifiers changed from: protected */
    public native void nativeSetFloat(long j, long j2, float f);

    /* access modifiers changed from: protected */
    public native void nativeSetLink(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetLong(long j, long j2, long j3);

    /* access modifiers changed from: protected */
    public native void nativeSetNull(long j, long j2);

    /* access modifiers changed from: protected */
    public native void nativeSetString(long j, long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j, long j2, long j3);

    UncheckedRow(isb isb, Table table, long j) {
        this.O00000Oo = isb;
        this.O00000o0 = table;
        this.O00000o = j;
        isb.O000000o(this);
    }

    UncheckedRow(UncheckedRow uncheckedRow) {
        this.O00000Oo = uncheckedRow.O00000Oo;
        this.O00000o0 = uncheckedRow.O00000o0;
        this.O00000o = uncheckedRow.O00000o;
    }

    public long getNativePtr() {
        return this.O00000o;
    }

    public long getNativeFinalizerPtr() {
        return f15354O000000o;
    }

    static UncheckedRow O000000o(isb isb, Table table, long j) {
        return new UncheckedRow(isb, table, j);
    }

    public long getColumnCount() {
        return nativeGetColumnCount(this.O00000o);
    }

    public String getColumnName(long j) {
        return nativeGetColumnName(this.O00000o, j);
    }

    public long getColumnIndex(String str) {
        if (str != null) {
            return nativeGetColumnIndex(this.O00000o, str);
        }
        throw new IllegalArgumentException("Column name can not be null.");
    }

    public RealmFieldType getColumnType(long j) {
        return RealmFieldType.fromNativeValue(nativeGetColumnType(this.O00000o, j));
    }

    public Table getTable() {
        return this.O00000o0;
    }

    public long getIndex() {
        return nativeGetIndex(this.O00000o);
    }

    public long getLong(long j) {
        return nativeGetLong(this.O00000o, j);
    }

    public boolean getBoolean(long j) {
        return nativeGetBoolean(this.O00000o, j);
    }

    public float getFloat(long j) {
        return nativeGetFloat(this.O00000o, j);
    }

    public double getDouble(long j) {
        return nativeGetDouble(this.O00000o, j);
    }

    public Date getDate(long j) {
        return new Date(nativeGetTimestamp(this.O00000o, j));
    }

    public String getString(long j) {
        return nativeGetString(this.O00000o, j);
    }

    public byte[] getBinaryByteArray(long j) {
        return nativeGetByteArray(this.O00000o, j);
    }

    public boolean isNullLink(long j) {
        return nativeIsNullLink(this.O00000o, j);
    }

    public OsList getModelList(long j) {
        return new OsList(this, j);
    }

    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        return new OsList(this, j);
    }

    public boolean isNull(long j) {
        return nativeIsNull(this.O00000o, j);
    }

    public boolean isAttached() {
        long j = this.O00000o;
        return j != 0 && nativeIsAttached(j);
    }
}
