package com.google.common.hash;

import android.support.v4.app.NotificationCompat;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    private static final long serialVersionUID = 0;
    private final int seed;

    public static long charToThreeUtf8Bytes(char c) {
        return (long) ((((c & '?') | 128) << 16) | (((c >>> 12) | 480) & 255) | ((((c >>> 6) & 63) | NotificationCompat.FLAG_HIGH_PRIORITY) << 8));
    }

    public static long charToTwoUtf8Bytes(char c) {
        return (long) ((((c & '?') | 128) << 8) | (((c >>> 6) | 960) & 255));
    }

    public static long codePointToFourUtf8Bytes(int i) {
        return ((((long) (i >>> 18)) | 240) & 255) | ((((long) ((i >>> 12) & 63)) | 128) << 8) | ((((long) ((i >>> 6) & 63)) | 128) << 16) | ((((long) (i & 63)) | 128) << 24);
    }

    public final int bits() {
        return 32;
    }

    Murmur3_32HashFunction(int i) {
        this.seed = i;
    }

    public final Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public final String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Murmur3_32HashFunction) || this.seed != ((Murmur3_32HashFunction) obj).seed) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return getClass().hashCode() ^ this.seed;
    }

    public final HashCode hashInt(int i) {
        return fmix(mixH1(this.seed, mixK1(i)), 4);
    }

    public final HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j)), mixK1(i)), 8);
    }

    public final HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.seed;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = mixH1(i, mixK1(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i, charSequence.length() * 2);
    }

    public final HashCode hashString(CharSequence charSequence, Charset charset) {
        int i;
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int i2 = 0;
        int i3 = this.seed;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + 4;
            if (i6 > length) {
                break;
            }
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence.charAt(i4 + 1);
            char charAt3 = charSequence.charAt(i4 + 2);
            char charAt4 = charSequence.charAt(i4 + 3);
            if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                break;
            }
            i3 = mixH1(i3, mixK1((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
            i5 = i + 4;
            i4 = i6;
        }
        long j = 0;
        while (i4 < length) {
            char charAt5 = charSequence.charAt(i4);
            if (charAt5 < 128) {
                j |= ((long) charAt5) << i2;
                i2 += 8;
                i++;
            } else if (charAt5 < 2048) {
                j |= charToTwoUtf8Bytes(charAt5) << i2;
                i2 += 16;
                i += 2;
            } else if (charAt5 < 55296 || charAt5 > 57343) {
                j |= charToThreeUtf8Bytes(charAt5) << i2;
                i2 += 24;
                i += 3;
            } else {
                int codePointAt = Character.codePointAt(charSequence, i4);
                if (codePointAt == charAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i4++;
                j |= codePointToFourUtf8Bytes(codePointAt) << i2;
                i += 4;
            }
            if (i2 >= 32) {
                i3 = mixH1(i3, mixK1((int) j));
                j >>>= 32;
                i2 -= 32;
            }
            i4++;
        }
        return fmix(mixK1((int) j) ^ i3, i);
    }

    public final HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        int i3 = 0;
        int i4 = this.seed;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 4;
            if (i6 > i2) {
                break;
            }
            i4 = mixH1(i4, mixK1(getIntLittleEndian(bArr, i5 + i)));
            i5 = i6;
        }
        int i7 = 0;
        while (i5 < i2) {
            i3 ^= UnsignedBytes.toInt(bArr[i + i5]) << i7;
            i5++;
            i7 += 8;
        }
        return fmix(mixK1(i3) ^ i4, i2);
    }

    public static int getIntLittleEndian(byte[] bArr, int i) {
        return Ints.fromBytes(bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
    }

    public static int mixK1(int i) {
        return Integer.rotateLeft(i * -862048943, 15) * 461845907;
    }

    public static int mixH1(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    public static HashCode fmix(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * -2048144789;
        int i5 = (i4 ^ (i4 >>> 13)) * -1028477387;
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    @CanIgnoreReturnValue
    static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;
        private int h1;
        private boolean isDone = false;
        private int length = 0;
        private int shift;

        Murmur3_32Hasher(int i) {
            this.h1 = i;
        }

        private void update(int i, long j) {
            long j2 = this.buffer;
            int i2 = this.shift;
            this.buffer = ((j & 4294967295L) << i2) | j2;
            this.shift = i2 + (i * 8);
            this.length += i;
            if (this.shift >= 32) {
                this.h1 = Murmur3_32HashFunction.mixH1(this.h1, Murmur3_32HashFunction.mixK1((int) this.buffer));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        public final Hasher putByte(byte b) {
            update(1, (long) (b & 255));
            return this;
        }

        public final Hasher putBytes(byte[] bArr, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 > i2) {
                    break;
                }
                update(4, (long) Murmur3_32HashFunction.getIntLittleEndian(bArr, i3 + i));
                i3 = i4;
            }
            while (i3 < i2) {
                putByte(bArr[i + i3]);
                i3++;
            }
            return this;
        }

        public final Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }

        public final Hasher putInt(int i) {
            update(4, (long) i);
            return this;
        }

        public final Hasher putLong(long j) {
            update(4, (long) ((int) j));
            update(4, j >>> 32);
            return this;
        }

        public final Hasher putChar(char c) {
            update(2, (long) c);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.hash.AbstractHasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.Hasher
         arg types: [java.lang.CharSequence, java.nio.charset.Charset]
         candidates:
          com.google.common.hash.Murmur3_32HashFunction.Murmur3_32Hasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.PrimitiveSink
          com.google.common.hash.AbstractHasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.PrimitiveSink
          com.google.common.hash.PrimitiveSink.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.PrimitiveSink
          com.google.common.hash.AbstractHasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.Hasher */
        public final Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length2 = charSequence.length();
            int i = 0;
            while (true) {
                int i2 = i + 4;
                if (i2 > length2) {
                    break;
                }
                char charAt = charSequence.charAt(i);
                char charAt2 = charSequence.charAt(i + 1);
                char charAt3 = charSequence.charAt(i + 2);
                char charAt4 = charSequence.charAt(i + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                update(4, (long) ((charAt2 << 8) | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i = i2;
            }
            while (i < length2) {
                char charAt5 = charSequence.charAt(i);
                if (charAt5 < 128) {
                    update(1, (long) charAt5);
                } else if (charAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                } else if (charAt5 < 55296 || charAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                } else {
                    int codePointAt = Character.codePointAt(charSequence, i);
                    if (codePointAt == charAt5) {
                        putBytes(charSequence.subSequence(i, length2).toString().getBytes(charset));
                        return this;
                    }
                    i++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                }
                i++;
            }
            return this;
        }

        public final HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            this.h1 ^= Murmur3_32HashFunction.mixK1((int) this.buffer);
            return Murmur3_32HashFunction.fmix(this.h1, this.length);
        }
    }
}
