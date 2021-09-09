package org.apache.commons.lang3.concurrent;

import _m_j.jdf;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class ConcurrentUtils {
    static Throwable O000000o(Throwable th) {
        jdf.O000000o(th != null && !(th instanceof RuntimeException) && !(th instanceof Error), "Not a checked exception: ".concat(String.valueOf(th)), new Object[0]);
        return th;
    }

    static final class ConstantFuture<T> implements Future<T> {
        private final T value;

        public final boolean cancel(boolean z) {
            return false;
        }

        public final boolean isCancelled() {
            return false;
        }

        public final boolean isDone() {
            return true;
        }

        ConstantFuture(T t) {
            this.value = t;
        }

        public final T get() {
            return this.value;
        }

        public final T get(long j, TimeUnit timeUnit) {
            return this.value;
        }
    }
}
