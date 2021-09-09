package _m_j;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;

public abstract class jak {

    /* renamed from: O000000o  reason: collision with root package name */
    private static jak f1696O000000o;

    public abstract void O000000o(List<ScanFilter> list, ScanSettings scanSettings, jat jat, Handler handler);

    /* access modifiers changed from: package-private */
    public abstract void O00000Oo(jat jat);

    public static synchronized jak O000000o() {
        synchronized (jak.class) {
            if (f1696O000000o != null) {
                jak jak = f1696O000000o;
                return jak;
            } else if (Build.VERSION.SDK_INT >= 26) {
                jao jao = new jao();
                f1696O000000o = jao;
                return jao;
            } else if (Build.VERSION.SDK_INT >= 23) {
                jan jan = new jan();
                f1696O000000o = jan;
                return jan;
            } else if (Build.VERSION.SDK_INT >= 21) {
                jam jam = new jam();
                f1696O000000o = jam;
                return jam;
            } else {
                jal jal = new jal();
                f1696O000000o = jal;
                return jal;
            }
        }
    }

    jak() {
    }

    public final void O000000o(jat jat) {
        if (jat != null) {
            O00000Oo(jat);
            return;
        }
        throw new IllegalArgumentException("callback is null");
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Object f1697O000000o = new Object();
        final boolean O00000Oo;
        final List<ScanFilter> O00000o;
        public boolean O00000o0;
        final ScanSettings O00000oO;
        final jat O00000oo;
        final Handler O0000O0o;
        final List<ScanResult> O0000OOo = new ArrayList();
        public final Map<String, ScanResult> O0000Oo = new HashMap();
        final Set<String> O0000Oo0 = new HashSet();
        private final boolean O0000OoO;
        private final boolean O0000Ooo;
        private final Runnable O0000o0 = new Runnable() {
            /* class _m_j.jak.O000000o.AnonymousClass2 */

            public final void run() {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                synchronized (O000000o.this.f1697O000000o) {
                    Iterator<ScanResult> it = O000000o.this.O0000Oo.values().iterator();
                    while (it.hasNext()) {
                        final ScanResult next = it.next();
                        if (next.O00000o < elapsedRealtimeNanos - O000000o.this.O00000oO.O0000OoO) {
                            it.remove();
                            O000000o.this.O0000O0o.post(new Runnable() {
                                /* class _m_j.jak.O000000o.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    O000000o.this.O00000oo.onScanResult(4, next);
                                }
                            });
                        }
                    }
                    if (!O000000o.this.O0000Oo.isEmpty()) {
                        O000000o.this.O0000O0o.postDelayed(this, O000000o.this.O00000oO.O0000Ooo);
                    }
                }
            }
        };
        private final Runnable O0000o00 = new Runnable() {
            /* class _m_j.jak.O000000o.AnonymousClass1 */

            public final void run() {
                if (!O000000o.this.O00000o0) {
                    O000000o o000000o = O000000o.this;
                    if (o000000o.O00000Oo && !o000000o.O00000o0) {
                        synchronized (o000000o.f1697O000000o) {
                            o000000o.O00000oo.onBatchScanResults(new ArrayList(o000000o.O0000OOo));
                            o000000o.O0000OOo.clear();
                            o000000o.O0000Oo0.clear();
                        }
                    }
                    O000000o.this.O0000O0o.postDelayed(this, O000000o.this.O00000oO.O00000oO);
                }
            }
        };

        O000000o(boolean z, boolean z2, List<ScanFilter> list, ScanSettings scanSettings, jat jat, Handler handler) {
            this.O00000o = Collections.unmodifiableList(list);
            this.O00000oO = scanSettings;
            this.O00000oo = jat;
            this.O0000O0o = handler;
            boolean z3 = false;
            this.O00000o0 = false;
            this.O0000Ooo = scanSettings.O00000o != 1 && (!(Build.VERSION.SDK_INT >= 23) || !scanSettings.O0000Oo);
            this.O0000OoO = !list.isEmpty() && (!z2 || !scanSettings.O0000OOo);
            long j = scanSettings.O00000oO;
            if (j > 0 && (!z || !scanSettings.O0000Oo0)) {
                z3 = true;
            }
            this.O00000Oo = z3;
            if (this.O00000Oo) {
                handler.postDelayed(this.O0000o00, j);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O00000o0 = true;
            this.O0000O0o.removeCallbacksAndMessages(null);
            synchronized (this.f1697O000000o) {
                this.O0000Oo.clear();
                this.O0000Oo0.clear();
                this.O0000OOo.clear();
            }
        }

        public final void O000000o(int i, ScanResult scanResult) {
            boolean isEmpty;
            ScanResult put;
            if (this.O00000o0) {
                return;
            }
            if (this.O00000o.isEmpty() || O000000o(scanResult)) {
                String address = scanResult.f15416O000000o.getAddress();
                if (this.O0000Ooo) {
                    synchronized (this.O0000Oo) {
                        isEmpty = this.O0000Oo.isEmpty();
                        put = this.O0000Oo.put(address, scanResult);
                    }
                    if (put == null && (this.O00000oO.O00000o & 2) > 0) {
                        this.O00000oo.onScanResult(2, scanResult);
                    }
                    if (isEmpty && (this.O00000oO.O00000o & 4) > 0) {
                        this.O0000O0o.removeCallbacks(this.O0000o0);
                        this.O0000O0o.postDelayed(this.O0000o0, this.O00000oO.O0000Ooo);
                    }
                } else if (this.O00000Oo) {
                    synchronized (this.f1697O000000o) {
                        if (!this.O0000Oo0.contains(address)) {
                            this.O0000OOo.add(scanResult);
                            this.O0000Oo0.add(address);
                        }
                    }
                } else {
                    this.O00000oo.onScanResult(i, scanResult);
                }
            }
        }

        public final void O000000o(List<ScanResult> list) {
            if (!this.O00000o0) {
                if (this.O0000OoO) {
                    ArrayList arrayList = new ArrayList();
                    for (ScanResult next : list) {
                        if (O000000o(next)) {
                            arrayList.add(next);
                        }
                    }
                    list = arrayList;
                }
                this.O00000oo.onBatchScanResults(list);
            }
        }

        public final void O000000o(int i) {
            this.O00000oo.onScanFailed(i);
        }

        private boolean O000000o(ScanResult scanResult) {
            for (ScanFilter O000000o2 : this.O00000o) {
                if (O000000o2.O000000o(scanResult)) {
                    return true;
                }
            }
            return false;
        }
    }
}
