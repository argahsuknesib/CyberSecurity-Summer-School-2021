package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

final class ah extends ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IBinder f3747a;
    final /* synthetic */ aj b;

    ah(aj ajVar, IBinder iBinder) {
        this.b = ajVar;
        this.f3747a = iBinder;
    }

    public final void a() {
        ak akVar = this.b.f3749a;
        akVar.l = (IInterface) akVar.h.a(this.f3747a);
        ak.f(this.b.f3749a);
        this.b.f3749a.f = false;
        for (Runnable run : this.b.f3749a.e) {
            run.run();
        }
        this.b.f3749a.e.clear();
    }
}
