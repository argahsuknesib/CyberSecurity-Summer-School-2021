package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.SortedMultisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
@Beta
public abstract class ForwardingSortedMultiset<E> extends ForwardingMultiset<E> implements SortedMultiset<E> {
    /* access modifiers changed from: protected */
    public abstract SortedMultiset<E> delegate();

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

    protected ForwardingSortedMultiset() {
    }

    public NavigableSet<E> elementSet() {
        return delegate().elementSet();
    }

    public class StandardElementSet extends SortedMultisets.NavigableElementSet<E> {
        public StandardElementSet() {
            super(ForwardingSortedMultiset.this);
        }
    }

    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    public SortedMultiset<E> descendingMultiset() {
        return delegate().descendingMultiset();
    }

    public abstract class StandardDescendingMultiset extends DescendingMultiset<E> {
        public StandardDescendingMultiset() {
        }

        /* access modifiers changed from: package-private */
        public SortedMultiset<E> forwardMultiset() {
            return ForwardingSortedMultiset.this;
        }
    }

    public Multiset.Entry<E> firstEntry() {
        return delegate().firstEntry();
    }

    /* access modifiers changed from: protected */
    public Multiset.Entry<E> standardFirstEntry() {
        Iterator it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    public Multiset.Entry<E> lastEntry() {
        return delegate().lastEntry();
    }

    /* access modifiers changed from: protected */
    public Multiset.Entry<E> standardLastEntry() {
        Iterator it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        return Multisets.immutableEntry(entry.getElement(), entry.getCount());
    }

    public Multiset.Entry<E> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    /* access modifiers changed from: protected */
    public Multiset.Entry<E> standardPollFirstEntry() {
        Iterator it = entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        it.remove();
        return immutableEntry;
    }

    public Multiset.Entry<E> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    /* access modifiers changed from: protected */
    public Multiset.Entry<E> standardPollLastEntry() {
        Iterator it = descendingMultiset().entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Multiset.Entry entry = (Multiset.Entry) it.next();
        Multiset.Entry<E> immutableEntry = Multisets.immutableEntry(entry.getElement(), entry.getCount());
        it.remove();
        return immutableEntry;
    }

    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return delegate().headMultiset(e, boundType);
    }

    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return delegate().subMultiset(e, boundType, e2, boundType2);
    }

    /* access modifiers changed from: protected */
    public SortedMultiset<E> standardSubMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return delegate().tailMultiset(e, boundType);
    }
}
