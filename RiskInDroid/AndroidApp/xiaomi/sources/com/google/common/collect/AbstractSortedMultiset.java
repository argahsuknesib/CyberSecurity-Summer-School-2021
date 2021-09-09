package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
abstract class AbstractSortedMultiset<E> extends AbstractMultiset<E> implements SortedMultiset<E> {
    @GwtTransient
    final Comparator<? super E> comparator;
    private transient SortedMultiset<E> descendingMultiset;

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    public /* synthetic */ void forEach(Consumer<? super E> consumer) {
        Multiset.CC.$default$forEach(this, consumer);
    }

    @Beta
    public /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Multiset.CC.$default$forEachEntry(this, objIntConsumer);
    }

    public /* synthetic */ Spliterator<E> spliterator() {
        return Multiset.CC.$default$spliterator(this);
    }

    AbstractSortedMultiset() {
        this(Ordering.natural());
    }

    AbstractSortedMultiset(Comparator<? super E> comparator2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
    }

    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    /* access modifiers changed from: package-private */
    public NavigableSet<E> createElementSet() {
        return new SortedMultisets.NavigableElementSet(this);
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public Multiset.Entry<E> firstEntry() {
        Iterator entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return (Multiset.Entry) entryIterator.next();
        }
        return null;
    }

    public Multiset.Entry<E> lastEntry() {
        Iterator descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return (Multiset.Entry) descendingEntryIterator.next();
        }
        return null;
    }

    public Multiset.Entry<E> pollFirstEntry() {
        Iterator entryIterator = entryIterator();
        if (!entryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) entryIterator.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        entryIterator.remove();
        return immutableEntry;
    }

    public Multiset.Entry<E> pollLastEntry() {
        Iterator descendingEntryIterator = descendingEntryIterator();
        if (!descendingEntryIterator.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) descendingEntryIterator.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        descendingEntryIterator.remove();
        return immutableEntry;
    }

    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> descendingIterator() {
        return Multisets.iteratorImpl(descendingMultiset());
    }

    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.descendingMultiset;
        if (sortedMultiset != null) {
            return sortedMultiset;
        }
        SortedMultiset<E> createDescendingMultiset = createDescendingMultiset();
        this.descendingMultiset = createDescendingMultiset;
        return createDescendingMultiset;
    }

    /* access modifiers changed from: package-private */
    public SortedMultiset<E> createDescendingMultiset() {
        return new DescendingMultiset<E>() {
            /* class com.google.common.collect.AbstractSortedMultiset.AnonymousClass1DescendingMultisetImpl */

            /* access modifiers changed from: package-private */
            public SortedMultiset<E> forwardMultiset() {
                return AbstractSortedMultiset.this;
            }

            /* access modifiers changed from: package-private */
            public Iterator<Multiset.Entry<E>> entryIterator() {
                return AbstractSortedMultiset.this.descendingEntryIterator();
            }

            public Iterator<E> iterator() {
                return AbstractSortedMultiset.this.descendingIterator();
            }
        };
    }
}
