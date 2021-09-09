package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

@GwtCompatible
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = new Function<Map<Object, Object>, Map<Object, Object>>() {
        /* class com.google.common.collect.Tables.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object apply(Object obj) {
            return apply((Map<Object, Object>) ((Map) obj));
        }

        public final Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    };

    private Tables() {
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.function.Supplier<I>, java.util.function.Supplier] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Beta
    public static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(java.util.function.Function<? super T, ? extends R> function, java.util.function.Function<? super T, ? extends C> function2, java.util.function.Function<? super T, ? extends V> function3, Supplier<I> r4) {
        return toTable(function, function2, function3, $$Lambda$Tables$oi1QVRfWz5gqg8qyHwNz1t6YIA.INSTANCE, r4);
    }

    static /* synthetic */ Object lambda$toTable$0(Object obj, Object obj2) {
        throw new IllegalStateException("Conflicting values " + obj + " and " + obj2);
    }

    public static <T, R, C, V, I extends Table<R, C, V>> Collector<T, ?, I> toTable(java.util.function.Function<? super T, ? extends R> function, java.util.function.Function<? super T, ? extends C> function2, java.util.function.Function<? super T, ? extends V> function3, BinaryOperator<V> binaryOperator, Supplier<I> supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        Preconditions.checkNotNull(function3);
        Preconditions.checkNotNull(binaryOperator);
        Preconditions.checkNotNull(supplier);
        return Collector.of(supplier, new BiConsumer(function, function2, function3, binaryOperator) {
            /* class com.google.common.collect.$$Lambda$Tables$FuaETyMohrBu_1sDhBaF3HzgmNQ */
            private final /* synthetic */ java.util.function.Function f$0;
            private final /* synthetic */ java.util.function.Function f$1;
            private final /* synthetic */ java.util.function.Function f$2;
            private final /* synthetic */ BinaryOperator f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void accept(Object obj, Object obj2) {
                Tables.merge((Table) obj, this.f$0.apply(obj2), this.f$1.apply(obj2), this.f$2.apply(obj2), this.f$3);
            }
        }, new BinaryOperator(binaryOperator) {
            /* class com.google.common.collect.$$Lambda$Tables$4YD6mScQjZTUDFSKT2BObkkn_5A */
            private final /* synthetic */ BinaryOperator f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj, Object obj2) {
                return Tables.lambda$toTable$2(this.f$0, (Table) obj, (Table) obj2);
            }
        }, new Collector.Characteristics[0]);
    }

    static /* synthetic */ Table lambda$toTable$2(BinaryOperator binaryOperator, Table table, Table table2) {
        for (Table.Cell cell : table2.cellSet()) {
            merge(table, cell.getRowKey(), cell.getColumnKey(), cell.getValue(), binaryOperator);
        }
        return table;
    }

    /* access modifiers changed from: private */
    public static <R, C, V> void merge(Table<R, C, V> table, R r, C c, V v, BinaryOperator<V> binaryOperator) {
        Preconditions.checkNotNull(v);
        V v2 = table.get(r, c);
        if (v2 == null) {
            table.put(r, c, v);
            return;
        }
        Object apply = binaryOperator.apply(v2, v);
        if (apply == null) {
            table.remove(r, c);
        } else {
            table.put(r, c, apply);
        }
    }

    public static <R, C, V> Table.Cell<R, C, V> immutableCell(R r, C c, V v) {
        return new ImmutableCell(r, c, v);
    }

    static final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final C columnKey;
        private final R rowKey;
        private final V value;

        ImmutableCell(R r, C c, V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        public final R getRowKey() {
            return this.rowKey;
        }

        public final C getColumnKey() {
            return this.columnKey;
        }

        public final V getValue() {
            return this.value;
        }
    }

    static abstract class AbstractCell<R, C, V> implements Table.Cell<R, C, V> {
        AbstractCell() {
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                return Objects.equal(getRowKey(), cell.getRowKey()) && Objects.equal(getColumnKey(), cell.getColumnKey()) && Objects.equal(getValue(), cell.getValue());
            }
        }

        public int hashCode() {
            return Objects.hashCode(getRowKey(), getColumnKey(), getValue());
        }

        public String toString() {
            return "(" + getRowKey() + "," + getColumnKey() + ")=" + getValue();
        }
    }

    public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> table) {
        return table instanceof TransposeTable ? ((TransposeTable) table).original : new TransposeTable(table);
    }

    static class TransposeTable<C, R, V> extends AbstractTable<C, R, V> {
        private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = new Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>() {
            /* class com.google.common.collect.Tables.TransposeTable.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Table.Cell<?, ?, ?>) ((Table.Cell) obj));
            }

            public final Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell) {
                return Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
            }
        };
        final Table<R, C, V> original;

        TransposeTable(Table<R, C, V> table) {
            this.original = (Table) Preconditions.checkNotNull(table);
        }

        public void clear() {
            this.original.clear();
        }

        public Map<C, V> column(R r) {
            return this.original.row(r);
        }

        public Set<R> columnKeySet() {
            return this.original.rowKeySet();
        }

        public Map<R, Map<C, V>> columnMap() {
            return this.original.rowMap();
        }

        public boolean contains(Object obj, Object obj2) {
            return this.original.contains(obj2, obj);
        }

        public boolean containsColumn(Object obj) {
            return this.original.containsRow(obj);
        }

        public boolean containsRow(Object obj) {
            return this.original.containsColumn(obj);
        }

        public boolean containsValue(Object obj) {
            return this.original.containsValue(obj);
        }

        public V get(Object obj, Object obj2) {
            return this.original.get(obj2, obj);
        }

        public V put(C c, R r, V v) {
            return this.original.put(r, c, v);
        }

        public void putAll(Table<? extends C, ? extends R, ? extends V> table) {
            this.original.putAll(Tables.transpose(table));
        }

        public V remove(Object obj, Object obj2) {
            return this.original.remove(obj2, obj);
        }

        public Map<R, V> row(C c) {
            return this.original.column(c);
        }

        public Set<C> rowKeySet() {
            return this.original.columnKeySet();
        }

        public Map<C, Map<R, V>> rowMap() {
            return this.original.columnMap();
        }

        public int size() {
            return this.original.size();
        }

        public Collection<V> values() {
            return this.original.values();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Table.Cell<C, R, V>> cellIterator() {
            return Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
        }

        /* access modifiers changed from: package-private */
        public Spliterator<Table.Cell<C, R, V>> cellSpliterator() {
            return CollectSpliterators.map(this.original.cellSet().spliterator(), TRANSPOSE_CELL);
        }
    }

    @Beta
    public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> map, com.google.common.base.Supplier<? extends Map<C, V>> supplier) {
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkNotNull(supplier);
        return new StandardTable(map, supplier);
    }

    @Beta
    public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> table, Function<? super V1, V2> function) {
        return new TransformedTable(table, function);
    }

    static class TransformedTable<R, C, V1, V2> extends AbstractTable<R, C, V2> {
        final Table<R, C, V1> fromTable;
        final Function<? super V1, V2> function;

        TransformedTable(Table<R, C, V1> table, Function<? super V1, V2> function2) {
            this.fromTable = (Table) Preconditions.checkNotNull(table);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public boolean contains(Object obj, Object obj2) {
            return this.fromTable.contains(obj, obj2);
        }

        public V2 get(Object obj, Object obj2) {
            if (contains(obj, obj2)) {
                return this.function.apply(this.fromTable.get(obj, obj2));
            }
            return null;
        }

        public int size() {
            return this.fromTable.size();
        }

        public void clear() {
            this.fromTable.clear();
        }

        public V2 put(R r, C c, V2 v2) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Table<? extends R, ? extends C, ? extends V2> table) {
            throw new UnsupportedOperationException();
        }

        public V2 remove(Object obj, Object obj2) {
            if (contains(obj, obj2)) {
                return this.function.apply(this.fromTable.remove(obj, obj2));
            }
            return null;
        }

        public Map<C, V2> row(R r) {
            return Maps.transformValues(this.fromTable.row(r), this.function);
        }

        public Map<R, V2> column(C c) {
            return Maps.transformValues(this.fromTable.column(c), this.function);
        }

        /* access modifiers changed from: package-private */
        public Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> cellFunction() {
            return new Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>() {
                /* class com.google.common.collect.Tables.TransformedTable.AnonymousClass1 */

                public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> cell) {
                    return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), TransformedTable.this.function.apply(cell.getValue()));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Table.Cell<R, C, V2>> cellIterator() {
            return Iterators.transform(this.fromTable.cellSet().iterator(), cellFunction());
        }

        /* access modifiers changed from: package-private */
        public Spliterator<Table.Cell<R, C, V2>> cellSpliterator() {
            return CollectSpliterators.map(this.fromTable.cellSet().spliterator(), cellFunction());
        }

        public Set<R> rowKeySet() {
            return this.fromTable.rowKeySet();
        }

        public Set<C> columnKeySet() {
            return this.fromTable.columnKeySet();
        }

        /* access modifiers changed from: package-private */
        public Collection<V2> createValues() {
            return Collections2.transform(this.fromTable.values(), this.function);
        }

        public Map<R, Map<C, V2>> rowMap() {
            return Maps.transformValues(this.fromTable.rowMap(), new Function<Map<C, V1>, Map<C, V2>>() {
                /* class com.google.common.collect.Tables.TransformedTable.AnonymousClass2 */

                public Map<C, V2> apply(Map<C, V1> map) {
                    return Maps.transformValues(map, TransformedTable.this.function);
                }
            });
        }

        public Map<C, Map<R, V2>> columnMap() {
            return Maps.transformValues(this.fromTable.columnMap(), new Function<Map<R, V1>, Map<R, V2>>() {
                /* class com.google.common.collect.Tables.TransformedTable.AnonymousClass3 */

                public Map<R, V2> apply(Map<R, V1> map) {
                    return Maps.transformValues(map, TransformedTable.this.function);
                }
            });
        }
    }

    public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
        return new UnmodifiableTable(table);
    }

    static class UnmodifiableTable<R, C, V> extends ForwardingTable<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Table<? extends R, ? extends C, ? extends V> delegate;

        UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> table) {
            this.delegate = (Table) Preconditions.checkNotNull(table);
        }

        /* access modifiers changed from: protected */
        public Table<R, C, V> delegate() {
            return this.delegate;
        }

        public Set<Table.Cell<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> column(C c) {
            return Collections.unmodifiableMap(super.column(c));
        }

        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), Tables.unmodifiableWrapper()));
        }

        public V put(R r, C c, V v) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        public V remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> row(R r) {
            return Collections.unmodifiableMap(super.row(r));
        }

        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), Tables.unmodifiableWrapper()));
        }

        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }
    }

    @Beta
    public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
        return new UnmodifiableRowSortedMap(rowSortedTable);
    }

    static final class UnmodifiableRowSortedMap<R, C, V> extends UnmodifiableTable<R, C, V> implements RowSortedTable<R, C, V> {
        private static final long serialVersionUID = 0;

        public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> rowSortedTable) {
            super(rowSortedTable);
        }

        /* access modifiers changed from: protected */
        public final RowSortedTable<R, C, V> delegate() {
            return (RowSortedTable) super.delegate();
        }

        public final SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), Tables.unmodifiableWrapper()));
        }

        public final SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }
    }

    public static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper() {
        return UNMODIFIABLE_WRAPPER;
    }

    public static <R, C, V> Table<R, C, V> synchronizedTable(Table<R, C, V> table) {
        return Synchronized.table(table, null);
    }

    static boolean equalsImpl(Table<?, ?, ?> table, Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof Table) {
            return table.cellSet().equals(((Table) obj).cellSet());
        }
        return false;
    }
}
