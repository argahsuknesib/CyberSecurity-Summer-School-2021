package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.z;

class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6105a;
    final /* synthetic */ long b;
    final /* synthetic */ f c;

    m(f fVar, String str, long j) {
        this.c = fVar;
        this.f6105a = str;
        this.b = j;
    }

    public void run() {
        try {
            if (!this.c.f.isAutoTrackActivityAction()) {
                q.a("OneTrackImp", "config.autoTrackActivityAction is false, ignore onetrack_pa pause event");
                return;
            }
            z.i(c.a(this.f6105a, "onetrack_pa", this.b, this.c.f, this.c.h, this.c.d("onetrack_pa")));
        } catch (Exception e) {
            q.b("OneTrackImp", "savePageEndData error:" + e.toString());
        }
    }
}
