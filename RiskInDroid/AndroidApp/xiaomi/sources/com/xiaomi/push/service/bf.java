package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.eow;
import _m_j.epb;
import _m_j.epe;
import _m_j.err;
import _m_j.eru;
import android.content.Context;
import com.xiaomi.push.hp;
import com.xiaomi.push.ht;
import com.xiaomi.push.hz;
import com.xiaomi.push.io;
import java.util.HashMap;

public class bf implements epe {
    public void c(Context context, HashMap<String, String> hashMap) {
        duv.O000000o("MoleInfo：　" + eow.O00000Oo(hashMap));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void
     arg types: [java.lang.String, byte[], int]
     candidates:
      com.xiaomi.push.service.XMPushService.a(_m_j.eqr, java.lang.String, java.lang.String):_m_j.eqr
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, int, java.lang.Exception):void
      _m_j.eqe.a(_m_j.eqb, int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void */
    public void a(Context context, HashMap<String, String> hashMap) {
        io ioVar = new io();
        ioVar.c = epb.O000000o(context).O00000Oo;
        ioVar.f = epb.O000000o(context).O00000o0;
        ioVar.d = hz.I.f70a;
        ioVar.b = aw.a();
        ioVar.f133a = hashMap;
        byte[] O000000o2 = eru.O000000o(ab.a(ioVar.f, ioVar.c, ioVar, hp.i));
        if (context instanceof XMPushService) {
            duv.O000000o("MoleInfo : send data directly in pushLayer " + ioVar.b);
            ((XMPushService) context).a(context.getPackageName(), O000000o2, true);
            return;
        }
        duv.O000000o("MoleInfo : context is not correct in pushLayer " + ioVar.b);
    }

    public void b(Context context, HashMap<String, String> hashMap) {
        err O000000o2 = err.O000000o(context);
        if (O000000o2 != null) {
            String O000000o3 = eow.O000000o(hashMap);
            String packageName = O000000o2.f15755O000000o.getPackageName();
            String packageName2 = O000000o2.f15755O000000o.getPackageName();
            ht htVar = new ht();
            htVar.d = "category_awake_app";
            htVar.c = "wake_up_app";
            htVar.O000000o(1);
            htVar.f56b = O000000o3;
            htVar.O000000o(true);
            htVar.f52a = "push_sdk_channel";
            htVar.e = packageName2;
            O000000o2.O000000o(htVar, packageName);
        }
    }
}
