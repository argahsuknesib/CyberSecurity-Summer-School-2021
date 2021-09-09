package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;

@GwtCompatible(serializable = true)
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    ExplicitOrdering(List list) {
        this(Maps.indexMap(list));
    }

    ExplicitOrdering(ImmutableMap immutableMap) {
        this.rankMap = immutableMap;
    }

    public final int compare(T t, T t2) {
        return rank(t) - rank(t2);
    }

    private int rank(T t) {
        Integer num = this.rankMap.get(t);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    public final int hashCode() {
        return this.rankMap.hashCode();
    }

    public final String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }
}
