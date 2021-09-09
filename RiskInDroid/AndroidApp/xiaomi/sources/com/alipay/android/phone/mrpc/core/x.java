package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private g f3148a;
    private z b = new z(this);

    public x(g gVar) {
        this.f3148a = gVar;
    }

    public final g a() {
        return this.f3148a;
    }

    public final <T> T a(Class<T> cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f3148a, cls, this.b));
    }
}
