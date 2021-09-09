package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.function.Supplier;
import java.util.stream.Collector;

@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    public final BloomFilterStrategies.LockFreeBitArray bits;
    public final Funnel<? super T> funnel;
    public final int numHashFunctions;
    public final Strategy strategy;

    interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    public /* synthetic */ boolean test(T t) {
        return Predicate.CC.$default$test(this, t);
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i, Funnel<? super T> funnel2, Strategy strategy2) {
        boolean z = true;
        Preconditions.checkArgument(i > 0, "numHashFunctions (%s) must be > 0", i);
        Preconditions.checkArgument(i > 255 ? false : z, "numHashFunctions (%s) must be <= 255", i);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel2);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy2);
    }

    public final BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public final boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    @Deprecated
    public final boolean apply(T t) {
        return mightContain(t);
    }

    @CanIgnoreReturnValue
    public final boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public final double expectedFpp() {
        double bitCount = (double) this.bits.bitCount();
        double bitSize = (double) bitSize();
        Double.isNaN(bitCount);
        Double.isNaN(bitSize);
        return Math.pow(bitCount / bitSize, (double) this.numHashFunctions);
    }

    public final long approximateElementCount() {
        long bitSize = this.bits.bitSize();
        double bitCount = (double) this.bits.bitCount();
        double d = (double) bitSize;
        Double.isNaN(bitCount);
        Double.isNaN(d);
        Double.isNaN(d);
        double d2 = (-Math.log1p(-(bitCount / d))) * d;
        double d3 = (double) this.numHashFunctions;
        Double.isNaN(d3);
        return DoubleMath.roundToLong(d2 / d3, RoundingMode.HALF_UP);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final long bitSize() {
        return this.bits.bitSize();
    }

    public final boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public final void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        Preconditions.checkArgument(this.numHashFunctions == bloomFilter.numHashFunctions, "BloomFilters must have the same number of hash functions (%s != %s)", this.numHashFunctions, bloomFilter.numHashFunctions);
        Preconditions.checkArgument(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BloomFilter) {
            BloomFilter bloomFilter = (BloomFilter) obj;
            return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
        }
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> funnel2, long j) {
        return toBloomFilter(funnel2, j, 0.03d);
    }

    public static <T> Collector<T, ?, BloomFilter<T>> toBloomFilter(Funnel<? super T> funnel2, long j, double d) {
        Preconditions.checkNotNull(funnel2);
        Preconditions.checkArgument(j >= 0, "Expected insertions (%s) must be >= 0", j);
        Preconditions.checkArgument(d > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d));
        Preconditions.checkArgument(d < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d));
        return Collector.of(new Supplier(j, d) {
            /* class com.google.common.hash.$$Lambda$BloomFilter$l9TLjKZk1IpLy4A0zMOUaq8wjGo */
            private final /* synthetic */ long f$1;
            private final /* synthetic */ double f$2;

            {
                this.f$1 = r2;
                this.f$2 = r4;
            }

            public final Object get() {
                return BloomFilter.create(Funnel.this, this.f$1, this.f$2);
            }
        }, $$Lambda$P_MmmwgZ0XwLgyONpS1egK2lhh4.INSTANCE, $$Lambda$BloomFilter$j8mscn2wdfq_052DogsIYVyRf94.INSTANCE, Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i, double d) {
        return create(funnel2, (long) i, d);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j, double d) {
        return create(funnel2, j, d, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j, double d, Strategy strategy2) {
        Preconditions.checkNotNull(funnel2);
        boolean z = true;
        Preconditions.checkArgument(j >= 0, "Expected insertions (%s) must be >= 0", j);
        Preconditions.checkArgument(d > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d));
        if (d >= 1.0d) {
            z = false;
        }
        Preconditions.checkArgument(z, "False positive probability (%s) must be < 1.0", Double.valueOf(d));
        Preconditions.checkNotNull(strategy2);
        if (j == 0) {
            j = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j, d);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j, optimalNumOfBits), funnel2, strategy2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i) {
        return create(funnel2, (long) i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j) {
        return create(funnel2, j, 0.03d);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long j, long j2) {
        double d = (double) j2;
        double d2 = (double) j;
        Double.isNaN(d);
        Double.isNaN(d2);
        return Math.max(1, (int) Math.round((d / d2) * Math.log(2.0d)));
    }

    @VisibleForTesting
    static long optimalNumOfBits(long j, double d) {
        if (d == 0.0d) {
            d = Double.MIN_VALUE;
        }
        double d2 = (double) (-j);
        double log = Math.log(d);
        Double.isNaN(d2);
        return (long) ((d2 * log) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<? super T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(bloomFilter.bits.data);
            this.numHashFunctions = bloomFilter.numHashFunctions;
            this.funnel = bloomFilter.funnel;
            this.strategy = bloomFilter.strategy;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast((long) this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast((long) this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i = 0; i < this.bits.data.length(); i++) {
            dataOutputStream.writeLong(this.bits.data.get(i));
        }
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel2) throws IOException {
        byte b;
        int i;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel2, "Funnel");
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            b = dataInputStream.readByte();
            try {
                i = UnsignedBytes.toInt(dataInputStream.readByte());
            } catch (RuntimeException e) {
                e = e;
                i = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i + " dataLength: " + -1, e);
            }
            try {
                int readInt = dataInputStream.readInt();
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[b];
                long[] jArr = new long[readInt];
                for (int i2 = 0; i2 < readInt; i2++) {
                    jArr[i2] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(jArr), i, funnel2, bloomFilterStrategies);
            } catch (RuntimeException e2) {
                e = e2;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i + " dataLength: " + -1, e);
            }
        } catch (RuntimeException e3) {
            e = e3;
            b = -1;
            i = -1;
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b) + " numHashFunctions: " + i + " dataLength: " + -1, e);
        }
    }
}
