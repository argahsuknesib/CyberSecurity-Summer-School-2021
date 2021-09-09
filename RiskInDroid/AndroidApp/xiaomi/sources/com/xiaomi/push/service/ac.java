package com.xiaomi.push.service;

import _m_j.eru;
import _m_j.erv;
import android.text.TextUtils;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.io;
import com.xiaomi.push.service.bq;
import java.util.HashMap;

class ac extends bq.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6486a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ n f231a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ac(String str, long j, XMPushService xMPushService, n nVar) {
        super(str, j);
        this.f6486a = xMPushService;
        this.f231a = nVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void
     arg types: [java.lang.String, byte[], int]
     candidates:
      com.xiaomi.push.service.XMPushService.a(_m_j.eqr, java.lang.String, java.lang.String):_m_j.eqr
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, int, java.lang.Exception):void
      _m_j.eqe.a(_m_j.eqb, int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void */
    /* access modifiers changed from: package-private */
    public void a(bq bqVar) {
        String a2 = bqVar.a("GAID", "gaid");
        String O000000o2 = erv.O000000o(this.f6486a);
        if (!TextUtils.isEmpty(O000000o2) && !TextUtils.equals(a2, O000000o2)) {
            bqVar.a("GAID", "gaid", O000000o2);
            io ioVar = new io();
            ioVar.c = this.f231a.d;
            ioVar.d = hz.g.f70a;
            ioVar.b = aw.a();
            ioVar.f133a = new HashMap();
            ioVar.f133a.put("gaid", O000000o2);
            byte[] O000000o3 = eru.O000000o(ab.a(this.f6486a.getPackageName(), this.f231a.d, ioVar, hp.i));
            XMPushService xMPushService = this.f6486a;
            xMPushService.a(xMPushService.getPackageName(), O000000o3, true);
        }
    }
}
