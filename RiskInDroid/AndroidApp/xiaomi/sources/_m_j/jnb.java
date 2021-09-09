package _m_j;

public final class jnb {
    public static final void O000000o(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static final void O000000o(String str) {
        System.err.println("SLF4J: ".concat(String.valueOf(str)));
    }
}
