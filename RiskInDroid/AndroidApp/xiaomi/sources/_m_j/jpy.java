package _m_j;

import _m_j.jpi;
import _m_j.jpj;
import _m_j.jrk;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import ss.q;

public final class jpy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jrl f2043O000000o = new jrl() {
        /* class _m_j.jpy.AnonymousClass1 */

        public final jpk O000000o() {
            return null;
        }

        public final long O00000Oo() {
            return 0;
        }

        public final iqn O00000o0() {
            return new iql();
        }
    };
    public final jrg O00000Oo;
    public final jrk O00000o;
    public final jqh O00000o0;
    public jqa O00000oO;
    public long O00000oo = -1;
    public boolean O0000O0o;
    public final boolean O0000OOo;
    public jri O0000Oo;
    public final jri O0000Oo0;
    public jrk O0000OoO;
    public jrk O0000Ooo;
    public jps O0000o;
    public iqm O0000o0;
    public iqy O0000o00;
    public final boolean O0000o0O;
    public final boolean O0000o0o;
    public jpt O0000oO0;

    public final void O000000o() {
        if (this.O00000oo == -1) {
            this.O00000oo = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException();
    }

    public class O000000o implements jpj.O000000o {
        private final int O00000Oo;
        private final jpa O00000o;
        private final jri O00000o0;
        private int O00000oO;

        public O000000o(int i, jri jri, jpa jpa) {
            this.O00000Oo = i;
            this.O00000o0 = jri;
            this.O00000o = jpa;
        }

        public final jri O000000o() {
            return this.O00000o0;
        }

        public final jrk O000000o(jri jri) throws IOException {
            this.O00000oO++;
            if (this.O00000Oo > 0) {
                jpj jpj = jpy.this.O00000Oo.O00000oo.get(this.O00000Oo - 1);
                jot jot = this.O00000o.O000000o().f2002O000000o;
                if (!jri.f2095O000000o.O00000Oo.equals(jot.f2001O000000o.O00000Oo) || jri.f2095O000000o.O00000o0 != jot.f2001O000000o.O00000o0) {
                    throw new IllegalStateException("network interceptor " + jpj + " must retain the same host and port");
                } else if (this.O00000oO > 1) {
                    throw new IllegalStateException("network interceptor " + jpj + " must call proceed() exactly once");
                }
            }
            if (this.O00000Oo < jpy.this.O00000Oo.O00000oo.size()) {
                O000000o o000000o = new O000000o(this.O00000Oo + 1, jri, this.O00000o);
                jpj jpj2 = jpy.this.O00000Oo.O00000oo.get(this.O00000Oo);
                jrk O000000o2 = jpj2.O000000o(o000000o);
                if (o000000o.O00000oO != 1) {
                    throw new IllegalStateException("network interceptor " + jpj2 + " must call proceed() exactly once");
                } else if (O000000o2 != null) {
                    return O000000o2;
                } else {
                    throw new NullPointerException("network interceptor " + jpj2 + " returned null");
                }
            } else {
                jpy.this.O00000oO.O000000o(jri);
                jri unused = jpy.this.O0000Oo = jri;
                if (jpy.O000000o(jri) && jri.O00000o != null) {
                    iqm O000000o3 = iqt.O000000o(jpy.this.O00000oO.O000000o(jri, jri.O00000o.O00000Oo()));
                    jri.O00000o.O000000o(O000000o3);
                    O000000o3.close();
                }
                jrk O00000Oo2 = jpy.this.O00000o();
                int i = O00000Oo2.O00000o0;
                if ((i != 204 && i != 205) || O00000Oo2.O0000O0o.O00000Oo() <= 0) {
                    return O00000Oo2;
                }
                throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + O00000Oo2.O0000O0o.O00000Oo());
            }
        }
    }

    public jpy(jrg jrg, jri jri, boolean z, boolean z2, boolean z3, jqh jqh, jqe jqe, jrk jrk) {
        jqh jqh2;
        joz joz;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        jrg jrg2 = jrg;
        jri jri2 = jri;
        this.O00000Oo = jrg2;
        this.O0000Oo0 = jri2;
        this.O0000OOo = z;
        this.O0000o0O = z2;
        this.O0000o0o = z3;
        if (jqh != null) {
            jqh2 = jqh;
        } else {
            jpb jpb = jrg2.O0000oO0;
            if (jri2.f2095O000000o.O00000Oo()) {
                sSLSocketFactory = jrg2.O0000Ooo;
                hostnameVerifier = jrg2.O0000o0;
                joz = jrg2.O0000o0O;
            } else {
                sSLSocketFactory = null;
                hostnameVerifier = null;
                joz = null;
            }
            String str = jri2.f2095O000000o.O00000Oo;
            int i = jri2.f2095O000000o.O00000o0;
            jpg jpg = jrg2.O0000oO;
            SocketFactory socketFactory = jrg2.O0000OoO;
            jov jov = jrg2.O0000o0o;
            Proxy proxy = jrg2.O00000Oo;
            jqh2 = new jqh(jpb, new jot(str, i, jpg, socketFactory, sSLSocketFactory, hostnameVerifier, joz, jov, proxy, jrg2.O00000o0, jrg2.O00000o, jrg2.O0000O0o));
        }
        this.O00000o0 = jqh2;
        this.O0000o00 = null;
        this.O00000o = jrk;
    }

    public static jrk O000000o(jrk jrk) {
        if (jrk == null || jrk.O0000O0o == null) {
            return jrk;
        }
        jrk.O000000o O000000o2 = jrk.O000000o();
        O000000o2.O0000O0o = null;
        return O000000o2.O000000o();
    }

    public static boolean O000000o(jri jri) {
        return jpz.O00000Oo(jri.O00000Oo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if ((r0.O00000o0() || r0.O00000Oo() || r0.O00000o()) != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r11 != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004d, code lost:
        if (r2 != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0054, code lost:
        if (r10.O00000Oo.O0000oo0 != false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0056, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006e, code lost:
        return new _m_j.jpy(r10.O00000Oo, r10.O0000Oo0, r10.O0000OOo, r10.O0000o0O, r10.O0000o0o, O00000o0(), null, r10.O00000o);
     */
    public final jpy O000000o(IOException iOException) {
        boolean z;
        jqh jqh = this.O00000o0;
        if (jqh.O00000o0 != null) {
            jqh.O000000o(iOException);
        }
        boolean z2 = true;
        if (jqh.O00000Oo != null) {
            jqf jqf = jqh.O00000Oo;
        }
        if (!(iOException instanceof ProtocolException)) {
            if (iOException instanceof InterruptedIOException) {
                z = iOException instanceof SocketTimeoutException;
            } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
                z = true;
            }
        }
        z = false;
    }

    public final void O00000Oo() throws IOException {
        this.O00000o0.O000000o(false, true, false);
    }

    public final jqh O00000o0() {
        Closeable closeable = this.O0000o0;
        if (!(closeable == null && (closeable = this.O0000o00) == null)) {
            jqp.O000000o(closeable);
        }
        jrk jrk = this.O0000Ooo;
        if (jrk != null) {
            jqp.O000000o(jrk.O0000O0o);
        } else {
            this.O00000o0.O000000o((IOException) null);
        }
        return this.O00000o0;
    }

    public final jrk O00000Oo(jrk jrk) throws IOException {
        if (!this.O0000O0o || !"gzip".equalsIgnoreCase(this.O0000Ooo.O000000o("Content-Encoding")) || jrk.O0000O0o == null) {
            return jrk;
        }
        iqr iqr = new iqr(jrk.O0000O0o.O00000o0());
        jpi O000000o2 = jrk.O00000oo.O000000o().O000000o("Content-Encoding").O000000o("Content-Length").O000000o();
        jrk.O000000o O000000o3 = jrk.O000000o().O000000o(O000000o2);
        O000000o3.O0000O0o = new jqc(O000000o2, iqt.O000000o(iqr));
        return O000000o3.O000000o();
    }

    public static boolean O00000o0(jrk jrk) {
        if (jrk.f2098O000000o.O00000Oo.equals("HEAD")) {
            return false;
        }
        int i = jrk.O00000o0;
        if (((i >= 100 && i < 200) || i == 204 || i == 304) && jqb.O000000o(jrk) == -1 && !"chunked".equalsIgnoreCase(jrk.O000000o("Transfer-Encoding"))) {
            return false;
        }
        return true;
    }

    public static String O000000o(List<jpd> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            jpd jpd = list.get(i);
            sb.append(jpd.f2015O000000o);
            sb.append('=');
            sb.append(jpd.O00000Oo);
        }
        return sb.toString();
    }

    public final jrk O00000o() throws IOException {
        this.O00000oO.O00000Oo();
        jrk.O000000o O000000o2 = this.O00000oO.O000000o();
        O000000o2.f2099O000000o = this.O0000Oo;
        O000000o2.O00000oO = this.O00000o0.O000000o().O00000o0;
        jrk O000000o3 = O000000o2.O000000o(jqb.O00000Oo, Long.toString(this.O00000oo)).O000000o(jqb.O00000o0, Long.toString(System.currentTimeMillis())).O000000o();
        if (!this.O0000o0o) {
            jrk.O000000o O000000o4 = O000000o3.O000000o();
            O000000o4.O0000O0o = this.O00000oO.O000000o(O000000o3);
            O000000o3 = O000000o4.O000000o();
        }
        if ("close".equalsIgnoreCase(O000000o3.f2098O000000o.O000000o("Connection")) || "close".equalsIgnoreCase(O000000o3.O000000o("Connection"))) {
            this.O00000o0.O000000o(true, false, false);
        }
        return O000000o3;
    }

    public static jpi O000000o(jpi jpi, jpi jpi2) throws IOException {
        jpi.O000000o o000000o = new jpi.O000000o();
        int length = jpi.f2020O000000o.length / 2;
        for (int i = 0; i < length; i++) {
            String O000000o2 = jpi.O000000o(i);
            String O00000Oo2 = jpi.O00000Oo(i);
            if ((!"Warning".equalsIgnoreCase(O000000o2) || !O00000Oo2.startsWith("1")) && (!jqb.O000000o(O000000o2) || jpi2.O000000o(O000000o2) == null)) {
                o000000o.O000000o(O000000o2, O00000Oo2);
            }
        }
        int length2 = jpi2.f2020O000000o.length / 2;
        for (int i2 = 0; i2 < length2; i2++) {
            String O000000o3 = jpi2.O000000o(i2);
            if (!"Content-Length".equalsIgnoreCase(O000000o3) && jqb.O000000o(O000000o3)) {
                o000000o.O000000o(O000000o3, jpi2.O00000Oo(i2));
            }
        }
        return o000000o.O000000o();
    }

    public final void O000000o(jpi jpi) throws IOException {
        if (this.O00000Oo.O0000OOo != jpe.f2016O000000o && jpd.O000000o(this.O0000Oo0.f2095O000000o, jpi).isEmpty()) {
        }
    }

    public final boolean O000000o(q qVar) {
        q qVar2 = this.O0000Oo0.f2095O000000o;
        return qVar2.O00000Oo.equals(qVar.O00000Oo) && qVar2.O00000o0 == qVar.O00000o0 && qVar2.f15491O000000o.equals(qVar.f15491O000000o);
    }
}
