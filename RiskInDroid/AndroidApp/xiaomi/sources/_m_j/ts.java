package _m_j;

import android.content.Context;
import java.util.List;

public final class ts extends tp {
    public ts() {
        super(500);
    }

    public final byte[] O000000o(Context context, ud udVar, List<ug> list, byte b) {
        ud udVar2 = udVar;
        O000000o();
        try {
            int O000000o2 = pw.O000000o(this.f2507O000000o, udVar2.f2527O000000o, udVar2.O00000Oo, udVar2.O00000o0, udVar2.O00000o, udVar2.O00000oO, udVar2.O00000oo, udVar2.O0000O0o, udVar2.O0000OOo, udVar2.O0000Oo0, udVar2.O0000Oo);
            int size = list.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                ug ugVar = list.get(i);
                iArr[i] = px.O000000o(this.f2507O000000o, ugVar.f2530O000000o, ugVar.O00000Oo, ugVar.O00000o0, ugVar.O00000o, ugVar.O00000oO);
            }
            this.f2507O000000o.O00000o(pp.O000000o(this.f2507O000000o, O000000o2, pp.O000000o(this.f2507O000000o, iArr), b));
            return qi.O000000o(ql.O000000o(context), pc.O000000o(this.f2507O000000o.O00000o0()));
        } catch (Throwable unused) {
            return null;
        }
    }
}
