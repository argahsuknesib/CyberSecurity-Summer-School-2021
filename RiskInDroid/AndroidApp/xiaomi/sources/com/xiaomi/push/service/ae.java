package com.xiaomi.push.service;

import com.xiaomi.push.service.az;

class ae implements az.b.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6488a;

    ae(XMPushService xMPushService) {
        this.f6488a = xMPushService;
    }

    public void a(az.c cVar, az.c cVar2, int i) {
        if (cVar2 == az.c.c) {
            r.a(this.f6488a);
            r.b(this.f6488a);
        } else if (cVar2 == az.c.f6516a) {
            r.a(this.f6488a, 70000001, " the push is not connected.");
        }
    }
}
