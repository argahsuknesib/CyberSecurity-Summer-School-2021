package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;

@GwtCompatible(emulated = true)
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    /* access modifiers changed from: package-private */
    public abstract ContiguousSet<C> headSetImpl(C c, boolean z);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    /* access modifiers changed from: package-private */
    public abstract ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract ContiguousSet<C> tailSetImpl(C c, boolean z);

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(discreteDomain.minValue())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            return intersection.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0 ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(intersection, discreteDomain);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Beta
    public static ContiguousSet<Integer> closed(int i, int i2) {
        return create(Range.closed(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Long> closed(long j, long j2) {
        return create(Range.closed(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    @Beta
    public static ContiguousSet<Integer> closedOpen(int i, int i2) {
        return create(Range.closedOpen(Integer.valueOf(i), Integer.valueOf(i2)), DiscreteDomain.integers());
    }

    @Beta
    public static ContiguousSet<Long> closedOpen(long j, long j2) {
        return create(Range.closedOpen(Long.valueOf(j), Long.valueOf(j2)), DiscreteDomain.longs());
    }

    ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ContiguousSet.headSetImpl(java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C>
     arg types: [java.lang.Comparable, int]
     candidates:
      com.google.common.collect.ContiguousSet.headSetImpl(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet
      com.google.common.collect.ImmutableSortedSet.headSetImpl(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ContiguousSet.headSetImpl(java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C> */
    public ContiguousSet<C> headSet(C c) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c), false);
    }

    @GwtIncompatible
    public ContiguousSet<C> headSet(C c, boolean z) {
        return headSetImpl((Comparable) Preconditions.checkNotNull(c), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ContiguousSet.subSetImpl(java.lang.Comparable, boolean, java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C>
     arg types: [C, int, C, int]
     candidates:
      com.google.common.collect.ContiguousSet.subSetImpl(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet
      com.google.common.collect.ImmutableSortedSet.subSetImpl(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ContiguousSet.subSetImpl(java.lang.Comparable, boolean, java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C> */
    public ContiguousSet<C> subSet(C c, C c2) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(c2);
        Preconditions.checkArgument(comparator().compare(c, c2) <= 0);
        return subSetImpl((Comparable) c, true, (Comparable) c2, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ContiguousSet.subSetImpl(java.lang.Comparable, boolean, java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C>
     arg types: [C, boolean, C, boolean]
     candidates:
      com.google.common.collect.ContiguousSet.subSetImpl(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet
      com.google.common.collect.ImmutableSortedSet.subSetImpl(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ContiguousSet.subSetImpl(java.lang.Comparable, boolean, java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C> */
    @GwtIncompatible
    public ContiguousSet<C> subSet(C c, boolean z, C c2, boolean z2) {
        Preconditions.checkNotNull(c);
        Preconditions.checkNotNull(c2);
        Preconditions.checkArgument(comparator().compare(c, c2) <= 0);
        return subSetImpl((Comparable) c, z, (Comparable) c2, z2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ContiguousSet.tailSetImpl(java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C>
     arg types: [java.lang.Comparable, int]
     candidates:
      com.google.common.collect.ContiguousSet.tailSetImpl(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet
      com.google.common.collect.ImmutableSortedSet.tailSetImpl(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ContiguousSet.tailSetImpl(java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet<C> */
    public ContiguousSet<C> tailSet(C c) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c), true);
    }

    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c, boolean z) {
        return tailSetImpl((Comparable) Preconditions.checkNotNull(c), z);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public ImmutableSortedSet<C> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    public String toString() {
        return range().toString();
    }

    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }
}
