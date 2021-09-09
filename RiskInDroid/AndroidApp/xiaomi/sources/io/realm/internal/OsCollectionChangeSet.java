package io.realm.internal;

import _m_j.isb;
import _m_j.isc;
import io.realm.OrderedCollectionChangeSet;
import io.realm.internal.sync.OsSubscription;
import java.util.Arrays;

public class OsCollectionChangeSet implements isc, OrderedCollectionChangeSet {
    private static long O00000o0 = nativeGetFinalizerPtr();

    /* renamed from: O000000o  reason: collision with root package name */
    protected final OsSubscription f15342O000000o;
    protected final boolean O00000Oo;
    private final long O00000o;
    private final boolean O00000oO;

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetIndices(long j, int i);

    private static native int[] nativeGetRanges(long j, int i);

    public OsCollectionChangeSet(long j) {
        this(j, false, null, false);
    }

    public OsCollectionChangeSet(long j, boolean z, OsSubscription osSubscription, boolean z2) {
        this.O00000o = j;
        this.O00000oO = z;
        this.f15342O000000o = null;
        this.O00000Oo = z2;
        isb.f1598O000000o.O000000o(this);
    }

    public OrderedCollectionChangeSet.O000000o[] O000000o() {
        return O000000o(nativeGetRanges(this.O00000o, 0));
    }

    public OrderedCollectionChangeSet.O000000o[] O00000Oo() {
        return O000000o(nativeGetRanges(this.O00000o, 1));
    }

    public OrderedCollectionChangeSet.O000000o[] O00000o0() {
        return O000000o(nativeGetRanges(this.O00000o, 2));
    }

    public Throwable O00000o() {
        OsSubscription osSubscription = this.f15342O000000o;
        if (osSubscription == null || osSubscription.O000000o() != OsSubscription.SubscriptionState.ERROR) {
            return null;
        }
        return this.f15342O000000o.O00000Oo();
    }

    public boolean O00000oO() {
        if (!this.O00000Oo) {
            return true;
        }
        OsSubscription osSubscription = this.f15342O000000o;
        if (osSubscription != null && osSubscription.O000000o() == OsSubscription.SubscriptionState.COMPLETE) {
            return true;
        }
        return false;
    }

    public boolean O00000oo() {
        return this.O00000oO;
    }

    public boolean O0000O0o() {
        return this.O00000o == 0;
    }

    private static OrderedCollectionChangeSet.O000000o[] O000000o(int[] iArr) {
        if (iArr == null) {
            return new OrderedCollectionChangeSet.O000000o[0];
        }
        OrderedCollectionChangeSet.O000000o[] o000000oArr = new OrderedCollectionChangeSet.O000000o[(iArr.length / 2)];
        for (int i = 0; i < o000000oArr.length; i++) {
            int i2 = i * 2;
            o000000oArr[i] = new OrderedCollectionChangeSet.O000000o(iArr[i2], iArr[i2 + 1]);
        }
        return o000000oArr;
    }

    public String toString() {
        if (this.O00000o == 0) {
            return "Change set is empty.";
        }
        return "Deletion Ranges: " + Arrays.toString(O000000o()) + "\nInsertion Ranges: " + Arrays.toString(O00000Oo()) + "\nChange Ranges: " + Arrays.toString(O00000o0());
    }

    public long getNativePtr() {
        return this.O00000o;
    }

    public long getNativeFinalizerPtr() {
        return O00000o0;
    }
}
