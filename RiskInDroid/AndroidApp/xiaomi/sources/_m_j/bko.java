package _m_j;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inuker.bluetooth.library.search.SearchResult;
import java.lang.reflect.Method;

public class bko implements bkt, bld, Handler.Callback {
    private static bkt O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public bkq f13017O000000o;
    private Handler O00000o0 = new Handler(Looper.getMainLooper(), this);

    private bko() {
    }

    public static bkt O000000o() {
        if (O00000Oo == null) {
            synchronized (bko.class) {
                if (O00000Oo == null) {
                    bko bko = new bko();
                    O00000Oo = (bkt) blf.O000000o(bko, bkt.class, bko);
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o(bkq bkq, bkw bkw) {
        bkq.O00000Oo = new O000000o(bkw);
        if (!bkz.O00000Oo()) {
            bkq.O000000o();
            return;
        }
        O00000Oo();
        if (this.f13017O000000o == null) {
            this.f13017O000000o = bkq;
            bkq bkq2 = this.f13017O000000o;
            if (bkq2.O00000Oo != null) {
                bkq2.O00000Oo.O000000o();
            }
            boolean z = false;
            boolean z2 = false;
            for (bkr next : bkq2.f13020O000000o) {
                if (next.O000000o()) {
                    z = true;
                } else if (next.O00000Oo()) {
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("unknown search task type!");
                }
            }
            if (z) {
                bkq2.O00000Oo();
            }
            if (z2) {
                bkq2.O00000o0();
            }
            bkq2.O00000o0.sendEmptyMessageDelayed(17, 100);
        }
    }

    class O000000o implements bkw {

        /* renamed from: O000000o  reason: collision with root package name */
        bkw f13018O000000o;

        O000000o(bkw bkw) {
            this.f13018O000000o = bkw;
        }

        public final void O000000o() {
            this.f13018O000000o.O000000o();
        }

        public final void O000000o(SearchResult searchResult) {
            this.f13018O000000o.O000000o(searchResult);
        }

        public final void O00000Oo() {
            this.f13018O000000o.O00000Oo();
            bko.this.f13017O000000o = null;
        }

        public final void O00000o0() {
            this.f13018O000000o.O00000o0();
            bko.this.f13017O000000o = null;
        }
    }

    public final void O00000Oo() {
        bkq bkq = this.f13017O000000o;
        if (bkq != null) {
            bkq.O000000o();
            this.f13017O000000o = null;
        }
    }

    public final boolean O000000o(Object obj, Method method, Object[] objArr) {
        this.O00000o0.obtainMessage(0, new blc(obj, method, objArr)).sendToTarget();
        return true;
    }

    public boolean handleMessage(Message message) {
        ((blc) message.obj).O000000o();
        return true;
    }
}
