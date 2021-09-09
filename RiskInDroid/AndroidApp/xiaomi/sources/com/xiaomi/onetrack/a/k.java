package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.ab;
import com.xiaomi.onetrack.h.q;
import com.xiaomi.onetrack.h.z;

class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6103a;

    k(f fVar) {
        this.f6103a = fVar;
    }

    public void run() {
        try {
            if (!ab.d(z.t())) {
                z.m(System.currentTimeMillis());
                this.f6103a.b.a("onetrack_dau", c.a(this.f6103a.f, this.f6103a.h, this.f6103a.d("onetrack_dau")));
            }
        } catch (Exception e) {
            q.b("OneTrackImp", "trackDau error  e:" + e.toString());
        }
    }
}
