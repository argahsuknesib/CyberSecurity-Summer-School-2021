package _m_j;

public abstract class avt {
    public static void O000000o(Object obj, String str) {
        O000000o(obj != null, str);
    }

    public static void O000000o(String str, String str2) {
        O000000o(O000000o(str), str2);
    }

    private static boolean O000000o(String str) {
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void O000000o(boolean z, String str) {
        if (!z) {
            if (!O000000o(str)) {
                str = "Received an invalid parameter";
            }
            throw new IllegalArgumentException(str);
        }
    }
}
