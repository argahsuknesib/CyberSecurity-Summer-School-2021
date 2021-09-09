package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;

class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6113a;

    u(f fVar) {
        this.f6113a = fVar;
    }

    public void run() {
        try {
            this.f6113a.b.a("onetrack_cta_status", c.a(this.f6113a.f, this.f6113a.h));
        } catch (Exception e) {
            q.b("OneTrackImp", "cta event error: " + e.toString());
        }
    }
}
