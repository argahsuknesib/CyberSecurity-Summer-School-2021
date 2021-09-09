package com.xiaomi.accountsdk.request;

import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class TlsCompatSocketFactory extends SSLSocketFactory {
    private static final String[] PROTOCOL_ARRAY;
    final SSLSocketFactory delegate;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            PROTOCOL_ARRAY = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};
        } else if (Build.VERSION.SDK_INT >= 26) {
            PROTOCOL_ARRAY = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else if (Build.VERSION.SDK_INT >= 16) {
            PROTOCOL_ARRAY = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            PROTOCOL_ARRAY = new String[]{"SSLv3", "TLSv1"};
        }
    }

    public TlsCompatSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return patch(this.delegate.createSocket(socket, str, i, z));
    }

    public Socket createSocket(String str, int i) throws IOException {
        return patch(this.delegate.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return patch(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return patch(this.delegate.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return patch(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private Socket patch(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(PROTOCOL_ARRAY);
        }
        return socket;
    }

    public static SSLSocketFactory sslSocketFactory() throws NoSuchAlgorithmException, KeyStoreException, IllegalStateException, KeyManagementException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{systemDefaultTrustManager()}, null);
        return new TlsCompatSocketFactory(instance.getSocketFactory());
    }

    private static X509TrustManager systemDefaultTrustManager() throws NoSuchAlgorithmException, KeyStoreException, IllegalStateException {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        TrustManager[] trustManagers = instance.getTrustManagers();
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            return (X509TrustManager) trustManagers[0];
        }
        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
    }
}
