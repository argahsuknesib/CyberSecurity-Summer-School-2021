package _m_j;

import java.util.concurrent.atomic.AtomicInteger;

public final class iim {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final AtomicInteger f1318O000000o = new AtomicInteger(1);

    public static int O000000o() {
        int i;
        int i2;
        do {
            i = f1318O000000o.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f1318O000000o.compareAndSet(i, i2));
        return i;
    }
}
