package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;

class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6117a;
    final /* synthetic */ String b;
    final /* synthetic */ f c;

    y(f fVar, String str, String str2) {
        this.c = fVar;
        this.f6117a = str;
        this.b = str2;
    }

    public void run() {
        try {
            if (!this.c.c(this.f6117a)) {
                this.c.b.a(this.f6117a, this.b);
            }
        } catch (Exception e) {
            q.b("OneTrackImp", "track map error: " + e.toString());
        }
    }
}
