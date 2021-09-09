package _m_j;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

public class hiz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hiz f18970O000000o;
    private Context O00000Oo;
    private BroadcastReceiver O00000o0 = new BroadcastReceiver() {
        /* class _m_j.hiz.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "action_on_logout")) {
                hiz.this.O000000o();
            }
        }
    };

    private hiz(Context context) {
        this.O00000Oo = context.getApplicationContext();
    }

    public static hiz O000000o(Context context) {
        if (f18970O000000o == null) {
            synchronized (hiz.class) {
                if (f18970O000000o == null) {
                    f18970O000000o = new hiz(context);
                }
            }
        }
        return f18970O000000o;
    }

    public final void O000000o() {
        ((NotificationManager) this.O00000Oo.getSystemService("notification")).cancelAll();
    }
}
