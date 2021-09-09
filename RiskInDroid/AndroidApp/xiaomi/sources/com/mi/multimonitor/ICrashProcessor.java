package com.mi.multimonitor;

public interface ICrashProcessor {
    CrashReportBean processorException(Thread thread, Throwable th);
}
