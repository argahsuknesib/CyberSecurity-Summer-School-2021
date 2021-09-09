package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.il;
import com.xiaomi.push.service.XMPushService;

class x extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ il f6580a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f353a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f354a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    x(int i, XMPushService xMPushService, il ilVar, String str) {
        super(i);
        this.f353a = xMPushService;
        this.f6580a = ilVar;
        this.f354a = str;
    }

    public String a() {
        return "send app absent ack message for message.";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.s.a(android.content.Context, com.xiaomi.push.il):com.xiaomi.push.il
     arg types: [com.xiaomi.push.service.XMPushService, com.xiaomi.push.il]
     candidates:
      com.xiaomi.push.service.s.a(byte[], long):android.content.Intent
      com.xiaomi.push.service.s.a(com.xiaomi.push.service.XMPushService, com.xiaomi.push.il):void
      com.xiaomi.push.service.s.a(android.content.Context, android.content.Intent):boolean
      com.xiaomi.push.service.s.a(android.content.Context, java.lang.String):boolean
      com.xiaomi.push.service.s.a(android.content.Context, com.xiaomi.push.il):com.xiaomi.push.il */
    /* renamed from: a  reason: collision with other method in class */
    public void m233a() {
        try {
            il a2 = s.a((Context) this.f353a, this.f6580a);
            a2.f122a.O000000o("absent_target_package", this.f354a);
            ab.a(this.f353a, a2);
        } catch (gg e) {
            duv.O000000o(e);
            this.f353a.a(10, e);
        }
    }
}
