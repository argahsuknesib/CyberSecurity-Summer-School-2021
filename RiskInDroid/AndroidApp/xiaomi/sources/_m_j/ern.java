package _m_j;

import _m_j.eov;
import _m_j.erm;
import com.xiaomi.push.service.bo;

final class ern extends bo.a {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ erm f15750O000000o;

    ern(erm erm) {
        this.f15750O000000o = erm;
    }

    public final void a(eov.O00000Oo o00000Oo) {
        if (o00000Oo.O00000oO) {
            erm erm = erm.O000000o.f15749O000000o;
            int i = o00000Oo.O00000oo;
            if (i > 0) {
                int i2 = i * 1000;
                if (i2 > 604800000) {
                    i2 = 604800000;
                }
                if (erm.O00000Oo != i2 || !erm.f15748O000000o) {
                    erm.f15748O000000o = true;
                    erm.O00000o0 = System.currentTimeMillis();
                    erm.O00000Oo = i2;
                    duv.O00000o0("enable dot duration = " + i2 + " start = " + erm.O00000o0);
                }
            }
        }
    }
}
