package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public final class hte {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Toast f616O000000o;

    public static void O000000o(Context context, int i) {
        O000000o(context, context.getString(i), 0);
    }

    public static void O000000o(Context context, CharSequence charSequence) {
        O000000o(context, charSequence, 0);
    }

    public static void O00000Oo(Context context, int i) {
        O000000o(context, context.getString(i), 0);
    }

    public static void O000000o(Context context, CharSequence charSequence, int i) {
        if (TextUtils.isEmpty(charSequence)) {
            gsy.O000000o(6, "ToastUtil", Log.getStackTraceString(new Exception()));
            return;
        }
        Toast toast = f616O000000o;
        if (toast != null) {
            toast.cancel();
        }
        izb O000000o2 = izb.O000000o(context, charSequence, i);
        f616O000000o = O000000o2;
        O000000o2.show();
    }

    public static void O000000o(Context context, CharSequence charSequence, Handler handler) {
        if (handler == null || Looper.myLooper() == Looper.getMainLooper()) {
            O000000o(context, charSequence, 1);
        } else {
            handler.post(new Runnable(context, charSequence, 1) {
                /* class _m_j.hte.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Context f617O000000o;
                final /* synthetic */ CharSequence O00000Oo;
                final /* synthetic */ int O00000o0 = 1;

                {
                    this.f617O000000o = r1;
                    this.O00000Oo = r2;
                }

                public final void run() {
                    hte.O000000o(this.f617O000000o, this.O00000Oo, this.O00000o0);
                }
            });
        }
    }

    public static void O000000o(Context context, View view, float[] fArr) {
        Toast toast = f616O000000o;
        if (toast != null) {
            toast.cancel();
        }
        Toast toast2 = new Toast(context);
        toast2.setView(view);
        toast2.setGravity(55, 0, 0);
        toast2.setDuration(1);
        toast2.setMargin(fArr[0], fArr[1]);
        f616O000000o = toast2;
        toast2.show();
    }
}
