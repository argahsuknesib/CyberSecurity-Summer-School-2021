package com.google.common.hash;

import android.support.v4.app.NotificationCompat;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@Immutable
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    static final HashFunction MURMUR3_128 = new Murmur3_128HashFunction(0);
    private static final long serialVersionUID = 0;
    private final int seed;

    public final int bits() {
        return NotificationCompat.FLAG_HIGH_PRIORITY;
    }

    Murmur3_128HashFunction(int i) {
        this.seed = i;
    }

    public final Hasher newHasher() {
        return new Murmur3_128Hasher(this.seed);
    }

    public final String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Murmur3_128HashFunction) || this.seed != ((Murmur3_128HashFunction) obj).seed) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }

    static final class Murmur3_128Hasher extends AbstractStreamingHasher {
        private long h1;
        private long h2;
        private int length = 0;

        private static long fmix64(long j) {
            long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
            long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
            return j3 ^ (j3 >>> 33);
        }

        Murmur3_128Hasher(int i) {
            super(16);
            long j = (long) i;
            this.h1 = j;
            this.h2 = j;
        }

        /* access modifiers changed from: protected */
        public final void process(ByteBuffer byteBuffer) {
            bmix64(byteBuffer.getLong(), byteBuffer.getLong());
            this.length += 16;
        }

        private void bmix64(long j, long j2) {
            this.h1 = mixK1(j) ^ this.h1;
            this.h1 = Long.rotateLeft(this.h1, 27);
            long j3 = this.h1;
            long j4 = this.h2;
            this.h1 = j3 + j4;
            this.h1 = (this.h1 * 5) + 1390208809;
            this.h2 = mixK2(j2) ^ j4;
            this.h2 = Long.rotateLeft(this.h2, 31);
            this.h2 += this.h1;
            this.h2 = (this.h2 * 5) + 944331445;
        }

        /* access modifiers changed from: protected */
        public final void processRemaining(ByteBuffer byteBuffer) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            long j10;
            long j11;
            long j12;
            long j13;
            long j14;
            this.length += byteBuffer.remaining();
            switch (byteBuffer.remaining()) {
                case 1:
                    j3 = 0;
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case 2:
                    j4 = 0;
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case 3:
                    j5 = 0;
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case 4:
                    j6 = 0;
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case 5:
                    j7 = 0;
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case 6:
                    j8 = 0;
                    j7 = j8 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40);
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case 7:
                    j8 = (((long) UnsignedBytes.toInt(byteBuffer.get(6))) << 48) ^ 0;
                    j7 = j8 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(5))) << 40);
                    j6 = j7 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(4))) << 32);
                    j5 = j6 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(3))) << 24);
                    j4 = j5 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(2))) << 16);
                    j3 = j4 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(1))) << 8);
                    j = ((long) UnsignedBytes.toInt(byteBuffer.get(0))) ^ j3;
                    j2 = 0;
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    j2 = 0;
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case 9:
                    j9 = 0;
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case 10:
                    j10 = 0;
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case 11:
                    j11 = 0;
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    j12 = 0;
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case 13:
                    j13 = 0;
                    j12 = j13 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case 14:
                    j14 = 0;
                    j13 = j14 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40);
                    j12 = j13 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    j14 = (((long) UnsignedBytes.toInt(byteBuffer.get(14))) << 48) ^ 0;
                    j13 = j14 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(13))) << 40);
                    j12 = j13 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(12))) << 32);
                    j11 = j12 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(11))) << 24);
                    j10 = j11 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(10))) << 16);
                    j9 = j10 ^ (((long) UnsignedBytes.toInt(byteBuffer.get(9))) << 8);
                    j2 = j9 ^ ((long) UnsignedBytes.toInt(byteBuffer.get(8)));
                    j = byteBuffer.getLong() ^ 0;
                    break;
                default:
                    throw new AssertionError("Should never get here.");
            }
            this.h1 = mixK1(j) ^ this.h1;
            this.h2 = mixK2(j2) ^ this.h2;
        }

        public final HashCode makeHash() {
            long j = this.h1;
            int i = this.length;
            this.h1 = j ^ ((long) i);
            this.h2 ^= (long) i;
            long j2 = this.h1;
            long j3 = this.h2;
            this.h1 = j2 + j3;
            long j4 = this.h1;
            this.h2 = j3 + j4;
            this.h1 = fmix64(j4);
            this.h2 = fmix64(this.h2);
            long j5 = this.h1;
            long j6 = this.h2;
            this.h1 = j5 + j6;
            this.h2 = j6 + this.h1;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.h1).putLong(this.h2).array());
        }

        private static long mixK1(long j) {
            return Long.rotateLeft(j * -8663945395140668459L, 31) * 5545529020109919103L;
        }

        private static long mixK2(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * -8663945395140668459L;
        }
    }
}
