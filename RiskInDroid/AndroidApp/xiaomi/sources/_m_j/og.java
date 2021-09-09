package _m_j;

import android.content.Context;

public class og {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile og f2341O000000o;
    private qm O00000Oo;

    private og() {
    }

    public static og O000000o() {
        if (f2341O000000o == null) {
            synchronized (og.class) {
                if (f2341O000000o == null) {
                    f2341O000000o = new og();
                }
            }
        }
        return f2341O000000o;
    }

    public final synchronized void O000000o(Context context, of ofVar) {
        if (this.O00000Oo == null) {
            this.O00000Oo = qm.O000000o();
            sm smVar = new sm();
            smVar.O00000Oo = ok.O000000o();
            smVar.O00000o0 = ok.O00000Oo();
            smVar.O00000oO = ok.O00000o0();
            smVar.O00000o = ok.O00000o();
            smVar.O000000o(ofVar.f2340O000000o);
            smVar.O00000Oo(ol.O00000Oo());
            smVar.O0000O0o = ofVar.O00000Oo;
            this.O00000Oo.O000000o(context, smVar);
        }
        ol.O000000o(context, ofVar.f2340O000000o);
    }

    public final synchronized void O00000Oo() {
        if (this.O00000Oo != null) {
            this.O00000Oo.O00000Oo();
        }
    }
}
