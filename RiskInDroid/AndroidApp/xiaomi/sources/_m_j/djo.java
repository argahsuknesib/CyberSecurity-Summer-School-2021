package _m_j;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;

@TargetApi(17)
public final class djo implements LayeredSocketFactory {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final HostnameVerifier f14724O000000o = new StrictHostnameVerifier();
    private static final SSLCertificateSocketFactory O00000Oo = ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0, null));

    public final Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException {
        socket.connect(new InetSocketAddress(str, i));
        return socket;
    }

    public final Socket createSocket() {
        return new Socket();
    }

    public final boolean isSecure(Socket socket) throws IllegalArgumentException {
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).isConnected();
        }
        return false;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        diz.O000000o("openSDK_LOG.SNISocketFactory", "createSocket " + socket.toString() + " host:" + str + " port:" + i + " autoClose:" + z);
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLSocket sSLSocket = (SSLSocket) O00000Oo.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            diz.O000000o("openSDK_LOG.SNISocketFactory", "Setting SNI hostname");
            O00000Oo.setHostname(sSLSocket, str);
        } else {
            diz.O000000o("openSDK_LOG.SNISocketFactory", "No documented SNI support on Android <4.2, trying with reflection");
            try {
                sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
            } catch (Exception unused) {
                diz.O000000o("openSDK_LOG.SNISocketFactory", "SNI not useable");
            }
        }
        if (f14724O000000o.verify(str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(String.valueOf(str)));
    }
}
