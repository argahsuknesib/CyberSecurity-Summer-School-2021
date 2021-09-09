package _m_j;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.xiaomi.smarthome.application.CommonApplication;

public final class ddb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Toast f14493O000000o;

    public static void O000000o(int i) {
        if (CommonApplication.getAppContext() != null) {
            O000000o(CommonApplication.getAppContext(), CommonApplication.getAppContext().getString(i));
        }
    }

    private static void O000000o(Context context, CharSequence charSequence) {
        Toast toast = f14493O000000o;
        if (toast != null) {
            toast.cancel();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            izb O000000o2 = izb.O000000o(context, charSequence, 0);
            f14493O000000o = O000000o2;
            O000000o2.show();
            return;
        }
        CommonApplication.getGlobalHandler().post(new Runnable(context, charSequence, 0) {
            /* class _m_j.ddb.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Context f14494O000000o;
            final /* synthetic */ CharSequence O00000Oo;
            final /* synthetic */ int O00000o0 = 0;

            {
                this.f14494O000000o = r1;
                this.O00000Oo = r2;
            }

            public final void run() {
                izb O000000o2 = izb.O000000o(this.f14494O000000o, this.O00000Oo, this.O00000o0);
                ddb.f14493O000000o = O000000o2;
                O000000o2.show();
            }
        });
    }

    public static void O000000o(CharSequence charSequence) {
        CommonApplication.getAppContext();
        if (CommonApplication.getAppContext() != null) {
            O000000o(CommonApplication.getAppContext(), charSequence);
        }
    }

    public static void O00000Oo(int i) {
        CommonApplication.getAppContext();
        O000000o(i);
    }
}
