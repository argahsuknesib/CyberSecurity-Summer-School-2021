package _m_j;

public final class ixg {
    public static String O000000o(ixd ixd) {
        String obj = ixd.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
