package _m_j;

import java.util.HashMap;

public final class dxg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<Long, O000000o> f15025O000000o = new HashMap<>();
    private static int O00000Oo = 6;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f15026O000000o;
        public int O00000Oo;
        public long O00000o0;

        O000000o() {
        }
    }

    public static int O000000o(long j) {
        if (f15025O000000o.get(Long.valueOf(j)) == null) {
            return -1;
        }
        O000000o o000000o = f15025O000000o.get(Long.valueOf(j));
        int currentTimeMillis = (int) ((System.currentTimeMillis() - o000000o.O00000o0) / 1000);
        if (currentTimeMillis > O00000Oo) {
            return -1;
        }
        return o000000o.O00000Oo + currentTimeMillis;
    }

    public static void O000000o(long j, int i) {
        O000000o o000000o;
        if (f15025O000000o.get(Long.valueOf(j)) != null) {
            o000000o = f15025O000000o.get(Long.valueOf(j));
        } else {
            o000000o = new O000000o();
        }
        o000000o.f15026O000000o = j;
        o000000o.O00000Oo = i;
        o000000o.O00000o0 = System.currentTimeMillis();
        f15025O000000o.put(Long.valueOf(j), o000000o);
    }
}
