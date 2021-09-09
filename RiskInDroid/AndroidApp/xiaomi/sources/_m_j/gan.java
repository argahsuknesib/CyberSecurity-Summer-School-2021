package _m_j;

import _m_j.gal;
import _m_j.gam;
import android.util.Base64;
import com.facebook.react.bridge.Callback;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class gan implements gal.O000000o, gam.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final boolean f17465O000000o;
    public gal O00000Oo;
    public boolean O00000o;
    public DatagramSocket O00000o0;
    private final O00000Oo O00000oO;
    private final O00000o0 O00000oo;
    private final Map<gam, Callback> O0000O0o;

    public interface O00000Oo {
        void didReceiveData(gan gan, String str, String str2, int i);

        void didReceiveError(gan gan, String str);
    }

    public interface O00000o0 {
        void didReceiveException(RuntimeException runtimeException);
    }

    public /* synthetic */ gan(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private gan(O000000o o000000o) {
        this.O00000o = false;
        this.O00000oO = o000000o.f17466O000000o;
        this.O00000oo = o000000o.O00000Oo;
        this.f17465O000000o = o000000o.O00000o0;
        this.O0000O0o = new ConcurrentHashMap();
    }

    public final void O000000o(String str, Integer num, String str2, Callback callback) throws UnknownHostException, IllegalStateException, IOException {
        DatagramSocket datagramSocket = this.O00000o0;
        if (datagramSocket == null || !datagramSocket.isBound()) {
            throw new IllegalStateException("Socket is not bound.");
        }
        byte[] decode = Base64.decode(str, 2);
        gam gam = new gam(this.O00000o0, this);
        gam.O00000Oo o00000Oo = new gam.O00000Oo();
        o00000Oo.O00000Oo = decode;
        o00000Oo.f17464O000000o = new InetSocketAddress(InetAddress.getByName(str2), num.intValue());
        if (callback != null) {
            synchronized (this.O0000O0o) {
                this.O0000O0o.put(gam, callback);
            }
        }
        gam.execute(o00000Oo);
    }

    public final void O000000o() throws IOException {
        gal gal = this.O00000Oo;
        if (gal != null && !gal.isCancelled()) {
            this.O00000Oo.cancel(true);
        }
        DatagramSocket datagramSocket = this.O00000o0;
        if (datagramSocket != null && !datagramSocket.isClosed()) {
            this.O00000o0.close();
            this.O00000o0 = null;
        }
    }

    public final void O000000o(String str, String str2, int i) {
        this.O00000oO.didReceiveData(this, str, str2, i);
    }

    public final void O000000o(String str) {
        this.O00000oO.didReceiveError(this, str);
    }

    public final void O000000o(RuntimeException runtimeException) {
        this.O00000oo.didReceiveException(runtimeException);
    }

    public final void O000000o(gam gam) {
        Callback callback;
        synchronized (this.O0000O0o) {
            callback = this.O0000O0o.get(gam);
            this.O0000O0o.remove(gam);
        }
        if (callback != null) {
            callback.invoke(new Object[0]);
        }
    }

    public final void O000000o(gam gam, String str) {
        Callback callback;
        synchronized (this.O0000O0o) {
            callback = this.O0000O0o.get(gam);
            this.O0000O0o.remove(gam);
        }
        if (callback != null) {
            callback.invoke(gak.O000000o(str));
        }
    }

    public final void O000000o(gam gam, RuntimeException runtimeException) {
        this.O00000oo.didReceiveException(runtimeException);
        synchronized (this.O0000O0o) {
            this.O0000O0o.remove(gam);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public O00000Oo f17466O000000o;
        public O00000o0 O00000Oo;
        public boolean O00000o0 = true;

        public O000000o(O00000Oo o00000Oo, O00000o0 o00000o0) {
            this.f17466O000000o = o00000Oo;
            this.O00000Oo = o00000o0;
        }
    }
}
