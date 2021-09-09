package _m_j;

import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicReference;

public interface isr {
    InetAddress[] O000000o();

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static volatile isr f1607O000000o;
        private static final AtomicReference<C0006O000000o> O00000Oo = new AtomicReference<>();

        /* renamed from: _m_j.isr$O000000o$O000000o  reason: collision with other inner class name */
        public interface C0006O000000o {
            isr O000000o();
        }

        private O000000o() {
        }

        public static isr O000000o() {
            if (f1607O000000o == null) {
                synchronized (O000000o.class) {
                    if (f1607O000000o == null) {
                        isr isr = null;
                        C0006O000000o o000000o = O00000Oo.get();
                        if (o000000o != null) {
                            isr = o000000o.O000000o();
                        }
                        if (isr == null) {
                            isr = new ite();
                        }
                        f1607O000000o = isr;
                    }
                }
            }
            return f1607O000000o;
        }
    }
}
