package _m_j;

public final class o0O0o000<E> implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f2242O000000o = new Object();
    public boolean O00000Oo;
    public Object[] O00000o;
    public long[] O00000o0;
    public int O00000oO;

    public o0O0o000() {
        this(10);
    }

    public o0O0o000(int i) {
        this.O00000Oo = false;
        if (i == 0) {
            this.O00000o0 = o0O0Oo00.O00000Oo;
            this.O00000o = o0O0Oo00.O00000o0;
            return;
        }
        int O00000Oo2 = o0O0Oo00.O00000Oo(i);
        this.O00000o0 = new long[O00000Oo2];
        this.O00000o = new Object[O00000Oo2];
    }

    /* renamed from: O000000o */
    public final o0O0o000<E> clone() {
        try {
            o0O0o000<E> o0o0o000 = (o0O0o000) super.clone();
            o0o0o000.O00000o0 = (long[]) this.O00000o0.clone();
            o0o0o000.O00000o = (Object[]) this.O00000o.clone();
            return o0o0o000;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final E O000000o(long j, E e) {
        int O000000o2 = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, j);
        if (O000000o2 >= 0) {
            E[] eArr = this.O00000o;
            if (eArr[O000000o2] != f2242O000000o) {
                return eArr[O000000o2];
            }
        }
        return e;
    }

    public final void O000000o(int i) {
        Object[] objArr = this.O00000o;
        Object obj = objArr[i];
        Object obj2 = f2242O000000o;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.O00000Oo = true;
        }
    }

    public final void O00000Oo() {
        int i = this.O00000oO;
        long[] jArr = this.O00000o0;
        Object[] objArr = this.O00000o;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2242O000000o) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.O00000Oo = false;
        this.O00000oO = i2;
    }

    public final void O00000Oo(long j, E e) {
        int O000000o2 = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, j);
        if (O000000o2 >= 0) {
            this.O00000o[O000000o2] = e;
            return;
        }
        int i = O000000o2 ^ -1;
        if (i < this.O00000oO) {
            Object[] objArr = this.O00000o;
            if (objArr[i] == f2242O000000o) {
                this.O00000o0[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.O00000Oo && this.O00000oO >= this.O00000o0.length) {
            O00000Oo();
            i = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, j) ^ -1;
        }
        int i2 = this.O00000oO;
        if (i2 >= this.O00000o0.length) {
            int O00000Oo2 = o0O0Oo00.O00000Oo(i2 + 1);
            long[] jArr = new long[O00000Oo2];
            Object[] objArr2 = new Object[O00000Oo2];
            long[] jArr2 = this.O00000o0;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.O00000o;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.O00000o0 = jArr;
            this.O00000o = objArr2;
        }
        int i3 = this.O00000oO;
        if (i3 - i != 0) {
            long[] jArr3 = this.O00000o0;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.O00000o;
            System.arraycopy(objArr4, i, objArr4, i4, this.O00000oO - i);
        }
        this.O00000o0[i] = j;
        this.O00000o[i] = e;
        this.O00000oO++;
    }

    public final int O00000o0() {
        if (this.O00000Oo) {
            O00000Oo();
        }
        return this.O00000oO;
    }

    public final long O00000Oo(int i) {
        if (this.O00000Oo) {
            O00000Oo();
        }
        return this.O00000o0[i];
    }

    public final E O00000o0(int i) {
        if (this.O00000Oo) {
            O00000Oo();
        }
        return this.O00000o[i];
    }

    public final void O00000o() {
        int i = this.O00000oO;
        Object[] objArr = this.O00000o;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.O00000oO = 0;
        this.O00000Oo = false;
    }

    public final void O00000o0(long j, E e) {
        int i = this.O00000oO;
        if (i == 0 || j > this.O00000o0[i - 1]) {
            if (this.O00000Oo && this.O00000oO >= this.O00000o0.length) {
                O00000Oo();
            }
            int i2 = this.O00000oO;
            if (i2 >= this.O00000o0.length) {
                int O00000Oo2 = o0O0Oo00.O00000Oo(i2 + 1);
                long[] jArr = new long[O00000Oo2];
                Object[] objArr = new Object[O00000Oo2];
                long[] jArr2 = this.O00000o0;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.O00000o;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.O00000o0 = jArr;
                this.O00000o = objArr;
            }
            this.O00000o0[i2] = j;
            this.O00000o[i2] = e;
            this.O00000oO = i2 + 1;
            return;
        }
        O00000Oo(j, e);
    }

    public final String toString() {
        if (O00000o0() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.O00000oO * 28);
        sb.append('{');
        for (int i = 0; i < this.O00000oO; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(O00000Oo(i));
            sb.append('=');
            Object O00000o02 = O00000o0(i);
            if (O00000o02 != this) {
                sb.append(O00000o02);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
