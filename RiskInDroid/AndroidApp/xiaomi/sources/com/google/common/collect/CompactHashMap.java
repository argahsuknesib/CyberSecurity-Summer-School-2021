package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;

@GwtIncompatible
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    @VisibleForTesting
    transient long[] entries;
    private transient Set<Map.Entry<K, V>> entrySetView;
    private transient Set<K> keySetView;
    @VisibleForTesting
    transient Object[] keys;
    transient float loadFactor;
    transient int modCount;
    public transient int size;
    private transient int[] table;
    private transient int threshold;
    @VisibleForTesting
    transient Object[] values;
    private transient Collection<V> valuesView;

    private static int getHash(long j) {
        return (int) (j >>> 32);
    }

    private static int getNext(long j) {
        return (int) j;
    }

    private static long swapNext(long j, int i) {
        return (j & -4294967296L) | (((long) i) & 4294967295L);
    }

    /* access modifiers changed from: package-private */
    public void accessEntry(int i) {
    }

    /* access modifiers changed from: package-private */
    public int adjustAfterRemove(int i, int i2) {
        return i - 1;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i) {
        return new CompactHashMap<>(i);
    }

    CompactHashMap() {
        init(3, 1.0f);
    }

    CompactHashMap(int i) {
        this(i, 1.0f);
    }

    CompactHashMap(int i, float f) {
        init(i, f);
    }

    /* access modifiers changed from: package-private */
    public void init(int i, float f) {
        boolean z = false;
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        if (f > 0.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Illegal load factor");
        int closedTableSize = Hashing.closedTableSize(i, (double) f);
        this.table = newTable(closedTableSize);
        this.loadFactor = f;
        this.keys = new Object[i];
        this.values = new Object[i];
        this.entries = newEntries(i);
        this.threshold = Math.max(1, (int) (((float) closedTableSize) * f));
    }

    private static int[] newTable(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(long[], long):void}
     arg types: [long[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(long[], long):void} */
    private static long[] newEntries(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    @CanIgnoreReturnValue
    public V put(K k, V v) {
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        V[] vArr = this.values;
        int smearedHash = Hashing.smearedHash(k);
        int hashTableMask = hashTableMask() & smearedHash;
        int i = this.size;
        int[] iArr = this.table;
        int i2 = iArr[hashTableMask];
        if (i2 == -1) {
            iArr[hashTableMask] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (getHash(j) != smearedHash || !Objects.equal(k, objArr[i2])) {
                    int next = getNext(j);
                    if (next == -1) {
                        jArr[i2] = swapNext(j, i);
                        break;
                    }
                    i2 = next;
                } else {
                    V v2 = vArr[i2];
                    vArr[i2] = v;
                    accessEntry(i2);
                    return v2;
                }
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            resizeMeMaybe(i3);
            insertEntry(i, k, v, smearedHash);
            this.size = i3;
            if (i >= this.threshold) {
                resizeTable(this.table.length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    /* access modifiers changed from: package-private */
    public void insertEntry(int i, K k, V v, int i2) {
        this.entries[i] = (((long) i2) << 32) | 4294967295L;
        this.keys[i] = k;
        this.values[i] = v;
    }

    private void resizeMeMaybe(int i) {
        int length = this.entries.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(long[], int, int, long):void}
     arg types: [long[], int, int, int]
     candidates:
      ClspMth{java.util.Arrays.fill(java.lang.Object[], int, int, java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int, int, int):void}
      ClspMth{java.util.Arrays.fill(char[], int, int, char):void}
      ClspMth{java.util.Arrays.fill(boolean[], int, int, boolean):void}
      ClspMth{java.util.Arrays.fill(byte[], int, int, byte):void}
      ClspMth{java.util.Arrays.fill(double[], int, int, double):void}
      ClspMth{java.util.Arrays.fill(float[], int, int, float):void}
      ClspMth{java.util.Arrays.fill(short[], int, int, short):void}
      ClspMth{java.util.Arrays.fill(long[], int, int, long):void} */
    /* access modifiers changed from: package-private */
    public void resizeEntries(int i) {
        this.keys = Arrays.copyOf(this.keys, i);
        this.values = Arrays.copyOf(this.values, i);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.entries = copyOf;
    }

    private void resizeTable(int i) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (((float) i) * this.loadFactor)) + 1;
        int[] newTable = newTable(i);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            int hash = getHash(jArr[i3]);
            int i4 = hash & length;
            int i5 = newTable[i4];
            newTable[i4] = i3;
            jArr[i3] = (((long) hash) << 32) | (4294967295L & ((long) i5));
        }
        this.threshold = i2;
        this.table = newTable;
    }

    public int indexOf(Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int i = this.table[hashTableMask() & smearedHash];
        while (i != -1) {
            long j = this.entries[i];
            if (getHash(j) == smearedHash && Objects.equal(obj, this.keys[i])) {
                return i;
            }
            i = getNext(j);
        }
        return -1;
    }

    public boolean containsKey(Object obj) {
        return indexOf(obj) != -1;
    }

    public V get(Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return this.values[indexOf];
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    private V remove(Object obj, int i) {
        int hashTableMask = hashTableMask() & i;
        int i2 = this.table[hashTableMask];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (getHash(this.entries[i2]) != i || !Objects.equal(obj, this.keys[i2])) {
                int next = getNext(this.entries[i2]);
                if (next == -1) {
                    return null;
                }
                int i4 = next;
                i3 = i2;
                i2 = i4;
            } else {
                V v = this.values[i2];
                if (i3 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i2]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i3] = swapNext(jArr[i3], getNext(jArr[i2]));
                }
                moveLastEntry(i2);
                this.size--;
                this.modCount++;
                return v;
            }
        }
    }

    @CanIgnoreReturnValue
    public V removeEntry(int i) {
        return remove(this.keys[i], getHash(this.entries[i]));
    }

    /* access modifiers changed from: package-private */
    public void moveLastEntry(int i) {
        int size2 = size() - 1;
        if (i < size2) {
            Object[] objArr = this.keys;
            objArr[i] = objArr[size2];
            Object[] objArr2 = this.values;
            objArr2[i] = objArr2[size2];
            objArr[size2] = null;
            objArr2[size2] = null;
            long[] jArr = this.entries;
            long j = jArr[size2];
            jArr[i] = j;
            jArr[size2] = -1;
            int hash = getHash(j) & hashTableMask();
            int[] iArr = this.table;
            int i2 = iArr[hash];
            if (i2 == size2) {
                iArr[hash] = i;
                return;
            }
            while (true) {
                long j2 = this.entries[i2];
                int next = getNext(j2);
                if (next == size2) {
                    this.entries[i2] = swapNext(j2, i);
                    return;
                }
                i2 = next;
            }
        } else {
            this.keys[i] = null;
            this.values[i] = null;
            this.entries[i] = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int getSuccessor(int i) {
        int i2 = i + 1;
        if (i2 < this.size) {
            return i2;
        }
        return -1;
    }

    abstract class Itr<T> implements Iterator<T> {
        int currentIndex;
        int expectedModCount;
        int indexToRemove;

        /* access modifiers changed from: package-private */
        public abstract T getOutput(int i);

        private Itr() {
            this.expectedModCount = CompactHashMap.this.modCount;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                int i = this.currentIndex;
                this.indexToRemove = i;
                T output = getOutput(i);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            this.expectedModCount++;
            CompactHashMap.this.removeEntry(this.indexToRemove);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Preconditions.checkNotNull(biFunction);
        for (int i = 0; i < this.size; i++) {
            Object[] objArr = this.values;
            objArr[i] = biFunction.apply(this.keys[i], objArr[i]);
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new KeySetView();
    }

    class KeySetView extends Maps.KeySet<K, V> {
        KeySetView() {
            super(CompactHashMap.this);
        }

        public Object[] toArray() {
            return ObjectArrays.copyAsObjectArray(CompactHashMap.this.keys, 0, CompactHashMap.this.size);
        }

        public <T> T[] toArray(T[] tArr) {
            return ObjectArrays.toArrayImpl(CompactHashMap.this.keys, 0, CompactHashMap.this.size, tArr);
        }

        public boolean remove(Object obj) {
            int indexOf = CompactHashMap.this.indexOf(obj);
            if (indexOf == -1) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public Spliterator<K> spliterator() {
            return Spliterators.spliterator(CompactHashMap.this.keys, 0, CompactHashMap.this.size, 17);
        }

        public void forEach(Consumer<? super K> consumer) {
            Preconditions.checkNotNull(consumer);
            for (int i = 0; i < CompactHashMap.this.size; i++) {
                consumer.accept(CompactHashMap.this.keys[i]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> keySetIterator() {
        return new CompactHashMap<K, V>.Itr<K>() {
            /* class com.google.common.collect.CompactHashMap.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public K getOutput(int i) {
                return CompactHashMap.this.keys[i];
            }
        };
    }

    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        for (int i = 0; i < this.size; i++) {
            biConsumer.accept(this.keys[i], this.values[i]);
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    class EntrySetView extends Maps.EntrySet<K, V> {
        EntrySetView() {
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> map() {
            return CompactHashMap.this;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        public Spliterator<Map.Entry<K, V>> spliterator() {
            return CollectSpliterators.indexed(CompactHashMap.this.size, 17, new IntFunction() {
                /* class com.google.common.collect.$$Lambda$CompactHashMap$EntrySetView$zx9uq9I50IJ3NBsUVususdSDP4g */

                public final Object apply(int i) {
                    return CompactHashMap.EntrySetView.this.lambda$spliterator$0$CompactHashMap$EntrySetView(i);
                }
            });
        }

        public /* synthetic */ Map.Entry lambda$spliterator$0$CompactHashMap$EntrySetView(int i) {
            return new MapEntry(i);
        }

        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int indexOf = CompactHashMap.this.indexOf(entry.getKey());
                if (indexOf == -1 || !Objects.equal(CompactHashMap.this.values[indexOf], entry.getValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            if (indexOf == -1 || !Objects.equal(CompactHashMap.this.values[indexOf], entry.getValue())) {
                return false;
            }
            CompactHashMap.this.removeEntry(indexOf);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            /* class com.google.common.collect.CompactHashMap.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public Map.Entry<K, V> getOutput(int i) {
                return new MapEntry(i);
            }
        };
    }

    final class MapEntry extends AbstractMapEntry<K, V> {
        private final K key;
        private int lastKnownIndex;

        MapEntry(int i) {
            this.key = CompactHashMap.this.keys[i];
            this.lastKnownIndex = i;
        }

        public final K getKey() {
            return this.key;
        }

        private void updateLastKnownIndex() {
            int i = this.lastKnownIndex;
            if (i == -1 || i >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        public final V getValue() {
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                return null;
            }
            return CompactHashMap.this.values[this.lastKnownIndex];
        }

        public final V setValue(V v) {
            updateLastKnownIndex();
            if (this.lastKnownIndex == -1) {
                CompactHashMap.this.put(this.key, v);
                return null;
            }
            V v2 = CompactHashMap.this.values[this.lastKnownIndex];
            CompactHashMap.this.values[this.lastKnownIndex] = v;
            return v2;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equal(obj, this.values[i])) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    /* access modifiers changed from: package-private */
    public Collection<V> createValues() {
        return new ValuesView();
    }

    class ValuesView extends Maps.Values<K, V> {
        ValuesView() {
            super(CompactHashMap.this);
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        public void forEach(Consumer<? super V> consumer) {
            Preconditions.checkNotNull(consumer);
            for (int i = 0; i < CompactHashMap.this.size; i++) {
                consumer.accept(CompactHashMap.this.values[i]);
            }
        }

        public Spliterator<V> spliterator() {
            return Spliterators.spliterator(CompactHashMap.this.values, 0, CompactHashMap.this.size, 16);
        }

        public Object[] toArray() {
            return ObjectArrays.copyAsObjectArray(CompactHashMap.this.values, 0, CompactHashMap.this.size);
        }

        public <T> T[] toArray(T[] tArr) {
            return ObjectArrays.toArrayImpl(CompactHashMap.this.values, 0, CompactHashMap.this.size, tArr);
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valuesIterator() {
        return new CompactHashMap<K, V>.Itr<V>() {
            /* class com.google.common.collect.CompactHashMap.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            public V getOutput(int i) {
                return CompactHashMap.this.values[i];
            }
        };
    }

    public void trimToSize() {
        int i = this.size;
        if (i < this.entries.length) {
            resizeEntries(i);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (((float) i) / this.loadFactor)));
        if (max < 1073741824) {
            double d = (double) i;
            double d2 = (double) max;
            Double.isNaN(d);
            Double.isNaN(d2);
            if (d / d2 > ((double) this.loadFactor)) {
                max <<= 1;
            }
        }
        if (max < this.table.length) {
            resizeTable(max);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(long[], long):void}
     arg types: [long[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void}
      ClspMth{java.util.Arrays.fill(long[], long):void} */
    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        for (int i = 0; i < this.size; i++) {
            objectOutputStream.writeObject(this.keys[i]);
            objectOutputStream.writeObject(this.values[i]);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt >= 0) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            } else {
                return;
            }
        }
    }
}
