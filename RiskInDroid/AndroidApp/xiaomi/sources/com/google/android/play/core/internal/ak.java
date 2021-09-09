package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ak<T extends IInterface> {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Handler> f3750a = new HashMap();
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public final aa c;
    private final String d;
    /* access modifiers changed from: private */
    public final List<ab> e = new ArrayList();
    /* access modifiers changed from: private */
    public boolean f;
    private final Intent g;
    /* access modifiers changed from: private */
    public final ag<T> h;
    private final WeakReference<af> i;
    private final IBinder.DeathRecipient j = new ac(this);
    /* access modifiers changed from: private */
    public ServiceConnection k;
    /* access modifiers changed from: private */
    public T l;

    public ak(Context context, aa aaVar, String str, Intent intent, ag<T> agVar) {
        this.b = context;
        this.c = aaVar;
        this.d = str;
        this.g = intent;
        this.h = agVar;
        this.i = new WeakReference<>(null);
    }

    static /* synthetic */ void a(ak akVar, ab abVar) {
        if (akVar.l == null && !akVar.f) {
            akVar.c.c("Initiate binding to the service.", new Object[0]);
            akVar.e.add(abVar);
            akVar.k = new aj(akVar);
            akVar.f = true;
            if (!akVar.b.bindService(akVar.g, akVar.k, 1)) {
                akVar.c.c("Failed to bind to the service.", new Object[0]);
                akVar.f = false;
                List<ab> list = akVar.e;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    i<?> b2 = list.get(i2).b();
                    if (b2 != null) {
                        b2.b((Exception) new al());
                    }
                }
                akVar.e.clear();
            }
        } else if (akVar.f) {
            akVar.c.c("Waiting to bind to the service.", new Object[0]);
            akVar.e.add(abVar);
        } else {
            abVar.run();
        }
    }

    /* access modifiers changed from: private */
    public final void b(ab abVar) {
        Handler handler;
        synchronized (f3750a) {
            if (!f3750a.containsKey(this.d)) {
                HandlerThread handlerThread = new HandlerThread(this.d, 10);
                handlerThread.start();
                f3750a.put(this.d, new Handler(handlerThread.getLooper()));
            }
            handler = f3750a.get(this.d);
        }
        handler.post(abVar);
    }

    static /* synthetic */ void f(ak akVar) {
        akVar.c.c("linkToDeath", new Object[0]);
        try {
            akVar.l.asBinder().linkToDeath(akVar.j, 0);
        } catch (RemoteException e2) {
            akVar.c.a(e2, "linkToDeath failed", new Object[0]);
        }
    }

    static /* synthetic */ void h(ak akVar) {
        akVar.c.c("unlinkToDeath", new Object[0]);
        akVar.l.asBinder().unlinkToDeath(akVar.j, 0);
    }

    public final void a() {
        b(new ae(this));
    }

    public final void a(ab abVar) {
        b(new ad(this, abVar.b(), abVar));
    }

    public final T b() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.c.c("reportBinderDeath", new Object[0]);
        af afVar = this.i.get();
        if (afVar == null) {
            this.c.c("%s : Binder has died.", this.d);
            List<ab> list = this.e;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                i<?> b2 = list.get(i2).b();
                if (b2 != null) {
                    b2.b((Exception) (Build.VERSION.SDK_INT < 15 ? new RemoteException() : new RemoteException(String.valueOf(this.d).concat(" : Binder has died."))));
                }
            }
            this.e.clear();
            return;
        }
        this.c.c("calling onBinderDied", new Object[0]);
        afVar.a();
    }
}
