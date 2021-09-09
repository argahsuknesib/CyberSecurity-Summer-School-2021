package com.xiaomi.onetrack.b;

import com.xiaomi.onetrack.h.q;
import java.util.ArrayList;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f6121a;
    final /* synthetic */ f b;

    g(f fVar, ArrayList arrayList) {
        this.b = fVar;
        this.f6121a = arrayList;
    }

    public void run() {
        if (q.f6178a) {
            q.a("ConfigDbManager", "update: " + this.f6121a);
        }
        this.b.b(this.f6121a);
    }
}
