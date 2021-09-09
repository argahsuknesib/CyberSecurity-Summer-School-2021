package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    protected g f3149a;
    protected Class<?> b;
    protected z c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f3149a = gVar;
        this.b = cls;
        this.c = zVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.c.a(method, objArr);
    }
}
