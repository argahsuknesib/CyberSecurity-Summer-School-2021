package _m_j;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import ss.ab;
import ss.g;

public final class jph {

    /* renamed from: O000000o  reason: collision with root package name */
    public final g f2019O000000o;
    public final List<Certificate> O00000Oo;
    private final List<Certificate> O00000o;
    private final ab O00000o0;

    private jph(ab abVar, g gVar, List<Certificate> list, List<Certificate> list2) {
        this.O00000o0 = abVar;
        this.f2019O000000o = gVar;
        this.O00000Oo = list;
        this.O00000o = list2;
    }

    public static jph O000000o(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            g a2 = g.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                ab a3 = ab.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                List O000000o2 = certificateArr != null ? jqp.O000000o(certificateArr) : Collections.emptyList();
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                return new jph(a3, a2, O000000o2, localCertificates != null ? jqp.O000000o(localCertificates) : Collections.emptyList());
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jph)) {
            return false;
        }
        jph jph = (jph) obj;
        return jqp.O000000o(this.f2019O000000o, jph.f2019O000000o) && this.f2019O000000o.equals(jph.f2019O000000o) && this.O00000Oo.equals(jph.O00000Oo) && this.O00000o.equals(jph.O00000o);
    }

    public final int hashCode() {
        ab abVar = this.O00000o0;
        return (((((((abVar != null ? abVar.hashCode() : 0) + 527) * 31) + this.f2019O000000o.hashCode()) * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o.hashCode();
    }
}
