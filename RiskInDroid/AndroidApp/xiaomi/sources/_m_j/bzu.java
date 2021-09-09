package _m_j;

import _m_j.cbm;
import android.text.TextUtils;
import java.io.File;
import java.util.regex.Pattern;

public final class bzu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13501O000000o;
    public static String O00000Oo = (f13501O000000o + '/' + cad.f13513O000000o + "_version.txt");

    public static void O000000o() {
        if (!TextUtils.isEmpty(f13501O000000o)) {
            long O000000o2 = cbm.O000000o.O000000o(new File(f13501O000000o));
            ccr.O00000Oo("webcache", "offline html5 cache size: " + O000000o2 + " byte");
            if (O000000o2 > 52428800) {
                cbm.O000000o.O00000Oo(new File(f13501O000000o));
            }
        }
    }

    public static void O00000Oo() {
        if (!TextUtils.isEmpty(f13501O000000o) && !new File(O00000Oo).exists()) {
            cbm.O000000o.O00000Oo(new File(f13501O000000o));
            cbm.O000000o.O000000o(byl.O00000oO().getAssets(), "webview", f13501O000000o);
        }
    }

    public static String[] O000000o(String str, boolean z) {
        if (TextUtils.isEmpty(f13501O000000o) || TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("/css");
        if (indexOf != -1) {
            return new String[]{"text/css", f13501O000000o + str.substring(indexOf, str.length()).replaceAll(Pattern.quote("?"), "_")};
        }
        int indexOf2 = str.indexOf("/js");
        if (indexOf2 != -1) {
            return new String[]{"text/javascript", f13501O000000o + str.substring(indexOf2, str.length()).replaceAll(Pattern.quote("?"), "_")};
        } else if (!z) {
            return null;
        } else {
            String[] split = str.split(cav.O00000oO());
            if (split.length != 2) {
                return null;
            }
            String str2 = split[1];
            int indexOf3 = str2.indexOf(63);
            if (indexOf3 != -1) {
                str2 = str2.substring(0, indexOf3);
            }
            if (str2.endsWith("/")) {
                str2 = str2.substring(0, str2.length() - 1) + ".html";
            }
            return new String[]{"text/html", f13501O000000o + "/" + str2};
        }
    }

    static {
        String str;
        File filesDir = byl.O00000oO().getFilesDir();
        if (filesDir == null) {
            str = "";
        } else {
            str = filesDir.getAbsolutePath() + '/' + "webview";
        }
        f13501O000000o = str;
    }
}
