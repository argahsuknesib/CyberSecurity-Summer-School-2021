package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;

class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6118a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ f f;

    z(f fVar, String str, String str2, String str3, String str4, String str5) {
        this.f = fVar;
        this.f6118a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public void run() {
        try {
            this.f.b.a("onetrack_bug_report", c.a(this.f6118a, this.b, this.c, this.d, this.e, this.f.f, this.f.h, this.f.d("onetrack_bug_report")));
        } catch (Exception e2) {
            q.b("OneTrackImp", "trackException error: " + e2.toString());
        }
    }
}
