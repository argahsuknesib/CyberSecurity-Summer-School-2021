package okhttp3.internal.connection;

import _m_j.jay;
import _m_j.jaz;
import _m_j.jbg;
import _m_j.jbn;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private jay sink;
    private Socket socket;
    private jaz source;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool2, Route route2) {
        this.connectionPool = connectionPool2;
        this.route = route2;
    }

    public static RealConnection testConnection(ConnectionPool connectionPool2, Route route2, Socket socket2, long j) {
        RealConnection realConnection = new RealConnection(connectionPool2, route2);
        realConnection.socket = socket2;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008d A[Catch:{ IOException -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0133  */
    public final void connect(int i, int i2, int i3, int i4, boolean z, Call call, EventListener eventListener) {
        Call call2 = call;
        EventListener eventListener2 = eventListener;
        if (this.protocol == null) {
            List<ConnectionSpec> connectionSpecs = this.route.address().connectionSpecs();
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
            if (this.route.address().sslSocketFactory() == null) {
                if (connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                    String host = this.route.address().url().host();
                    if (!Platform.get().isCleartextTrafficPermitted(host)) {
                        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
                    }
                } else {
                    throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
                throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            RouteException routeException = null;
            do {
                try {
                    if (!this.route.requiresTunnel()) {
                        connectTunnel(i, i2, i3, call, eventListener);
                        if (this.rawSocket == null) {
                            if (!this.route.requiresTunnel() && this.rawSocket == null) {
                                throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                            } else if (this.http2Connection != null) {
                                synchronized (this.connectionPool) {
                                    this.allocationLimit = this.http2Connection.maxConcurrentStreams();
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        try {
                            connectSocket(i, i2, call2, eventListener2);
                        } catch (IOException e) {
                            e = e;
                            Util.closeQuietly(this.socket);
                            Util.closeQuietly(this.rawSocket);
                            this.socket = null;
                            this.rawSocket = null;
                            this.source = null;
                            this.sink = null;
                            this.handshake = null;
                            this.protocol = null;
                            this.http2Connection = null;
                            eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                            if (routeException != null) {
                            }
                            throw routeException;
                        }
                    }
                    try {
                        establishProtocol(connectionSpecSelector, i4, call2, eventListener2);
                        eventListener2.connectEnd(call2, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        if (!this.route.requiresTunnel()) {
                        }
                        if (this.http2Connection != null) {
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    Util.closeQuietly(this.socket);
                    Util.closeQuietly(this.rawSocket);
                    this.socket = null;
                    this.rawSocket = null;
                    this.source = null;
                    this.sink = null;
                    this.handshake = null;
                    this.protocol = null;
                    this.http2Connection = null;
                    eventListener.connectFailed(call, this.route.socketAddress(), this.route.proxy(), null, e);
                    if (routeException != null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.addConnectException(e);
                    }
                    if (!z || connectionSpecSelector.connectionFailed(e)) {
                        throw routeException;
                    }
                    do {
                        if (!this.route.requiresTunnel()) {
                        }
                        establishProtocol(connectionSpecSelector, i4, call2, eventListener2);
                        eventListener2.connectEnd(call2, this.route.socketAddress(), this.route.proxy(), this.protocol);
                        if (!this.route.requiresTunnel()) {
                        }
                        if (this.http2Connection != null) {
                        }
                    } while (connectionSpecSelector.connectionFailed(e));
                    throw routeException;
                }
            } while (connectionSpecSelector.connectionFailed(e));
            throw routeException;
        }
        throw new IllegalStateException("already connected");
    }

    private void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (i4 < 21) {
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
                i4++;
            } else {
                return;
            }
        }
    }

    private void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            try {
                this.source = jbg.O000000o(jbg.O00000Oo(this.rawSocket));
                this.sink = jbg.O000000o(jbg.O000000o(this.rawSocket));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol == Protocol.HTTP_2) {
                startHttp2(i);
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            startHttp2(i);
        } else {
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
    }

    private void startHttp2(int i) throws IOException {
        this.socket.setSoTimeout(0);
        this.http2Connection = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection.start();
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{javax.net.ssl.SSLSocketFactory.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket throws java.io.IOException}
     arg types: [java.net.Socket, java.lang.String, int, int]
     candidates:
      ClspMth{javax.net.SocketFactory.createSocket(java.lang.String, int, java.net.InetAddress, int):java.net.Socket throws java.io.IOException, java.net.UnknownHostException}
      ClspMth{javax.net.SocketFactory.createSocket(java.net.InetAddress, int, java.net.InetAddress, int):java.net.Socket throws java.io.IOException}
      ClspMth{javax.net.ssl.SSLSocketFactory.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket throws java.io.IOException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010e A[Catch:{ all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0114 A[Catch:{ all -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0117  */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void connectTls(ConnectionSpecSelector connectionSpecSelector) throws IOException {
        ? r1;
        Protocol protocol2;
        Address address = this.route.address();
        String str = null;
        try {
            ? r12 = (SSLSocket) address.sslSocketFactory().createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(r12);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(r12, address.url().host(), address.protocols());
                }
                r12.startHandshake();
                SSLSession session = r12.getSession();
                Handshake handshake2 = Handshake.get(session);
                if (address.hostnameVerifier().verify(address.url().host(), session)) {
                    address.certificatePinner().check(address.url().host(), handshake2.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(r12);
                    }
                    this.socket = r12;
                    this.source = jbg.O000000o(jbg.O00000Oo(this.socket));
                    this.sink = jbg.O000000o(jbg.O000000o(this.socket));
                    this.handshake = handshake2;
                    if (str != null) {
                        protocol2 = Protocol.get(str);
                    } else {
                        protocol2 = Protocol.HTTP_1_1;
                    }
                    this.protocol = protocol2;
                    if (r12 != 0) {
                        Platform.get().afterHandshake(r12);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) handshake2.peerCertificates().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
            } catch (AssertionError e) {
                e = e;
                str = r12;
                try {
                    if (!Util.isAndroidGetsocknameError(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    r1 = str;
                    if (r1 != 0) {
                        Platform.get().afterHandshake(r1);
                    }
                    Util.closeQuietly((Socket) r1);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = r12;
                if (r1 != 0) {
                }
                Util.closeQuietly((Socket) r1);
                throw th;
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!Util.isAndroidGetsocknameError(e)) {
            }
        }
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec(null, null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            jbn newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(build.header("Connection"))) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (this.source.O000000o().O00000o() && this.sink.O000000o().O00000o()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    public final boolean isEligible(Address address, Route route2) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || route2 == null || route2.proxy().type() != Proxy.Type.DIRECT || this.route.proxy().type() != Proxy.Type.DIRECT || !this.route.socketAddress().equals(route2.socketAddress()) || route2.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0))) {
            return false;
        }
        return true;
    }

    public final HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, http2Connection2);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.source, this.sink);
    }

    public final RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new RealWebSocket.Streams(true, this.source, this.sink) {
            /* class okhttp3.internal.connection.RealConnection.AnonymousClass1 */

            public void close() throws IOException {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.streamFinished(true, streamAllocation.codec(), -1, null);
            }
        };
    }

    public final Route route() {
        return this.route;
    }

    public final void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public final Socket socket() {
        return this.socket;
    }

    public final boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 == null) {
            if (z) {
                try {
                    soTimeout = this.socket.getSoTimeout();
                    this.socket.setSoTimeout(1);
                    if (this.source.O00000o()) {
                        this.socket.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.socket.setSoTimeout(soTimeout);
                    return true;
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                    return false;
                } catch (Throwable th) {
                    this.socket.setSoTimeout(soTimeout);
                    throw th;
                }
            }
            return true;
        } else if (!http2Connection2.isShutdown()) {
            return true;
        } else {
            return false;
        }
    }

    public final void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public final void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final boolean isMultiplexed() {
        return this.http2Connection != null;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        sb.append(handshake2 != null ? handshake2.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
