package _m_j;

import _m_j.joz;
import _m_j.jpc;
import _m_j.jpi;
import com.google.android.exoplayer2.C;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import ss.u;

public class jrg implements Cloneable {
    /* access modifiers changed from: private */
    public static final List<u> O00oOooO = jqp.O000000o(u.HTTP_2, u.SPDY_3, u.HTTP_1_1);
    /* access modifiers changed from: private */
    public static final List<jpc> O00oOooo = jqp.O000000o(jpc.f2013O000000o, jpc.O00000Oo, jpc.O00000o0);

    /* renamed from: O000000o  reason: collision with root package name */
    final jpf f2091O000000o;
    public final Proxy O00000Oo;
    public final List<jpc> O00000o;
    public final List<u> O00000o0;
    final List<jpj> O00000oO;
    public final List<jpj> O00000oo;
    public final ProxySelector O0000O0o;
    public final jpe O0000OOo;
    final jpo O0000Oo;
    final jow O0000Oo0;
    public final SocketFactory O0000OoO;
    public final SSLSocketFactory O0000Ooo;
    final jov O0000o;
    public final HostnameVerifier O0000o0;
    final jqn O0000o00;
    public final joz O0000o0O;
    public final jov O0000o0o;
    public final jpg O0000oO;
    public final jpb O0000oO0;
    public final boolean O0000oOO;
    public final boolean O0000oOo;
    public final int O0000oo;
    public final boolean O0000oo0;
    public final int O0000ooO;
    public final int O0000ooo;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        jpf f2092O000000o = new jpf();
        Proxy O00000Oo;
        List<jpc> O00000o = jrg.O00oOooo;
        List<u> O00000o0 = jrg.O00oOooO;
        final List<jpj> O00000oO = new ArrayList();
        public final List<jpj> O00000oo = new ArrayList();
        ProxySelector O0000O0o = ProxySelector.getDefault();
        jpe O0000OOo = jpe.f2016O000000o;
        jpo O0000Oo;
        jow O0000Oo0;
        SocketFactory O0000OoO = SocketFactory.getDefault();
        SSLSocketFactory O0000Ooo;
        jov O0000o = jov.f2003O000000o;
        HostnameVerifier O0000o0 = jql.f2059O000000o;
        jqn O0000o00;
        joz O0000o0O = joz.f2007O000000o;
        jov O0000o0o = jov.f2003O000000o;
        jpg O0000oO = jpg.f2018O000000o;
        jpb O0000oO0 = new jpb();
        boolean O0000oOO = true;
        boolean O0000oOo = true;
        public int O0000oo = C.MSG_CUSTOM_BASE;
        boolean O0000oo0 = true;
        public int O0000ooO = C.MSG_CUSTOM_BASE;
        public int O0000ooo = C.MSG_CUSTOM_BASE;
    }

    static {
        jpn.O00000Oo = new jpn() {
            /* class _m_j.jrg.AnonymousClass1 */

            public final jqo O000000o(jpb jpb) {
                return jpb.O00000oO;
            }

            public final void O000000o(jpi.O000000o o000000o, String str) {
                int indexOf = str.indexOf(":", 1);
                if (indexOf != -1) {
                    o000000o.O00000Oo(str.substring(0, indexOf), str.substring(indexOf + 1));
                } else if (str.startsWith(":")) {
                    o000000o.O00000Oo("", str.substring(1));
                } else {
                    o000000o.O00000Oo("", str);
                }
            }

            public final jpo O000000o(jrg jrg) {
                return jrg.O0000Oo0 != null ? jrg.O0000Oo0.f2004O000000o : jrg.O0000Oo;
            }

            public final boolean O00000Oo(jpb jpb, jqr jqr) {
                if (!jpb.O0000O0o && !Thread.holdsLock(jpb)) {
                    throw new AssertionError();
                } else if (jqr.O0000Oo || jpb.O00000Oo == 0) {
                    jpb.O00000o.remove(jqr);
                    return true;
                } else {
                    jpb.notifyAll();
                    return false;
                }
            }

            public final jqr O000000o(jpb jpb, jot jot, jqh jqh) {
                if (jpb.O0000O0o || Thread.holdsLock(jpb)) {
                    for (jqr next : jpb.O00000o) {
                        if (next.O0000Oo0.size() < next.O0000OOo && jot.equals(next.f2064O000000o.f2002O000000o) && !next.O0000Oo) {
                            jqh.O000000o(next);
                            return next;
                        }
                    }
                    return null;
                }
                throw new AssertionError();
            }

            public final void O000000o(jpb jpb, jqr jqr) {
                if (jpb.O0000O0o || Thread.holdsLock(jpb)) {
                    if (!jpb.O00000oo) {
                        jpb.O00000oo = true;
                        jpb.f2011O000000o.execute(jpb.O00000o0);
                    }
                    jpb.O00000o.add(jqr);
                    return;
                }
                throw new AssertionError();
            }

            public final void O000000o(jpc jpc, SSLSocket sSLSocket, boolean z) {
                String[] enabledCipherSuites = jpc.O00000oo != null ? (String[]) jqp.O000000o(String.class, jpc.O00000oo, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
                String[] enabledProtocols = jpc.O0000O0o != null ? (String[]) jqp.O000000o(String.class, jpc.O0000O0o, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
                if (z && jqp.O000000o(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
                    enabledCipherSuites = jqp.O00000Oo(enabledCipherSuites, "TLS_FALLBACK_SCSV");
                }
                jpc O00000Oo = new jpc.O000000o(jpc).O000000o(enabledCipherSuites).O00000Oo(enabledProtocols).O00000Oo();
                if (O00000Oo.O0000O0o != null) {
                    sSLSocket.setEnabledProtocols(O00000Oo.O0000O0o);
                }
                if (O00000Oo.O00000oo != null) {
                    sSLSocket.setEnabledCipherSuites(O00000Oo.O00000oo);
                }
            }
        };
    }

    public jrg() {
        this(new O000000o());
    }

    public /* synthetic */ jrg(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public final joy O000000o(jri jri) {
        return new jrh(this, jri);
    }

    private jrg(O000000o o000000o) {
        boolean z;
        joz joz;
        this.f2091O000000o = o000000o.f2092O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = jqp.O000000o(o000000o.O00000oO);
        this.O00000oo = jqp.O000000o(o000000o.O00000oo);
        this.O0000O0o = o000000o.O0000O0o;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo0;
        this.O0000Oo = o000000o.O0000Oo;
        this.O0000OoO = o000000o.O0000OoO;
        Iterator<jpc> it = this.O00000o.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                jpc next = it.next();
                if (z || next.O00000o) {
                    z = true;
                }
            }
        }
        if (o000000o.O0000Ooo != null || !z) {
            this.O0000Ooo = o000000o.O0000Ooo;
        } else {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.O0000Ooo = instance.getSocketFactory();
            } catch (GeneralSecurityException unused) {
                throw new AssertionError();
            }
        }
        if (this.O0000Ooo == null || o000000o.O0000o00 != null) {
            this.O0000o00 = o000000o.O0000o00;
            joz = o000000o.O0000o0O;
        } else {
            X509TrustManager O000000o2 = jpr.O000000o().O000000o(this.O0000Ooo);
            if (O000000o2 != null) {
                this.O0000o00 = jpr.O000000o().O000000o(O000000o2);
                joz.O000000o o000000o2 = new joz.O000000o(o000000o.O0000o0O);
                o000000o2.O00000Oo = this.O0000o00;
                joz = o000000o2.O000000o();
            } else {
                throw new IllegalStateException("Unable to extract the trust manager on " + jpr.O000000o() + ", sslSocketFactory is " + this.O0000Ooo.getClass());
            }
        }
        this.O0000o0O = joz;
        this.O0000o0 = o000000o.O0000o0;
        this.O0000o0o = o000000o.O0000o0o;
        this.O0000o = o000000o.O0000o;
        this.O0000oO0 = o000000o.O0000oO0;
        this.O0000oO = o000000o.O0000oO;
        this.O0000oOO = o000000o.O0000oOO;
        this.O0000oOo = o000000o.O0000oOo;
        this.O0000oo0 = o000000o.O0000oo0;
        this.O0000oo = o000000o.O0000oo;
        this.O0000ooO = o000000o.O0000ooO;
        this.O0000ooo = o000000o.O0000ooo;
    }
}
