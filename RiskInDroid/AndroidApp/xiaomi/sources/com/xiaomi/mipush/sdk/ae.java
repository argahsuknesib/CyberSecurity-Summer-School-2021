package com.xiaomi.mipush.sdk;

import _m_j.eao;
import _m_j.elo;
import _m_j.eru;
import android.content.Context;
import com.xiaomi.push.hp;
import com.xiaomi.push.hv;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.ih;
import com.xiaomi.push.io;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.au;

public class ae extends elo.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f6050O000000o;

    public ae(Context context) {
        this.f6050O000000o = context;
    }

    public String a() {
        return "2";
    }

    public void run() {
        at a2 = at.a(this.f6050O000000o);
        ih ihVar = new ih();
        ihVar.f6418a = au.a(a2, hv.f6397a);
        ihVar.O000000o();
        ihVar.b = au.a(a2, hv.b);
        ihVar.O00000Oo();
        io ioVar = new io("-1", false);
        ioVar.d = hz.p.f70a;
        ioVar.O000000o(eru.O000000o(ihVar));
        eao.O000000o(this.f6050O000000o).O000000o(ioVar, hp.i, (ic) null);
    }
}
