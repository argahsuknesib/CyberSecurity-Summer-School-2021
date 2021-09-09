package _m_j;

import android.os.Looper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public final class isk implements irw {
    @SuppressFBWarnings({"MS_SHOULD_BE_FINAL"})

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1604O000000o = false;
    private final Looper O00000Oo = Looper.myLooper();
    private final boolean O00000o0;

    public isk() {
        String name = Thread.currentThread().getName();
        this.O00000o0 = name != null && name.startsWith("IntentService[");
    }

    public final boolean O000000o() {
        return O00000o0() && !this.O00000o0;
    }

    public final void O00000Oo() {
        if (!O00000o0()) {
            throw new IllegalStateException("");
        } else if (this.O00000o0) {
            throw new IllegalStateException("");
        }
    }

    private boolean O00000o0() {
        return this.O00000Oo != null;
    }
}
