package _m_j;

import java.util.List;

final class dlb implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ List f14759O000000o;
    final /* synthetic */ boolean O00000Oo;
    final /* synthetic */ dkz O00000o;
    final /* synthetic */ boolean O00000o0 = true;

    dlb(dkz dkz, List list, boolean z, boolean z2) {
        this.O00000o = dkz;
        this.f14759O000000o = list;
        this.O00000Oo = z;
    }

    public final void run() {
        this.O00000o.O000000o(this.f14759O000000o, this.O00000Oo);
        if (this.O00000o0) {
            this.f14759O000000o.clear();
        }
    }
}
