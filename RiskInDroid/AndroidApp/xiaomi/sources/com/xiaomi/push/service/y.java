package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import com.xiaomi.push.gg;
import com.xiaomi.push.il;
import com.xiaomi.push.service.XMPushService;

class y extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ il f6581a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ XMPushService f355a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f356a;
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    y(int i, XMPushService xMPushService, il ilVar, String str, String str2) {
        super(i);
        this.f355a = xMPushService;
        this.f6581a = ilVar;
        this.f356a = str;
        this.b = str2;
    }

    public String a() {
        return "send wrong message ack for message.";
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
    public void m234a() {
        try {
            il a2 = s.a((Context) this.f355a, this.f6581a);
            a2.f122a.O000000o("error", this.f356a);
            a2.f122a.O000000o("reason", this.b);
            ab.a(this.f355a, a2);
        } catch (gg e) {
            duv.O000000o(e);
            this.f355a.a(10, e);
        }
    }
}
