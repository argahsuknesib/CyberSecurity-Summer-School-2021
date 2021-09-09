package com.xiaomi.onetrack.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.miui.analytics.ITrack;
import com.xiaomi.onetrack.Configuration;
import com.xiaomi.onetrack.h.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ai {
    /* access modifiers changed from: private */
    public ITrack d;
    /* access modifiers changed from: private */
    public AtomicBoolean e;
    /* access modifiers changed from: private */
    public AtomicBoolean f;
    /* access modifiers changed from: private */
    public final Object g;
    private boolean h;
    private Context i;
    private c k;
    private ServiceConnection l;
    private CopyOnWriteArrayList<b> m;

    public interface b {
        void a();
    }

    /* synthetic */ ai(aj ajVar) {
        this();
    }

    public static ai a() {
        return a.f6095a;
    }

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static ai f6095a = new ai(null);

        private a() {
        }
    }

    private ai() {
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new Object();
        this.h = false;
        this.l = new aj(this);
        this.m = new CopyOnWriteArrayList<>();
        this.i = com.xiaomi.onetrack.f.a.a();
        this.k = new c(Looper.getMainLooper());
        this.h = e();
        b();
    }

    public boolean a(String str, String str2, Configuration configuration) {
        boolean z;
        synchronized (this.g) {
            b();
            z = false;
            if (this.d != null) {
                try {
                    this.d.trackEvent(configuration.getAppId(), com.xiaomi.onetrack.f.a.d(), str, str2);
                    z = true;
                } catch (RemoteException e2) {
                    d();
                    this.e.set(false);
                    this.f.set(false);
                    this.d = null;
                    q.a("ServiceConnectManager", "track: " + e2.toString());
                } catch (NullPointerException unused) {
                }
            }
        }
        return z;
    }

    public void b(String str, String str2, Configuration configuration) {
        try {
            synchronized (this.g) {
                this.d.trackEvent(configuration.getAppId(), com.xiaomi.onetrack.f.a.d(), str, str2);
            }
        } catch (Exception e2) {
            q.b("ServiceConnectManager", "trackCacheData error:" + e2.toString());
        }
    }

    private void b() {
        if (this.e.get() || (this.f.get() && this.d != null)) {
            StringBuilder sb = new StringBuilder("ensureService mConnecting: ");
            sb.append(this.e.get());
            sb.append(" mIsBindSuccess:");
            sb.append(this.f.get());
            sb.append(" mAnalytics: ");
            sb.append(this.d == null ? 0 : 1);
            q.a("ServiceConnectManager", sb.toString());
            return;
        }
        c();
    }

    private void c() {
        if (this.h) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.miui.analytics", "com.miui.analytics.onetrack.OneTrackService");
                this.i.bindService(intent, this.l, 1);
                this.e.set(true);
                q.a("ServiceConnectManager", "bindService:  mConnecting: " + this.e);
            } catch (Exception e2) {
                q.b("ServiceConnectManager", "bindService: " + e2.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            if (this.h && this.f.get()) {
                this.i.unbindService(this.l);
                this.f.set(false);
                q.a("ServiceConnectManager", "unBindService  mIsBindSuccess:" + this.f.get());
            }
        } catch (Exception e2) {
            q.a("ServiceConnectManager", "unBindService: " + e2.toString());
        }
    }

    private boolean e() {
        List<ResolveInfo> queryIntentServices;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.miui.analytics", "com.miui.analytics.onetrack.OneTrackService");
            if (this.i == null || this.i.getPackageManager() == null || (queryIntentServices = this.i.getPackageManager().queryIntentServices(intent, 0)) == null || queryIntentServices.size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            Log.d("ServiceConnectManager", "isServiceOnline: " + e2.toString());
        }
    }

    public void a(b bVar) {
        if (!this.m.contains(bVar)) {
            this.m.add(bVar);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Iterator<b> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(int i2) {
        if (i2 == 2) {
            this.k.sendEmptyMessageDelayed(1, 5000);
        } else if (this.k.hasMessages(1)) {
            this.k.removeMessages(1);
        }
    }

    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                ai.this.d();
            }
        }
    }
}
