package _m_j;

import java.util.HashMap;

public class dil {

    /* renamed from: O000000o  reason: collision with root package name */
    public static dil f14687O000000o;
    static final /* synthetic */ boolean O00000o = (!dil.class.desiredAssertionStatus());
    private static int O00000oO = 0;
    public HashMap<String, O000000o> O00000Oo = new HashMap<>();
    public final String O00000o0 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public djz f14688O000000o;
        public dik O00000Oo;
        public String O00000o0;
    }

    public static dil O000000o() {
        if (f14687O000000o == null) {
            f14687O000000o = new dil();
        }
        return f14687O000000o;
    }

    public static String O00000Oo() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            double random = Math.random();
            double d = (double) length;
            Double.isNaN(d);
            stringBuffer.append(charArray[(int) (random * d)]);
        }
        return stringBuffer.toString();
    }

    public final String O000000o(O000000o o000000o) {
        int i = O00000oO + 1;
        O00000oO = i;
        try {
            this.O00000Oo.put(String.valueOf(i), o000000o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return String.valueOf(i);
    }
}
