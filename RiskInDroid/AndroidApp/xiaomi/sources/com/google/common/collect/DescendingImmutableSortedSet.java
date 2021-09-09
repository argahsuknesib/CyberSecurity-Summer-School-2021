package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
final class DescendingImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    DescendingImmutableSortedSet(ImmutableSortedSet<E> immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    public final boolean contains(Object obj) {
        return this.forward.contains(obj);
    }

    public final int size() {
        return this.forward.size();
    }

    public final UnmodifiableIterator<E> iterator() {
        return this.forward.descendingIterator();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, boolean]
     candidates:
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return this.forward.tailSet((Object) e, z).descendingSet();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, boolean, E, boolean]
     candidates:
      com.google.common.collect.ImmutableSortedSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return this.forward.subSet((Object) e2, z2, (Object) e, z).descendingSet();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, boolean]
     candidates:
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.headSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return this.forward.headSet((Object) e, z).descendingSet();
    }

    @GwtIncompatible("NavigableSet")
    public final ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    @GwtIncompatible("NavigableSet")
    public final UnmodifiableIterator<E> descendingIterator() {
        return this.forward.iterator();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible("NavigableSet")
    public final ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    public final E lower(E e) {
        return this.forward.higher(e);
    }

    public final E floor(E e) {
        return this.forward.ceiling(e);
    }

    public final E ceiling(E e) {
        return this.forward.floor(e);
    }

    public final E higher(E e) {
        return this.forward.lower(e);
    }

    /* access modifiers changed from: package-private */
    public final int indexOf(Object obj) {
        int indexOf = this.forward.indexOf(obj);
        if (indexOf == -1) {
            return indexOf;
        }
        return (size() - 1) - indexOf;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return this.forward.isPartialView();
    }
}
