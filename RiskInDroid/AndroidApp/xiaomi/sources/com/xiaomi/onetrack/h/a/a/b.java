package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.TimeUnit;

class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f6144a;

    public void onServiceDisconnected(ComponentName componentName) {
    }

    b(a aVar) {
        this.f6144a = aVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6144a.f6143a.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            q.a("ASUSDeviceIDHelper", e.getMessage());
        }
    }
}
