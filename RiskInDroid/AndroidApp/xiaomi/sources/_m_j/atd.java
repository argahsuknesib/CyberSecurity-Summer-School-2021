package _m_j;

public abstract class atd<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    T f12585O000000o;
    O000000o<T> O00000Oo;
    int O00000o;
    O000000o<T> O00000o0;

    /* access modifiers changed from: protected */
    public abstract T O000000o(int i);

    protected atd() {
    }

    public final T O000000o(T t, int i) {
        O000000o<T> o000000o = new O000000o<>(t, i);
        if (this.O00000Oo == null) {
            this.O00000o0 = o000000o;
            this.O00000Oo = o000000o;
        } else {
            O000000o<T> o000000o2 = this.O00000o0;
            if (o000000o2.O00000o0 == null) {
                o000000o2.O00000o0 = o000000o;
                this.O00000o0 = o000000o;
            } else {
                throw new IllegalStateException();
            }
        }
        this.O00000o += i;
        return O000000o(i < 16384 ? i + i : i + (i >> 2));
    }

    public final T O00000Oo(T t, int i) {
        int i2 = this.O00000o + i;
        T O000000o2 = O000000o(i2);
        int i3 = 0;
        for (O000000o<T> o000000o = this.O00000Oo; o000000o != null; o000000o = o000000o.O00000o0) {
            System.arraycopy(o000000o.f12586O000000o, 0, O000000o2, i3, o000000o.O00000Oo);
            i3 += o000000o.O00000Oo;
        }
        System.arraycopy(t, 0, O000000o2, i3, i);
        int i4 = i3 + i;
        if (i4 == i2) {
            return O000000o2;
        }
        throw new IllegalStateException("Should have gotten " + i2 + " entries, got " + i4);
    }

    static final class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final T f12586O000000o;
        final int O00000Oo;
        O000000o<T> O00000o0;

        public O000000o(T t, int i) {
            this.f12586O000000o = t;
            this.O00000Oo = i;
        }
    }

    public final T O000000o() {
        O000000o<T> o000000o = this.O00000o0;
        if (o000000o != null) {
            this.f12585O000000o = o000000o.f12586O000000o;
        }
        this.O00000o0 = null;
        this.O00000Oo = null;
        this.O00000o = 0;
        T t = this.f12585O000000o;
        return t == null ? O000000o(12) : t;
    }
}
