package _m_j;

import java.util.Random;

public final class erb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f15737O000000o = "&quot;".toCharArray();
    private static final char[] O00000Oo = "&apos;".toCharArray();
    private static final char[] O00000o = "&lt;".toCharArray();
    private static final char[] O00000o0 = "&amp;".toCharArray();
    private static final char[] O00000oO = "&gt;".toCharArray();
    private static Random O00000oo = new Random();
    private static char[] O0000O0o = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String O000000o() {
        char[] cArr = new char[5];
        for (int i = 0; i < 5; i++) {
            cArr[i] = O0000O0o[O00000oo.nextInt(71)];
        }
        return new String(cArr);
    }

    public static String O000000o(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        double d = (double) length;
        Double.isNaN(d);
        StringBuilder sb = new StringBuilder((int) (d * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = charArray[i];
            if (c <= '>') {
                if (c == '<') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(O00000o);
                } else if (c == '>') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(O00000oO);
                } else if (c == '&') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    int i3 = i + 5;
                    if (length <= i3 || charArray[i + 1] != '#' || !Character.isDigit(charArray[i + 2]) || !Character.isDigit(charArray[i + 3]) || !Character.isDigit(charArray[i + 4]) || charArray[i3] != ';') {
                        i2 = i + 1;
                        sb.append(O00000o0);
                    }
                } else if (c == '\"') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(f15737O000000o);
                } else if (c == '\'') {
                    if (i > i2) {
                        sb.append(charArray, i2, i - i2);
                    }
                    i2 = i + 1;
                    sb.append(O00000Oo);
                }
            }
            i++;
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            sb.append(charArray, i2, i - i2);
        }
        return sb.toString();
    }

    private static String O000000o(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf);
        sb.append(charArray2);
        int i = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i);
            if (indexOf2 > 0) {
                sb.append(charArray, i, indexOf2 - i);
                sb.append(charArray2);
                i = indexOf2 + length;
            } else {
                sb.append(charArray, i, charArray.length - i);
                return sb.toString();
            }
        }
    }

    public static String O000000o(byte[] bArr) {
        return String.valueOf(emi.O000000o(bArr));
    }

    public static final String O00000Oo(String str) {
        return O000000o(O000000o(O000000o(O000000o(O000000o(str, "&lt;", "<"), "&gt;", ">"), "&quot;", jdn.f1779O000000o), "&apos;", "'"), "&amp;", "&");
    }
}
