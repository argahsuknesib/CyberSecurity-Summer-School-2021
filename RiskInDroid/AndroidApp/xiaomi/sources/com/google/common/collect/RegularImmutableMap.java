package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((Map.Entry[]) ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    final transient Map.Entry<K, V>[] entries;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] table;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    static <K, V> ImmutableMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    static <K, V> ImmutableMap<K, V> fromEntryArray(int i, Map.Entry<K, V>[] entryArr) {
        Map.Entry<K, V>[] entryArr2;
        Preconditions.checkPositionIndex(i, entryArr.length);
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == entryArr.length) {
            entryArr2 = entryArr;
        } else {
            entryArr2 = ImmutableMapEntry.createEntryArray(i);
        }
        int closedTableSize = Hashing.closedTableSize(i, 1.2d);
        ImmutableMapEntry[] createEntryArray = ImmutableMapEntry.createEntryArray(closedTableSize);
        int i2 = closedTableSize - 1;
        for (int i3 = 0; i3 < i; i3++) {
            Map.Entry<K, V> entry = entryArr[i3];
            K key = entry.getKey();
            V value = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value);
            int smear = Hashing.smear(key.hashCode()) & i2;
            ImmutableMapEntry immutableMapEntry = createEntryArray[smear];
            ImmutableMapEntry makeImmutable = immutableMapEntry == null ? makeImmutable(entry, key, value) : new ImmutableMapEntry.NonTerminalImmutableMapEntry(key, value, immutableMapEntry);
            createEntryArray[smear] = makeImmutable;
            entryArr2[i3] = makeImmutable;
            if (checkNoConflictInKeyBucket(key, makeImmutable, immutableMapEntry) > 8) {
                return JdkBackedImmutableMap.create(i, entryArr);
            }
        }
        return new RegularImmutableMap(entryArr2, createEntryArray, i2);
    }

    static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> entry, K k, V v) {
        return (entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable() ? (ImmutableMapEntry) entry : new ImmutableMapEntry<>(k, v);
    }

    static <K, V> ImmutableMapEntry<K, V> makeImmutable(Map.Entry<K, V> entry) {
        return makeImmutable(entry, entry.getKey(), entry.getValue());
    }

    private RegularImmutableMap(Map.Entry<K, V>[] entryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr, int i) {
        this.entries = entryArr;
        this.table = immutableMapEntryArr;
        this.mask = i;
    }

    @CanIgnoreReturnValue
    static int checkNoConflictInKeyBucket(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        int i = 0;
        while (immutableMapEntry != null) {
            checkNoConflict(!obj.equals(immutableMapEntry.getKey()), "key", entry, immutableMapEntry);
            i++;
            immutableMapEntry = immutableMapEntry.getNextInKeyBucket();
        }
        return i;
    }

    public final V get(Object obj) {
        return get(obj, this.table, this.mask);
    }

    static <V> V get(Object obj, ImmutableMapEntry<?, V>[] immutableMapEntryArr, int i) {
        if (!(obj == null || immutableMapEntryArr == null)) {
            for (ImmutableMapEntry<?, V> immutableMapEntry = immutableMapEntryArr[i & Hashing.smear(obj.hashCode())]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInKeyBucket()) {
                if (obj.equals(immutableMapEntry.getKey())) {
                    return immutableMapEntry.getValue();
                }
            }
        }
        return null;
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        for (Map.Entry<K, V> entry : this.entries) {
            biConsumer.accept(entry.getKey(), entry.getValue());
        }
    }

    public final int size() {
        return this.entries.length;
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @GwtCompatible(emulated = true)
    static final class KeySet<K, V> extends IndexedImmutableSet<K> {
        @Weak
        private final RegularImmutableMap<K, V> map;

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return true;
        }

        KeySet(RegularImmutableMap<K, V> regularImmutableMap) {
            this.map = regularImmutableMap;
        }

        /* access modifiers changed from: package-private */
        public final K get(int i) {
            return this.map.entries[i].getKey();
        }

        public final boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        public final int size() {
            return this.map.size();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public final Object writeReplace() {
            return new SerializedForm(this.map);
        }

        @GwtIncompatible
        static class SerializedForm<K> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<K, ?> map;

            SerializedForm(ImmutableMap<K, ?> immutableMap) {
                this.map = immutableMap;
            }

            /* access modifiers changed from: package-private */
            public Object readResolve() {
                return this.map.keySet();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @GwtCompatible(emulated = true)
    static final class Values<K, V> extends ImmutableList<V> {
        @Weak
        final RegularImmutableMap<K, V> map;

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return true;
        }

        Values(RegularImmutableMap<K, V> regularImmutableMap) {
            this.map = regularImmutableMap;
        }

        public final V get(int i) {
            return this.map.entries[i].getValue();
        }

        public final int size() {
            return this.map.size();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public final Object writeReplace() {
            return new SerializedForm(this.map);
        }

        @GwtIncompatible
        static class SerializedForm<V> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<?, V> map;

            SerializedForm(ImmutableMap<?, V> immutableMap) {
                this.map = immutableMap;
            }

            /* access modifiers changed from: package-private */
            public Object readResolve() {
                return this.map.values();
            }
        }
    }
}
