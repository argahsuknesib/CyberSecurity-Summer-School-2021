package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
@FunctionalInterface
public interface Predicate<T> extends java.util.function.Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(Object obj);

    boolean equals(Object obj);

    boolean test(T t);

    /* renamed from: com.google.common.base.Predicate$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$test(Predicate _this, Object obj) {
            return _this.apply(obj);
        }
    }
}
