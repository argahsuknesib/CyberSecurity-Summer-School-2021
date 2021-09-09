package _m_j;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;

final class ds {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ThreadLocal<ds> f14886O000000o = new ThreadLocal<>();
    final o0OO00OO<O00000Oo, Long> O00000Oo = new o0OO00OO<>();
    long O00000o = 0;
    final ArrayList<O00000Oo> O00000o0 = new ArrayList<>();
    boolean O00000oO = false;
    private final O000000o O00000oo = new O000000o();
    private O00000o0 O0000O0o;

    interface O00000Oo {
        boolean O000000o(long j);
    }

    ds() {
    }

    class O000000o {
        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            ds.this.O00000o = SystemClock.uptimeMillis();
            ds dsVar = ds.this;
            long j = dsVar.O00000o;
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= dsVar.O00000o0.size()) {
                    break;
                }
                O00000Oo o00000Oo = dsVar.O00000o0.get(i);
                if (o00000Oo != null) {
                    Long l = dsVar.O00000Oo.get(o00000Oo);
                    if (l != null) {
                        if (l.longValue() < uptimeMillis) {
                            dsVar.O00000Oo.remove(o00000Oo);
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        o00000Oo.O000000o(j);
                    }
                }
                i++;
            }
            if (dsVar.O00000oO) {
                for (int size = dsVar.O00000o0.size() - 1; size >= 0; size--) {
                    if (dsVar.O00000o0.get(size) == null) {
                        dsVar.O00000o0.remove(size);
                    }
                }
                dsVar.O00000oO = false;
            }
            if (ds.this.O00000o0.size() > 0) {
                ds.this.O00000Oo().O000000o();
            }
        }
    }

    public static ds O000000o() {
        if (f14886O000000o.get() == null) {
            f14886O000000o.set(new ds());
        }
        return f14886O000000o.get();
    }

    /* access modifiers changed from: package-private */
    public final O00000o0 O00000Oo() {
        if (this.O0000O0o == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.O0000O0o = new O0000O0o(this.O00000oo);
            } else {
                this.O0000O0o = new O00000o(this.O00000oo);
            }
        }
        return this.O0000O0o;
    }

    public final void O000000o(O00000Oo o00000Oo) {
        this.O00000Oo.remove(o00000Oo);
        int indexOf = this.O00000o0.indexOf(o00000Oo);
        if (indexOf >= 0) {
            this.O00000o0.set(indexOf, null);
            this.O00000oO = true;
        }
    }

    static class O0000O0o extends O00000o0 {
        private final Choreographer O00000Oo = Choreographer.getInstance();
        private final Choreographer.FrameCallback O00000o0 = new Choreographer.FrameCallback() {
            /* class _m_j.ds.O0000O0o.AnonymousClass1 */

            public final void doFrame(long j) {
                O0000O0o.this.f14889O000000o.O000000o();
            }
        };

        O0000O0o(O000000o o000000o) {
            super(o000000o);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O00000Oo.postFrameCallback(this.O00000o0);
        }
    }

    static class O00000o extends O00000o0 {
        long O00000Oo = -1;
        private final Handler O00000o = new Handler(Looper.myLooper());
        private final Runnable O00000o0 = new Runnable() {
            /* class _m_j.ds.O00000o.AnonymousClass1 */

            public final void run() {
                O00000o.this.O00000Oo = SystemClock.uptimeMillis();
                O00000o.this.f14889O000000o.O000000o();
            }
        };

        O00000o(O000000o o000000o) {
            super(o000000o);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.lang.Math.max(long, long):long}
         arg types: [long, int]
         candidates:
          ClspMth{java.lang.Math.max(double, double):double}
          ClspMth{java.lang.Math.max(int, int):int}
          ClspMth{java.lang.Math.max(float, float):float}
          ClspMth{java.lang.Math.max(long, long):long} */
        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O00000o.postDelayed(this.O00000o0, Math.max(10 - (SystemClock.uptimeMillis() - this.O00000Oo), 0L));
        }
    }

    static abstract class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final O000000o f14889O000000o;

        /* access modifiers changed from: package-private */
        public abstract void O000000o();

        O00000o0(O000000o o000000o) {
            this.f14889O000000o = o000000o;
        }
    }
}
