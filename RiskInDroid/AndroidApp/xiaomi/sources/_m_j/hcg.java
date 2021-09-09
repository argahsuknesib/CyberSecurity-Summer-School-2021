package _m_j;

import _m_j.hcc;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class hcg {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Locale f18777O000000o = Locale.ENGLISH;
    public static final Locale O00000Oo = Locale.ENGLISH;

    public static long O000000o(Map<String, hdi> map, String str) {
        hdi hdi;
        if (map == null || (hdi = map.get(str)) == null) {
            return 0;
        }
        return hdi.O00000Oo;
    }

    public static String O000000o(String str) {
        return str == null ? "" : str.replaceAll("\\s", "").replace("@3x", "").toLowerCase(f18777O000000o);
    }

    public static boolean O000000o(List<? extends hcc.O000000o> list) {
        if (list == null) {
            return false;
        }
        for (hcc.O000000o o000000o : list) {
            if (o000000o.O00000Oo == 6) {
                return true;
            }
        }
        return false;
    }

    public static long O00000Oo(long j) {
        return hhc.O00000Oo(j);
    }

    public static boolean O000000o(long j) {
        long O00000Oo2 = hhc.O00000Oo(j);
        return O00000Oo2 != 0 && System.currentTimeMillis() > O00000Oo2 + 43200000;
    }
}
