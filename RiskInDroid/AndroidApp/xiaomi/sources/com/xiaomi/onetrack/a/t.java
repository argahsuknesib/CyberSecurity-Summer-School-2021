package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.ServiceQualityEvent;
import com.xiaomi.onetrack.h.q;

class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ServiceQualityEvent f6112a;
    final /* synthetic */ f b;

    t(f fVar, ServiceQualityEvent serviceQualityEvent) {
        this.b = fVar;
        this.f6112a = serviceQualityEvent;
    }

    public void run() {
        try {
            this.b.b.a("ot_service_quality", c.a(this.f6112a, this.b.f, this.b.h));
        } catch (Exception e) {
            q.b("OneTrackImp", "trackNetAvailableEvent error: " + e.toString());
        }
    }
}
