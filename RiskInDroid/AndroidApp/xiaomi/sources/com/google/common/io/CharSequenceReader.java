package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

@GwtIncompatible
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    public final boolean markSupported() {
        return true;
    }

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    public final synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), remaining());
        for (int i = 0; i < min; i++) {
            CharSequence charSequence = this.seq;
            int i2 = this.pos;
            this.pos = i2 + 1;
            charBuffer.put(charSequence.charAt(i2));
        }
        return min;
    }

    public final synchronized int read() throws IOException {
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        CharSequence charSequence = this.seq;
        int i = this.pos;
        this.pos = i + 1;
        return charSequence.charAt(i);
    }

    public final synchronized int read(char[] cArr, int i, int i2) throws IOException {
        Preconditions.checkPositionIndexes(i, i + i2, cArr.length);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, remaining());
        for (int i3 = 0; i3 < min; i3++) {
            CharSequence charSequence = this.seq;
            int i4 = this.pos;
            this.pos = i4 + 1;
            cArr[i + i3] = charSequence.charAt(i4);
        }
        return min;
    }

    public final synchronized long skip(long j) throws IOException {
        int min;
        Preconditions.checkArgument(j >= 0, "n (%s) may not be negative", j);
        checkOpen();
        min = (int) Math.min((long) remaining(), j);
        this.pos += min;
        return (long) min;
    }

    public final synchronized boolean ready() throws IOException {
        checkOpen();
        return true;
    }

    public final synchronized void mark(int i) throws IOException {
        Preconditions.checkArgument(i >= 0, "readAheadLimit (%s) may not be negative", i);
        checkOpen();
        this.mark = this.pos;
    }

    public final synchronized void reset() throws IOException {
        checkOpen();
        this.pos = this.mark;
    }

    public final synchronized void close() throws IOException {
        this.seq = null;
    }
}
