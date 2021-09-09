package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@GwtCompatible
public interface ListMultimap<K, V> extends Multimap<K, V> {

    /* renamed from: com.google.common.collect.ListMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Map<K, Collection<V>> asMap();

    boolean equals(Object obj);

    List<V> get(Object obj);

    @CanIgnoreReturnValue
    List<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    List<V> replaceValues(Object obj, Iterable iterable);
}
