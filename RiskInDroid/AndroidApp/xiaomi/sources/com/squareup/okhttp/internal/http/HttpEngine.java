package com.squareup.okhttp.internal.http;

import _m_j.jax;
import _m_j.jay;
import _m_j.jaz;
import _m_j.jbe;
import _m_j.jbg;
import _m_j.jbm;
import _m_j.jbn;
import _m_j.jbo;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        /* class com.squareup.okhttp.internal.http.HttpEngine.AnonymousClass1 */

        public final long contentLength() {
            return 0;
        }

        public final MediaType contentType() {
            return null;
        }

        public final jaz source() {
            return new jax();
        }
    };
    private Address address;
    public final boolean bufferRequestBody;
    private jay bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    public Connection connection;
    private final boolean forWebSocket;
    public Request networkRequest;
    private final Response priorResponse;
    private jbm requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    public Transport transport;
    private final Request userRequest;
    private Response userResponse;

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, Connection connection2, RouteSelector routeSelector2, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.connection = connection2;
        this.routeSelector = routeSelector2;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
        if (connection2 != null) {
            Internal.instance.setOwner(connection2, this);
            this.route = connection2.getRoute();
            return;
        }
        this.route = null;
    }

    public final void sendRequest() throws RequestException, RouteException, IOException {
        if (this.cacheStrategy == null) {
            if (this.transport == null) {
                Request networkRequest2 = networkRequest(this.userRequest);
                InternalCache internalCache = Internal.instance.internalCache(this.client);
                Response response = internalCache != null ? internalCache.get(networkRequest2) : null;
                this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), networkRequest2, response).get();
                this.networkRequest = this.cacheStrategy.networkRequest;
                this.cacheResponse = this.cacheStrategy.cacheResponse;
                if (internalCache != null) {
                    internalCache.trackResponse(this.cacheStrategy);
                }
                if (response != null && this.cacheResponse == null) {
                    Util.closeQuietly(response.body());
                }
                if (this.networkRequest != null) {
                    if (this.connection == null) {
                        connect();
                    }
                    this.transport = Internal.instance.newTransport(this.connection, this);
                    if (this.callerWritesRequestBody && permitsRequestBody(this.networkRequest) && this.requestBodyOut == null) {
                        long contentLength = OkHeaders.contentLength(networkRequest2);
                        if (!this.bufferRequestBody) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, contentLength);
                        } else if (contentLength > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (contentLength != -1) {
                            this.transport.writeRequestHeaders(this.networkRequest);
                            this.requestBodyOut = new RetryableSink((int) contentLength);
                        } else {
                            this.requestBodyOut = new RetryableSink();
                        }
                    }
                } else {
                    if (this.connection != null) {
                        Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
                        this.connection = null;
                    }
                    Response response2 = this.cacheResponse;
                    if (response2 != null) {
                        this.userResponse = response2.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
                    } else {
                        this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
                    }
                    this.userResponse = unzip(this.userResponse);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private void connect() throws RequestException, RouteException {
        if (this.connection == null) {
            if (this.routeSelector == null) {
                this.address = createAddress(this.client, this.networkRequest);
                try {
                    this.routeSelector = RouteSelector.get(this.address, this.networkRequest, this.client);
                } catch (IOException e) {
                    throw new RequestException(e);
                }
            }
            this.connection = createNextConnection();
            Internal.instance.connectAndSetOwner(this.client, this.connection, this);
            this.route = this.connection.getRoute();
            return;
        }
        throw new IllegalStateException();
    }

    private Connection createNextConnection() throws RouteException {
        Connection connection2;
        ConnectionPool connectionPool = this.client.getConnectionPool();
        while (true) {
            connection2 = connectionPool.get(this.address);
            if (connection2 == null) {
                try {
                    return new Connection(connectionPool, this.routeSelector.next());
                } catch (IOException e) {
                    throw new RouteException(e);
                }
            } else if (this.networkRequest.method().equals("GET") || Internal.instance.isReadable(connection2)) {
                return connection2;
            } else {
                Util.closeQuietly(connection2.getSocket());
            }
        }
        return connection2;
    }

    public final void writingRequestHeaders() {
        if (this.sentRequestMillis == -1) {
            this.sentRequestMillis = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public final boolean permitsRequestBody(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    public final jbm getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public final jay getBufferedRequestBody() {
        jay jay = this.bufferedRequestBody;
        if (jay != null) {
            return jay;
        }
        jbm requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        jay O000000o2 = jbg.O000000o(requestBody);
        this.bufferedRequestBody = O000000o2;
        return O000000o2;
    }

    public final boolean hasResponse() {
        return this.userResponse != null;
    }

    public final Request getRequest() {
        return this.userRequest;
    }

    public final Response getResponse() {
        Response response = this.userResponse;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public final Connection getConnection() {
        return this.connection;
    }

    public final HttpEngine recover(RouteException routeException) {
        RouteSelector routeSelector2 = this.routeSelector;
        if (!(routeSelector2 == null || this.connection == null)) {
            connectFailed(routeSelector2, routeException.getLastConnectException());
        }
        if (this.routeSelector == null && this.connection == null) {
            return null;
        }
        RouteSelector routeSelector3 = this.routeSelector;
        if ((routeSelector3 != null && !routeSelector3.hasNext()) || !isRecoverable(routeException)) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) this.requestBodyOut, this.priorResponse);
    }

    private boolean isRecoverable(RouteException routeException) {
        if (!this.client.getRetryOnConnectionFailure()) {
            return false;
        }
        IOException lastConnectException = routeException.getLastConnectException();
        if (lastConnectException instanceof ProtocolException) {
            return false;
        }
        if (lastConnectException instanceof InterruptedIOException) {
            return lastConnectException instanceof SocketTimeoutException;
        }
        if ((!(lastConnectException instanceof SSLHandshakeException) || !(lastConnectException.getCause() instanceof CertificateException)) && !(lastConnectException instanceof SSLPeerUnverifiedException)) {
            return true;
        }
        return false;
    }

    public final HttpEngine recover(IOException iOException, jbm jbm) {
        RouteSelector routeSelector2 = this.routeSelector;
        if (!(routeSelector2 == null || this.connection == null)) {
            connectFailed(routeSelector2, iOException);
        }
        boolean z = jbm == null || (jbm instanceof RetryableSink);
        if (this.routeSelector == null && this.connection == null) {
            return null;
        }
        RouteSelector routeSelector3 = this.routeSelector;
        if ((routeSelector3 != null && !routeSelector3.hasNext()) || !isRecoverable(iOException) || !z) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) jbm, this.priorResponse);
    }

    private void connectFailed(RouteSelector routeSelector2, IOException iOException) {
        if (Internal.instance.recycleCount(this.connection) <= 0) {
            routeSelector2.connectFailed(this.connection.getRoute(), iOException);
        }
    }

    public final HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }

    private boolean isRecoverable(IOException iOException) {
        if (this.client.getRetryOnConnectionFailure() && !(iOException instanceof ProtocolException) && !(iOException instanceof InterruptedIOException)) {
            return true;
        }
        return false;
    }

    public final Route getRoute() {
        return this.route;
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = internalCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                } catch (IOException unused) {
                }
            }
        }
    }

    public final void releaseConnection() throws IOException {
        Transport transport2 = this.transport;
        if (!(transport2 == null || this.connection == null)) {
            transport2.releaseConnectionOnIdle();
        }
        this.connection = null;
    }

    public final void disconnect() {
        try {
            if (this.transport != null) {
                this.transport.disconnect(this);
                return;
            }
            Connection connection2 = this.connection;
            if (connection2 != null) {
                Internal.instance.closeIfOwnedBy(connection2, this);
            }
        } catch (IOException unused) {
        }
    }

    public final Connection close() {
        jay jay = this.bufferedRequestBody;
        if (jay != null) {
            Util.closeQuietly(jay);
        } else {
            jbm jbm = this.requestBodyOut;
            if (jbm != null) {
                Util.closeQuietly(jbm);
            }
        }
        Response response = this.userResponse;
        if (response == null) {
            Connection connection2 = this.connection;
            if (connection2 != null) {
                Util.closeQuietly(connection2.getSocket());
            }
            this.connection = null;
            return null;
        }
        Util.closeQuietly(response.body());
        Transport transport2 = this.transport;
        if (transport2 == null || this.connection == null || transport2.canReuseConnection()) {
            if (this.connection != null && !Internal.instance.clearOwner(this.connection)) {
                this.connection = null;
            }
            Connection connection3 = this.connection;
            this.connection = null;
            return connection3;
        }
        Util.closeQuietly(this.connection.getSocket());
        this.connection = null;
        return null;
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        jbe jbe = new jbe(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, jbg.O000000o(jbe))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.httpUrl()));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), null)));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    public final void readResponse() throws IOException {
        Response response;
        Response response2;
        if (this.userResponse == null) {
            if (this.networkRequest == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            }
            Request request = this.networkRequest;
            if (request != null) {
                if (this.forWebSocket) {
                    this.transport.writeRequestHeaders(request);
                } else if (!this.callerWritesRequestBody) {
                    response = new NetworkInterceptorChain(0, request).proceed(this.networkRequest);
                    receiveHeaders(response.headers());
                    response2 = this.cacheResponse;
                    if (response2 != null) {
                        if (validate(response2, response)) {
                            this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), response.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                            response.body().close();
                            releaseConnection();
                            InternalCache internalCache = Internal.instance.internalCache(this.client);
                            internalCache.trackConditionalCacheHit();
                            internalCache.update(this.cacheResponse, stripBody(this.userResponse));
                            this.userResponse = unzip(this.userResponse);
                            return;
                        }
                        Util.closeQuietly(this.cacheResponse.body());
                    }
                    this.userResponse = response.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                    if (!hasBody(this.userResponse)) {
                        maybeCache();
                        this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                        return;
                    }
                    return;
                } else {
                    jay jay = this.bufferedRequestBody;
                    if (jay != null && jay.O000000o().O00000Oo > 0) {
                        this.bufferedRequestBody.O00000o0();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1) {
                            jbm jbm = this.requestBodyOut;
                            if (jbm instanceof RetryableSink) {
                                this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(((RetryableSink) jbm).contentLength())).build();
                            }
                        }
                        this.transport.writeRequestHeaders(this.networkRequest);
                    }
                    jbm jbm2 = this.requestBodyOut;
                    if (jbm2 != null) {
                        jay jay2 = this.bufferedRequestBody;
                        if (jay2 != null) {
                            jay2.close();
                        } else {
                            jbm2.close();
                        }
                        jbm jbm3 = this.requestBodyOut;
                        if (jbm3 instanceof RetryableSink) {
                            this.transport.writeRequestBody((RetryableSink) jbm3);
                        }
                    }
                }
                response = readNetworkResponse();
                receiveHeaders(response.headers());
                response2 = this.cacheResponse;
                if (response2 != null) {
                }
                this.userResponse = response.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(response)).build();
                if (!hasBody(this.userResponse)) {
                }
            }
        }
    }

    class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request2) {
            this.index = i;
            this.request = request2;
        }

        public Connection connection() {
            return HttpEngine.this.connection;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request2) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request2.httpUrl().host().equals(address.getUriHost()) || request2.httpUrl().port() != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request2);
                Interceptor interceptor2 = HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor2.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
                }
            } else {
                HttpEngine.this.transport.writeRequestHeaders(request2);
                HttpEngine httpEngine = HttpEngine.this;
                httpEngine.networkRequest = request2;
                if (httpEngine.permitsRequestBody(request2) && request2.body() != null) {
                    jay O000000o2 = jbg.O000000o(HttpEngine.this.transport.createRequestBody(request2, request2.body().contentLength()));
                    request2.body().writeTo(O000000o2);
                    O000000o2.close();
                }
                Response readNetworkResponse = HttpEngine.this.readNetworkResponse();
                int code = readNetworkResponse.code();
                if ((code != 204 && code != 205) || readNetworkResponse.body().contentLength() <= 0) {
                    return readNetworkResponse;
                }
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + readNetworkResponse.body().contentLength());
            }
        }
    }

    public final Response readNetworkResponse() throws IOException {
        this.transport.finishRequest();
        Response build = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        return !this.forWebSocket ? build.newBuilder().body(this.transport.openResponseBody(build)).build() : build;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        jbm body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final jaz source = response.body().source();
        final jay O000000o2 = jbg.O000000o(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), jbg.O000000o(new jbn() {
            /* class com.squareup.okhttp.internal.http.HttpEngine.AnonymousClass2 */
            boolean cacheRequestClosed;

            public long read(jax jax, long j) throws IOException {
                try {
                    long read = source.read(jax, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            O000000o2.close();
                        }
                        return -1;
                    }
                    jax.O000000o(O000000o2.O000000o(), jax.O00000Oo - read, read);
                    O000000o2.O0000ooo();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public jbo timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    private static boolean validate(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        if (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) {
            return false;
        }
        return true;
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    public final void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, null));
        }
    }

    public final Request followUpRequest() throws IOException {
        Proxy proxy;
        String header;
        HttpUrl resolve;
        if (this.userResponse != null) {
            if (getRoute() != null) {
                proxy = getRoute().getProxy();
            } else {
                proxy = this.client.getProxy();
            }
            int code = this.userResponse.code();
            if (code != 307 && code != 308) {
                if (code != 401) {
                    if (code != 407) {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (proxy.type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                }
                return OkHeaders.processAuthHeader(this.client.getAuthenticator(), this.userResponse, proxy);
            } else if (!this.userRequest.method().equals("GET") && !this.userRequest.method().equals("HEAD")) {
                return null;
            }
            if (!this.client.getFollowRedirects() || (header = this.userResponse.header("Location")) == null || (resolve = this.userRequest.httpUrl().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(this.userRequest.httpUrl().scheme()) && !this.client.getFollowSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = this.userRequest.newBuilder();
            if (HttpMethod.permitsRequestBody(this.userRequest.method())) {
                newBuilder.method("GET", null);
                newBuilder.removeHeader("Transfer-Encoding");
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
            if (!sameConnection(resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    public final boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.userRequest.httpUrl();
        return httpUrl2.host().equals(httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals(httpUrl.scheme());
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (request.isHttps()) {
            SSLSocketFactory sslSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(request.httpUrl().host(), request.httpUrl().port(), okHttpClient.getDns(), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }
}
