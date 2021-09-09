package com.hzy.tvmao.model.legacy.api;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class d implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f4431a;

    d(c cVar) {
        this.f4431a = cVar;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        return c.i.isEmpty() || c.i.contains(str);
    }
}
