package com.xiaomi.push;

import _m_j.duv;
import _m_j.dvb;
import _m_j.elo;
import _m_j.emm;
import android.content.Context;

public class bs extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f6371O000000o;

    public bs(Context context) {
        this.f6371O000000o = context;
    }

    public String a() {
        return "100887";
    }

    public void run() {
        try {
            if (dvb.O000000o(this.f6371O000000o).O000000o().O00000o0) {
                dvb O000000o2 = dvb.O000000o(this.f6371O000000o);
                if (O000000o2.O000000o().O00000o0) {
                    emm emm = new emm();
                    emm.f15631O000000o = O000000o2.O0000OOo;
                    emm.O00000Oo = O000000o2.O00000o;
                    O000000o2.f14966O000000o.execute(emm);
                }
                duv.O00000o0(this.f6371O000000o.getPackageName() + " perf begin upload");
            }
        } catch (Exception e) {
            duv.O00000o("fail to send perf data. ".concat(String.valueOf(e)));
        }
    }
}
