package _m_j;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class jpb {

    /* renamed from: O000000o  reason: collision with root package name */
    static final Executor f2011O000000o = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), jqp.O000000o("OkHttp ConnectionPool"));
    static final /* synthetic */ boolean O0000O0o = (!jpb.class.desiredAssertionStatus());
    final int O00000Oo;
    final Deque<jqr> O00000o;
    final Runnable O00000o0;
    final jqo O00000oO;
    boolean O00000oo;
    private final long O0000OOo;

    public jpb() {
        this(TimeUnit.MINUTES);
    }

    private jpb(TimeUnit timeUnit) {
        this.O00000o0 = new Runnable() {
            /* class _m_j.jpb.AnonymousClass1 */

            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002b */
            public final void run() {
                while (true) {
                    long O000000o2 = jpb.this.O000000o(System.nanoTime());
                    if (O000000o2 != -1) {
                        if (O000000o2 > 0) {
                            long j = O000000o2 / 1000000;
                            long j2 = O000000o2 - (1000000 * j);
                            synchronized (jpb.this) {
                                jpb.this.wait(j, (int) j2);
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        };
        this.O00000o = new ArrayDeque();
        this.O00000oO = new jqo();
        this.O00000Oo = 5;
        this.O0000OOo = timeUnit.toNanos(5);
    }

    /* access modifiers changed from: package-private */
    public final long O000000o(long j) {
        int size;
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            jqr jqr = null;
            int i = 0;
            int i2 = 0;
            for (jqr next : this.O00000o) {
                List<Reference<jqh>> list = next.O0000Oo0;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        size = list.size();
                        break;
                    } else if (list.get(i3).get() != null) {
                        i3++;
                    } else {
                        jpn.f2027O000000o.warning("A connection to " + next.f2064O000000o.f2002O000000o.f2001O000000o + " was leaked. Did you forget to close a response body?");
                        list.remove(i3);
                        next.O0000Oo = true;
                        if (list.isEmpty()) {
                            next.O0000OoO = j - this.O0000OOo;
                            size = 0;
                            break;
                        }
                    }
                }
                if (size > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - next.O0000OoO;
                    if (j3 > j2) {
                        jqr = next;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.O0000OOo) {
                if (i <= this.O00000Oo) {
                    if (i > 0) {
                        long j4 = this.O0000OOo - j2;
                        return j4;
                    } else if (i2 > 0) {
                        long j5 = this.O0000OOo;
                        return j5;
                    } else {
                        this.O00000oo = false;
                        return -1;
                    }
                }
            }
            this.O00000o.remove(jqr);
            jqp.O000000o(jqr.O00000Oo);
            return 0;
        }
    }
}
