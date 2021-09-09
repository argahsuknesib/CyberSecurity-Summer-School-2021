package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@Immutable
abstract class AbstractHashFunction implements HashFunction {
    AbstractHashFunction() {
    }

    public <T> HashCode hashObject(T t, Funnel<? super T> funnel) {
        return newHasher().putObject(t, funnel).hash();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).putUnencodedChars(charSequence).hash();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.hash.Hasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.Hasher
     arg types: [java.lang.CharSequence, java.nio.charset.Charset]
     candidates:
      com.google.common.hash.PrimitiveSink.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.PrimitiveSink
      com.google.common.hash.Hasher.putString(java.lang.CharSequence, java.nio.charset.Charset):com.google.common.hash.Hasher */
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().putString(charSequence, charset).hash();
    }

    public HashCode hashInt(int i) {
        return newHasher(4).putInt(i).hash();
    }

    public HashCode hashLong(long j) {
        return newHasher(8).putLong(j).hash();
    }

    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher
     arg types: [byte[], int, int]
     candidates:
      com.google.common.hash.PrimitiveSink.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher */
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return newHasher(i2).putBytes(bArr, i, i2).hash();
    }

    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).putBytes(byteBuffer).hash();
    }

    public Hasher newHasher(int i) {
        Preconditions.checkArgument(i >= 0, "expectedInputSize must be >= 0 but was %s", i);
        return newHasher();
    }
}
