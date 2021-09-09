package ss.ss;

import java.util.concurrent.ThreadFactory;

public class i$1 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f15495a;
    final /* synthetic */ boolean b;

    public i$1(String str, boolean z) {
        this.f15495a = str;
        this.b = z;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f15495a);
        thread.setDaemon(this.b);
        return thread;
    }
}
