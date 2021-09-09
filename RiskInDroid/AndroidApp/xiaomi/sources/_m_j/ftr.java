package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.login.MijiaLoginManager;
import com.xiaomi.smarthome.library.log.LogType;

public final class ftr extends gtz {
    public final void O000000o() {
        ServiceApplication.getStateNotifier().O000000o(9);
    }

    public final void O000000o(final int i) {
        if (gfr.O0000Ooo) {
            gsy.O00000Oo(LogType.LOGIN, "login", "LoginHostApiImpl onLoginSuccess ".concat(String.valueOf(i)));
        }
        if (i != 1) {
            MijiaLoginManager.O000000o().O000000o(i);
        } else {
            goq.O000000o(new Runnable() {
                /* class _m_j.ftr.AnonymousClass1 */

                public final void run() {
                    MijiaLoginManager.O000000o().O000000o(i);
                }
            });
        }
    }

    public final void O00000Oo() {
        ServiceApplication.getStateNotifier().O00000oo();
        ezo.O000000o().clearRegedPushIDAndDeviceID();
    }

    public final void O000000o(String str) {
        if (ftm.O000000o(ServiceApplication.getAppContext())) {
            gsy.O00000o0(LogType.LOGIN, "", str);
        }
    }

    public final void O000000o(Context context) {
        if (context != null) {
            fbt fbt = new fbt(context, "SmartHomeMainActivity");
            fbt.O00000Oo(268435456);
            fbs.O000000o(fbt);
        }
    }
}
