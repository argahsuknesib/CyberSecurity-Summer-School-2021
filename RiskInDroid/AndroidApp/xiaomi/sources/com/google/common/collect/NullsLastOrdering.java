package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    public final <S extends T> Ordering<S> nullsLast() {
        return this;
    }

    NullsLastOrdering(Ordering<? super T> ordering2) {
        this.ordering = ordering2;
    }

    public final int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.ordering.compare(t, t2);
    }

    public final <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public final <S extends T> Ordering<S> nullsFirst() {
        return this.ordering.nullsFirst();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsLastOrdering) {
            return this.ordering.equals(((NullsLastOrdering) obj).ordering);
        }
        return false;
    }

    public final int hashCode() {
        return this.ordering.hashCode() ^ -921210296;
    }

    public final String toString() {
        return this.ordering + ".nullsLast()";
    }
}
