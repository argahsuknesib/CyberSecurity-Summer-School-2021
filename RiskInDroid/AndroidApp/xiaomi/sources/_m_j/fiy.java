package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.server.CoreService;

public final class fiy {
    private static volatile fiy O00000Oo;
    private static Object O00000o0 = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    Context f16429O000000o = CoreService.getAppContext();
    private boolean O00000o = false;

    public interface O000000o {
        void O000000o();
    }

    private fiy() {
    }

    public static fiy O000000o() {
        if (O00000Oo == null) {
            synchronized (O00000o0) {
                if (O00000Oo == null) {
                    O00000Oo = new fiy();
                }
            }
        }
        return O00000Oo;
    }

    public final synchronized boolean O00000Oo() {
        return this.O00000o;
    }

    public final synchronized void O00000o0() {
        this.O00000o = true;
    }

    public final void O000000o(final O000000o o000000o) {
        boolean O00000Oo2 = fju.O000000o().O00000Oo();
        boolean O00000o02 = fju.O000000o().O00000o0();
        boolean O00000Oo3 = O00000Oo();
        if (!O00000o02 || (O00000Oo2 && !O00000Oo3)) {
            IntentFilter intentFilter = new IntentFilter("CTAManager.onCTAReadyInternal");
            ft.O000000o(CoreService.getAppContext()).O000000o(new BroadcastReceiver() {
                /* class _m_j.fiy.AnonymousClass2 */

                public final void onReceive(Context context, Intent intent) {
                    ft.O000000o(CoreService.getAppContext()).O000000o(this);
                    O000000o o000000o = o000000o;
                    if (o000000o != null) {
                        o000000o.O000000o();
                    }
                }
            }, intentFilter);
            return;
        }
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.fiy.AnonymousClass1 */

            public final void run() {
                o000000o.O000000o();
            }
        });
    }
}
