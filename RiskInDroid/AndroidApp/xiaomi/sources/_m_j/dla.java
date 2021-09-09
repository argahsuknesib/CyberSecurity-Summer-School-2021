package _m_j;

import java.util.List;

final class dla implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ List f14758O000000o;
    final /* synthetic */ int O00000Oo = 1;
    final /* synthetic */ boolean O00000o;
    final /* synthetic */ boolean O00000o0;
    final /* synthetic */ dkz O00000oO;

    dla(dkz dkz, List list, int i, boolean z, boolean z2) {
        this.O00000oO = dkz;
        this.f14758O000000o = list;
        this.O00000o0 = z;
        this.O00000o = true;
    }

    public final void run() {
        this.O00000oO.O000000o(this.f14758O000000o, this.O00000Oo, this.O00000o0);
        if (this.O00000o) {
            this.f14758O000000o.clear();
        }
    }
}
