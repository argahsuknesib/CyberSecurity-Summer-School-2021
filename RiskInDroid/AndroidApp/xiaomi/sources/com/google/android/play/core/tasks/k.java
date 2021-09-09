package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

final class k implements Executor {
    k() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
