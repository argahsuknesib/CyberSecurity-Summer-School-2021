package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 {
        public final <T> boolean put(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                z |= lockFreeBitArray.set(((long) i5) % bitSize);
            }
            return z;
        }

        public final <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            long asLong = Hashing.murmur3_128().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 ^= -1;
                }
                if (!lockFreeBitArray.get(((long) i5) % bitSize)) {
                    return false;
                }
            }
            return true;
        }
    },
    MURMUR128_MITZ_64 {
        public final <T> boolean put(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            long j = lowerEight;
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= lockFreeBitArray.set((Long.MAX_VALUE & j) % bitSize);
                j += upperEight;
            }
            return z;
        }

        public final <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, LockFreeBitArray lockFreeBitArray) {
            long bitSize = lockFreeBitArray.bitSize();
            byte[] bytesInternal = Hashing.murmur3_128().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            long j = lowerEight;
            for (int i2 = 0; i2 < i; i2++) {
                if (!lockFreeBitArray.get((Long.MAX_VALUE & j) % bitSize)) {
                    return false;
                }
                j += upperEight;
            }
            return true;
        }

        private long lowerEight(byte[] bArr) {
            return Longs.fromBytes(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.fromBytes(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }
    };

    static final class LockFreeBitArray {
        private final LongAddable bitCount;
        final AtomicLongArray data;

        LockFreeBitArray(long j) {
            this(new long[Ints.checkedCast(LongMath.divide(j, 64, RoundingMode.CEILING))]);
        }

        LockFreeBitArray(long[] jArr) {
            Preconditions.checkArgument(jArr.length > 0, "data length is zero!");
            this.data = new AtomicLongArray(jArr);
            this.bitCount = LongAddables.create();
            long j = 0;
            for (long bitCount2 : jArr) {
                j += (long) Long.bitCount(bitCount2);
            }
            this.bitCount.add(j);
        }

        /* access modifiers changed from: package-private */
        public final boolean set(long j) {
            long j2;
            long j3;
            if (get(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.data.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.data.compareAndSet(i, j2, j3));
            this.bitCount.increment();
            return true;
        }

        /* access modifiers changed from: package-private */
        public final boolean get(long j) {
            return ((1 << ((int) j)) & this.data.get((int) (j >>> 6))) != 0;
        }

        public static long[] toPlainArray(AtomicLongArray atomicLongArray) {
            long[] jArr = new long[atomicLongArray.length()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        /* access modifiers changed from: package-private */
        public final long bitSize() {
            return ((long) this.data.length()) * 64;
        }

        /* access modifiers changed from: package-private */
        public final long bitCount() {
            return this.bitCount.sum();
        }

        /* access modifiers changed from: package-private */
        public final LockFreeBitArray copy() {
            return new LockFreeBitArray(toPlainArray(this.data));
        }

        /* access modifiers changed from: package-private */
        public final void putAll(LockFreeBitArray lockFreeBitArray) {
            long j;
            long j2;
            boolean z;
            LockFreeBitArray lockFreeBitArray2 = lockFreeBitArray;
            Preconditions.checkArgument(this.data.length() == lockFreeBitArray2.data.length(), "BitArrays must be of equal length (%s != %s)", this.data.length(), lockFreeBitArray2.data.length());
            for (int i = 0; i < this.data.length(); i++) {
                long j3 = lockFreeBitArray2.data.get(i);
                while (true) {
                    j = this.data.get(i);
                    j2 = j | j3;
                    if (j != j2) {
                        if (this.data.compareAndSet(i, j, j2)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    this.bitCount.add((long) (Long.bitCount(j2) - Long.bitCount(j)));
                }
            }
        }

        public final boolean equals(Object obj) {
            if (obj instanceof LockFreeBitArray) {
                return Arrays.equals(toPlainArray(this.data), toPlainArray(((LockFreeBitArray) obj).data));
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(toPlainArray(this.data));
        }
    }
}
