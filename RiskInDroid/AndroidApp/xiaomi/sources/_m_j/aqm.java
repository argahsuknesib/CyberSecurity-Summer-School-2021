package _m_j;

import _m_j.aqe;
import java.util.Map;

public final class aqm {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O000000o[] f12525O000000o;
    private final int O00000Oo;

    private static final int O000000o(int i) {
        int i2 = 8;
        while (i2 < (i <= 64 ? i + i : i + (i >> 2))) {
            i2 += i2;
        }
        return i2;
    }

    public aqm(Map<aqe.O000000o, ajz<Object>> map) {
        int O000000o2 = O000000o(map.size());
        this.O00000Oo = O000000o2;
        int i = O000000o2 - 1;
        O000000o[] o000000oArr = new O000000o[O000000o2];
        for (Map.Entry next : map.entrySet()) {
            aqe.O000000o o000000o = (aqe.O000000o) next.getKey();
            int hashCode = o000000o.hashCode() & i;
            o000000oArr[hashCode] = new O000000o(o000000oArr[hashCode], o000000o, (ajz) next.getValue());
        }
        this.f12525O000000o = o000000oArr;
    }

    public final ajz<Object> O000000o(aqe.O000000o o000000o) {
        int hashCode = o000000o.hashCode();
        O000000o[] o000000oArr = this.f12525O000000o;
        O000000o o000000o2 = o000000oArr[hashCode & (o000000oArr.length - 1)];
        if (o000000o2 == null) {
            return null;
        }
        if (o000000o.equals(o000000o2.f12526O000000o)) {
            return o000000o2.O00000Oo;
        }
        do {
            o000000o2 = o000000o2.O00000o0;
            if (o000000o2 == null) {
                return null;
            }
        } while (!o000000o.equals(o000000o2.f12526O000000o));
        return o000000o2.O00000Oo;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final aqe.O000000o f12526O000000o;
        public final ajz<Object> O00000Oo;
        public final O000000o O00000o0;

        public O000000o(O000000o o000000o, aqe.O000000o o000000o2, ajz<Object> ajz) {
            this.O00000o0 = o000000o;
            this.f12526O000000o = o000000o2;
            this.O00000Oo = ajz;
        }
    }
}
