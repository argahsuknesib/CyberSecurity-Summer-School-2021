package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
public interface RowSortedTable<R, C, V> extends Table<R, C, V> {

    /* renamed from: com.google.common.collect.RowSortedTable$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    SortedSet<R> rowKeySet();

    SortedMap<R, Map<C, V>> rowMap();
}
