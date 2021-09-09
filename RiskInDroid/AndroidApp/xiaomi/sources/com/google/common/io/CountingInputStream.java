package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@GwtIncompatible
@Beta
public final class CountingInputStream extends FilterInputStream {
    private long count;
    private long mark = -1;

    public CountingInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.checkNotNull(inputStream));
    }

    public final long getCount() {
        return this.count;
    }

    public final int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            this.count++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            this.count += (long) read;
        }
        return read;
    }

    public final long skip(long j) throws IOException {
        long skip = this.in.skip(j);
        this.count += skip;
        return skip;
    }

    public final synchronized void mark(int i) {
        this.in.mark(i);
        this.mark = this.count;
    }

    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.mark != -1) {
            this.in.reset();
            this.count = this.mark;
        } else {
            throw new IOException("Mark not set");
        }
    }
}
