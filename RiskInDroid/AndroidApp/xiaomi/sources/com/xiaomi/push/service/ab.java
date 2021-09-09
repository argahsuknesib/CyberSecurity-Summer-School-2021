package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.env;
import _m_j.epq;
import _m_j.eqb;
import _m_j.eqr;
import _m_j.eru;
import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.ie;
import com.xiaomi.push.il;
import com.xiaomi.push.io;
import com.xiaomi.push.ja;
import com.xiaomi.push.jf;
import com.xiaomi.push.service.az;
import java.nio.ByteBuffer;

final class ab {
    static epq a(XMPushService xMPushService, byte[] bArr) {
        il ilVar = new il();
        try {
            eru.O000000o(ilVar, bArr);
            return a(o.m222a((Context) xMPushService), xMPushService, ilVar);
        } catch (jf e) {
            duv.O000000o(e);
            return null;
        }
    }

    static <T extends ja<T, ?>> il a(String str, String str2, T t, hp hpVar) {
        return a(str, str2, t, hpVar, true);
    }

    private static String a(il ilVar) {
        if (!(ilVar.f122a == null || ilVar.f122a.f89b == null)) {
            String str = ilVar.f122a.f89b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ilVar.b;
    }

    static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    static void a(XMPushService xMPushService) {
        n a2 = o.m222a(xMPushService.getApplicationContext());
        if (a2 != null) {
            az.b a3 = o.m222a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a3);
            az.a().a(a3);
            bq.a(xMPushService).a(new ac("GAID", 172800, xMPushService, a2));
            a(xMPushService, a2, 172800);
        }
    }

    static void a(XMPushService xMPushService, az.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new ae(xMPushService));
    }

    private static void a(XMPushService xMPushService, n nVar, int i) {
        bq.a(xMPushService).a(new ad("MSAID", (long) i, xMPushService, nVar));
    }

    static <T extends ja<T, ?>> il b(String str, String str2, T t, hp hpVar) {
        return a(str, str2, t, hpVar, false);
    }

    static epq a(n nVar, Context context, il ilVar) {
        try {
            epq epq = new epq();
            epq.O000000o(5);
            epq.O00000Oo(nVar.f341a);
            epq.O00000o0 = a(ilVar);
            epq.O000000o("SECMSG", "message");
            String str = nVar.f341a;
            ilVar.f123a.f94a = str.substring(0, str.indexOf("@"));
            ilVar.f123a.c = str.substring(str.indexOf("/") + 1);
            epq.O000000o(eru.O000000o(ilVar), nVar.c);
            epq.O00000Oo = 1;
            duv.O000000o("try send mi push message. packagename:" + ilVar.b + " action:" + ilVar.f6426a);
            return epq;
        } catch (NullPointerException e) {
            duv.O000000o(e);
            return null;
        }
    }

    private static <T extends ja<T, ?>> il a(String str, String str2, T t, hp hpVar, boolean z) {
        byte[] O000000o2 = eru.O000000o(t);
        il ilVar = new il();
        ie ieVar = new ie();
        ieVar.f6412a = 5;
        ieVar.f94a = "fakeid";
        ilVar.f123a = ieVar;
        ilVar.f125a = ByteBuffer.wrap(O000000o2);
        ilVar.f6426a = hpVar;
        ilVar.O00000Oo(z);
        ilVar.b = str;
        ilVar.O000000o(false);
        ilVar.f124a = str2;
        return ilVar;
    }

    static il a(String str, String str2) {
        io ioVar = new io();
        ioVar.c = str2;
        ioVar.d = "package uninstalled";
        ioVar.b = eqr.O00000o0();
        ioVar.O000000o(false);
        return a(str, str2, ioVar, hp.i);
    }

    static il b(String str, String str2) {
        io ioVar = new io();
        ioVar.c = str2;
        ioVar.d = hz.ac.f70a;
        ioVar.b = aw.a();
        ioVar.O000000o(false);
        return a(str, str2, ioVar, hp.i);
    }

    static void a(XMPushService xMPushService, String str, byte[] bArr) {
        Context applicationContext = xMPushService.getApplicationContext();
        if (!(applicationContext == null || bArr == null || bArr.length <= 0)) {
            il ilVar = new il();
            try {
                eru.O000000o(ilVar, bArr);
                env.O000000o(str, applicationContext, ilVar, bArr.length);
            } catch (jf unused) {
                duv.O000000o("fail to convert bytes to container");
            }
        }
        eqb a2 = xMPushService.m119a();
        if (a2 == null) {
            throw new gg("try send msg while connection is null.");
        } else if (a2.O00000Oo()) {
            epq a3 = a(xMPushService, bArr);
            if (a3 != null) {
                a2.O00000Oo(a3);
            } else {
                r.a(xMPushService, str, bArr, 70000003, "not a valid message");
            }
        } else {
            throw new gg("Don't support XMPP connection.");
        }
    }

    static void a(XMPushService xMPushService, il ilVar) {
        env.O000000o(ilVar.b, xMPushService.getApplicationContext(), ilVar, -1);
        eqb a2 = xMPushService.m119a();
        if (a2 == null) {
            throw new gg("try send msg while connection is null.");
        } else if (a2.O00000Oo()) {
            epq a3 = a(o.m222a((Context) xMPushService), xMPushService, ilVar);
            if (a3 != null) {
                a2.O00000Oo(a3);
            }
        } else {
            throw new gg("Don't support XMPP connection.");
        }
    }
}
