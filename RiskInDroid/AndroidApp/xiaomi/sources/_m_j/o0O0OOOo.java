package _m_j;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class o0O0OOOo<E> implements Collection<E>, Set<E> {
    private static final Object[] O00000o = new Object[0];
    private static final int[] O00000o0 = new int[0];
    private static Object[] O00000oO;
    private static int O00000oo;
    private static Object[] O0000O0o;
    private static int O0000OOo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Object[] f2239O000000o;
    int O00000Oo;
    private o0OO000o<E, E> O0000Oo;
    private int[] O0000Oo0;

    private int O000000o(Object obj, int i) {
        int i2 = this.O00000Oo;
        if (i2 == 0) {
            return -1;
        }
        int O000000o2 = o0O0Oo00.O000000o(this.O0000Oo0, i2, i);
        if (O000000o2 < 0 || obj.equals(this.f2239O000000o[O000000o2])) {
            return O000000o2;
        }
        int i3 = O000000o2 + 1;
        while (i3 < i2 && this.O0000Oo0[i3] == i) {
            if (obj.equals(this.f2239O000000o[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = O000000o2 - 1;
        while (i4 >= 0 && this.O0000Oo0[i4] == i) {
            if (obj.equals(this.f2239O000000o[i4])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int O000000o() {
        int i = this.O00000Oo;
        if (i == 0) {
            return -1;
        }
        int O000000o2 = o0O0Oo00.O000000o(this.O0000Oo0, i, 0);
        if (O000000o2 < 0 || this.f2239O000000o[O000000o2] == null) {
            return O000000o2;
        }
        int i2 = O000000o2 + 1;
        while (i2 < i && this.O0000Oo0[i2] == 0) {
            if (this.f2239O000000o[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = O000000o2 - 1;
        while (i3 >= 0 && this.O0000Oo0[i3] == 0) {
            if (this.f2239O000000o[i3] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void O00000Oo(int i) {
        if (i == 8) {
            synchronized (o0O0OOOo.class) {
                if (O0000O0o != null) {
                    Object[] objArr = O0000O0o;
                    this.f2239O000000o = objArr;
                    O0000O0o = (Object[]) objArr[0];
                    this.O0000Oo0 = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    O0000OOo--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (o0O0OOOo.class) {
                if (O00000oO != null) {
                    Object[] objArr2 = O00000oO;
                    this.f2239O000000o = objArr2;
                    O00000oO = (Object[]) objArr2[0];
                    this.O0000Oo0 = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    O00000oo--;
                    return;
                }
            }
        }
        this.O0000Oo0 = new int[i];
        this.f2239O000000o = new Object[i];
    }

    private static void O000000o(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (o0O0OOOo.class) {
                if (O0000OOo < 10) {
                    objArr[0] = O0000O0o;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    O0000O0o = objArr;
                    O0000OOo++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (o0O0OOOo.class) {
                if (O00000oo < 10) {
                    objArr[0] = O00000oO;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    O00000oO = objArr;
                    O00000oo++;
                }
            }
        }
    }

    public o0O0OOOo() {
        this(0);
    }

    public o0O0OOOo(int i) {
        if (i == 0) {
            this.O0000Oo0 = O00000o0;
            this.f2239O000000o = O00000o;
        } else {
            O00000Oo(i);
        }
        this.O00000Oo = 0;
    }

    public final void clear() {
        int i = this.O00000Oo;
        if (i != 0) {
            O000000o(this.O0000Oo0, this.f2239O000000o, i);
            this.O0000Oo0 = O00000o0;
            this.f2239O000000o = O00000o;
            this.O00000Oo = 0;
        }
    }

    public final boolean contains(Object obj) {
        return O000000o(obj) >= 0;
    }

    public final int O000000o(Object obj) {
        return obj == null ? O000000o() : O000000o(obj, obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.O00000Oo <= 0;
    }

    public final boolean add(E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = O000000o();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = O000000o(e, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = i2 ^ -1;
        int i4 = this.O00000Oo;
        if (i4 >= this.O0000Oo0.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.O0000Oo0;
            Object[] objArr = this.f2239O000000o;
            O00000Oo(i5);
            int[] iArr2 = this.O0000Oo0;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2239O000000o, 0, objArr.length);
            }
            O000000o(iArr, objArr, this.O00000Oo);
        }
        int i6 = this.O00000Oo;
        if (i3 < i6) {
            int[] iArr3 = this.O0000Oo0;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f2239O000000o;
            System.arraycopy(objArr2, i3, objArr2, i7, this.O00000Oo - i3);
        }
        this.O0000Oo0[i3] = i;
        this.f2239O000000o[i3] = e;
        this.O00000Oo++;
        return true;
    }

    public final boolean remove(Object obj) {
        int O000000o2 = O000000o(obj);
        if (O000000o2 < 0) {
            return false;
        }
        O000000o(O000000o2);
        return true;
    }

    public final E O000000o(int i) {
        E[] eArr = this.f2239O000000o;
        E e = eArr[i];
        int i2 = this.O00000Oo;
        if (i2 <= 1) {
            O000000o(this.O0000Oo0, eArr, i2);
            this.O0000Oo0 = O00000o0;
            this.f2239O000000o = O00000o;
            this.O00000Oo = 0;
        } else {
            int[] iArr = this.O0000Oo0;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                this.O00000Oo--;
                int i4 = this.O00000Oo;
                if (i < i4) {
                    int[] iArr2 = this.O0000Oo0;
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, iArr2, i, i4 - i);
                    Object[] objArr = this.f2239O000000o;
                    System.arraycopy(objArr, i5, objArr, i, this.O00000Oo - i);
                }
                this.f2239O000000o[this.O00000Oo] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                int[] iArr3 = this.O0000Oo0;
                Object[] objArr2 = this.f2239O000000o;
                O00000Oo(i3);
                this.O00000Oo--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.O0000Oo0, 0, i);
                    System.arraycopy(objArr2, 0, this.f2239O000000o, 0, i);
                }
                int i6 = this.O00000Oo;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.O0000Oo0, i, i6 - i);
                    System.arraycopy(objArr2, i7, this.f2239O000000o, i, this.O00000Oo - i);
                }
            }
        }
        return e;
    }

    public final int size() {
        return this.O00000Oo;
    }

    public final Object[] toArray() {
        int i = this.O00000Oo;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f2239O000000o, 0, objArr, 0, i);
        return objArr;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.O00000Oo) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.O00000Oo);
        }
        System.arraycopy(this.f2239O000000o, 0, tArr, 0, this.O00000Oo);
        int length = tArr.length;
        int i = this.O00000Oo;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.O00000Oo) {
                try {
                    if (!set.contains(this.f2239O000000o[i])) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.O0000Oo0;
        int i = this.O00000Oo;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.O00000Oo * 14);
        sb.append('{');
        for (int i = 0; i < this.O00000Oo; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.f2239O000000o[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int size = this.O00000Oo + collection.size();
        int[] iArr = this.O0000Oo0;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f2239O000000o;
            O00000Oo(size);
            int i = this.O00000Oo;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.O0000Oo0, 0, i);
                System.arraycopy(objArr, 0, this.f2239O000000o, 0, this.O00000Oo);
            }
            O000000o(iArr, objArr, this.O00000Oo);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.O00000Oo - 1; i >= 0; i--) {
            if (!collection.contains(this.f2239O000000o[i])) {
                O000000o(i);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new o0OO000o<E, E>() {
                /* class _m_j.o0O0OOOo.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final int O000000o() {
                    return o0O0OOOo.this.O00000Oo;
                }

                /* access modifiers changed from: protected */
                public final Object O000000o(int i, int i2) {
                    return o0O0OOOo.this.f2239O000000o[i];
                }

                /* access modifiers changed from: protected */
                public final int O000000o(Object obj) {
                    return o0O0OOOo.this.O000000o(obj);
                }

                /* access modifiers changed from: protected */
                public final int O00000Oo(Object obj) {
                    return o0O0OOOo.this.O000000o(obj);
                }

                /* access modifiers changed from: protected */
                public final Map<E, E> O00000Oo() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public final void O000000o(E e, E e2) {
                    o0O0OOOo.this.add(e);
                }

                /* access modifiers changed from: protected */
                public final E O000000o(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                public final void O000000o(int i) {
                    o0O0OOOo.this.O000000o(i);
                }

                /* access modifiers changed from: protected */
                public final void O00000o0() {
                    o0O0OOOo.this.clear();
                }
            };
        }
        return this.O0000Oo.O00000o().iterator();
    }
}
