package androidx.core.util;

public final class Pools {

    public interface O000000o<T> {
        T acquire();

        boolean release(T t);
    }

    public static class SimplePool<T> implements O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Object[] f2841O000000o;
        private int O00000Oo;

        public SimplePool(int i) {
            if (i > 0) {
                this.f2841O000000o = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T acquire() {
            int i = this.O00000Oo;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            T[] tArr = this.f2841O000000o;
            T t = tArr[i2];
            tArr[i2] = null;
            this.O00000Oo = i - 1;
            return t;
        }

        public boolean release(T t) {
            boolean z;
            int i = 0;
            while (true) {
                if (i >= this.O00000Oo) {
                    z = false;
                    break;
                } else if (this.f2841O000000o[i] == t) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                int i2 = this.O00000Oo;
                Object[] objArr = this.f2841O000000o;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t;
                this.O00000Oo = i2 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class O00000Oo<T> extends SimplePool<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final Object f2840O000000o = new Object();

        public O00000Oo(int i) {
            super(i);
        }

        public final T acquire() {
            T acquire;
            synchronized (this.f2840O000000o) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public final boolean release(T t) {
            boolean release;
            synchronized (this.f2840O000000o) {
                release = super.release(t);
            }
            return release;
        }
    }
}
