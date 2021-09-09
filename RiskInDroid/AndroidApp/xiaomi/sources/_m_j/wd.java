package _m_j;

import android.util.Log;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

public final class wd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f2570O000000o = "mijia.camera.v3";
    private static boolean O00000Oo = false;

    public static int O000000o(String str, String str2) {
        if (!O00000Oo) {
            return 0;
        }
        return Log.d("MiJiaCamera_".concat(String.valueOf(str)), str2);
    }

    public static int O00000Oo(String str, String str2) {
        if (!O00000Oo) {
            return 0;
        }
        return Log.i("MiJiaCamera_".concat(String.valueOf(str)), str2);
    }

    public static int O00000o0(String str, String str2) {
        return Log.e("MiJiaCamera_".concat(String.valueOf(str)), str2);
    }

    public static int O000000o(String str, String str2, Throwable th) {
        return Log.e("MiJiaCamera_".concat(String.valueOf(str)), str2, th);
    }

    public static void O000000o(String str) {
        f2570O000000o = str;
    }

    public static int O00000o(String str, String str2) {
        XmPluginHostApi instance = XmPluginHostApi.instance();
        String str3 = f2570O000000o;
        instance.logForModel(str3, str + ":" + str2);
        return Log.e("MiJiaCamera_".concat(String.valueOf(str)), str2, null);
    }
}
