package _m_j;

import android.os.Handler;
import android.os.Looper;
import androidx.arch.core.executor.DefaultTaskExecutor$1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class o0O0000O extends o0O000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Object f2229O000000o = new Object();
    private final ExecutorService O00000Oo = Executors.newFixedThreadPool(2, new DefaultTaskExecutor$1(this));
    private volatile Handler O00000o0;

    public final void O000000o(Runnable runnable) {
        this.O00000Oo.execute(runnable);
    }

    public final void O00000Oo(Runnable runnable) {
        if (this.O00000o0 == null) {
            synchronized (this.f2229O000000o) {
                if (this.O00000o0 == null) {
                    this.O00000o0 = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.O00000o0.post(runnable);
    }

    public final boolean O00000Oo() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
