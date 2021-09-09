package _m_j;

public final class gqj<T> implements gql {

    /* renamed from: O000000o  reason: collision with root package name */
    private T[] f18151O000000o;
    private int O00000Oo;

    private gqj(T[] tArr) {
        this.f18151O000000o = tArr;
        this.O00000Oo = -1;
    }

    public gqj(T[] tArr, byte b) {
        this(tArr);
    }

    public final String O000000o(int i) {
        if (i < 0) {
            return null;
        }
        T[] tArr = this.f18151O000000o;
        if (i < tArr.length) {
            return tArr[i].toString();
        }
        return null;
    }

    public final int O000000o() {
        return this.f18151O000000o.length;
    }

    public final int O00000Oo() {
        return this.O00000Oo;
    }
}
