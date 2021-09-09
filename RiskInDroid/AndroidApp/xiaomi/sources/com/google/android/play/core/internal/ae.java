package com.google.android.play.core.internal;

import android.os.IInterface;

final class ae extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f3746a;

    ae(ak akVar) {
        this.f3746a = akVar;
    }

    public final void a() {
        if (this.f3746a.l != null) {
            this.f3746a.c.c("Unbind from service.", new Object[0]);
            this.f3746a.b.unbindService(this.f3746a.k);
            this.f3746a.f = false;
            this.f3746a.l = (IInterface) null;
            this.f3746a.k = null;
        }
    }
}
