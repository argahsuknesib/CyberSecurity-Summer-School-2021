package com.facebook.common.internal;

import com.android.internal.util.Predicate;

public class AndroidPredicates {
    private AndroidPredicates() {
    }

    public static <T> Predicate<T> True() {
        return new Predicate<T>() {
            /* class com.facebook.common.internal.AndroidPredicates.AnonymousClass1 */

            public final boolean apply(T t) {
                return true;
            }
        };
    }

    public static <T> Predicate<T> False() {
        return new Predicate<T>() {
            /* class com.facebook.common.internal.AndroidPredicates.AnonymousClass2 */

            public final boolean apply(T t) {
                return false;
            }
        };
    }
}
