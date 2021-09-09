package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

final class c implements ThreadFactory {
    c() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
