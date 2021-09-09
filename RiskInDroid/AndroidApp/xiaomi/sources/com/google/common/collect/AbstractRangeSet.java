package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.RangeSet;
import java.lang.Comparable;

@GwtIncompatible
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    public /* synthetic */ void addAll(Iterable<Range<C>> iterable) {
        RangeSet.CC.$default$addAll(this, iterable);
    }

    public abstract boolean encloses(Range<C> range);

    public /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return RangeSet.CC.$default$enclosesAll(this, iterable);
    }

    public abstract Range<C> rangeContaining(C c);

    public /* synthetic */ void removeAll(Iterable iterable) {
        RangeSet.CC.$default$removeAll(this, iterable);
    }

    AbstractRangeSet() {
    }

    public boolean contains(C c) {
        return rangeContaining(c) != null;
    }

    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean enclosesAll(RangeSet rangeSet) {
        return enclosesAll(rangeSet.asRanges());
    }

    public void addAll(RangeSet<C> rangeSet) {
        addAll(rangeSet.asRanges());
    }

    public void removeAll(RangeSet<C> rangeSet) {
        removeAll(rangeSet.asRanges());
    }

    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return asRanges().equals(((RangeSet) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public final String toString() {
        return asRanges().toString();
    }
}
