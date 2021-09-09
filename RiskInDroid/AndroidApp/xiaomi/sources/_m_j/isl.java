package _m_j;

import android.os.Process;

public final class isl implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Runnable f1605O000000o;

    public isl(Runnable runnable) {
        this.f1605O000000o = runnable;
    }

    public final void run() {
        Process.setThreadPriority(10);
        this.f1605O000000o.run();
    }
}
