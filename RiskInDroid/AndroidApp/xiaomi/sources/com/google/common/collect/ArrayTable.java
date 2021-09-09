package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.IntFunction;

@GwtCompatible(emulated = true)
@Beta
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    public final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    public final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.RowMap rowMap;

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return table instanceof ArrayTable ? new ArrayTable<>((ArrayTable) table) : new ArrayTable<>(table);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable<? extends R>, java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Iterable<? extends C>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 2 */
    private ArrayTable(Iterable<? extends R> r1, Iterable<? extends C> r2) {
        this.rowList = ImmutableList.copyOf((Iterable) r1);
        this.columnList = ImmutableList.copyOf((Iterable) r2);
        Preconditions.checkArgument(this.rowList.isEmpty() == this.columnList.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(this.rowList);
        this.columnKeyToIndex = Maps.indexMap(this.columnList);
        this.array = (Object[][]) Array.newInstance(Object.class, this.rowList.size(), this.columnList.size());
        eraseAll();
    }

    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        this.rowList = arrayTable.rowList;
        this.columnList = arrayTable.columnList;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (Object[][]) Array.newInstance(Object.class, this.rowList.size(), this.columnList.size());
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = arrayTable.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
    }

    static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        /* access modifiers changed from: package-private */
        public abstract String getKeyRole();

        /* access modifiers changed from: package-private */
        public abstract V getValue(int i);

        /* access modifiers changed from: package-private */
        public abstract V setValue(int i, V v);

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.keyIndex = immutableMap;
        }

        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        /* access modifiers changed from: package-private */
        public K getKey(int i) {
            return this.keyIndex.keySet().asList().get(i);
        }

        public int size() {
            return this.keyIndex.size();
        }

        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> getEntry(final int i) {
            Preconditions.checkElementIndex(i, size());
            return new AbstractMapEntry<K, V>() {
                /* class com.google.common.collect.ArrayTable.ArrayMap.AnonymousClass1 */

                public K getKey() {
                    return ArrayMap.this.getKey(i);
                }

                public V getValue() {
                    return ArrayMap.this.getValue(i);
                }

                public V setValue(V v) {
                    return ArrayMap.this.setValue(i, v);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) {
                /* class com.google.common.collect.ArrayTable.ArrayMap.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public Map.Entry<K, V> get(int i) {
                    return ArrayMap.this.getEntry(i);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return CollectSpliterators.indexed(size(), 16, new IntFunction() {
                /* class com.google.common.collect.$$Lambda$zlaL1DxoUc9G5cfYLZuGPJzAVR4 */

                public final Object apply(int i) {
                    return ArrayTable.ArrayMap.this.getEntry(i);
                }
            });
        }

        public boolean containsKey(Object obj) {
            return this.keyIndex.containsKey(obj);
        }

        public V get(Object obj) {
            Integer num = this.keyIndex.get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public V put(K k, V v) {
            Integer num = this.keyIndex.get(k);
            if (num != null) {
                return setValue(num.intValue(), v);
            }
            throw new IllegalArgumentException(getKeyRole() + " " + ((Object) k) + " not in " + this.keyIndex.keySet());
        }

        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public final ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public final ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    public final V at(int i, int i2) {
        Preconditions.checkElementIndex(i, this.rowList.size());
        Preconditions.checkElementIndex(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @CanIgnoreReturnValue
    public final V set(int i, int i2, V v) {
        Preconditions.checkElementIndex(i, this.rowList.size());
        Preconditions.checkElementIndex(i2, this.columnList.size());
        V[][] vArr = this.array;
        V v2 = vArr[i][i2];
        vArr[i][i2] = v;
        return v2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int[]):java.lang.Object VARARG throws java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException}
     arg types: [java.lang.Class<V>, int[]]
     candidates:
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int):java.lang.Object throws java.lang.NegativeArraySizeException}
      ClspMth{java.lang.reflect.Array.newInstance(java.lang.Class<?>, int[]):java.lang.Object VARARG throws java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException} */
    @GwtIncompatible
    public final V[][] toArray(Class<V> cls) {
        V[][] vArr = (Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size());
        for (int i = 0; i < this.rowList.size(); i++) {
            V[][] vArr2 = this.array;
            System.arraycopy(vArr2[i], 0, vArr[i], 0, vArr2[i].length);
        }
        return vArr;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final void eraseAll() {
        for (V[] fill : this.array) {
            Arrays.fill(fill, (Object) null);
        }
    }

    public final boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    public final boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    public final boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        for (V[] vArr : this.array) {
            for (V equal : r0[r3]) {
                if (Objects.equal(obj, equal)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    public final boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @CanIgnoreReturnValue
    public final V put(R r, C c, V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Integer num = this.rowKeyToIndex.get(r);
        boolean z = true;
        Preconditions.checkArgument(num != null, "Row %s not in %s", r, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c);
        if (num2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Column %s not in %s", c, this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public final V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public final int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public final Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) {
            /* class com.google.common.collect.ArrayTable.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public Table.Cell<R, C, V> get(int i) {
                return ArrayTable.this.getCell(i);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<Table.Cell<R, C, V>> cellSpliterator() {
        return CollectSpliterators.indexed(size(), 273, new IntFunction() {
            /* class com.google.common.collect.$$Lambda$FATKzBP6LUcxX6zrRZwWCdTKJqY */

            public final Object apply(int i) {
                return ArrayTable.this.getCell(i);
            }
        });
    }

    public final Table.Cell<R, C, V> getCell(final int i) {
        return new Tables.AbstractCell<R, C, V>() {
            /* class com.google.common.collect.ArrayTable.AnonymousClass2 */
            final int columnIndex = (i % ArrayTable.this.columnList.size());
            final int rowIndex = (i / ArrayTable.this.columnList.size());

            public R getRowKey() {
                return ArrayTable.this.rowList.get(this.rowIndex);
            }

            public C getColumnKey() {
                return ArrayTable.this.columnList.get(this.columnIndex);
            }

            public V getValue() {
                return ArrayTable.this.at(this.rowIndex, this.columnIndex);
            }
        };
    }

    public final V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public final Map<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        Integer num = this.columnKeyToIndex.get(c);
        return num == null ? ImmutableMap.of() : new Column(num.intValue());
    }

    class Column extends ArrayMap<R, V> {
        final int columnIndex;

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Row";
        }

        Column(int i) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = i;
        }

        /* access modifiers changed from: package-private */
        public V getValue(int i) {
            return ArrayTable.this.at(i, this.columnIndex);
        }

        /* access modifiers changed from: package-private */
        public V setValue(int i, V v) {
            return ArrayTable.this.set(i, this.columnIndex, v);
        }
    }

    public final ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public final Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap columnMap2 = this.columnMap;
        if (columnMap2 != null) {
            return columnMap2;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap3 = new ColumnMap();
        this.columnMap = columnMap3;
        return columnMap3;
    }

    class ColumnMap extends ArrayMap<C, Map<R, V>> {
        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Column";
        }

        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        /* access modifiers changed from: package-private */
        public Map<R, V> getValue(int i) {
            return new Column(i);
        }

        /* access modifiers changed from: package-private */
        public Map<R, V> setValue(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer num = this.rowKeyToIndex.get(r);
        return num == null ? ImmutableMap.of() : new Row(num.intValue());
    }

    class Row extends ArrayMap<C, V> {
        final int rowIndex;

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Column";
        }

        Row(int i) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = i;
        }

        /* access modifiers changed from: package-private */
        public V getValue(int i) {
            return ArrayTable.this.at(this.rowIndex, i);
        }

        /* access modifiers changed from: package-private */
        public V setValue(int i, V v) {
            return ArrayTable.this.set(this.rowIndex, i, v);
        }
    }

    public final ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public final Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap rowMap2 = this.rowMap;
        if (rowMap2 != null) {
            return rowMap2;
        }
        ArrayTable<R, C, V>.RowMap rowMap3 = new RowMap();
        this.rowMap = rowMap3;
        return rowMap3;
    }

    class RowMap extends ArrayMap<R, Map<C, V>> {
        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Row";
        }

        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        /* access modifiers changed from: package-private */
        public Map<C, V> getValue(int i) {
            return new Row(i);
        }

        /* access modifiers changed from: package-private */
        public Map<C, V> setValue(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public final Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<V> valuesIterator() {
        return new AbstractIndexedListIterator<V>(size()) {
            /* class com.google.common.collect.ArrayTable.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public V get(int i) {
                return ArrayTable.this.getValue(i);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<V> valuesSpliterator() {
        return CollectSpliterators.indexed(size(), 16, new IntFunction() {
            /* class com.google.common.collect.$$Lambda$OwnqjKRHjlmrdw3G2IJwblrqChQ */

            public final Object apply(int i) {
                return ArrayTable.this.getValue(i);
            }
        });
    }
}
