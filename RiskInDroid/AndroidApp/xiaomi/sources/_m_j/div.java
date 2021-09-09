package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;

public final class div {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14701O000000o;
    private static String O00000Oo;

    public static String O000000o() {
        return "";
    }

    public static String O00000o() {
        return "";
    }

    public static String O00000o0() {
        return "";
    }

    public static String O00000oO() {
        return "";
    }

    public static String O000000o(Context context) {
        if (!TextUtils.isEmpty(f14701O000000o)) {
            return f14701O000000o;
        }
        if (context == null) {
            return "";
        }
        f14701O000000o = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            f14701O000000o = width + "x" + height;
        }
        return f14701O000000o;
    }

    public static String O00000Oo() {
        return Locale.getDefault().getLanguage();
    }

    public static String O00000Oo(Context context) {
        try {
            if (O00000Oo == null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                StringBuilder sb = new StringBuilder();
                sb.append("imei=&");
                sb.append("model=");
                sb.append(Build.MODEL);
                sb.append('&');
                sb.append("os=");
                sb.append(Build.VERSION.RELEASE);
                sb.append('&');
                sb.append("apilevel=");
                sb.append(Build.VERSION.SDK_INT);
                sb.append('&');
                String O000000o2 = diu.O000000o();
                sb.append("network=");
                sb.append(O000000o2);
                sb.append('&');
                sb.append("sdcard=");
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append('&');
                sb.append("display=");
                sb.append(displayMetrics.widthPixels);
                sb.append('*');
                sb.append(displayMetrics.heightPixels);
                sb.append('&');
                sb.append("manu=");
                sb.append(Build.MANUFACTURER);
                sb.append("&");
                sb.append("wifi=");
                sb.append(diu.O00000Oo(context));
                O00000Oo = sb.toString();
            }
            return O00000Oo;
        } catch (Exception unused) {
            return null;
        }
    }
}
