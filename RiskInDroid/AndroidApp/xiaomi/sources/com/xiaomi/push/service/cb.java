package com.xiaomi.push.service;

import _m_j.duv;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;

class cb extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6544a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f312a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f313a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    cb(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f6544a = xMPushService;
        this.f312a = str;
        this.f313a = bArr;
    }

    public String a() {
        return "send mi push message";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m197a() {
        try {
            ab.a(this.f6544a, this.f312a, this.f313a);
        } catch (gg e) {
            duv.O000000o(e);
            this.f6544a.a(10, e);
        }
    }
}
