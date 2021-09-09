package _m_j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class jjn implements jji {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Map<Long, jjn> f1882O000000o = Collections.synchronizedMap(new HashMap());
    public long O00000Oo;

    public static jjn O000000o(long j) {
        jjn jjn = f1882O000000o.get(Long.valueOf(j));
        if (jjn != null) {
            return jjn;
        }
        jjn jjn2 = new jjn();
        jjn2.O00000Oo = j;
        f1882O000000o.put(Long.valueOf(j), jjn2);
        return jjn2;
    }

    public String toString() {
        return "ctts=" + this.O00000Oo;
    }
}
