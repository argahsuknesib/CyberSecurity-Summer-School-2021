package _m_j;

public final class o0OO00o0<E> implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f2248O000000o = new Object();
    private boolean O00000Oo;
    private Object[] O00000o;
    private int[] O00000o0;
    private int O00000oO;

    public o0OO00o0() {
        this(10);
    }

    public o0OO00o0(int i) {
        this.O00000Oo = false;
        if (i == 0) {
            this.O00000o0 = o0O0Oo00.f2241O000000o;
            this.O00000o = o0O0Oo00.O00000o0;
            return;
        }
        int O000000o2 = o0O0Oo00.O000000o(i);
        this.O00000o0 = new int[O000000o2];
        this.O00000o = new Object[O000000o2];
    }

    /* renamed from: O000000o */
    public final o0OO00o0<E> clone() {
        try {
            o0OO00o0<E> o0oo00o0 = (o0OO00o0) super.clone();
            o0oo00o0.O00000o0 = (int[]) this.O00000o0.clone();
            o0oo00o0.O00000o = (Object[]) this.O00000o.clone();
            return o0oo00o0;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final E O000000o(int i, E e) {
        int O000000o2 = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, i);
        if (O000000o2 >= 0) {
            E[] eArr = this.O00000o;
            if (eArr[O000000o2] != f2248O000000o) {
                return eArr[O000000o2];
            }
        }
        return e;
    }

    public final void O000000o(int i) {
        Object[] objArr;
        Object obj;
        int O000000o2 = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, i);
        if (O000000o2 >= 0 && (objArr = this.O00000o)[O000000o2] != (obj = f2248O000000o)) {
            objArr[O000000o2] = obj;
            this.O00000Oo = true;
        }
    }

    private void O00000o() {
        int i = this.O00000oO;
        int[] iArr = this.O00000o0;
        Object[] objArr = this.O00000o;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2248O000000o) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.O00000Oo = false;
        this.O00000oO = i2;
    }

    public final void O00000Oo(int i, E e) {
        int O000000o2 = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, i);
        if (O000000o2 >= 0) {
            this.O00000o[O000000o2] = e;
            return;
        }
        int i2 = O000000o2 ^ -1;
        if (i2 < this.O00000oO) {
            Object[] objArr = this.O00000o;
            if (objArr[i2] == f2248O000000o) {
                this.O00000o0[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.O00000Oo && this.O00000oO >= this.O00000o0.length) {
            O00000o();
            i2 = o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, i) ^ -1;
        }
        int i3 = this.O00000oO;
        if (i3 >= this.O00000o0.length) {
            int O000000o3 = o0O0Oo00.O000000o(i3 + 1);
            int[] iArr = new int[O000000o3];
            Object[] objArr2 = new Object[O000000o3];
            int[] iArr2 = this.O00000o0;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.O00000o;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.O00000o0 = iArr;
            this.O00000o = objArr2;
        }
        int i4 = this.O00000oO;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.O00000o0;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.O00000o;
            System.arraycopy(objArr4, i2, objArr4, i5, this.O00000oO - i2);
        }
        this.O00000o0[i2] = i;
        this.O00000o[i2] = e;
        this.O00000oO++;
    }

    public final int O00000Oo() {
        if (this.O00000Oo) {
            O00000o();
        }
        return this.O00000oO;
    }

    public final int O00000Oo(int i) {
        if (this.O00000Oo) {
            O00000o();
        }
        return this.O00000o0[i];
    }

    public final E O00000o0(int i) {
        if (this.O00000Oo) {
            O00000o();
        }
        return this.O00000o[i];
    }

    public final int O00000o(int i) {
        if (this.O00000Oo) {
            O00000o();
        }
        return o0O0Oo00.O000000o(this.O00000o0, this.O00000oO, i);
    }

    public final int O000000o(E e) {
        if (this.O00000Oo) {
            O00000o();
        }
        for (int i = 0; i < this.O00000oO; i++) {
            if (this.O00000o[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public final void O00000o0() {
        int i = this.O00000oO;
        Object[] objArr = this.O00000o;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.O00000oO = 0;
        this.O00000Oo = false;
    }

    public final void O00000o0(int i, E e) {
        int i2 = this.O00000oO;
        if (i2 == 0 || i > this.O00000o0[i2 - 1]) {
            if (this.O00000Oo && this.O00000oO >= this.O00000o0.length) {
                O00000o();
            }
            int i3 = this.O00000oO;
            if (i3 >= this.O00000o0.length) {
                int O000000o2 = o0O0Oo00.O000000o(i3 + 1);
                int[] iArr = new int[O000000o2];
                Object[] objArr = new Object[O000000o2];
                int[] iArr2 = this.O00000o0;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.O00000o;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.O00000o0 = iArr;
                this.O00000o = objArr;
            }
            this.O00000o0[i3] = i;
            this.O00000o[i3] = e;
            this.O00000oO = i3 + 1;
            return;
        }
        O00000Oo(i, e);
    }

    public final String toString() {
        if (O00000Oo() <= 0) {
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
