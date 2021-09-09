package _m_j;

public abstract class ati {
    public abstract boolean O000000o(Class<?> cls);

    public static final class O000000o extends ati {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f12591O000000o = new O000000o();

        public final boolean O000000o(Class<?> cls) {
            return false;
        }

        private O000000o() {
        }
    }

    public static final class O00000o0 extends ati {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Class<?> f12593O000000o;

        public O00000o0(Class<?> cls) {
            this.f12593O000000o = cls;
        }

        public final boolean O000000o(Class<?> cls) {
            Class<?> cls2 = this.f12593O000000o;
            return cls == cls2 || cls2.isAssignableFrom(cls);
        }
    }

    public static final class O00000Oo extends ati {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Class<?>[] f12592O000000o;

        public O00000Oo(Class<?>[] clsArr) {
            this.f12592O000000o = clsArr;
        }

        public final boolean O000000o(Class<?> cls) {
            for (Class<?> cls2 : this.f12592O000000o) {
                if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }
}
