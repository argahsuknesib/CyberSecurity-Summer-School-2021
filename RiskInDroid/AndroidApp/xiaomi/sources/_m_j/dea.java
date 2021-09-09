package _m_j;

import _m_j.ddz;
import java.util.ArrayList;
import java.util.Iterator;

public final class dea {
    public static String O000000o(String str) {
        ArrayList<ddz.O000000o> O000000o2 = ddz.O000000o().O000000o(str);
        StringBuilder sb = new StringBuilder();
        if (O000000o2.size() > 0) {
            Iterator<ddz.O000000o> it = O000000o2.iterator();
            while (it.hasNext()) {
                ddz.O000000o next = it.next();
                if (2 == next.f14540O000000o) {
                    sb.append(next.O00000o0);
                } else {
                    sb.append(next.O00000Oo);
                }
            }
        }
        return sb.toString().toLowerCase();
    }

    public static boolean O00000Oo(String str) {
        for (char c : str.toCharArray()) {
            if (c >= 19968 && c <= 40959) {
                return true;
            }
            if (c >= 13312 && c <= 19903) {
                return true;
            }
            if (c >= 63744 && c <= 64255) {
                return true;
            }
        }
        return false;
    }
}
