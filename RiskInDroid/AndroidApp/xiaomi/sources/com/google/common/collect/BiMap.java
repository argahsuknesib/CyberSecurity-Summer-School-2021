package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {

    /* renamed from: com.google.common.collect.BiMap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    @CanIgnoreReturnValue
    V forcePut(K k, V v);

    BiMap<V, K> inverse();

    @CanIgnoreReturnValue
    V put(K k, V v);

    void putAll(Map<? extends K, ? extends V> map);

    Set<V> values();
}
