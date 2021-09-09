package com.xiaomi.onetrack.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.onetrack.b.c;
import com.xiaomi.onetrack.h.j;
import com.xiaomi.onetrack.h.q;
import java.util.concurrent.atomic.AtomicBoolean;

public class f {
    private static f b;
    private static BroadcastReceiver e = new j();
    /* access modifiers changed from: private */
    public AtomicBoolean c = new AtomicBoolean(false);
    private BroadcastReceiver d = new h(this);

    public static void a(Context context) {
        if (b == null) {
            b = new f(context);
        }
    }

    private f(Context context) {
        j.a(new g(this, context.getApplicationContext()));
    }

    /* access modifiers changed from: private */
    public void a() {
        c.b();
    }

    /* access modifiers changed from: private */
    public static void c(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(e, intentFilter);
    }

    /* access modifiers changed from: private */
    public void d(Context context) {
        if (context != null) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.d, intentFilter);
            } catch (Exception e2) {
                q.a("OneTrackApp", "registerNetReceiver: ".concat(String.valueOf(e2)));
            }
        }
    }
}
