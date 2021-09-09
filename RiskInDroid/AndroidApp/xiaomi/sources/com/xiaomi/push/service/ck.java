package com.xiaomi.push.service;

import _m_j.duv;
import android.database.ContentObserver;
import android.os.Handler;
import com.xiaomi.push.service.XMPushService;

class ck extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6553a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ck(XMPushService xMPushService, Handler handler) {
        super(handler);
        this.f6553a = xMPushService;
    }

    public void onChange(boolean z) {
        super.onChange(z);
        boolean b = XMPushService.b(this.f6553a);
        duv.O000000o("SuperPowerMode:".concat(String.valueOf(b)));
        XMPushService.a(this.f6553a);
        if (b) {
            XMPushService xMPushService = this.f6553a;
            xMPushService.a(new XMPushService.g(24, null));
            return;
        }
        this.f6553a.a(true);
    }
}
