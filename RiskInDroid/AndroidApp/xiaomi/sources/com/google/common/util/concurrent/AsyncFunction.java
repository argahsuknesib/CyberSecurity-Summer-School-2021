package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@FunctionalInterface
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I i) throws Exception;
}
