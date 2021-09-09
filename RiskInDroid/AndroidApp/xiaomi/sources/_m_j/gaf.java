package _m_j;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xiaomi.smarthome.application.CommonApplication;

public final class gaf {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f17459O000000o;
    private static int O00000Oo;

    private static void O00000o(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        f17459O000000o = displayMetrics.widthPixels;
        O00000Oo = displayMetrics.heightPixels;
    }

    public static int O000000o(Context context) {
        if (context == null) {
            return -1;
        }
        if (f17459O000000o == 0) {
            O00000o(context);
        }
        return f17459O000000o;
    }

    public static int O00000Oo(Context context) {
        if (context == null) {
            return -1;
        }
        if (O00000Oo == 0) {
            O00000o(context);
        }
        return O00000Oo;
    }

    public static float O000000o() {
        if (hyy.O000000o()) {
            return hyy.O00000Oo().density;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) CommonApplication.getAppContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static int O00000o0(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 10.0f) + 0.5f);
    }
}
