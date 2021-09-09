package _m_j;

import _m_j.dya;
import java.util.Map;

public final class dzk {
    public static synchronized Long O000000o(String str, Long l) {
        synchronized (dzk.class) {
            if (l.longValue() <= 0) {
                l = Long.valueOf(System.currentTimeMillis());
            }
            Map map = dya.O000000o.f15057O000000o.f15053O000000o.get();
            if (map == null) {
                return l;
            }
            if (map.containsKey(str)) {
                map.put(str, l);
                Long valueOf = Long.valueOf(l.longValue() - ((Long) map.get(str)).longValue());
                return valueOf;
            }
            map.put(str, l);
            return l;
        }
    }
}
