package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

@GwtCompatible
public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<Table.Cell<R, C, V>> createCellSet();

    /* access modifiers changed from: package-private */
    public abstract SerializedForm createSerializedForm();

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<V> createValues();

    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Beta
    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3) {
        Preconditions.checkNotNull(function, "rowFunction");
        Preconditions.checkNotNull(function2, "columnFunction");
        Preconditions.checkNotNull(function3, "valueFunction");
        return Collector.of($$Lambda$ImmutableTable$52PoG1cay3o3QtG88q4H14VWC0A.INSTANCE, new BiConsumer(function, function2, function3) {
            /* class com.google.common.collect.$$Lambda$ImmutableTable$VEoMKodei5HBgDkLyF7ipFkulKA */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;
            private final /* synthetic */ Function f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableTable.Builder) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2), this.f$2.apply(obj2));
            }
        }, $$Lambda$ImmutableTable$ckQOHx_QHoF96hmXod25xh9h1Pw.INSTANCE, $$Lambda$ImmutableTable$H2IdI2SjayUV7IpMDriZLeqvMPA.INSTANCE, new Collector.Characteristics[0]);
    }

    static /* synthetic */ Builder lambda$toImmutableTable$0() {
        return new Builder();
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, BinaryOperator<V> binaryOperator) {
        Preconditions.checkNotNull(function, "rowFunction");
        Preconditions.checkNotNull(function2, "columnFunction");
        Preconditions.checkNotNull(function3, "valueFunction");
        Preconditions.checkNotNull(binaryOperator, "mergeFunction");
        return Collector.of($$Lambda$ImmutableTable$3nvOFXygdJjpD05SaQtUOm3ckKk.INSTANCE, new BiConsumer(function, function2, function3, binaryOperator) {
            /* class com.google.common.collect.$$Lambda$ImmutableTable$j3c5WbxsgsCxgENdrTOH1HIsB6I */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;
            private final /* synthetic */ Function f$2;
            private final /* synthetic */ BinaryOperator f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableTable.CollectorState) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2), this.f$2.apply(obj2), this.f$3);
            }
        }, new BinaryOperator(binaryOperator) {
            /* class com.google.common.collect.$$Lambda$ImmutableTable$320mNUMmXDeNOO3PGxQ0DcrqK4Y */
            private final /* synthetic */ BinaryOperator f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj, Object obj2) {
                return ((ImmutableTable.CollectorState) obj).combine((ImmutableTable.CollectorState) obj2, this.f$0);
            }
        }, $$Lambda$ImmutableTable$zZeMrBtoGSnbzy_M_iHgpKXoKo.INSTANCE, new Collector.Characteristics[0]);
    }

    static /* synthetic */ CollectorState lambda$toImmutableTable$4() {
        return new CollectorState();
    }

    static final class CollectorState<R, C, V> {
        final List<MutableCell<R, C, V>> insertionOrder;
        final Table<R, C, MutableCell<R, C, V>> table;

        private CollectorState() {
            this.insertionOrder = new ArrayList();
            this.table = HashBasedTable.create();
        }

        /* access modifiers changed from: package-private */
        public final void put(R r, C c, V v, BinaryOperator<V> binaryOperator) {
            MutableCell mutableCell = this.table.get(r, c);
            if (mutableCell == null) {
                MutableCell mutableCell2 = new MutableCell(r, c, v);
                this.insertionOrder.add(mutableCell2);
                this.table.put(r, c, mutableCell2);
                return;
            }
            mutableCell.merge(v, binaryOperator);
        }

        /* access modifiers changed from: package-private */
        public final CollectorState<R, C, V> combine(CollectorState<R, C, V> collectorState, BinaryOperator<V> binaryOperator) {
            for (MutableCell next : collectorState.insertionOrder) {
                put(next.getRowKey(), next.getColumnKey(), next.getValue(), binaryOperator);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public final ImmutableTable<R, C, V> toTable() {
            return ImmutableTable.copyOf(this.insertionOrder);
        }
    }

    static final class MutableCell<R, C, V> extends Tables.AbstractCell<R, C, V> {
        private final C column;
        private final R row;
        private V value;

        MutableCell(R r, C c, V v) {
            this.row = Preconditions.checkNotNull(r, "row");
            this.column = Preconditions.checkNotNull(c, "column");
            this.value = Preconditions.checkNotNull(v, "value");
        }

        public final R getRowKey() {
            return this.row;
        }

        public final C getColumnKey() {
            return this.column;
        }

        public final V getValue() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public final void merge(V v, BinaryOperator<V> binaryOperator) {
            Preconditions.checkNotNull(v, "value");
            this.value = Preconditions.checkNotNull(binaryOperator.apply(this.value, v), "mergeFunction.apply");
        }
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return SparseImmutableTable.EMPTY;
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r, C c, V v) {
        return new SingletonImmutableTable(r, c, v);
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Table<? extends R, ? extends C, ? extends V> table) {
        if (table instanceof ImmutableTable) {
            return (ImmutableTable) table;
        }
        return copyOf(table.cellSet());
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(Iterable<? extends Table.Cell<? extends R, ? extends C, ? extends V>> iterable) {
        Builder builder = builder();
        for (Table.Cell put : iterable) {
            builder.put(put);
        }
        return builder.build();
    }

    public static <R, C, V> Builder<R, C, V> builder() {
        return new Builder<>();
    }

    static <R, C, V> Table.Cell<R, C, V> cellOf(R r, C c, V v) {
        return Tables.immutableCell(Preconditions.checkNotNull(r, "rowKey"), Preconditions.checkNotNull(c, "columnKey"), Preconditions.checkNotNull(v, "value"));
    }

    public static final class Builder<R, C, V> {
        private final List<Table.Cell<R, C, V>> cells = Lists.newArrayList();
        private Comparator<? super C> columnComparator;
        private Comparator<? super R> rowComparator;

        @CanIgnoreReturnValue
        public final Builder<R, C, V> orderRowsBy(Comparator<? super R> comparator) {
            this.rowComparator = (Comparator) Preconditions.checkNotNull(comparator, "rowComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<R, C, V> orderColumnsBy(Comparator<? super C> comparator) {
            this.columnComparator = (Comparator) Preconditions.checkNotNull(comparator, "columnComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<R, C, V> put(R r, C c, V v) {
            this.cells.add(ImmutableTable.cellOf(r, c, v));
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof Tables.ImmutableCell) {
                Preconditions.checkNotNull(cell.getRowKey(), "row");
                Preconditions.checkNotNull(cell.getColumnKey(), "column");
                Preconditions.checkNotNull(cell.getValue(), "value");
                this.cells.add(cell);
            } else {
                put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> table) {
            for (Table.Cell<? extends R, ? extends C, ? extends V> put : table.cellSet()) {
                put(put);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public final Builder<R, C, V> combine(Builder<R, C, V> builder) {
            this.cells.addAll(builder.cells);
            return this;
        }

        public final ImmutableTable<R, C, V> build() {
            int size = this.cells.size();
            if (size == 0) {
                return ImmutableTable.of();
            }
            if (size != 1) {
                return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
            }
            return new SingletonImmutableTable((Table.Cell) Iterables.getOnlyElement(this.cells));
        }
    }

    ImmutableTable() {
    }

    public ImmutableSet<Table.Cell<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    /* access modifiers changed from: package-private */
    public final UnmodifiableIterator<Table.Cell<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<Table.Cell<R, C, V>> cellSpliterator() {
        throw new AssertionError("should never be called");
    }

    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c, "columnKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) columnMap().get(c), ImmutableMap.of());
    }

    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    public ImmutableMap<C, V> row(R r) {
        Preconditions.checkNotNull(r, "rowKey");
        return (ImmutableMap) MoreObjects.firstNonNull((ImmutableMap) rowMap().get(r), ImmutableMap.of());
    }

    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final V put(R r, C c, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        private SerializedForm(Object[] objArr, Object[] objArr2, Object[] objArr3, int[] iArr, int[] iArr2) {
            this.rowKeys = objArr;
            this.columnKeys = objArr2;
            this.cellValues = objArr3;
            this.cellRowIndices = iArr;
            this.cellColumnIndices = iArr2;
        }

        static SerializedForm create(ImmutableTable<?, ?, ?> immutableTable, int[] iArr, int[] iArr2) {
            return new SerializedForm(immutableTable.rowKeySet().toArray(), immutableTable.columnKeySet().toArray(), immutableTable.values().toArray(), iArr, iArr2);
        }

        /* access modifiers changed from: package-private */
        public final Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return ImmutableTable.of();
            }
            int i = 0;
            if (objArr.length == 1) {
                return ImmutableTable.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            ImmutableList.Builder builder = new ImmutableList.Builder(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i >= objArr2.length) {
                    return RegularImmutableTable.forOrderedComponents(builder.build(), ImmutableSet.copyOf(this.rowKeys), ImmutableSet.copyOf(this.columnKeys));
                }
                builder.add((Object) ImmutableTable.cellOf(this.rowKeys[this.cellRowIndices[i]], this.columnKeys[this.cellColumnIndices[i]], objArr2[i]));
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return createSerializedForm();
    }
}
