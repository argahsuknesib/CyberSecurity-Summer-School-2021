package _m_j;

import com.tencent.bugly.proguard.w$1;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class dic {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dic f14659O000000o;
    private ScheduledExecutorService O00000Oo;

    protected dic() {
        this.O00000Oo = null;
        this.O00000Oo = Executors.newScheduledThreadPool(3, new w$1(this));
        ScheduledExecutorService scheduledExecutorService = this.O00000Oo;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            did.O00000o("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized dic O000000o() {
        dic dic;
        synchronized (dic.class) {
            if (f14659O000000o == null) {
                f14659O000000o = new dic();
            }
            dic = f14659O000000o;
        }
        return dic;
    }

    public final synchronized boolean O000000o(Runnable runnable, long j) {
        if (!O00000o0()) {
            did.O00000o("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j <= 0) {
            j = 0;
        }
        did.O00000o0("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
        try {
            this.O00000Oo.schedule(runnable, j, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (dgm.O00000o0) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean O000000o(Runnable runnable) {
        if (!O00000o0()) {
            did.O00000o("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            did.O00000o("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            did.O00000o0("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            try {
                this.O00000Oo.execute(runnable);
                return true;
            } catch (Throwable th) {
                if (dgm.O00000o0) {
                    th.printStackTrace();
                }
                return false;
            }
        }
    }

    public final synchronized void O00000Oo() {
        if (this.O00000Oo != null && !this.O00000Oo.isShutdown()) {
            did.O00000o0("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.O00000Oo.shutdownNow();
        }
    }

    public final synchronized boolean O00000o0() {
        return this.O00000Oo != null && !this.O00000Oo.isShutdown();
    }
}
