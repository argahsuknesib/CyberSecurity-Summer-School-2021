package com.xiaomi.youpin.common.thread;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class MainThreadExecutor implements Executor {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.handler.post(runnable);
    }
}
