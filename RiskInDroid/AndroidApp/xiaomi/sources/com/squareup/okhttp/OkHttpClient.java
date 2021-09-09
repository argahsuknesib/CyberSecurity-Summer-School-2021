package com.squareup.okhttp;

import _m_j.jay;
import _m_j.jaz;
import com.google.android.exoplayer2.C;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class OkHttpClient implements Cloneable {
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    private static SSLSocketFactory defaultSslSocketFactory;
    private Authenticator authenticator;
    private Cache cache;
    private CertificatePinner certificatePinner;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private List<ConnectionSpec> connectionSpecs;
    private CookieHandler cookieHandler;
    private Dispatcher dispatcher;
    private Dns dns;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private InternalCache internalCache;
    private final List<Interceptor> networkInterceptors;
    private List<Protocol> protocols;
    private Proxy proxy;
    private ProxySelector proxySelector;
    private int readTimeout;
    private boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private int writeTimeout;

    static {
        Internal.instance = new Internal() {
            /* class com.squareup.okhttp.OkHttpClient.AnonymousClass1 */

            public final Transport newTransport(Connection connection, HttpEngine httpEngine) throws IOException {
                return connection.newTransport(httpEngine);
            }

            public final boolean clearOwner(Connection connection) {
                return connection.clearOwner();
            }

            public final void closeIfOwnedBy(Connection connection, Object obj) throws IOException {
                connection.closeIfOwnedBy(obj);
            }

            public final int recycleCount(Connection connection) {
                return connection.recycleCount();
            }

            public final void setOwner(Connection connection, HttpEngine httpEngine) {
                connection.setOwner(httpEngine);
            }

            public final boolean isReadable(Connection connection) {
                return connection.isReadable();
            }

            public final void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            public final void addLenient(Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }

            public final void setCache(OkHttpClient okHttpClient, InternalCache internalCache) {
                okHttpClient.setInternalCache(internalCache);
            }

            public final InternalCache internalCache(OkHttpClient okHttpClient) {
                return okHttpClient.internalCache();
            }

            public final void recycle(ConnectionPool connectionPool, Connection connection) {
                connectionPool.recycle(connection);
            }

            public final RouteDatabase routeDatabase(OkHttpClient okHttpClient) {
                return okHttpClient.routeDatabase();
            }

            public final void connectAndSetOwner(OkHttpClient okHttpClient, Connection connection, HttpEngine httpEngine) throws RouteException {
                connection.connectAndSetOwner(okHttpClient, httpEngine);
            }

            public final void callEnqueue(Call call, Callback callback, boolean z) {
                call.enqueue(callback, z);
            }

            public final void callEngineReleaseConnection(Call call) throws IOException {
                call.engine.releaseConnection();
            }

            public final Connection callEngineGetConnection(Call call) {
                return call.engine.getConnection();
            }

            public final jaz connectionRawSource(Connection connection) {
                return connection.rawSource();
            }

            public final jay connectionRawSink(Connection connection) {
                return connection.rawSink();
            }

            public final void connectionSetOwner(Connection connection, Object obj) {
                connection.setOwner(obj);
            }

            public final void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.apply(sSLSocket, z);
            }

            public final HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
                return HttpUrl.getChecked(str);
            }
        };
    }

    public OkHttpClient() {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.connectTimeout = C.MSG_CUSTOM_BASE;
        this.readTimeout = C.MSG_CUSTOM_BASE;
        this.writeTimeout = C.MSG_CUSTOM_BASE;
        this.routeDatabase = new RouteDatabase();
        this.dispatcher = new Dispatcher();
    }

    private OkHttpClient(OkHttpClient okHttpClient) {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.connectTimeout = C.MSG_CUSTOM_BASE;
        this.readTimeout = C.MSG_CUSTOM_BASE;
        this.writeTimeout = C.MSG_CUSTOM_BASE;
        this.routeDatabase = okHttpClient.routeDatabase;
        this.dispatcher = okHttpClient.dispatcher;
        this.proxy = okHttpClient.proxy;
        this.protocols = okHttpClient.protocols;
        this.connectionSpecs = okHttpClient.connectionSpecs;
        this.interceptors.addAll(okHttpClient.interceptors);
        this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
        this.proxySelector = okHttpClient.proxySelector;
        this.cookieHandler = okHttpClient.cookieHandler;
        this.cache = okHttpClient.cache;
        Cache cache2 = this.cache;
        this.internalCache = cache2 != null ? cache2.internalCache : okHttpClient.internalCache;
        this.socketFactory = okHttpClient.socketFactory;
        this.sslSocketFactory = okHttpClient.sslSocketFactory;
        this.hostnameVerifier = okHttpClient.hostnameVerifier;
        this.certificatePinner = okHttpClient.certificatePinner;
        this.authenticator = okHttpClient.authenticator;
        this.connectionPool = okHttpClient.connectionPool;
        this.dns = okHttpClient.dns;
        this.followSslRedirects = okHttpClient.followSslRedirects;
        this.followRedirects = okHttpClient.followRedirects;
        this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
        this.connectTimeout = okHttpClient.connectTimeout;
        this.readTimeout = okHttpClient.readTimeout;
        this.writeTimeout = okHttpClient.writeTimeout;
    }

    public void setConnectTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (millis != 0 || j <= 0) {
                this.connectTimeout = (int) millis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setReadTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (millis != 0 || j <= 0) {
                this.readTimeout = (int) millis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setWriteTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (millis != 0 || j <= 0) {
                this.writeTimeout = (int) millis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        } else {
            throw new IllegalArgumentException("unit == null");
        }
    }

    public int getWriteTimeout() {
        return this.writeTimeout;
    }

    public OkHttpClient setProxy(Proxy proxy2) {
        this.proxy = proxy2;
        return this;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public OkHttpClient setProxySelector(ProxySelector proxySelector2) {
        this.proxySelector = proxySelector2;
        return this;
    }

    public ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public OkHttpClient setCookieHandler(CookieHandler cookieHandler2) {
        this.cookieHandler = cookieHandler2;
        return this;
    }

    public CookieHandler getCookieHandler() {
        return this.cookieHandler;
    }

    /* access modifiers changed from: package-private */
    public void setInternalCache(InternalCache internalCache2) {
        this.internalCache = internalCache2;
        this.cache = null;
    }

    /* access modifiers changed from: package-private */
    public InternalCache internalCache() {
        return this.internalCache;
    }

    public OkHttpClient setCache(Cache cache2) {
        this.cache = cache2;
        this.internalCache = null;
        return this;
    }

    public Cache getCache() {
        return this.cache;
    }

    public OkHttpClient setDns(Dns dns2) {
        this.dns = dns2;
        return this;
    }

    public Dns getDns() {
        return this.dns;
    }

    public OkHttpClient setSocketFactory(SocketFactory socketFactory2) {
        this.socketFactory = socketFactory2;
        return this;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public OkHttpClient setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        return this;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public OkHttpClient setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
        return this;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public OkHttpClient setCertificatePinner(CertificatePinner certificatePinner2) {
        this.certificatePinner = certificatePinner2;
        return this;
    }

    public CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public OkHttpClient setAuthenticator(Authenticator authenticator2) {
        this.authenticator = authenticator2;
        return this;
    }

    public Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public OkHttpClient setConnectionPool(ConnectionPool connectionPool2) {
        this.connectionPool = connectionPool2;
        return this;
    }

    public ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public OkHttpClient setFollowSslRedirects(boolean z) {
        this.followSslRedirects = z;
        return this;
    }

    public boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public void setRetryOnConnectionFailure(boolean z) {
        this.retryOnConnectionFailure = z;
    }

    public boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* access modifiers changed from: package-private */
    public RouteDatabase routeDatabase() {
        return this.routeDatabase;
    }

    public OkHttpClient setDispatcher(Dispatcher dispatcher2) {
        if (dispatcher2 != null) {
            this.dispatcher = dispatcher2;
            return this;
        }
        throw new IllegalArgumentException("dispatcher == null");
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public OkHttpClient setProtocols(List<Protocol> list) {
        List immutableList = Util.immutableList(list);
        if (!immutableList.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(immutableList)));
        } else if (immutableList.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(immutableList)));
        } else if (!immutableList.contains(null)) {
            this.protocols = Util.immutableList(immutableList);
            return this;
        } else {
            throw new IllegalArgumentException("protocols must not contain null");
        }
    }

    public List<Protocol> getProtocols() {
        return this.protocols;
    }

    public OkHttpClient setConnectionSpecs(List<ConnectionSpec> list) {
        this.connectionSpecs = Util.immutableList(list);
        return this;
    }

    public List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Call newCall(Request request) {
        return new Call(this, request);
    }

    public OkHttpClient cancel(Object obj) {
        getDispatcher().cancel(obj);
        return this;
    }

    /* access modifiers changed from: package-private */
    public OkHttpClient copyWithDefaults() {
        OkHttpClient okHttpClient = new OkHttpClient(this);
        if (okHttpClient.proxySelector == null) {
            okHttpClient.proxySelector = ProxySelector.getDefault();
        }
        if (okHttpClient.cookieHandler == null) {
            okHttpClient.cookieHandler = CookieHandler.getDefault();
        }
        if (okHttpClient.socketFactory == null) {
            okHttpClient.socketFactory = SocketFactory.getDefault();
        }
        if (okHttpClient.sslSocketFactory == null) {
            okHttpClient.sslSocketFactory = getDefaultSSLSocketFactory();
        }
        if (okHttpClient.hostnameVerifier == null) {
            okHttpClient.hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (okHttpClient.certificatePinner == null) {
            okHttpClient.certificatePinner = CertificatePinner.DEFAULT;
        }
        if (okHttpClient.authenticator == null) {
            okHttpClient.authenticator = AuthenticatorAdapter.INSTANCE;
        }
        if (okHttpClient.connectionPool == null) {
            okHttpClient.connectionPool = ConnectionPool.getDefault();
        }
        if (okHttpClient.protocols == null) {
            okHttpClient.protocols = DEFAULT_PROTOCOLS;
        }
        if (okHttpClient.connectionSpecs == null) {
            okHttpClient.connectionSpecs = DEFAULT_CONNECTION_SPECS;
        }
        if (okHttpClient.dns == null) {
            okHttpClient.dns = Dns.SYSTEM;
        }
        return okHttpClient;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    private synchronized SSLSocketFactory getDefaultSSLSocketFactory() {
        if (defaultSslSocketFactory == null) {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, null, null);
            defaultSslSocketFactory = instance.getSocketFactory();
            throw new AssertionError();
        }
        return defaultSslSocketFactory;
    }

    public OkHttpClient clone() {
        return new OkHttpClient(this);
    }
}
