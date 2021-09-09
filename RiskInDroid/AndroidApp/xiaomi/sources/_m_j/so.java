package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.GpsStatus;
import android.os.Handler;
import android.os.Message;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class so implements GpsStatus.Listener {
    /* access modifiers changed from: private */

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<O00000Oo> f2468O000000o = new CopyOnWriteArrayList();
    /* access modifiers changed from: private */
    public sl O00000Oo;
    private O000000o O00000o = new O000000o(this);
    private Context O00000o0;

    class O000000o extends BroadcastReceiver {
        private GpsStatus.Listener O00000Oo;

        public O000000o(GpsStatus.Listener listener) {
            this.O00000Oo = listener;
        }

        public final void onReceive(Context context, Intent intent) {
            if (se.O000000o(context).O000000o("gps")) {
                synchronized (so.this.f2468O000000o) {
                    if (so.this.f2468O000000o.size() > 0) {
                        so.this.O00000Oo.O00000Oo(this.O00000Oo);
                        so.this.O00000Oo.O000000o(this.O00000Oo);
                    }
                }
            }
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        Handler f2470O000000o;
    }

    public so(sl slVar, Context context) {
        this.O00000Oo = slVar;
        this.O00000o0 = context;
    }

    public final void onGpsStatusChanged(int i) {
        synchronized (this.f2468O000000o) {
            for (O00000Oo o00000Oo : this.f2468O000000o) {
                Message obtainMessage = o00000Oo.f2470O000000o.obtainMessage();
                obtainMessage.arg1 = i;
                obtainMessage.sendToTarget();
            }
        }
    }
}
