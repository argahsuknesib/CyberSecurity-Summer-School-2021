package androidx.arch.core.executor;

import _m_j.o0O0000O;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTaskExecutor$1 implements ThreadFactory {
    private final AtomicInteger mThreadId = new AtomicInteger(0);
    final /* synthetic */ o0O0000O this$0;

    public DefaultTaskExecutor$1(o0O0000O o0o0000o) {
        this.this$0 = o0o0000o;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.mThreadId.getAndIncrement())));
        return thread;
    }
}
