package _m_j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class fcd {
    private static volatile fcd O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public AtomicBoolean f16075O000000o = new AtomicBoolean(false);
    private final List<Object> O00000o0 = Collections.synchronizedList(new ArrayList());

    private fcd() {
    }

    public static fcd O000000o() {
        if (O00000Oo == null) {
            synchronized (fcd.class) {
                if (O00000Oo == null) {
                    O00000Oo = new fcd();
                }
            }
        }
        return O00000Oo;
    }
}
