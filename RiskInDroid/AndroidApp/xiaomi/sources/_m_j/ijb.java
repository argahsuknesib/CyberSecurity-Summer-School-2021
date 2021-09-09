package _m_j;

import android.os.Handler;
import com.ximalaya.ting.android.opensdk.httputil.ExecutorDelivery$1;
import java.util.concurrent.Executor;

public final class ijb {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Executor f1356O000000o;

    public ijb(Handler handler) {
        this.f1356O000000o = new ExecutorDelivery$1(this, handler);
    }

    public final <T> void O000000o(iiw<T> iiw, T t) {
        this.f1356O000000o.execute(new O000000o(t, iiw));
    }

    public final <T> void O000000o(int i, String str, iiw<T> iiw) {
        this.f1356O000000o.execute(new O000000o(i, str, iiw));
    }

    class O000000o<T> implements Runnable {
        private int O00000Oo;
        private iiw<T> O00000o;
        private String O00000o0;
        private T O00000oO;
        private int O00000oo = 1;

        public O000000o(int i, String str, T t) {
            this.O00000Oo = i;
            this.O00000o0 = str;
            this.O00000o = t;
            this.O00000oO = null;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [int, T] */
        /* JADX WARNING: Unknown variable types count: 1 */
        public O000000o(int r2, iiw<T> iiw) {
            this.O00000o = iiw;
            this.O00000oO = r2;
        }

        public final void run() {
            int i = this.O00000oo;
            if (i == 0) {
                this.O00000o.O000000o(this.O00000oO);
            } else if (i == 1) {
                this.O00000o.O000000o(this.O00000Oo, this.O00000o0);
            }
        }
    }
}
