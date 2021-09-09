package io.realm.internal;

import _m_j.irr;
import _m_j.irt;
import _m_j.isc;
import _m_j.ise;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmException;

@Keep
public class OsObject implements isc {
    private static final String OBJECT_ID_COLUMN_NAME = nativeGetObjectIdColumName();
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final long nativePtr;
    private ise<O00000Oo> observerPairs = new ise<>();

    private static native long nativeCreate(long j, long j2);

    private static native long nativeCreateNewObject(long j, long j2);

    private static native long nativeCreateNewObjectWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateNewObjectWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeCreateRow(long j, long j2);

    private static native long nativeCreateRowWithLongPrimaryKey(long j, long j2, long j3, long j4, boolean z);

    private static native long nativeCreateRowWithStringPrimaryKey(long j, long j2, long j3, String str);

    private static native long nativeGetFinalizerPtr();

    private static native String nativeGetObjectIdColumName();

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final String[] f15345O000000o;
        final boolean O00000Oo;

        O00000o0(String[] strArr, boolean z) {
            this.f15345O000000o = strArr;
            this.O00000Oo = z;
        }
    }

    public static class O00000Oo<T extends irr> extends ise.O00000Oo<T, irt<T>> {
        public O00000Oo(T t, irt<T> irt) {
            super(t, irt);
        }
    }

    static class O000000o implements ise.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final String[] f15344O000000o;

        O000000o(String[] strArr) {
            this.f15344O000000o = strArr;
        }

        public final /* synthetic */ void O000000o(ise.O00000Oo o00000Oo, Object obj) {
            boolean z = this.f15344O000000o == null;
            new O00000o0(z ? new String[0] : this.f15344O000000o, z);
        }
    }

    public OsObject(OsSharedRealm osSharedRealm, UncheckedRow uncheckedRow) {
        this.nativePtr = nativeCreate(osSharedRealm.getNativePtr(), uncheckedRow.getNativePtr());
        osSharedRealm.context.O000000o(this);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public <T extends irr> void addListener(T t, irt<T> irt) {
        if (this.observerPairs.O000000o()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.O000000o(new O00000Oo(t, irt));
    }

    public <T extends irr> void removeListener(T t) {
        this.observerPairs.O000000o((Object) t);
        if (this.observerPairs.O000000o()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T extends irr> void removeListener(T t, irt<T> irt) {
        this.observerPairs.O000000o(t, irt);
        if (this.observerPairs.O000000o()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public void setObserverPairs(ise<O00000Oo> ise) {
        if (this.observerPairs.O000000o()) {
            this.observerPairs = ise;
            if (!ise.O000000o()) {
                nativeStartListening(this.nativePtr);
                return;
            }
            return;
        }
        throw new IllegalStateException("'observerPairs' is not empty. Listeners have been added before.");
    }

    public static UncheckedRow createWithPrimaryKey(Table table, Object obj) {
        long j;
        long andVerifyPrimaryKeyColumnIndex = getAndVerifyPrimaryKeyColumnIndex(table);
        RealmFieldType O00000Oo2 = table.O00000Oo(andVerifyPrimaryKeyColumnIndex);
        OsSharedRealm osSharedRealm = table.O00000Oo;
        if (O00000Oo2 == RealmFieldType.STRING) {
            if (obj == null || (obj instanceof String)) {
                return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithStringPrimaryKey(osSharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, (String) obj));
            }
            throw new IllegalArgumentException("Primary key value is not a String: ".concat(String.valueOf(obj)));
        } else if (O00000Oo2 == RealmFieldType.INTEGER) {
            if (obj == null) {
                j = 0;
            } else {
                j = Long.parseLong(obj.toString());
            }
            return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObjectWithLongPrimaryKey(osSharedRealm.getNativePtr(), table.getNativePtr(), andVerifyPrimaryKeyColumnIndex, j, obj == null));
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: ".concat(String.valueOf(O00000Oo2)));
        }
    }

    public static long createRowWithPrimaryKey(Table table, long j, Object obj) {
        long j2;
        Object obj2 = obj;
        RealmFieldType O00000Oo2 = table.O00000Oo(j);
        OsSharedRealm osSharedRealm = table.O00000Oo;
        if (O00000Oo2 == RealmFieldType.STRING) {
            if (obj2 == null || (obj2 instanceof String)) {
                return nativeCreateRowWithStringPrimaryKey(osSharedRealm.getNativePtr(), table.getNativePtr(), j, (String) obj2);
            }
            throw new IllegalArgumentException("Primary key value is not a String: ".concat(String.valueOf(obj)));
        } else if (O00000Oo2 == RealmFieldType.INTEGER) {
            if (obj2 == null) {
                j2 = 0;
            } else {
                j2 = Long.parseLong(obj.toString());
            }
            return nativeCreateRowWithLongPrimaryKey(osSharedRealm.getNativePtr(), table.getNativePtr(), j, j2, obj2 == null);
        } else {
            throw new RealmException("Cannot check for duplicate rows for unsupported primary key type: ".concat(String.valueOf(O00000Oo2)));
        }
    }

    public static boolean isObjectIdColumn(String str) {
        return OBJECT_ID_COLUMN_NAME.equals(str);
    }

    private void notifyChangeListeners(String[] strArr) {
        this.observerPairs.O000000o((ise.O000000o<O00000Oo>) new O000000o(strArr));
    }

    public static UncheckedRow create(Table table) {
        OsSharedRealm osSharedRealm = table.O00000Oo;
        return new UncheckedRow(osSharedRealm.context, table, nativeCreateNewObject(osSharedRealm.getNativePtr(), table.getNativePtr()));
    }

    public static long createRow(Table table) {
        return nativeCreateRow(table.O00000Oo.getNativePtr(), table.getNativePtr());
    }

    private static long getAndVerifyPrimaryKeyColumnIndex(Table table) {
        String O000000o2 = OsObjectStore.O000000o(table.O00000Oo, Table.O00000Oo(table.O000000o()));
        if (O000000o2 != null) {
            return table.O000000o(O000000o2);
        }
        throw new IllegalStateException(table.O000000o() + " has no primary key defined.");
    }
}
