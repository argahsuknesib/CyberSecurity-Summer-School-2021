package _m_j;

import android.util.Log;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

@Deprecated
public final class civ {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f13928O000000o = "mijia.camera.v3";

    public static int O000000o(String str, String str2) {
        if (!ckh.O00000o) {
            return 0;
        }
        return Log.d("MiJiaCamera_".concat(String.valueOf(str)), str2);
    }

    public static int O00000Oo(String str, String str2) {
        if (!ckh.O00000o) {
            return 0;
        }
        return Log.i("MiJiaCamera_".concat(String.valueOf(str)), str2);
    }

    public static int O00000o0(String str, String str2) {
        if (!ckh.O00000o) {
            return 0;
        }
        return Log.e("MiJiaCamera_".concat(String.valueOf(str)), str2);
    }

    public static int O00000o(String str, String str2) {
        return O000000o(str, str2, null);
    }

    public static int O000000o(String str, String str2, Throwable th) {
        XmPluginHostApi instance = XmPluginHostApi.instance();
        String str3 = f13928O000000o;
        instance.logForModel(str3, str + ":" + str2);
        return Log.e("MiJiaCamera_".concat(String.valueOf(str)), str2, th);
    }

    public static void O000000o(String str) {
        f13928O000000o = str;
    }
}
