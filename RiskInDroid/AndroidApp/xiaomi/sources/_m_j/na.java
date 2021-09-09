package _m_j;

public final class na {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean[] f2191O000000o = new boolean[256];
    private static boolean[] O00000Oo = new boolean[256];

    public static String O000000o(String str) {
        if ("x-default".equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt == '-' || charAt == '_') {
                    stringBuffer.append('-');
                    i++;
                } else {
                    stringBuffer.append(i != 2 ? Character.toLowerCase(str.charAt(i2)) : Character.toUpperCase(str.charAt(i2)));
                }
            }
        }
        return stringBuffer.toString();
    }

    static boolean O000000o(char c) {
        return ((c > 31 && c != 127) || c == 9 || c == 10 || c == 13) ? false : true;
    }

    private static boolean O00000Oo(char c) {
        if (c <= 255 && f2191O000000o[c]) {
            return true;
        }
        if (c >= 256 && c <= 767) {
            return true;
        }
        if (c >= 880 && c <= 893) {
            return true;
        }
        if (c >= 895 && c <= 8191) {
            return true;
        }
        if (c >= 8204 && c <= 8205) {
            return true;
        }
        if (c >= 8304 && c <= 8591) {
            return true;
        }
        if (c >= 11264 && c <= 12271) {
            return true;
        }
        if (c >= 12289 && c <= 55295) {
            return true;
        }
        if (c >= 63744 && c <= 64975) {
            return true;
        }
        if (c < 65008 || c > 65533) {
            return c >= 0 && c <= 65535;
        }
        return true;
    }

    static String[] O00000Oo(String str) {
        int indexOf = str.indexOf(61);
        String substring = str.substring(str.charAt(1) == '?' ? 2 : 1, indexOf);
        int i = indexOf + 1;
        char charAt = str.charAt(i);
        int i2 = i + 1;
        int length = str.length() - 2;
        StringBuffer stringBuffer = new StringBuffer(length - indexOf);
        while (i2 < length) {
            stringBuffer.append(str.charAt(i2));
            i2++;
            if (str.charAt(i2) == charAt) {
                i2++;
            }
        }
        return new String[]{substring, stringBuffer.toString()};
    }

    public static boolean O00000o(String str) {
        if (str.length() > 0 && !O00000Oo(str.charAt(0))) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!O00000o0(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean O00000o0(char c) {
        if ((c <= 255 && O00000Oo[c]) || O00000Oo(c)) {
            return true;
        }
        if (c < 768 || c > 879) {
            return c >= 8255 && c <= 8256;
        }
        return true;
    }

    static boolean O00000o0(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        boolean z = true;
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '-') {
                i2++;
                z = z && (i == 8 || i == 13 || i == 18 || i == 23);
            }
            i++;
        }
        return z && 4 == i2 && 36 == i;
    }

    public static boolean O00000oO(String str) {
        if (str.length() > 0 && (!O00000Oo(str.charAt(0)) || str.charAt(0) == ':')) {
            return false;
        }
        for (int i = 1; i < str.length(); i++) {
            if (!O00000o0(str.charAt(i)) || str.charAt(i) == ':') {
                return false;
            }
        }
        return true;
    }

    static {
        char c = 0;
        while (c < O00000Oo.length) {
            boolean z = true;
            f2191O000000o[c] = c == ':' || ('A' <= c && c <= 'Z') || c == '_' || (('a' <= c && c <= 'z') || ((192 <= c && c <= 214) || ((216 <= c && c <= 246) || (248 <= c && c <= 255))));
            boolean[] zArr = O00000Oo;
            if (!f2191O000000o[c] && c != '-' && c != '.' && (('0' > c || c > '9') && c != 183)) {
                z = false;
            }
            zArr[c] = z;
            c = (char) (c + 1);
        }
    }
}
