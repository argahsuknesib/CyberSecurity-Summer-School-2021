package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    @CanIgnoreReturnValue
    public final boolean set(V v) {
        return super.set(v);
    }

    @CanIgnoreReturnValue
    public final boolean setException(Throwable th) {
        return super.setException(th);
    }

    @CanIgnoreReturnValue
    @Beta
    public final boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    private SettableFuture() {
    }
}
