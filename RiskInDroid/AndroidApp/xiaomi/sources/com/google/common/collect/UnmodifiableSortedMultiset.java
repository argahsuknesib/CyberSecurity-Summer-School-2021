package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements SortedMultiset<E> {
    private static final long serialVersionUID = 0;
    private transient UnmodifiableSortedMultiset<E> descendingMultiset;

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

    UnmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset) {
        super(sortedMultiset);
    }

    /* access modifiers changed from: protected */
    public final SortedMultiset<E> delegate() {
        return (SortedMultiset) super.delegate();
    }

    public final Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    /* access modifiers changed from: package-private */
    public final NavigableSet<E> createElementSet() {
        return Sets.unmodifiableNavigableSet(delegate().elementSet());
    }

    public final NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    public final SortedMultiset<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(delegate().descendingMultiset());
        unmodifiableSortedMultiset2.descendingMultiset = this;
        this.descendingMultiset = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    public final Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    public final Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(delegate().headMultiset(e, boundType));
    }

    public final SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(delegate().subMultiset(e, boundType, e2, boundType2));
    }

    public final SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(delegate().tailMultiset(e, boundType));
    }
}
