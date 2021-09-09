package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.openapi.bj$2;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class qv {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f2413O000000o;
    private int O00000Oo = 0;
    private int O00000o = 0;
    private ReentrantReadWriteLock O00000o0 = new ReentrantReadWriteLock();
    private Handler O00000oO;
    private O000000o O00000oo;
    private long O0000O0o;
    private O00000Oo O0000OOo;
    private Executor O0000Oo;
    private int O0000Oo0;
    private Handler.Callback O0000OoO = new Handler.Callback() {
        /* class _m_j.qv.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            try {
                return qv.this.O000000o(message);
            } catch (Exception unused) {
                qv.this.O00000Oo();
                return true;
            }
        }
    };

    public interface O000000o {
        long O000000o();

        Object O000000o(long j);

        void O000000o(int i);

        void O000000o(int i, Object obj);

        boolean O000000o(Object obj);

        int O00000Oo();

        void O00000Oo(Object obj);

        boolean O00000Oo(int i);

        int O00000o();

        long O00000o(int i);

        long O00000o0();

        long O00000o0(int i);

        void O00000oO();
    }

    private void O00000o() {
        if (this.O0000OOo == null) {
            int O000000o2 = pe.O000000o(this.f2413O000000o);
            if (O000000o2 == -1) {
                O00000Oo();
            } else if (!this.O00000oo.O00000Oo(O000000o2)) {
                O00000Oo();
            } else {
                long O00000o02 = this.O00000oo.O00000o0(O000000o2);
                if (O00000o02 <= 0) {
                    O00000Oo();
                    return;
                }
                long O000000o3 = this.O00000oo.O000000o();
                if (O000000o3 <= 0) {
                    O00000Oo();
                    return;
                }
                long min = Math.min(this.O00000oo.O00000o(O000000o2), O00000o02);
                if (O000000o3 >= min || SystemClock.elapsedRealtime() - this.O0000O0o >= this.O00000oo.O00000o0()) {
                    Object O000000o4 = this.O00000oo.O000000o(min);
                    if (O000000o4 == null) {
                        O00000Oo();
                        return;
                    }
                    this.O0000O0o = SystemClock.elapsedRealtime();
                    if (O000000o2 != pe.O000000o(this.f2413O000000o)) {
                        this.O00000oo.O00000oO();
                        O00000Oo();
                        return;
                    }
                    try {
                        this.O00000o0.readLock().lock();
                        if (this.O00000oO != null) {
                            this.O0000OOo = new O00000Oo(this, this.O00000oo, O000000o4, O000000o2);
                            O00000oO().execute(this.O0000OOo);
                            this.O00000oO.sendEmptyMessageDelayed(102, (long) this.O00000oo.O00000o());
                        }
                    } catch (Throwable unused) {
                    } finally {
                        this.O00000o0.readLock().unlock();
                    }
                } else {
                    O00000Oo();
                }
            }
        }
    }

    private Executor O00000oO() {
        Executor executor = this.O0000Oo;
        if (executor != null) {
            return executor;
        }
        this.O0000Oo = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1024), new bj$2(this));
        this.O00000o = 2;
        return this.O0000Oo;
    }

    public final void O000000o() {
        try {
            this.O00000o0.writeLock().lock();
            if (this.O00000Oo == 1) {
                this.O00000Oo = 2;
                this.O00000oO.removeCallbacksAndMessages(null);
                if (this.O00000oO.getLooper() == Looper.myLooper()) {
                    O00000o0();
                } else {
                    this.O00000oO.sendEmptyMessage(106);
                }
                this.O00000oO = null;
            }
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public final void O000000o(long j) {
        try {
            this.O00000o0.readLock().lock();
            if (this.O00000oO != null) {
                this.O00000oO.removeMessages(101);
                this.O00000oO.sendMessageDelayed(this.O00000oO.obtainMessage(101, 1, 0), Math.max(0L, j));
            }
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    public final void O000000o(Context context, O000000o o000000o, Looper looper) {
        if (context == null || o000000o == null || looper == null) {
            throw new RuntimeException("params not be null!");
        }
        try {
            this.O00000o0.writeLock().lock();
            if (this.O00000Oo == 0) {
                this.f2413O000000o = context;
                this.O00000oo = o000000o;
                this.O00000oO = new Handler(looper, this.O0000OoO);
                if (Looper.myLooper() != looper) {
                    this.O00000oO.sendEmptyMessage(105);
                }
                this.O00000Oo = 1;
            }
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        try {
            this.O00000o0.readLock().lock();
            if (this.O00000oO != null && ((this.O00000oo.O00000Oo() <= 0 || this.O0000Oo0 < this.O00000oo.O00000Oo()) && !this.O00000oO.hasMessages(101))) {
                this.O00000oO.sendMessageDelayed(this.O00000oO.obtainMessage(101, 0, 0), this.O00000oo.O00000o0());
            }
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    static class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<O000000o> f2415O000000o;
        WeakReference<qv> O00000Oo;
        Object O00000o;
        volatile boolean O00000o0;
        final int O00000oO;

        O00000Oo(qv qvVar, O000000o o000000o, Object obj, int i) {
            this.O00000Oo = new WeakReference<>(qvVar);
            this.f2415O000000o = new WeakReference<>(o000000o);
            this.O00000o = obj;
            this.O00000oO = i;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.qv.O000000o(_m_j.qv, _m_j.qv$O00000Oo, boolean):void
         arg types: [_m_j.qv, _m_j.qv$O00000Oo, int]
         candidates:
          _m_j.qv.O000000o(android.content.Context, _m_j.qv$O000000o, android.os.Looper):void
          _m_j.qv.O000000o(_m_j.qv, _m_j.qv$O00000Oo, boolean):void */
        public final void run() {
            if (!this.O00000o0) {
                qv qvVar = this.O00000Oo.get();
                O000000o o000000o = this.f2415O000000o.get();
                if (qvVar != null && o000000o != null) {
                    boolean z = false;
                    if (pe.O000000o(qvVar.f2413O000000o) < this.O00000oO) {
                        qv.O000000o(qvVar, this, false);
                        return;
                    }
                    try {
                        z = o000000o.O000000o(this.O00000o);
                    } catch (Throwable unused) {
                    }
                    if (!this.O00000o0) {
                        qv.O000000o(qvVar, this, z);
                    }
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final boolean O000000o(Message message) {
        switch (message.what) {
            case 101:
                if (message.arg1 == 1) {
                    this.O0000Oo0 = 0;
                }
                O00000o();
                break;
            case 102:
                this.O00000oo.O000000o(this.O0000OOo.O00000oO, this.O0000OOo.O00000o);
                this.O0000OOo.O00000o0 = true;
                this.O0000OOo = null;
                this.O0000Oo0++;
                this.O00000oo.O000000o(-1);
                O00000Oo();
                break;
            case 103:
                O00000Oo o00000Oo = (O00000Oo) message.obj;
                if (message.obj == this.O0000OOo) {
                    this.O0000OOo = null;
                    try {
                        this.O00000o0.readLock().lock();
                        if (this.O00000oO != null) {
                            this.O00000oO.removeMessages(102);
                        }
                        this.O00000o0.readLock().unlock();
                        this.O00000oo.O000000o(o00000Oo.O00000oO, o00000Oo.O00000o);
                        this.O00000oo.O00000Oo(o00000Oo.O00000o);
                        this.O00000oo.O000000o(1);
                        O00000o();
                        break;
                    } catch (Throwable th) {
                        this.O00000o0.readLock().unlock();
                        throw th;
                    }
                }
                break;
            case 104:
                Object obj = message.obj;
                O00000Oo o00000Oo2 = this.O0000OOo;
                if (obj == o00000Oo2) {
                    this.O00000oo.O000000o(o00000Oo2.O00000oO, this.O0000OOo.O00000o);
                    this.O0000OOo = null;
                    try {
                        this.O00000o0.readLock().lock();
                        if (this.O00000oO != null) {
                            this.O00000oO.removeMessages(102);
                        }
                        this.O00000o0.readLock().unlock();
                        this.O0000Oo0++;
                        this.O00000oo.O000000o(0);
                        O00000Oo();
                        break;
                    } catch (Throwable th2) {
                        this.O00000o0.readLock().unlock();
                        throw th2;
                    }
                }
                break;
            case 106:
                O00000o0();
                break;
        }
        return true;
    }

    private void O00000o0() {
        O00000Oo o00000Oo = this.O0000OOo;
        if (o00000Oo != null) {
            o00000Oo.O00000o0 = true;
        }
        if (this.O00000o == 2) {
            ((ExecutorService) this.O0000Oo).shutdown();
        }
        this.O0000Oo = null;
        this.O00000oo = null;
        this.O0000OOo = null;
    }

    static /* synthetic */ void O000000o(qv qvVar, O00000Oo o00000Oo, boolean z) {
        try {
            qvVar.O00000o0.readLock().lock();
            if (qvVar.O00000oO != null) {
                qvVar.O00000oO.obtainMessage(z ? 103 : 104, o00000Oo).sendToTarget();
            }
        } finally {
            qvVar.O00000o0.readLock().unlock();
        }
    }
}
