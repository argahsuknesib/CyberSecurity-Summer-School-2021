package com.xiaomi.onetrack.h.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.b.b;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f6148a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new f(this);

    public String a(Context context) {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        String str = "";
        if (context.bindService(intent, this.b, 1)) {
            try {
                IBinder poll = this.f6148a.poll(1, TimeUnit.SECONDS);
                if (poll == null) {
                    try {
                        context.unbindService(this.b);
                    } catch (Exception e) {
                        q.a("HWDeviceIDHelper", e.getMessage());
                    }
                    return str;
                }
                str = new b.a(poll).a();
                try {
                    context.unbindService(this.b);
                } catch (Exception e2) {
                    q.a("HWDeviceIDHelper", e2.getMessage());
                }
            } catch (Exception e3) {
                q.a("HWDeviceIDHelper", e3.getMessage());
                context.unbindService(this.b);
            } catch (Throwable th) {
                try {
                    context.unbindService(this.b);
                } catch (Exception e4) {
                    q.a("HWDeviceIDHelper", e4.getMessage());
                }
                throw th;
            }
        }
        return str;
    }
}
