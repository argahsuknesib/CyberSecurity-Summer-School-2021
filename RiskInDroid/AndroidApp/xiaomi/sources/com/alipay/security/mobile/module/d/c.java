package com.alipay.security.mobile.module.d;

final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3240a;

    c(b bVar) {
        this.f3240a = bVar;
    }

    public final void run() {
        try {
            this.f3240a.b();
        } catch (Exception e) {
            d.a(e);
        }
    }
}
