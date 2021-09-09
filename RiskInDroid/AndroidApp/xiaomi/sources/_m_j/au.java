package _m_j;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.C;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class au {

    /* renamed from: O000000o  reason: collision with root package name */
    final Object f12612O000000o = new Object();
    HandlerThread O00000Oo;
    final int O00000o;
    Handler O00000o0;
    private int O00000oO;
    private Handler.Callback O00000oo = new Handler.Callback() {
        /* class _m_j.au.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                au auVar = au.this;
                synchronized (auVar.f12612O000000o) {
                    if (!auVar.O00000o0.hasMessages(1)) {
                        auVar.O00000Oo.quit();
                        auVar.O00000Oo = null;
                        auVar.O00000o0 = null;
                    }
                }
                return true;
            } else if (i != 1) {
                return true;
            } else {
                au auVar2 = au.this;
                ((Runnable) message.obj).run();
                synchronized (auVar2.f12612O000000o) {
                    auVar2.O00000o0.removeMessages(0);
                    auVar2.O00000o0.sendMessageDelayed(auVar2.O00000o0.obtainMessage(0), (long) auVar2.O00000o);
                }
                return true;
            }
        }
    };
    private final int O0000O0o;
    private final String O0000OOo;

    public interface O000000o<T> {
        void O000000o(T t);
    }

    public au(String str) {
        this.O0000OOo = str;
        this.O0000O0o = 10;
        this.O00000o = C.MSG_CUSTOM_BASE;
        this.O00000oO = 0;
    }

    public final void O000000o(Runnable runnable) {
        synchronized (this.f12612O000000o) {
            if (this.O00000Oo == null) {
                this.O00000Oo = new HandlerThread(this.O0000OOo, this.O0000O0o);
                this.O00000Oo.start();
                this.O00000o0 = new Handler(this.O00000Oo.getLooper(), this.O00000oo);
                this.O00000oO++;
            }
            this.O00000o0.removeMessages(0);
            this.O00000o0.sendMessage(this.O00000o0.obtainMessage(1, runnable));
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:9|10|11|12|(4:25|14|15|16)(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
    public final <T> T O000000o(Callable<T> callable, int i) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicReference atomicReference2 = atomicReference;
        final Callable<T> callable2 = callable;
        final ReentrantLock reentrantLock2 = reentrantLock;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        final Condition condition = newCondition;
        O000000o(new Runnable() {
            /* class _m_j.au.AnonymousClass3 */

            public final void run() {
                try {
                    atomicReference2.set(callable2.call());
                } catch (Exception unused) {
                }
                reentrantLock2.lock();
                try {
                    atomicBoolean2.set(false);
                    condition.signal();
                } finally {
                    reentrantLock2.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) i);
            do {
                nanos = newCondition.awaitNanos(nanos);
                if (atomicBoolean.get()) {
                    T t = atomicReference.get();
                    reentrantLock.unlock();
                    return t;
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
