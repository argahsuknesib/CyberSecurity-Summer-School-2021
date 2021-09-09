package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        boolean equals(Object obj);

        C getColumnKey();

        R getRowKey();

        V getValue();

        int hashCode();
    }

    Set<Cell<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(C c);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@CompatibleWith("R") Object obj, @CompatibleWith("C") Object obj2);

    boolean containsColumn(@CompatibleWith("C") Object obj);

    boolean containsRow(@CompatibleWith("R") Object obj);

    boolean containsValue(@CompatibleWith("V") Object obj);

    boolean equals(Object obj);

    V get(@CompatibleWith("R") Object obj, @CompatibleWith("C") Object obj2);

    int hashCode();

    boolean isEmpty();

    @CanIgnoreReturnValue
    V put(R r, C c, V v);

    void putAll(Table<? extends R, ? extends C, ? extends V> table);

    @CanIgnoreReturnValue
    V remove(@CompatibleWith("R") Object obj, @CompatibleWith("C") Object obj2);

    Map<C, V> row(R r);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
