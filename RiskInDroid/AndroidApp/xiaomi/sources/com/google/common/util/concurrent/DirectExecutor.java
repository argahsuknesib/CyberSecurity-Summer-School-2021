package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Executor;

@GwtCompatible
enum DirectExecutor implements Executor {
    INSTANCE;

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
