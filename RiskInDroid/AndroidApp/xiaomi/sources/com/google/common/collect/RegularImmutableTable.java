package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    /* access modifiers changed from: package-private */
    public abstract Table.Cell<R, C, V> getCell(int i);

    /* access modifiers changed from: package-private */
    public abstract V getValue(int i);

    RegularImmutableTable() {
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return isEmpty() ? ImmutableSet.of() : new CellSet();
    }

    final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return false;
        }

        private CellSet() {
        }

        public final int size() {
            return RegularImmutableTable.this.size();
        }

        /* access modifiers changed from: package-private */
        public final Table.Cell<R, C, V> get(int i) {
            return RegularImmutableTable.this.getCell(i);
        }

        public final boolean contains(Object obj) {
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Object obj2 = RegularImmutableTable.this.get(cell.getRowKey(), cell.getColumnKey());
                if (obj2 == null || !obj2.equals(cell.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final ImmutableCollection<V> createValues() {
        return isEmpty() ? ImmutableList.of() : new Values();
    }

    final class Values extends ImmutableList<V> {
        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return true;
        }

        private Values() {
        }

        public final int size() {
            return RegularImmutableTable.this.size();
        }

        public final V get(int i) {
            return RegularImmutableTable.this.getValue(i);
        }
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Table.Cell<R, C, V>> list, final Comparator<? super R> comparator, final Comparator<? super C> comparator2) {
        Preconditions.checkNotNull(list);
        if (!(comparator == null && comparator2 == null)) {
            Collections.sort(list, new Comparator<Table.Cell<R, C, V>>() {
                /* class com.google.common.collect.RegularImmutableTable.AnonymousClass1 */

                public final int compare(Table.Cell<R, C, V> cell, Table.Cell<R, C, V> cell2) {
                    int i;
                    Comparator comparator = comparator;
                    if (comparator == null) {
                        i = 0;
                    } else {
                        i = comparator.compare(cell.getRowKey(), cell2.getRowKey());
                    }
                    if (i != 0) {
                        return i;
                    }
                    Comparator comparator2 = comparator2;
                    if (comparator2 == null) {
                        return 0;
                    }
                    return comparator2.compare(cell.getColumnKey(), cell2.getColumnKey());
                }
            });
        }
        return forCellsInternal(list, comparator, comparator2);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Table.Cell<R, C, V>> iterable) {
        return forCellsInternal(iterable, null, null);
    }

    private static <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Table.Cell<R, C, V>> iterable, Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        ImmutableSet<E> immutableSet;
        ImmutableSet<E> immutableSet2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ImmutableList<E> copyOf = ImmutableList.copyOf(iterable);
        for (Table.Cell next : iterable) {
            linkedHashSet.add(next.getRowKey());
            linkedHashSet2.add(next.getColumnKey());
        }
        if (comparator == null) {
            immutableSet = ImmutableSet.copyOf((Collection) linkedHashSet);
        } else {
            immutableSet = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator, linkedHashSet));
        }
        if (comparator2 == null) {
            immutableSet2 = ImmutableSet.copyOf((Collection) linkedHashSet2);
        } else {
            immutableSet2 = ImmutableSet.copyOf((Collection) ImmutableList.sortedCopyOf(comparator2, linkedHashSet2));
        }
        return forOrderedComponents(copyOf, immutableSet, immutableSet2);
    }

    static <R, C, V> RegularImmutableTable<R, C, V> forOrderedComponents(ImmutableList<Table.Cell<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        return ((long) immutableList.size()) > (((long) immutableSet.size()) * ((long) immutableSet2.size())) / 2 ? new DenseImmutableTable(immutableList, immutableSet, immutableSet2) : new SparseImmutableTable(immutableList, immutableSet, immutableSet2);
    }
}
