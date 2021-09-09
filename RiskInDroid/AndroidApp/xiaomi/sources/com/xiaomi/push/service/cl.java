package com.xiaomi.push.service;

import _m_j.emf;
import com.xiaomi.push.service.XMPushService;

class cl extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6554a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cl(XMPushService xMPushService, int i) {
        super(i);
        this.f6554a = xMPushService;
    }

    public String a() {
        return "prepare the mi push account.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m199a() {
        ab.a(this.f6554a);
        if (emf.O000000o(this.f6554a)) {
            this.f6554a.a(true);
        }
    }
}
