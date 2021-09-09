package _m_j;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;

public final class gbz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Toast f17508O000000o;

    public static void O000000o(Context context, CharSequence charSequence) {
        if (context != null || (context = CommonApplication.getAppContext()) != null) {
            O000000o(context, charSequence, 0);
        }
    }

    private static void O000000o(final Context context, final CharSequence charSequence, final int i) {
        Toast toast = f17508O000000o;
        if (toast != null) {
            toast.cancel();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Toast makeText = Toast.makeText(context, charSequence, i);
            f17508O000000o = makeText;
            makeText.show();
            return;
        }
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.gbz.AnonymousClass1 */

            public final void run() {
                Toast makeText = Toast.makeText(context, charSequence, i);
                gbz.f17508O000000o = makeText;
                makeText.show();
            }
        });
    }

    public static void O000000o(CharSequence charSequence) {
        O000000o(CommonApplication.getAppContext(), charSequence);
    }

    public static void O000000o() {
        Context appContext = CommonApplication.getAppContext();
        if (appContext != null || (appContext = CommonApplication.getAppContext()) != null) {
            O000000o(appContext, appContext.getString(R.string.action_fail), 0);
        }
    }

    public static void O00000Oo(CharSequence charSequence) {
        O000000o(CommonApplication.getAppContext(), charSequence, 1);
    }
}
