package _m_j;

public final class bns {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f13147O000000o = 750;
    private static float O00000Oo;
    private static final bnq<String, Integer> O00000o = new bnq<>();
    private static int O00000o0;

    public static void O000000o(float f, int i) {
        O00000Oo = f;
        O00000o0 = i;
    }

    public static int O000000o(double d) {
        double d2 = (double) O00000o0;
        Double.isNaN(d2);
        double d3 = d * d2;
        double d4 = (double) f13147O000000o;
        Double.isNaN(d4);
        return (int) ((d3 / d4) + 0.5d);
    }

    public static int O00000Oo(double d) {
        float f = O00000Oo;
        if (f < 0.0f) {
            f = 1.0f;
        }
        if (d >= 0.0d) {
            double d2 = (double) f;
            Double.isNaN(d2);
            return (int) ((d * d2) + 0.5d);
        }
        double d3 = (double) f;
        Double.isNaN(d3);
        return -((int) (((-d) * d3) + 0.5d));
    }

    public static boolean O000000o(String str) {
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            if ((str.charAt(0) == '$' && str.charAt(1) == '{' && str.charAt(length - 1) == '}') || (str.charAt(0) == '@' && str.charAt(1) == '{' && str.charAt(length - 1) == '}')) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            if (str.charAt(0) == '@' && str.charAt(1) == '{' && str.charAt(length - 1) == '}') {
                return true;
            }
            return false;
        }
        return false;
    }

    public static Boolean O000000o(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static Float O00000Oo(Object obj) {
        if (obj instanceof Float) {
            return (Float) obj;
        }
        if (obj instanceof Double) {
            return Float.valueOf(((Double) obj).floatValue());
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Float.valueOf((String) obj);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Integer O00000o0(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return Integer.valueOf((int) Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String O00000o(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static int O00000o0(String str) {
        try {
            Integer O000000o2 = O00000o.O000000o(str);
            if (O000000o2 != null) {
                return O000000o2.intValue();
            }
            Integer valueOf = Integer.valueOf(bnp.O000000o(str));
            O00000o.O000000o(str, valueOf);
            return valueOf.intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
