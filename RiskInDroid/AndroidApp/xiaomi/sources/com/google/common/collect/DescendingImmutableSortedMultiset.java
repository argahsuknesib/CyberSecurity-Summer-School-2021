package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Multiset;

@GwtIncompatible
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> forward;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    public final int count(Object obj) {
        return this.forward.count(obj);
    }

    public final Multiset.Entry<E> firstEntry() {
        return this.forward.lastEntry();
    }

    public final Multiset.Entry<E> lastEntry() {
        return this.forward.firstEntry();
    }

    public final int size() {
        return this.forward.size();
    }

    public final ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }

    /* access modifiers changed from: package-private */
    public final Multiset.Entry<E> getEntry(int i) {
        return this.forward.entrySet().asList().reverse().get(i);
    }

    public final ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E>
     arg types: [E, com.google.common.collect.BoundType]
     candidates:
      com.google.common.collect.ImmutableSortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset
      com.google.common.collect.SortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset<E>
      com.google.common.collect.ImmutableSortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E> */
    public final ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return this.forward.tailMultiset((Object) e, boundType).descendingMultiset();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E>
     arg types: [E, com.google.common.collect.BoundType]
     candidates:
      com.google.common.collect.ImmutableSortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset
      com.google.common.collect.SortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset<E>
      com.google.common.collect.ImmutableSortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E> */
    public final ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return this.forward.headMultiset((Object) e, boundType).descendingMultiset();
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return this.forward.isPartialView();
    }
}
