package com.squareup.okhttp;

import _m_j.jay;
import _m_j.jaz;
import _m_j.jbn;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.http.FramedTransport;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

public final class Connection {
    private FramedConnection framedConnection;
    private Handshake handshake;
    private HttpConnection httpConnection;
    private long idleStartTimeNs;
    private Object owner;
    private final ConnectionPool pool;
    private Protocol protocol;
    private int recycleCount;
    private final Route route;
    private Socket socket;

    public Connection(ConnectionPool connectionPool, Route route2) {
        this.pool = connectionPool;
        this.route = route2;
    }

    /* access modifiers changed from: package-private */
    public final Object getOwner() {
        Object obj;
        synchronized (this.pool) {
            obj = this.owner;
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final void setOwner(Object obj) {
        if (!isFramed()) {
            synchronized (this.pool) {
                if (this.owner == null) {
                    this.owner = obj;
                } else {
                    throw new IllegalStateException("Connection already has an owner!");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean clearOwner() {
        synchronized (this.pool) {
            if (this.owner == null) {
                return false;
            }
            this.owner = null;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        r3 = r2.socket;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    public final void closeIfOwnedBy(Object obj) throws IOException {
        if (!isFramed()) {
            synchronized (this.pool) {
                if (this.owner == obj) {
                    this.owner = null;
                }
            }
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void connect(int i, int i2, int i3, List<ConnectionSpec> list, boolean z) throws RouteException {
        Socket socket2;
        if (this.protocol == null) {
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
            Proxy proxy = this.route.getProxy();
            Address address = this.route.getAddress();
            if (this.route.address.getSslSocketFactory() != null || list.contains(ConnectionSpec.CLEARTEXT)) {
                RouteException routeException = null;
                while (this.protocol == null) {
                    try {
                        if (proxy.type() != Proxy.Type.DIRECT) {
                            if (proxy.type() != Proxy.Type.HTTP) {
                                socket2 = new Socket(proxy);
                                this.socket = socket2;
                                connectSocket(i, i2, i3, connectionSpecSelector);
                            }
                        }
                        socket2 = address.getSocketFactory().createSocket();
                        this.socket = socket2;
                        connectSocket(i, i2, i3, connectionSpecSelector);
                    } catch (IOException e) {
                        Util.closeQuietly(this.socket);
                        this.socket = null;
                        this.handshake = null;
                        this.protocol = null;
                        this.httpConnection = null;
                        this.framedConnection = null;
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.addConnectException(e);
                        }
                        if (!z || !connectionSpecSelector.connectionFailed(e)) {
                            throw routeException;
                        }
                    }
                }
                return;
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: ".concat(String.valueOf(list))));
        }
        throw new IllegalStateException("already connected");
    }

    private void connectSocket(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        this.socket.setSoTimeout(i2);
        Platform.get().connectSocket(this.socket, this.route.getSocketAddress(), i);
        if (this.route.address.getSslSocketFactory() != null) {
            connectTls(i2, i3, connectionSpecSelector);
        } else {
            this.protocol = Protocol.HTTP_1_1;
        }
        if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(0);
            this.framedConnection = new FramedConnection.Builder(this.route.address.uriHost, true, this.socket).protocol(this.protocol).build();
            this.framedConnection.sendConnectionPreface();
            return;
        }
        this.httpConnection = new HttpConnection(this.pool, this, this.socket);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.net.Socket, javax.net.ssl.SSLSocket] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{javax.net.ssl.SSLSocketFactory.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket throws java.io.IOException}
     arg types: [java.net.Socket, java.lang.String, int, int]
     candidates:
      ClspMth{javax.net.SocketFactory.createSocket(java.lang.String, int, java.net.InetAddress, int):java.net.Socket throws java.io.IOException, java.net.UnknownHostException}
      ClspMth{javax.net.SocketFactory.createSocket(java.net.InetAddress, int, java.net.InetAddress, int):java.net.Socket throws java.io.IOException}
      ClspMth{javax.net.ssl.SSLSocketFactory.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket throws java.io.IOException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ed A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f3 A[Catch:{ all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f6  */
    /* JADX WARNING: Unknown variable types count: 2 */
    private void connectTls(int i, int i2, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        ? r7;
        if (this.route.requiresTunnel()) {
            createTunnel(i, i2);
        }
        Address address = this.route.getAddress();
        String str = null;
        try {
            ? r72 = (SSLSocket) address.getSslSocketFactory().createSocket(this.socket, address.getUriHost(), address.getUriPort(), true);
            try {
                ConnectionSpec configureSecureSocket = connectionSpecSelector.configureSecureSocket(r72);
                if (configureSecureSocket.supportsTlsExtensions()) {
                    Platform.get().configureTlsExtensions(r72, address.getUriHost(), address.getProtocols());
                }
                r72.startHandshake();
                Handshake handshake2 = Handshake.get(r72.getSession());
                if (address.getHostnameVerifier().verify(address.getUriHost(), r72.getSession())) {
                    address.getCertificatePinner().check(address.getUriHost(), handshake2.peerCertificates());
                    if (configureSecureSocket.supportsTlsExtensions()) {
                        str = Platform.get().getSelectedProtocol(r72);
                    }
                    this.socket = r72;
                    this.handshake = handshake2;
                    this.protocol = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                    if (r72 != 0) {
                        Platform.get().afterHandshake(r72);
                        return;
                    }
                    return;
                }
                X509Certificate x509Certificate = (X509Certificate) handshake2.peerCertificates().get(0);
                throw new SSLPeerUnverifiedException("Hostname " + address.getUriHost() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
            } catch (AssertionError e) {
                e = e;
                str = r72;
                try {
                    if (!Util.isAndroidGetsocknameError(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    r7 = str;
                    if (r7 != 0) {
                        Platform.get().afterHandshake(r7);
                    }
                    Util.closeQuietly((Socket) r7);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r7 = r72;
                if (r7 != 0) {
                }
                Util.closeQuietly((Socket) r7);
                throw th;
            }
        } catch (AssertionError e2) {
            e = e2;
            if (!Util.isAndroidGetsocknameError(e)) {
            }
        }
    }

    private void createTunnel(int i, int i2) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpConnection httpConnection2 = new HttpConnection(this.pool, this, this.socket);
        httpConnection2.setTimeouts(i, i2);
        HttpUrl httpUrl = createTunnelRequest.httpUrl();
        String str = "CONNECT " + httpUrl.host() + ":" + httpUrl.port() + " HTTP/1.1";
        do {
            httpConnection2.writeRequest(createTunnelRequest.headers(), str);
            httpConnection2.flush();
            Response build = httpConnection2.readResponse().request(createTunnelRequest).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            jbn newFixedLengthSource = httpConnection2.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    createTunnelRequest = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), build, this.route.getProxy());
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (httpConnection2.bufferSize() > 0) {
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else {
                return;
            }
        } while (createTunnelRequest != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request createTunnelRequest() throws IOException {
        HttpUrl build = new HttpUrl.Builder().scheme("https").host(this.route.address.uriHost).port(this.route.address.uriPort).build();
        return new Request.Builder().url(build).header("Host", Util.hostHeader(build)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    /* access modifiers changed from: package-private */
    public final void connectAndSetOwner(OkHttpClient okHttpClient, Object obj) throws RouteException {
        setOwner(obj);
        if (!isConnected()) {
            connect(okHttpClient.getConnectTimeout(), okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout(), this.route.address.getConnectionSpecs(), okHttpClient.getRetryOnConnectionFailure());
            if (isFramed()) {
                okHttpClient.getConnectionPool().share(this);
            }
            okHttpClient.routeDatabase().connected(getRoute());
        }
        setTimeouts(okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout());
    }

    /* access modifiers changed from: package-private */
    public final boolean isConnected() {
        return this.protocol != null;
    }

    public final Route getRoute() {
        return this.route;
    }

    public final Socket getSocket() {
        return this.socket;
    }

    /* access modifiers changed from: package-private */
    public final jaz rawSource() {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 != null) {
            return httpConnection2.rawSource();
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final jay rawSink() {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 != null) {
            return httpConnection2.rawSink();
        }
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final boolean isAlive() {
        return !this.socket.isClosed() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }

    /* access modifiers changed from: package-private */
    public final boolean isReadable() {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 != null) {
            return httpConnection2.isReadable();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void resetIdleStartTime() {
        if (this.framedConnection == null) {
            this.idleStartTimeNs = System.nanoTime();
            return;
        }
        throw new IllegalStateException("framedConnection != null");
    }

    /* access modifiers changed from: package-private */
    public final boolean isIdle() {
        FramedConnection framedConnection2 = this.framedConnection;
        return framedConnection2 == null || framedConnection2.isIdle();
    }

    /* access modifiers changed from: package-private */
    public final long getIdleStartTimeNs() {
        FramedConnection framedConnection2 = this.framedConnection;
        return framedConnection2 == null ? this.idleStartTimeNs : framedConnection2.getIdleStartTimeNs();
    }

    public final Handshake getHandshake() {
        return this.handshake;
    }

    /* access modifiers changed from: package-private */
    public final Transport newTransport(HttpEngine httpEngine) throws IOException {
        FramedConnection framedConnection2 = this.framedConnection;
        return framedConnection2 != null ? new FramedTransport(httpEngine, framedConnection2) : new HttpTransport(httpEngine, this.httpConnection);
    }

    /* access modifiers changed from: package-private */
    public final boolean isFramed() {
        return this.framedConnection != null;
    }

    public final Protocol getProtocol() {
        Protocol protocol2 = this.protocol;
        return protocol2 != null ? protocol2 : Protocol.HTTP_1_1;
    }

    /* access modifiers changed from: package-private */
    public final void setTimeouts(int i, int i2) throws RouteException {
        if (this.protocol == null) {
            throw new IllegalStateException("not connected");
        } else if (this.httpConnection != null) {
            try {
                this.socket.setSoTimeout(i);
                this.httpConnection.setTimeouts(i, i2);
            } catch (IOException e) {
                throw new RouteException(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void incrementRecycleCount() {
        this.recycleCount++;
    }

    /* access modifiers changed from: package-private */
    public final int recycleCount() {
        return this.recycleCount;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.route.address.uriHost);
        sb.append(":");
        sb.append(this.route.address.uriPort);
        sb.append(", proxy=");
        sb.append(this.route.proxy);
        sb.append(" hostAddress=");
        sb.append(this.route.inetSocketAddress.getAddress().getHostAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        sb.append(handshake2 != null ? handshake2.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}
