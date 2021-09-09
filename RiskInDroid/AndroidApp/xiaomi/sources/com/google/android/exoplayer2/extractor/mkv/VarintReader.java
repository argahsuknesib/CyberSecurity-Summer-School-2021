package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader {
    private static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] scratch = new byte[8];
    private int state;

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long readUnsignedVarint(ExtractorInput extractorInput, boolean z, boolean z2, int i) throws IOException {
        if (this.state == 0) {
            if (!extractorInput.readFully(this.scratch, 0, 1, z)) {
                return -1;
            }
            this.length = parseUnsignedVarintLength(this.scratch[0] & 255);
            if (this.length != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.length;
        if (i2 > i) {
            this.state = 0;
            return -2;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.scratch, 1, i2 - 1);
        }
        this.state = 0;
        return assembleVarint(this.scratch, this.length, z2);
    }

    public final int getLastLength() {
        return this.length;
    }

    public static int parseUnsignedVarintLength(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long assembleVarint(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= VARINT_LENGTH_MASKS[i - 1] ^ -1;
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
