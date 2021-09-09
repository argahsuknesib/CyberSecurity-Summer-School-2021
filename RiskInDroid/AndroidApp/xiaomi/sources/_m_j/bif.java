package _m_j;

public class bif<K, V> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final O000000o<K, V>[] f12991O000000o;
    private final int O00000Oo;

    public bif() {
        this(1024);
    }

    public bif(int i) {
        this.O00000Oo = 1023;
        this.f12991O000000o = new O000000o[1024];
    }

    public final V O000000o(Object obj) {
        for (O000000o<K, V> o000000o = this.f12991O000000o[System.identityHashCode(obj) & this.O00000Oo]; o000000o != null; o000000o = o000000o.O00000o) {
            if (obj == o000000o.O00000Oo) {
                return o000000o.O00000o0;
            }
        }
        return null;
    }

    public final boolean O000000o(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i = this.O00000Oo & identityHashCode;
        for (O000000o<K, V> o000000o = this.f12991O000000o[i]; o000000o != null; o000000o = o000000o.O00000o) {
            if (k == o000000o.O00000Oo) {
                o000000o.O00000o0 = v;
                return true;
            }
        }
        this.f12991O000000o[i] = new O000000o<>(k, v, identityHashCode, this.f12991O000000o[i]);
        return false;
    }

    public static final class O000000o<K, V> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f12992O000000o;
        public final K O00000Oo;
        public final O000000o<K, V> O00000o;
        public V O00000o0;

        public O000000o(K k, V v, int i, O000000o<K, V> o000000o) {
            this.O00000Oo = k;
            this.O00000o0 = v;
            this.O00000o = o000000o;
            this.f12992O000000o = i;
        }
    }
}
