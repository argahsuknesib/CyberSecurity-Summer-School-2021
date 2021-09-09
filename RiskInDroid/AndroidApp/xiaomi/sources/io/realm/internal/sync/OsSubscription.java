package io.realm.internal.sync;

import _m_j.isc;

public class OsSubscription implements isc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final long f15356O000000o = nativeGetFinalizerPtr();
    private final long O00000Oo;

    private static native long nativeCreate(long j, String str);

    private static native Object nativeGetError(long j);

    private static native long nativeGetFinalizerPtr();

    private static native int nativeGetState(long j);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    public enum SubscriptionState {
        ERROR(-1),
        CREATING(2),
        PENDING(0),
        COMPLETE(1),
        INVALIDATED(3);
        
        private final int val;

        private SubscriptionState(int i) {
            this.val = i;
        }

        public static SubscriptionState fromInternalValue(int i) {
            for (SubscriptionState subscriptionState : values()) {
                if (subscriptionState.val == i) {
                    return subscriptionState;
                }
            }
            throw new IllegalArgumentException("Unknown value: ".concat(String.valueOf(i)));
        }
    }

    public long getNativePtr() {
        return this.O00000Oo;
    }

    public long getNativeFinalizerPtr() {
        return f15356O000000o;
    }

    public final SubscriptionState O000000o() {
        return SubscriptionState.fromInternalValue(nativeGetState(this.O00000Oo));
    }

    public final Throwable O00000Oo() {
        return (Throwable) nativeGetError(this.O00000Oo);
    }
}
