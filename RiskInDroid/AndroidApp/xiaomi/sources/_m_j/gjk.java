package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.international.SelectServerActivity;

public final class gjk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static SharedPreferences f17848O000000o;

    public static void O000000o() {
        if (f17848O000000o == null) {
            f17848O000000o = gpy.O000000o(ServiceApplication.getAppContext(), "com.xiaomi.smarthome.serverconfig");
        }
    }

    public static void O000000o(Context context, int i, hsq hsq, String str) {
        final gpr gpr = new gpr(hsq);
        final ft O000000o2 = ft.O000000o(context);
        AnonymousClass1 r1 = new BroadcastReceiver() {
            /* class _m_j.gjk.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                O000000o2.O000000o(this);
                int intExtra = intent.getIntExtra("param_key", 0);
                hsq hsq = (hsq) gpr.f18128O000000o;
                gpr.f18128O000000o = null;
                if (intExtra == 1) {
                    if (hsq != null) {
                        hsq.O000000o();
                    }
                } else if (intExtra == 2 && hsq != null) {
                    hsq.O00000Oo();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("action_select_server_local_broadcast_complete");
        intentFilter.addAction("action_select_server_local_broadcast_complete_final");
        O000000o2.O000000o(r1, intentFilter);
        Intent intent = new Intent(context, SelectServerActivity.class);
        intent.putExtra(SelectServerActivity.DISPLAY_MODE, i);
        intent.putExtra("from_where", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void O000000o(boolean z) {
        O000000o();
        gpy.O000000o(f17848O000000o, "pref_key_ignore", z);
    }
}
