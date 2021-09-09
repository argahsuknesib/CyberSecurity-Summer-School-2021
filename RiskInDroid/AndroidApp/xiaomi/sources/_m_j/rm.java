package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.location.security.Core;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class rm {

    /* renamed from: O000000o  reason: collision with root package name */
    sm f2430O000000o;
    Handler O00000Oo;
    ReentrantReadWriteLock O00000o = new ReentrantReadWriteLock();
    pm O00000o0;
    final List<to> O00000oO = new ArrayList();
    private Context O00000oo;
    private O000000o O0000O0o;
    private boolean O0000OOo;
    private Runnable O0000Oo0 = new Runnable() {
        /* class _m_j.rm.AnonymousClass3 */

        public final void run() {
            rm rmVar = rm.this;
            om.O00000Oo("@_2_1_@", "@_2_1_5_@");
            byte[] O00000Oo = rmVar.O00000Oo();
            if (O00000Oo != null) {
                String O000000o2 = rm.O000000o(ti.O000000o(sm.f2464O000000o ? "http://aps.testing.amap.com/conf/r?type=3&mid=300&sver=140" : "http://control.aps.amap.com/conf/r?type=3&mid=300&sver=140", O00000Oo, rmVar.f2430O000000o));
                if (O000000o2 != null) {
                    rmVar.O000000o(O000000o2);
                    return;
                }
                om.O00000Oo("@_2_1_@", "@_2_1_7_@");
                rmVar.O00000o0();
                return;
            }
            om.O00000Oo("@_2_1_@", "@_2_1_6_@");
            rmVar.O00000o0();
        }
    };

    protected rm() {
    }

    static String O000000o(byte[] bArr) {
        if (bArr != null) {
            try {
                byte[] xxt = Core.xxt(pc.O00000Oo(bArr), -1);
                if (xxt == null) {
                    return null;
                }
                String intern = new String(xxt, "utf-8").intern();
                om.O00000Oo("@_2_1_@", "@_2_1_10_@".concat(String.valueOf(intern)));
                if (ti.O000000o(intern)) {
                    return intern;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private void O000000o(pm pmVar) {
        synchronized (this.O00000oO) {
            for (int i = 0; i < this.O00000oO.size(); i++) {
                this.O00000oO.get(i).O000000o(pmVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        om.O00000Oo("@_2_1_@", "@_2_1_2_@");
        O000000o o000000o = this.O0000O0o;
        if (o000000o != null) {
            o000000o.f2434O000000o = true;
        }
        this.O00000o.writeLock().lock();
        final Handler handler = this.O00000Oo;
        this.O00000Oo = null;
        this.O00000o.writeLock().unlock();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler.post(new Runnable() {
                /* class _m_j.rm.AnonymousClass2 */

                public final void run() {
                    Looper looper = handler.getLooper();
                    if (looper != null) {
                        looper.quit();
                    }
                }
            });
        }
        synchronized (this.O00000oO) {
            this.O00000oO.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Context context, sm smVar) {
        om.O00000Oo("@_2_1_@", "@_2_1_1_@");
        this.O00000oo = context;
        this.f2430O000000o = smVar;
        this.O0000O0o = new O000000o("LocationCloudScheduler");
        O000000o o000000o = this.O0000O0o;
        o000000o.f2434O000000o = false;
        o000000o.start();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        String str2;
        SharedPreferences sharedPreferences = this.O00000oo.getSharedPreferences("LocationCloudConfig", 0);
        pm pmVar = new pm();
        if (pmVar.O000000o(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            sharedPreferences.edit().putString("command", str).putLong("lasttime", currentTimeMillis).commit();
            pmVar.O00000o = currentTimeMillis;
            this.O00000o0 = pmVar;
            O000000o(pmVar);
            this.O00000o.readLock().lock();
            Handler handler = this.O00000Oo;
            if (handler != null) {
                handler.postDelayed(this.O0000Oo0, this.O00000o0.f2388O000000o);
            }
            this.O00000o.readLock().unlock();
            str2 = "@_2_1_8_@";
        } else {
            O00000o0();
            str2 = "@_2_1_9_@";
        }
        om.O00000Oo("@_2_1_@", str2);
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        this.O00000o.readLock().lock();
        try {
            if (this.O00000Oo != null) {
                this.O00000Oo.postDelayed(this.O0000Oo0, 3600000);
            }
        } finally {
            this.O00000o.readLock().unlock();
        }
    }

    final class O000000o extends HandlerThread {

        /* renamed from: O000000o  reason: collision with root package name */
        protected volatile boolean f2434O000000o;

        public O000000o(String str) {
            super(str, 10);
        }

        /* access modifiers changed from: protected */
        public final void onLooperPrepared() {
            rm.this.O00000o.writeLock().lock();
            try {
                if (this.f2434O000000o) {
                    Looper looper = getLooper();
                    if (looper != null) {
                        looper.quit();
                    }
                    return;
                }
                rm.this.O00000Oo = new Handler(Looper.myLooper());
                rm.this.O00000o.writeLock().unlock();
                try {
                    rm.O000000o(rm.this);
                    rm.O00000Oo(rm.this);
                } catch (Throwable unused) {
                }
            } finally {
                rm.this.O00000o.writeLock().unlock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] O00000Oo() {
        try {
            bwk bwk = new bwk();
            int O000000o2 = bwk.O000000o(this.O00000oo.getPackageName());
            int O000000o3 = bwk.O000000o(this.f2430O000000o.O00000o0);
            int O000000o4 = bwk.O000000o(ol.O000000o());
            String str = this.f2430O000000o.O00000oo;
            if (TextUtils.isEmpty(str)) {
                str = ol.O00000Oo(this.O00000oo);
            }
            int O000000o5 = bwk.O000000o(str);
            int O000000o6 = bwk.O000000o(ol.O000000o(this.O00000oo));
            int O000000o7 = bwk.O000000o(ol.O00000o0(this.O00000oo));
            int O000000o8 = bwk.O000000o(ol.O00000o());
            int O000000o9 = bwk.O000000o(ol.O00000o0());
            int O000000o10 = bwk.O000000o(this.f2430O000000o.O00000oO);
            int O000000o11 = bwk.O000000o(this.f2430O000000o.O00000o);
            qx.O000000o(bwk);
            qx.O000000o(bwk, this.f2430O000000o.O00000Oo);
            qx.O000000o(bwk, O000000o2);
            qx.O00000Oo(bwk, O000000o3);
            qx.O00000Oo(bwk, (byte) ol.O00000oO());
            qx.O00000o0(bwk, O000000o4);
            qx.O00000o(bwk, O000000o5);
            qx.O00000oO(bwk, O000000o6);
            qx.O00000oo(bwk, O000000o7);
            qx.O000000o(bwk, ol.O00000o(this.O00000oo));
            qx.O0000O0o(bwk, O000000o8);
            qx.O0000OOo(bwk, O000000o9);
            qx.O0000Oo0(bwk, O000000o10);
            qx.O0000Oo(bwk, O000000o11);
            bwk.O00000o(qx.O00000Oo(bwk));
            return Core.xxt(bwk.O00000o0(), 1);
        } catch (Error | Exception unused) {
            return null;
        }
    }

    static /* synthetic */ void O000000o(rm rmVar) {
        SharedPreferences sharedPreferences = rmVar.O00000oo.getSharedPreferences("LocationCloudConfig", 0);
        String string = sharedPreferences.getString("command", "");
        long j = sharedPreferences.getLong("lasttime", 0);
        if (!TextUtils.isEmpty(string) && ti.O000000o(string)) {
            pm pmVar = new pm();
            if (pmVar.O000000o(string)) {
                pmVar.O00000o = j;
                rmVar.O00000o0 = pmVar;
                rmVar.O000000o(pmVar);
                om.O00000Oo("@_2_1_@", "@_2_1_3_@");
                return;
            }
        }
        om.O00000Oo("@_2_1_@", "@_2_1_4_@");
        rmVar.O0000OOo = true;
        synchronized (rmVar.O00000oO) {
            for (int i = 0; i < rmVar.O00000oO.size(); i++) {
                rmVar.O00000oO.get(i);
            }
        }
    }

    static /* synthetic */ void O00000Oo(rm rmVar) {
        rmVar.O00000o.readLock().lock();
        try {
            if (rmVar.O00000Oo != null) {
                boolean z = true;
                if (rmVar.O00000o0 != null) {
                    long currentTimeMillis = System.currentTimeMillis() - rmVar.O00000o0.O00000o;
                    if (currentTimeMillis < rmVar.O00000o0.f2388O000000o) {
                        if (currentTimeMillis >= 0) {
                            z = false;
                        }
                    }
                }
                if (z) {
                    rmVar.O00000Oo.post(rmVar.O0000Oo0);
                } else {
                    rmVar.O00000Oo.postDelayed(rmVar.O0000Oo0, rmVar.O00000o0.f2388O000000o);
                }
            }
        } finally {
            rmVar.O00000o.readLock().unlock();
        }
    }
}
