package _m_j;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class asu {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000Oo f12575O000000o = null;
    public O00000o0 O00000Oo = null;
    public O0000OOo O00000o = null;
    public O0000Oo O00000o0 = null;
    public O0000Oo0 O00000oO = null;
    public O0000O0o O00000oo = null;
    public O00000o O0000O0o = null;

    public static <T> HashSet<T> O000000o(T[] tArr) {
        HashSet<T> hashSet = new HashSet<>();
        if (tArr != null) {
            for (T add : tArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public static <T> HashSet<T> O000000o(Set<T> set, T[] tArr) {
        HashSet<T> hashSet = new HashSet<>();
        if (set != null) {
            hashSet.addAll(set);
        }
        if (tArr != null) {
            for (T add : tArr) {
                hashSet.add(add);
            }
        }
        return hashSet;
    }

    public static <T> Iterable<T> O00000Oo(T[] tArr) {
        return new O000000o(tArr);
    }

    static final class O000000o<T> implements Iterable<T>, Iterator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final T[] f12576O000000o;
        private int O00000Oo = 0;

        public final Iterator<T> iterator() {
            return this;
        }

        public O000000o(T[] tArr) {
            this.f12576O000000o = tArr;
        }

        public final boolean hasNext() {
            return this.O00000Oo < this.f12576O000000o.length;
        }

        public final T next() {
            int i = this.O00000Oo;
            T[] tArr = this.f12576O000000o;
            if (i < tArr.length) {
                this.O00000Oo = i + 1;
                return tArr[i];
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class O00000Oo extends atd<boolean[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new boolean[i];
        }
    }

    public static final class O00000o0 extends atd<byte[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new byte[i];
        }
    }

    public static final class O0000Oo extends atd<short[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new short[i];
        }
    }

    public static final class O0000OOo extends atd<int[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new int[i];
        }
    }

    public static final class O0000Oo0 extends atd<long[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new long[i];
        }
    }

    public static final class O0000O0o extends atd<float[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new float[i];
        }
    }

    public static final class O00000o extends atd<double[]> {
        public final /* bridge */ /* synthetic */ Object O000000o(int i) {
            return new double[i];
        }
    }
}
