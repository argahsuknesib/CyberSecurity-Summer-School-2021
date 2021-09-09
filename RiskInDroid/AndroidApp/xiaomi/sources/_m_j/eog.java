package _m_j;

import _m_j.elr;
import _m_j.eoe;

final class eog extends elr.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    elr.O00000Oo f15673O000000o;
    final /* synthetic */ eoe O00000Oo;

    eog(eoe eoe) {
        this.O00000Oo = eoe;
    }

    public final void b() {
        eoe.O00000Oo o00000Oo = (eoe.O00000Oo) this.O00000Oo.f15669O000000o.peek();
        if (o00000Oo != null && o00000Oo.O000000o()) {
            if (this.O00000Oo.f15669O000000o.remove(o00000Oo)) {
                this.f15673O000000o = o00000Oo;
            }
            elr.O00000Oo o00000Oo2 = this.f15673O000000o;
            if (o00000Oo2 != null) {
                o00000Oo2.b();
            }
        }
    }

    public final void c() {
        elr.O00000Oo o00000Oo = this.f15673O000000o;
        if (o00000Oo != null) {
            o00000Oo.c();
        }
    }
}
