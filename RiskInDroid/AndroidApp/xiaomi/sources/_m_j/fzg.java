package _m_j;

import _m_j.fzd;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.os.AsyncTask;
import com.facebook.react.bridge.ReadableMap;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;

public final class fzg extends fze {
    public ServerSocket O00000Oo;
    int O00000o;
    public fzd.O000000o O00000o0;
    public final ConcurrentHashMap<Integer, fze> O00000oO;
    @SuppressLint({"StaticFieldLeak"})
    private final AsyncTask O00000oo = new AsyncTask() {
        /* class _m_j.fzg.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return O000000o();
        }

        private Void O000000o() {
            while (!isCancelled() && !fzg.this.O00000Oo.isClosed()) {
                try {
                    Socket accept = fzg.this.O00000Oo.accept();
                    fzg fzg = fzg.this;
                    int i = fzg.O00000o;
                    fzg.O00000o = i + 1;
                    fze fze = new fze(fzg.this.O00000o0, Integer.valueOf(i), accept);
                    fzg.this.O00000oO.put(Integer.valueOf(i), fze);
                    fzg.this.O00000o0.onConnection(Integer.valueOf(fzg.this.O000000o()), Integer.valueOf(i), new InetSocketAddress(accept.getInetAddress(), accept.getPort()));
                    fze.O00000o0();
                } catch (IOException e) {
                    if (fzg.this.O00000Oo.isClosed()) {
                        return null;
                    }
                    fzg.this.O00000o0.onError(Integer.valueOf(fzg.this.O000000o()), e.getMessage());
                    return null;
                }
            }
            return null;
        }
    };

    public final /* bridge */ /* synthetic */ int O000000o() {
        return super.O000000o();
    }

    public final /* bridge */ /* synthetic */ void O000000o(Context context, String str, Integer num, ReadableMap readableMap, Network network) throws IOException, GeneralSecurityException {
        super.O000000o(context, str, num, readableMap, network);
    }

    public final /* bridge */ /* synthetic */ void O000000o(boolean z) throws IOException {
        super.O000000o(z);
    }

    public final /* bridge */ /* synthetic */ void O000000o(boolean z, int i) throws IOException {
        super.O000000o(z, i);
    }

    public final /* bridge */ /* synthetic */ Socket O00000Oo() {
        return super.O00000Oo();
    }

    public final /* bridge */ /* synthetic */ void O00000o0() {
        super.O00000o0();
    }

    public fzg(ConcurrentHashMap<Integer, fze> concurrentHashMap, fzd.O000000o o000000o, Integer num, ReadableMap readableMap) throws IOException {
        super(num.intValue());
        int i = readableMap.getInt("port");
        String string = readableMap.getString("host");
        this.O00000oO = concurrentHashMap;
        this.O00000o = (super.O000000o() + 1) * 1000;
        this.O00000Oo = new ServerSocket(i, 50, InetAddress.getByName(string));
        try {
            this.O00000Oo.setReuseAddress(readableMap.getBoolean("reuseAddress"));
        } catch (Exception unused) {
            this.O00000Oo.setReuseAddress(true);
        }
        this.O00000o0 = o000000o;
        this.O00000oo.executeOnExecutor(this.f17431O000000o, new Object[0]);
    }

    public final void O000000o(byte[] bArr) {
        this.O00000o0.onError(Integer.valueOf(super.O000000o()), "SERVER CANNOT WRITE");
    }

    public final void O00000o() {
        try {
            if (!this.O00000oo.isCancelled()) {
                this.O00000oo.cancel(true);
                this.f17431O000000o.shutdown();
            }
            if (this.O00000Oo != null && !this.O00000Oo.isClosed()) {
                this.O00000Oo.close();
                this.O00000o0.onClose(Integer.valueOf(super.O000000o()), null);
                this.O00000Oo = null;
            }
        } catch (IOException e) {
            this.O00000o0.onClose(Integer.valueOf(super.O000000o()), e.getMessage());
        }
    }
}
