package _m_j;

import java.lang.Thread;

public abstract class ere implements Thread.UncaughtExceptionHandler {
    public abstract void O000000o(Thread thread, Throwable th);

    public final void uncaughtException(Thread thread, Throwable th) {
        O000000o(thread, th);
    }
}
