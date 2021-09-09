package com.xiaomi.onetrack.a;

import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.q;

class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f6111a;
    final /* synthetic */ f b;

    s(f fVar, String str) {
        this.b = fVar;
        this.f6111a = str;
    }

    public void run() {
        try {
            p.a().a(this.f6111a);
        } catch (Exception e) {
            q.b("OneTrackImp", "setInstanceId error: " + e.toString());
        }
    }
}
