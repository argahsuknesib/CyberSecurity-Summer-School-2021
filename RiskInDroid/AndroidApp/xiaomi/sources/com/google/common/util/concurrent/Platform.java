package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform {
    static boolean isInstanceOfThrowableClass(Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }

    private Platform() {
    }
}
