package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class si {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f2454O000000o;
    O000000o O00000Oo;

    public si(sl slVar, Context context) {
        this.f2454O000000o = new O000000o("gps", slVar, context);
        this.O00000Oo = new O000000o("passive", slVar, context);
    }

    static class O000000o implements LocationListener {

        /* renamed from: O000000o  reason: collision with root package name */
        Context f2455O000000o;
        C0009O000000o O00000Oo = new C0009O000000o(this);
        /* access modifiers changed from: private */
        public sl O00000o;
        /* access modifiers changed from: package-private */
        public final List<sj> O00000o0 = new ArrayList();
        /* access modifiers changed from: private */
        public String O00000oO;
        /* access modifiers changed from: private */
        public long O00000oo = Long.MAX_VALUE;
        /* access modifiers changed from: private */
        public float O0000O0o = Float.MAX_VALUE;
        private Location O0000OOo;

        /* renamed from: _m_j.si$O000000o$O000000o  reason: collision with other inner class name */
        class C0009O000000o extends BroadcastReceiver {
            private LocationListener O00000Oo;

            public C0009O000000o(LocationListener locationListener) {
                this.O00000Oo = locationListener;
            }

            public final void onReceive(Context context, Intent intent) {
                if (se.O000000o(context).O000000o("gps")) {
                    synchronized (O000000o.this.O00000o0) {
                        if (O000000o.this.O00000o0.size() > 0) {
                            O000000o.this.O00000o.O000000o(this.O00000Oo);
                            O000000o.this.O00000o.O000000o(O000000o.this.O00000oO, O000000o.this.O00000oo, O000000o.this.O0000O0o, this.O00000Oo, Looper.getMainLooper());
                        }
                    }
                }
            }
        }

        O000000o(String str, sl slVar, Context context) {
            this.O00000o = slVar;
            this.O00000oO = str;
            this.f2455O000000o = context;
        }

        /* access modifiers changed from: package-private */
        public void O000000o() {
            float f = Float.MAX_VALUE;
            long j = Long.MAX_VALUE;
            if (this.O00000o0.isEmpty()) {
                this.O00000o.O000000o(this);
                this.O0000OOo = null;
                this.O00000oo = Long.MAX_VALUE;
                this.O0000O0o = Float.MAX_VALUE;
                return;
            }
            for (sj next : this.O00000o0) {
                j = Math.min(j, next.O00000Oo);
                f = Math.min(f, next.O00000o0);
            }
            if (this.O00000oo != j || this.O0000O0o != f) {
                this.O00000oo = j;
                this.O0000O0o = f;
                this.O00000o.O000000o(this);
                this.O00000o.O000000o(this.O00000oO, this.O00000oo, this.O0000O0o, this, Looper.getMainLooper());
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|4|(2:5|(2:7|(2:21|9))(1:22))|10|(2:13|14)|15|16) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
        public final void O000000o(LocationListener locationListener) {
            synchronized (this.O00000o0) {
                boolean z = false;
                Iterator<sj> it = this.O00000o0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    sj next = it.next();
                    if (next.f2457O000000o == locationListener) {
                        this.O00000o0.remove(next);
                        O000000o();
                        z = true;
                        break;
                    }
                }
                if (this.O00000o0.size() == 0 && z) {
                    this.f2455O000000o.unregisterReceiver(this.O00000Oo);
                }
            }
        }

        public final void onProviderDisabled(String str) {
            synchronized (this.O00000o0) {
                for (sj O000000o2 : this.O00000o0) {
                    O000000o2.O000000o(str, false);
                }
            }
        }

        public final void onProviderEnabled(String str) {
            synchronized (this.O00000o0) {
                for (sj O000000o2 : this.O00000o0) {
                    O000000o2.O000000o(str, true);
                }
            }
        }

        public final void onLocationChanged(Location location) {
            if (location != null) {
                Location location2 = this.O0000OOo;
                float abs = location2 == null ? Float.MAX_VALUE : Math.abs(location.distanceTo(location2));
                synchronized (this.O00000o0) {
                    for (sj next : this.O00000o0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (abs > next.O00000o0 || elapsedRealtime - next.O00000oO > next.O00000Oo) {
                            next.O00000oO = elapsedRealtime;
                            next.O00000o.obtainMessage(1, location).sendToTarget();
                        }
                    }
                }
                this.O0000OOo = location;
            }
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
            synchronized (this.O00000o0) {
                for (sj sjVar : this.O00000o0) {
                    Message obtainMessage = sjVar.O00000o.obtainMessage(2, str);
                    obtainMessage.arg1 = i;
                    obtainMessage.sendToTarget();
                }
            }
        }
    }
}
