package _m_j;

import android.text.TextUtils;
import java.io.File;

public final class gad {
    private static String O00000o0(String str) {
        if (gae.O00000Oo(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(O00000o0(str))) {
            return false;
        }
        File file = new File(str);
        if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
            return false;
        }
        return true;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }
}
