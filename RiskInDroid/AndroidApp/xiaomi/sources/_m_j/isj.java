package _m_j;

import io.realm.OrderedCollectionChangeSet;
import io.realm.internal.OsCollectionChangeSet;

public final class isj implements OrderedCollectionChangeSet {

    /* renamed from: O000000o  reason: collision with root package name */
    private final OrderedCollectionChangeSet f1603O000000o;
    private final Throwable O00000Oo;
    private final boolean O00000o;
    private final OrderedCollectionChangeSet.State O00000o0;

    public isj(OsCollectionChangeSet osCollectionChangeSet) {
        OrderedCollectionChangeSet.State state;
        this.f1603O000000o = osCollectionChangeSet;
        boolean O00000oo = osCollectionChangeSet.O00000oo();
        this.O00000o = osCollectionChangeSet.O00000oO();
        this.O00000Oo = osCollectionChangeSet.O00000o();
        if (this.O00000Oo != null) {
            state = OrderedCollectionChangeSet.State.ERROR;
        } else {
            state = O00000oo ? OrderedCollectionChangeSet.State.INITIAL : OrderedCollectionChangeSet.State.UPDATE;
        }
        this.O00000o0 = state;
    }
}
