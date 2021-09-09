package com.fasterxml.jackson.databind.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUMap<K, V> extends LinkedHashMap<K, V> {
    protected final int _maxEntries;

    public LRUMap(int i, int i2) {
        super(i, 0.8f, true);
        this._maxEntries = i2;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this._maxEntries;
    }
}
