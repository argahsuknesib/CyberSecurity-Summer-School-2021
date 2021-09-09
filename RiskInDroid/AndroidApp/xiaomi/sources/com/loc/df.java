package com.loc;

import _m_j.buw;
import java.util.concurrent.ThreadFactory;

public final class df implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("httpdns worker");
        thread.setDaemon(false);
        thread.setUncaughtExceptionHandler(new buw());
        return thread;
    }
}
