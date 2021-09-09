package com.xiaomi.onetrack.a;

import android.text.TextUtils;
import com.xiaomi.onetrack.h.d;
import com.xiaomi.onetrack.h.p;
import com.xiaomi.onetrack.h.z;

class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f6099a;

    g(f fVar) {
        this.f6099a = fVar;
    }

    public void run() {
        if (z.B() == 0) {
            z.n(System.currentTimeMillis());
        }
        if (!TextUtils.isEmpty(this.f6099a.f.getInstanceId())) {
            p.a().a(this.f6099a.f.getInstanceId());
        }
        this.f6099a.l();
        d.a();
        com.xiaomi.onetrack.c.g.c(false);
    }
}
