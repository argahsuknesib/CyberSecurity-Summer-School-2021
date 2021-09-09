package _m_j;

import java.io.IOException;
import java.io.InterruptedIOException;

public class iqj extends ira {

    /* renamed from: O000000o  reason: collision with root package name */
    private static iqj f1556O000000o;
    private iqj O00000o;
    private boolean O00000o0;
    private long O00000oO;

    static final class O000000o extends Thread {
        public O000000o() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(2:3|6)(2:4|7)|5) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:5:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        public final void run() {
            while (true) {
                iqj L_ = iqj.L_();
                if (L_ != null) {
                    L_.O00000o0();
                }
            }
        }
    }

    private static synchronized boolean O000000o(iqj iqj) {
        boolean z;
        synchronized (iqj.class) {
            iqj iqj2 = f1556O000000o;
            while (true) {
                if (iqj2 == null) {
                    z = true;
                    break;
                } else if (iqj2.O00000o == iqj) {
                    iqj2.O00000o = iqj.O00000o;
                    iqj.O00000o = null;
                    z = false;
                    break;
                } else {
                    iqj2 = iqj2.O00000o;
                }
            }
        }
        return z;
    }

    public final void K_() {
        if (!this.O00000o0) {
            long O000000o2 = O000000o();
            boolean M_ = M_();
            if (O000000o2 != 0 || M_) {
                this.O00000o0 = true;
                O000000o(this, O000000o2, M_);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    /* access modifiers changed from: package-private */
    public final IOException O000000o(IOException iOException) throws IOException {
        return !O00000Oo() ? iOException : O00000Oo(iOException);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) throws IOException {
        if (O00000Oo() && z) {
            throw O00000Oo(null);
        }
    }

    /* access modifiers changed from: protected */
    public IOException O00000Oo(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final boolean O00000Oo() {
        if (!this.O00000o0) {
            return false;
        }
        this.O00000o0 = false;
        return O000000o(this);
    }

    /* access modifiers changed from: protected */
    public void O00000o0() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0052 A[EDGE_INSN: B:36:0x0052->B:23:0x0052 ?: BREAK  , SYNTHETIC] */
    private static synchronized void O000000o(iqj iqj, long j, boolean z) {
        iqj iqj2;
        synchronized (iqj.class) {
            if (f1556O000000o == null) {
                f1556O000000o = new iqj();
                new O000000o().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                j = Math.min(j, iqj.N_() - nanoTime);
            } else if (j == 0) {
                if (z) {
                    iqj.O00000oO = iqj.N_();
                    long j2 = iqj.O00000oO - nanoTime;
                    iqj2 = f1556O000000o;
                    while (true) {
                        if (iqj2.O00000o == null) {
                            break;
                        } else if (j2 < iqj2.O00000o.O00000oO - nanoTime) {
                            break;
                        } else {
                            iqj2 = iqj2.O00000o;
                        }
                    }
                    iqj.O00000o = iqj2.O00000o;
                    iqj2.O00000o = iqj;
                    if (iqj2 != f1556O000000o) {
                        iqj.class.notify();
                        return;
                    }
                    return;
                }
                throw new AssertionError();
            }
            iqj.O00000oO = j + nanoTime;
            long j22 = iqj.O00000oO - nanoTime;
            iqj2 = f1556O000000o;
            while (true) {
                if (iqj2.O00000o == null) {
                }
                iqj2 = iqj2.O00000o;
            }
            iqj.O00000o = iqj2.O00000o;
            iqj2.O00000o = iqj;
            if (iqj2 != f1556O000000o) {
            }
        }
    }

    static synchronized iqj L_() throws InterruptedException {
        synchronized (iqj.class) {
            iqj iqj = f1556O000000o.O00000o;
            if (iqj == null) {
                iqj.class.wait();
                return null;
            }
            long nanoTime = iqj.O00000oO - System.nanoTime();
            if (nanoTime > 0) {
                long j = nanoTime / 1000000;
                Long.signum(j);
                iqj.class.wait(j, (int) (nanoTime - (1000000 * j)));
                return null;
            }
            f1556O000000o.O00000o = iqj.O00000o;
            iqj.O00000o = null;
            return iqj;
        }
    }
}
