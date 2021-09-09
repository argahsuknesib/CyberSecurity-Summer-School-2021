package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(emulated = true)
public interface SortedMultiset<E> extends SortedIterable<E>, SortedMultisetBridge<E> {

    /* renamed from: com.google.common.collect.SortedMultiset$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Comparator<? super E> comparator();

    SortedMultiset<E> descendingMultiset();

    NavigableSet<E> elementSet();

    Set<Multiset.Entry<E>> entrySet();

    Multiset.Entry<E> firstEntry();

    SortedMultiset<E> headMultiset(Object obj, BoundType boundType);

    Iterator<E> iterator();

    Multiset.Entry<E> lastEntry();

    Multiset.Entry<E> pollFirstEntry();

    Multiset.Entry<E> pollLastEntry();

    SortedMultiset<E> subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2);

    SortedMultiset<E> tailMultiset(Object obj, BoundType boundType);
}
