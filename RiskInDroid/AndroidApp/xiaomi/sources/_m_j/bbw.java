package _m_j;

import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class bbw {
    static boolean O000000o(char c) {
        return c == ' ' || c == 9 || c == 13 || c == 10;
    }

    public static int O000000o(String str, String str2) throws ParseException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw ParseException.O000000o(ParseExceptionType.NOT_JAVA_INTEGER, str2, str);
        }
    }

    public static <T extends Enum<T>> T O000000o(String str, Class cls, String str2) throws ParseException {
        try {
            return Enum.valueOf(cls, str);
        } catch (IllegalArgumentException unused) {
            throw ParseException.O000000o(ParseExceptionType.NOT_JAVA_ENUM, str2, str);
        }
    }

    public static float O00000Oo(String str, String str2) throws ParseException {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            throw ParseException.O000000o(ParseExceptionType.NOT_JAVA_FLOAT, str2, str);
        }
    }

    public static boolean O000000o(baz baz, String str) throws ParseException {
        if (baz.O00000Oo.equals("YES")) {
            return true;
        }
        if (baz.O00000Oo.equals("NO")) {
            return false;
        }
        throw ParseException.O000000o(ParseExceptionType.NOT_YES_OR_NO, str, baz.toString());
    }

    public static String O00000o0(String str, String str2) throws ParseException {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (i != 0 || charAt == '\"') {
                if (i2 != 2) {
                    if (i == str.length() - 1) {
                        if (charAt != '\"' || z) {
                            throw new ParseException(ParseExceptionType.UNCLOSED_QUOTED_STRING, str2);
                        }
                    } else if (z) {
                        sb.append(charAt);
                        z = false;
                    } else if (charAt == '\\') {
                        z = true;
                    } else if (charAt == '\"') {
                        i2++;
                    } else {
                        sb.append(charAt);
                    }
                    i++;
                } else if (O000000o(charAt)) {
                    throw new ParseException(ParseExceptionType.ILLEGAL_WHITESPACE, str2);
                } else {
                    throw new ParseException(ParseExceptionType.INVALID_QUOTED_STRING, str2);
                }
            } else if (O000000o(charAt)) {
                throw new ParseException(ParseExceptionType.ILLEGAL_WHITESPACE, str2);
            } else {
                throw new ParseException(ParseExceptionType.INVALID_QUOTED_STRING, str2);
            }
        }
        return sb.toString();
    }

    public static String O000000o(String str, Encoding encoding) throws ParseException {
        try {
            return URLDecoder.decode(str.replace("+", "%2B"), encoding.value);
        } catch (UnsupportedEncodingException unused) {
            throw new ParseException(ParseExceptionType.INTERNAL_ERROR);
        }
    }

    public static Matcher O000000o(Pattern pattern, String str, String str2) throws ParseException {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return matcher;
        }
        throw ParseException.O000000o(ParseExceptionType.BAD_EXT_TAG_FORMAT, str2, str);
    }

    public static <T> void O000000o(String str, T t, bbv bbv, Map<String, ? extends bba<T>> map, String str2) throws ParseException {
        for (baz next : O00000o(str, str2)) {
            if (map.containsKey(next.f12759O000000o)) {
                ((bba) map.get(next.f12759O000000o)).O000000o(next, t, bbv);
            } else {
                throw ParseException.O000000o(ParseExceptionType.INVALID_ATTRIBUTE_NAME, str2, str);
            }
        }
    }

    private static List<baz> O00000o(String str, String str2) throws ParseException {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (String next : O00000oO(str, str2)) {
            int indexOf = next.indexOf("=");
            int indexOf2 = next.indexOf(jdn.f1779O000000o);
            if (indexOf == -1 || (indexOf2 != -1 && indexOf2 < indexOf)) {
                throw ParseException.O000000o(ParseExceptionType.MISSING_ATTRIBUTE_SEPARATOR, str2, arrayList.toString());
            }
            String trim = next.substring(0, indexOf).trim();
            String substring = next.substring(indexOf + 1);
            if (trim.isEmpty()) {
                throw ParseException.O000000o(ParseExceptionType.MISSING_ATTRIBUTE_NAME, str2, arrayList.toString());
            } else if (substring.isEmpty()) {
                throw ParseException.O000000o(ParseExceptionType.MISSING_ATTRIBUTE_VALUE, str2, arrayList.toString());
            } else if (hashSet.add(trim)) {
                arrayList.add(new baz(trim, substring));
            } else {
                throw ParseException.O000000o(ParseExceptionType.MULTIPLE_ATTRIBUTE_NAME_INSTANCES, str2, arrayList.toString());
            }
        }
        return arrayList;
    }

    private static List<String> O00000oO(String str, String str2) throws ParseException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        int indexOf = str.indexOf(":") + 1;
        boolean z = false;
        boolean z2 = false;
        for (int i = indexOf; i < str.length(); i++) {
            if (!z) {
                char charAt = str.charAt(i);
                if (charAt == ',') {
                    arrayList.add(Integer.valueOf(i));
                } else if (charAt == '\"') {
                    z = true;
                }
            } else if (z2) {
                z2 = false;
            } else {
                char charAt2 = str.charAt(i);
                if (charAt2 == '\\') {
                    z2 = true;
                } else if (charAt2 == '\"') {
                    z = false;
                }
            }
        }
        if (!z) {
            for (Integer num : arrayList) {
                arrayList2.add(str.substring(indexOf, num.intValue()));
                indexOf = num.intValue() + 1;
            }
            arrayList2.add(str.substring(indexOf));
            return arrayList2;
        }
        throw new ParseException(ParseExceptionType.UNCLOSED_QUOTED_STRING, str2);
    }
}
