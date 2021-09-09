package com.alibaba.android.arouter.base;

import java.util.TreeMap;

public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {
    private String tipText;

    public UniqueKeyTreeMap(String str) {
        this.tipText = str;
    }

    public V put(K k, V v) {
        if (!containsKey(k)) {
            return super.put(k, v);
        }
        throw new RuntimeException(String.format(this.tipText, k));
    }
}
