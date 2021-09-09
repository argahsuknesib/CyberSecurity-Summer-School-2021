package _m_j;

import android.content.Context;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class cqr extends SSLSocketFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    private volatile SSLContext f14257O000000o;

    public cqr(Context context, cqn cqn) {
        AnonymousClass1 r0 = new X509TrustManager() {
            /* class _m_j.cqr.AnonymousClass1 */

            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            }

            public final X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        if (cqn != null) {
            try {
                if (cqn.O00000Oo != null) {
                    cqs.O000000o("Reading the certificate " + cqn.O00000Oo + ".p12");
                    KeyStore instance = KeyStore.getInstance("pkcs12");
                    instance.load(context.getResources().openRawResource(context.getResources().getIdentifier(cqn.O00000Oo, "raw", context.getPackageName())), cqn.f14254O000000o.toCharArray());
                    Enumeration<String> aliases = instance.aliases();
                    while (aliases.hasMoreElements()) {
                        cqs.O000000o(instance.getCertificate(aliases.nextElement().toString()).toString());
                    }
                    KeyManagerFactory instance2 = KeyManagerFactory.getInstance("X509");
                    instance2.init(instance, cqn.f14254O000000o.toCharArray());
                    this.f14257O000000o = SSLContext.getInstance("TLS");
                    this.f14257O000000o.init(instance2.getKeyManagers(), new TrustManager[]{r0}, null);
                    cqs.O000000o("Client certificate attached.");
                    return;
                }
            } catch (Exception e) {
                cqs.O000000o("Exception while attaching Client certificate.");
                cqs.O000000o(e);
                try {
                    cqs.O000000o("so, setting only the trust manager");
                    this.f14257O000000o = SSLContext.getInstance("TLS");
                    this.f14257O000000o.init(null, new TrustManager[]{r0}, null);
                    cqs.O000000o("set trust manager");
                    return;
                } catch (Exception e2) {
                    cqs.O000000o("Exception while setting the trust manager");
                    cqs.O000000o(e2);
                    return;
                }
            }
        }
        cqs.O000000o("Client certificate is not found");
        cqs.O000000o("so, setting only the trust manager");
        this.f14257O000000o = SSLContext.getInstance("TLS");
        this.f14257O000000o.init(null, new TrustManager[]{r0}, null);
        cqs.O000000o("set trust manager");
    }

    public final synchronized Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.f14257O000000o != null) {
            return this.f14257O000000o.getSocketFactory().createSocket(socket, str, i, z);
        }
        return getDefault().createSocket(str, i);
    }

    public final synchronized String[] getDefaultCipherSuites() {
        return null;
    }

    public final synchronized String[] getSupportedCipherSuites() {
        return null;
    }

    public final synchronized Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        if (this.f14257O000000o != null) {
            return this.f14257O000000o.getSocketFactory().createSocket(str, i);
        }
        return getDefault().createSocket(str, i);
    }

    public final synchronized Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.f14257O000000o != null) {
            return this.f14257O000000o.getSocketFactory().createSocket(inetAddress, i);
        }
        return getDefault().createSocket(inetAddress, i);
    }

    public final synchronized Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        if (this.f14257O000000o != null) {
            return this.f14257O000000o.getSocketFactory().createSocket(str, i, inetAddress, i2);
        }
        return getDefault().createSocket(str, i);
    }

    public final synchronized Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.f14257O000000o != null) {
            return this.f14257O000000o.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        }
        return getDefault().createSocket(inetAddress, i, inetAddress2, i2);
    }
}
