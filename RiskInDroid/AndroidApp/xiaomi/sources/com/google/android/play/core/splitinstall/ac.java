package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.listener.b;

public final class ac extends b<SplitInstallSessionState> {
    private static ac c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final c e;

    public ac(Context context, c cVar) {
        super(new aa("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.e = cVar;
    }

    public static synchronized ac a(Context context) {
        ac acVar;
        synchronized (ac.class) {
            if (c == null) {
                c = new ac(context, w.f3839a);
            }
            acVar = c;
        }
        return acVar;
    }

    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState a2 = SplitInstallSessionState.a(bundleExtra);
            this.f3771a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a2);
            d a3 = this.e.a();
            if (a2.status() == 3 && a3 != null) {
                a3.a(a2.c(), new aa(this, a2, intent, context));
            } else {
                a(a2);
            }
        }
    }
}
