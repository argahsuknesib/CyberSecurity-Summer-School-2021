package com.xiaomi.push.service;

import _m_j.duv;
import com.xiaomi.push.gg;
import com.xiaomi.push.il;
import com.xiaomi.push.service.XMPushService;

class t extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ il f6576a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f349a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    t(int i, XMPushService xMPushService, il ilVar) {
        super(i);
        this.f349a = xMPushService;
        this.f6576a = ilVar;
    }

    public String a() {
        return "send app absent message.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m229a() {
        try {
            ab.a(this.f349a, ab.a(this.f6576a.b, this.f6576a.f124a));
        } catch (gg e) {
            duv.O000000o(e);
            this.f349a.a(10, e);
        }
    }
}
