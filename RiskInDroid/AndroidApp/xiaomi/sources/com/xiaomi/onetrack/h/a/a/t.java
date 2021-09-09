package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.TimeUnit;

class t implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f6162a;

    public void onServiceDisconnected(ComponentName componentName) {
    }

    t(s sVar) {
        this.f6162a = sVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6162a.b.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            q.a("ZTEDeviceIDHelper", e.getMessage());
        }
    }
}
