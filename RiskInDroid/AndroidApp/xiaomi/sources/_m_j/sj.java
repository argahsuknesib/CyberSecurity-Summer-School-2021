package _m_j;

import android.location.Location;
import android.location.LocationListener;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class sj {

    /* renamed from: O000000o  reason: collision with root package name */
    LocationListener f2457O000000o;
    long O00000Oo;
    Handler O00000o;
    float O00000o0;
    long O00000oO;

    public sj(LocationListener locationListener, long j, float f, Looper looper) {
        this.f2457O000000o = locationListener;
        this.O00000Oo = j;
        this.O00000o0 = f;
        this.O00000o = new Handler(looper == null ? Looper.getMainLooper() : looper) {
            /* class _m_j.sj.AnonymousClass1 */

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    sj.this.f2457O000000o.onLocationChanged(new Location((Location) message.obj));
                } else if (i == 2) {
                    sj.this.f2457O000000o.onStatusChanged((String) message.obj, message.arg1, message.getData());
                } else if (i == 3) {
                    sj.this.f2457O000000o.onProviderEnabled((String) message.obj);
                } else if (i == 4) {
                    sj.this.f2457O000000o.onProviderDisabled((String) message.obj);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str, boolean z) {
        this.O00000o.obtainMessage(z ? 3 : 4, str).sendToTarget();
    }
}
