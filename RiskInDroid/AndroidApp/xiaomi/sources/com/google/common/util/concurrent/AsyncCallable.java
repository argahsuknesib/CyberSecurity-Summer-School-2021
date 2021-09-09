package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@FunctionalInterface
@Beta
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
