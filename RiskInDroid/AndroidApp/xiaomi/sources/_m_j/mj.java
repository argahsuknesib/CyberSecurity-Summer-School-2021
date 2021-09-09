package _m_j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class mj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile mj f2184O000000o;

    private mj() {
    }

    public static mj O000000o() {
        if (f2184O000000o == null) {
            synchronized (mj.class) {
                if (f2184O000000o == null) {
                    f2184O000000o = new mj();
                }
            }
        }
        return f2184O000000o;
    }

    public static String O000000o(String str) {
        if (!O00000o0(str)) {
            return null;
        }
        civ.O000000o("TimeZoneUtils", "localTimeString:".concat(String.valueOf(str)));
        int intValue = Integer.valueOf(str.split(":")[0]).intValue();
        int intValue2 = Integer.valueOf(str.split(":")[1]).intValue();
        int intValue3 = Integer.valueOf(str.split(":")[2]).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar instance = Calendar.getInstance();
        instance.set(11, intValue);
        instance.set(12, intValue2);
        instance.set(13, intValue3);
        instance.set(14, 0);
        instance.add(14, -(instance.get(15) + instance.get(16)));
        Calendar instance2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
        instance2.setTimeInMillis(instance.getTimeInMillis());
        instance2.add(14, instance2.get(15) + instance2.get(16));
        String format = simpleDateFormat.format(instance2.getTime());
        civ.O000000o("TimeZoneUtils", "toGMT8TimeString:".concat(String.valueOf(format)));
        return format;
    }

    public static String O00000Oo(String str) {
        if (!O00000o0(str)) {
            return null;
        }
        civ.O000000o("TimeZoneUtils", "gmt8TimeString:".concat(String.valueOf(str)));
        int intValue = Integer.valueOf(str.split(":")[0]).intValue();
        int intValue2 = Integer.valueOf(str.split(":")[1]).intValue();
        int intValue3 = Integer.valueOf(str.split(":")[2]).intValue();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("GMT+08"));
        instance.set(11, intValue);
        instance.set(12, intValue2);
        instance.set(13, intValue3);
        instance.set(14, 0);
        instance.add(14, -(instance.get(15) + instance.get(16)));
        Calendar instance2 = Calendar.getInstance(TimeZone.getDefault());
        instance2.setTimeInMillis(instance.getTimeInMillis());
        instance2.add(14, instance2.get(15) + instance2.get(16));
        String str2 = simpleDateFormat.format(instance2.getTime()).toString();
        civ.O000000o("TimeZoneUtils", "toLocalTimeString:".concat(String.valueOf(str2)));
        return str2;
    }

    private static boolean O00000o0(String str) {
        return Pattern.compile("((((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$").matcher(str).matches();
    }
}
