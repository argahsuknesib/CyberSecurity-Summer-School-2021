package _m_j;

import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import java.util.List;

public final class bce {
    public static String O000000o(boolean z) {
        return z ? "YES" : "NO";
    }

    public static String O000000o(String str, String str2) throws ParseException {
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append(jdn.f1779O000000o);
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (i != 0 || !bbw.O000000o(charAt)) {
                if (charAt == '\"') {
                    sb.append('\\');
                    sb.append(charAt);
                } else {
                    sb.append(charAt);
                }
                i++;
            } else {
                throw new ParseException(ParseExceptionType.ILLEGAL_WHITESPACE, str2);
            }
        }
        sb.append(jdn.f1779O000000o);
        return sb.toString();
    }

    public static String O000000o(List<? extends Object> list, String str) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("valueList might not be null or empty!");
        } else if (str != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size()) {
                sb.append(list.get(i).toString());
                i++;
                if (i < list.size()) {
                    sb.append(str);
                }
            }
            return sb.toString();
        } else {
            throw new IllegalArgumentException("separator might not be null!");
        }
    }
}
