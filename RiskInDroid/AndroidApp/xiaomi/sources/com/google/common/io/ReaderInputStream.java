package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

@GwtIncompatible
final class ReaderInputStream extends InputStream {
    private ByteBuffer byteBuffer;
    private CharBuffer charBuffer;
    private boolean doneFlushing;
    private boolean draining;
    private final CharsetEncoder encoder;
    private boolean endOfInput;
    private final Reader reader;
    private final byte[] singleByte;

    ReaderInputStream(Reader reader2, Charset charset, int i) {
        this(reader2, charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), i);
    }

    ReaderInputStream(Reader reader2, CharsetEncoder charsetEncoder, int i) {
        boolean z = true;
        this.singleByte = new byte[1];
        this.reader = (Reader) Preconditions.checkNotNull(reader2);
        this.encoder = (CharsetEncoder) Preconditions.checkNotNull(charsetEncoder);
        Preconditions.checkArgument(i <= 0 ? false : z, "bufferSize must be positive: %s", i);
        charsetEncoder.reset();
        this.charBuffer = CharBuffer.allocate(i);
        this.charBuffer.flip();
        this.byteBuffer = ByteBuffer.allocate(i);
    }

    public final void close() throws IOException {
        this.reader.close();
    }

    public final int read() throws IOException {
        if (read(this.singleByte) == 1) {
            return UnsignedBytes.toInt(this.singleByte[0]);
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[RETURN] */
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        CoderResult coderResult;
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        boolean z = this.endOfInput;
        int i3 = 0;
        while (true) {
            if (this.draining) {
                i3 += drain(bArr, i + i3, i2 - i3);
                if (i3 != i2 && !this.doneFlushing) {
                    this.draining = false;
                    this.byteBuffer.clear();
                } else if (i3 <= 0) {
                    return i3;
                } else {
                    return -1;
                }
            }
            while (true) {
                if (this.doneFlushing) {
                    coderResult = CoderResult.UNDERFLOW;
                } else if (z) {
                    coderResult = this.encoder.flush(this.byteBuffer);
                } else {
                    coderResult = this.encoder.encode(this.charBuffer, this.byteBuffer, this.endOfInput);
                }
                if (coderResult.isOverflow()) {
                    startDraining(true);
                    break;
                } else if (coderResult.isUnderflow()) {
                    if (z) {
                        this.doneFlushing = true;
                        startDraining(false);
                        break;
                    } else if (this.endOfInput) {
                        z = true;
                    } else {
                        readMoreChars();
                    }
                } else if (coderResult.isError()) {
                    coderResult.throwException();
                    return 0;
                }
            }
        }
        if (i3 <= 0) {
        }
    }

    private static CharBuffer grow(CharBuffer charBuffer2) {
        CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer2.array(), charBuffer2.capacity() * 2));
        wrap.position(charBuffer2.position());
        wrap.limit(charBuffer2.limit());
        return wrap;
    }

    private void readMoreChars() throws IOException {
        if (availableCapacity(this.charBuffer) == 0) {
            if (this.charBuffer.position() > 0) {
                this.charBuffer.compact().flip();
            } else {
                this.charBuffer = grow(this.charBuffer);
            }
        }
        int limit = this.charBuffer.limit();
        int read = this.reader.read(this.charBuffer.array(), limit, availableCapacity(this.charBuffer));
        if (read == -1) {
            this.endOfInput = true;
        } else {
            this.charBuffer.limit(limit + read);
        }
    }

    private static int availableCapacity(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private void startDraining(boolean z) {
        this.byteBuffer.flip();
        if (!z || this.byteBuffer.remaining() != 0) {
            this.draining = true;
        } else {
            this.byteBuffer = ByteBuffer.allocate(this.byteBuffer.capacity() * 2);
        }
    }

    private int drain(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.byteBuffer.remaining());
        this.byteBuffer.get(bArr, i, min);
        return min;
    }
}
