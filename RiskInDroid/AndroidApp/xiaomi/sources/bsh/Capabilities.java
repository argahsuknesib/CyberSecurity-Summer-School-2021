package bsh;

import java.util.Hashtable;

public final class Capabilities {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f3061O000000o = false;
    private static Hashtable O00000Oo = new Hashtable();

    public static class Unavailable extends UtilEvalError {
        public Unavailable(String str) {
            super(str);
        }
    }

    public static boolean O000000o() {
        return O000000o("javax.swing.JButton");
    }

    public static boolean O000000o(String str) {
        Object obj = O00000Oo.get(str);
        if (obj == null) {
            try {
                obj = Class.forName(str);
            } catch (ClassNotFoundException unused) {
            }
            if (obj != null) {
                O00000Oo.put(obj, "unused");
            }
        }
        return obj != null;
    }

    public static boolean O00000Oo() {
        return O000000o("java.lang.reflect.Proxy");
    }

    public static boolean O00000o0() {
        return f3061O000000o;
    }
}
