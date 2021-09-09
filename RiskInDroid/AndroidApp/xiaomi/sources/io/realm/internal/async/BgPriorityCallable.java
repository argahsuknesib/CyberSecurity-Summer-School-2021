package io.realm.internal.async;

import android.os.Process;
import java.util.concurrent.Callable;

public class BgPriorityCallable<T> implements Callable<T> {
    private final Callable<T> callable;

    BgPriorityCallable(Callable<T> callable2) {
        this.callable = callable2;
    }

    public T call() throws Exception {
        Process.setThreadPriority(10);
        return this.callable.call();
    }
}
