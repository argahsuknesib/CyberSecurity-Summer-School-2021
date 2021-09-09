package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.TimeUnit;

class h implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f6151a;

    public void onServiceDisconnected(ComponentName componentName) {
    }

    h(g gVar) {
        this.f6151a = gVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f6151a.f6150a.offer(iBinder, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
