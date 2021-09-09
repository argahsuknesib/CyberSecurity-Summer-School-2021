package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.b.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f6150a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new h(this);

    public String a(Context context) {
        context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        String str = "";
        if (context.bindService(intent, this.b, 1)) {
            try {
                IBinder poll = this.f6150a.poll(1, TimeUnit.SECONDS);
                if (poll == null) {
                    try {
                        context.unbindService(this.b);
                    } catch (Exception unused) {
                    }
                    return str;
                }
                str = new c.a.C0055a(poll).a();
                try {
                    context.unbindService(this.b);
                } catch (Exception unused2) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                try {
                    context.unbindService(this.b);
                } catch (Exception unused3) {
                }
                throw th;
            }
        }
        return str;
    }
}
