package _m_j;

import java.lang.reflect.Array;
import java.util.List;

public final class atc {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f12583O000000o;
    private O000000o O00000Oo;
    private Object[] O00000o;
    private int O00000o0;

    public final Object[] O000000o() {
        O00000o0();
        Object[] objArr = this.O00000o;
        return objArr == null ? new Object[12] : objArr;
    }

    public final Object[] O000000o(Object[] objArr) {
        O000000o o000000o = new O000000o(objArr);
        if (this.f12583O000000o == null) {
            this.O00000Oo = o000000o;
            this.f12583O000000o = o000000o;
        } else {
            this.O00000Oo.O000000o(o000000o);
            this.O00000Oo = o000000o;
        }
        int length = objArr.length;
        this.O00000o0 += length;
        return new Object[(length < 16384 ? length + length : length + (length >> 2))];
    }

    public final Object[] O000000o(Object[] objArr, int i) {
        int i2 = this.O00000o0 + i;
        Object[] objArr2 = new Object[i2];
        O000000o(objArr2, i2, objArr, i);
        return objArr2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException}
     arg types: [java.lang.Class<T>, int]
     candidates:
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int[]):java.lang.Object VARARG throws java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException}
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException} */
    public final <T> T[] O000000o(Object[] objArr, int i, Class<T> cls) {
        int i2 = this.O00000o0 + i;
        T[] tArr = (Object[]) Array.newInstance((Class<?>) cls, i2);
        O000000o(tArr, i2, objArr, i);
        O00000o0();
        return tArr;
    }

    public final void O000000o(Object[] objArr, int i, List<Object> list) {
        int i2;
        O000000o o000000o = this.f12583O000000o;
        while (true) {
            i2 = 0;
            if (o000000o == null) {
                break;
            }
            Object[] objArr2 = o000000o.f12584O000000o;
            int length = objArr2.length;
            while (i2 < length) {
                list.add(objArr2[i2]);
                i2++;
            }
            o000000o = o000000o.O00000Oo;
        }
        while (i2 < i) {
            list.add(objArr[i2]);
            i2++;
        }
    }

    public final int O00000Oo() {
        Object[] objArr = this.O00000o;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    private void O00000o0() {
        O000000o o000000o = this.O00000Oo;
        if (o000000o != null) {
            this.O00000o = o000000o.f12584O000000o;
        }
        this.O00000Oo = null;
        this.f12583O000000o = null;
        this.O00000o0 = 0;
    }

    private void O000000o(Object obj, int i, Object[] objArr, int i2) {
        int i3 = 0;
        for (O000000o o000000o = this.f12583O000000o; o000000o != null; o000000o = o000000o.O00000Oo) {
            Object[] objArr2 = o000000o.f12584O000000o;
            int length = objArr2.length;
            System.arraycopy(objArr2, 0, obj, i3, length);
            i3 += length;
        }
        System.arraycopy(objArr, 0, obj, i3, i2);
        int i4 = i3 + i2;
        if (i4 != i) {
            throw new IllegalStateException("Should have gotten " + i + " entries, got " + i4);
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final Object[] f12584O000000o;
        O000000o O00000Oo;

        public O000000o(Object[] objArr) {
            this.f12584O000000o = objArr;
        }

        public final void O000000o(O000000o o000000o) {
            if (this.O00000Oo == null) {
                this.O00000Oo = o000000o;
                return;
            }
            throw new IllegalStateException();
        }
    }
}
