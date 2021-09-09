package _m_j;

public final class jqb {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f2050O000000o = jpr.O00000Oo();
    public static final String O00000Oo = (f2050O000000o + "-Sent-Millis");
    public static final String O00000o = (f2050O000000o + "-Selected-Protocol");
    public static final String O00000o0 = (f2050O000000o + "-Received-Millis");
    public static final String O00000oO = (f2050O000000o + "-Response-Source");

    static {
        jpr.O000000o();
    }

    public static long O000000o(jpi jpi) {
        return O00000Oo(jpi.O000000o("Content-Length"));
    }

    static boolean O000000o(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    private static long O00000Oo(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long O000000o(jri jri) {
        return O000000o(jri.O00000o0);
    }

    public static long O000000o(jrk jrk) {
        return O000000o(jrk.O00000oo);
    }
}
