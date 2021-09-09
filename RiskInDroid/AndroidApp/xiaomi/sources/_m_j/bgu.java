package _m_j;

import java.util.List;

public final class bgu {
    public static Object O000000o(bhc bhc, Object obj) {
        List<bia> list = bhc.O00000o0;
        if (list != null) {
            for (bia O000000o2 : list) {
                obj = O000000o2.O000000o();
            }
        }
        return obj;
    }

    public static String O000000o(bhc bhc, String str) {
        List<bhj> list = bhc.O00000o;
        if (list != null) {
            for (bhj O000000o2 : list) {
                str = O000000o2.O000000o();
            }
        }
        return str;
    }

    public static boolean O000000o(bhc bhc) {
        List<bhq> list = bhc.O00000oO;
        if (list == null) {
            return true;
        }
        for (bhq O000000o2 : list) {
            if (!O000000o2.O000000o()) {
                return false;
            }
        }
        return true;
    }

    public static boolean O00000Oo(bhc bhc) {
        List<bhp> list = bhc.O00000Oo;
        if (list == null) {
            return true;
        }
        for (bhp O000000o2 : list) {
            if (!O000000o2.O000000o()) {
                return false;
            }
        }
        return true;
    }
}
