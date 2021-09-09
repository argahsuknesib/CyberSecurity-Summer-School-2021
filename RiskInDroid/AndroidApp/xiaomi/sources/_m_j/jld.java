package _m_j;

public final class jld {
    public static long O000000o(long j, long j2) {
        while (true) {
            long j3 = j;
            j = j2;
            long j4 = j3;
            if (j <= 0) {
                return j4;
            }
            j2 = j4 % j;
        }
    }

    public static long O00000Oo(long j, long j2) {
        return j * (j2 / O000000o(j, j2));
    }
}
