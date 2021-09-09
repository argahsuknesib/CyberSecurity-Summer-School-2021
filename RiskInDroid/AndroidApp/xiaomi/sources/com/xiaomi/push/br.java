package com.xiaomi.push;

import _m_j.duv;
import _m_j.dvb;
import _m_j.elo;
import _m_j.emm;
import android.content.Context;

public class br extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f6370O000000o;

    public br(Context context) {
        this.f6370O000000o = context;
    }

    public String a() {
        return "100886";
    }

    public void run() {
        try {
            if (dvb.O000000o(this.f6370O000000o).O000000o().O00000Oo) {
                duv.O00000o0(this.f6370O000000o.getPackageName() + " begin upload event");
                dvb O000000o2 = dvb.O000000o(this.f6370O000000o);
                if (O000000o2.O000000o().O00000Oo) {
                    emm emm = new emm();
                    emm.O00000Oo = O000000o2.O00000o;
                    emm.f15631O000000o = O000000o2.O0000O0o;
                    O000000o2.f14966O000000o.execute(emm);
                }
            }
        } catch (Exception e) {
            duv.O000000o(e);
        }
    }
}
