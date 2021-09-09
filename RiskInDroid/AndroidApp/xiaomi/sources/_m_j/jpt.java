package _m_j;

import java.util.Date;

public final class jpt {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jri f2034O000000o;
    public final jrk O00000Oo;

    private jpt(jri jri, jrk jrk) {
        this.f2034O000000o = jri;
        this.O00000Oo = jrk;
    }

    public /* synthetic */ jpt(jri jri, jrk jrk, byte b) {
        this(jri, jrk);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final long f2035O000000o;
        public final jri O00000Oo;
        public Date O00000o;
        public final jrk O00000o0;
        public String O00000oO;
        public Date O00000oo;
        public String O0000O0o;
        public Date O0000OOo;
        public long O0000Oo;
        public long O0000Oo0;
        public String O0000OoO;
        public int O0000Ooo = -1;

        public static boolean O000000o(jri jri) {
            return (jri.O000000o("If-Modified-Since") == null && jri.O000000o("If-None-Match") == null) ? false : true;
        }

        public O000000o(long j, jri jri, jrk jrk) {
            this.f2035O000000o = j;
            this.O00000Oo = jri;
            this.O00000o0 = jrk;
            if (jrk != null) {
                jpi jpi = jrk.O00000oo;
                int length = jpi.f2020O000000o.length / 2;
                for (int i = 0; i < length; i++) {
                    String O000000o2 = jpi.O000000o(i);
                    String O00000Oo2 = jpi.O00000Oo(i);
                    if ("Date".equalsIgnoreCase(O000000o2)) {
                        this.O00000o = jpx.O000000o(O00000Oo2);
                        this.O00000oO = O00000Oo2;
                    } else if ("Expires".equalsIgnoreCase(O000000o2)) {
                        this.O0000OOo = jpx.O000000o(O00000Oo2);
                    } else if ("Last-Modified".equalsIgnoreCase(O000000o2)) {
                        this.O00000oo = jpx.O000000o(O00000Oo2);
                        this.O0000O0o = O00000Oo2;
                    } else if ("ETag".equalsIgnoreCase(O000000o2)) {
                        this.O0000OoO = O00000Oo2;
                    } else if ("Age".equalsIgnoreCase(O000000o2)) {
                        this.O0000Ooo = jpu.O000000o(O00000Oo2, -1);
                    } else if (jqb.O00000Oo.equalsIgnoreCase(O000000o2)) {
                        this.O0000Oo0 = Long.parseLong(O00000Oo2);
                    } else if (jqb.O00000o0.equalsIgnoreCase(O000000o2)) {
                        this.O0000Oo = Long.parseLong(O00000Oo2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (r3.O00000Oo().O00000oo == false) goto L_0x0050;
     */
    public static boolean O000000o(jrk jrk, jri jri) {
        int i = jrk.O00000o0;
        if (!(i == 200 || i == 410 || i == 414 || i == 501 || i == 203 || i == 204)) {
            if (i != 307) {
                if (!(i == 308 || i == 404 || i == 405)) {
                    switch (i) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (jrk.O000000o("Expires") == null) {
                if (jrk.O00000Oo().O00000oO == -1) {
                    if (!jrk.O00000Oo().O0000O0o) {
                    }
                }
            }
        }
        if (jrk.O00000Oo().O00000o || jri.O00000Oo().O00000o) {
            return false;
        }
        return true;
    }
}
