package com.xiaomi.push.service;

import _m_j.elh;
import _m_j.eqc;
import android.content.Context;
import com.xiaomi.push.service.XMPushService;

class ca extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6543a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f310a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ byte[] f311a;
    final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ca(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f6543a = xMPushService;
        this.b = i2;
        this.f311a = bArr;
        this.f310a = str;
    }

    public String a() {
        return "clear account cache.";
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m196a() {
        o.m223a((Context) this.f6543a);
        az.a().m180a("5");
        elh.O000000o(this.b);
        XMPushService.a(this.f6543a).c(eqc.a());
        this.f6543a.a(this.f311a, this.f310a);
    }
}
