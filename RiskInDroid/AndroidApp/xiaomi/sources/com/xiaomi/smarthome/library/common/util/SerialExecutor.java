package com.xiaomi.smarthome.library.common.util;

import android.os.AsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor {
    Runnable mActive;
    final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() {
            /* class com.xiaomi.smarthome.library.common.util.SerialExecutor.AnonymousClass1 */

            public final void run() {
                try {
                    runnable.run();
                } finally {
                    SerialExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
        }
    }
}
