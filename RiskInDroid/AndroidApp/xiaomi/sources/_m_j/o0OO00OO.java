package _m_j;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class o0OO00OO<K, V> {
    static Object[] O00000Oo;
    static Object[] O00000o;
    static int O00000o0;
    static int O00000oO;
    int[] O00000oo;
    Object[] O0000O0o;
    int O0000OOo;

    private static int O000000o(int[] iArr, int i, int i2) {
        try {
            return o0O0Oo00.O000000o(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private int O000000o(Object obj, int i) {
        int i2 = this.O0000OOo;
        if (i2 == 0) {
            return -1;
        }
        int O000000o2 = O000000o(this.O00000oo, i2, i);
        if (O000000o2 < 0 || obj.equals(this.O0000O0o[O000000o2 << 1])) {
            return O000000o2;
        }
        int i3 = O000000o2 + 1;
        while (i3 < i2 && this.O00000oo[i3] == i) {
            if (obj.equals(this.O0000O0o[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = O000000o2 - 1;
        while (i4 >= 0 && this.O00000oo[i4] == i) {
            if (obj.equals(this.O0000O0o[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private int O000000o() {
        int i = this.O0000OOo;
        if (i == 0) {
            return -1;
        }
        int O000000o2 = O000000o(this.O00000oo, i, 0);
        if (O000000o2 < 0 || this.O0000O0o[O000000o2 << 1] == null) {
            return O000000o2;
        }
        int i2 = O000000o2 + 1;
        while (i2 < i && this.O00000oo[i2] == 0) {
            if (this.O0000O0o[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = O000000o2 - 1;
        while (i3 >= 0 && this.O00000oo[i3] == 0) {
            if (this.O0000O0o[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return i2 ^ -1;
    }

    private void O00000oO(int i) {
        if (i == 8) {
            synchronized (o0OO00OO.class) {
                if (O00000o != null) {
                    Object[] objArr = O00000o;
                    this.O0000O0o = objArr;
                    O00000o = (Object[]) objArr[0];
                    this.O00000oo = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    O00000oO--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (o0OO00OO.class) {
                if (O00000Oo != null) {
                    Object[] objArr2 = O00000Oo;
                    this.O0000O0o = objArr2;
                    O00000Oo = (Object[]) objArr2[0];
                    this.O00000oo = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    O00000o0--;
                    return;
                }
            }
        }
        this.O00000oo = new int[i];
        this.O0000O0o = new Object[(i << 1)];
    }

    private static void O000000o(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (o0OO00OO.class) {
                if (O00000oO < 10) {
                    objArr[0] = O00000o;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    O00000o = objArr;
                    O00000oO++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (o0OO00OO.class) {
                if (O00000o0 < 10) {
                    objArr[0] = O00000Oo;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    O00000Oo = objArr;
                    O00000o0++;
                }
            }
        }
    }

    public o0OO00OO() {
        this.O00000oo = o0O0Oo00.f2241O000000o;
        this.O0000O0o = o0O0Oo00.O00000o0;
        this.O0000OOo = 0;
    }

    public o0OO00OO(int i) {
        if (i == 0) {
            this.O00000oo = o0O0Oo00.f2241O000000o;
            this.O0000O0o = o0O0Oo00.O00000o0;
        } else {
            O00000oO(i);
        }
        this.O0000OOo = 0;
    }

    public o0OO00OO(o0OO00OO o0oo00oo) {
        this();
        if (o0oo00oo != null) {
            int i = o0oo00oo.O0000OOo;
            O000000o(this.O0000OOo + i);
            if (this.O0000OOo != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    put(o0oo00oo.O00000Oo(i2), o0oo00oo.O00000o0(i2));
                }
            } else if (i > 0) {
                System.arraycopy(o0oo00oo.O00000oo, 0, this.O00000oo, 0, i);
                System.arraycopy(o0oo00oo.O0000O0o, 0, this.O0000O0o, 0, i << 1);
                this.O0000OOo = i;
            }
        }
    }

    public void clear() {
        int i = this.O0000OOo;
        if (i > 0) {
            int[] iArr = this.O00000oo;
            Object[] objArr = this.O0000O0o;
            this.O00000oo = o0O0Oo00.f2241O000000o;
            this.O0000O0o = o0O0Oo00.O00000o0;
            this.O0000OOo = 0;
            O000000o(iArr, objArr, i);
        }
        if (this.O0000OOo > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void O000000o(int i) {
        int i2 = this.O0000OOo;
        int[] iArr = this.O00000oo;
        if (iArr.length < i) {
            Object[] objArr = this.O0000O0o;
            O00000oO(i);
            if (this.O0000OOo > 0) {
                System.arraycopy(iArr, 0, this.O00000oo, 0, i2);
                System.arraycopy(objArr, 0, this.O0000O0o, 0, i2 << 1);
            }
            O000000o(iArr, objArr, i2);
        }
        if (this.O0000OOo != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return O000000o(obj) >= 0;
    }

    public final int O000000o(Object obj) {
        return obj == null ? O000000o() : O000000o(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo(Object obj) {
        int i = this.O0000OOo * 2;
        Object[] objArr = this.O0000O0o;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return O00000Oo(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int O000000o2 = O000000o(obj);
        return O000000o2 >= 0 ? this.O0000O0o[(O000000o2 << 1) + 1] : v;
    }

    public final K O00000Oo(int i) {
        return this.O0000O0o[i << 1];
    }

    public final V O00000o0(int i) {
        return this.O0000O0o[(i << 1) + 1];
    }

    public final V O000000o(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.O0000O0o;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public boolean isEmpty() {
        return this.O0000OOo <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.O0000OOo;
        if (k == null) {
            i2 = O000000o();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = O000000o(k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.O0000O0o;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = i2 ^ -1;
        if (i3 >= this.O00000oo.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.O00000oo;
            Object[] objArr = this.O0000O0o;
            O00000oO(i6);
            if (i3 == this.O0000OOo) {
                int[] iArr2 = this.O00000oo;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.O0000O0o, 0, objArr.length);
                }
                O000000o(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.O00000oo;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.O0000O0o;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.O0000OOo - i5) << 1);
        }
        int i8 = this.O0000OOo;
        if (i3 == i8) {
            int[] iArr4 = this.O00000oo;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.O0000O0o;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.O0000OOo = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int O000000o2 = O000000o(obj);
        if (O000000o2 >= 0) {
            return O00000o(O000000o2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int O000000o2 = O000000o(obj);
        if (O000000o2 < 0) {
            return false;
        }
        Object O00000o02 = O00000o0(O000000o2);
        if (obj2 != O00000o02 && (obj2 == null || !obj2.equals(O00000o02))) {
            return false;
        }
        O00000o(O000000o2);
        return true;
    }

    public final V O00000o(int i) {
        int i2;
        V[] vArr = this.O0000O0o;
        int i3 = i << 1;
        V v = vArr[i3 + 1];
        int i4 = this.O0000OOo;
        if (i4 <= 1) {
            O000000o(this.O00000oo, vArr, i4);
            this.O00000oo = o0O0Oo00.f2241O000000o;
            this.O0000O0o = o0O0Oo00.O00000o0;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.O00000oo;
            int i5 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i < i2) {
                    int[] iArr2 = this.O00000oo;
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, iArr2, i, i7);
                    Object[] objArr = this.O0000O0o;
                    System.arraycopy(objArr, i6 << 1, objArr, i3, i7 << 1);
                }
                Object[] objArr2 = this.O0000O0o;
                int i8 = i2 << 1;
                objArr2[i8] = null;
                objArr2[i8 + 1] = null;
            } else {
                if (i4 > 8) {
                    i5 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.O00000oo;
                Object[] objArr3 = this.O0000O0o;
                O00000oO(i5);
                if (i4 == this.O0000OOo) {
                    if (i > 0) {
                        System.arraycopy(iArr3, 0, this.O00000oo, 0, i);
                        System.arraycopy(objArr3, 0, this.O0000O0o, 0, i3);
                    }
                    if (i < i2) {
                        int i9 = i + 1;
                        int i10 = i2 - i;
                        System.arraycopy(iArr3, i9, this.O00000oo, i, i10);
                        System.arraycopy(objArr3, i9 << 1, this.O0000O0o, i3, i10 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (i4 == this.O0000OOo) {
            this.O0000OOo = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V replace(K k, V v) {
        int O000000o2 = O000000o(k);
        if (O000000o2 >= 0) {
            return O000000o(O000000o2, v);
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: V
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public boolean replace(K r2, V r3, V r4) {
        /*
            r1 = this;
            int r2 = r1.O000000o(r2)
            if (r2 < 0) goto L_0x0019
            java.lang.Object r0 = r1.O00000o0(r2)
            if (r0 == r3) goto L_0x0014
            if (r3 == 0) goto L_0x0019
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0019
        L_0x0014:
            r1.O000000o(r2, r4)
            r2 = 1
            return r2
        L_0x0019:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.o0OO00OO.replace(java.lang.Object, java.lang.Object, java.lang.Object):boolean");
    }

    public int size() {
        return this.O0000OOo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o0OO00OO) {
            o0OO00OO o0oo00oo = (o0OO00OO) obj;
            if (size() != o0oo00oo.size()) {
                return false;
            }
            int i = 0;
            while (i < this.O0000OOo) {
                try {
                    Object O00000Oo2 = O00000Oo(i);
                    Object O00000o02 = O00000o0(i);
                    Object obj2 = o0oo00oo.get(O00000Oo2);
                    if (O00000o02 == null) {
                        if (obj2 != null || !o0oo00oo.containsKey(O00000Oo2)) {
                            return false;
                        }
                    } else if (!O00000o02.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.O0000OOo) {
                try {
                    Object O00000Oo3 = O00000Oo(i2);
                    Object O00000o03 = O00000o0(i2);
                    Object obj3 = map.get(O00000Oo3);
                    if (O00000o03 == null) {
                        if (obj3 != null || !map.containsKey(O00000Oo3)) {
                            return false;
                        }
                    } else if (!O00000o03.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.O00000oo;
        Object[] objArr = this.O0000O0o;
        int i = this.O0000OOo;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.O0000OOo * 28);
        sb.append('{');
        for (int i = 0; i < this.O0000OOo; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object O00000Oo2 = O00000Oo(i);
            if (O00000Oo2 != this) {
                sb.append(O00000Oo2);
            } else {
                sb.append("(this Map)");
            }
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
