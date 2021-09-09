package com.mi.multimonitor;

public interface ICrashDataSender {
    void postCrashData(Thread thread, Throwable th);
}
