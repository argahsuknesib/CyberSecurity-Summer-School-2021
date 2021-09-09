package com.xiaomi.onetrack.f;

import com.xiaomi.onetrack.c.b;

final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6138a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;

    e(String str, String str2, String str3, String str4) {
        this.f6138a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void run() {
        b.a().a(com.xiaomi.onetrack.e.b.a(this.f6138a, this.b, this.c, this.d));
    }
}
