package _m_j;

import gK.f;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class joz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final joz f2007O000000o = new O000000o().O000000o();
    /* access modifiers changed from: private */
    public final List<O00000Oo> O00000Oo;
    /* access modifiers changed from: private */
    public final jqn O00000o0;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<O00000Oo> f2008O000000o = new ArrayList();
        jqn O00000Oo;

        public O000000o() {
        }

        O000000o(joz joz) {
            this.f2008O000000o.addAll(joz.O00000Oo);
            this.O00000Oo = joz.O00000o0;
        }

        public final joz O000000o() {
            return new joz(this, (byte) 0);
        }
    }

    /* synthetic */ joz(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private static f O000000o(X509Certificate x509Certificate) {
        return jqp.O00000Oo(f.O000000o(x509Certificate.getPublicKey().getEncoded()));
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f2009O000000o;
        final String O00000Oo;
        final f O00000o0;

        public final boolean equals(Object obj) {
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return this.f2009O000000o.equals(o00000Oo.f2009O000000o) && this.O00000Oo.equals(o00000Oo.O00000Oo) && this.O00000o0.equals(o00000Oo.O00000o0);
        }

        public final int hashCode() {
            return ((((this.f2009O000000o.hashCode() + 527) * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode();
        }

        public final String toString() {
            return this.O00000Oo + iqk.O000000o(this.O00000o0.c);
        }
    }

    private joz(O000000o o000000o) {
        this.O00000Oo = jqp.O000000o(o000000o.f2008O000000o);
        this.O00000o0 = o000000o.O00000Oo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0044, code lost:
        if (r14.regionMatches(false, r4 + 1, r2.f2009O000000o, 2, r2.f2009O000000o.length() - 2) != false) goto L_0x0048;
     */
    public final void O000000o(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        int i;
        List emptyList = Collections.emptyList();
        Iterator<O00000Oo> it = this.O00000Oo.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            O00000Oo next = it.next();
            boolean z = true;
            if (!next.f2009O000000o.equals(str)) {
                int indexOf = str.indexOf(46);
                if (next.f2009O000000o.startsWith("*.")) {
                }
                z = false;
            }
            if (z) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                emptyList.add(next);
            }
        }
        if (!emptyList.isEmpty()) {
            jqn jqn = this.O00000o0;
            if (jqn != null) {
                list = new jqj(jqn).O000000o(list);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = emptyList.size();
                f fVar = null;
                f fVar2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    O00000Oo o00000Oo = (O00000Oo) emptyList.get(i3);
                    if (o00000Oo.O00000Oo.equals("sha256/")) {
                        if (fVar == null) {
                            fVar = O000000o(x509Certificate);
                        }
                        if (o00000Oo.O00000o0.equals(fVar)) {
                            return;
                        }
                    } else if (o00000Oo.O00000Oo.equals("sha1/")) {
                        if (fVar2 == null) {
                            fVar2 = jqp.O000000o(f.O000000o(x509Certificate.getPublicKey().getEncoded()));
                        }
                        if (o00000Oo.O00000o0.equals(fVar2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                }
            }
            StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i4 = 0; i4 < size3; i4++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb.append("\n    ");
                sb.append(O000000o((Certificate) x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = emptyList.size();
            for (i = 0; i < size4; i++) {
                sb.append("\n    ");
                sb.append((O00000Oo) emptyList.get(i));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public static String O000000o(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + iqk.O000000o(O000000o((X509Certificate) certificate).c);
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }
}
