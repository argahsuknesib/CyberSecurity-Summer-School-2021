package com.xiaomi.push.service;

import _m_j.duv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;

class bb extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az.b.c f6519a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bb(az.b.c cVar, int i) {
        super(i);
        this.f6519a = cVar;
    }

    public String a() {
        return "clear peer job";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m184a() {
        if (this.f6519a.f6515a == this.f6519a.f281a.f268a) {
            duv.O00000Oo("clean peer, chid = " + this.f6519a.f281a.g);
            this.f6519a.f281a.f268a = null;
        }
    }
}
