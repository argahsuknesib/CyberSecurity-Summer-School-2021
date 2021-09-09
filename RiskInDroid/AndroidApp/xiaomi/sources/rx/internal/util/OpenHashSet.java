package rx.internal.util;

import java.util.Arrays;
import rx.functions.Action1;
import rx.internal.util.unsafe.Pow2;

public final class OpenHashSet<T> {
    T[] keys;
    final float loadFactor;
    int mask;
    int maxSize;
    int size;

    static int mix(int i) {
        int i2 = i * -1640531527;
        return i2 ^ (i2 >>> 16);
    }

    public OpenHashSet() {
        this(16, 0.75f);
    }

    public OpenHashSet(int i) {
        this(i, 0.75f);
    }

    public OpenHashSet(int i, float f) {
        this.loadFactor = f;
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = roundToPowerOfTwo - 1;
        this.maxSize = (int) (f * ((float) roundToPowerOfTwo));
        this.keys = (Object[]) new Object[roundToPowerOfTwo];
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
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
    public final boolean add(T r7) {
        /*
            r6 = this;
            T[] r0 = r6.keys
            int r1 = r6.mask
            int r2 = r7.hashCode()
            int r2 = mix(r2)
            r2 = r2 & r1
            r3 = r0[r2]
            r4 = 1
            if (r3 == 0) goto L_0x0027
            boolean r3 = r3.equals(r7)
            r5 = 0
            if (r3 == 0) goto L_0x001a
            return r5
        L_0x001a:
            int r2 = r2 + r4
            r2 = r2 & r1
            r3 = r0[r2]
            if (r3 == 0) goto L_0x0027
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x001a
            return r5
        L_0x0027:
            r0[r2] = r7
            int r7 = r6.size
            int r7 = r7 + r4
            r6.size = r7
            int r0 = r6.maxSize
            if (r7 < r0) goto L_0x0035
            r6.rehash()
        L_0x0035:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.OpenHashSet.add(java.lang.Object):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
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
    public final boolean remove(T r6) {
        /*
            r5 = this;
            T[] r0 = r5.keys
            int r1 = r5.mask
            int r2 = r6.hashCode()
            int r2 = mix(r2)
            r2 = r2 & r1
            r3 = r0[r2]
            r4 = 0
            if (r3 != 0) goto L_0x0013
            return r4
        L_0x0013:
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x001e
            boolean r6 = r5.removeEntry(r2, r0, r1)
            return r6
        L_0x001e:
            int r2 = r2 + 1
            r2 = r2 & r1
            r3 = r0[r2]
            if (r3 != 0) goto L_0x0026
            return r4
        L_0x0026:
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x001e
            boolean r6 = r5.removeEntry(r2, r0, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.OpenHashSet.remove(java.lang.Object):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean removeEntry(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.size--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int mix = mix(t.hashCode()) & i2;
                if (i <= i3) {
                    if (i >= mix || mix > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else {
                    if (i >= mix && mix > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public final void clear(Action1<? super T> action1) {
        if (this.size != 0) {
            T[] tArr = this.keys;
            for (T t : tArr) {
                if (t != null) {
                    action1.call(t);
                }
            }
            Arrays.fill(tArr, (Object) null);
            this.size = 0;
        }
    }

    public final void terminate() {
        this.size = 0;
        this.keys = (Object[]) new Object[0];
    }

    /* access modifiers changed from: package-private */
    public final void rehash() {
        T[] tArr = this.keys;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (Object[]) new Object[i];
        int i3 = this.size;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int mix = mix(tArr[length].hashCode()) & i2;
                if (tArr2[mix] != null) {
                    do {
                        mix = (mix + 1) & i2;
                    } while (tArr2[mix] != null);
                }
                tArr2[mix] = tArr[length];
                i3 = i4;
            } else {
                this.mask = i2;
                this.maxSize = (int) (((float) i) * this.loadFactor);
                this.keys = tArr2;
                return;
            }
        }
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final T[] values() {
        return this.keys;
    }
}
