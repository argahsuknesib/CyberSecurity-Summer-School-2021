package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;

@GwtCompatible
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {

    /* renamed from: com.google.common.collect.SortedSetMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Map<K, Collection<V>> asMap();

    SortedSet<V> get(Object obj);

    @CanIgnoreReturnValue
    SortedSet<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    SortedSet<V> replaceValues(Object obj, Iterable iterable);

    Comparator<? super V> valueComparator();
}
