package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.IntFunction;

@GwtCompatible(emulated = true)
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements SortedIterable<E> {
    ImmutableSortedAsList(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) super.delegateCollection();
    }

    public final Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    @GwtIncompatible
    public final int indexOf(Object obj) {
        int indexOf = delegateCollection().indexOf(obj);
        if (indexOf < 0 || !get(indexOf).equals(obj)) {
            return -1;
        }
        return indexOf;
    }

    @GwtIncompatible
    public final int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableSortedSet(super.subListUnchecked(i, i2), comparator()).asList();
    }

    public final Spliterator<E> spliterator() {
        int size = size();
        ImmutableList delegateList = delegateList();
        delegateList.getClass();
        return CollectSpliterators.indexed(size, 1301, new IntFunction() {
            /* class com.google.common.collect.$$Lambda$J9zVGv6YXVkAf1JUJc7fbdQoC3U */

            public final Object apply(int i) {
                return ImmutableList.this.get(i);
            }
        }, comparator());
    }
}
