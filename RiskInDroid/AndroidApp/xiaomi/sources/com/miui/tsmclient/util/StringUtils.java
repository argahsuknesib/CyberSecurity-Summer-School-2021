package com.miui.tsmclient.util;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

public class StringUtils {
    public static String formatDateFromString(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        try {
            return new SimpleDateFormat(str3).format(new SimpleDateFormat(str2).parse(str));
        } catch (ParseException e) {
            LogUtils.e("parse date failed,date string is:" + str + ",pattern is:" + str2, e);
            return null;
        }
    }

    public static String millsToTime(long j, String str) {
        if (j < 0) {
            return null;
        }
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String covertFloatToString(float f) {
        int i = (int) f;
        if (f == ((float) i)) {
            return String.valueOf(i);
        }
        return String.valueOf(f);
    }

    public static String createMarkedString(String str, int i, int i2, char c) {
        if (TextUtils.isEmpty(str) || i2 > str.length()) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i);
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 < i) {
                sb.append(c);
                i3 = i4;
            } else {
                sb.replace(i - i2, i, str.subSequence(str.length() - i2, str.length()).toString());
                return sb.toString();
            }
        }
    }

    public static String formatAmount(int i) {
        return String.format(String.format("%.2f", Float.valueOf(((float) i) / 100.0f)), new Object[0]);
    }

    public static String createMarkedString(String str, int i, char c) {
        if (TextUtils.isEmpty(str) || i > str.length()) {
            return null;
        }
        return createMarkedString(str, str.length(), i, c);
    }

    public static boolean checkLength(String str, int i) {
        return checkLength(str, i, i);
    }

    public static boolean checkLength(String str, int i, int i2) {
        if (!TextUtils.isEmpty(str) && str.length() >= i && str.length() <= i2) {
            return true;
        }
        return false;
    }

    public static boolean checkValidByPatten(String str, String str2) {
        return Pattern.compile(str2).matcher(str).matches();
    }

    public static boolean checkPhoneNum(String str) {
        return checkValidByPatten(str, "^\\d{11}$");
    }

    public static String tail(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(str.length() - i);
    }

    public static String join(Map<String, String> map, String str) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            i++;
        }
        return sb.toString();
    }

    public static String join(String str, String... strArr) {
        if (!(strArr == null || str == null)) {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(str);
            }
            if (sb.length() > 0) {
                return sb.substring(0, sb.length() - 1).toString();
            }
        }
        return null;
    }

    private StringUtils() {
    }
}
