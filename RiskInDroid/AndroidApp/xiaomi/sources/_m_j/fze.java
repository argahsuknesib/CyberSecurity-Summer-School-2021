package _m_j;

import _m_j.fzd;
import android.content.Context;
import android.net.Network;
import android.util.Pair;
import com.facebook.react.bridge.ReadableMap;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class fze {

    /* renamed from: O000000o  reason: collision with root package name */
    final ExecutorService f17431O000000o;
    private final int O00000Oo;
    private Socket O00000o;
    private fzd O00000o0;
    private fzd.O000000o O00000oO;

    fze(int i) {
        this.O00000Oo = i;
        this.f17431O000000o = Executors.newFixedThreadPool(1);
    }

    public fze(fzd.O000000o o000000o, Integer num, Socket socket) {
        this(num.intValue());
        this.O00000o = socket;
        this.O00000o0 = new fzd();
        this.O00000oO = o000000o;
    }

    public int O000000o() {
        return this.O00000Oo;
    }

    public Socket O00000Oo() {
        return this.O00000o;
    }

    public void O000000o(Context context, String str, Integer num, ReadableMap readableMap, Network network) throws IOException, GeneralSecurityException {
        SocketFactory socketFactory;
        InputStream inputStream;
        if (this.O00000o == null) {
            int i = 0;
            boolean z = readableMap.hasKey("tls") && readableMap.getBoolean("tls");
            if (!z) {
                this.O00000o = new Socket();
            } else if (!readableMap.hasKey("tlsCheckValidity") || readableMap.getBoolean("tlsCheckValidity")) {
                String string = readableMap.hasKey("tlsCert") ? readableMap.getString("tlsCert") : null;
                if (string != null) {
                    int O000000o2 = fzc.O000000o(context, string);
                    if (O000000o2 == 0) {
                        inputStream = URI.create(string).toURL().openStream();
                    } else {
                        inputStream = context.getResources().openRawResource(O000000o2);
                    }
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
                    inputStream.close();
                    KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                    instance.load(null, null);
                    instance.setCertificateEntry("ca", generateCertificate);
                    TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    instance2.init(instance);
                    SSLContext instance3 = SSLContext.getInstance("TLS");
                    instance3.init(null, instance2.getTrustManagers(), new SecureRandom());
                    socketFactory = instance3.getSocketFactory();
                } else {
                    socketFactory = SSLSocketFactory.getDefault();
                }
                SSLSocket sSLSocket = (SSLSocket) socketFactory.createSocket();
                sSLSocket.setUseClientMode(true);
                this.O00000o = sSLSocket;
            } else {
                throw new GeneralSecurityException("tlsCheckValidity cannot set as false");
            }
            InetAddress byName = InetAddress.getByName(readableMap.hasKey("localAddress") ? readableMap.getString("localAddress") : "0.0.0.0");
            InetAddress byName2 = InetAddress.getByName(str);
            if (network != null) {
                network.bindSocket(this.O00000o);
            }
            if (readableMap.hasKey("reuseAddress")) {
                this.O00000o.setReuseAddress(readableMap.getBoolean("reuseAddress"));
            } else {
                this.O00000o.setReuseAddress(true);
            }
            if (readableMap.hasKey("localPort")) {
                i = readableMap.getInt("localPort");
            }
            this.O00000o.bind(new InetSocketAddress(byName, i));
            this.O00000o.connect(new InetSocketAddress(byName2, num.intValue()));
            if (z) {
                ((SSLSocket) this.O00000o).startHandshake();
            }
            O00000o0();
            return;
        }
        throw new IOException("Already connected");
    }

    public void O00000o0() {
        this.O00000o0.executeOnExecutor(this.f17431O000000o, new Pair(this, this.O00000oO));
    }

    public void O000000o(byte[] bArr) throws IOException {
        Socket socket = this.O00000o;
        if (socket != null) {
            socket.getOutputStream().write(bArr);
            return;
        }
        throw new IOException("Socket is not connected.");
    }

    public void O00000o() {
        try {
            if (this.O00000o0 != null && !this.O00000o0.isCancelled()) {
                this.O00000o0.cancel(true);
                this.f17431O000000o.shutdown();
            }
            if (this.O00000o != null && !this.O00000o.isClosed()) {
                this.O00000o.close();
                this.O00000oO.onClose(Integer.valueOf(O000000o()), null);
                this.O00000o = null;
            }
        } catch (IOException e) {
            this.O00000oO.onClose(Integer.valueOf(O000000o()), e.getMessage());
        }
    }

    public void O000000o(boolean z) throws IOException {
        Socket socket = this.O00000o;
        if (socket != null) {
            socket.setTcpNoDelay(z);
            return;
        }
        throw new IOException("Socket is not connected.");
    }

    public void O000000o(boolean z, int i) throws IOException {
        Socket socket = this.O00000o;
        if (socket != null) {
            socket.setKeepAlive(z);
            return;
        }
        throw new IOException("Socket is not connected.");
    }
}
