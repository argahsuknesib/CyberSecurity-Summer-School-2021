package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.amap.openapi.av$1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class oj {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f2348O000000o;
    oh O00000Oo;
    uc O00000o;
    ox O00000o0;
    qh O00000oO;
    tv O00000oo;
    tw O0000O0o;
    HandlerThread O0000OOo;
    Looper O0000Oo;
    volatile O00000Oo O0000Oo0;
    boolean O0000OoO = false;
    final Object O0000Ooo = new Object();
    private qs O0000o0;
    O000000o O0000o00;
    private qr O0000o0O;

    public oj(Context context, oh ohVar, ox oxVar) {
        this.f2348O000000o = context;
        this.O00000Oo = ohVar;
        this.O00000o0 = oxVar;
    }

    public final void O000000o() {
        if (O00000o0()) {
            this.O0000OOo = new HandlerThread("collection") {
                /* class _m_j.oj.AnonymousClass1 */

                /* access modifiers changed from: protected */
                /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00d7 */
                /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0077 */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x00e1 A[Catch:{ Throwable -> 0x00eb }, RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x007f A[SYNTHETIC] */
                public final void onLooperPrepared() {
                    try {
                        oj.this.O0000Oo = getLooper();
                        oj.this.O00000o = new uc(oj.this.f2348O000000o, oj.this.O0000Oo);
                        uc ucVar = oj.this.O00000o;
                        ucVar.O00000Oo.O000000o(ucVar.O00000o0, ucVar.f2525O000000o);
                        oj.this.O00000oO = new qh(oj.this.f2348O000000o, oj.this.O0000Oo, oj.this.O00000o, oj.this.O00000o0, oj.this.O00000Oo);
                        qh qhVar = oj.this.O00000oO;
                        qhVar.O00000Oo = new Handler(qhVar.O0000OoO);
                        qhVar.O0000Oo0.O000000o(qhVar.f2396O000000o, qhVar.O0000Oo, qhVar.O0000OoO);
                        qhVar.O00000oO = new av$1(qhVar);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        qhVar.f2396O000000o.registerReceiver(qhVar.O00000oO, intentFilter, null, qhVar.O00000Oo);
                        qhVar.O000000o();
                        synchronized (oj.this.O0000Ooo) {
                            oj.this.O0000Oo0 = new O00000Oo(oj.this.O0000Oo);
                            if (oj.this.O0000OoO) {
                                oj.this.O0000OoO = false;
                                oj.this.O0000Oo0.obtainMessage(1).sendToTarget();
                            }
                        }
                        if (oj.this.O00000Oo.O00000Oo) {
                            oj.this.O0000o00 = new O000000o(oj.this, (byte) 0);
                            IntentFilter intentFilter2 = new IntentFilter();
                            intentFilter2.addAction("android.intent.action.SCREEN_ON");
                            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
                            oj.this.f2348O000000o.registerReceiver(oj.this.O0000o00, intentFilter2, null, oj.this.O0000Oo0);
                            if (!ql.O00000o0(oj.this.f2348O000000o)) {
                                return;
                            }
                        }
                        oj.O000000o(oj.this);
                    } catch (Throwable unused) {
                    }
                }
            };
            this.O0000OOo.start();
        }
    }

    public final void O00000Oo() {
        synchronized (this.O0000Ooo) {
            if (this.O0000Oo0 != null) {
                this.O0000Oo0.obtainMessage(1).sendToTarget();
            } else {
                this.O0000OoO = true;
            }
        }
    }

    class O00000Oo extends Handler {
        O00000Oo(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (oj.this.O0000o00 != null) {
                    try {
                        oj.this.f2348O000000o.unregisterReceiver(oj.this.O0000o00);
                        oj.this.O0000o00 = null;
                    } catch (Throwable unused) {
                    }
                }
                oj.O00000Oo(oj.this);
                removeCallbacksAndMessages(null);
                qh qhVar = oj.this.O00000oO;
                try {
                    qhVar.O0000Oo0.O000000o();
                    if (qhVar.O00000oO != null) {
                        qhVar.f2396O000000o.unregisterReceiver(qhVar.O00000oO);
                        qhVar.O00000oO = null;
                    }
                } catch (Throwable unused2) {
                }
                qhVar.O00000Oo.removeCallbacksAndMessages(null);
                qhVar.O00000Oo = null;
                try {
                    oj.this.O00000o.O00000Oo.O000000o();
                } catch (Throwable unused3) {
                }
                post(new Runnable() {
                    /* class _m_j.oj.O00000Oo.AnonymousClass1 */

                    public final void run() {
                        try {
                            oj.this.O0000OOo.quit();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }
    }

    private boolean O00000o0() {
        return this.O00000Oo.O00000o0.f2343O000000o || this.O00000Oo.O00000o.f2344O000000o;
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(oj ojVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (action != null) {
                    char c = 65535;
                    int hashCode = action.hashCode();
                    if (hashCode != -2128145023) {
                        if (hashCode == -1454123155) {
                            if (action.equals("android.intent.action.SCREEN_ON")) {
                                c = 1;
                            }
                        }
                    } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                        c = 0;
                    }
                    if (c != 0) {
                        if (c == 1) {
                            if (oj.this.O00000Oo.O00000Oo) {
                                oj.O000000o(oj.this);
                            }
                        }
                    } else if (oj.this.O00000Oo.O00000Oo) {
                        oj.O00000Oo(oj.this);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(float, float):float}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(long, long):long} */
    static /* synthetic */ void O000000o(oj ojVar) {
        long j;
        if (ojVar.O0000o0O == null) {
            boolean z = ojVar.O00000Oo.O00000o0.f2343O000000o;
            boolean z2 = ojVar.O00000Oo.O00000o.f2344O000000o;
            long j2 = 0;
            int i = 0;
            if (z) {
                j2 = 1000;
                i = 10;
            }
            if (z2) {
                if (z) {
                    j = Math.min(j, 2000L);
                } else {
                    j = 2000;
                }
                if (z) {
                    Math.min(i, 5);
                }
            }
            try {
                ojVar.O0000o0O = new qr() {
                    /* class _m_j.oj.AnonymousClass2 */

                    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x004a */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0081 */
                    /* JADX WARNING: Removed duplicated region for block: B:132:0x0221 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:133:0x0222 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:136:0x0227 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:140:0x0253 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:142:0x0258 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:192:0x031b A[SYNTHETIC, Splitter:B:192:0x031b] */
                    /* JADX WARNING: Removed duplicated region for block: B:194:0x0331 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:196:0x0335 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:201:0x035d A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:206:0x0371 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:223:0x03dc A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089 A[Catch:{ Throwable -> 0x03e2 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:82:0x0151 A[Catch:{ Throwable -> 0x03e2 }] */
                    public final void O000000o(Location location, List<ScanResult> list, long j, long j2) {
                        boolean z;
                        byte[] bArr;
                        tz tzVar;
                        tx txVar;
                        boolean z2;
                        ArrayList<pn> arrayList;
                        byte[] O000000o2;
                        boolean z3;
                        List<ScanResult> list2;
                        Iterator<ScanResult> it;
                        boolean z4;
                        boolean z5;
                        boolean z6;
                        Location location2 = location;
                        List<ScanResult> list3 = list;
                        oj ojVar = oj.this;
                        if (ojVar.O00000Oo.O00000o0.f2343O000000o && ojVar.O00000oo == null) {
                            ojVar.O00000oo = new tv(ojVar.f2348O000000o, ojVar.O00000o, ojVar.O0000Oo);
                            tv tvVar = ojVar.O00000oo;
                            tvVar.O00000o.O000000o();
                            tvVar.O00000oO.O000000o();
                            tvVar.O00000oo = new sf() {
                                /* class _m_j.tv.AnonymousClass1 */

                                public final void O000000o(long j) {
                                    long unused = tv.this.O0000O0o = j;
                                }
                            };
                            se O000000o3 = se.O000000o(tvVar.f2514O000000o);
                            sf sfVar = tvVar.O00000oo;
                            Looper looper = tvVar.O00000Oo.getLooper();
                            if (sfVar != null) {
                                O000000o3.O00000Oo.O000000o(sfVar, looper);
                            }
                        }
                        try {
                            if (ojVar.O00000Oo.O00000o.f2344O000000o && ojVar.O0000O0o == null) {
                                ojVar.O0000O0o = new tw(ojVar.f2348O000000o, ojVar.O00000o, ojVar.O00000Oo.O00000o, ojVar.O0000Oo);
                                tw twVar = ojVar.O0000O0o;
                                twVar.O00000oo = new sh() {
                                    /* class _m_j.tw.AnonymousClass1 */

                                    public final void O000000o(int i, List<sg> list) {
                                        long unused = tw.this.O0000Oo0 = SystemClock.elapsedRealtime();
                                        List unused2 = tw.this.O0000OoO = list;
                                    }
                                };
                                se.O000000o(twVar.f2516O000000o).O000000o(twVar.O00000oo, twVar.O00000o0.getLooper());
                            }
                            if (ojVar.O00000Oo.O00000o0.f2343O000000o) {
                                tv tvVar2 = ojVar.O00000oo;
                                long elapsedRealtime = SystemClock.elapsedRealtime();
                                float f = 10.0f;
                                if (tvVar2.O0000Oo0 == null || location2.distanceTo(tvVar2.O0000Oo0) >= 10.0f) {
                                    tu tuVar = tvVar2.O00000o;
                                    if (tuVar.O00000o0) {
                                        CellLocation O00000o0 = tuVar.O00000o0();
                                        if ((O00000o0 instanceof CdmaCellLocation) && -1 == ((CdmaCellLocation) O00000o0).getNetworkId()) {
                                            O00000o0 = null;
                                        }
                                        List<CellInfo> O00000o = tuVar.O00000o();
                                        CellInfo O000000o4 = O00000o != null ? qj.O000000o(O00000o) : null;
                                        if (!(O00000o0 == null && O000000o4 == null)) {
                                            if (tuVar.O00000oo != null) {
                                                if (!(location2.distanceTo(tuVar.O00000oo) > ((location.getSpeed() > 10.0f ? 1 : (location.getSpeed() == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (location.getSpeed() > 2.0f ? 1 : (location.getSpeed() == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f))) {
                                                    CellLocation cellLocation = tuVar.O00000o;
                                                    if (O00000o0 != cellLocation) {
                                                        if (O00000o0 != null) {
                                                            if (cellLocation != null) {
                                                                if ((O00000o0 instanceof GsmCellLocation) && (cellLocation instanceof GsmCellLocation)) {
                                                                    GsmCellLocation gsmCellLocation = (GsmCellLocation) O00000o0;
                                                                    GsmCellLocation gsmCellLocation2 = (GsmCellLocation) cellLocation;
                                                                    if (gsmCellLocation.getCid() == gsmCellLocation2.getCid() && gsmCellLocation.getLac() == gsmCellLocation2.getLac()) {
                                                                    }
                                                                } else if ((O00000o0 instanceof CdmaCellLocation) && (cellLocation instanceof CdmaCellLocation)) {
                                                                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) O00000o0;
                                                                    CdmaCellLocation cdmaCellLocation2 = (CdmaCellLocation) cellLocation;
                                                                    if (cdmaCellLocation.getBaseStationId() == cdmaCellLocation2.getBaseStationId() && cdmaCellLocation.getNetworkId() == cdmaCellLocation2.getNetworkId() && cdmaCellLocation.getSystemId() == cdmaCellLocation2.getSystemId()) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z5 = false;
                                                        if (z5) {
                                                            CellInfo cellInfo = tuVar.O00000oO;
                                                            if (O000000o4 != cellInfo) {
                                                                if (O000000o4 != null) {
                                                                    if (cellInfo != null) {
                                                                        if (Build.VERSION.SDK_INT >= 17) {
                                                                            if ((O000000o4 instanceof CellInfoGsm) && (cellInfo instanceof CellInfoGsm)) {
                                                                                CellIdentityGsm cellIdentity = ((CellInfoGsm) O000000o4).getCellIdentity();
                                                                                CellIdentityGsm cellIdentity2 = ((CellInfoGsm) cellInfo).getCellIdentity();
                                                                                if (cellIdentity.getCid() == cellIdentity2.getCid() && cellIdentity.getLac() == cellIdentity2.getLac()) {
                                                                                }
                                                                            } else if ((O000000o4 instanceof CellInfoCdma) && (cellInfo instanceof CellInfoCdma)) {
                                                                                CellIdentityCdma cellIdentity3 = ((CellInfoCdma) O000000o4).getCellIdentity();
                                                                                CellIdentityCdma cellIdentity4 = ((CellInfoCdma) cellInfo).getCellIdentity();
                                                                                if (cellIdentity3.getBasestationId() == cellIdentity4.getBasestationId() && cellIdentity3.getNetworkId() == cellIdentity4.getNetworkId() && cellIdentity3.getSystemId() == cellIdentity4.getSystemId()) {
                                                                                }
                                                                            } else if ((O000000o4 instanceof CellInfoLte) && (cellInfo instanceof CellInfoLte)) {
                                                                                CellIdentityLte cellIdentity5 = ((CellInfoLte) O000000o4).getCellIdentity();
                                                                                CellIdentityLte cellIdentity6 = ((CellInfoLte) cellInfo).getCellIdentity();
                                                                                if (cellIdentity5.getCi() == cellIdentity6.getCi() && cellIdentity5.getTac() == cellIdentity6.getTac()) {
                                                                                }
                                                                            } else if (Build.VERSION.SDK_INT >= 18 && (O000000o4 instanceof CellInfoWcdma) && (cellInfo instanceof CellInfoWcdma)) {
                                                                                CellIdentityWcdma cellIdentity7 = ((CellInfoWcdma) O000000o4).getCellIdentity();
                                                                                CellIdentityWcdma cellIdentity8 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                                                                                if (cellIdentity7.getCid() == cellIdentity8.getCid() && cellIdentity7.getLac() == cellIdentity8.getLac()) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                z6 = false;
                                                                if (!z6) {
                                                                    z4 = false;
                                                                    if (z4) {
                                                                        qj.O000000o(tuVar.f2508O000000o, tuVar.O0000O0o, O00000o0, tuVar.O00000Oo, O00000o);
                                                                        tuVar.O00000o = O00000o0;
                                                                        tuVar.O00000oO = O000000o4;
                                                                        tuVar.O00000oo = location2;
                                                                        qf.O000000o(tuVar.O0000O0o.O00000o0);
                                                                        tuVar.O000000o(tuVar.O0000O0o);
                                                                        tzVar = tuVar.O0000O0o;
                                                                        txVar = tvVar2.O00000oO;
                                                                        if (qq.O000000o(txVar.f2518O000000o)) {
                                                                            long j3 = j2;
                                                                        } else if (tx.O000000o(location2, j, j2) && list3 != null && list.size() > 0) {
                                                                            if (txVar.O00000o != null) {
                                                                                if (location.getSpeed() > 10.0f) {
                                                                                    f = 200.0f;
                                                                                } else if (location.getSpeed() > 2.0f) {
                                                                                    f = 50.0f;
                                                                                }
                                                                                boolean z7 = location2.distanceTo(txVar.O00000o) > f;
                                                                                if (!z7) {
                                                                                    List<ScanResult> list4 = txVar.O00000o0;
                                                                                    if (list3 != null) {
                                                                                        if (list4 != null) {
                                                                                            int size = list.size();
                                                                                            int size2 = list4.size();
                                                                                            int i = size + size2;
                                                                                            if (size > size2) {
                                                                                                list2 = list4;
                                                                                                list4 = list3;
                                                                                            } else {
                                                                                                list2 = list3;
                                                                                            }
                                                                                            HashMap hashMap = new HashMap(list4.size());
                                                                                            Iterator<ScanResult> it2 = list4.iterator();
                                                                                            while (it2.hasNext()) {
                                                                                                ScanResult next = it2.next();
                                                                                                if (next.BSSID != null) {
                                                                                                    it = it2;
                                                                                                    hashMap.put(next.BSSID, 1);
                                                                                                } else {
                                                                                                    it = it2;
                                                                                                }
                                                                                                it2 = it;
                                                                                            }
                                                                                            int i2 = 0;
                                                                                            for (ScanResult next2 : list2) {
                                                                                                if (!(next2.BSSID == null || ((Integer) hashMap.get(next2.BSSID)) == null)) {
                                                                                                    i2++;
                                                                                                }
                                                                                            }
                                                                                            double d = (double) i2;
                                                                                            Double.isNaN(d);
                                                                                            double d2 = (double) i;
                                                                                            Double.isNaN(d2);
                                                                                            if (d * 2.0d >= d2 * 0.5d) {
                                                                                                z3 = true;
                                                                                                z7 = !z3;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    z3 = false;
                                                                                    z7 = !z3;
                                                                                }
                                                                                z2 = z7;
                                                                            } else {
                                                                                z2 = true;
                                                                            }
                                                                            if (z2) {
                                                                                qq.O000000o(txVar.O00000oO, list3);
                                                                                txVar.O00000o0.clear();
                                                                                txVar.O00000o0.addAll(list3);
                                                                                txVar.O00000o = location2;
                                                                                arrayList = txVar.O00000oO;
                                                                            } else {
                                                                                arrayList = null;
                                                                            }
                                                                            if (tzVar == null) {
                                                                                if (arrayList != null) {
                                                                                }
                                                                                z = false;
                                                                                tvVar2.O0000Oo0 = location2;
                                                                                tvVar2.O0000OOo = elapsedRealtime;
                                                                                if (!ojVar.O00000Oo.O00000o.f2344O000000o) {
                                                                                    tw twVar2 = ojVar.O0000O0o;
                                                                                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                                                                    if (twVar2.O0000OOo != null) {
                                                                                        if (elapsedRealtime2 - twVar2.O0000O0o < 2000 || location2.distanceTo(twVar2.O0000OOo) < 5.0f) {
                                                                                            bArr = null;
                                                                                            if (bArr == null) {
                                                                                                twVar2.O00000o.O000000o(1, bArr);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    twVar2.O0000O0o = elapsedRealtime2;
                                                                                    twVar2.O0000OOo = location2;
                                                                                    if (twVar2.O00000Oo.O00000o0 && twVar2.O0000Oo0 != 0 && elapsedRealtime2 - twVar2.O0000Oo0 <= 3000) {
                                                                                        z = true;
                                                                                    }
                                                                                    short O000000o5 = qn.O000000o(twVar2.O0000Oo, z, twVar2.O0000OoO);
                                                                                    ud udVar = twVar2.O0000Ooo;
                                                                                    long time = location.getTime();
                                                                                    long currentTimeMillis = System.currentTimeMillis();
                                                                                    udVar.O0000Oo = O000000o5;
                                                                                    qn.O000000o(udVar, location, time, currentTimeMillis);
                                                                                    bArr = twVar2.O00000oO.O000000o(twVar2.f2516O000000o, twVar2.O0000Ooo, twVar2.O0000Oo, twVar2.O00000Oo.O00000Oo);
                                                                                    if (bArr == null) {
                                                                                    }
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            }
                                                                            qn.O000000o(tvVar2.O0000OoO, location, tvVar2.O0000O0o, j2);
                                                                            O000000o2 = tvVar2.O0000Oo.O000000o(tvVar2.f2514O000000o, tvVar2.O0000OoO, tzVar, tvVar2.O00000oO.O00000Oo, arrayList);
                                                                            if (O000000o2 != null) {
                                                                                z = false;
                                                                                tvVar2.O00000o0.O000000o(0, O000000o2);
                                                                                tvVar2.O0000Oo0 = location2;
                                                                                tvVar2.O0000OOo = elapsedRealtime;
                                                                                if (!ojVar.O00000Oo.O00000o.f2344O000000o) {
                                                                                }
                                                                            }
                                                                            z = false;
                                                                            tvVar2.O0000Oo0 = location2;
                                                                            tvVar2.O0000OOo = elapsedRealtime;
                                                                            if (!ojVar.O00000Oo.O00000o.f2344O000000o) {
                                                                            }
                                                                        }
                                                                        z2 = false;
                                                                        if (z2) {
                                                                        }
                                                                        if (tzVar == null) {
                                                                        }
                                                                        qn.O000000o(tvVar2.O0000OoO, location, tvVar2.O0000O0o, j2);
                                                                        O000000o2 = tvVar2.O0000Oo.O000000o(tvVar2.f2514O000000o, tvVar2.O0000OoO, tzVar, tvVar2.O00000oO.O00000Oo, arrayList);
                                                                        if (O000000o2 != null) {
                                                                        }
                                                                        z = false;
                                                                        tvVar2.O0000Oo0 = location2;
                                                                        tvVar2.O0000OOo = elapsedRealtime;
                                                                        if (!ojVar.O00000Oo.O00000o.f2344O000000o) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z6 = true;
                                                            if (!z6) {
                                                            }
                                                        }
                                                    }
                                                    z5 = true;
                                                    if (z5) {
                                                    }
                                                }
                                            }
                                            z4 = true;
                                            if (z4) {
                                            }
                                        }
                                    }
                                    tzVar = null;
                                    txVar = tvVar2.O00000oO;
                                    if (qq.O000000o(txVar.f2518O000000o)) {
                                    }
                                    z2 = false;
                                    if (z2) {
                                    }
                                    if (tzVar == null) {
                                    }
                                    qn.O000000o(tvVar2.O0000OoO, location, tvVar2.O0000O0o, j2);
                                    O000000o2 = tvVar2.O0000Oo.O000000o(tvVar2.f2514O000000o, tvVar2.O0000OoO, tzVar, tvVar2.O00000oO.O00000Oo, arrayList);
                                    if (O000000o2 != null) {
                                    }
                                    z = false;
                                    tvVar2.O0000Oo0 = location2;
                                    tvVar2.O0000OOo = elapsedRealtime;
                                    if (!ojVar.O00000Oo.O00000o.f2344O000000o) {
                                    }
                                }
                            }
                            z = false;
                            if (!ojVar.O00000Oo.O00000o.f2344O000000o) {
                            }
                        } catch (Throwable unused) {
                        }
                    }
                };
                if (ojVar.O0000o0 == null) {
                    ojVar.O0000o0 = new qs(ojVar.f2348O000000o, ojVar.O00000Oo.O00000o0, ojVar.O0000o0O, ojVar.O0000Oo);
                }
                ojVar.O0000o0.O000000o("passive", j);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x005a */
    static /* synthetic */ void O00000Oo(oj ojVar) {
        qt qtVar;
        try {
            if (ojVar.O0000o0O != null && ojVar.O0000o0 != null) {
                qs qsVar = ojVar.O0000o0;
                if (qsVar.f2403O000000o.O00000oO) {
                    qtVar = qsVar.f2403O000000o;
                    if (qtVar.O00000oO) {
                        qtVar.O00000oO = false;
                        qtVar.O00000o.readLock().lock();
                        if (qtVar.O0000O0o != null) {
                            qtVar.O0000O0o.sendEmptyMessage(1);
                        }
                        qtVar.O00000o.readLock().unlock();
                    }
                }
                ojVar.O0000o0.O000000o();
                ojVar.O0000o0O = null;
                if (ojVar.O00000oo != null) {
                    tv tvVar = ojVar.O00000oo;
                    se.O000000o(tvVar.f2514O000000o).O000000o(tvVar.O00000oo);
                    tvVar.O00000Oo.removeCallbacksAndMessages(null);
                    tvVar.O00000o.O00000Oo();
                    tvVar.O00000oO.O00000Oo();
                    ojVar.O00000oo = null;
                }
                if (ojVar.O0000O0o != null) {
                    ojVar.O0000O0o.O000000o();
                    ojVar.O0000O0o = null;
                }
                qf.O000000o();
            }
        } catch (Throwable unused) {
        }
    }
}
