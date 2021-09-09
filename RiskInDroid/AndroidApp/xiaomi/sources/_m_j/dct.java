package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.UnsupportedEncodingException;

public final class dct {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f14486O000000o = true;

    public static void O000000o() {
        f14486O000000o = true;
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!glc.O0000OOo) {
            return str;
        }
        try {
            return grs.O00000Oo(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void O00000Oo(String str) {
        if (f14486O000000o) {
            O0000O0o(str);
        }
    }

    public static void O00000o0(String str) {
        if (f14486O000000o) {
            O0000O0o(str);
        }
    }

    public static void O00000o(String str) {
        if (f14486O000000o) {
            O0000O0o(str);
        }
    }

    public static void O00000oO(String str) {
        if (f14486O000000o) {
            O0000O0o(str);
        }
    }

    public static void O00000oo(String str) {
        if (f14486O000000o) {
            O0000O0o(str);
        }
    }

    private static void O0000O0o(String str) {
        gsy.O00000Oo(LogType.MICONNECT, "MiConnect", str);
    }
}
