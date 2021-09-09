package _m_j;

import java.util.HashMap;
import java.util.Map;

public class inb {
    private static inb O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, imy> f1491O000000o = new HashMap();

    public static inb O000000o() {
        if (O00000Oo == null) {
            synchronized (inb.class) {
                if (O00000Oo == null) {
                    O00000Oo = new inb();
                }
            }
        }
        return O00000Oo;
    }
}
