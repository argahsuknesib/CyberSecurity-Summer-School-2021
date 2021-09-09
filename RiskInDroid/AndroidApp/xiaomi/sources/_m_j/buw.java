package _m_j;

import java.lang.Thread;

public final class buw implements Thread.UncaughtExceptionHandler {
    public final void uncaughtException(Thread thread, Throwable th) {
        gsy.O000000o(6, "HttpDnsSDK", "Catch an uncaught exception, " + thread.getName() + ", error message: " + th.getMessage());
        th.printStackTrace();
    }
}
