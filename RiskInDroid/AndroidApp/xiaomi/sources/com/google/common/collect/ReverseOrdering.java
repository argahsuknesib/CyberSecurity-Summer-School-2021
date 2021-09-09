package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(ordering);
    }

    public final int compare(T t, T t2) {
        return this.forwardOrder.compare(t2, t);
    }

    public final <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public final <E extends T> E min(E e, E e2) {
        return this.forwardOrder.max(e, e2);
    }

    public final <E extends T> E min(E e, E e2, E e3, E... eArr) {
        return this.forwardOrder.max(e, e2, e3, eArr);
    }

    public final <E extends T> E min(Iterator<E> it) {
        return this.forwardOrder.max(it);
    }

    public final <E extends T> E min(Iterable<E> iterable) {
        return this.forwardOrder.max(iterable);
    }

    public final <E extends T> E max(E e, E e2) {
        return this.forwardOrder.min(e, e2);
    }

    public final <E extends T> E max(E e, E e2, E e3, E... eArr) {
        return this.forwardOrder.min(e, e2, e3, eArr);
    }

    public final <E extends T> E max(Iterator<E> it) {
        return this.forwardOrder.min(it);
    }

    public final <E extends T> E max(Iterable<E> iterable) {
        return this.forwardOrder.min(iterable);
    }

    public final int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public final String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
