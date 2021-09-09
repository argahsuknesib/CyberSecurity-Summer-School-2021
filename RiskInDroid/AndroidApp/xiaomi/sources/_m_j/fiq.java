package _m_j;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public final class fiq {
    public static X509Certificate O000000o() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            InputStream open = glc.O0000O0o.getAssets().open("MijiaRootCert.der");
            X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(open);
            open.close();
            return x509Certificate;
        } catch (CertificateException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean O000000o(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
