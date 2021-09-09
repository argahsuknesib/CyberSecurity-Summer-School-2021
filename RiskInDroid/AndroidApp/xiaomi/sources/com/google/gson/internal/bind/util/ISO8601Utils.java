package com.google.gson.internal.bind.util;

import _m_j.jdn;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder((z ? 4 : 0) + 19 + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a2 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01aa }] */
    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        TimeZone timeZone;
        char charAt;
        String str3 = str;
        ParsePosition parsePosition2 = parsePosition;
        try {
            int index = parsePosition.getIndex();
            int i7 = index + 4;
            int parseInt = parseInt(str3, index, i7);
            if (checkOffset(str3, i7, '-')) {
                i7++;
            }
            int i8 = i7 + 2;
            int parseInt2 = parseInt(str3, i7, i8);
            if (checkOffset(str3, i8, '-')) {
                i8++;
            }
            int i9 = i8 + 2;
            int parseInt3 = parseInt(str3, i8, i9);
            boolean checkOffset = checkOffset(str3, i9, 'T');
            if (checkOffset || str.length() > i9) {
                if (checkOffset) {
                    int i10 = i9 + 1;
                    int i11 = i10 + 2;
                    i5 = parseInt(str3, i10, i11);
                    if (checkOffset(str3, i11, ':')) {
                        i11++;
                    }
                    i = i11 + 2;
                    i4 = parseInt(str3, i11, i);
                    if (checkOffset(str3, i, ':')) {
                        i++;
                    }
                    if (!(str.length() <= i || (charAt = str3.charAt(i)) == 'Z' || charAt == '+' || charAt == '-')) {
                        int i12 = i + 2;
                        int parseInt4 = parseInt(str3, i, i12);
                        if (parseInt4 > 59 && parseInt4 < 63) {
                            parseInt4 = 59;
                        }
                        if (checkOffset(str3, i12, '.')) {
                            int i13 = i12 + 1;
                            int indexOfNonDigit = indexOfNonDigit(str3, i13 + 1);
                            int min = Math.min(indexOfNonDigit, i13 + 3);
                            int parseInt5 = parseInt(str3, i13, min);
                            int i14 = min - i13;
                            if (i14 == 1) {
                                parseInt5 *= 100;
                            } else if (i14 == 2) {
                                parseInt5 *= 10;
                            }
                            i2 = parseInt5;
                            i3 = parseInt4;
                            i = indexOfNonDigit;
                            if (str.length() > i) {
                                char charAt2 = str3.charAt(i);
                                if (charAt2 == 'Z') {
                                    timeZone = TIMEZONE_UTC;
                                    i6 = i + 1;
                                } else {
                                    if (charAt2 != '+') {
                                        if (charAt2 != '-') {
                                            throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt2 + "'");
                                        }
                                    }
                                    String substring = str3.substring(i);
                                    if (substring.length() < 5) {
                                        substring = substring + "00";
                                    }
                                    i6 = i + substring.length();
                                    if (!"+0000".equals(substring)) {
                                        if (!"+00:00".equals(substring)) {
                                            String concat = "GMT".concat(String.valueOf(substring));
                                            TimeZone timeZone2 = TimeZone.getTimeZone(concat);
                                            String id = timeZone2.getID();
                                            if (!id.equals(concat)) {
                                                if (!id.replace(":", "").equals(concat)) {
                                                    throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + concat + " given, resolves to " + timeZone2.getID());
                                                }
                                            }
                                            timeZone = timeZone2;
                                        }
                                    }
                                    timeZone = TIMEZONE_UTC;
                                }
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, parseInt);
                                gregorianCalendar.set(2, parseInt2 - 1);
                                gregorianCalendar.set(5, parseInt3);
                                gregorianCalendar.set(11, i5);
                                gregorianCalendar.set(12, i4);
                                gregorianCalendar.set(13, i3);
                                gregorianCalendar.set(14, i2);
                                parsePosition2.setIndex(i6);
                                return gregorianCalendar.getTime();
                            }
                            throw new IllegalArgumentException("No time zone indicator");
                        }
                        i3 = parseInt4;
                        i = i12;
                        i2 = 0;
                        if (str.length() > i) {
                        }
                    }
                } else {
                    i = i9;
                    i5 = 0;
                    i4 = 0;
                }
                i3 = 0;
                i2 = 0;
                if (str.length() > i) {
                }
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(parseInt, parseInt2 - 1, parseInt3);
                parsePosition2.setIndex(i9);
                return gregorianCalendar2.getTime();
            }
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e) {
            if (str3 == null) {
                str2 = null;
            } else {
                str2 = jdn.f1779O000000o + str3 + '\"';
            }
            String message = e.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i4 = i;
            i3 = 0;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
