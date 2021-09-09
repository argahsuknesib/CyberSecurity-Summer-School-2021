package com.xiaomi.push.service;

import _m_j.duv;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

class cj extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6552a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cj(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f6552a = xMPushService;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        boolean a2 = XMPushService.a(this.f6552a);
        duv.O000000o("ExtremePowerMode:".concat(String.valueOf(a2)));
        if (a2) {
            XMPushService xMPushService = this.f6552a;
            xMPushService.a(new XMPushService.g(23, null));
            return;
        }
        this.f6552a.a(true);
    }
}
