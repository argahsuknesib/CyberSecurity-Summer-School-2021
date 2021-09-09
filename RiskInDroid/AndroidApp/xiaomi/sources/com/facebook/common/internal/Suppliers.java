package com.facebook.common.internal;

public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = new Supplier<Boolean>() {
        /* class com.facebook.common.internal.Suppliers.AnonymousClass3 */

        public final Boolean get() {
            return Boolean.FALSE;
        }
    };
    public static final Supplier<Boolean> BOOLEAN_TRUE = new Supplier<Boolean>() {
        /* class com.facebook.common.internal.Suppliers.AnonymousClass2 */

        public final Boolean get() {
            return Boolean.TRUE;
        }
    };

    public static <T> Supplier<T> of(final T t) {
        return new Supplier<T>() {
            /* class com.facebook.common.internal.Suppliers.AnonymousClass1 */

            public final T get() {
                return t;
            }
        };
    }
}
