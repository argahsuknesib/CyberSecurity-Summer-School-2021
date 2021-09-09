package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;

@GwtCompatible
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    public final boolean isPresent() {
        return true;
    }

    Present(T t) {
        this.reference = t;
    }

    public final T get() {
        return this.reference;
    }

    public final T or(T t) {
        Preconditions.checkNotNull(t, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    public final Optional<T> or(Optional<? extends T> optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    public final T or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    public final T orNull() {
        return this.reference;
    }

    public final Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    public final <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.checkNotNull(function.apply(this.reference), "the Function passed to Optional.transform() must not return null."));
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
    public final boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof com.google.common.base.Present
            if (r0 == 0) goto L_0x000f
            com.google.common.base.Present r2 = (com.google.common.base.Present) r2
            T r0 = r1.reference
            T r2 = r2.reference
            boolean r2 = r0.equals(r2)
            return r2
        L_0x000f:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Present.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + ((Object) this.reference) + ")";
    }
}
