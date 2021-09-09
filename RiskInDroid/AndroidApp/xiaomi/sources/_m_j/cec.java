package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public final class cec {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Handler f13681O000000o = new Handler(Looper.getMainLooper());

    public static void O000000o(Context context, int i, int i2) {
        try {
            O000000o(context, context.getText(i), i2);
        } catch (Exception unused) {
        }
    }

    public static void O000000o(final Context context, final CharSequence charSequence, final int i) {
        try {
            if (O000000o()) {
                O00000Oo(context, charSequence, i);
            } else {
                f13681O000000o.post(new Runnable() {
                    /* class _m_j.cec.AnonymousClass1 */

                    public final void run() {
                        cec.O00000Oo(context, charSequence, i);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public static void O00000Oo(Context context, CharSequence charSequence, int i) {
        try {
            izb.O000000o(context.getApplicationContext(), charSequence, i).show();
        } catch (Throwable unused) {
        }
    }

    private static boolean O000000o() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
