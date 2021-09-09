package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0;
    private transient Ordering<Comparable> nullsFirst;
    private transient Ordering<Comparable> nullsLast;

    public final String toString() {
        return "Ordering.natural()";
    }

    public final int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = this.nullsFirst;
        if (ordering != null) {
            return ordering;
        }
        Ordering<S> nullsFirst2 = super.nullsFirst();
        this.nullsFirst = nullsFirst2;
        return nullsFirst2;
    }

    public final <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = this.nullsLast;
        if (ordering != null) {
            return ordering;
        }
        Ordering<S> nullsLast2 = super.nullsLast();
        this.nullsLast = nullsLast2;
        return nullsLast2;
    }

    public final <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private NaturalOrdering() {
    }
}
