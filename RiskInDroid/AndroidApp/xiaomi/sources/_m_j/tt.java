package _m_j;

import android.content.Context;
import android.os.Build;

public final class tt extends tp {
    public tt() {
        super(5120);
    }

    private byte[] O000000o(Context context, oh ohVar) {
        super.O000000o();
        this.f2507O000000o.O00000o(qx.O000000o(this.f2507O000000o, oh.O000000o(), this.f2507O000000o.O000000o(ql.O000000o(context)), this.f2507O000000o.O000000o(oh.O00000o0()), (byte) Build.VERSION.SDK_INT, this.f2507O000000o.O000000o(ol.O000000o()), this.f2507O000000o.O000000o(ohVar.O00000oo()), this.f2507O000000o.O000000o(qp.O000000o(ol.O000000o(context))), this.f2507O000000o.O000000o(qp.O000000o(ol.O00000o0(context))), pe.O000000o(ol.O00000oO(context)), this.f2507O000000o.O000000o(ol.O00000o()), this.f2507O000000o.O000000o(ol.O00000o0()), this.f2507O000000o.O000000o(oh.O00000o()), this.f2507O000000o.O000000o(oh.O00000oO())));
        try {
            return qi.O000000o(ql.O000000o(context), this.f2507O000000o.O00000o0());
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.pq.O000000o(_m_j.bwk, byte[]):int
     arg types: [_m_j.tr, byte[]]
     candidates:
      _m_j.pq.O000000o(_m_j.bwk, int[]):int
      _m_j.pq.O000000o(_m_j.bwk, byte[]):int */
    public final byte[] O000000o(Context context, oh ohVar, qg qgVar) {
        try {
            byte[] O000000o2 = qo.O000000o(qi.O000000o(ql.O000000o(context)));
            byte[] O000000o3 = O000000o(context, ohVar);
            int size = qgVar.O00000Oo.size();
            if (size <= 0 || O000000o2 == null) {
                return null;
            }
            O000000o();
            int O000000o4 = pq.O000000o((bwk) this.f2507O000000o, O000000o2);
            int[] iArr = new int[size];
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ub ubVar = qgVar.O00000Oo.get(i2);
                iArr[i2] = pv.O000000o(this.f2507O000000o, (byte) ubVar.f2524O000000o, pv.O000000o(this.f2507O000000o, ubVar.O00000Oo));
            }
            int O000000o5 = pq.O000000o(this.f2507O000000o, iArr);
            if (O000000o3 != null) {
                i = pq.O00000Oo(this.f2507O000000o, O000000o3);
            }
            this.f2507O000000o.O00000o(pq.O000000o(this.f2507O000000o, O000000o4, i, O000000o5));
            return pc.O000000o(this.f2507O000000o.O00000o0());
        } catch (Throwable unused) {
            return null;
        }
    }
}
