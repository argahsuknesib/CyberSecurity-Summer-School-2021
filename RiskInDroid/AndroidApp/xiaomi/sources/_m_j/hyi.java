package _m_j;

import java.util.concurrent.atomic.AtomicLong;

public final class hyi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile Long f980O000000o = null;
    private static volatile AtomicLong O00000Oo = null;
    private static int O00000o0 = 1;

    private static String O00000Oo(long j, long j2) {
        if (f980O000000o == null && O00000Oo == null) {
            synchronized ("STAT_LOG_CACHE_STATUS") {
                if (f980O000000o == null && O00000Oo == null) {
                    if (j <= 10) {
                        j = System.currentTimeMillis();
                    }
                    f980O000000o = Long.valueOf(j);
                    O00000Oo = new AtomicLong(j2);
                }
            }
        }
        return "\\\"session\\\":" + f980O000000o + ",\\\"order\\\":" + O00000Oo.incrementAndGet();
    }

    public static String O000000o(long j, long j2) {
        if (j >= 10) {
            return O00000Oo(j, j2);
        }
        boolean z = j2 == 1;
        O00000o0 += z ? 1 : -1;
        if (z) {
            if (O00000o0 > 1) {
                return null;
            }
            return "enter";
        } else if (O00000o0 > 0) {
            return null;
        } else {
            synchronized ("STAT_LOG_CACHE_STATUS") {
                f980O000000o = Long.valueOf(System.currentTimeMillis());
                O00000Oo = new AtomicLong(0);
            }
            return "reset";
        }
    }

    public static final boolean O000000o(flu flu, boolean z, boolean z2) {
        return flu.O000000o((long) ((z ^ true ? 1 : 0) + true), z2 ? 1 : 2) != null;
    }

    public static String O000000o(flu flu) {
        if (flu == null || !flu.O00000o()) {
            return O00000Oo(10, 0);
        }
        if (!(f980O000000o == null || O00000Oo == null)) {
            synchronized ("STAT_LOG_CACHE_STATUS") {
                if (f980O000000o != null && O00000Oo != null) {
                    String O000000o2 = flu.O000000o(f980O000000o.longValue(), O00000Oo.get());
                    if (O000000o2 == null) {
                        String O00000Oo2 = O00000Oo(10, 0);
                        return O00000Oo2;
                    }
                    f980O000000o = null;
                    O00000Oo = null;
                    return O000000o2;
                }
            }
        }
        return flu.O000000o(10, 0);
    }
}
