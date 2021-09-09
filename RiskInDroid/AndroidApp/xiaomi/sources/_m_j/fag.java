package _m_j;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.lang.ref.WeakReference;

public final class fag {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Handler f15996O000000o = new Handler(Looper.getMainLooper());
    public static WeakReference<Toast> O00000Oo = null;
    public static Object O00000o0 = new Object();

    private static void O000000o(final Context context, final String str, final int i) {
        if (context != null && !TextUtils.isEmpty(str)) {
            new Thread(new Runnable() {
                /* class _m_j.fag.AnonymousClass1 */

                public final void run() {
                    fag.f15996O000000o.post(new Runnable() {
                        /* class _m_j.fag.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            Toast toast;
                            synchronized (fag.O00000o0) {
                                if (!TextUtils.isEmpty(str)) {
                                    if (fag.O00000Oo != null) {
                                        if (fag.O00000Oo.get() != null) {
                                            toast = fag.O00000Oo.get();
                                            if (toast != null) {
                                                toast.setText(str);
                                                toast.setDuration(i);
                                            } else {
                                                toast = izb.O000000o(context, str, i);
                                                fag.O00000Oo = new WeakReference<>(toast);
                                            }
                                            toast.show();
                                        }
                                    }
                                    toast = izb.O000000o(context, str, i);
                                    fag.O00000Oo = new WeakReference<>(toast);
                                    toast.show();
                                }
                            }
                        }
                    });
                }
            }).start();
        }
    }

    public static void O000000o(Context context, int i, int i2) {
        if (context != null && i != 0) {
            O000000o(context, context.getString(i), i2);
        }
    }

    public static void O000000o(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            O000000o(context, str, 1);
        }
    }
}
