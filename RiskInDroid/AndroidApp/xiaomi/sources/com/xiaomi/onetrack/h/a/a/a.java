package com.xiaomi.onetrack.h.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.onetrack.h.a.b.a;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f6143a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new b(this);

    public String a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        String str = "";
        if (context.bindService(intent, this.b, 1)) {
            try {
                IBinder poll = this.f6143a.poll(1, TimeUnit.SECONDS);
                if (poll == null) {
                    try {
                        context.unbindService(this.b);
                    } catch (Exception e) {
                        q.a("ASUSDeviceIDHelper", e.getMessage());
                    }
                    return str;
                }
                str = new a.C0054a(poll).a();
                try {
                    context.unbindService(this.b);
                } catch (Exception e2) {
                    q.a("ASUSDeviceIDHelper", e2.getMessage());
                }
            } catch (Exception e3) {
                q.a("ASUSDeviceIDHelper", e3.getMessage());
                context.unbindService(this.b);
            } catch (Throwable th) {
                try {
                    context.unbindService(this.b);
                } catch (Exception e4) {
                    q.a("ASUSDeviceIDHelper", e4.getMessage());
                }
                throw th;
            }
        }
        return str;
    }
}
