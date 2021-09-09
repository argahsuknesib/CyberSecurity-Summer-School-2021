package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;

public class bmf {
    private static bmf O0000Ooo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<Long, Integer> f13094O000000o = new HashMap();
    public SparseArray<Handler> O00000Oo = new SparseArray<>();
    public HandlerThread O00000o = null;
    public Handler O00000o0 = null;
    public HandlerThread O00000oO = null;
    public HandlerThread O00000oo = null;
    public HandlerThread O0000O0o = null;
    public Handler O0000OOo = null;
    public Handler O0000Oo = null;
    public Handler O0000Oo0 = null;
    public Handler O0000OoO = null;

    private bmf() {
    }

    private Handler O000000o(int i) {
        return this.O00000Oo.get(i);
    }

    public static bmf O00000Oo() {
        if (O0000Ooo == null) {
            synchronized (bmf.class) {
                if (O0000Ooo == null) {
                    O0000Ooo = new bmf();
                }
            }
        }
        return O0000Ooo;
    }

    public final int O000000o() {
        return this.f13094O000000o.get(Long.valueOf(Thread.currentThread().getId())).intValue();
    }

    public final void O000000o(Runnable runnable, int i) {
        O000000o(runnable, i, false, 0, false);
    }

    public final void O000000o(Runnable runnable, int i, long j, boolean z) {
        O000000o(runnable, i, false, j, z);
    }

    public final void O000000o(Runnable runnable, int i, boolean z, long j, boolean z2) {
        Handler O000000o2 = O000000o(i);
        if (O000000o2 == null) {
            bmz.O00000o("TaskExecutor", "execute failed: known thread flag.", new Object[0]);
            return;
        }
        if (z2) {
            O000000o2.removeCallbacks(runnable);
        }
        if (z) {
            O000000o2.postAtFrontOfQueue(runnable);
        } else {
            O000000o2.postDelayed(runnable, j);
        }
    }
}
