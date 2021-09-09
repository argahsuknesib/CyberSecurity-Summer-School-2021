package com.loc;

import _m_j.btx;
import _m_j.bua;
import _m_j.bwt;
import _m_j.bww;
import _m_j.oh;
import _m_j.oi;
import android.content.Context;
import android.os.Build;

public final class ch {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f4520O000000o = null;
    public oi O00000Oo;

    public ch(Context context) {
        this.f4520O000000o = context.getApplicationContext();
    }

    public final oh O000000o(btx btx) {
        String O0000O0o;
        oh ohVar = new oh();
        oh.O00000Oo();
        if (btx != null) {
            try {
                oh.O000000o(btx.f13278O000000o);
                oh.O00000Oo(btx.O00000Oo);
                oh.O00000o0(btx.O00000o0);
                O0000O0o = btx.O00000oo;
            } catch (Throwable th) {
                bua.O000000o(th, "", "");
            }
        } else {
            oh.O000000o("");
            oh.O00000Oo("S128DF1572465B890OE3F7A13167KLEI");
            oh.O00000o0(bwt.O00000oo(this.f4520O000000o));
            O0000O0o = bww.O0000O0o(this.f4520O000000o);
        }
        ohVar.O00000o(O0000O0o);
        ohVar.O0000OOo().O000000o(true);
        ohVar.O0000OOo().O00000Oo();
        ohVar.O0000Oo0().O000000o(false);
        ohVar.O0000Oo().O000000o();
        ohVar.O0000Oo().O000000o(false);
        ohVar.O0000Oo().O00000o();
        ohVar.O0000Oo().O00000o0();
        ohVar.O0000Oo().O00000Oo();
        if (Build.VERSION.SDK_INT >= 28) {
            ohVar.O0000OOo().O000000o();
        }
        ohVar.O0000O0o();
        return ohVar;
    }
}
