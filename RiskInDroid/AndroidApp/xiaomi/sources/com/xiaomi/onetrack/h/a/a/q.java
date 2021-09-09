package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.TimeUnit;

class q implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ p f6160a;

    public void onServiceDisconnected(ComponentName componentName) {
    }

    q(p pVar) {
        this.f6160a = pVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6160a.f6159a.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            com.xiaomi.onetrack.h.q.a("SamsungDeviceIDHelper", e.getMessage());
        }
    }
}
