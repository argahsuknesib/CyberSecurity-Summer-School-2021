package com.xiaomi.onetrack.c;

import com.xiaomi.onetrack.f.b;
import com.xiaomi.onetrack.h.q;

class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f6126a;
    final /* synthetic */ b b;

    d(b bVar, b bVar2) {
        this.b = bVar;
        this.f6126a = bVar2;
    }

    public void run() {
        try {
            this.b.b(this.f6126a);
            q.a("EventManager", "addEvent: " + this.f6126a.d() + "data:" + this.f6126a.f().toString());
            m.a().a(this.f6126a.e(), false);
        } catch (Exception e) {
            q.b("EventManager", "EventManager.addEvent exception: ", e);
        }
    }
}
