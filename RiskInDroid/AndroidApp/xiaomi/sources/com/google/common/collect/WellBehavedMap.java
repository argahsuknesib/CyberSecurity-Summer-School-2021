package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class WellBehavedMap<K, V> extends ForwardingMap<K, V> {
    private final Map<K, V> delegate;
    private Set<Map.Entry<K, V>> entrySet;

    private WellBehavedMap(Map<K, V> map) {
        this.delegate = map;
    }

    static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> map) {
        return new WellBehavedMap<>(map);
    }

    /* access modifiers changed from: protected */
    public final Map<K, V> delegate() {
        return this.delegate;
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    final class EntrySet extends Maps.EntrySet<K, V> {
        private EntrySet() {
        }

        /* access modifiers changed from: package-private */
        public final Map<K, V> map() {
            return WellBehavedMap.this;
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new TransformedIterator<K, Map.Entry<K, V>>(WellBehavedMap.this.keySet().iterator()) {
                /* class com.google.common.collect.WellBehavedMap.EntrySet.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public Map.Entry<K, V> transform(final K k) {
                    return new AbstractMapEntry<K, V>() {
                        /* class com.google.common.collect.WellBehavedMap.EntrySet.AnonymousClass1.AnonymousClass1 */

                        public K getKey() {
                            return k;
                        }

                        public V getValue() {
                            return WellBehavedMap.this.get(k);
                        }

                        public V setValue(V v) {
                            return WellBehavedMap.this.put(k, v);
                        }
                    };
                }
            };
        }
    }
}
