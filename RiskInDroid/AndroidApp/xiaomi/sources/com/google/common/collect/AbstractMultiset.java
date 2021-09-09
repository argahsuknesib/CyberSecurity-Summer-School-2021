package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
    private transient Set<E> elementSet;
    private transient Set<Multiset.Entry<E>> entrySet;

    public abstract void clear();

    /* access modifiers changed from: package-private */
    public abstract int distinctElements();

    /* access modifiers changed from: package-private */
    public abstract Iterator<E> elementIterator();

    /* access modifiers changed from: package-private */
    public abstract Iterator<Multiset.Entry<E>> entryIterator();

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

    AbstractMultiset() {
    }

    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @CanIgnoreReturnValue
    public final boolean add(E e) {
        add(e, 1);
        return true;
    }

    @CanIgnoreReturnValue
    public int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return Multisets.setCountImpl(this, e, i);
    }

    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return Multisets.setCountImpl(this, e, i, i2);
    }

    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> createElementSet = createElementSet();
        this.elementSet = createElementSet;
        return createElementSet;
    }

    /* access modifiers changed from: package-private */
    public Set<E> createElementSet() {
        return new ElementSet();
    }

    class ElementSet extends Multisets.ElementSet<E> {
        ElementSet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> multiset() {
            return AbstractMultiset.this;
        }

        public Iterator<E> iterator() {
            return AbstractMultiset.this.elementIterator();
        }
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    class EntrySet extends Multisets.EntrySet<E> {
        EntrySet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> multiset() {
            return AbstractMultiset.this;
        }

        public Iterator<Multiset.Entry<E>> iterator() {
            return AbstractMultiset.this.entryIterator();
        }

        public int size() {
            return AbstractMultiset.this.distinctElements();
        }
    }

    /* access modifiers changed from: package-private */
    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    public final boolean equals(Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    public final int hashCode() {
        return entrySet().hashCode();
    }

    public final String toString() {
        return entrySet().toString();
    }
}
