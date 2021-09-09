package com.miui.tsmclient.model;

import android.content.Context;
import android.content.ServiceConnection;
import com.miui.tsmclient.util.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    protected AtomicBoolean f3873a;
    protected boolean b;
    protected Context c;

    public void a() {
        b();
    }

    /* access modifiers changed from: protected */
    public synchronized void b() {
        if (this.f3873a.get()) {
            LogUtils.d("BaseAppTask: unbind service");
            c();
            this.f3873a.set(false);
        }
        this.b = true;
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.c.unbindService(this);
    }
}
