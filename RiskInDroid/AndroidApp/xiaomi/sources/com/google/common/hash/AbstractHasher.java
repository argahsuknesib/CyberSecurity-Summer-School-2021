package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@CanIgnoreReturnValue
abstract class AbstractHasher implements Hasher {
    public /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b) {
        return putByte(b);
    }

    AbstractHasher() {
    }

    public final Hasher putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : 0);
    }

    public final Hasher putDouble(double d) {
        return putLong(Double.doubleToRawLongBits(d));
    }

    public final Hasher putFloat(float f) {
        return putInt(Float.floatToRawIntBits(f));
    }

    public Hasher putUnencodedChars(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            putChar(charSequence.charAt(i));
        }
        return this;
    }

    public Hasher putString(CharSequence charSequence, Charset charset) {
        return putBytes(charSequence.toString().getBytes(charset));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.hash.AbstractHasher.putBytes(byte[], int, int):com.google.common.hash.Hasher
     arg types: [byte[], int, int]
     candidates:
      com.google.common.hash.AbstractHasher.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.PrimitiveSink.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.AbstractHasher.putBytes(byte[], int, int):com.google.common.hash.Hasher */
    public Hasher putBytes(byte[] bArr) {
        return putBytes(bArr, 0, bArr.length);
    }

    public Hasher putBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            putByte(bArr[i + i3]);
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.hash.AbstractHasher.putBytes(byte[], int, int):com.google.common.hash.Hasher
     arg types: [byte[], int, int]
     candidates:
      com.google.common.hash.AbstractHasher.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.PrimitiveSink.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.AbstractHasher.putBytes(byte[], int, int):com.google.common.hash.Hasher */
    public Hasher putBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            putBytes(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                putByte(byteBuffer.get());
            }
        }
        return this;
    }

    public Hasher putShort(short s) {
        putByte((byte) s);
        putByte((byte) (s >>> 8));
        return this;
    }

    public Hasher putInt(int i) {
        putByte((byte) i);
        putByte((byte) (i >>> 8));
        putByte((byte) (i >>> 16));
        putByte((byte) (i >>> 24));
        return this;
    }

    public Hasher putLong(long j) {
        for (int i = 0; i < 64; i += 8) {
            putByte((byte) ((int) (j >>> i)));
        }
        return this;
    }

    public Hasher putChar(char c) {
        putByte((byte) c);
        putByte((byte) (c >>> 8));
        return this;
    }

    public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }
}
