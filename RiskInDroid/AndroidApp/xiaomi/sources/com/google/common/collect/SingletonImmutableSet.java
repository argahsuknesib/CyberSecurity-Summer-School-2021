package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    @LazyInit
    private transient int cachedHashCode;
    final transient E element;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    public final int size() {
        return 1;
    }

    SingletonImmutableSet(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    SingletonImmutableSet(E e, int i) {
        this.element = e;
        this.cachedHashCode = i;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
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
    public final boolean contains(java.lang.Object r2) {
        /*
            r1 = this;
            E r0 = r1.element
            boolean r2 = r0.equals(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.SingletonImmutableSet.contains(java.lang.Object):boolean");
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<E> createAsList() {
        return ImmutableList.of(this.element);
    }

    /* access modifiers changed from: package-private */
    public final int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.cachedHashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.element.hashCode();
        this.cachedHashCode = hashCode;
        return hashCode;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    public final String toString() {
        return "[" + this.element.toString() + ']';
    }
}
