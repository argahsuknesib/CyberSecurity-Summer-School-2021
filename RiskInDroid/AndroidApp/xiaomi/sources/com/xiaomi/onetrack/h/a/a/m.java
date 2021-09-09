package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.TimeUnit;

class m implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f6156a;

    m(l lVar) {
        this.f6156a = lVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6156a.b.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            q.a("OnePlusDeviceIDHelper", e.getMessage());
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f6156a.f6155a = null;
    }
}
