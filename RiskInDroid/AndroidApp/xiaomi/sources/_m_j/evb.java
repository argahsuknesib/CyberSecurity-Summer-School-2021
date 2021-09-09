package _m_j;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

public abstract class evb {

    /* renamed from: O000000o  reason: collision with root package name */
    private final long f15839O000000o;
    public final long O00000Oo;
    public boolean O00000o = false;
    public long O00000o0;
    public boolean O00000oO = false;
    private Handler O00000oo = new Handler() {
        /* class _m_j.evb.AnonymousClass1 */

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
            return;
         */
        public final void handleMessage(Message message) {
            synchronized (evb.this) {
                if (!evb.this.O00000o) {
                    if (!evb.this.O00000oO) {
                        long elapsedRealtime = evb.this.O00000o0 - SystemClock.elapsedRealtime();
                        if (elapsedRealtime <= 0) {
                            evb.this.O000000o();
                        } else {
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            evb.this.O000000o(elapsedRealtime);
                            long elapsedRealtime3 = (elapsedRealtime2 + evb.this.O00000Oo) - SystemClock.elapsedRealtime();
                            while (elapsedRealtime3 < 0) {
                                elapsedRealtime3 += evb.this.O00000Oo;
                            }
                            sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                        }
                    }
                }
            }
        }
    };

    public abstract void O000000o();

    public abstract void O000000o(long j);

    public evb(long j, long j2) {
        this.f15839O000000o = j2 > 1000 ? j + 15 : j;
        this.O00000Oo = j2;
    }

    private synchronized evb O00000Oo(long j) {
        this.O00000o = false;
        if (j <= 0) {
            O000000o();
            return this;
        }
        this.O00000o0 = SystemClock.elapsedRealtime() + j;
        this.O00000oo.sendMessage(this.O00000oo.obtainMessage(1));
        return this;
    }

    public final synchronized void O00000Oo() {
        O00000Oo(this.f15839O000000o);
    }

    public final synchronized void O00000o0() {
        this.O00000o = true;
        this.O00000oo.removeMessages(1);
    }
}
