package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Locale;

public class CheckedRow extends UncheckedRow {

    /* renamed from: O000000o  reason: collision with root package name */
    private UncheckedRow f15337O000000o;

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
    public native long nativeGetLink(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetLong(long j, long j2);

    /* access modifiers changed from: protected */
    public native String nativeGetString(long j, long j2);

    /* access modifiers changed from: protected */
    public native long nativeGetTimestamp(long j, long j2);

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
    public native void nativeSetString(long j, long j2, String str);

    /* access modifiers changed from: protected */
    public native void nativeSetTimestamp(long j, long j2, long j3);

    private CheckedRow(UncheckedRow uncheckedRow) {
        super(uncheckedRow);
        this.f15337O000000o = uncheckedRow;
    }

    public static CheckedRow O000000o(UncheckedRow uncheckedRow) {
        return new CheckedRow(uncheckedRow);
    }

    public boolean isNullLink(long j) {
        RealmFieldType columnType = getColumnType(j);
        if (columnType == RealmFieldType.OBJECT || columnType == RealmFieldType.LIST) {
            return super.isNullLink(j);
        }
        return false;
    }

    public boolean isNull(long j) {
        return super.isNull(j);
    }

    public OsList getModelList(long j) {
        if (getTable().O00000Oo(j) == RealmFieldType.LIST) {
            return super.getModelList(j);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Field '%s' is not a 'RealmList'.", getTable().O000000o(j)));
    }

    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        if (realmFieldType == getTable().O00000Oo(j)) {
            return super.getValueList(j, realmFieldType);
        }
        throw new IllegalArgumentException(String.format(Locale.US, "The type of field '%1$s' is not 'RealmFieldType.%2$s'.", getTable().O000000o(j), realmFieldType.name()));
    }
}
