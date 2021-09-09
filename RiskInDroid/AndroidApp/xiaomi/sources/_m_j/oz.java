package _m_j;

import android.text.TextUtils;
import javax.crypto.spec.IvParameterSpec;

public final class oz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f2378O000000o = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
    static char[] O00000Oo = new char[66];
    public static final IvParameterSpec O00000o = new IvParameterSpec(f2378O000000o);
    static char[] O00000o0 = new char[66];

    static {
        "9O7M5 K3I1G:ZiXgVedcRQEu.CsrzyxwklP8N6L4J2H0jYhWfUTS,bavDtBAqponmF".getChars(0, 66, O00000Oo, 0);
        "F0n2p4A6t8v1b3T5M7hY lEwRczrsC:ZijmHoJqLB,NDGaISK.UfWO9ukQxydeVgXP".getChars(0, 66, O00000o0, 0);
    }

    private static int O000000o(char[] cArr, char c) {
        for (int i = 0; i < cArr.length; i++) {
            if (c == cArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int O000000o2 = O000000o(O00000Oo, charAt);
            if (O000000o2 >= 0) {
                charAt = O00000o0[O000000o2];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int O000000o2 = O000000o(O00000o0, charAt);
            if (O000000o2 >= 0) {
                charAt = O00000Oo[O000000o2];
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
