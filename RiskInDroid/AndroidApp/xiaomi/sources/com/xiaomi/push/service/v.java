package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.il;
import com.xiaomi.push.service.XMPushService;

class v extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ il f6578a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f351a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    v(int i, XMPushService xMPushService, il ilVar) {
        super(i);
        this.f351a = xMPushService;
        this.f6578a = ilVar;
    }

    public String a() {
        return "send ack message for obsleted message.";
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
    public void m231a() {
        try {
            il a2 = s.a((Context) this.f351a, this.f6578a);
            a2.f122a.O000000o("message_obsleted", "1");
            ab.a(this.f351a, a2);
        } catch (gg e) {
            duv.O000000o(e);
            this.f351a.a(10, e);
        }
    }
}
