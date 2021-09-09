package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtCompatible(emulated = true)
final class EmptyContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    public final boolean contains(Object obj) {
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final ContiguousSet<C> headSetImpl(C c, boolean z) {
        return this;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final int indexOf(Object obj) {
        return -1;
    }

    public final ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        return this;
    }

    public final boolean isEmpty() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final boolean isHashCodeFast() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    public final int size() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final ContiguousSet<C> subSetImpl(C c, boolean z, C c2, boolean z2) {
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return this;
    }

    public final String toString() {
        return "[]";
    }

    EmptyContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
    }

    public final C first() {
        throw new NoSuchElementException();
    }

    public final C last() {
        throw new NoSuchElementException();
    }

    public final Range<C> range() {
        throw new NoSuchElementException();
    }

    public final Range<C> range(BoundType boundType, BoundType boundType2) {
        throw new NoSuchElementException();
    }

    public final UnmodifiableIterator<C> iterator() {
        return Iterators.emptyIterator();
    }

    @GwtIncompatible
    public final UnmodifiableIterator<C> descendingIterator() {
        return Iterators.emptyIterator();
    }

    public final ImmutableList<C> asList() {
        return ImmutableList.of();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    @GwtIncompatible
    static final class SerializedForm<C extends Comparable> implements Serializable {
        private static final long serialVersionUID = 0;
        private final DiscreteDomain<C> domain;

        private SerializedForm(DiscreteDomain<C> discreteDomain) {
            this.domain = discreteDomain;
        }

        private Object readResolve() {
            return new EmptyContiguousSet(this.domain);
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final Object writeReplace() {
        return new SerializedForm(this.domain);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final ImmutableSortedSet<C> createDescendingSet() {
        return ImmutableSortedSet.emptySet(Ordering.natural().reverse());
    }
}
