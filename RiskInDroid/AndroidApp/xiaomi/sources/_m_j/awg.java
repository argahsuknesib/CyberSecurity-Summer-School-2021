package _m_j;

import android.text.TextUtils;

public final class awg {
    public static boolean O000000o() {
        return !TextUtils.isEmpty(O000000o("ro.miui.ui.version.name", ""));
    }

    public static boolean O00000o0() {
        return !TextUtils.isEmpty(O000000o("ro.build.version.emui", ""));
    }

    private static String O00000oo() {
        return O00000o0() ? O000000o("ro.build.version.emui", "") : "";
    }

    private static boolean O0000O0o() {
        String O00000oo = O00000oo();
        return "EmotionUI 3".equals(O00000oo) || O00000oo.contains("EmotionUI_3.1");
    }

    private static boolean O0000OOo() {
        return O00000oo().contains("EmotionUI_3.0");
    }

    public static boolean O00000o() {
        return O0000OOo() || O0000O0o();
    }

    private static String O000000o(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static boolean O00000Oo() {
        String str = "";
        if (O000000o()) {
            str = O000000o("ro.miui.ui.version.name", str);
        }
        if (!str.isEmpty()) {
            try {
                if (Integer.valueOf(str.substring(1)).intValue() >= 6) {
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public static boolean O00000oO() {
        int i;
        String str = "";
        if (O000000o("ro.build.display.id", str).toLowerCase().contains("flyme")) {
            str = O000000o("ro.build.display.id", str);
        }
        if (!str.isEmpty()) {
            try {
                if (str.toLowerCase().contains("os")) {
                    i = Integer.valueOf(str.substring(9, 10)).intValue();
                } else {
                    i = Integer.valueOf(str.substring(6, 7)).intValue();
                }
                if (i >= 4) {
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }
}
