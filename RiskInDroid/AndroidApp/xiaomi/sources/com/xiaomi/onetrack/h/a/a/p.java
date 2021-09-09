package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.b.f;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f6159a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new q(this);

    public String a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        String str = "";
        if (context.bindService(intent, this.b, 1)) {
            try {
                IBinder poll = this.f6159a.poll(1, TimeUnit.SECONDS);
                if (poll == null) {
                    try {
                        context.unbindService(this.b);
                    } catch (Exception e) {
                        q.a("SamsungDeviceIDHelper", e.getMessage());
                    }
                    return str;
                }
                str = new f.a(poll).a();
                try {
                    context.unbindService(this.b);
                } catch (Exception e2) {
                    q.a("SamsungDeviceIDHelper", e2.getMessage());
                }
            } catch (Exception e3) {
                q.a("SamsungDeviceIDHelper", e3.getMessage());
                context.unbindService(this.b);
            } catch (Throwable th) {
                try {
                    context.unbindService(this.b);
                } catch (Exception e4) {
                    q.a("SamsungDeviceIDHelper", e4.getMessage());
                }
                throw th;
            }
        }
        return str;
    }
}
