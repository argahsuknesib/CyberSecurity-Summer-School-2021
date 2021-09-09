package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;

@GwtCompatible
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    public static <K, V> RemovalNotification<K, V> create(K k, V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    private RemovalNotification(K k, V v, RemovalCause removalCause) {
        super(k, v);
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    public final RemovalCause getCause() {
        return this.cause;
    }

    public final boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
