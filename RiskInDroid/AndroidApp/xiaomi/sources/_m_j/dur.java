package _m_j;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import java.util.Calendar;

@SuppressLint({"WrongConstant"})
public final class dur {

    /* renamed from: O000000o  reason: collision with root package name */
    private static long f14957O000000o;

    public static int O000000o(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        return instance.get(6) - instance2.get(6);
    }

    public static long O000000o(long j) {
        return j + (SystemClock.uptimeMillis() - f14957O000000o);
    }

    public static long O00000Oo(long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(10, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        return (instance.getTimeInMillis() + 1) - j;
    }
}
