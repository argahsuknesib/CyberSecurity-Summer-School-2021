package _m_j;

import com.lidroid.xutils.task.Priority;

public final class brj extends bri<Runnable> implements Runnable {
    public brj(Priority priority, Runnable runnable) {
        super(priority, runnable);
    }

    public final void run() {
        ((Runnable) this.O00000Oo).run();
    }
}
