package _m_j;

import android.util.Log;

public final class fyc {

    /* renamed from: O000000o  reason: collision with root package name */
    private static fyb f17403O000000o = new O00000Oo();
    private static int O00000Oo = (gfr.O0000OOo || gfr.O0000Oo || gfr.O0000o0o ? 2 : 4);

    public static int O000000o(String str, String str2) {
        if (3 < O00000Oo) {
            return -1;
        }
        return f17403O000000o.O000000o(str, str2);
    }

    public static int O00000Oo(String str, String str2) {
        if (4 < O00000Oo) {
            return -1;
        }
        return f17403O000000o.O00000Oo(str, str2);
    }

    public static int O00000o0(String str, String str2) {
        if (5 < O00000Oo) {
            return -1;
        }
        return f17403O000000o.O00000o0(str, str2);
    }

    public static int O000000o(String str, String str2, Throwable th) {
        if (5 < O00000Oo) {
            return -1;
        }
        return f17403O000000o.O000000o(str, str2, th);
    }

    public static int O00000o(String str, String str2) {
        if (6 < O00000Oo) {
            return -1;
        }
        return f17403O000000o.O00000o(str, str2);
    }

    public static int O00000Oo(String str, String str2, Throwable th) {
        if (6 < O00000Oo) {
            return -1;
        }
        return f17403O000000o.O00000Oo(str, str2, th);
    }

    public static class O000000o implements fyb {
        public int O000000o(String str, String str2) {
            return gsy.O000000o(3, str, str2);
        }

        public int O00000Oo(String str, String str2) {
            return gsy.O000000o(4, str, str2);
        }

        public int O00000o0(String str, String str2) {
            return gsy.O000000o(5, str, str2);
        }

        public int O000000o(String str, String str2, Throwable th) {
            return Log.w(str, str2, th);
        }

        public int O00000o(String str, String str2) {
            return gsy.O000000o(6, str, str2);
        }

        public int O00000Oo(String str, String str2, Throwable th) {
            return Log.e(str, str2, th);
        }
    }

    public static class O00000Oo extends O000000o {
        public final int O000000o(String str, String str2, Throwable th) {
            gbu.O000000o(str, 5, str2 + "\n" + Log.getStackTraceString(th));
            return 0;
        }

        public final int O00000Oo(String str, String str2, Throwable th) {
            gbu.O000000o(str, 6, str2 + "\n" + Log.getStackTraceString(th));
            return 0;
        }

        public final int O000000o(String str, String str2) {
            gbu.O000000o(str, 3, str2);
            return 0;
        }

        public final int O00000Oo(String str, String str2) {
            gbu.O000000o(str, 4, str2);
            return 0;
        }

        public final int O00000o0(String str, String str2) {
            gbu.O000000o(str, 5, str2);
            return 0;
        }

        public final int O00000o(String str, String str2) {
            gbu.O000000o(str, 6, str2);
            return 0;
        }
    }
}
