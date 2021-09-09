package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.util.HashMap;
import java.util.Map;

@GwtCompatible(emulated = true)
final class JdkBackedImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    private final Map<V, K> backwardDelegate;
    public final transient ImmutableList<Map.Entry<K, V>> entries;
    private final Map<K, V> forwardDelegate;
    @RetainedWith
    @LazyInit
    private transient JdkBackedImmutableBiMap<V, K> inverse;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    @VisibleForTesting
    static <K, V> ImmutableBiMap<K, V> create(int i, Map.Entry<K, V>[] entryArr) {
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(i);
        HashMap newHashMapWithExpectedSize2 = Maps.newHashMapWithExpectedSize(i);
        int i2 = 0;
        while (i2 < i) {
            ImmutableMapEntry makeImmutable = RegularImmutableMap.makeImmutable(entryArr[i2]);
            entryArr[i2] = makeImmutable;
            Object putIfAbsent = newHashMapWithExpectedSize.putIfAbsent(makeImmutable.getKey(), makeImmutable.getValue());
            if (putIfAbsent == null) {
                Object putIfAbsent2 = newHashMapWithExpectedSize2.putIfAbsent(makeImmutable.getValue(), makeImmutable.getKey());
                if (putIfAbsent2 == null) {
                    i2++;
                } else {
                    throw conflictException("value", putIfAbsent2 + "=" + ((Object) makeImmutable.getValue()), entryArr[i2]);
                }
            } else {
                throw conflictException("key", ((Object) makeImmutable.getKey()) + "=" + putIfAbsent, entryArr[i2]);
            }
        }
        return new JdkBackedImmutableBiMap(ImmutableList.asImmutableList(entryArr, i), newHashMapWithExpectedSize, newHashMapWithExpectedSize2);
    }

    private JdkBackedImmutableBiMap(ImmutableList<Map.Entry<K, V>> immutableList, Map<K, V> map, Map<V, K> map2) {
        this.entries = immutableList;
        this.forwardDelegate = map;
        this.backwardDelegate = map2;
    }

    public final int size() {
        return this.entries.size();
    }

    public final ImmutableBiMap<V, K> inverse() {
        JdkBackedImmutableBiMap<V, K> jdkBackedImmutableBiMap = this.inverse;
        if (jdkBackedImmutableBiMap != null) {
            return jdkBackedImmutableBiMap;
        }
        JdkBackedImmutableBiMap<V, K> jdkBackedImmutableBiMap2 = new JdkBackedImmutableBiMap<>(new InverseEntries(), this.backwardDelegate, this.forwardDelegate);
        this.inverse = jdkBackedImmutableBiMap2;
        jdkBackedImmutableBiMap2.inverse = this;
        return jdkBackedImmutableBiMap2;
    }

    final class InverseEntries extends ImmutableList<Map.Entry<V, K>> {
        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return false;
        }

        private InverseEntries() {
        }

        public final Map.Entry<V, K> get(int i) {
            Map.Entry entry = JdkBackedImmutableBiMap.this.entries.get(i);
            return Maps.immutableEntry(entry.getValue(), entry.getKey());
        }

        public final int size() {
            return JdkBackedImmutableBiMap.this.entries.size();
        }
    }

    public final V get(Object obj) {
        return this.forwardDelegate.get(obj);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }
}
