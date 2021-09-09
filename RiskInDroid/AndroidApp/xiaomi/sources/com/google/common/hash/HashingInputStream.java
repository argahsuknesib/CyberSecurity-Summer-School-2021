package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class HashingInputStream extends FilterInputStream {
    private final Hasher hasher;

    public final void mark(int i) {
    }

    public final boolean markSupported() {
        return false;
    }

    public HashingInputStream(HashFunction hashFunction, InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    @CanIgnoreReturnValue
    public final int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.hasher.putByte((byte) read);
        }
        return read;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher
     arg types: [byte[], int, int]
     candidates:
      com.google.common.hash.PrimitiveSink.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher */
    @CanIgnoreReturnValue
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.hasher.putBytes(bArr, i, read);
        }
        return read;
    }

    public final void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    public final HashCode hash() {
        return this.hasher.hash();
    }
}
