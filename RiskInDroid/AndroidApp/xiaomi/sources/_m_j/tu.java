package _m_j;

import _m_j.or;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class tu {
    private static final String O0000OOo = "tu";

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f2508O000000o;
    public SignalStrength O00000Oo;
    public CellLocation O00000o;
    public boolean O00000o0;
    public CellInfo O00000oO;
    public Location O00000oo;
    public tz O0000O0o = new tz();
    /* access modifiers changed from: private */
    public final ReentrantReadWriteLock O0000Oo;
    /* access modifiers changed from: private */
    public Handler O0000Oo0;
    private TelephonyManager O0000OoO;
    /* access modifiers changed from: private */
    public CellLocation O0000Ooo;
    private PhoneStateListener O0000o = new PhoneStateListener() {
        /* class _m_j.tu.AnonymousClass2 */

        public final void onCellInfoChanged(List<CellInfo> list) {
            tu.this.O0000Oo.readLock().lock();
            try {
                if (tu.this.O0000Oo0 != null) {
                    tu.this.O0000Oo0.post(new Runnable() {
                        /* class _m_j.tu.AnonymousClass2.AnonymousClass3 */

                        public final void run() {
                            tu.O00000oO(tu.this);
                        }
                    });
                }
            } finally {
                tu.this.O0000Oo.readLock().unlock();
            }
        }

        public final void onCellLocationChanged(final CellLocation cellLocation) {
            tu.this.O0000Oo.readLock().lock();
            try {
                if (tu.this.O0000Oo0 != null) {
                    tu.this.O0000Oo0.post(new Runnable() {
                        /* class _m_j.tu.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            CellLocation unused = tu.this.O0000Ooo = cellLocation;
                            long unused2 = tu.this.O0000o00 = SystemClock.elapsedRealtime();
                            tu.O00000oO(tu.this);
                        }
                    });
                }
            } finally {
                tu.this.O0000Oo.readLock().unlock();
            }
        }

        public final void onSignalStrengthsChanged(final SignalStrength signalStrength) {
            tu.this.O0000Oo.readLock().lock();
            try {
                if (tu.this.O0000Oo0 != null) {
                    tu.this.O0000Oo0.post(new Runnable() {
                        /* class _m_j.tu.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            SignalStrength unused = tu.this.O00000Oo = signalStrength;
                            tu.O00000oO(tu.this);
                        }
                    });
                }
            } finally {
                tu.this.O0000Oo.readLock().unlock();
            }
        }
    };
    private tz O0000o0 = new tz();
    /* access modifiers changed from: private */
    public long O0000o00;
    private final List<or.O000000o> O0000o0O = new ArrayList(3);
    private BroadcastReceiver O0000o0o = new BroadcastReceiver() {
        /* class _m_j.tu.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action;
            if (intent != null && (action = intent.getAction()) != null) {
                char c = 65535;
                if (action.hashCode() == -1076576821 && action.equals("android.intent.action.AIRPLANE_MODE")) {
                    c = 0;
                }
                if (c == 0) {
                    tu tuVar = tu.this;
                    boolean unused = tuVar.O00000o0 = !qj.O000000o(tuVar.f2508O000000o);
                    if (!tu.this.O00000o0) {
                        CellLocation unused2 = tu.this.O0000Ooo = (CellLocation) null;
                        long unused3 = tu.this.O0000o00 = 0;
                    }
                }
            }
        }
    };

    public tu(Context context, Looper looper) {
        this.f2508O000000o = context;
        this.O0000OoO = (TelephonyManager) this.f2508O000000o.getSystemService("phone");
        this.O0000Oo0 = new Handler(looper);
        this.O0000Oo = new ReentrantReadWriteLock();
    }

    public final void O000000o() {
        this.O00000o0 = !qj.O000000o(this.f2508O000000o);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        try {
            this.f2508O000000o.registerReceiver(this.O0000o0o, intentFilter, null, this.O0000Oo0);
            if (this.O0000OoO != null) {
                int i = 272;
                if (Build.VERSION.SDK_INT >= 17) {
                    i = 1296;
                }
                this.O0000OoO.listen(this.O0000o, i);
            }
        } catch (Exception unused) {
        }
    }

    public final void O00000Oo() {
        try {
            this.f2508O000000o.unregisterReceiver(this.O0000o0o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TelephonyManager telephonyManager = this.O0000OoO;
        if (telephonyManager != null) {
            telephonyManager.listen(this.O0000o, 0);
        }
        this.O0000Oo.writeLock().lock();
        try {
            this.O0000Oo0.removeCallbacksAndMessages(null);
            this.O0000Oo0 = null;
        } finally {
            this.O0000Oo.writeLock().unlock();
        }
    }

    public final List<CellInfo> O00000o() {
        try {
            if (this.O0000OoO == null || Build.VERSION.SDK_INT < 17) {
                return null;
            }
            return this.O0000OoO.getAllCellInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    public final CellLocation O00000o0() {
        boolean z;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.O0000Ooo != null) {
            long j = this.O0000o00;
            if (j != 0 && elapsedRealtime - j <= 1500) {
                z = true;
                if (!z) {
                    try {
                        this.O0000Ooo = this.O0000OoO != null ? this.O0000OoO.getCellLocation() : null;
                        this.O0000o00 = elapsedRealtime;
                    } catch (Exception unused) {
                        this.O0000Ooo = null;
                        this.O0000o00 = 0;
                    }
                }
                return this.O0000Ooo;
            }
        }
        z = false;
        if (!z) {
        }
        return this.O0000Ooo;
    }

    public final void O000000o(tz tzVar) {
        List<or.O000000o> list;
        synchronized (this.O0000o0O) {
            Iterator<ua> it = tzVar.O00000o0.iterator();
            while (it.hasNext()) {
                ua next = it.next();
                boolean z = true;
                if (1 == next.O00000Oo) {
                    or.O000000o o000000o = new or.O000000o();
                    o000000o.O0000OOo = SystemClock.elapsedRealtime();
                    o000000o.f2372O000000o = next.f2523O000000o;
                    byte b = next.f2523O000000o;
                    if (b != 1) {
                        if (b != 2) {
                            if (b != 3) {
                                if (b == 4) {
                                    if (next.O00000oo != null) {
                                        uh uhVar = (uh) next.O00000oo;
                                        if (pe.O000000o(uhVar.O00000o0) && pe.O00000Oo(uhVar.O00000o)) {
                                            o000000o.O00000o0 = uhVar.O00000o0;
                                            o000000o.O00000o = uhVar.O00000o;
                                            o000000o.O00000Oo = uhVar.O00000oo;
                                            list = this.O0000o0O;
                                        }
                                    }
                                }
                            } else if (next.O00000oo != null) {
                                uf ufVar = (uf) next.O00000oo;
                                if (pe.O000000o(ufVar.O00000o0) && pe.O00000Oo(ufVar.O00000o)) {
                                    o000000o.O00000o0 = ufVar.O00000o0;
                                    o000000o.O00000o = ufVar.O00000o;
                                    o000000o.O00000Oo = ufVar.O00000oo;
                                    list = this.O0000o0O;
                                }
                            }
                        } else if (next.O00000oo != null) {
                            ty tyVar = (ty) next.O00000oo;
                            int i = tyVar.f2520O000000o;
                            if (i > 0 && i <= 32767) {
                                int i2 = tyVar.O00000Oo;
                                if (i2 >= 0 && i2 <= 65535) {
                                    int i3 = tyVar.O00000o0;
                                    if (i3 < 0 || i3 > 65535) {
                                        z = false;
                                    }
                                    if (z) {
                                        o000000o.O00000oO = tyVar.f2520O000000o;
                                        o000000o.O00000oo = tyVar.O00000Oo;
                                        o000000o.O0000O0o = tyVar.O00000o0;
                                        o000000o.O00000Oo = tyVar.O00000oo;
                                        list = this.O0000o0O;
                                    }
                                }
                            }
                        }
                        pe.O000000o(o000000o, list);
                    } else if (next.O00000oo != null) {
                        ue ueVar = (ue) next.O00000oo;
                        if (pe.O000000o(ueVar.O00000o0) && pe.O00000Oo(ueVar.O00000o)) {
                            o000000o.O00000o0 = ueVar.O00000o0;
                            o000000o.O00000o = ueVar.O00000o;
                            o000000o.O00000Oo = ueVar.O00000oO;
                            pe.O000000o(o000000o, this.O0000o0O);
                        }
                    }
                }
            }
            this.O0000O0o.O00000o.clear();
            this.O0000O0o.O00000o.addAll(this.O0000o0O);
        }
    }

    static /* synthetic */ void O00000oO(tu tuVar) {
        if (tuVar.O00000o0) {
            try {
                CellLocation O00000o02 = tuVar.O00000o0();
                CellInfo cellInfo = null;
                if ((O00000o02 instanceof CdmaCellLocation) && -1 == ((CdmaCellLocation) O00000o02).getNetworkId()) {
                    O00000o02 = null;
                }
                List<CellInfo> O00000o2 = tuVar.O00000o();
                if (O00000o2 != null) {
                    cellInfo = qj.O000000o(O00000o2);
                }
                if (O00000o02 != null || cellInfo != null) {
                    qj.O000000o(tuVar.f2508O000000o, tuVar.O0000o0, O00000o02, tuVar.O00000Oo, O00000o2);
                    qf.O000000o(tuVar.O0000o0.O00000o0);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
