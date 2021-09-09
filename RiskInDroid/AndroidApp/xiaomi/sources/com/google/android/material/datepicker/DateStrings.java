package com.google.android.material.datepicker;

import _m_j.be;
import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class DateStrings {
    private DateStrings() {
    }

    static String getYearMonth(Context context, long j) {
        return DateUtils.formatDateTime(context, j - ((long) TimeZone.getDefault().getOffset(j)), 36);
    }

    static String getYearMonthDay(long j) {
        return getYearMonthDay(j, Locale.getDefault());
    }

    static String getYearMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getMediumFormat(locale).format(new Date(j));
    }

    static String getMonthDay(long j) {
        return getMonthDay(j, Locale.getDefault());
    }

    static String getMonthDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getMediumNoYear(locale).format(new Date(j));
    }

    static String getMonthDayOfWeekDay(long j) {
        return getMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getMonthDayOfWeekDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    static String getYearMonthDayOfWeekDay(long j) {
        return getYearMonthDayOfWeekDay(j, Locale.getDefault());
    }

    static String getYearMonthDayOfWeekDay(long j, Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j));
        }
        return UtcDates.getFullFormat(locale).format(new Date(j));
    }

    static String getDateString(long j) {
        return getDateString(j, null);
    }

    static String getDateString(long j, SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j);
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j));
        }
        if (todayCalendar.get(1) == utcCalendar.get(1)) {
            return getMonthDay(j);
        }
        return getYearMonthDay(j);
    }

    static be<String, String> getDateRangeString(Long l, Long l2) {
        return getDateRangeString(l, l2, null);
    }

    static be<String, String> getDateRangeString(Long l, Long l2, SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return be.O000000o(null, null);
        }
        if (l == null) {
            return be.O000000o(null, getDateString(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return be.O000000o(getDateString(l.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return be.O000000o(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        } else if (utcCalendar.get(1) != utcCalendar2.get(1)) {
            return be.O000000o(getYearMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        } else {
            if (utcCalendar.get(1) == todayCalendar.get(1)) {
                return be.O000000o(getMonthDay(l.longValue(), Locale.getDefault()), getMonthDay(l2.longValue(), Locale.getDefault()));
            }
            return be.O000000o(getMonthDay(l.longValue(), Locale.getDefault()), getYearMonthDay(l2.longValue(), Locale.getDefault()));
        }
    }
}
