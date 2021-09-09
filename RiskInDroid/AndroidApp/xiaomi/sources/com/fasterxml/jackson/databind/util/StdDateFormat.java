package com.fasterxml.jackson.databind.util;

import _m_j.aiw;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class StdDateFormat extends DateFormat {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final String[] f3601O000000o = {"yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
    protected static final DateFormat O00000Oo;
    protected static final DateFormat O00000o;
    protected static final DateFormat O00000o0;
    protected static final DateFormat O00000oO;
    public static final StdDateFormat O00000oo = new StdDateFormat();
    private static final TimeZone O0000Ooo = TimeZone.getTimeZone("GMT");
    protected transient TimeZone O0000O0o;
    protected transient DateFormat O0000OOo;
    protected transient DateFormat O0000Oo;
    protected transient DateFormat O0000Oo0;
    protected transient DateFormat O0000OoO;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        O00000Oo = simpleDateFormat;
        simpleDateFormat.setTimeZone(O0000Ooo);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        O00000o0 = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(O0000Ooo);
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        O00000o = simpleDateFormat3;
        simpleDateFormat3.setTimeZone(O0000Ooo);
        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
        O00000oO = simpleDateFormat4;
        simpleDateFormat4.setTimeZone(O0000Ooo);
    }

    public StdDateFormat() {
    }

    private StdDateFormat(TimeZone timeZone) {
        this.O0000O0o = timeZone;
    }

    public static StdDateFormat O000000o(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = O0000Ooo;
        }
        return new StdDateFormat(timeZone);
    }

    public static DateFormat O00000Oo(TimeZone timeZone) {
        return O000000o(O00000o0, timeZone);
    }

    public void setTimeZone(TimeZone timeZone) {
        if (timeZone != this.O0000O0o) {
            this.O0000OOo = null;
            this.O0000Oo0 = null;
            this.O0000Oo = null;
            this.O0000OoO = null;
            this.O0000O0o = timeZone;
        }
    }

    public Date parse(String str) throws ParseException {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(trim, parsePosition);
        if (parse != null) {
            return parse;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : f3601O000000o) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", trim, sb.toString()), parsePosition.getErrorIndex());
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = O000000o(O00000o0);
        }
        return this.O0000Oo0.format(date, stringBuffer, fieldPosition);
    }

    private final DateFormat O000000o(DateFormat dateFormat) {
        return O000000o(dateFormat, this.O0000O0o);
    }

    private static final DateFormat O000000o(DateFormat dateFormat, TimeZone timeZone) {
        DateFormat dateFormat2 = (DateFormat) dateFormat.clone();
        if (timeZone != null) {
            dateFormat2.setTimeZone(timeZone);
        }
        return dateFormat2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x014f  */
    public Date parse(String str, ParsePosition parsePosition) {
        char charAt;
        DateFormat dateFormat;
        char charAt2;
        char charAt3;
        char charAt4;
        boolean z = false;
        if (str.length() >= 5 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-') {
            int length = str.length();
            int i = length - 1;
            char charAt5 = str.charAt(i);
            if (length <= 10 && Character.isDigit(charAt5)) {
                dateFormat = this.O0000OoO;
                if (dateFormat == null) {
                    dateFormat = O000000o(O00000oO);
                    this.O0000OoO = dateFormat;
                }
            } else if (charAt5 == 'Z') {
                DateFormat dateFormat2 = this.O0000Oo;
                if (dateFormat2 == null) {
                    dateFormat2 = O000000o(O00000o);
                    this.O0000Oo = dateFormat2;
                }
                if (str.charAt(length - 4) == ':') {
                    StringBuilder sb = new StringBuilder(str);
                    sb.insert(i, ".000");
                    str = sb.toString();
                }
                dateFormat = dateFormat2;
            } else {
                int length2 = str.length();
                if (length2 >= 6 && ((charAt2 = str.charAt(length2 - 6)) == '+' || charAt2 == '-' || (charAt3 = str.charAt(length2 - 5)) == '+' || charAt3 == '-' || (charAt4 = str.charAt(length2 - 3)) == '+' || charAt4 == '-')) {
                    z = true;
                }
                if (z) {
                    int i2 = length - 3;
                    char charAt6 = str.charAt(i2);
                    if (charAt6 == ':') {
                        StringBuilder sb2 = new StringBuilder(str);
                        sb2.delete(i2, length - 2);
                        str = sb2.toString();
                    } else if (charAt6 == '+' || charAt6 == '-') {
                        str = str + "00";
                    }
                    int length3 = str.length();
                    if (Character.isDigit(str.charAt(length3 - 9))) {
                        StringBuilder sb3 = new StringBuilder(str);
                        sb3.insert(length3 - 5, ".000");
                        str = sb3.toString();
                    }
                    dateFormat = this.O0000Oo0;
                    if (dateFormat == null) {
                        dateFormat = O000000o(O00000o0);
                        this.O0000Oo0 = dateFormat;
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder(str);
                    if ((length - str.lastIndexOf(84)) - 1 <= 8) {
                        sb4.append(".000");
                    }
                    sb4.append('Z');
                    str = sb4.toString();
                    dateFormat = this.O0000Oo;
                    if (dateFormat == null) {
                        dateFormat = O000000o(O00000o);
                        this.O0000Oo = dateFormat;
                    }
                }
            }
            return dateFormat.parse(str, parsePosition);
        }
        int length4 = str.length();
        do {
            length4--;
            if (length4 < 0 || (charAt = str.charAt(length4)) < '0') {
                if (length4 >= 0 && aiw.O00000o0(str)) {
                    return new Date(Long.parseLong(str));
                }
                if (this.O0000OOo == null) {
                    this.O0000OOo = O000000o(O00000Oo);
                }
                return this.O0000OOo.parse(str, parsePosition);
            }
        } while (charAt <= '9');
        if (length4 >= 0) {
        }
        if (this.O0000OOo == null) {
        }
        return this.O0000OOo.parse(str, parsePosition);
    }

    public /* synthetic */ Object clone() {
        return new StdDateFormat();
    }
}
