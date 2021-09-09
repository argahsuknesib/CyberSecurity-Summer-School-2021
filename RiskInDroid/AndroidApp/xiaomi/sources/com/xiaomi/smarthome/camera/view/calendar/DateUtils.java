package com.xiaomi.smarthome.camera.view.calendar;

import _m_j.gkv;
import _m_j.mi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<>();
    private static final ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        /* class com.xiaomi.smarthome.camera.view.calendar.DateUtils.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        }
    };
    private static final ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        /* class com.xiaomi.smarthome.camera.view.calendar.DateUtils.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM/dd/yyyy");
        }
    };

    public static boolean earlyThan(String str, String str2) {
        return false;
    }

    public static boolean lateThan(String str, String str2) {
        return false;
    }

    public static boolean isToday(String str) {
        Date date = toDate(str);
        return date != null && dateFormater2.get().format(new Date()).equals(dateFormater2.get().format(date));
    }

    public static Date toDate(String str) {
        try {
            return dateFormater.get().parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static boolean IsToday(String str) throws ParseException {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(System.currentTimeMillis()));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(getDateFormat().parse(str));
        if (instance2.get(1) == instance.get(1) && instance2.get(6) - instance.get(6) == 0) {
            return true;
        }
        return false;
    }

    public static boolean IsYesterday(String str) throws ParseException {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(System.currentTimeMillis()));
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(getDateFormat().parse(str));
        if (instance2.get(1) == instance.get(1) && instance2.get(6) - instance.get(6) == -1) {
            return true;
        }
        return false;
    }

    public static SimpleDateFormat getDateFormat() {
        if (DateLocal.get() == null) {
            DateLocal.set(new SimpleDateFormat("MM/dd/yyyy", Locale.CHINA));
        }
        return DateLocal.get();
    }

    public static String getDateFromNum(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(j));
    }

    public static String getDateFromNum(long j, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
    }

    public static String getYearFromNumm(long j) {
        return new SimpleDateFormat("yyyy", Locale.CHINA).format(new Date(j));
    }

    public static String getMonthFromNumm(long j) {
        return new SimpleDateFormat("MM", Locale.CHINA).format(new Date(j));
    }

    public static String getDateFromNumm(long j) {
        return new SimpleDateFormat("dd", Locale.CHINA).format(new Date(j));
    }

    public static String getTimeFromNum(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i / 60;
        int i3 = i2 / 60;
        int i4 = i3 * 60;
        int i5 = i2 - i4;
        int i6 = (i - (i5 * 60)) - (i4 * 60);
        if (i3 > 9) {
            stringBuffer.append(i3 + ":");
        } else {
            stringBuffer.append("0" + i3 + ":");
        }
        if (i5 > 9) {
            stringBuffer.append(i5 + ":");
        } else {
            stringBuffer.append("0" + i5 + ":");
        }
        if (i6 > 9) {
            stringBuffer.append(String.valueOf(i6));
        } else {
            stringBuffer.append("0".concat(String.valueOf(i6)));
        }
        return stringBuffer.toString();
    }

    public static String getNumberDecimalFormat(long j) {
        return new DecimalFormat("###.00").format(j);
    }

    public static long getTime(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.CHINA).parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String convertHHMMSS(int i) {
        String str;
        String str2;
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        if (i2 < 10) {
            str = "" + "0" + i2;
        } else {
            str = "" + i2;
        }
        if (i4 < 10) {
            str2 = str + ":0" + i4;
        } else {
            str2 = str + ":" + i4;
        }
        if (i5 < 10) {
            return str2 + ":0" + i5;
        }
        return str2 + ":" + i5;
    }

    public static String getDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(instance.get(5));
    }

    public static String getMonth(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return String.valueOf(instance.get(2));
    }

    public static CalendarDate getCalendarDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return new CalendarDate(String.valueOf(instance.get(1)), String.valueOf(instance.get(2)), String.valueOf(instance.get(5)), String.valueOf(instance.get(7)), j);
    }

    public static String getTimeStr(Context context, long j) {
        long[] dayStartAndEndTimeMillis = getCalendarDate(System.currentTimeMillis()).getDayStartAndEndTimeMillis();
        if (j >= dayStartAndEndTimeMillis[0] && j < dayStartAndEndTimeMillis[1]) {
            return context.getString(R.string.today);
        }
        if (j >= dayStartAndEndTimeMillis[0] - 86400000 && j < dayStartAndEndTimeMillis[1] - 86400000) {
            return context.getString(R.string.yesterday);
        }
        if (j >= dayStartAndEndTimeMillis[0] - 172800000 && j < dayStartAndEndTimeMillis[1] - 172800000) {
            Resources resources = context.getResources();
            resources.getDisplayMetrics();
            if (resources.getConfiguration().locale.getLanguage().equals("zh")) {
                return "前天";
            }
        }
        return getDateFromNum(j, "MM-dd");
    }

    public static String getCurrentBeforeTime(String str) {
        long currentTimeMillis = (System.currentTimeMillis() - Long.parseLong(str)) / 1000;
        if (currentTimeMillis >= 60) {
            long j = currentTimeMillis / 60;
            String str2 = j + "分钟之前";
            if (j < 60) {
                return str2;
            }
            long j2 = j / 60;
            String str3 = j2 + "小时之前";
            if (j2 < 24) {
                return str3;
            }
            return (j2 / 24) + "天之前";
        }
        return currentTimeMillis + "秒之前";
    }

    public static String dataToName(long j) {
        return new SimpleDateFormat("MM月dd日 HH点mm分").format(new Date(j));
    }

    public static String getMonthDay(long j) {
        String language = gkv.f17949O000000o.getResources().getConfiguration().locale.getLanguage();
        String country = gkv.f17949O000000o.getResources().getConfiguration().locale.getCountry();
        if (TextUtils.isEmpty(language) || !"zh".equalsIgnoreCase(language) || !"cn".equalsIgnoreCase(country)) {
            return mi.O00000o(j);
        }
        return getDateFromNum(j, "MM月dd日");
    }
}
