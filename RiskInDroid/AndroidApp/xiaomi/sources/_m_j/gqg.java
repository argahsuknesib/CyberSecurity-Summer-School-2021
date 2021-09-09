package _m_j;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;

public final class gqg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Toast f18148O000000o;

    public static void O000000o() {
        Toast toast = f18148O000000o;
        if (toast != null) {
            toast.cancel();
        }
    }

    public static void O000000o(int i) {
        if (ServiceApplication.getAppContext() != null) {
            O000000o(ServiceApplication.getAppContext(), ServiceApplication.getAppContext().getString(i), 0);
        }
    }

    public static void O000000o(CharSequence charSequence) {
        if (ServiceApplication.getAppContext() != null) {
            O000000o(ServiceApplication.getAppContext(), charSequence, 0);
        }
    }

    public static void O000000o(int i, int i2) {
        if (ServiceApplication.getAppContext() != null) {
            O000000o(ServiceApplication.getAppContext(), ServiceApplication.getAppContext().getString(i), i2);
        }
    }

    public static void O000000o(final Context context, final CharSequence charSequence, final int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            Toast toast = f18148O000000o;
            if (toast != null) {
                toast.cancel();
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                izb O000000o2 = izb.O000000o(context, charSequence, i);
                f18148O000000o = O000000o2;
                O000000o2.show();
                return;
            }
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.gqg.AnonymousClass1 */

                public final void run() {
                    izb O000000o2 = izb.O000000o(context, charSequence, i);
                    gqg.f18148O000000o = O000000o2;
                    O000000o2.show();
                }
            });
        }
    }

    public static void O00000Oo(CharSequence charSequence) {
        ServiceApplication.getAppContext();
        O000000o(charSequence);
    }

    public static void O00000Oo(int i) {
        ServiceApplication.getAppContext();
        O000000o(i);
    }

    public static void O000000o(CharSequence charSequence, int i) {
        O000000o(ServiceApplication.getAppContext(), charSequence, i);
    }

    public static void O00000Oo(int i, int i2) {
        ServiceApplication.getAppContext();
        O000000o(i, i2);
    }

    public static void O000000o(int[] iArr, int i) {
        String string = ServiceApplication.getAppContext().getString(i);
        if (ServiceApplication.getAppContext() != null) {
            Toast toast = f18148O000000o;
            if (toast != null) {
                toast.cancel();
            }
            Toast toast2 = new Toast(ServiceApplication.getAppContext());
            View inflate = LayoutInflater.from(ServiceApplication.getAppContext()).inflate((int) R.layout.toast_common, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.message);
            if (TextUtils.isEmpty(string)) {
                string = " ";
            }
            textView.setText(string);
            inflate.setAnimation(null);
            toast2.setView(inflate);
            toast2.setDuration(0);
            toast2.setGravity(53, iArr[0], iArr[1]);
            f18148O000000o = toast2;
            toast2.show();
        }
    }
}
