package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.TimeUnit;

class o implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f6158a;

    o(n nVar) {
        this.f6158a = nVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6158a.b.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            q.a("OppoDeviceIDHelper", e.getMessage());
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f6158a.f6157a = null;
    }
}
