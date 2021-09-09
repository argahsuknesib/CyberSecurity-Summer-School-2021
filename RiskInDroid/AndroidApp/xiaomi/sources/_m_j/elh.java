package _m_j;

public final class elh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f15607O000000o;
    public static final boolean O00000Oo;
    public static final boolean O00000o = "LOGABLE".equalsIgnoreCase(f15607O000000o);
    public static final boolean O00000o0;
    public static final boolean O00000oO = f15607O000000o.contains("YY");
    public static boolean O00000oo = f15607O000000o.equalsIgnoreCase("TEST");
    public static final boolean O0000O0o = "BETA".equalsIgnoreCase(f15607O000000o);
    public static final boolean O0000OOo;
    private static int O0000Oo0;

    static {
        int i;
        String str = elk.O00000Oo ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f15607O000000o = str;
        boolean contains = str.contains("2A2FE0D7");
        O00000Oo = contains;
        boolean z = false;
        O00000o0 = contains || "DEBUG".equalsIgnoreCase(f15607O000000o);
        String str2 = f15607O000000o;
        if (str2 != null && str2.startsWith("RC")) {
            z = true;
        }
        O0000OOo = z;
        O0000Oo0 = 1;
        if (f15607O000000o.equalsIgnoreCase("SANDBOX")) {
            i = 2;
        } else if (f15607O000000o.equalsIgnoreCase("ONEBOX")) {
            i = 3;
        } else {
            O0000Oo0 = 1;
            return;
        }
        O0000Oo0 = i;
    }

    public static void O000000o(int i) {
        O0000Oo0 = i;
    }

    public static boolean O000000o() {
        return O0000Oo0 == 2;
    }

    public static boolean O00000Oo() {
        return O0000Oo0 == 3;
    }

    public static int O00000o0() {
        return O0000Oo0;
    }
}
