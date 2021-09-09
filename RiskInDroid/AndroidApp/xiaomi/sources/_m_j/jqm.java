package _m_j;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.security.auth.x500.X500Principal;

public final class jqm implements jqn {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<X500Principal, List<X509Certificate>> f2060O000000o = new LinkedHashMap();

    public jqm(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Object obj = this.f2060O000000o.get(subjectX500Principal);
            if (obj == null) {
                obj = new ArrayList(1);
                this.f2060O000000o.put(subjectX500Principal, obj);
            }
            obj.add(x509Certificate);
        }
    }

    public final X509Certificate O000000o(X509Certificate x509Certificate) {
        List<X509Certificate> list = this.f2060O000000o.get(x509Certificate.getIssuerX500Principal());
        if (list == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : list) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
