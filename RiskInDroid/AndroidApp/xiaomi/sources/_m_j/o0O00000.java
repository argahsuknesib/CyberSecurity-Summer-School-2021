package _m_j;

import androidx.arch.core.executor.ArchTaskExecutor$1;
import androidx.arch.core.executor.ArchTaskExecutor$2;
import java.util.concurrent.Executor;

public class o0O00000 extends o0O000Oo {
    private static volatile o0O00000 O00000Oo;
    private static final Executor O00000o = new ArchTaskExecutor$1();
    private static final Executor O00000oO = new ArchTaskExecutor$2();

    /* renamed from: O000000o  reason: collision with root package name */
    public o0O000Oo f2228O000000o = this.O00000o0;
    private o0O000Oo O00000o0 = new o0O0000O();

    private o0O00000() {
    }

    public static o0O00000 O000000o() {
        if (O00000Oo != null) {
            return O00000Oo;
        }
        synchronized (o0O00000.class) {
            if (O00000Oo == null) {
                O00000Oo = new o0O00000();
            }
        }
        return O00000Oo;
    }

    public final void O000000o(Runnable runnable) {
        this.f2228O000000o.O000000o(runnable);
    }

    public final void O00000Oo(Runnable runnable) {
        this.f2228O000000o.O00000Oo(runnable);
    }

    public final boolean O00000Oo() {
        return this.f2228O000000o.O00000Oo();
    }
}
