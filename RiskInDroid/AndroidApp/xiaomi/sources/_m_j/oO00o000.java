package _m_j;

final class oO00o000 {

    interface O000000o<T> {
        T O000000o();

        void O000000o(T[] tArr, int i);

        boolean O000000o(T t);
    }

    static class O00000Oo<T> implements O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Object[] f2279O000000o = new Object[256];
        private int O00000Oo;

        O00000Oo() {
        }

        public final T O000000o() {
            int i = this.O00000Oo;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f2279O000000o;
            T t = tArr[i2];
            tArr[i2] = null;
            this.O00000Oo = i - 1;
            return t;
        }

        public final boolean O000000o(T t) {
            int i = this.O00000Oo;
            Object[] objArr = this.f2279O000000o;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.O00000Oo = i + 1;
            return true;
        }

        public final void O000000o(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.O00000Oo;
                Object[] objArr = this.f2279O000000o;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.O00000Oo = i3 + 1;
                }
            }
        }
    }
}
