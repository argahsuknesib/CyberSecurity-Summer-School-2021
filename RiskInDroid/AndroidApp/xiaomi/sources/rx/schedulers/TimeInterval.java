package rx.schedulers;

public class TimeInterval<T> {
    private final long intervalInMilliseconds;
    private final T value;

    public TimeInterval(long j, T t) {
        this.value = t;
        this.intervalInMilliseconds = j;
    }

    public long getIntervalInMilliseconds() {
        return this.intervalInMilliseconds;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        long j = this.intervalInMilliseconds;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.value;
        return i + (t == null ? 0 : t.hashCode());
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
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r7 != r8) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r8 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r7.getClass()
            java.lang.Class r3 = r8.getClass()
            if (r2 == r3) goto L_0x0013
            return r1
        L_0x0013:
            rx.schedulers.TimeInterval r8 = (rx.schedulers.TimeInterval) r8
            long r2 = r7.intervalInMilliseconds
            long r4 = r8.intervalInMilliseconds
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x001e
            return r1
        L_0x001e:
            T r2 = r7.value
            if (r2 != 0) goto L_0x0027
            T r8 = r8.value
            if (r8 == 0) goto L_0x0030
            return r1
        L_0x0027:
            T r8 = r8.value
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L_0x0030
            return r1
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.schedulers.TimeInterval.equals(java.lang.Object):boolean");
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + ((Object) this.value) + "]";
    }
}
