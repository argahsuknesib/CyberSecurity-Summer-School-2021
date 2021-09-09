package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
@FunctionalInterface
public interface Supplier<T> extends java.util.function.Supplier<T> {
    @CanIgnoreReturnValue
    T get();
}
