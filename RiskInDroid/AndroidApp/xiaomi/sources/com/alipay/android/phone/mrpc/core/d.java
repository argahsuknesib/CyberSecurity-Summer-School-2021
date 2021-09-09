package com.alipay.android.phone.mrpc.core;

import com.alipay.android.phone.mrpc.core.b;
import org.apache.http.client.RedirectHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

final class d extends DefaultHttpClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3134a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d(b bVar, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
        this.f3134a = bVar;
    }

    /* access modifiers changed from: protected */
    public final ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new f(this);
    }

    /* access modifiers changed from: protected */
    public final HttpContext createHttpContext() {
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return basicHttpContext;
    }

    /* access modifiers changed from: protected */
    public final BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor createHttpProcessor = d.super.createHttpProcessor();
        createHttpProcessor.addRequestInterceptor(b.c);
        createHttpProcessor.addRequestInterceptor(new b.a(this.f3134a, (byte) 0));
        return createHttpProcessor;
    }

    /* access modifiers changed from: protected */
    public final RedirectHandler createRedirectHandler() {
        return new e(this);
    }
}
