package com.xiaomi.push.service;

import _m_j.eqb;
import com.xiaomi.push.service.XMPushService;

class cc extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6545a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cc(XMPushService xMPushService, int i) {
        super(i);
        this.f6545a = xMPushService;
    }

    public String a() {
        return "disconnect for service destroy.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m198a() {
        if (XMPushService.a(this.f6545a) != null) {
            XMPushService.a(this.f6545a).O00000Oo(15, (Exception) null);
            eqb unused = this.f6545a.f194a = (eqb) null;
        }
    }
}
