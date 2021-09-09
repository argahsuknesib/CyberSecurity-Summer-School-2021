package _m_j;

import _m_j.jqu;
import _m_j.jri;
import _m_j.jrk;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import ss.q;
import ss.ss.gK.o;
import ss.ss.ss.a;
import ss.u;

public final class jqr extends jqu.O00000Oo implements jpa {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jou f2064O000000o;
    public Socket O00000Oo;
    public volatile jqu O00000o;
    public jph O00000o0;
    public int O00000oO;
    public iqn O00000oo;
    public iqm O0000O0o;
    public int O0000OOo;
    public boolean O0000Oo;
    public final List<Reference<jqh>> O0000Oo0 = new ArrayList();
    public long O0000OoO = Long.MAX_VALUE;
    private u O0000o0;
    private Socket O0000o00;

    public jqr(jou jou) {
        this.f2064O000000o = jou;
    }

    public final jou O000000o() {
        return this.f2064O000000o;
    }

    public final void O000000o(jqu jqu) {
        this.O0000OOo = jqu.O000000o();
    }

    public final void O000000o(jqv jqv) throws IOException {
        jqv.O000000o(a.REFUSED_STREAM);
    }

    public final boolean O000000o(boolean z) {
        int soTimeout;
        if (this.O00000Oo.isClosed() || this.O00000Oo.isInputShutdown() || this.O00000Oo.isOutputShutdown()) {
            return false;
        }
        if (this.O00000o == null && z) {
            try {
                soTimeout = this.O00000Oo.getSoTimeout();
                this.O00000Oo.setSoTimeout(1);
                if (this.O00000oo.O00000o()) {
                    this.O00000Oo.setSoTimeout(soTimeout);
                    return false;
                }
                this.O00000Oo.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.O00000Oo.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:26:0x0077 */
    /* JADX INFO: additional move instructions added (6) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:169:0x003f */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Failed to insert an additional move for type inference into block B:168:0x003f */
    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v48, resolved type: _m_j.iqm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v49, resolved type: _m_j.iqm} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
     arg types: [ss.q, int]
     candidates:
      _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
      _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
      _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
      _m_j.jqp.O000000o(ss.q, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{javax.net.ssl.SSLSocketFactory.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket throws java.io.IOException}
     arg types: [java.net.Socket, java.lang.String, int, int]
     candidates:
      ClspMth{javax.net.SocketFactory.createSocket(java.lang.String, int, java.net.InetAddress, int):java.net.Socket throws java.io.IOException, java.net.UnknownHostException}
      ClspMth{javax.net.SocketFactory.createSocket(java.net.InetAddress, int, java.net.InetAddress, int):java.net.Socket throws java.io.IOException}
      ClspMth{javax.net.ssl.SSLSocketFactory.createSocket(java.net.Socket, java.lang.String, int, boolean):java.net.Socket throws java.io.IOException} */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0367, code lost:
        if ((r0.getCause() instanceof java.security.cert.CertificateException) == false) goto L_0x0369;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0371, code lost:
        if ((r0 instanceof javax.net.ssl.SSLProtocolException) != false) goto L_0x0373;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02a0 A[Catch:{ IOException -> 0x0302 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02ed A[Catch:{ IOException -> 0x0302 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x02f6 A[Catch:{ IOException -> 0x0323 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x034f  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0378 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x028c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097 A[Catch:{ IOException -> 0x0304 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x027b A[Catch:{ all -> 0x0282 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0281 A[Catch:{ all -> 0x0282 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0285 A[SYNTHETIC, Splitter:B:95:0x0285] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0290 A[Catch:{ IOException -> 0x0302 }] */
    public final void O000000o(int i, int i2, int i3, List<jpc> list, boolean z) throws o {
        boolean z2;
        boolean z3;
        Socket socket;
        int O00000Oo2;
        SSLSocket sSLSocket;
        int i4 = i2;
        List<jpc> list2 = list;
        if (this.O0000o0 == null) {
            jpl jpl = new jpl(list2);
            Proxy proxy = this.f2064O000000o.O00000Oo;
            jot jot = this.f2064O000000o.f2002O000000o;
            if (this.f2064O000000o.f2002O000000o.O0000Oo0 != null || list2.contains(jpc.O00000o0)) {
                jqh jqh = null;
                o oVar = null;
                while (this.O0000o0 == null) {
                    try {
                        if (proxy.type() != Proxy.Type.DIRECT) {
                            if (proxy.type() != Proxy.Type.HTTP) {
                                socket = new Socket(proxy);
                                this.O0000o00 = socket;
                                this.O0000o00.setSoTimeout(i4);
                                jpr.O000000o().O000000o(this.O0000o00, this.f2064O000000o.O00000o0, i);
                                try {
                                    this.O00000oo = iqt.O000000o(iqt.O00000Oo(this.O0000o00));
                                    this.O0000O0o = iqt.O000000o(iqt.O000000o(this.O0000o00));
                                    if (this.f2064O000000o.f2002O000000o.O0000Oo0 == null) {
                                        jou jou = this.f2064O000000o;
                                        if (jou.f2002O000000o.O0000Oo0 != null && jou.O00000Oo.type() == Proxy.Type.HTTP) {
                                            jri O000000o2 = new jri.O000000o().O000000o(this.f2064O000000o.f2002O000000o.f2001O000000o).O000000o("Host", jqp.O000000o(this.f2064O000000o.f2002O000000o.f2001O000000o, true)).O000000o("Proxy-Connection", "Keep-Alive").O000000o("User-Agent", "").O000000o();
                                            q qVar = O000000o2.f2095O000000o;
                                            String str = "CONNECT " + jqp.O000000o(qVar, true) + " HTTP/1.1";
                                            jpv jpv = new jpv(jqh, this.O00000oo, this.O0000O0o);
                                            this.O00000oo.O000000o().O000000o((long) i4, TimeUnit.MILLISECONDS);
                                            try {
                                                this.O0000O0o.O000000o().O000000o((long) i3, TimeUnit.MILLISECONDS);
                                                jpv.O000000o(O000000o2.O00000o0, str);
                                                jpv.O00000Oo();
                                                jrk.O000000o O00000o02 = jpv.O00000o0();
                                                O00000o02.f2099O000000o = O000000o2;
                                                jrk O000000o3 = O00000o02.O000000o();
                                                long O000000o4 = jqb.O000000o(O000000o3);
                                                if (O000000o4 == -1) {
                                                    O000000o4 = 0;
                                                }
                                                iqz O000000o5 = jpv.O000000o(O000000o4);
                                                jqp.O000000o(O000000o5, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
                                                O000000o5.close();
                                                int i5 = O000000o3.O00000o0;
                                                if (i5 != 200) {
                                                    if (i5 != 407) {
                                                        throw new IOException("Unexpected response code for CONNECT: " + O000000o3.O00000o0);
                                                    }
                                                    throw new IOException("Failed to authenticate with proxy");
                                                } else if (!this.O00000oo.O00000Oo().O00000o() || !this.O0000O0o.O00000Oo().O00000o()) {
                                                    throw new IOException("TLS tunnel buffered too many bytes!");
                                                }
                                            } catch (IOException e) {
                                                e = e;
                                            }
                                        } else {
                                            int i6 = i3;
                                        }
                                        jot jot2 = this.f2064O000000o.f2002O000000o;
                                        try {
                                            sSLSocket = (SSLSocket) jot2.O0000Oo0.createSocket(this.O0000o00, jot2.f2001O000000o.O00000Oo, jot2.f2001O000000o.O00000o0, true);
                                            try {
                                                jpc O000000o6 = jpl.O000000o(sSLSocket);
                                                if (O000000o6.O00000oO) {
                                                    jpr.O000000o().O000000o(sSLSocket, jot2.f2001O000000o.O00000Oo, jot2.O00000oO);
                                                }
                                                sSLSocket.startHandshake();
                                                jph O000000o7 = jph.O000000o(sSLSocket.getSession());
                                                if (jot2.O0000Oo.verify(jot2.f2001O000000o.O00000Oo, sSLSocket.getSession())) {
                                                    jot2.O0000OoO.O000000o(jot2.f2001O000000o.O00000Oo, O000000o7.O00000Oo);
                                                    String O00000Oo3 = O000000o6.O00000oO ? jpr.O000000o().O00000Oo(sSLSocket) : null;
                                                    this.O00000Oo = sSLSocket;
                                                    this.O00000oo = iqt.O000000o(iqt.O00000Oo(this.O00000Oo));
                                                    iqm O000000o8 = iqt.O000000o(iqt.O000000o(this.O00000Oo));
                                                    this.O0000O0o = O000000o8;
                                                    this.O00000o0 = O000000o7;
                                                    this.O0000o0 = O00000Oo3 != null ? u.a(O00000Oo3) : u.HTTP_1_1;
                                                    z2 = O000000o8;
                                                    if (sSLSocket != null) {
                                                        jpr.O000000o().O000000o(sSLSocket);
                                                        z2 = O000000o8;
                                                    }
                                                } else {
                                                    X509Certificate x509Certificate = (X509Certificate) O000000o7.O00000Oo.get(0);
                                                    throw new SSLPeerUnverifiedException("Hostname " + jot2.f2001O000000o.O00000Oo + " not verified:\n    certificate: " + joz.O000000o((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + jql.O000000o(x509Certificate));
                                                }
                                            } catch (AssertionError e2) {
                                                e = e2;
                                                try {
                                                    if (!jqp.O000000o(e)) {
                                                        throw new IOException(e);
                                                    }
                                                    throw e;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (sSLSocket == null) {
                                                        jpr.O000000o().O000000o(sSLSocket);
                                                    }
                                                    jqp.O000000o((Socket) sSLSocket);
                                                    throw th;
                                                }
                                            }
                                        } catch (AssertionError e3) {
                                            e = e3;
                                            sSLSocket = null;
                                            if (!jqp.O000000o(e)) {
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            sSLSocket = null;
                                            if (sSLSocket == null) {
                                            }
                                            jqp.O000000o((Socket) sSLSocket);
                                            throw th;
                                        }
                                    } else {
                                        int i7 = i3;
                                        this.O0000o0 = u.HTTP_1_1;
                                        this.O00000Oo = this.O0000o00;
                                    }
                                    if (this.O0000o0 != u.SPDY_3) {
                                        if (this.O0000o0 != u.HTTP_2) {
                                            this.O0000OOo = 1;
                                            z2 = z2;
                                            jqh = null;
                                        }
                                    }
                                    this.O00000Oo.setSoTimeout(0);
                                    jqu.O000000o o000000o = new jqu.O000000o();
                                    Socket socket2 = this.O00000Oo;
                                    String str2 = this.f2064O000000o.f2002O000000o.f2001O000000o.O00000Oo;
                                    iqn iqn = this.O00000oo;
                                    iqm iqm = this.O0000O0o;
                                    o000000o.f2066O000000o = socket2;
                                    o000000o.O00000Oo = str2;
                                    o000000o.O00000o0 = iqn;
                                    o000000o.O00000o = iqm;
                                    o000000o.O00000oo = this.O0000o0;
                                    o000000o.O00000oO = this;
                                    z2 = false;
                                    jqu jqu = new jqu(o000000o, (byte) 0);
                                    jqu.O0000Oo0.O000000o();
                                    jqu.O0000Oo0.O00000Oo(jqu.O00000oO);
                                    O00000Oo2 = jqu.O00000oO.O00000Oo();
                                    if (O00000Oo2 == 65536) {
                                        z2 = false;
                                        jqu.O0000Oo0.O000000o(0, (long) (O00000Oo2 - 65536));
                                    } else {
                                        z2 = false;
                                    }
                                    this.O0000OOo = jqu.O000000o();
                                    this.O00000o = jqu;
                                    z2 = z2;
                                    jqh = null;
                                } catch (IOException e4) {
                                    e = e4;
                                    z3 = false;
                                    jqp.O000000o(this.O00000Oo);
                                    jqp.O000000o(this.O0000o00);
                                    jqh = null;
                                    this.O00000Oo = null;
                                    this.O0000o00 = null;
                                    this.O00000oo = null;
                                    this.O0000O0o = null;
                                    this.O00000o0 = null;
                                    this.O0000o0 = null;
                                    if (oVar == null) {
                                    }
                                    if (z) {
                                    }
                                    throw oVar;
                                }
                            }
                        }
                        socket = jot.O00000o0.createSocket();
                        this.O0000o00 = socket;
                        this.O0000o00.setSoTimeout(i4);
                        try {
                            try {
                                jpr.O000000o().O000000o(this.O0000o00, this.f2064O000000o.O00000o0, i);
                                this.O00000oo = iqt.O000000o(iqt.O00000Oo(this.O0000o00));
                                this.O0000O0o = iqt.O000000o(iqt.O000000o(this.O0000o00));
                                if (this.f2064O000000o.f2002O000000o.O0000Oo0 == null) {
                                }
                                if (this.O0000o0 != u.SPDY_3) {
                                }
                                this.O00000Oo.setSoTimeout(0);
                                jqu.O000000o o000000o2 = new jqu.O000000o();
                                Socket socket22 = this.O00000Oo;
                                String str22 = this.f2064O000000o.f2002O000000o.f2001O000000o.O00000Oo;
                                iqn iqn2 = this.O00000oo;
                                iqm iqm2 = this.O0000O0o;
                                o000000o2.f2066O000000o = socket22;
                                o000000o2.O00000Oo = str22;
                                o000000o2.O00000o0 = iqn2;
                                o000000o2.O00000o = iqm2;
                                o000000o2.O00000oo = this.O0000o0;
                                o000000o2.O00000oO = this;
                                z2 = false;
                            } catch (ConnectException unused) {
                                int i8 = i3;
                                throw new ConnectException("Failed to connect to " + this.f2064O000000o.O00000o0);
                            }
                        } catch (ConnectException unused2) {
                            int i9 = i;
                            int i82 = i3;
                            throw new ConnectException("Failed to connect to " + this.f2064O000000o.O00000o0);
                        }
                        try {
                            jqu jqu2 = new jqu(o000000o2, (byte) 0);
                            jqu2.O0000Oo0.O000000o();
                            jqu2.O0000Oo0.O00000Oo(jqu2.O00000oO);
                            O00000Oo2 = jqu2.O00000oO.O00000Oo();
                            if (O00000Oo2 == 65536) {
                            }
                            this.O0000OOo = jqu2.O000000o();
                            this.O00000o = jqu2;
                            z2 = z2;
                            jqh = null;
                        } catch (IOException e5) {
                            e = e5;
                            z3 = z2;
                            jqp.O000000o(this.O00000Oo);
                            jqp.O000000o(this.O0000o00);
                            jqh = null;
                            this.O00000Oo = null;
                            this.O0000o00 = null;
                            this.O00000oo = null;
                            this.O0000O0o = null;
                            this.O00000o0 = null;
                            this.O0000o0 = null;
                            if (oVar == null) {
                            }
                            if (z) {
                            }
                            throw oVar;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        z3 = false;
                        jqp.O000000o(this.O00000Oo);
                        jqp.O000000o(this.O0000o00);
                        jqh = null;
                        this.O00000Oo = null;
                        this.O0000o00 = null;
                        this.O00000oo = null;
                        this.O0000O0o = null;
                        this.O00000o0 = null;
                        this.O0000o0 = null;
                        if (oVar == null) {
                            oVar = new o(e);
                        } else {
                            oVar.a(e);
                        }
                        if (z) {
                            jpl.O00000Oo = true;
                            boolean z4 = z3;
                            if (jpl.f2023O000000o) {
                                z4 = z3;
                                if (!(e instanceof ProtocolException)) {
                                    z4 = z3;
                                    if (!(e instanceof InterruptedIOException)) {
                                        boolean z5 = e instanceof SSLHandshakeException;
                                        if (z5) {
                                            z4 = z3;
                                        }
                                        z4 = z3;
                                        if (!(e instanceof SSLPeerUnverifiedException)) {
                                            if (!z5) {
                                                z4 = z3;
                                            }
                                            z4 = true;
                                        }
                                    }
                                }
                            }
                            if (z2) {
                            }
                        }
                        throw oVar;
                    }
                }
                return;
            }
            throw new o(new UnknownServiceException("CLEARTEXT communication not supported: ".concat(String.valueOf(list))));
        }
        throw new IllegalStateException("already connected");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.f2064O000000o.f2002O000000o.f2001O000000o.O00000Oo);
        sb.append(":");
        sb.append(this.f2064O000000o.f2002O000000o.f2001O000000o.O00000o0);
        sb.append(", proxy=");
        sb.append(this.f2064O000000o.O00000Oo);
        sb.append(" hostAddress=");
        sb.append(this.f2064O000000o.O00000o0);
        sb.append(" cipherSuite=");
        jph jph = this.O00000o0;
        sb.append(jph != null ? jph.f2019O000000o : "none");
        sb.append(" protocol=");
        sb.append(this.O0000o0);
        sb.append('}');
        return sb.toString();
    }
}
