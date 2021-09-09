package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@FunctionalInterface
public interface Weigher<K, V> {
    int weigh(K k, V v);
}
