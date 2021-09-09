package _m_j;

import android.os.AsyncTask;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public final class gam extends AsyncTask<O00000Oo, Void, Void> {

    /* renamed from: O000000o  reason: collision with root package name */
    private DatagramSocket f17463O000000o;
    private WeakReference<O000000o> O00000Oo;

    public interface O000000o {
        void O000000o(gam gam);

        void O000000o(gam gam, RuntimeException runtimeException);

        void O000000o(gam gam, String str);
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        SocketAddress f17464O000000o;
        byte[] O00000Oo;
    }

    public gam(DatagramSocket datagramSocket, O000000o o000000o) {
        this.f17463O000000o = datagramSocket;
        this.O00000Oo = new WeakReference<>(o000000o);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public Void doInBackground(O00000Oo... o00000OoArr) {
        O000000o o000000o = this.O00000Oo.get();
        try {
            O00000Oo o00000Oo = o00000OoArr[0];
            this.f17463O000000o.send(new DatagramPacket(o00000Oo.O00000Oo, o00000Oo.O00000Oo.length, o00000Oo.f17464O000000o));
            if (o000000o == null) {
                return null;
            }
            o000000o.O000000o(this);
            return null;
        } catch (IOException e) {
            if (o000000o == null) {
                return null;
            }
            o000000o.O000000o(this, e.getMessage());
            return null;
        } catch (RuntimeException e2) {
            if (o000000o == null) {
                return null;
            }
            o000000o.O000000o(this, e2);
            return null;
        }
    }
}
