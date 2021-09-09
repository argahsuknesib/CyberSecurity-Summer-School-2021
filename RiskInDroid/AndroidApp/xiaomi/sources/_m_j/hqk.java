package _m_j;

import _m_j.hof;
import _m_j.hqs;
import android.content.Intent;
import android.text.TextUtils;

public final class hqk extends hqe implements hql<hqs.O0000Oo0, hof.O0000O0o.O00000Oo> {

    /* renamed from: O000000o  reason: collision with root package name */
    hpx f524O000000o;

    public final void O000000o(Intent intent) {
    }

    public hqk(int i, int i2, int i3, int i4, hpx hpx) {
        super(i, i2, i3, i4);
        this.f524O000000o = hpx;
    }

    public final int p_() {
        return this.O00000oO == 4 ? -1 : 3;
    }

    public final /* synthetic */ Object o_() {
        hqs.O0000Oo0 o0000Oo0 = new hqs.O0000Oo0();
        o0000Oo0.f538O000000o = this.O00000Oo;
        o0000Oo0.O00000Oo = "cloud";
        o0000Oo0.O00000o0 = this.f524O000000o.O00000Oo();
        o0000Oo0.O00000oo = this.f524O000000o.O00000oO;
        if (TextUtils.isEmpty(this.f524O000000o.O00000o)) {
            return null;
        }
        o0000Oo0.O0000O0o = new hqs.O00000Oo(this.f524O000000o.O00000o);
        o0000Oo0.O00000oO = 5;
        return o0000Oo0;
    }
}
