package _m_j;

import android.os.Handler;
import android.os.Message;

public final class gov {

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f18099O000000o;
    Handler O00000Oo;
    O000000o O00000o;
    long O00000o0;
    public long O00000oO;
    public Runnable O00000oo;
    boolean O0000O0o;

    public interface O000000o {
        void O000000o();
    }

    public gov() {
        this.f18099O000000o = false;
        this.O0000O0o = false;
        this.f18099O000000o = false;
    }

    public final void O000000o() {
        this.O00000Oo = new Handler() {
            /* class _m_j.gov.AnonymousClass1 */

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i != 10) {
                    if (i == 11 && gov.this.O0000O0o && gov.this.O00000Oo == this) {
                        gov.this.O00000Oo.removeMessages(10);
                        gov gov = gov.this;
                        gov.O0000O0o = false;
                        gov.O00000Oo = null;
                        if (gov.O00000oo != null) {
                            gov.this.O00000oo.run();
                        }
                    }
                } else if (gov.this.O0000O0o && gov.this.O00000Oo == this) {
                    gov.this.O00000o.O000000o();
                    if (gov.this.f18099O000000o && gov.this.O00000o0 > 0) {
                        sendEmptyMessageDelayed(10, gov.this.O00000o0);
                    }
                }
            }
        };
        this.O0000O0o = true;
        this.O00000Oo.sendEmptyMessage(10);
        long j = this.O00000oO;
        if (j > 0 && this.O00000oo != null) {
            this.O00000Oo.sendEmptyMessageDelayed(11, j);
        }
    }

    public final void O00000Oo() {
        this.O0000O0o = false;
        Handler handler = this.O00000Oo;
        if (handler != null) {
            handler.removeMessages(10);
            this.O00000Oo.removeMessages(11);
            this.O00000Oo = null;
        }
    }

    public final void O00000o0() {
        this.O00000Oo.sendEmptyMessageDelayed(10, this.O00000o0);
    }

    public final void O000000o(O000000o o000000o, long j) {
        this.O00000o = o000000o;
        this.O00000o0 = j;
    }
}
