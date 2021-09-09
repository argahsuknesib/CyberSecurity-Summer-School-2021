package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class DefaultExtractorInput implements ExtractorInput {
    private final DataReader dataReader;
    private byte[] peekBuffer = new byte[65536];
    private int peekBufferLength;
    private int peekBufferPosition;
    private long position;
    private final byte[] scratchSpace = new byte[4096];
    private final long streamLength;

    public DefaultExtractorInput(DataReader dataReader2, long j, long j2) {
        this.dataReader = dataReader2;
        this.position = j;
        this.streamLength = j2;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i, i2);
        if (readFromPeekBuffer == 0) {
            readFromPeekBuffer = readFromUpstream(bArr, i, i2, 0, true);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer;
    }

    public final boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int readFromPeekBuffer = readFromPeekBuffer(bArr, i, i2);
        while (readFromPeekBuffer < i2 && readFromPeekBuffer != -1) {
            readFromPeekBuffer = readFromUpstream(bArr, i, i2, readFromPeekBuffer, z);
        }
        commitBytesRead(readFromPeekBuffer);
        return readFromPeekBuffer != -1;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        readFully(bArr, i, i2, false);
    }

    public final int skip(int i) throws IOException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i);
        if (skipFromPeekBuffer == 0) {
            byte[] bArr = this.scratchSpace;
            skipFromPeekBuffer = readFromUpstream(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer;
    }

    public final boolean skipFully(int i, boolean z) throws IOException {
        int skipFromPeekBuffer = skipFromPeekBuffer(i);
        while (skipFromPeekBuffer < i && skipFromPeekBuffer != -1) {
            skipFromPeekBuffer = readFromUpstream(this.scratchSpace, -skipFromPeekBuffer, Math.min(i, this.scratchSpace.length + skipFromPeekBuffer), skipFromPeekBuffer, z);
        }
        commitBytesRead(skipFromPeekBuffer);
        return skipFromPeekBuffer != -1;
    }

    public final void skipFully(int i) throws IOException {
        skipFully(i, false);
    }

    public final int peek(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        ensureSpaceForPeek(i2);
        int i4 = this.peekBufferLength;
        int i5 = this.peekBufferPosition;
        int i6 = i4 - i5;
        if (i6 == 0) {
            i3 = readFromUpstream(this.peekBuffer, i5, i2, 0, true);
            if (i3 == -1) {
                return -1;
            }
            this.peekBufferLength += i3;
        } else {
            i3 = Math.min(i2, i6);
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition, bArr, i, i3);
        this.peekBufferPosition += i3;
        return i3;
    }

    public final boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!advancePeekPosition(i2, z)) {
            return false;
        }
        System.arraycopy(this.peekBuffer, this.peekBufferPosition - i2, bArr, i, i2);
        return true;
    }

    public final void peekFully(byte[] bArr, int i, int i2) throws IOException {
        peekFully(bArr, i, i2, false);
    }

    public final boolean advancePeekPosition(int i, boolean z) throws IOException {
        ensureSpaceForPeek(i);
        int i2 = this.peekBufferLength - this.peekBufferPosition;
        while (i2 < i) {
            i2 = readFromUpstream(this.peekBuffer, this.peekBufferPosition, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.peekBufferLength = this.peekBufferPosition + i2;
        }
        this.peekBufferPosition += i;
        return true;
    }

    public final void advancePeekPosition(int i) throws IOException {
        advancePeekPosition(i, false);
    }

    public final void resetPeekPosition() {
        this.peekBufferPosition = 0;
    }

    public final long getPeekPosition() {
        return this.position + ((long) this.peekBufferPosition);
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getLength() {
        return this.streamLength;
    }

    public final <E extends Throwable> void setRetryPosition(long j, E e) throws Throwable {
        Assertions.checkArgument(j >= 0);
        this.position = j;
        throw e;
    }

    private void ensureSpaceForPeek(int i) {
        int i2 = this.peekBufferPosition + i;
        byte[] bArr = this.peekBuffer;
        if (i2 > bArr.length) {
            this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int skipFromPeekBuffer(int i) {
        int min = Math.min(this.peekBufferLength, i);
        updatePeekBuffer(min);
        return min;
    }

    private int readFromPeekBuffer(byte[] bArr, int i, int i2) {
        int i3 = this.peekBufferLength;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.peekBuffer, 0, bArr, i, min);
        updatePeekBuffer(min);
        return min;
    }

    private void updatePeekBuffer(int i) {
        this.peekBufferLength -= i;
        this.peekBufferPosition = 0;
        byte[] bArr = this.peekBuffer;
        int i2 = this.peekBufferLength;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[(i2 + 65536)];
        }
        System.arraycopy(this.peekBuffer, i, bArr, 0, this.peekBufferLength);
        this.peekBuffer = bArr;
    }

    private int readFromUpstream(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.dataReader.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private void commitBytesRead(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }
}
