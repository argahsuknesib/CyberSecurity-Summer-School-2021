package _m_j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class goz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Date f18101O000000o = new Date(Long.MAX_VALUE);

    public static boolean O000000o(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    public static boolean O000000o(Date date, Date date2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date2);
            if (instance.get(0) == instance2.get(0) && instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    public static boolean O00000Oo(Date date, Date date2) {
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date2);
            if (instance.get(0) == instance2.get(0) && instance.get(1) == instance2.get(1) && instance.get(3) == instance2.get(3)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("The dates must not be null");
    }

    public static boolean O000000o(Date date) {
        Date time = Calendar.getInstance().getTime();
        if (date == null || time == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(time);
        return O000000o(instance, instance2);
    }

    public static boolean O00000o0(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return instance2.get(6) - instance.get(6) == 1;
    }

    private static boolean O00000Oo(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        } else if (calendar.get(0) < calendar2.get(0)) {
            return true;
        } else {
            if (calendar.get(0) > calendar2.get(0)) {
                return false;
            }
            if (calendar.get(1) < calendar2.get(1)) {
                return true;
            }
            return calendar.get(1) <= calendar2.get(1) && calendar.get(6) < calendar2.get(6);
        }
    }

    private static boolean O00000o0(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        } else if (calendar.get(0) < calendar2.get(0)) {
            return false;
        } else {
            if (calendar.get(0) > calendar2.get(0)) {
                return true;
            }
            if (calendar.get(1) < calendar2.get(1)) {
                return false;
            }
            if (calendar.get(1) > calendar2.get(1) || calendar.get(6) > calendar2.get(6)) {
                return true;
            }
            return false;
        }
    }

    public static boolean O000000o(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(6, i);
            return O00000o0(calendar, instance) && !O00000o0(calendar, instance2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean O000000o(Calendar calendar) {
        if (calendar != null) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.add(6, -1);
            return O00000Oo(calendar, instance) && !O00000Oo(calendar, instance2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date O00000Oo(Date date) {
        if (date == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static Date O00000o0(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static int O00000o(Date date, Date date2) {
        int i;
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        int i2 = instance.get(6);
        int i3 = instance2.get(6);
        boolean z = true;
        int i4 = instance.get(1);
        int i5 = instance2.get(1);
        if (i4 == i5) {
            return i3 - i2;
        }
        if (i4 > i5) {
            i = i2 - i3;
        } else {
            i = i3 - i2;
            z = false;
            int i6 = i4;
            i4 = i5;
            i5 = i6;
        }
        while (i5 < i4) {
            i = ((i5 % 4 != 0 || i5 % 100 == 0) && i5 % 400 != 0) ? i + 365 : i + 366;
            i5++;
        }
        return z ? -i : i;
    }

    public static String O000000o(String str) {
        if (str == null || str.isEmpty() || str.equals("null")) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date(Long.valueOf(str + "000").longValue()));
    }
}
