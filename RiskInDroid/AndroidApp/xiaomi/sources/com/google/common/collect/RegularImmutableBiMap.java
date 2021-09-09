package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap(null, null, (Map.Entry[]) ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    @VisibleForTesting
    final transient Map.Entry<K, V>[] entries;
    public final transient int hashCode;
    @RetainedWith
    @LazyInit
    private transient ImmutableBiMap<V, K> inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    public final transient int mask;
    public final transient ImmutableMapEntry<K, V>[] valueTable;

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    static <K, V> ImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    static <K, V> ImmutableBiMap<K, V> fromEntryArray(int i, Map.Entry<K, V>[] entryArr) {
        ImmutableMapEntry[] immutableMapEntryArr;
        int i2 = i;
        Map.Entry<K, V>[] entryArr2 = entryArr;
        Preconditions.checkPositionIndex(i2, entryArr2.length);
        int closedTableSize = Hashing.closedTableSize(i2, 1.2d);
        int i3 = closedTableSize - 1;
        ImmutableMapEntry[] createEntryArray = ImmutableMapEntry.createEntryArray(closedTableSize);
        ImmutableMapEntry[] createEntryArray2 = ImmutableMapEntry.createEntryArray(closedTableSize);
        if (i2 == entryArr2.length) {
            immutableMapEntryArr = entryArr2;
        } else {
            immutableMapEntryArr = ImmutableMapEntry.createEntryArray(i);
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Map.Entry<K, V> entry = entryArr2[i4];
            K key = entry.getKey();
            V value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            int hashCode2 = key.hashCode();
            int hashCode3 = value.hashCode();
            int smear = Hashing.smear(hashCode2) & i3;
            int smear2 = Hashing.smear(hashCode3) & i3;
            ImmutableMapEntry immutableMapEntry = createEntryArray[smear];
            int checkNoConflictInKeyBucket = RegularImmutableMap.checkNoConflictInKeyBucket(key, entry, immutableMapEntry);
            ImmutableMapEntry immutableMapEntry2 = createEntryArray2[smear2];
            int i6 = i3;
            int checkNoConflictInValueBucket = checkNoConflictInValueBucket(value, entry, immutableMapEntry2);
            int i7 = i5;
            if (checkNoConflictInKeyBucket > 8 || checkNoConflictInValueBucket > 8) {
                return JdkBackedImmutableBiMap.create(i, entryArr);
            }
            ImmutableMapEntry<K, V> makeImmutable = (immutableMapEntry2 == null && immutableMapEntry == null) ? RegularImmutableMap.makeImmutable(entry, key, value) : new ImmutableMapEntry.NonTerminalImmutableBiMapEntry<>(key, value, immutableMapEntry, immutableMapEntry2);
            createEntryArray[smear] = makeImmutable;
            createEntryArray2[smear2] = makeImmutable;
            immutableMapEntryArr[i4] = makeImmutable;
            i5 = i7 + (hashCode2 ^ hashCode3);
            i4++;
            i2 = i;
            entryArr2 = entryArr;
            i3 = i6;
        }
        return new RegularImmutableBiMap(createEntryArray, createEntryArray2, immutableMapEntryArr, i3, i5);
    }

    private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] immutableMapEntryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr2, Map.Entry<K, V>[] entryArr, int i, int i2) {
        this.keyTable = immutableMapEntryArr;
        this.valueTable = immutableMapEntryArr2;
        this.entries = entryArr;
        this.mask = i;
        this.hashCode = i2;
    }

    @CanIgnoreReturnValue
    private static int checkNoConflictInValueBucket(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        int i = 0;
        while (immutableMapEntry != null) {
            checkNoConflict(!obj.equals(immutableMapEntry.getValue()), "value", entry, immutableMapEntry);
            i++;
            immutableMapEntry = immutableMapEntry.getNextInValueBucket();
        }
        return i;
    }

    public V get(Object obj) {
        ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.keyTable;
        if (immutableMapEntryArr == null) {
            return null;
        }
        return RegularImmutableMap.get(obj, immutableMapEntryArr, this.mask);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        for (Map.Entry<K, V> entry : this.entries) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    public int hashCode() {
        return this.hashCode;
    }

    public int size() {
        return this.entries.length;
    }

    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap<V, K> immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        Inverse inverse2 = new Inverse();
        this.inverse = inverse2;
        return inverse2;
    }

    final class Inverse extends ImmutableBiMap<V, K> {
        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return false;
        }

        private Inverse() {
        }

        public final int size() {
            return inverse().size();
        }

        public final ImmutableBiMap<K, V> inverse() {
            return RegularImmutableBiMap.this;
        }

        public final void forEach(BiConsumer<? super V, ? super K> biConsumer) {
            Preconditions.checkNotNull(biConsumer);
            RegularImmutableBiMap.this.forEach(new BiConsumer(biConsumer) {
                /* class com.google.common.collect.$$Lambda$RegularImmutableBiMap$Inverse$39utWjSdb4qH9l60lU9_VgsnG5I */
                private final /* synthetic */ BiConsumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj, Object obj2) {
                    this.f$0.accept(obj2, obj);
                }
            });
        }

        public final K get(Object obj) {
            if (!(obj == null || RegularImmutableBiMap.this.valueTable == null)) {
                for (ImmutableMapEntry<K, V> immutableMapEntry = RegularImmutableBiMap.this.valueTable[Hashing.smear(obj.hashCode()) & RegularImmutableBiMap.this.mask]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInValueBucket()) {
                    if (obj.equals(immutableMapEntry.getValue())) {
                        return immutableMapEntry.getKey();
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final ImmutableSet<V> createKeySet() {
            return new ImmutableMapKeySet(this);
        }

        /* access modifiers changed from: package-private */
        public final ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            /* access modifiers changed from: package-private */
            public final boolean isHashCodeFast() {
                return true;
            }

            InverseEntrySet() {
            }

            /* access modifiers changed from: package-private */
            public final ImmutableMap<V, K> map() {
                return Inverse.this;
            }

            public final int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            public final UnmodifiableIterator<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }

            public final void forEach(Consumer<? super Map.Entry<V, K>> consumer) {
                asList().forEach(consumer);
            }

            /* access modifiers changed from: package-private */
            public final ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>() {
                    /* class com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.AnonymousClass1 */

                    public Map.Entry<V, K> get(int i) {
                        Map.Entry<K, V> entry = RegularImmutableBiMap.this.entries[i];
                        return Maps.immutableEntry(entry.getValue(), entry.getKey());
                    }

                    /* access modifiers changed from: package-private */
                    public ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }
                };
            }
        }

        /* access modifiers changed from: package-private */
        public final Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }
    }

    static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            this.forward = immutableBiMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.forward.inverse();
        }
    }
}
