package com.xiaomi.onetrack.f;

import android.content.Context;
import com.xiaomi.onetrack.c.b;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f6139a;
    final /* synthetic */ f b;

    g(f fVar, Context context) {
        this.b = fVar;
        this.f6139a = context;
    }

    public void run() {
        f.c(this.f6139a);
        this.b.d(this.f6139a);
        b.a(this.f6139a);
    }
}
