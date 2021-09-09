package io.realm.internal;

import _m_j.irk;
import _m_j.iro;
import _m_j.ise;
import _m_j.isj;

@Keep
interface ObservableCollection {
    void notifyChangeListeners(long j);

    public static class O00000Oo<T> extends ise.O00000Oo<T, Object> {
        public final void O000000o(OsCollectionChangeSet osCollectionChangeSet) {
            if (this.O00000Oo instanceof irk) {
                new isj(osCollectionChangeSet);
            } else if (!(this.O00000Oo instanceof iro)) {
                throw new RuntimeException("Unsupported listener type: " + this.O00000Oo);
            }
        }
    }

    public static class O00000o0<T> implements irk<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final iro<T> f15341O000000o;

        O00000o0(iro<T> iro) {
            this.f15341O000000o = iro;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof O00000o0) && this.f15341O000000o == ((O00000o0) obj).f15341O000000o;
        }

        public final int hashCode() {
            return this.f15341O000000o.hashCode();
        }
    }

    public static class O000000o implements ise.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final OsCollectionChangeSet f15340O000000o;

        public final /* bridge */ /* synthetic */ void O000000o(ise.O00000Oo o00000Oo, Object obj) {
            ((O00000Oo) o00000Oo).O000000o(this.f15340O000000o);
        }

        O000000o(OsCollectionChangeSet osCollectionChangeSet) {
            this.f15340O000000o = osCollectionChangeSet;
        }
    }
}
