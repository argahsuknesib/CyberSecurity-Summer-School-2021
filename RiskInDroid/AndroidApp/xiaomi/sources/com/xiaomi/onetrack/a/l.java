package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;

class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6104a;
    final /* synthetic */ boolean b;
    final /* synthetic */ f c;

    l(f fVar, String str, boolean z) {
        this.c = fVar;
        this.f6104a = str;
        this.b = z;
    }

    public void run() {
        try {
            if (!this.c.f.isAutoTrackActivityAction()) {
                q.a("OneTrackImp", "config.autoTrackActivityAction is false, ignore onetrack_pa resume event");
                return;
            }
            this.c.b.a("onetrack_pa", c.a(this.f6104a, "onetrack_pa", this.c.f, this.c.h, this.c.d("onetrack_pa"), this.b));
            q.a("OneTrackImp", "trackPageStartAuto");
        } catch (Exception e) {
            q.b("OneTrackImp", "auto trackPageStartAuto error: " + e.toString());
        }
    }
}
