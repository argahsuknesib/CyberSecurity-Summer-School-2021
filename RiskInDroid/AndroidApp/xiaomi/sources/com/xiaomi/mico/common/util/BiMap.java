package com.xiaomi.mico.common.util;

import java.util.HashMap;

public class BiMap<K, V> {
    private HashMap<K, V> mapkv = new HashMap<>();
    private HashMap<V, K> mapvk = new HashMap<>();

    public BiMap<K, V> put(K k, V v) {
        this.mapkv.put(k, v);
        this.mapvk.put(v, k);
        return this;
    }

    public V value(K k) {
        return this.mapkv.get(k);
    }

    public K key(V v) {
        return this.mapvk.get(v);
    }
}
