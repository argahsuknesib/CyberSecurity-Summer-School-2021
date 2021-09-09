package _m_j;

public class dzg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile dzg f15094O000000o;

    public static dzg O000000o() {
        if (f15094O000000o == null) {
            synchronized (dzg.class) {
                if (f15094O000000o == null) {
                    f15094O000000o = new dzg();
                }
            }
        }
        return f15094O000000o;
    }

    public static void O000000o(Runnable runnable) {
        goq.O000000o(runnable);
    }

    public static void O000000o(Runnable runnable, long j) {
        goq.O000000o(runnable, j);
    }
}
