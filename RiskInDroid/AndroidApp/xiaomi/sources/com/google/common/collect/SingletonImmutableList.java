package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Spliterator;

@GwtCompatible(emulated = true, serializable = true)
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    public final int size() {
        return 1;
    }

    SingletonImmutableList(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    public final E get(int i) {
        Preconditions.checkElementIndex(i, 1);
        return this.element;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    public final Spliterator<E> spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    public final ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, 1);
        return i == i2 ? ImmutableList.of() : this;
    }

    public final String toString() {
        return "[" + this.element.toString() + ']';
    }
}
