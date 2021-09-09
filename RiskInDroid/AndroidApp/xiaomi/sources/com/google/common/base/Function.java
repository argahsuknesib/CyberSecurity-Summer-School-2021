package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
@FunctionalInterface
public interface Function<F, T> extends java.util.function.Function<F, T> {
    @CanIgnoreReturnValue
    T apply(Object obj);

    boolean equals(Object obj);
}
