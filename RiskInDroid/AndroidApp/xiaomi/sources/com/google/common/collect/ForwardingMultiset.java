package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
    /* access modifiers changed from: protected */
    public abstract Multiset<E> delegate();

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

    protected ForwardingMultiset() {
    }

    public int count(Object obj) {
        return delegate().count(obj);
    }

    @CanIgnoreReturnValue
    public int add(E e, int i) {
        return delegate().add(e, i);
    }

    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        return delegate().remove(obj, i);
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        return delegate().setCount(e, i);
    }

    @CanIgnoreReturnValue
    public boolean setCount(E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    /* access modifiers changed from: protected */
    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    /* access modifiers changed from: protected */
    @Beta
    public int standardCount(Object obj) {
        for (Multiset.Entry entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean standardAdd(E e) {
        add(e, 1);
        return true;
    }

    /* access modifiers changed from: protected */
    @Beta
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    /* access modifiers changed from: protected */
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    /* access modifiers changed from: protected */
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    /* access modifiers changed from: protected */
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    /* access modifiers changed from: protected */
    public int standardSetCount(E e, int i) {
        return Multisets.setCountImpl(this, e, i);
    }

    /* access modifiers changed from: protected */
    public boolean standardSetCount(E e, int i, int i2) {
        return Multisets.setCountImpl(this, e, i, i2);
    }

    @Beta
    public class StandardElementSet extends Multisets.ElementSet<E> {
        public StandardElementSet() {
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> multiset() {
            return ForwardingMultiset.this;
        }

        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }
    }

    /* access modifiers changed from: protected */
    public Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    /* access modifiers changed from: protected */
    public int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return entrySet().hashCode();
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return entrySet().toString();
    }
}
