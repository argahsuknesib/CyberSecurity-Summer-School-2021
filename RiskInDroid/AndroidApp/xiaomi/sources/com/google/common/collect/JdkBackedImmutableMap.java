package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntrySet;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtCompatible(emulated = true)
final class JdkBackedImmutableMap<K, V> extends ImmutableMap<K, V> {
    private final transient Map<K, V> delegateMap;
    private final transient ImmutableList<Map.Entry<K, V>> entries;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    static <K, V> ImmutableMap<K, V> create(int i, Map.Entry<K, V>[] entryArr) {
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(i);
        int i2 = 0;
        while (i2 < i) {
            entryArr[i2] = RegularImmutableMap.makeImmutable(entryArr[i2]);
            Object putIfAbsent = newHashMapWithExpectedSize.putIfAbsent(entryArr[i2].getKey(), entryArr[i2].getValue());
            if (putIfAbsent == null) {
                i2++;
            } else {
                Map.Entry<K, V> entry = entryArr[i2];
                throw conflictException("key", entry, ((Object) entryArr[i2].getKey()) + "=" + putIfAbsent);
            }
        }
        return new JdkBackedImmutableMap(newHashMapWithExpectedSize, ImmutableList.asImmutableList(entryArr, i));
    }

    JdkBackedImmutableMap(Map<K, V> map, ImmutableList<Map.Entry<K, V>> immutableList) {
        this.delegateMap = map;
        this.entries = immutableList;
    }

    public final int size() {
        return this.entries.size();
    }

    public final V get(Object obj) {
        return this.delegateMap.get(obj);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        this.entries.forEach(new Consumer(biConsumer) {
            /* class com.google.common.collect.$$Lambda$JdkBackedImmutableMap$ThhB9akQzP54Zy7ZoDbOMOzR7V8 */
            private final /* synthetic */ BiConsumer f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                this.f$0.accept(((Map.Entry) obj).getKey(), ((Map.Entry) obj).getValue());
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableCollection<V> createValues() {
        return new ImmutableMapValues(this);
    }
}
