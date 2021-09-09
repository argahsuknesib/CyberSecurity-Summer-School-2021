package _m_j;

import _m_j.rq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class rp {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f2436O000000o;
    pf O00000Oo;
    public ReentrantReadWriteLock O00000o = new ReentrantReadWriteLock();
    public O000000o O00000o0;
    rq O00000oO;
    long O00000oo;
    BroadcastReceiver O0000O0o = new BroadcastReceiver() {
        /* class _m_j.rp.AnonymousClass2 */

        public final void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && SystemClock.elapsedRealtime() - rp.this.O00000oo >= 10000) {
                rp.this.O00000o.readLock().lock();
                try {
                    if (rp.this.O00000o0 != null) {
                        rp.this.O00000o0.removeMessages(1);
                        rp.this.O00000o0.sendEmptyMessage(1);
                    }
                } finally {
                    rp.this.O00000o.readLock().unlock();
                }
            }
        }
    };
    private pg O0000OOo;

    public rp(Context context, pg pgVar, pf pfVar) {
        this.f2436O000000o = context;
        this.O0000OOo = pgVar;
        this.O00000Oo = pfVar;
        this.O00000oO = new rq(this.f2436O000000o, this.O0000OOo, this.O00000Oo, new rq.O000000o() {
            /* class _m_j.rp.AnonymousClass1 */

            public final void O000000o() {
                rp.this.O00000o.readLock().lock();
                try {
                    if (rp.this.O00000o0 != null) {
                        rp.this.O00000o0.removeMessages(2);
                        rp.this.O00000o0.sendMessage(rp.this.O00000o0.obtainMessage(2));
                    }
                } finally {
                    rp.this.O00000o.readLock().unlock();
                }
            }
        });
    }

    public final void O000000o() {
        O00000Oo o00000Oo = new O00000Oo("OfflineDownloader");
        o00000Oo.start();
        synchronized (o00000Oo) {
            om.O000000o("@_18_5_@", "offline-thread:before-start");
            while (this.O00000o0 == null) {
                try {
                    o00000Oo.wait();
                } catch (InterruptedException unused) {
                }
            }
            om.O000000o("@_18_5_@", "offline-thread:after-start");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo() {
        pf pfVar;
        pg pgVar = this.O0000OOo;
        return pgVar != null && pgVar.O0000OoO && (pfVar = this.O00000Oo) != null && pfVar.O000000o();
    }

    class O00000Oo extends HandlerThread {
        public O00000Oo(String str) {
            super(str, 10);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            rp rpVar = rp.this;
            rpVar.O00000o0 = new O000000o(Looper.myLooper());
            synchronized (this) {
                notify();
            }
            rp.this.O00000oo = SystemClock.elapsedRealtime();
            rp rpVar2 = rp.this;
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                rpVar2.f2436O000000o.registerReceiver(rpVar2.O0000O0o, intentFilter, null, rpVar2.O00000o0);
            } catch (Exception unused) {
            }
            rp.this.O00000o.readLock().lock();
            try {
                if (rp.this.O00000o0 != null) {
                    rp.this.O00000o0.removeMessages(0);
                    rp.this.O00000o0.sendEmptyMessageDelayed(0, 10000);
                    rp.this.O00000o0.removeMessages(1);
                    rp.this.O00000o0.sendEmptyMessageDelayed(1, 10000);
                    rp.this.O00000o0.removeMessages(3);
                    rp.this.O00000o0.sendEmptyMessageDelayed(3, 15000);
                }
            } finally {
                rp.this.O00000o.readLock().unlock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i) {
        boolean z = true;
        if (i == 1) {
            return sc.O00000Oo(this.f2436O000000o, this.O00000Oo.O0000O0o());
        }
        if (i != 0) {
            return false;
        }
        if (!sc.O00000Oo(this.f2436O000000o, this.O00000Oo.O0000O0o()) || !sc.O00000o0(this.f2436O000000o, this.O00000Oo.O0000OOo())) {
            z = false;
        }
        if (z) {
            su.O000000o(100052);
        }
        return z;
    }

    class O000000o extends Handler {
        O000000o(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:18|(3:22|23|24)|25|26|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(6:13|14|15|16|17|67) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007a */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0034=Splitter:B:16:0x0034, B:25:0x007a=Splitter:B:25:0x007a} */
        public final void handleMessage(Message message) {
            om.O00000Oo("@_18_5_@", "@_18_5_1_@" + message.what);
            try {
                int i = message.what;
                if (i != 0) {
                    if (i == 1) {
                        rp rpVar = rp.this;
                        if (!rpVar.O00000oO.O000000o() && rpVar.O00000Oo()) {
                            int O000000o2 = pe.O000000o(rpVar.f2436O000000o);
                            if (rpVar.O00000Oo.O0000Oo() && O000000o2 == 1 && !sc.O00000o0(rpVar.f2436O000000o)) {
                                rpVar.O00000oO.O000000o((byte) 0, O000000o2);
                            } else if (rpVar.O000000o(O000000o2)) {
                                rpVar.O00000oO.O000000o((byte) 1, O000000o2);
                            }
                        }
                    } else if (i == 2) {
                        rp rpVar2 = rp.this;
                        int O000000o3 = pe.O000000o(rpVar2.f2436O000000o);
                        if (!rpVar2.O00000oO.O000000o() && rpVar2.O00000Oo() && rpVar2.O000000o(O000000o3)) {
                            rpVar2.O00000oO.O000000o((byte) 1, O000000o3);
                        }
                    } else if (i == 3) {
                        if (rp.this.O00000Oo.O00000o0() && sc.O000000o(rp.this.f2436O000000o, rp.this.O00000Oo.O00000Oo())) {
                            rk O000000o4 = rk.O000000o(rp.this.f2436O000000o);
                            SQLiteDatabase writableDatabase = O000000o4.f2428O000000o.getWritableDatabase();
                            SQLiteDatabase writableDatabase2 = O000000o4.O00000Oo.getWritableDatabase();
                            writableDatabase.delete("CL", null, null);
                            writableDatabase.delete("AP", null, null);
                            writableDatabase2.delete("CL", null, null);
                            writableDatabase2.delete("AP", null, null);
                        }
                        rk.O000000o(rp.this.f2436O000000o).O000000o();
                        rk.O000000o(rp.this.f2436O000000o).O00000Oo();
                    } else if (i == 4) {
                        rp rpVar3 = rp.this;
                        rpVar3.f2436O000000o.unregisterReceiver(rpVar3.O0000O0o);
                        getLooper().quit();
                    }
                } else if (rp.this.O00000Oo()) {
                    ry.O000000o().O000000o(rp.this.f2436O000000o);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
