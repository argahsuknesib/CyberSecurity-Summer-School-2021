package _m_j;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class gxq {
    public static long O000000o(String str, String str2) {
        return new SimpleDateFormat(str2, Locale.CHINA).parse(str, new ParsePosition(0)).getTime();
    }

    public static String O000000o(Date date, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(date);
    }
}
