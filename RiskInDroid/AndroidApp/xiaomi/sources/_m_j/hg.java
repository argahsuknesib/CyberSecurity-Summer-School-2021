package _m_j;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

public final class hg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final o0OO00OO<RecyclerView.O000OOo0, O000000o> f18890O000000o = new o0OO00OO<>();
    public final o0O0o000<RecyclerView.O000OOo0> O00000Oo = new o0O0o000<>();

    public interface O00000Oo {
        void O000000o(RecyclerView.O000OOo0 o000OOo0);

        void O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2);

        void O00000Oo(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2);

        void O00000o0(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo, RecyclerView.O0000OOo.O00000Oo o00000Oo2);
    }

    public final void O000000o() {
        this.f18890O000000o.clear();
        this.O00000Oo.O00000o();
    }

    public final void O000000o(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo) {
        O000000o o000000o = this.f18890O000000o.get(o000OOo0);
        if (o000000o == null) {
            o000000o = O000000o.O000000o();
            this.f18890O000000o.put(o000OOo0, o000000o);
        }
        o000000o.O00000Oo = o00000Oo;
        o000000o.f18891O000000o |= 4;
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0) {
        O000000o o000000o = this.f18890O000000o.get(o000OOo0);
        return (o000000o == null || (o000000o.f18891O000000o & 1) == 0) ? false : true;
    }

    public final RecyclerView.O0000OOo.O00000Oo O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
        O000000o O00000o0;
        RecyclerView.O0000OOo.O00000Oo o00000Oo;
        int O000000o2 = this.f18890O000000o.O000000o(o000OOo0);
        if (O000000o2 < 0 || (O00000o0 = this.f18890O000000o.O00000o0(O000000o2)) == null || (O00000o0.f18891O000000o & i) == 0) {
            return null;
        }
        O00000o0.f18891O000000o &= i ^ -1;
        if (i == 4) {
            o00000Oo = O00000o0.O00000Oo;
        } else if (i == 8) {
            o00000Oo = O00000o0.O00000o0;
        } else {
            throw new IllegalArgumentException("Must provide flag PRE or POST");
        }
        if ((O00000o0.f18891O000000o & 12) == 0) {
            this.f18890O000000o.O00000o(O000000o2);
            O000000o.O000000o(O00000o0);
        }
        return o00000Oo;
    }

    public final void O000000o(long j, RecyclerView.O000OOo0 o000OOo0) {
        this.O00000Oo.O00000Oo(j, o000OOo0);
    }

    public final void O00000Oo(RecyclerView.O000OOo0 o000OOo0, RecyclerView.O0000OOo.O00000Oo o00000Oo) {
        O000000o o000000o = this.f18890O000000o.get(o000OOo0);
        if (o000000o == null) {
            o000000o = O000000o.O000000o();
            this.f18890O000000o.put(o000OOo0, o000000o);
        }
        o000000o.O00000o0 = o00000Oo;
        o000000o.f18891O000000o |= 8;
    }

    public final void O00000Oo(RecyclerView.O000OOo0 o000OOo0) {
        O000000o o000000o = this.f18890O000000o.get(o000OOo0);
        if (o000000o == null) {
            o000000o = O000000o.O000000o();
            this.f18890O000000o.put(o000OOo0, o000000o);
        }
        o000000o.f18891O000000o |= 1;
    }

    public final void O00000o0(RecyclerView.O000OOo0 o000OOo0) {
        O000000o o000000o = this.f18890O000000o.get(o000OOo0);
        if (o000000o != null) {
            o000000o.f18891O000000o &= -2;
        }
    }

    public final void O00000o(RecyclerView.O000OOo0 o000OOo0) {
        int O00000o0 = this.O00000Oo.O00000o0() - 1;
        while (true) {
            if (O00000o0 < 0) {
                break;
            } else if (o000OOo0 == this.O00000Oo.O00000o0(O00000o0)) {
                this.O00000Oo.O000000o(O00000o0);
                break;
            } else {
                O00000o0--;
            }
        }
        O000000o remove = this.f18890O000000o.remove(o000OOo0);
        if (remove != null) {
            O000000o.O000000o(remove);
        }
    }

    public static class O000000o {
        static Pools.O000000o<O000000o> O00000o = new Pools.SimplePool(20);

        /* renamed from: O000000o  reason: collision with root package name */
        public int f18891O000000o;
        public RecyclerView.O0000OOo.O00000Oo O00000Oo;
        public RecyclerView.O0000OOo.O00000Oo O00000o0;

        private O000000o() {
        }

        public static O000000o O000000o() {
            O000000o acquire = O00000o.acquire();
            return acquire == null ? new O000000o() : acquire;
        }

        public static void O000000o(O000000o o000000o) {
            o000000o.f18891O000000o = 0;
            o000000o.O00000Oo = null;
            o000000o.O00000o0 = null;
            O00000o.release(o000000o);
        }

        public static void O00000Oo() {
            do {
            } while (O00000o.acquire() != null);
        }
    }
}
