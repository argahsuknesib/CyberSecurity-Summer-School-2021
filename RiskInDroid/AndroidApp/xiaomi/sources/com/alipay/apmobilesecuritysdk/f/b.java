package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f3159a = new b();
    /* access modifiers changed from: private */
    public Thread b = null;
    /* access modifiers changed from: private */
    public LinkedList<Runnable> c = new LinkedList<>();

    public static b a() {
        return f3159a;
    }

    public final synchronized void a(Runnable runnable) {
        this.c.add(runnable);
        if (this.b == null) {
            this.b = new Thread(new c(this));
            this.b.start();
        }
    }
}
