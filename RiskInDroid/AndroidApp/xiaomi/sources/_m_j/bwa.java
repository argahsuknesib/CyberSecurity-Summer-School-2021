package _m_j;

import java.util.Calendar;
import java.util.Date;

public final class bwa {
    private static long O000000o(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public static long O000000o(long j, long j2, int i) {
        if (i > 0) {
            try {
                if (Math.abs(j - j2) > ((long) i) * 31536000000L) {
                    long O000000o2 = O000000o(j2) + (j - O000000o(j));
                    long abs = Math.abs(O000000o2 - j2);
                    Calendar instance = Calendar.getInstance();
                    instance.setTime(new Date(O000000o2));
                    int i2 = instance.get(11);
                    if (i2 == 23 && abs >= 82800000) {
                        O000000o2 -= 86400000;
                    }
                    return (i2 != 0 || abs < 82800000) ? O000000o2 : O000000o2 + 86400000;
                }
            } catch (Throwable unused) {
            }
        }
        return j;
    }
}
