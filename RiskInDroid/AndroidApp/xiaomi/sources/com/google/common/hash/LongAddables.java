package com.google.common.hash;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    LongAddables() {
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() {
                /* class com.google.common.hash.LongAddables.AnonymousClass1 */

                public final LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() {
                /* class com.google.common.hash.LongAddables.AnonymousClass2 */

                public final LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }

    static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        public final void increment() {
            getAndIncrement();
        }

        public final void add(long j) {
            getAndAdd(j);
        }

        public final long sum() {
            return get();
        }
    }
}
