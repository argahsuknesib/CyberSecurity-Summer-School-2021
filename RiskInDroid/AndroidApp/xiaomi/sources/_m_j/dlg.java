package _m_j;

import java.util.List;

final class dlg implements dmh {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ List f14764O000000o;
    final /* synthetic */ boolean O00000Oo;
    final /* synthetic */ dkz O00000o0;

    dlg(dkz dkz, List list, boolean z) {
        this.O00000o0 = dkz;
        this.f14764O000000o = list;
        this.O00000Oo = z;
    }

    public final void O000000o() {
        dke.O00000Oo();
        dkz dkz = this.O00000o0;
        List list = this.f14764O000000o;
        boolean z = this.O00000Oo;
        if (dkz.f14757O000000o != null) {
            dkz.f14757O000000o.O000000o(new dlb(dkz, list, z, true));
        }
    }

    public final void O00000Oo() {
        dke.O00000o0();
        dkz dkz = this.O00000o0;
        List list = this.f14764O000000o;
        boolean z = this.O00000Oo;
        if (dkz.f14757O000000o != null) {
            dkz.f14757O000000o.O000000o(new dla(dkz, list, 1, z, true));
        }
    }
}
