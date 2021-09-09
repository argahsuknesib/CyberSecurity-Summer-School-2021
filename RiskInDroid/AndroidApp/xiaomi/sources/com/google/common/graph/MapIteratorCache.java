package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MapIteratorCache<K, V> {
    public final Map<K, V> backingMap;
    public transient Map.Entry<K, V> entrySetCache;

    MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    @CanIgnoreReturnValue
    public V put(K k, V v) {
        clearCache();
        return this.backingMap.put(k, v);
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        clearCache();
        return this.backingMap.remove(obj);
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public V get(Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        return getWithoutCaching(obj);
    }

    public final V getWithoutCaching(Object obj) {
        return this.backingMap.get(obj);
    }

    public final boolean containsKey(Object obj) {
        return getIfCached(obj) != null || this.backingMap.containsKey(obj);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() {
            /* class com.google.common.graph.MapIteratorCache.AnonymousClass1 */

            public UnmodifiableIterator<K> iterator() {
                final Iterator<Map.Entry<K, V>> it = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    /* class com.google.common.graph.MapIteratorCache.AnonymousClass1.AnonymousClass1 */

                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public K next() {
                        Map.Entry<K, V> entry = (Map.Entry) it.next();
                        MapIteratorCache.this.entrySetCache = entry;
                        return entry.getKey();
                    }
                };
            }

            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            public boolean contains(Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }
        };
    }

    /* access modifiers changed from: protected */
    public V getIfCached(Object obj) {
        Map.Entry<K, V> entry = this.entrySetCache;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: protected */
    public void clearCache() {
        this.entrySetCache = null;
    }
}
