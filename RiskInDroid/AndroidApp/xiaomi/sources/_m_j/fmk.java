package _m_j;

import android.os.Handler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class fmk {
    private static volatile fmk O00000oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f16651O000000o = false;
    public volatile Map<String, Integer> O00000Oo = new ConcurrentHashMap();
    public Handler O00000o;
    public gpq O00000o0;
    private final int O00000oO = 1;

    private fmk() {
    }

    public static fmk O000000o() {
        if (O00000oo == null) {
            synchronized (fmk.class) {
                if (O00000oo == null) {
                    O00000oo = new fmk();
                }
            }
        }
        return O00000oo;
    }
}
