package com.xiaomi.push.service;

import _m_j.elz;
import _m_j.eru;
import android.text.TextUtils;
import com.xiaomi.push.hp;
import com.xiaomi.push.hz;
import com.xiaomi.push.io;
import com.xiaomi.push.service.bq;
import java.util.HashMap;

class ad extends bq.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6487a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ n f232a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(String str, long j, XMPushService xMPushService, n nVar) {
        super(str, j);
        this.f6487a = xMPushService;
        this.f232a = nVar;
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
        elz O000000o2 = elz.O000000o(this.f6487a);
        String a2 = bqVar.a("MSAID", "msaid");
        String str = O000000o2.O00000Oo() + O000000o2.O00000o0() + O000000o2.O00000o() + O000000o2.O00000oO();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(a2, str)) {
            bqVar.a("MSAID", "msaid", str);
            io ioVar = new io();
            ioVar.c = this.f232a.d;
            ioVar.d = hz.g.f70a;
            ioVar.b = aw.a();
            ioVar.f133a = new HashMap();
            O000000o2.O000000o(ioVar.f133a);
            byte[] O000000o3 = eru.O000000o(ab.a(this.f6487a.getPackageName(), this.f232a.d, ioVar, hp.i));
            XMPushService xMPushService = this.f6487a;
            xMPushService.a(xMPushService.getPackageName(), O000000o3, true);
        }
    }
}
