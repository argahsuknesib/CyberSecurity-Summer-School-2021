package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;

@GwtCompatible(serializable = true)
final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    public final int compare(Object obj, Object obj2) {
        return 0;
    }

    public final <S> Ordering<S> reverse() {
        return this;
    }

    public final String toString() {
        return "Ordering.allEqual()";
    }

    AllEqualOrdering() {
    }

    public final <E> List<E> sortedCopy(Iterable<E> iterable) {
        return Lists.newArrayList(iterable);
    }

    public final <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.copyOf(iterable);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
