package com.jakewharton.rxbinding.internal;

import rx.functions.Func0;
import rx.functions.Func1;

public final class Functions {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Func0<Boolean> f4502O000000o;
    public static final Func1<Object, Boolean> O00000Oo = O00000o0;
    private static final Always<Boolean> O00000o0;

    static {
        Always<Boolean> always = new Always<>(Boolean.TRUE);
        O00000o0 = always;
        f4502O000000o = always;
    }

    static final class Always<T> implements Func0<T>, Func1<Object, T> {
        private final T value;

        Always(T t) {
            this.value = t;
        }

        public final T call(Object obj) {
            return this.value;
        }

        public final T call() {
            return this.value;
        }
    }
}
