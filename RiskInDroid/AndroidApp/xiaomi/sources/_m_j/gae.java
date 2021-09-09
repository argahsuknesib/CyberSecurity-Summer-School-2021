package _m_j;

import java.util.regex.Pattern;

public final class gae {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f17458O000000o = "\\S*[0-9]+\\S*";
    public static String O00000Oo = "\\S*[a-zA-Z]+\\S*";
    public static String[] O00000o = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    public static String O00000o0 = "\\S*[\\]\\[\\-&+*/',.:;|\"`~@%$#_<>{}=?!^()\\\\]+\\S*";
    public static String[] O00000oO = {"十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static boolean O000000o(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean O00000Oo(String str) {
        return str == null || "".equals(str.trim()) || str.length() <= 0;
    }
}
