package _m_j;

import _m_j.clj;
import java.util.Comparator;

public final class cli implements Comparator<clj.O000000o> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return O000000o((clj.O000000o) obj, (clj.O000000o) obj2);
    }

    private static int O000000o(clj.O000000o o000000o, clj.O000000o o000000o2) {
        try {
            long j = o000000o.f14070O000000o;
            long j2 = o000000o2.f14070O000000o;
            if (j == 0) {
                j = o000000o.O00000o0.lastModified();
            }
            if (j2 == 0) {
                j2 = o000000o2.O00000o0.lastModified();
            }
            if (j > j2) {
                return 1;
            }
            if (j < j2) {
                return -1;
            }
            return 0;
        } catch (Exception unused) {
        }
    }
}
