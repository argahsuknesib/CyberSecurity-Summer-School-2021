package _m_j;

public final class aih {

    public static abstract class O00000Oo extends aig<Object> {
    }

    public static abstract class O000000o<T> extends aig<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final Class<?> f12387O000000o;

        protected O000000o(Class<?> cls) {
            this.f12387O000000o = cls;
        }

        public final Class<?> O000000o() {
            return this.f12387O000000o;
        }

        public boolean O000000o(aig<?> aig) {
            return aig.getClass() == getClass() && aig.O000000o() == this.f12387O000000o;
        }
    }

    public static abstract class O00000o0 extends O000000o<Object> {
        public final /* bridge */ /* synthetic */ boolean O000000o(aig aig) {
            return super.O000000o((aig<?>) aig);
        }

        protected O00000o0(Class<?> cls) {
            super(cls);
        }
    }
}
