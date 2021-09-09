package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;

class bc extends XMPushService.j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ az.b.c f6520a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bc(az.b.c cVar, int i) {
        super(i);
        this.f6520a = cVar;
    }

    public String a() {
        return "check peer job";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
     arg types: [java.lang.String, java.lang.String]
     candidates:
      com.xiaomi.push.service.az.a(android.content.Context, int):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
      com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
    /* renamed from: a  reason: collision with other method in class */
    public void m185a() {
        if (az.a().a(this.f6520a.f281a.g, this.f6520a.f281a.f277b).f268a == null) {
            az.b.a(az.b.this).a(this.f6520a.f281a.g, this.f6520a.f281a.f277b, 2, null, null);
        }
    }
}
