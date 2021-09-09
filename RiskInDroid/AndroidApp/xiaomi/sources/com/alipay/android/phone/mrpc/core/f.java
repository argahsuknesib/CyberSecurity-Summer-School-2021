package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class f implements ConnectionKeepAliveStrategy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f3136a;

    f(d dVar) {
        this.f3136a = dVar;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000;
    }
}
