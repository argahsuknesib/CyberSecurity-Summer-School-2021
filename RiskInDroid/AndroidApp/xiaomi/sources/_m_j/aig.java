package _m_j;

public abstract class aig<T> {
    public abstract O000000o O000000o(Object obj);

    public abstract aig<T> O000000o(Class<?> cls);

    public abstract Class<?> O000000o();

    public abstract boolean O000000o(aig<?> aig);

    public abstract aig<T> O00000Oo();

    public abstract T O00000Oo(Object obj);

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Class<?> f12386O000000o;
        private final Class<?> O00000Oo;
        private final int O00000o;
        private final Object O00000o0;

        public O000000o(Class<?> cls, Class<?> cls2, Object obj) {
            this.f12386O000000o = cls;
            this.O00000Oo = cls2;
            this.O00000o0 = obj;
            int hashCode = obj.hashCode() + cls.getName().hashCode();
            this.O00000o = cls2 != null ? hashCode ^ cls2.getName().hashCode() : hashCode;
        }

        public final int hashCode() {
            return this.O00000o;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            return o000000o.O00000o0.equals(this.O00000o0) && o000000o.f12386O000000o == this.f12386O000000o && o000000o.O00000Oo == this.O00000Oo;
        }
    }
}
