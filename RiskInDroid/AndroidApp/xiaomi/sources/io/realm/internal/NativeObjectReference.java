package io.realm.internal;

import _m_j.isb;
import _m_j.isc;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public final class NativeObjectReference extends PhantomReference<isc> {
    private static O000000o O00000oo = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public NativeObjectReference f15338O000000o;
    public NativeObjectReference O00000Oo;
    private final long O00000o;
    private final long O00000o0;
    private final isb O00000oO;

    private static native void nativeCleanUp(long j, long j2);

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        NativeObjectReference f15339O000000o;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void O000000o(NativeObjectReference nativeObjectReference) {
            nativeObjectReference.f15338O000000o = null;
            nativeObjectReference.O00000Oo = this.f15339O000000o;
            if (this.f15339O000000o != null) {
                this.f15339O000000o.f15338O000000o = nativeObjectReference;
            }
            this.f15339O000000o = nativeObjectReference;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void O00000Oo(NativeObjectReference nativeObjectReference) {
            NativeObjectReference nativeObjectReference2 = nativeObjectReference.O00000Oo;
            NativeObjectReference nativeObjectReference3 = nativeObjectReference.f15338O000000o;
            nativeObjectReference.O00000Oo = null;
            nativeObjectReference.f15338O000000o = null;
            if (nativeObjectReference3 != null) {
                nativeObjectReference3.O00000Oo = nativeObjectReference2;
            } else {
                this.f15339O000000o = nativeObjectReference2;
            }
            if (nativeObjectReference2 != null) {
                nativeObjectReference2.f15338O000000o = nativeObjectReference3;
            }
        }
    }

    public NativeObjectReference(isb isb, isc isc, ReferenceQueue<? super isc> referenceQueue) {
        super(isc, referenceQueue);
        this.O00000o0 = isc.getNativePtr();
        this.O00000o = isc.getNativeFinalizerPtr();
        this.O00000oO = isb;
        O00000oo.O000000o(this);
    }

    public final void O000000o() {
        synchronized (this.O00000oO) {
            nativeCleanUp(this.O00000o, this.O00000o0);
        }
        O00000oo.O00000Oo(this);
    }
}
