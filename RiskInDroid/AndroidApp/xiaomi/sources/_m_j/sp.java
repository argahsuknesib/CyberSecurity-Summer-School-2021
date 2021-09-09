package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class sp {

    /* renamed from: O000000o  reason: collision with root package name */
    final List<O000000o> f2471O000000o = new CopyOnWriteArrayList();
    sl O00000Oo;
    GpsStatus.Listener O00000o;
    GnssStatus.Callback O00000o0;
    GpsStatus O00000oO;
    private Context O00000oo;
    private O00000Oo O0000O0o = new O00000Oo(this, (byte) 0);

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Handler f2474O000000o;
        sh O00000Oo;

        /* renamed from: _m_j.sp$O000000o$O000000o  reason: collision with other inner class name */
        static class C0011O000000o extends Handler {

            /* renamed from: O000000o  reason: collision with root package name */
            private sh f2475O000000o;

            C0011O000000o(sh shVar, Looper looper) {
                super(looper);
                this.f2475O000000o = shVar;
            }

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i != 1 && i != 2) {
                    if (i == 3) {
                        ((Integer) message.obj).intValue();
                    } else if (i == 4) {
                        O00000o0 o00000o0 = (O00000o0) message.obj;
                        this.f2475O000000o.O000000o(o00000o0.f2477O000000o, o00000o0.O00000o);
                    }
                }
            }
        }

        O000000o(sh shVar, Looper looper) {
            this.O00000Oo = shVar;
            this.f2474O000000o = new C0011O000000o(this.O00000Oo, looper == null ? Looper.getMainLooper() : looper);
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, Object obj) {
            Message obtainMessage = this.f2474O000000o.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2477O000000o;
        int O00000Oo;
        List<sg> O00000o;
        float O00000o0;

        public O00000o0(int i, int i2, float f, List<sg> list) {
            this.f2477O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = f;
            this.O00000o = list;
        }
    }

    public sp(sl slVar, Context context) {
        this.O00000Oo = slVar;
        this.O00000oo = context;
        if (Build.VERSION.SDK_INT >= 24) {
            this.O00000o0 = new GnssStatus.Callback() {
                /* class _m_j.sp.AnonymousClass1 */

                public final void onFirstFix(int i) {
                    sp.O000000o(sp.this, i);
                }

                public final void onStarted() {
                    sp.O000000o(sp.this);
                }

                public final void onStopped() {
                    sp.O00000Oo(sp.this);
                }

                public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
                    sp spVar = sp.this;
                    try {
                        if (Build.VERSION.SDK_INT >= 24 && gnssStatus != null) {
                            int satelliteCount = gnssStatus.getSatelliteCount();
                            ArrayList arrayList = new ArrayList();
                            int i = 0;
                            float f = 0.0f;
                            for (int i2 = 0; i2 < satelliteCount; i2++) {
                                arrayList.add(new sg(gnssStatus.usedInFix(i2), gnssStatus.getSvid(i2), gnssStatus.getCn0DbHz(i2), gnssStatus.getElevationDegrees(i2), gnssStatus.getAzimuthDegrees(i2), gnssStatus.getConstellationType(i2)));
                                if (gnssStatus.usedInFix(i2)) {
                                    i++;
                                    f += gnssStatus.getCn0DbHz(i2);
                                }
                            }
                            if (i != 0) {
                                f /= (float) i;
                            }
                            spVar.O000000o(i, satelliteCount, f, arrayList);
                        }
                    } catch (Exception unused) {
                    }
                }
            };
        } else {
            this.O00000o = new GpsStatus.Listener() {
                /* class _m_j.sp.AnonymousClass2 */

                public final void onGpsStatusChanged(int i) {
                    if (i == 1) {
                        sp.O000000o(sp.this);
                    } else if (i == 2) {
                        sp.O00000Oo(sp.this);
                    } else if (i == 3) {
                        if (sp.this.O00000oO == null) {
                            sp spVar = sp.this;
                            spVar.O00000oO = spVar.O00000Oo.O000000o((GpsStatus) null);
                        } else {
                            sp.this.O00000Oo.O000000o(sp.this.O00000oO);
                        }
                        if (sp.this.O00000oO != null) {
                            sp spVar2 = sp.this;
                            sp.O000000o(spVar2, spVar2.O00000oO.getTimeToFirstFix());
                        }
                    } else if (i == 4) {
                        if (sp.this.O00000oO == null) {
                            sp spVar3 = sp.this;
                            spVar3.O00000oO = spVar3.O00000Oo.O000000o((GpsStatus) null);
                        } else {
                            sp.this.O00000Oo.O000000o(sp.this.O00000oO);
                        }
                        if (sp.this.O00000oO != null) {
                            sp spVar4 = sp.this;
                            Iterable<GpsSatellite> satellites = spVar4.O00000oO.getSatellites();
                            if (satellites != null) {
                                float f = 0.0f;
                                try {
                                    ArrayList arrayList = new ArrayList();
                                    int i2 = 0;
                                    int i3 = 0;
                                    for (GpsSatellite next : satellites) {
                                        if (next != null) {
                                            i3++;
                                            arrayList.add(new sg(next.usedInFix(), next.getPrn(), next.getSnr(), next.getElevation(), next.getAzimuth(), 0));
                                            if (next.usedInFix()) {
                                                i2++;
                                                f += next.getSnr();
                                            }
                                        }
                                    }
                                    if (i2 != 0) {
                                        f /= (float) i2;
                                    }
                                    spVar4.O000000o(i2, i3, f, arrayList);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            };
        }
    }

    private O000000o O00000Oo(sh shVar) {
        for (O000000o next : this.f2471O000000o) {
            if (next.O00000Oo == shVar) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i, int i2, float f, List<sg> list) {
        synchronized (this.f2471O000000o) {
            for (O000000o O000000o2 : this.f2471O000000o) {
                O000000o2.O000000o(4, new O00000o0(i, i2, f, list));
            }
        }
    }

    public final void O000000o(sh shVar) {
        if (shVar != null) {
            synchronized (this.f2471O000000o) {
                O000000o O00000Oo2 = O00000Oo(shVar);
                if (O00000Oo2 != null) {
                    boolean remove = this.f2471O000000o.remove(O00000Oo2);
                    if (this.f2471O000000o.size() == 0 && remove) {
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (this.O00000o0 != null) {
                                    this.O00000Oo.O00000Oo(this.O00000o0);
                                }
                            } else if (this.O00000o != null) {
                                this.O00000Oo.O00000Oo(this.O00000o);
                            }
                            this.O00000oo.unregisterReceiver(this.O0000O0o);
                        } catch (Exception e) {
                            om.O000000o("@_24_5_@", "@_24_5_2_@", e);
                        }
                    }
                }
            }
        }
    }

    class O00000Oo extends BroadcastReceiver {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(sp spVar, byte b) {
            this();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
         arg types: [java.lang.String, java.lang.String, java.lang.SecurityException]
         candidates:
          _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
          _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void */
        public final void onReceive(Context context, Intent intent) {
            if (se.O000000o(context).O000000o("gps")) {
                synchronized (sp.this.f2471O000000o) {
                    if (sp.this.f2471O000000o.size() > 0) {
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (sp.this.O00000o0 != null) {
                                    sp.this.O00000Oo.O00000Oo(sp.this.O00000o0);
                                    sp.this.O00000Oo.O000000o(sp.this.O00000o0);
                                }
                            } else if (sp.this.O00000o != null) {
                                sp.this.O00000Oo.O00000Oo(sp.this.O00000o);
                                sp.this.O00000Oo.O000000o(sp.this.O00000o);
                            }
                        } catch (SecurityException e) {
                            try {
                                om.O000000o("@_24_5_@", "卫星接口权限异常", (Exception) e);
                            } catch (SecurityException e2) {
                                om.O000000o("@_24_5_@", "卫星接口权限异常", (Exception) e2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
     arg types: [java.lang.String, java.lang.String, java.lang.SecurityException]
     candidates:
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
      _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        return r0;
     */
    public final boolean O000000o(sh shVar, Looper looper) {
        boolean z = false;
        if (shVar == null) {
            return false;
        }
        synchronized (this.f2471O000000o) {
            O000000o O00000Oo2 = O00000Oo(shVar);
            if (O00000Oo2 != null) {
                if (looper == null) {
                    looper = Looper.getMainLooper();
                }
                if (O00000Oo2.O00000Oo == shVar && O00000Oo2.f2474O000000o.getLooper() == looper) {
                    z = true;
                }
            } else {
                O000000o o000000o = new O000000o(shVar, looper);
                this.f2471O000000o.add(o000000o);
                if (this.f2471O000000o.size() != 1) {
                    return true;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (this.O00000o0 != null) {
                            z = this.O00000Oo.O000000o(this.O00000o0);
                        }
                    } else if (this.O00000o != null) {
                        z = this.O00000Oo.O000000o(this.O00000o);
                    }
                } catch (SecurityException e) {
                    om.O000000o("@_24_5_@", "卫星接口权限异常", (Exception) e);
                }
                if (!z) {
                    this.f2471O000000o.remove(o000000o);
                } else {
                    try {
                        this.O00000oo.registerReceiver(this.O0000O0o, new IntentFilter("android.location.PROVIDERS_CHANGED"));
                    } catch (Exception e2) {
                        om.O000000o("@_24_6_@", "@_24_6_1_@", e2);
                    }
                }
            }
        }
        return z;
    }

    static /* synthetic */ void O000000o(sp spVar) {
        synchronized (spVar.f2471O000000o) {
            for (O000000o O000000o2 : spVar.f2471O000000o) {
                O000000o2.O000000o(1, null);
            }
        }
    }

    static /* synthetic */ void O00000Oo(sp spVar) {
        synchronized (spVar.f2471O000000o) {
            for (O000000o O000000o2 : spVar.f2471O000000o) {
                O000000o2.O000000o(2, null);
            }
        }
    }

    static /* synthetic */ void O000000o(sp spVar, int i) {
        synchronized (spVar.f2471O000000o) {
            for (O000000o O000000o2 : spVar.f2471O000000o) {
                O000000o2.O000000o(3, Integer.valueOf(i));
            }
        }
    }
}
