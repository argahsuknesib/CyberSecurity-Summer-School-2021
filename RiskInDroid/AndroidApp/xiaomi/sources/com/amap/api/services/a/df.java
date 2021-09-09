package com.amap.api.services.a;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

public abstract class df {
    int f = 20000;
    int g = 20000;
    Proxy h = null;

    public abstract Map<String, String> d();

    public abstract Map<String, String> e();

    public byte[] h() {
        return null;
    }

    public abstract String i();

    /* access modifiers changed from: protected */
    public String n() {
        return "";
    }

    public boolean p() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public String m() {
        byte[] h2 = h();
        if (h2 == null || h2.length == 0) {
            return i();
        }
        Map<String, String> d = d();
        if (d == null) {
            return i();
        }
        String a2 = dd.a(d);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i());
        stringBuffer.append("?");
        stringBuffer.append(a2);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return !TextUtils.isEmpty(n());
    }

    /* access modifiers changed from: package-private */
    public byte[] q() {
        byte[] h2 = h();
        if (h2 != null && h2.length != 0) {
            return h2;
        }
        String a2 = dd.a(d());
        return !TextUtils.isEmpty(a2) ? bz.a(a2) : h2;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void b(int i) {
        this.g = i;
    }

    public final void a(Proxy proxy) {
        this.h = proxy;
    }
}
