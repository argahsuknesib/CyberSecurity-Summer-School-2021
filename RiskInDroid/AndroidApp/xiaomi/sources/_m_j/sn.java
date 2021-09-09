package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.GnssStatus;
import android.os.Handler;
import android.os.Message;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class sn extends GnssStatus.Callback {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<O000000o> f2465O000000o = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public sl O00000Oo;
    private O00000Oo O00000o = new O00000Oo(this);
    private Context O00000o0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private Handler f2466O000000o;

        /* access modifiers changed from: package-private */
        public final void O000000o(int i, Object obj) {
            Message obtainMessage = this.f2466O000000o.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = obj;
            obtainMessage.sendToTarget();
        }
    }

    class O00000Oo extends BroadcastReceiver {
        private GnssStatus.Callback O00000Oo;

        public O00000Oo(GnssStatus.Callback callback) {
            this.O00000Oo = callback;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void
         arg types: [java.lang.String, java.lang.String, java.lang.SecurityException]
         candidates:
          _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Throwable):void
          _m_j.om.O000000o(java.lang.String, java.lang.String, java.lang.Exception):void */
        public final void onReceive(Context context, Intent intent) {
            if (se.O000000o(context).O000000o("gps")) {
                synchronized (sn.this.f2465O000000o) {
                    if (sn.this.f2465O000000o.size() > 0) {
                        try {
                            sn.this.O00000Oo.O00000Oo(this.O00000Oo);
                            sn.this.O00000Oo.O000000o(this.O00000Oo);
                        } catch (SecurityException e) {
                            om.O000000o("@_24_5_@", "卫星老接口权限异常", (Exception) e);
                        }
                    }
                }
            }
        }
    }

    public sn(sl slVar, Context context) {
        this.O00000Oo = slVar;
        this.O00000o0 = context;
    }

    public final void onFirstFix(int i) {
        synchronized (this.f2465O000000o) {
            for (O000000o O000000o2 : this.f2465O000000o) {
                O000000o2.O000000o(3, Integer.valueOf(i));
            }
        }
    }

    public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        synchronized (this.f2465O000000o) {
            for (O000000o O000000o2 : this.f2465O000000o) {
                O000000o2.O000000o(4, gnssStatus);
            }
        }
    }

    public final void onStarted() {
        synchronized (this.f2465O000000o) {
            for (O000000o O000000o2 : this.f2465O000000o) {
                O000000o2.O000000o(1, null);
            }
        }
    }

    public final void onStopped() {
        synchronized (this.f2465O000000o) {
            for (O000000o O000000o2 : this.f2465O000000o) {
                O000000o2.O000000o(2, null);
            }
        }
    }
}
