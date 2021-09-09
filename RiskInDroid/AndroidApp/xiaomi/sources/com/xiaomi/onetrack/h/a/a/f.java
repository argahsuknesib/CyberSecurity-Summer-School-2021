package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.TimeUnit;

class f implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f6149a;

    public void onServiceDisconnected(ComponentName componentName) {
    }

    f(e eVar) {
        this.f6149a = eVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6149a.f6148a.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            q.a("HWDeviceIDHelper", e.getMessage());
        }
    }
}
