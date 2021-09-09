package _m_j;

import java.lang.Thread;

abstract class joc implements Runnable {
    final jnw O00000o0;

    /* access modifiers changed from: package-private */
    public abstract void O000000o();

    joc(jnw jnw) {
        this.O00000o0 = jnw;
    }

    public final void run() {
        try {
            if (!this.O00000o0.O00000oo.O0000OoO()) {
                O000000o();
            }
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
