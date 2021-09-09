package _m_j;

public final class jde {
    public static boolean O000000o(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean O000000o(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        boolean z = charSequence instanceof String;
        if (z && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int length = charSequence.length();
        if (z && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(false, 0, (String) charSequence2, 0, length);
        }
        int length2 = charSequence.length() - 0;
        int length3 = charSequence2.length() - 0;
        if (length >= 0 && length2 >= length && length3 >= length) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - 1;
                if (length <= 0) {
                    return true;
                }
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (charSequence.charAt(i) != charSequence2.charAt(i2)) {
                    return false;
                }
                i = i4;
                i2 = i5;
                length = i3;
            }
        }
        return false;
    }

    public static String O000000o(String str, String str2, String str3) {
        if (O000000o(str) || O000000o(str2) || str3 == null) {
            return str;
        }
        int i = 0;
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length2 * 16));
        int i2 = -1;
        while (indexOf != -1) {
            sb.append(str.substring(i, indexOf));
            sb.append(str3);
            i = indexOf + length;
            i2--;
            if (i2 == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i);
        }
        sb.append(str.substring(i));
        return sb.toString();
    }
}
