package _m_j;

public final class jle {
    public static long O000000o(jha jha, jhd jhd, long j) {
        long j2;
        for (jgy next : jha.getBoxes()) {
            if (next == jhd) {
                return j;
            }
            if (next instanceof jha) {
                long O000000o2 = O000000o((jha) next, jhd, 0);
                if (O000000o2 > 0) {
                    return O000000o2 + j;
                }
                j2 = next.getSize();
            } else {
                j2 = next.getSize();
            }
            j += j2;
        }
        return -1;
    }
}
