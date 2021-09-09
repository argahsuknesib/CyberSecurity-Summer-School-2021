package io.realm.internal;

import _m_j.isb;
import _m_j.isc;
import java.util.Collection;

public class OsSchemaInfo implements isc {
    private static final long O00000Oo = nativeGetFinalizerPtr();

    /* renamed from: O000000o  reason: collision with root package name */
    private long f15350O000000o;
    private final OsSharedRealm O00000o0;

    private static native long nativeCreateFromList(long[] jArr);

    private static native long nativeGetFinalizerPtr();

    private static native long nativeGetObjectSchemaInfo(long j, String str);

    public OsSchemaInfo(Collection<OsObjectSchemaInfo> collection) {
        this.f15350O000000o = nativeCreateFromList(O000000o(collection));
        isb.f1598O000000o.O000000o(this);
        this.O00000o0 = null;
    }

    OsSchemaInfo(long j, OsSharedRealm osSharedRealm) {
        this.f15350O000000o = j;
        this.O00000o0 = osSharedRealm;
    }

    private static long[] O000000o(Collection<OsObjectSchemaInfo> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (OsObjectSchemaInfo nativePtr : collection) {
            jArr[i] = nativePtr.getNativePtr();
            i++;
        }
        return jArr;
    }

    public long getNativePtr() {
        return this.f15350O000000o;
    }

    public long getNativeFinalizerPtr() {
        return O00000Oo;
    }
}
