package _m_j;

import java.util.Arrays;

public final class jar {
    public static boolean O000000o(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? obj == obj2 : (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) ? obj.equals(obj2) : Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    public static boolean O00000Oo(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static String O000000o(Object obj) {
        return obj == null ? "null" : obj.toString();
    }
}
