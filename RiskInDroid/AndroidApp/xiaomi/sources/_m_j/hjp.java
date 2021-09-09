package _m_j;

import _m_j.fca;
import android.net.Uri;
import com.xiaomi.smarthome.library.log.LogType;

public final class hjp {
    public static boolean O000000o(String str) {
        O000000o(1, str, null, new boolean[0]);
        return true;
    }

    public static boolean O000000o(String str, String str2) {
        if (O00000Oo(str)) {
            O000000o(5, str, str2, new boolean[0]);
            return true;
        } else if (!O00000o0(str)) {
            return false;
        } else {
            O000000o(1, str, str2, new boolean[0]);
            return true;
        }
    }

    public static boolean O000000o(String str, String str2, boolean... zArr) {
        if (O000000o(str, str2)) {
            return true;
        }
        O000000o(4, str, str2, zArr);
        return true;
    }

    static void O000000o(int i, String str, String str2, boolean... zArr) {
        if ((i == 5 || i == 1) && !cmb.O000000o()) {
            gsy.O00000Oo(LogType.GENERAL, "ShopOrWebViewUrl", "sync init youpin failed.");
            cmb.O00000Oo();
        }
        fca.O000000o o000000o = new fca.O000000o();
        fca.O00000Oo o00000Oo = new fca.O00000Oo();
        o00000Oo.O00000o0 = str;
        o00000Oo.O00000Oo = str2;
        o00000Oo.f16071O000000o = i;
        if (zArr.length > 0) {
            o00000Oo.O0000o00 = zArr[0];
        }
        o000000o.O0000Oo = o00000Oo;
        fca.O000000o();
        fca.O00000o0(o000000o);
    }

    private static boolean O00000o0(String str) {
        if (cmc.O00000Oo()) {
            return true;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String path = parse.getPath();
            return host.equals("home.mi.com") && (path.startsWith("/shop/") || path.startsWith("/app/shop/"));
        } catch (Exception unused) {
        }
    }

    static boolean O00000Oo(String str) {
        try {
            Uri parse = Uri.parse(str);
            if (!"m.mi.com".equals(parse.getHost()) || !"/sdk".equals(parse.getPath())) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }
}
