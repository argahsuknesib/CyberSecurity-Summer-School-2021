package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class aj implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f3749a;

    /* synthetic */ aj(ak akVar) {
        this.f3749a = akVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3749a.c.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f3749a.b(new ah(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f3749a.c.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f3749a.b(new ai(this));
    }
}
