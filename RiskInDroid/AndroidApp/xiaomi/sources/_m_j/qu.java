package _m_j;

import _m_j.qu.O000000o;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class qu<Item extends O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler.Callback f2411O000000o = new Handler.Callback() {
        /* class _m_j.qu.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            try {
                return qu.this.O000000o(message);
            } catch (Exception unused) {
                return true;
            }
        }
    };
    private int O00000Oo = 0;
    private O00000Oo<Item> O00000o;
    private ReentrantReadWriteLock O00000o0 = new ReentrantReadWriteLock();
    private Handler O00000oO;
    private ArrayList<Item> O00000oo = new ArrayList<>();
    private long O0000O0o;
    private boolean O0000OOo;

    public interface O000000o {
        long O000000o();
    }

    public interface O00000Oo<Item extends O000000o> {
        void O000000o();

        void O000000o(ArrayList<Item> arrayList);

        boolean O000000o(long j);

        long O00000Oo();

        long O00000o0();
    }

    /* JADX INFO: finally extract failed */
    private void O00000Oo(Item item) {
        this.O00000oo.add(item);
        this.O0000O0o += item.O000000o();
        if (this.O0000O0o >= this.O00000o.O00000Oo()) {
            try {
                this.O00000o0.readLock().lock();
                if (this.O00000oO != null) {
                    this.O00000oO.removeMessages(2);
                }
                this.O00000o0.readLock().unlock();
                O00000o();
            } catch (Throwable th) {
                this.O00000o0.readLock().unlock();
                throw th;
            }
        } else {
            O00000oO();
        }
    }

    private void O00000o() {
        this.O0000OOo = false;
        if (this.O00000o.O000000o(this.O0000O0o)) {
            this.O00000o.O000000o(this.O00000oo);
        }
        this.O00000oo.clear();
        this.O0000O0o = 0;
    }

    private void O00000o0() {
        O00000o();
        this.O00000o.O000000o();
        this.O00000o = null;
    }

    /* JADX INFO: finally extract failed */
    private void O00000oO() {
        if (!this.O0000OOo) {
            try {
                this.O00000o0.readLock().lock();
                if (this.O00000oO != null) {
                    this.O00000oO.sendEmptyMessageDelayed(2, this.O00000o.O00000o0());
                }
                this.O00000o0.readLock().unlock();
                this.O0000OOo = true;
            } catch (Throwable th) {
                this.O00000o0.readLock().unlock();
                throw th;
            }
        }
    }

    public final void O000000o() {
        this.O00000o0.writeLock().lock();
        try {
            if (this.O00000Oo == 1) {
                this.O00000Oo = 2;
                this.O00000oO.removeCallbacksAndMessages(null);
                if (this.O00000oO.getLooper() == Looper.myLooper()) {
                    O00000o0();
                } else {
                    this.O00000oO.sendEmptyMessage(3);
                }
                this.O00000oO = null;
            }
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    public final void O000000o(Item item) {
        try {
            this.O00000o0.readLock().lock();
            if (this.O00000oO != null) {
                if (this.O00000oO.getLooper() == Looper.myLooper()) {
                    O00000Oo(item);
                } else {
                    this.O00000oO.obtainMessage(1, item).sendToTarget();
                }
            }
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }

    public final void O000000o(O00000Oo<Item> o00000Oo, Looper looper) {
        if (o00000Oo == null || looper == null) {
            throw new RuntimeException("business 和 looper 都不能为 null");
        }
        try {
            this.O00000o0.writeLock().lock();
            if (this.O00000Oo == 0) {
                this.O00000o = o00000Oo;
                this.O00000oO = new Handler(looper, this.f2411O000000o);
                if (Looper.myLooper() != looper) {
                    this.O00000oO.sendEmptyMessage(4);
                }
                this.O00000Oo = 1;
            }
        } finally {
            this.O00000o0.writeLock().unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Message message) {
        int i = message.what;
        if (i == 1) {
            O00000Oo((O000000o) message.obj);
        } else if (i == 2) {
            O00000o();
        } else if (i == 3) {
            O00000o0();
        }
        return true;
    }

    public final void O00000Oo() {
        try {
            this.O00000o0.readLock().lock();
            if (this.O00000oO != null) {
                if (this.O00000oO.getLooper() == Looper.myLooper()) {
                    this.O00000oO.removeMessages(2);
                    O00000o();
                } else {
                    this.O00000oO.removeMessages(2);
                    this.O00000oO.obtainMessage(2).sendToTarget();
                }
            }
        } finally {
            this.O00000o0.readLock().unlock();
        }
    }
}
