package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

public abstract class a implements v {

    /* renamed from: a  reason: collision with root package name */
    protected Method f3126a;
    protected byte[] b;
    protected String c;
    protected int d;
    protected String e;
    protected boolean f;

    public a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.f3126a = method;
        this.d = i;
        this.c = str;
        this.b = bArr;
        this.e = str2;
        this.f = z;
    }
}
