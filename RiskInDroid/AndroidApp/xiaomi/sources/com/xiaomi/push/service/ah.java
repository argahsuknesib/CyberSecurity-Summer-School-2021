package com.xiaomi.push.service;

import _m_j.elo;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;

class ah extends elo.O000000o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f6494a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Notification f243a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Context f244a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f245a;
    final /* synthetic */ String b;

    ah(int i, String str, Context context, String str2, Notification notification) {
        this.f6494a = i;
        this.f245a = str;
        this.f244a = context;
        this.b = str2;
        this.f243a = notification;
    }

    public String a() {
        return af.b(this.f6494a, this.f245a);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification):void
     arg types: [android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification]
     candidates:
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification):_m_j.elo$O000000o
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, java.lang.String, byte[], int):android.app.PendingIntent
      com.xiaomi.push.service.af.a(android.content.Context, com.xiaomi.push.il, byte[], java.lang.String, int):com.xiaomi.push.ex
      com.xiaomi.push.service.af.a(android.content.Context, java.lang.String, int, java.lang.String, android.app.Notification):void */
    @TargetApi(19)
    public void run() {
        af.a(this.f244a, this.b, this.f6494a, this.f245a, this.f243a);
    }
}
