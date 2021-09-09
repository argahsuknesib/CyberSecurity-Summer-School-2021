package com.xiaomi.mico.common.util;

import android.text.TextUtils;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    public static long getDayString(Date date) {
        long rawOffset = (long) Calendar.getInstance().getTimeZone().getRawOffset();
        return ((date.getTime() + rawOffset) / 86400000) - ((System.currentTimeMillis() + rawOffset) / 86400000);
    }

    public static Date strToDate(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0));
    }

    public static Date strToDate(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Date();
        }
        return new SimpleDateFormat(str2).parse(str, new ParsePosition(0));
    }

    public static String dateToStr(Date date, String str) {
        return (date == null || TextUtils.isEmpty(str)) ? "" : new SimpleDateFormat(str).format(date);
    }

    public static String timestampToStr(long j, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Date date = new Date();
        date.setTime(j);
        return new SimpleDateFormat(str).format(date);
    }

    public static boolean isTomorrow(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(System.currentTimeMillis() + 86400000));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = j - instance.getTimeInMillis();
        if (timeInMillis < 0 || timeInMillis >= 86400000) {
            return false;
        }
        return true;
    }

    public static boolean isBeforeCurrentTimeOfHourMinute(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        int i3 = instance.get(11);
        int i4 = instance.get(12);
        if (i >= i3) {
            return i == i3 && i2 <= i4;
        }
        return true;
    }

    public static String updateTimeString(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }

    public static int compareTimestampHourMinute(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(11);
        int i2 = instance.get(12);
        instance.setTimeInMillis(j2);
        int i3 = instance.get(11);
        int i4 = instance.get(12);
        if (i > i3) {
            return 1;
        }
        if (i < i3) {
            return -1;
        }
        if (i2 > i4) {
            return 1;
        }
        return i2 < i4 ? -1 : 0;
    }
}
