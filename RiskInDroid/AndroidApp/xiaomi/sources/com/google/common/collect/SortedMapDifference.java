package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.MapDifference;
import java.util.SortedMap;

@GwtCompatible
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {

    /* renamed from: com.google.common.collect.SortedMapDifference$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();

    SortedMap<K, V> entriesInCommon();

    SortedMap<K, V> entriesOnlyOnLeft();

    SortedMap<K, V> entriesOnlyOnRight();
}
