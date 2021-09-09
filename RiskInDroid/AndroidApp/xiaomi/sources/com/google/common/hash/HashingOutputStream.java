package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
public final class HashingOutputStream extends FilterOutputStream {
    private final Hasher hasher;

    public HashingOutputStream(HashFunction hashFunction, OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
        this.hasher = (Hasher) Preconditions.checkNotNull(hashFunction.newHasher());
    }

    public final void write(int i) throws IOException {
        this.hasher.putByte((byte) i);
        this.out.write(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher
     arg types: [byte[], int, int]
     candidates:
      com.google.common.hash.PrimitiveSink.putBytes(byte[], int, int):com.google.common.hash.PrimitiveSink
      com.google.common.hash.Hasher.putBytes(byte[], int, int):com.google.common.hash.Hasher */
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.hasher.putBytes(bArr, i, i2);
        this.out.write(bArr, i, i2);
    }

    public final HashCode hash() {
        return this.hasher.hash();
    }

    public final void close() throws IOException {
        this.out.close();
    }
}
