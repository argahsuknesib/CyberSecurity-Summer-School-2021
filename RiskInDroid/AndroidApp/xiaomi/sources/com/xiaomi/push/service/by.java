package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.eru;
import com.xiaomi.push.hp;
import com.xiaomi.push.io;

class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ io f6540a;

    by(io ioVar) {
        this.f6540a = ioVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void
     arg types: [java.lang.String, byte[], int]
     candidates:
      com.xiaomi.push.service.XMPushService.a(_m_j.eqr, java.lang.String, java.lang.String):_m_j.eqr
      com.xiaomi.push.service.XMPushService.a(_m_j.eqb, int, java.lang.Exception):void
      _m_j.eqe.a(_m_j.eqb, int, java.lang.Exception):void
      com.xiaomi.push.service.XMPushService.a(java.lang.String, byte[], boolean):void */
    public void run() {
        byte[] O000000o2 = eru.O000000o(ab.a(this.f6540a.f, this.f6540a.c, this.f6540a, hp.i));
        if (bx.a() instanceof XMPushService) {
            ((XMPushService) bx.a()).a(this.f6540a.f, O000000o2, true);
        } else {
            duv.O000000o("UNDatas UploadNotificationDatas failed because not xmsf");
        }
    }
}
