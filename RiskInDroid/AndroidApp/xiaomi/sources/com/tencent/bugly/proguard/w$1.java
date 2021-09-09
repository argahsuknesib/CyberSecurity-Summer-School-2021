package com.tencent.bugly.proguard;

import _m_j.dic;
import java.util.concurrent.ThreadFactory;

public class w$1 implements ThreadFactory {
    public w$1(dic dic) {
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("BUGLY_THREAD");
        return thread;
    }
}
