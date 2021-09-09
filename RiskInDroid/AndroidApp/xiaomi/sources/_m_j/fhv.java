package _m_j;

final class fhv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final long f16389O000000o = Runtime.getRuntime().maxMemory();

    static int O000000o(int i) {
        int i2 = 1;
        if (i > 127) {
            int i3 = 1;
            while (true) {
                i >>>= 8;
                if (i == 0) {
                    break;
                }
                i3++;
            }
            for (int i4 = (i3 - 1) * 8; i4 >= 0; i4 -= 8) {
                i2++;
            }
        }
        return i2;
    }
}
