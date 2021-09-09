package _m_j;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public final class bqp extends SSLSocketFactory {
    private static KeyStore O00000Oo;
    private static bqp O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    private SSLContext f13201O000000o = SSLContext.getInstance("TLS");

    static {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            O00000Oo = instance;
            instance.load(null, null);
        } catch (Throwable th) {
            brm.O000000o(th.getMessage(), th);
        }
    }

    public static bqp O000000o() {
        if (O00000o0 == null) {
            try {
                O00000o0 = new bqp();
            } catch (Throwable th) {
                brm.O000000o(th.getMessage(), th);
            }
        }
        return O00000o0;
    }

    private bqp() throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        super(O00000Oo);
        AnonymousClass1 r0 = new X509TrustManager() {
            /* class _m_j.bqp.AnonymousClass1 */

            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        this.f13201O000000o.init(null, new TrustManager[]{r0}, null);
        setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return this.f13201O000000o.getSocketFactory().createSocket(socket, str, i, z);
    }

    public final Socket createSocket() throws IOException {
        return this.f13201O000000o.getSocketFactory().createSocket();
    }
}
