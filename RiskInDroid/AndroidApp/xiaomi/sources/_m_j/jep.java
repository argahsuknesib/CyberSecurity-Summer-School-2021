package _m_j;

public final class jep {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static boolean f1796O000000o = false;
    private static boolean O00000Oo = false;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jer.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.jer.O000000o(java.lang.String, java.util.Properties):java.lang.String
      _m_j.jer.O000000o(java.lang.String, org.apache.log4j.Level):org.apache.log4j.Level
      _m_j.jer.O000000o(java.lang.String, boolean):boolean */
    static {
        String O000000o2 = jer.O000000o("log4j.debug");
        if (O000000o2 == null) {
            O000000o2 = jer.O000000o("log4j.configDebug");
        }
        if (O000000o2 != null) {
            f1796O000000o = jer.O000000o(O000000o2, true);
        }
    }

    public static void O000000o(boolean z) {
        f1796O000000o = z;
    }

    public static void O000000o(String str) {
        if (f1796O000000o && !O00000Oo) {
            System.out.println("log4j: ".concat(String.valueOf(str)));
        }
    }

    public static void O000000o(String str, Throwable th) {
        if (f1796O000000o && !O00000Oo) {
            System.out.println("log4j: ".concat(String.valueOf(str)));
            th.printStackTrace(System.out);
        }
    }

    public static void O00000Oo(String str) {
        if (!O00000Oo) {
            System.err.println("log4j:ERROR ".concat(String.valueOf(str)));
        }
    }

    public static void O00000Oo(String str, Throwable th) {
        if (!O00000Oo) {
            System.err.println("log4j:ERROR ".concat(String.valueOf(str)));
            th.printStackTrace();
        }
    }

    public static void O00000o0(String str) {
        if (!O00000Oo) {
            System.err.println("log4j:WARN ".concat(String.valueOf(str)));
        }
    }

    public static void O00000o0(String str, Throwable th) {
        if (!O00000Oo) {
            System.err.println("log4j:WARN ".concat(String.valueOf(str)));
            if (th != null) {
                th.printStackTrace();
            }
        }
    }
}
