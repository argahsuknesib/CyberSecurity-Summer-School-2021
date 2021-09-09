package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;

public final class hsk {
    public static String O000000o(Context context) {
        return O000000o(context, "api.io.mi.com", "api.io.mi.com");
    }

    public static String O00000Oo(Context context) {
        return O000000o(context, "home.mi.com", "");
    }

    public static String O000000o(Context context, String str, String str2) {
        ServerBean O000000o2 = ftn.O000000o(context);
        String O00000o0 = O00000o0(context);
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
            O00000o0 = "release";
        }
        if (O000000o2 == null || ftn.O00000o0(O000000o2)) {
            if (TextUtils.isEmpty(O00000o0) || O00000o0.equalsIgnoreCase("release") || !O00000o0.equalsIgnoreCase("preview")) {
                return "https://".concat(String.valueOf(str));
            }
            return "https://pv.".concat(String.valueOf(str2));
        } else if (!TextUtils.isEmpty(O00000o0) && !O00000o0.equalsIgnoreCase("release") && O00000o0.equalsIgnoreCase("preview")) {
            return "https://pv-" + O000000o2.f7546O000000o + "." + str2;
        } else if (!TextUtils.equals("st", O000000o2.f7546O000000o.toLowerCase()) || (!str.startsWith("home.mi.com") && !str.startsWith("mi.com"))) {
            return "https://" + O000000o2.f7546O000000o + "." + str;
        } else {
            return "http://" + O000000o2.f7546O000000o + ".iot." + str;
        }
    }

    private static String O00000o0(Context context) {
        if (fdc.O000000o().O0000Ooo()) {
            return fdc.O000000o().O0000o00();
        }
        if (context != null) {
            return context.getSharedPreferences("com.xiaomi.smarthome.globaldynamicsetting", 0).getString("server_env", "release");
        }
        return "release";
    }
}
