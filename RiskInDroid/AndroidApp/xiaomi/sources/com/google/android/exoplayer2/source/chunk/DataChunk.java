package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk extends Chunk {
    private byte[] data;
    private volatile boolean loadCanceled;

    /* access modifiers changed from: protected */
    public abstract void consume(byte[] bArr, int i) throws IOException;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i, Format format, int i2, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i, format, i2, obj, -9223372036854775807L, -9223372036854775807L);
        byte[] bArr2;
        DataChunk dataChunk;
        if (bArr == null) {
            bArr2 = Util.EMPTY_BYTE_ARRAY;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.data = bArr2;
    }

    public byte[] getDataHolder() {
        return this.data;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public final void load() throws IOException {
        try {
            this.dataSource.open(this.dataSpec);
            int i = 0;
            int i2 = 0;
            while (i != -1 && !this.loadCanceled) {
                maybeExpandData(i2);
                i = this.dataSource.read(this.data, i2, 16384);
                if (i != -1) {
                    i2 += i;
                }
            }
            if (!this.loadCanceled) {
                consume(this.data, i2);
            }
        } finally {
            Util.closeQuietly(this.dataSource);
        }
    }

    private void maybeExpandData(int i) {
        byte[] bArr = this.data;
        if (bArr.length < i + 16384) {
            this.data = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }
}
