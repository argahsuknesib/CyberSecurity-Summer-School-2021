package _m_j;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

public final class fkb extends SSLSocketFactory {
    private static final String[] O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    final SSLSocketFactory f16510O000000o;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            O00000Oo = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else if (Build.VERSION.SDK_INT >= 16) {
            O00000Oo = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            O00000Oo = new String[]{"SSLv3", "TLSv1"};
        }
    }

    private fkb(SSLSocketFactory sSLSocketFactory) {
        this.f16510O000000o = sSLSocketFactory;
    }

    public final String[] getDefaultCipherSuites() {
        return this.f16510O000000o.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f16510O000000o.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return O000000o(this.f16510O000000o.createSocket(socket, str, i, z));
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return O000000o(this.f16510O000000o.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return O000000o(this.f16510O000000o.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return O000000o(this.f16510O000000o.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return O000000o(this.f16510O000000o.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private static Socket O000000o(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(O00000Oo);
        }
        return socket;
    }

    public static SSLSocketFactory O000000o() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{O00000Oo()}, null);
            return new fkb(instance.getSocketFactory());
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public static X509TrustManager O00000Oo() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public static void O000000o(OkHttpClient.Builder builder) {
        builder.sslSocketFactory(O000000o(), O00000Oo());
        Log.i("TlsCompatSocketFactory", "injectSslSocketFactory", new Exception());
    }
}
