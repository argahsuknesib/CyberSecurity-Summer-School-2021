package _m_j;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class elr {

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f15612O000000o;
    volatile boolean O00000Oo;
    volatile O00000Oo O00000o;
    int O00000o0;
    private O000000o O00000oO;
    private final boolean O00000oo;

    public static abstract class O00000Oo {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public elr() {
        this(false);
    }

    public elr(boolean z) {
        this(z, 0);
    }

    public elr(boolean z, int i) {
        this.f15612O000000o = null;
        this.O00000Oo = false;
        this.O00000o0 = 0;
        this.f15612O000000o = new els(this, Looper.getMainLooper());
        this.O00000oo = z;
        this.O00000o0 = i;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void O000000o() {
        this.O00000oO = null;
        this.O00000Oo = true;
    }

    public final void O000000o(O00000Oo o00000Oo, long j) {
        this.f15612O000000o.postDelayed(new elt(this, o00000Oo), j);
    }

    class O000000o extends Thread {

        /* renamed from: O000000o  reason: collision with root package name */
        final LinkedBlockingQueue<O00000Oo> f15613O000000o = new LinkedBlockingQueue<>();

        public O000000o() {
            super("PackageProcessor");
        }

        private void O000000o(int i, O00000Oo o00000Oo) {
            try {
                elr.this.f15612O000000o.sendMessage(elr.this.f15612O000000o.obtainMessage(i, o00000Oo));
            } catch (Exception e) {
                duv.O000000o(e);
            }
        }

        public final void run() {
            long j = elr.this.O00000o0 > 0 ? (long) elr.this.O00000o0 : Long.MAX_VALUE;
            while (!elr.this.O00000Oo) {
                try {
                    O00000Oo poll = this.f15613O000000o.poll(j, TimeUnit.SECONDS);
                    elr.this.O00000o = poll;
                    if (poll != null) {
                        O000000o(0, poll);
                        poll.b();
                        O000000o(1, poll);
                    } else if (elr.this.O00000o0 > 0) {
                        elr.this.O000000o();
                    }
                } catch (InterruptedException e) {
                    duv.O000000o(e);
                }
            }
        }
    }

    public final synchronized void O000000o(O00000Oo o00000Oo) {
        if (this.O00000oO == null) {
            this.O00000oO = new O000000o();
            this.O00000oO.setDaemon(this.O00000oo);
            this.O00000Oo = false;
            this.O00000oO.start();
        }
        try {
            this.O00000oO.f15613O000000o.add(o00000Oo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
