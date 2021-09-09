package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean supportsFastOffset;

    public abstract long distance(C c, C c2);

    public abstract C next(C c);

    public abstract C previous(C c);

    public static DiscreteDomain<Integer> integers() {
        return IntegerDomain.INSTANCE;
    }

    static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        public static final IntegerDomain INSTANCE = new IntegerDomain();
        private static final long serialVersionUID = 0;

        public final String toString() {
            return "DiscreteDomain.integers()";
        }

        IntegerDomain() {
            super(true);
        }

        public final Integer next(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        public final Integer previous(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        /* access modifiers changed from: package-private */
        public final Integer offset(Integer num, long j) {
            CollectPreconditions.checkNonnegative(j, "distance");
            return Integer.valueOf(Ints.checkedCast(num.longValue() + j));
        }

        public final long distance(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        public final Integer minValue() {
            return Integer.MIN_VALUE;
        }

        public final Integer maxValue() {
            return Integer.MAX_VALUE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static DiscreteDomain<Long> longs() {
        return LongDomain.INSTANCE;
    }

    static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        public static final LongDomain INSTANCE = new LongDomain();
        private static final long serialVersionUID = 0;

        public final String toString() {
            return "DiscreteDomain.longs()";
        }

        LongDomain() {
            super(true);
        }

        public final Long next(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        public final Long previous(Long l) {
            long longValue = l.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        /* access modifiers changed from: package-private */
        public final Long offset(Long l, long j) {
            CollectPreconditions.checkNonnegative(j, "distance");
            long longValue = l.longValue() + j;
            if (longValue < 0) {
                Preconditions.checkArgument(l.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        public final long distance(Long l, Long l2) {
            long longValue = l2.longValue() - l.longValue();
            if (l2.longValue() > l.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l2.longValue() >= l.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        public final Long minValue() {
            return Long.MIN_VALUE;
        }

        public final Long maxValue() {
            return Long.MAX_VALUE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static DiscreteDomain<BigInteger> bigIntegers() {
        return BigIntegerDomain.INSTANCE;
    }

    static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        public static final BigIntegerDomain INSTANCE = new BigIntegerDomain();
        private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
        private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
        private static final long serialVersionUID = 0;

        public final String toString() {
            return "DiscreteDomain.bigIntegers()";
        }

        BigIntegerDomain() {
            super(true);
        }

        public final BigInteger next(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        public final BigInteger previous(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        /* access modifiers changed from: package-private */
        public final BigInteger offset(BigInteger bigInteger, long j) {
            CollectPreconditions.checkNonnegative(j, "distance");
            return bigInteger.add(BigInteger.valueOf(j));
        }

        public final long distance(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(MIN_LONG).min(MAX_LONG).longValue();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    protected DiscreteDomain() {
        this(false);
    }

    private DiscreteDomain(boolean z) {
        this.supportsFastOffset = z;
    }

    /* access modifiers changed from: package-private */
    public C offset(C c, long j) {
        CollectPreconditions.checkNonnegative(j, "distance");
        for (long j2 = 0; j2 < j; j2++) {
            c = next(c);
        }
        return c;
    }

    @CanIgnoreReturnValue
    public C minValue() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C maxValue() {
        throw new NoSuchElementException();
    }
}
