package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    public final ByteBuffer buffer;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    public final byte byteAt(int i) {
        try {
            return this.buffer.get(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    public final byte internalByteAt(int i) {
        return byteAt(i);
    }

    public final int size() {
        return this.buffer.remaining();
    }

    public final ByteString substring(int i, int i2) {
        try {
            return new NioByteString(slice(i, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public final void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i);
        slice.get(bArr, i2, i3);
    }

    public final void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public final boolean equalsRange(ByteString byteString, int i, int i2) {
        return substring(0, i2).equals(byteString.substring(i, i2 + i));
    }

    /* access modifiers changed from: package-private */
    public final void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i, i2);
            return;
        }
        ByteBufferWriter.write(slice(i, i2 + i), outputStream);
    }

    /* access modifiers changed from: package-private */
    public final void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }

    public final ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public final List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    /* access modifiers changed from: protected */
    public final String toStringInternal(Charset charset) {
        int i;
        int i2;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i2 = this.buffer.arrayOffset() + this.buffer.position();
            i = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i2 = 0;
            i = bArr.length;
        }
        return new String(bArr, i2, i, charset);
    }

    public final boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    /* access modifiers changed from: protected */
    public final int partialIsValidUtf8(int i, int i2, int i3) {
        return Utf8.partialIsValidUtf8(i, this.buffer, i2, i3 + i2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    /* access modifiers changed from: protected */
    public final int partialHash(int i, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + this.buffer.get(i5);
        }
        return i4;
    }

    public final InputStream newInput() {
        return new InputStream() {
            /* class com.google.protobuf.NioByteString.AnonymousClass1 */
            private final ByteBuffer buf = NioByteString.this.buffer.slice();

            public boolean markSupported() {
                return true;
            }

            public void mark(int i) {
                this.buf.mark();
            }

            public void reset() throws IOException {
                try {
                    this.buf.reset();
                } catch (InvalidMarkException e) {
                    throw new IOException(e);
                }
            }

            public int available() throws IOException {
                return this.buf.remaining();
            }

            public int read() throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                return this.buf.get() & 255;
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i2, this.buf.remaining());
                this.buf.get(bArr, i, min);
                return min;
            }
        };
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.CodedInputStream.newInstance(java.nio.ByteBuffer, boolean):com.google.protobuf.CodedInputStream
     arg types: [java.nio.ByteBuffer, int]
     candidates:
      com.google.protobuf.CodedInputStream.newInstance(java.io.InputStream, int):com.google.protobuf.CodedInputStream
      com.google.protobuf.CodedInputStream.newInstance(java.lang.Iterable<java.nio.ByteBuffer>, boolean):com.google.protobuf.CodedInputStream
      com.google.protobuf.CodedInputStream.newInstance(java.nio.ByteBuffer, boolean):com.google.protobuf.CodedInputStream */
    public final CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    private ByteBuffer slice(int i, int i2) {
        if (i < this.buffer.position() || i2 > this.buffer.limit() || i > i2) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i - this.buffer.position());
        slice.limit(i2 - this.buffer.position());
        return slice;
    }
}
