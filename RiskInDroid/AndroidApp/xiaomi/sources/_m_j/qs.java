package _m_j;

import _m_j.oh;
import _m_j.qt;
import _m_j.si;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;

public final class qs {

    /* renamed from: O000000o  reason: collision with root package name */
    public qt f2403O000000o;
    boolean O00000Oo;
    qr O00000o;
    Context O00000o0;
    boolean O00000oO;
    private LocationListener O00000oo;
    private se O0000O0o;
    private sh O0000OOo;
    private Looper O0000Oo;
    private final Object O0000Oo0 = new Object();

    public qs(Context context, oh.O000000o o000000o, qr qrVar, Looper looper) {
        this.O00000o0 = context;
        this.O0000Oo = looper;
        this.O0000O0o = se.O000000o(context);
        this.O00000o = qrVar;
        this.f2403O000000o = new qt(context, o000000o, looper);
        this.O00000oo = new LocationListener() {
            /* class _m_j.qs.AnonymousClass1 */

            public final void onProviderDisabled(String str) {
            }

            public final void onProviderEnabled(String str) {
            }

            public final void onStatusChanged(String str, int i, Bundle bundle) {
            }

            /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[Catch:{ all -> 0x00ad, Throwable -> 0x00d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x0077 A[Catch:{ all -> 0x00ad, Throwable -> 0x00d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:34:0x0078 A[Catch:{ all -> 0x00ad, Throwable -> 0x00d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
            public final void onLocationChanged(Location location) {
                boolean z;
                boolean z2;
                qt qtVar;
                if (qs.this.O00000oO) {
                    if (location != null) {
                        try {
                            if ("gps".equalsIgnoreCase(location.getProvider()) && location.getLatitude() > -90.0d && location.getLatitude() < 90.0d && location.getLongitude() > -180.0d && location.getLongitude() < 180.0d) {
                                z = true;
                                if (!z) {
                                    Context context = qs.this.O00000o0;
                                    if (Build.VERSION.SDK_INT < 18) {
                                        if (!Build.MODEL.equals("sdk") && !ql.O00000Oo(context)) {
                                        }
                                        z2 = true;
                                        if (!z2) {
                                        }
                                    } else if (ql.O000000o(location)) {
                                        z2 = true;
                                        if (!z2) {
                                            qs qsVar = qs.this;
                                            if (!qsVar.f2403O000000o.O00000oO) {
                                                qtVar = qsVar.f2403O000000o;
                                                if (!qtVar.O00000oO) {
                                                    qtVar.O00000oO = true;
                                                    qtVar.O00000o.writeLock().lock();
                                                    if (qtVar.O0000O0o == null) {
                                                        qtVar.O0000O0o = new qt.O00000Oo(qtVar.O00000Oo);
                                                    }
                                                    qtVar.O0000O0o.sendEmptyMessage(0);
                                                    qtVar.O00000o.writeLock().unlock();
                                                }
                                            }
                                            if (qs.this.O00000o != null) {
                                                qt.O000000o O000000o2 = qs.this.f2403O000000o.O000000o();
                                                qs.this.O00000o.O000000o(location, O000000o2.f2409O000000o, O000000o2.O00000Oo, System.currentTimeMillis());
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    z2 = false;
                                    if (!z2) {
                                    }
                                } else {
                                    return;
                                }
                            }
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
        };
        this.O0000OOo = new sh() {
            /* class _m_j.qs.AnonymousClass2 */

            public final void O000000o(int i, List<sg> list) {
                qs qsVar = qs.this;
                boolean z = i < 4;
                if (qsVar.O00000Oo != z) {
                    qsVar.O00000Oo = z;
                    if (z) {
                        qt qtVar = qsVar.f2403O000000o;
                        qtVar.O00000o.readLock().lock();
                        try {
                            if (qtVar.O0000O0o != null) {
                                qtVar.O0000O0o.removeMessages(2);
                            }
                        } finally {
                            qtVar.O00000o.readLock().unlock();
                        }
                    } else {
                        qt qtVar2 = qsVar.f2403O000000o;
                        qtVar2.O00000o.readLock().lock();
                        try {
                            if (qtVar2.O0000O0o != null && !qtVar2.O0000O0o.hasMessages(2)) {
                                qtVar2.O0000O0o.sendEmptyMessage(2);
                            }
                        } finally {
                            qtVar2.O00000o.readLock().unlock();
                        }
                    }
                }
            }
        };
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:44|45) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007d, code lost:
        if (r3.O00000o0.size() != 0) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.f2455O000000o.registerReceiver(r3.O00000Oo, new android.content.IntentFilter("android.location.PROVIDERS_CHANGED"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r3.O00000o0.add(new _m_j.sj(r5, r12, 0.0f, r9));
        r3.O000000o();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x008d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00aa */
    public final void O000000o(String str, long j) {
        synchronized (this.O0000Oo0) {
            this.O00000oO = true;
            se seVar = this.O0000O0o;
            si.O000000o o000000o = null;
            List<String> O000000o2 = seVar.f2452O000000o == null ? null : seVar.f2452O000000o.O000000o();
            if (O000000o2.contains("gps") || O000000o2.contains("passive")) {
                se seVar2 = this.O0000O0o;
                LocationListener locationListener = this.O00000oo;
                Looper looper = this.O0000Oo;
                if (locationListener != null) {
                    si siVar = seVar2.O00000o0;
                    if (locationListener != null) {
                        if ("gps".equals(str)) {
                            o000000o = siVar.f2454O000000o;
                        } else if ("passive".equals(str)) {
                            o000000o = siVar.O00000Oo;
                        }
                        if (o000000o != null) {
                            synchronized (o000000o.O00000o0) {
                                try {
                                    Iterator<sj> it = o000000o.O00000o0.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        sj next = it.next();
                                        if (next.f2457O000000o == locationListener) {
                                            if (!(next.O00000Oo == j && next.O00000o0 == 0.0f)) {
                                                next.O00000Oo = j;
                                                next.O00000o0 = 0.0f;
                                                o000000o.O000000o();
                                            }
                                        }
                                    }
                                } catch (Throwable ) {
                                }
                            }
                        }
                    }
                }
                this.O0000O0o.O000000o(this.O0000OOo, this.O0000Oo);
            }
        }
        return;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:2|3|4|5|6|(2:8|(1:10))|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0021 */
    public final void O000000o() {
        synchronized (this.O0000Oo0) {
            this.O00000oO = false;
            se seVar = this.O0000O0o;
            LocationListener locationListener = this.O00000oo;
            if (locationListener != null) {
                si siVar = seVar.O00000o0;
                if (locationListener != null) {
                    siVar.f2454O000000o.O000000o(locationListener);
                    siVar.O00000Oo.O000000o(locationListener);
                }
            }
            this.O0000O0o.O000000o(this.O0000OOo);
        }
    }
}
