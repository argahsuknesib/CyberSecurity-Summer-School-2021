package _m_j;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Stack;

public final class eya {
    private static eya O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15942O000000o = false;
    private O000000o O00000o = new O000000o();
    private Stack<Activity> O00000o0 = new Stack<>();

    public static eya O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new eya();
        }
        return O00000Oo;
    }

    class O000000o extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f15943O000000o = "reason";
        final String O00000Oo = "globalactions";
        final String O00000o = "homekey";
        final String O00000o0 = "recentapps";

        O000000o() {
        }

        public final void onReceive(Context context, Intent intent) {
            String stringExtra;
            String action = intent.getAction();
            if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null) {
                gsy.O000000o(6, "HomeKeyManager", "action:" + action + ",reason:" + stringExtra);
                if (!stringExtra.equals("homekey")) {
                    stringExtra.equals("recentapps");
                } else if (eya.this.f15942O000000o) {
                    try {
                        eya.this.O00000o0();
                        eya.this.f15942O000000o = false;
                        eya.this.O00000Oo();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        eya.this.f15942O000000o = false;
                        throw th;
                    }
                    eya.this.f15942O000000o = false;
                }
            }
        }
    }

    private eya() {
        if (CommonApplication.getAppContext() != null) {
            CommonApplication.getAppContext().registerReceiver(this.O00000o, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    public final void O000000o(boolean z) {
        this.f15942O000000o = z;
    }

    public final void O00000Oo() {
        if (O00000Oo != null) {
            O00000Oo = null;
            try {
                if (this.O00000o != null && CommonApplication.getAppContext() != null) {
                    CommonApplication.getAppContext().unregisterReceiver(this.O00000o);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(Activity activity) {
        if (this.O00000o0 == null) {
            this.O00000o0 = new Stack<>();
        }
        this.O00000o0.add(activity);
    }

    public final void O00000Oo(Activity activity) {
        if (activity != null) {
            this.O00000o0.remove(activity);
        }
    }

    public final void O00000o0() {
        while (true) {
            Activity lastElement = this.O00000o0.size() > 0 ? this.O00000o0.lastElement() : null;
            if (lastElement != null) {
                gsy.O00000Oo("HomeKeyManager", "popAllActivity  :" + lastElement.getClass().getSimpleName());
                if (lastElement != null) {
                    lastElement.finish();
                    this.O00000o0.remove(lastElement);
                }
            } else {
                return;
            }
        }
    }
}
