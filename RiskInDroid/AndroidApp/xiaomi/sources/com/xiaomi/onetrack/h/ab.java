package com.xiaomi.onetrack.h;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

public class ab {
    private static long i;
    private static long j;
    private static long k;

    public static long a() {
        return System.currentTimeMillis();
    }

    public static boolean a(long j2, long j3) {
        return Math.abs(System.currentTimeMillis() - j2) >= j3;
    }

    public static boolean a(long j2) {
        q.a("TimeUtil", "inToday,current ts :" + a());
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(a());
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        long j3 = timeInMillis + 86400000;
        q.a("TimeUtil", "[start]:" + timeInMillis + "\n[end]:" + j3 + "duration" + ((j3 - timeInMillis) - 86400000));
        StringBuilder sb = new StringBuilder("is in today:");
        sb.append(timeInMillis <= j2 && j2 < j3);
        q.a("TimeUtil", sb.toString());
        if (timeInMillis > j2 || j2 >= j3) {
            return false;
        }
        return true;
    }

    public static boolean b(long j2) {
        q.a("TimeUtil", "inTodayClientTime,current ts :" + System.currentTimeMillis());
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(System.currentTimeMillis());
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        long j3 = timeInMillis + 86400000;
        q.a("TimeUtil", "[start]:" + timeInMillis + "\n[end]:" + j3 + "duration" + ((j3 - timeInMillis) - 86400000));
        StringBuilder sb = new StringBuilder("is in today:");
        sb.append(timeInMillis <= j2 && j2 < j3);
        q.a("TimeUtil", sb.toString());
        if (timeInMillis > j2 || j2 >= j3) {
            return false;
        }
        return true;
    }

    public static boolean a(long j2, int i2) {
        return Math.abs(System.currentTimeMillis() - j2) >= ((long) (i2 + new Random().nextInt(i2 / 2)));
    }

    public static String c(long j2) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            return new SimpleDateFormat("HH:mm:ss yy-MM-dd").format(instance.getTime());
        } catch (Exception unused) {
            return "";
        }
    }

    public static long b() {
        Calendar calendar;
        try {
            calendar = Calendar.getInstance(TimeZone.getTimeZone(r.d()));
        } catch (Exception unused) {
            calendar = Calendar.getInstance();
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean d(long j2) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.add(10, 8);
        Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance2.setTimeInMillis(j2);
        instance2.add(10, 8);
        int i2 = instance2.get(1);
        int i3 = instance2.get(2);
        int i4 = instance2.get(5);
        if (i2 == instance.get(1) && i3 == instance.get(2) && i4 == instance.get(5)) {
            return true;
        }
        return false;
    }
}
