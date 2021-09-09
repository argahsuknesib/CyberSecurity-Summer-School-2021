package _m_j;

import _m_j.oh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class qt {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f2406O000000o;
    Looper O00000Oo;
    public ReentrantReadWriteLock O00000o;
    sq O00000o0;
    public boolean O00000oO = false;
    BroadcastReceiver O00000oo;
    public Handler O0000O0o = null;
    boolean O0000OOo = true;
    oh.O000000o O0000Oo;
    int O0000Oo0 = 20000;
    final Object O0000OoO = new Object();
    List<ScanResult> O0000Ooo = new ArrayList();
    private boolean O0000o0 = true;
    long O0000o00 = 0;
    private Comparator<ScanResult> O0000o0O = new Comparator<ScanResult>() {
        /* class _m_j.qt.AnonymousClass2 */

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ScanResult scanResult = (ScanResult) obj;
            int compareTo = scanResult.BSSID.compareTo(scanResult.BSSID);
            if (compareTo > 0) {
                return 1;
            }
            return compareTo == 0 ? 0 : -1;
        }
    };

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<ScanResult> f2409O000000o = new ArrayList();
        public long O00000Oo;
    }

    public final O000000o O000000o() {
        O000000o o000000o = new O000000o();
        synchronized (this.O0000OoO) {
            if (this.O0000Ooo == null) {
                return o000000o;
            }
            for (ScanResult add : this.O0000Ooo) {
                o000000o.f2409O000000o.add(add);
            }
            o000000o.O00000Oo = this.O0000o00;
            return o000000o;
        }
    }

    public qt(Context context, oh.O000000o o000000o, Looper looper) {
        this.f2406O000000o = context;
        this.O0000OOo = o000000o.O00000Oo;
        this.O0000Oo0 = o000000o.O00000oO;
        this.O0000o0 = o000000o.O00000o0;
        this.O0000Oo = o000000o;
        this.O00000Oo = looper;
        this.O00000o = new ReentrantReadWriteLock();
        this.O00000o0 = sq.O000000o(this.f2406O000000o);
    }

    static /* synthetic */ void O000000o(qt qtVar) {
        sq sqVar;
        if (qtVar.O0000OOo && (sqVar = qtVar.O00000o0) != null && sqVar.f2478O000000o.O00000o0()) {
            boolean z = false;
            try {
                if (Build.VERSION.SDK_INT < 18 && qtVar.O0000o0) {
                    sq sqVar2 = qtVar.O00000o0;
                    Object[] objArr = new Object[0];
                    Method declaredMethod = sqVar2.getClass().getDeclaredMethod("startScanActive", new Class[0]);
                    if (!declaredMethod.isAccessible()) {
                        declaredMethod.setAccessible(true);
                    }
                    Object invoke = declaredMethod.invoke(sqVar2, objArr);
                    if (invoke != null && "true".equals(String.valueOf(invoke))) {
                        z = true;
                    }
                }
            } catch (Exception unused) {
            }
            if (!z) {
                try {
                    qtVar.O00000o0.O000000o();
                } catch (Exception unused2) {
                }
            }
        }
    }

    static /* synthetic */ void O00000Oo(qt qtVar) {
        Context context;
        synchronized (qtVar.O0000OoO) {
            qtVar.O0000o00 = 0;
            if (qtVar.O0000Ooo != null) {
                qtVar.O0000Ooo.clear();
            }
        }
        BroadcastReceiver broadcastReceiver = qtVar.O00000oo;
        if (broadcastReceiver != null && broadcastReceiver != null && (context = qtVar.f2406O000000o) != null) {
            try {
                context.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    final class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006d */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i == 0) {
                    qt qtVar = qt.this;
                    qtVar.O00000oo = new BroadcastReceiver() {
                        /* class _m_j.qt.AnonymousClass1 */

                        public final void onReceive(Context context, Intent intent) {
                            boolean z;
                            if (intent != null) {
                                try {
                                    if (intent.getAction() != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                                        boolean z2 = true;
                                        try {
                                            qt qtVar = qt.this;
                                            oh.O000000o o000000o = qtVar.O0000Oo;
                                            if (qtVar.O0000Oo != null) {
                                                z = o000000o.O00000o;
                                            } else {
                                                z = true;
                                            }
                                            if (z && intent.getExtras() != null) {
                                                z2 = intent.getExtras().getBoolean("resultsUpdated", true);
                                            }
                                        } catch (Throwable unused) {
                                        }
                                        su.O000000o(100067);
                                        if (z2) {
                                            synchronized (qt.this.O0000OoO) {
                                                qt.this.O0000o00 = System.currentTimeMillis();
                                                qt.this.O0000Ooo = qt.this.O00000o0.f2478O000000o.O000000o();
                                                qf.O00000Oo(qt.this.O0000Ooo);
                                            }
                                        } else {
                                            su.O000000o(100068);
                                        }
                                        if (qt.this.O0000OOo) {
                                            qt.this.O00000o.readLock().lock();
                                            if (qt.this.O0000O0o != null) {
                                                qt.this.O0000O0o.removeMessages(2);
                                                qt.this.O0000O0o.sendEmptyMessageDelayed(2, (long) qt.this.O0000Oo0);
                                            }
                                            qt.this.O00000o.readLock().unlock();
                                        }
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                    };
                    BroadcastReceiver broadcastReceiver = qtVar.O00000oo;
                    if (broadcastReceiver != null) {
                        if (qtVar.f2406O000000o != null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
                            qtVar.f2406O000000o.registerReceiver(broadcastReceiver, intentFilter);
                        }
                    }
                    qt.O000000o(qt.this);
                } else if (i == 1) {
                    qt.O00000Oo(qt.this);
                    qt.this.O00000o.writeLock().lock();
                    if (qt.this.O0000O0o != null) {
                        qt.this.O0000O0o.removeCallbacksAndMessages(null);
                        qt.this.O0000O0o = null;
                    }
                    qt.this.O00000o.writeLock().unlock();
                } else if (i == 2) {
                    qt.O000000o(qt.this);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
