package _m_j;

import _m_j.gng;
import _m_j.gnh;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C;
import java.util.UUID;

public abstract class gnc {

    /* renamed from: O000000o  reason: collision with root package name */
    int f18038O000000o;
    UUID[] O00000Oo;
    private gnd O00000o;
    private int O00000o0;
    private Handler O00000oO;

    public gnc(int i) {
        this(i, (byte) 0);
    }

    private gnc(int i, byte b) {
        this.O00000o0 = i;
        this.f18038O000000o = C.MSG_CUSTOM_BASE;
    }

    public final boolean O000000o() {
        return this.O00000o0 == 2;
    }

    public final boolean O00000Oo() {
        return this.O00000o0 == 1;
    }

    public final gnd O00000o0() {
        gnd gnd;
        if (this.O00000o == null) {
            int i = this.O00000o0;
            if (i == 1) {
                gnd = gng.O000000o.f18041O000000o;
            } else if (i == 2) {
                gnd = gnh.O000000o.f18044O000000o;
            } else {
                throw new IllegalStateException(String.format("unknown search type %d", Integer.valueOf(i)));
            }
            this.O00000o = gnd;
        }
        return this.O00000o;
    }

    public final void O000000o(gna gna) {
        O00000o0().O000000o(this.O00000Oo, gna);
        int i = this.f18038O000000o;
        if (this.O00000oO == null) {
            this.O00000oO = new Handler(Looper.myLooper()) {
                /* class _m_j.gnc.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    if (message.what == 34) {
                        gnc.this.O00000o0().O000000o();
                    }
                }
            };
        }
        this.O00000oO.sendMessageDelayed(this.O00000oO.obtainMessage(34), (long) i);
    }

    public final void O00000o() {
        this.O00000oO.removeCallbacksAndMessages(null);
        O00000o0().O00000Oo();
    }

    public String toString() {
        String str;
        if (O000000o()) {
            str = "Ble";
        } else {
            str = O00000Oo() ? "classic" : "unknown";
        }
        int i = this.f18038O000000o;
        if (i >= 1000) {
            return String.format("%s search (%ds)", str, Integer.valueOf(i / 1000));
        }
        double d = (double) i;
        Double.isNaN(d);
        return String.format("%s search (%.1fs)", str, Double.valueOf((d * 1.0d) / 1000.0d));
    }
}
