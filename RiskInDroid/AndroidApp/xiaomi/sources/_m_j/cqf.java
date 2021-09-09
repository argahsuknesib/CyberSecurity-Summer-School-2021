package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class cqf {
    private static final ConcurrentHashMap<String, WeakReference<cqf>> O00000o = new ConcurrentHashMap<>(4);
    private static final cpo O00000o0 = cpo.O000000o(cqf.class.getSimpleName());

    /* renamed from: O000000o  reason: collision with root package name */
    HandlerThread f14236O000000o;
    Handler O00000Oo = new Handler(this.f14236O000000o.getLooper());

    public static cqf O000000o(String str) {
        if (O00000o.containsKey(str)) {
            cqf cqf = (cqf) O00000o.get(str).get();
            if (cqf != null) {
                HandlerThread handlerThread = cqf.f14236O000000o;
                if (handlerThread.isAlive() && !handlerThread.isInterrupted()) {
                    O00000o0.O000000o(2, "get:", "Reusing cached worker handler.", str);
                    return cqf;
                }
            }
            O00000o0.O000000o(2, "get:", "Thread reference died, removing.", str);
            O00000o.remove(str);
        }
        O00000o0.O000000o(1, "get:", "Creating new handler.", str);
        cqf cqf2 = new cqf(str);
        O00000o.put(str, new WeakReference(cqf2));
        return cqf2;
    }

    private cqf(String str) {
        this.f14236O000000o = new HandlerThread(str);
        this.f14236O000000o.setDaemon(true);
        this.f14236O000000o.start();
    }

    public final void O000000o(Runnable runnable) {
        this.O00000Oo.post(runnable);
    }
}
