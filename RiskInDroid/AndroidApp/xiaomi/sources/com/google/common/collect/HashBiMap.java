package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@GwtCompatible(emulated = true)
public final class HashBiMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient BiEntry<K, V> firstInKeyInsertionOrder;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    @RetainedWith
    private transient BiMap<V, K> inverse;
    private transient BiEntry<K, V> lastInKeyInsertionOrder;
    private transient int mask;
    public transient int modCount;
    public transient int size;

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        BiEntry<K, V> nextInKToVBucket;
        BiEntry<K, V> nextInKeyInsertionOrder;
        BiEntry<K, V> nextInVToKBucket;
        BiEntry<K, V> prevInKeyInsertionOrder;
        final int valueHash;

        BiEntry(K k, int i, V v, int i2) {
            super(k, v);
            this.keyHash = i;
            this.valueHash = i2;
        }
    }

    private HashBiMap(int i) {
        init(i);
    }

    private void init(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        int closedTableSize = Hashing.closedTableSize(i, 1.0d);
        this.hashTableKToV = createTable(closedTableSize);
        this.hashTableVToK = createTable(closedTableSize);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.size = 0;
        this.mask = closedTableSize - 1;
        this.modCount = 0;
    }

    public final void delete(BiEntry<K, V> biEntry) {
        BiEntry<K, V> biEntry2;
        int i = biEntry.keyHash & this.mask;
        BiEntry<K, V> biEntry3 = null;
        BiEntry<K, V> biEntry4 = null;
        for (BiEntry<K, V> biEntry5 = this.hashTableKToV[i]; biEntry5 != biEntry; biEntry5 = biEntry5.nextInKToVBucket) {
            biEntry4 = biEntry5;
        }
        if (biEntry4 == null) {
            this.hashTableKToV[i] = biEntry.nextInKToVBucket;
        } else {
            biEntry4.nextInKToVBucket = biEntry.nextInKToVBucket;
        }
        int i2 = biEntry.valueHash & this.mask;
        BiEntry<K, V> biEntry6 = this.hashTableVToK[i2];
        while (true) {
            BiEntry<K, V> biEntry7 = biEntry3;
            biEntry3 = biEntry6;
            biEntry2 = biEntry7;
            if (biEntry3 == biEntry) {
                break;
            }
            biEntry6 = biEntry3.nextInVToKBucket;
        }
        if (biEntry2 == null) {
            this.hashTableVToK[i2] = biEntry.nextInVToKBucket;
        } else {
            biEntry2.nextInVToKBucket = biEntry.nextInVToKBucket;
        }
        if (biEntry.prevInKeyInsertionOrder == null) {
            this.firstInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        } else {
            biEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = biEntry.nextInKeyInsertionOrder;
        }
        if (biEntry.nextInKeyInsertionOrder == null) {
            this.lastInKeyInsertionOrder = biEntry.prevInKeyInsertionOrder;
        } else {
            biEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = biEntry.prevInKeyInsertionOrder;
        }
        this.size--;
        this.modCount++;
    }

    public final void insert(BiEntry<K, V> biEntry, BiEntry<K, V> biEntry2) {
        int i = biEntry.keyHash & this.mask;
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        biEntry.nextInKToVBucket = biEntryArr[i];
        biEntryArr[i] = biEntry;
        int i2 = biEntry.valueHash & this.mask;
        BiEntry<K, V>[] biEntryArr2 = this.hashTableVToK;
        biEntry.nextInVToKBucket = biEntryArr2[i2];
        biEntryArr2[i2] = biEntry;
        if (biEntry2 == null) {
            BiEntry<K, V> biEntry3 = this.lastInKeyInsertionOrder;
            biEntry.prevInKeyInsertionOrder = biEntry3;
            biEntry.nextInKeyInsertionOrder = null;
            if (biEntry3 == null) {
                this.firstInKeyInsertionOrder = biEntry;
            } else {
                biEntry3.nextInKeyInsertionOrder = biEntry;
            }
            this.lastInKeyInsertionOrder = biEntry;
        } else {
            biEntry.prevInKeyInsertionOrder = biEntry2.prevInKeyInsertionOrder;
            if (biEntry.prevInKeyInsertionOrder == null) {
                this.firstInKeyInsertionOrder = biEntry;
            } else {
                biEntry.prevInKeyInsertionOrder.nextInKeyInsertionOrder = biEntry;
            }
            biEntry.nextInKeyInsertionOrder = biEntry2.nextInKeyInsertionOrder;
            if (biEntry.nextInKeyInsertionOrder == null) {
                this.lastInKeyInsertionOrder = biEntry;
            } else {
                biEntry.nextInKeyInsertionOrder.prevInKeyInsertionOrder = biEntry;
            }
        }
        this.size++;
        this.modCount++;
    }

    public final BiEntry<K, V> seekByKey(Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.hashTableKToV[this.mask & i]; biEntry != null; biEntry = biEntry.nextInKToVBucket) {
            if (i == biEntry.keyHash && Objects.equal(obj, biEntry.key)) {
                return biEntry;
            }
        }
        return null;
    }

    public final BiEntry<K, V> seekByValue(Object obj, int i) {
        for (BiEntry<K, V> biEntry = this.hashTableVToK[this.mask & i]; biEntry != null; biEntry = biEntry.nextInVToKBucket) {
            if (i == biEntry.valueHash && Objects.equal(obj, biEntry.value)) {
                return biEntry;
            }
        }
        return null;
    }

    public final boolean containsKey(Object obj) {
        return seekByKey(obj, Hashing.smearedHash(obj)) != null;
    }

    public final boolean containsValue(Object obj) {
        return seekByValue(obj, Hashing.smearedHash(obj)) != null;
    }

    public final V get(Object obj) {
        return Maps.valueOrNull(seekByKey(obj, Hashing.smearedHash(obj)));
    }

    @CanIgnoreReturnValue
    public final V put(K k, V v) {
        return put(k, v, false);
    }

    private V put(K k, V v, boolean z) {
        int smearedHash = Hashing.smearedHash(k);
        int smearedHash2 = Hashing.smearedHash(v);
        BiEntry seekByKey = seekByKey(k, smearedHash);
        if (seekByKey != null && smearedHash2 == seekByKey.valueHash && Objects.equal(v, seekByKey.value)) {
            return v;
        }
        BiEntry seekByValue = seekByValue(v, smearedHash2);
        if (seekByValue != null) {
            if (z) {
                delete(seekByValue);
            } else {
                throw new IllegalArgumentException("value already present: ".concat(String.valueOf(v)));
            }
        }
        BiEntry biEntry = new BiEntry(k, smearedHash, v, smearedHash2);
        if (seekByKey != null) {
            delete(seekByKey);
            insert(biEntry, seekByKey);
            seekByKey.prevInKeyInsertionOrder = null;
            seekByKey.nextInKeyInsertionOrder = null;
            return seekByKey.value;
        }
        insert(biEntry, null);
        rehashIfNecessary();
        return null;
    }

    @CanIgnoreReturnValue
    public final V forcePut(K k, V v) {
        return put(k, v, true);
    }

    public final K putInverse(V v, K k, boolean z) {
        int smearedHash = Hashing.smearedHash(v);
        int smearedHash2 = Hashing.smearedHash(k);
        BiEntry seekByValue = seekByValue(v, smearedHash);
        BiEntry seekByKey = seekByKey(k, smearedHash2);
        if (seekByValue != null && smearedHash2 == seekByValue.keyHash && Objects.equal(k, seekByValue.key)) {
            return k;
        }
        if (seekByKey == null || z) {
            if (seekByValue != null) {
                delete(seekByValue);
            }
            if (seekByKey != null) {
                delete(seekByKey);
            }
            insert(new BiEntry(k, smearedHash2, v, smearedHash), seekByKey);
            if (seekByKey != null) {
                seekByKey.prevInKeyInsertionOrder = null;
                seekByKey.nextInKeyInsertionOrder = null;
            }
            if (seekByValue != null) {
                seekByValue.prevInKeyInsertionOrder = null;
                seekByValue.nextInKeyInsertionOrder = null;
            }
            rehashIfNecessary();
            return Maps.keyOrNull(seekByValue);
        }
        throw new IllegalArgumentException("key already present: ".concat(String.valueOf(k)));
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] biEntryArr = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, biEntryArr.length, 1.0d)) {
            int length = biEntryArr.length * 2;
            this.hashTableKToV = createTable(length);
            this.hashTableVToK = createTable(length);
            this.mask = length - 1;
            this.size = 0;
            for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                insert(biEntry, biEntry);
            }
            this.modCount++;
        }
    }

    private BiEntry<K, V>[] createTable(int i) {
        return new BiEntry[i];
    }

    @CanIgnoreReturnValue
    public final V remove(Object obj) {
        BiEntry seekByKey = seekByKey(obj, Hashing.smearedHash(obj));
        if (seekByKey == null) {
            return null;
        }
        delete(seekByKey);
        seekByKey.prevInKeyInsertionOrder = null;
        seekByKey.nextInKeyInsertionOrder = null;
        return seekByKey.value;
    }

    public final void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, (Object) null);
        Arrays.fill(this.hashTableVToK, (Object) null);
        this.firstInKeyInsertionOrder = null;
        this.lastInKeyInsertionOrder = null;
        this.modCount++;
    }

    public final int size() {
        return this.size;
    }

    abstract class Itr<T> implements Iterator<T> {
        int expectedModCount = HashBiMap.this.modCount;
        BiEntry<K, V> next = HashBiMap.this.firstInKeyInsertionOrder;
        int remaining = HashBiMap.this.size();
        BiEntry<K, V> toRemove = null;

        /* access modifiers changed from: package-private */
        public abstract T output(BiEntry<K, V> biEntry);

        Itr() {
        }

        public boolean hasNext() {
            if (HashBiMap.this.modCount == this.expectedModCount) {
                return this.next != null && this.remaining > 0;
            }
            throw new ConcurrentModificationException();
        }

        public T next() {
            if (hasNext()) {
                BiEntry<K, V> biEntry = this.next;
                this.next = biEntry.nextInKeyInsertionOrder;
                this.toRemove = biEntry;
                this.remaining--;
                return output(biEntry);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (HashBiMap.this.modCount == this.expectedModCount) {
                CollectPreconditions.checkRemove(this.toRemove != null);
                HashBiMap.this.delete(this.toRemove);
                this.expectedModCount = HashBiMap.this.modCount;
                this.toRemove = null;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public final Set<K> keySet() {
        return new KeySet();
    }

    final class KeySet extends Maps.KeySet<K, V> {
        KeySet() {
            super(HashBiMap.this);
        }

        public final Iterator<K> iterator() {
            return new HashBiMap<K, V>.Itr<K>() {
                /* class com.google.common.collect.HashBiMap.KeySet.AnonymousClass1 */

                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                /* access modifiers changed from: package-private */
                public K output(BiEntry<K, V> biEntry) {
                    return biEntry.key;
                }
            };
        }

        public final boolean remove(Object obj) {
            BiEntry seekByKey = HashBiMap.this.seekByKey(obj, Hashing.smearedHash(obj));
            if (seekByKey == null) {
                return false;
            }
            HashBiMap.this.delete(seekByKey);
            seekByKey.prevInKeyInsertionOrder = null;
            seekByKey.nextInKeyInsertionOrder = null;
            return true;
        }
    }

    public final Set<V> values() {
        return inverse().keySet();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<K, V>> entryIterator() {
        return new HashBiMap<K, V>.Itr<Map.Entry<K, V>>() {
            /* class com.google.common.collect.HashBiMap.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public Map.Entry<K, V> output(BiEntry<K, V> biEntry) {
                return new MapEntry(biEntry);
            }

            /* renamed from: com.google.common.collect.HashBiMap$1$MapEntry */
            class MapEntry extends AbstractMapEntry<K, V> {
                BiEntry<K, V> delegate;

                MapEntry(BiEntry<K, V> biEntry) {
                    this.delegate = biEntry;
                }

                public K getKey() {
                    return this.delegate.key;
                }

                public V getValue() {
                    return this.delegate.value;
                }

                public V setValue(V v) {
                    V v2 = this.delegate.value;
                    int smearedHash = Hashing.smearedHash(v);
                    if (smearedHash == this.delegate.valueHash && Objects.equal(v, v2)) {
                        return v;
                    }
                    Preconditions.checkArgument(HashBiMap.this.seekByValue(v, smearedHash) == null, "value already present: %s", v);
                    HashBiMap.this.delete(this.delegate);
                    BiEntry<K, V> biEntry = new BiEntry<>(this.delegate.key, this.delegate.keyHash, v, smearedHash);
                    HashBiMap.this.insert(biEntry, this.delegate);
                    BiEntry<K, V> biEntry2 = this.delegate;
                    biEntry2.prevInKeyInsertionOrder = null;
                    biEntry2.nextInKeyInsertionOrder = null;
                    AnonymousClass1 r6 = AnonymousClass1.this;
                    r6.expectedModCount = HashBiMap.this.modCount;
                    if (AnonymousClass1.this.toRemove == this.delegate) {
                        AnonymousClass1.this.toRemove = biEntry;
                    }
                    this.delegate = biEntry;
                    return v2;
                }
            }
        };
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
            biConsumer.accept(biEntry.key, biEntry.value);
        }
    }

    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Preconditions.checkNotNull(biFunction);
        clear();
        for (BiEntry<K, V> biEntry = this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
            put(biEntry.key, biFunction.apply(biEntry.key, biEntry.value));
        }
    }

    public final BiMap<V, K> inverse() {
        BiMap<V, K> biMap = this.inverse;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse2 = new Inverse();
        this.inverse = inverse2;
        return inverse2;
    }

    final class Inverse extends Maps.IteratorBasedAbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private Inverse() {
        }

        /* access modifiers changed from: package-private */
        public final BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        public final int size() {
            return HashBiMap.this.size;
        }

        public final void clear() {
            forward().clear();
        }

        public final boolean containsKey(Object obj) {
            return forward().containsValue(obj);
        }

        public final K get(Object obj) {
            return Maps.keyOrNull(HashBiMap.this.seekByValue(obj, Hashing.smearedHash(obj)));
        }

        @CanIgnoreReturnValue
        public final K put(V v, K k) {
            return HashBiMap.this.putInverse(v, k, false);
        }

        public final K forcePut(V v, K k) {
            return HashBiMap.this.putInverse(v, k, true);
        }

        public final K remove(Object obj) {
            BiEntry seekByValue = HashBiMap.this.seekByValue(obj, Hashing.smearedHash(obj));
            if (seekByValue == null) {
                return null;
            }
            HashBiMap.this.delete(seekByValue);
            seekByValue.prevInKeyInsertionOrder = null;
            seekByValue.nextInKeyInsertionOrder = null;
            return seekByValue.key;
        }

        public final BiMap<K, V> inverse() {
            return forward();
        }

        public final Set<V> keySet() {
            return new InverseKeySet();
        }

        final class InverseKeySet extends Maps.KeySet<V, K> {
            InverseKeySet() {
                super(Inverse.this);
            }

            public final boolean remove(Object obj) {
                BiEntry seekByValue = HashBiMap.this.seekByValue(obj, Hashing.smearedHash(obj));
                if (seekByValue == null) {
                    return false;
                }
                HashBiMap.this.delete(seekByValue);
                return true;
            }

            public final Iterator<V> iterator() {
                return new HashBiMap<K, V>.Itr<V>() {
                    /* class com.google.common.collect.HashBiMap.Inverse.InverseKeySet.AnonymousClass1 */

                    {
                        HashBiMap hashBiMap = HashBiMap.this;
                    }

                    /* access modifiers changed from: package-private */
                    public V output(BiEntry<K, V> biEntry) {
                        return biEntry.value;
                    }
                };
            }
        }

        public final Set<K> values() {
            return forward().keySet();
        }

        /* access modifiers changed from: package-private */
        public final Iterator<Map.Entry<V, K>> entryIterator() {
            return new HashBiMap<K, V>.Itr<Map.Entry<V, K>>() {
                /* class com.google.common.collect.HashBiMap.Inverse.AnonymousClass1 */

                {
                    HashBiMap hashBiMap = HashBiMap.this;
                }

                /* access modifiers changed from: package-private */
                public Map.Entry<V, K> output(BiEntry<K, V> biEntry) {
                    return new InverseEntry(biEntry);
                }

                /* renamed from: com.google.common.collect.HashBiMap$Inverse$1$InverseEntry */
                class InverseEntry extends AbstractMapEntry<V, K> {
                    BiEntry<K, V> delegate;

                    InverseEntry(BiEntry<K, V> biEntry) {
                        this.delegate = biEntry;
                    }

                    public V getKey() {
                        return this.delegate.value;
                    }

                    public K getValue() {
                        return this.delegate.key;
                    }

                    public K setValue(K k) {
                        K k2 = this.delegate.key;
                        int smearedHash = Hashing.smearedHash(k);
                        if (smearedHash == this.delegate.keyHash && Objects.equal(k, k2)) {
                            return k;
                        }
                        Preconditions.checkArgument(HashBiMap.this.seekByKey(k, smearedHash) == null, "value already present: %s", k);
                        HashBiMap.this.delete(this.delegate);
                        BiEntry<K, V> biEntry = new BiEntry<>(k, smearedHash, this.delegate.value, this.delegate.valueHash);
                        this.delegate = biEntry;
                        HashBiMap.this.insert(biEntry, null);
                        AnonymousClass1 r6 = AnonymousClass1.this;
                        r6.expectedModCount = HashBiMap.this.modCount;
                        return k2;
                    }
                }
            };
        }

        public final void forEach(BiConsumer<? super V, ? super K> biConsumer) {
            Preconditions.checkNotNull(biConsumer);
            HashBiMap.this.forEach(new BiConsumer(biConsumer) {
                /* class com.google.common.collect.$$Lambda$HashBiMap$Inverse$RpeIn_FowtHkkM0eHEOuMSgmjY */
                private final /* synthetic */ BiConsumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj, Object obj2) {
                    this.f$0.accept(obj2, obj);
                }
            });
        }

        public final void replaceAll(BiFunction<? super V, ? super K, ? extends K> biFunction) {
            Preconditions.checkNotNull(biFunction);
            clear();
            for (BiEntry<K, V> biEntry = HashBiMap.this.firstInKeyInsertionOrder; biEntry != null; biEntry = biEntry.nextInKeyInsertionOrder) {
                put(biEntry.value, biFunction.apply(biEntry.value, biEntry.key));
            }
        }

        /* access modifiers changed from: package-private */
        public final Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }
    }

    static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> hashBiMap) {
            this.bimap = hashBiMap;
        }

        /* access modifiers changed from: package-private */
        public final Object readResolve() {
            return this.bimap.inverse();
        }
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(16);
        Serialization.populateMap(this, objectInputStream, readCount);
    }
}
