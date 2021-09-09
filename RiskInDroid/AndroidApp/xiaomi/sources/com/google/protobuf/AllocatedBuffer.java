package com.google.protobuf;

import java.nio.ByteBuffer;

abstract class AllocatedBuffer {
    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    AllocatedBuffer() {
    }

    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer wrap(byte[] bArr, int i, int i2) {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            return wrapNoCheck(bArr, i, i2);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() {
            /* class com.google.protobuf.AllocatedBuffer.AnonymousClass1 */

            public final boolean hasNioBuffer() {
                return true;
            }

            public final ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            public final boolean hasArray() {
                return byteBuffer.hasArray();
            }

            public final byte[] array() {
                return byteBuffer.array();
            }

            public final int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            public final int position() {
                return byteBuffer.position();
            }

            public final AllocatedBuffer position(int i) {
                byteBuffer.position(i);
                return this;
            }

            public final int limit() {
                return byteBuffer.limit();
            }

            public final int remaining() {
                return byteBuffer.remaining();
            }
        };
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() {
            /* class com.google.protobuf.AllocatedBuffer.AnonymousClass2 */
            private int position;

            public final boolean hasArray() {
                return true;
            }

            public final boolean hasNioBuffer() {
                return false;
            }

            public final ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            public final byte[] array() {
                return bArr;
            }

            public final int arrayOffset() {
                return i;
            }

            public final int position() {
                return this.position;
            }

            public final AllocatedBuffer position(int i) {
                if (i < 0 || i > i2) {
                    throw new IllegalArgumentException("Invalid position: ".concat(String.valueOf(i)));
                }
                this.position = i;
                return this;
            }

            public final int limit() {
                return i2;
            }

            public final int remaining() {
                return i2 - this.position;
            }
        };
    }
}
