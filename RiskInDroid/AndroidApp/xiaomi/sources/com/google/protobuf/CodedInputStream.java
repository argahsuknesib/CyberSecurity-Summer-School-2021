package com.google.protobuf;

import android.support.v4.app.NotificationCompat;
import com.google.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CodedInputStream {
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract void checkLastTagWas(int i) throws InvalidProtocolBufferException;

    public abstract void enableAliasing(boolean z);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public abstract boolean skipField(int i) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipRawBytes(int i) throws IOException;

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (inputStream == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        } else {
            return new StreamDecoder(inputStream, i);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.CodedInputStream.newInstance(java.lang.Iterable<java.nio.ByteBuffer>, boolean):com.google.protobuf.CodedInputStream
     arg types: [java.lang.Iterable<java.nio.ByteBuffer>, int]
     candidates:
      com.google.protobuf.CodedInputStream.newInstance(java.io.InputStream, int):com.google.protobuf.CodedInputStream
      com.google.protobuf.CodedInputStream.newInstance(java.nio.ByteBuffer, boolean):com.google.protobuf.CodedInputStream
      com.google.protobuf.CodedInputStream.newInstance(java.lang.Iterable<java.nio.ByteBuffer>, boolean):com.google.protobuf.CodedInputStream */
    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z) {
        boolean z2 = false;
        int i = 0;
        for (ByteBuffer next : iterable) {
            i += next.remaining();
            if (next.hasArray()) {
                z2 |= true;
            } else {
                z2 = next.isDirect() ? z2 | true : z2 | true;
            }
        }
        if (z2) {
            return new IterableDirectByteBufferDecoder(iterable, i, z);
        }
        return newInstance(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        return newInstance(bArr, i, i2, false);
    }

    static CodedInputStream newInstance(byte[] bArr, int i, int i2, boolean z) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i, i2, z);
        try {
            arrayDecoder.pushLimit(i2);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.protobuf.CodedInputStream.newInstance(java.nio.ByteBuffer, boolean):com.google.protobuf.CodedInputStream
     arg types: [java.nio.ByteBuffer, int]
     candidates:
      com.google.protobuf.CodedInputStream.newInstance(java.io.InputStream, int):com.google.protobuf.CodedInputStream
      com.google.protobuf.CodedInputStream.newInstance(java.lang.Iterable<java.nio.ByteBuffer>, boolean):com.google.protobuf.CodedInputStream
      com.google.protobuf.CodedInputStream.newInstance(java.nio.ByteBuffer, boolean):com.google.protobuf.CodedInputStream */
    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, bArr.length, true);
    }

    private CodedInputStream() {
        this.recursionLimit = 100;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public final int setRecursionLimit(int i) {
        if (i >= 0) {
            int i2 = this.recursionLimit;
            this.recursionLimit = i;
            return i2;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: ".concat(String.valueOf(i)));
    }

    public final int setSizeLimit(int i) {
        if (i >= 0) {
            int i2 = this.sizeLimit;
            this.sizeLimit = i;
            return i2;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: ".concat(String.valueOf(i)));
    }

    /* access modifiers changed from: package-private */
    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    /* access modifiers changed from: package-private */
    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    /* access modifiers changed from: package-private */
    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i2 |= (read & 127) << i3;
                if ((read & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                    return i2;
                }
                i3 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        while (i3 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if ((read2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                return i2;
            } else {
                i3 += 7;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private ArrayDecoder(byte[] bArr, int i, int i2, boolean z) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i2 + i;
            this.pos = i;
            this.startPos = this.pos;
            this.immutable = z;
        }

        public final int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public final void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public final int getLastTag() {
            return this.lastTag;
        }

        public final boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeRawVarint32(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        public final void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public final long readUInt64() throws IOException {
            return readRawVarint64();
        }

        public final long readInt64() throws IOException {
            return readRawVarint64();
        }

        public final int readInt32() throws IOException {
            return readRawVarint32();
        }

        public final long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public final String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    String str = new String(this.buffer, i2, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i2, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Deprecated
        public final void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public final void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final ByteString readBytes() throws IOException {
            ByteString byteString;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    if (!this.immutable || !this.enableAliasing) {
                        byteString = ByteString.copyFrom(this.buffer, this.pos, readRawVarint32);
                    } else {
                        byteString = ByteString.wrap(this.buffer, i2, readRawVarint32);
                    }
                    this.pos += readRawVarint32;
                    return byteString;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(readRawBytes(readRawVarint32));
        }

        public final byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public final ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer byteBuffer;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.limit;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(bArr, i3, i3 + readRawVarint32));
                    } else {
                        byteBuffer = ByteBuffer.wrap(this.buffer, i2, readRawVarint32).slice();
                    }
                    this.pos += readRawVarint32;
                    return byteBuffer;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public final int readEnum() throws IOException {
            return readRawVarint32();
        }

        public final int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        public final long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
            if (r2[r3] >= 0) goto L_0x0068;
         */
        public final int readRawVarint32() throws IOException {
            byte b;
            int i = this.pos;
            int i2 = this.limit;
            if (i2 != i) {
                byte[] bArr = this.buffer;
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.pos = i3;
                    return b2;
                } else if (i2 - i3 >= 9) {
                    int i4 = i3 + 1;
                    byte b3 = b2 ^ (bArr[i3] << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        int i5 = i4 + 1;
                        byte b4 = b3 ^ (bArr[i4] << 14);
                        if (b4 >= 0) {
                            b = b4 ^ 16256;
                        } else {
                            i4 = i5 + 1;
                            byte b5 = b4 ^ (bArr[i5] << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                i5 = i4 + 1;
                                byte b6 = bArr[i4];
                                b = (b5 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    i4 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i4 + 1;
                                        if (bArr[i4] < 0) {
                                            i4 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i4 + 1;
                                                if (bArr[i4] < 0) {
                                                    i4 = i5 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = i5;
                    }
                    this.pos = i4;
                    return b;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i = 0;
            while (i < 10) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
            if (((long) r2[r0]) >= 0) goto L_0x00b2;
         */
        public final long readRawVarint64() throws IOException {
            long j;
            int i;
            long j2;
            long j3;
            byte b;
            int i2 = this.pos;
            int i3 = this.limit;
            if (i3 != i2) {
                byte[] bArr = this.buffer;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.pos = i4;
                    return (long) b2;
                } else if (i3 - i4 >= 9) {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << 14);
                        if (b4 >= 0) {
                            i = i6;
                            j = (long) (b4 ^ 16256);
                        } else {
                            i5 = i6 + 1;
                            byte b5 = b4 ^ (bArr[i6] << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                long j4 = (long) b5;
                                int i7 = i5 + 1;
                                long j5 = j4 ^ (((long) bArr[i5]) << 28);
                                if (j5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    i = i7 + 1;
                                    long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                    if (j6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i7 = i + 1;
                                        j5 = j6 ^ (((long) bArr[i]) << 42);
                                        if (j5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i = i7 + 1;
                                            j6 = j5 ^ (((long) bArr[i7]) << 49);
                                            if (j6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i7 = i + 1;
                                                j = (j6 ^ (((long) bArr[i]) << 56)) ^ 71499008037633920L;
                                                if (j < 0) {
                                                    i = i7 + 1;
                                                }
                                                i = i7;
                                            }
                                        }
                                    }
                                    j = j6 ^ j2;
                                }
                                j = j3 ^ j5;
                                i = i7;
                            }
                        }
                        this.pos = i;
                        return j;
                    }
                    j = (long) b;
                    this.pos = i;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public final long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int readRawLittleEndian32() throws IOException {
            int i = this.pos;
            if (this.limit - i >= 4) {
                byte[] bArr = this.buffer;
                this.pos = i + 4;
                return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final long readRawLittleEndian64() throws IOException {
            int i = this.pos;
            if (this.limit - i >= 8) {
                byte[] bArr = this.buffer;
                this.pos = i + 8;
                return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void enableAliasing(boolean z) {
            this.enableAliasing = z;
        }

        public final void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public final int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i2 = this.currentLimit;
                if (totalBytesRead <= i2) {
                    this.currentLimit = totalBytesRead;
                    recomputeBufferSizeAfterLimit();
                    return i2;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += this.bufferSizeAfterLimit;
            int i = this.limit;
            int i2 = i - this.startPos;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                this.bufferSizeAfterLimit = i2 - i3;
                this.limit = i - this.bufferSizeAfterLimit;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        public final void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        public final int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        public final boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        public final int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        public final byte readRawByte() throws IOException {
            int i = this.pos;
            if (i != this.limit) {
                byte[] bArr = this.buffer;
                this.pos = i + 1;
                return bArr[i];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final byte[] readRawBytes(int i) throws IOException {
            if (i > 0) {
                int i2 = this.limit;
                int i3 = this.pos;
                if (i <= i2 - i3) {
                    this.pos = i + i3;
                    return Arrays.copyOfRange(this.buffer, i3, this.pos);
                }
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public final void skipRawBytes(int i) throws IOException {
            if (i >= 0) {
                int i2 = this.limit;
                int i3 = this.pos;
                if (i <= i2 - i3) {
                    this.pos = i3 + i;
                    return;
                }
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            this.address = UnsafeUtil.addressOffset(byteBuffer);
            this.limit = this.address + ((long) byteBuffer.limit());
            this.pos = this.address + ((long) byteBuffer.position());
            this.startPos = this.pos;
            this.immutable = z;
        }

        public final int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public final void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public final int getLastTag() {
            return this.lastTag;
        }

        public final boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeRawVarint32(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        public final void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public final long readUInt64() throws IOException {
            return readRawVarint64();
        }

        public final long readInt64() throws IOException {
            return readRawVarint64();
        }

        public final int readInt32() throws IOException {
            return readRawVarint32();
        }

        public final long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public final String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                long j = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j);
                String str = new String(bArr, Internal.UTF_8);
                this.pos += j;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                String decodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), readRawVarint32);
                this.pos += (long) readRawVarint32;
                return decodeUtf8;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Deprecated
        public final void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public final void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j);
                this.pos += j;
                return ByteString.wrap(bArr);
            } else {
                long j2 = this.pos;
                long j3 = (long) readRawVarint32;
                ByteBuffer slice = slice(j2, j2 + j3);
                this.pos += j3;
                return ByteString.wrap(slice);
            }
        }

        public final byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public final ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j);
                this.pos += j;
                return ByteBuffer.wrap(bArr);
            } else {
                long j2 = this.pos;
                long j3 = (long) readRawVarint32;
                ByteBuffer slice = slice(j2, j2 + j3);
                this.pos += j3;
                return slice;
            }
        }

        public final int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public final int readEnum() throws IOException {
            return readRawVarint32();
        }

        public final int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        public final long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r4) >= 0) goto L_0x0082;
         */
        public final int readRawVarint32() throws IOException {
            byte b;
            long j = this.pos;
            if (this.limit != j) {
                long j2 = j + 1;
                byte b2 = UnsafeUtil.getByte(j);
                if (b2 >= 0) {
                    this.pos = j2;
                    return b2;
                } else if (this.limit - j2 >= 9) {
                    long j3 = j2 + 1;
                    byte b3 = b2 ^ (UnsafeUtil.getByte(j2) << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        long j4 = j3 + 1;
                        byte b4 = b3 ^ (UnsafeUtil.getByte(j3) << 14);
                        if (b4 >= 0) {
                            b = b4 ^ 16256;
                        } else {
                            j3 = j4 + 1;
                            byte b5 = b4 ^ (UnsafeUtil.getByte(j4) << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                j4 = j3 + 1;
                                byte b6 = UnsafeUtil.getByte(j3);
                                b = (b5 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    j3 = j4 + 1;
                                    if (UnsafeUtil.getByte(j4) < 0) {
                                        j4 = j3 + 1;
                                        if (UnsafeUtil.getByte(j3) < 0) {
                                            j3 = j4 + 1;
                                            if (UnsafeUtil.getByte(j4) < 0) {
                                                j4 = j3 + 1;
                                                if (UnsafeUtil.getByte(j3) < 0) {
                                                    j3 = j4 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j3 = j4;
                    }
                    this.pos = j3;
                    return b;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i = 0;
            while (i < 10) {
                long j = this.pos;
                this.pos = 1 + j;
                if (UnsafeUtil.getByte(j) < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            long j4;
            byte b;
            long j5 = this.pos;
            if (this.limit != j5) {
                long j6 = j5 + 1;
                byte b2 = UnsafeUtil.getByte(j5);
                if (b2 >= 0) {
                    this.pos = j6;
                    return (long) b2;
                } else if (this.limit - j6 >= 9) {
                    long j7 = j6 + 1;
                    byte b3 = b2 ^ (UnsafeUtil.getByte(j6) << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        j = j7 + 1;
                        byte b4 = b3 ^ (UnsafeUtil.getByte(j7) << 14);
                        if (b4 >= 0) {
                            j2 = (long) (b4 ^ 16256);
                        } else {
                            j7 = j + 1;
                            byte b5 = b4 ^ (UnsafeUtil.getByte(j) << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                j = j7 + 1;
                                long j8 = ((long) b5) ^ (((long) UnsafeUtil.getByte(j7)) << 28);
                                if (j8 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j + 1;
                                    long j10 = j8 ^ (((long) UnsafeUtil.getByte(j)) << 35);
                                    if (j10 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j = j9 + 1;
                                        j8 = j10 ^ (((long) UnsafeUtil.getByte(j9)) << 42);
                                        if (j8 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j + 1;
                                            j10 = j8 ^ (((long) UnsafeUtil.getByte(j)) << 49);
                                            if (j10 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j = j9 + 1;
                                                j2 = (j10 ^ (((long) UnsafeUtil.getByte(j9)) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j11 = 1 + j;
                                                    if (((long) UnsafeUtil.getByte(j)) >= 0) {
                                                        j = j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = j10 ^ j3;
                                    j = j9;
                                }
                                j2 = j8 ^ j4;
                            }
                        }
                        this.pos = j;
                        return j2;
                    }
                    j2 = (long) b;
                    j = j7;
                    this.pos = j;
                    return j2;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public final long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int readRawLittleEndian32() throws IOException {
            long j = this.pos;
            if (this.limit - j >= 4) {
                this.pos = 4 + j;
                return ((UnsafeUtil.getByte(j + 3) & 255) << 24) | (UnsafeUtil.getByte(j) & 255) | ((UnsafeUtil.getByte(1 + j) & 255) << 8) | ((UnsafeUtil.getByte(2 + j) & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final long readRawLittleEndian64() throws IOException {
            long j = this.pos;
            if (this.limit - j >= 8) {
                this.pos = 8 + j;
                return ((((long) UnsafeUtil.getByte(j + 7)) & 255) << 56) | (((long) UnsafeUtil.getByte(j)) & 255) | ((((long) UnsafeUtil.getByte(1 + j)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final void enableAliasing(boolean z) {
            this.enableAliasing = z;
        }

        public final void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public final int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int totalBytesRead = i + getTotalBytesRead();
                int i2 = this.currentLimit;
                if (totalBytesRead <= i2) {
                    this.currentLimit = totalBytesRead;
                    recomputeBufferSizeAfterLimit();
                    return i2;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public final void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        public final int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        public final boolean isAtEnd() throws IOException {
            return this.pos == this.limit;
        }

        public final int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        public final byte readRawByte() throws IOException {
            long j = this.pos;
            if (j != this.limit) {
                this.pos = 1 + j;
                return UnsafeUtil.getByte(j);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public final byte[] readRawBytes(int i) throws IOException {
            if (i >= 0 && i <= remaining()) {
                byte[] bArr = new byte[i];
                long j = this.pos;
                long j2 = (long) i;
                slice(j, j + j2).get(bArr);
                this.pos += j2;
                return bArr;
            } else if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public final void skipRawBytes(int i) throws IOException {
            if (i >= 0 && i <= remaining()) {
                this.pos += (long) i;
            } else if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            this.limit += (long) this.bufferSizeAfterLimit;
            long j = this.limit;
            int i = (int) (j - this.startPos);
            int i2 = this.currentLimit;
            if (i > i2) {
                this.bufferSizeAfterLimit = i - i2;
                this.limit = j - ((long) this.bufferSizeAfterLimit);
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private int bufferPos(long j) {
            return (int) (j - this.address);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0040, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002f, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r3.buffer.position(r0);
            r3.buffer.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0031 */
        private ByteBuffer slice(long j, long j2) throws IOException {
            int position = this.buffer.position();
            int limit2 = this.buffer.limit();
            this.buffer.position(bufferPos(j));
            this.buffer.limit(bufferPos(j2));
            ByteBuffer slice = this.buffer.slice();
            this.buffer.position(position);
            this.buffer.limit(limit2);
            return slice;
        }
    }

    static final class StreamDecoder extends CodedInputStream {
        public final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        public int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        interface RefillCallback {
            void onRefill();
        }

        public final void enableAliasing(boolean z) {
        }

        private StreamDecoder(InputStream inputStream, int i) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        public final int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public final void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public final int getLastTag() {
            return this.lastTag;
        }

        public final boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeRawVarint32(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        public final void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos = StreamDecoder.this.pos;

            private SkippedDataSink() {
            }

            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }

            /* access modifiers changed from: package-private */
            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }
        }

        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public final long readUInt64() throws IOException {
            return readRawVarint64();
        }

        public final long readInt64() throws IOException {
            return readRawVarint64();
        }

        public final int readInt32() throws IOException {
            return readRawVarint32();
        }

        public final long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public final String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i = this.bufferSize;
                int i2 = this.pos;
                if (readRawVarint32 <= i - i2) {
                    String str = new String(this.buffer, i2, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(readRawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.pos, readRawVarint32, Internal.UTF_8);
            this.pos += readRawVarint32;
            return str2;
        }

        public final String readStringRequireUtf8() throws IOException {
            byte[] bArr;
            int readRawVarint32 = readRawVarint32();
            int i = this.pos;
            int i2 = 0;
            if (readRawVarint32 <= this.bufferSize - i && readRawVarint32 > 0) {
                bArr = this.buffer;
                this.pos = i + readRawVarint32;
                i2 = i;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= this.bufferSize) {
                    refillBuffer(readRawVarint32);
                    bArr = this.buffer;
                    this.pos = readRawVarint32 + 0;
                } else {
                    bArr = readRawBytesSlowPath(readRawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(bArr, i2, readRawVarint32);
        }

        public final void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Deprecated
        public final void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public final void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i2, readRawVarint32);
                this.pos += readRawVarint32;
                return copyFrom;
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                return readBytesSlowPath(readRawVarint32);
            }
        }

        public final byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            if (readRawVarint32 > i - i2 || readRawVarint32 <= 0) {
                return readRawBytesSlowPath(readRawVarint32, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32);
            this.pos += readRawVarint32;
            return copyOfRange;
        }

        public final ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.pos;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i2, i2 + readRawVarint32));
                this.pos += readRawVarint32;
                return wrap;
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32, true));
            }
        }

        public final int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public final int readEnum() throws IOException {
            return readRawVarint32();
        }

        public final int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        public final long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
            if (r2[r3] >= 0) goto L_0x0068;
         */
        public final int readRawVarint32() throws IOException {
            byte b;
            int i = this.pos;
            int i2 = this.bufferSize;
            if (i2 != i) {
                byte[] bArr = this.buffer;
                int i3 = i + 1;
                byte b2 = bArr[i];
                if (b2 >= 0) {
                    this.pos = i3;
                    return b2;
                } else if (i2 - i3 >= 9) {
                    int i4 = i3 + 1;
                    byte b3 = b2 ^ (bArr[i3] << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        int i5 = i4 + 1;
                        byte b4 = b3 ^ (bArr[i4] << 14);
                        if (b4 >= 0) {
                            b = b4 ^ 16256;
                        } else {
                            i4 = i5 + 1;
                            byte b5 = b4 ^ (bArr[i5] << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                i5 = i4 + 1;
                                byte b6 = bArr[i4];
                                b = (b5 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    i4 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i4 + 1;
                                        if (bArr[i4] < 0) {
                                            i4 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i4 + 1;
                                                if (bArr[i4] < 0) {
                                                    i4 = i5 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i4 = i5;
                    }
                    this.pos = i4;
                    return b;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i = 0;
            while (i < 10) {
                byte[] bArr = this.buffer;
                int i2 = this.pos;
                this.pos = i2 + 1;
                if (bArr[i2] < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b0, code lost:
            if (((long) r2[r0]) >= 0) goto L_0x00b2;
         */
        public final long readRawVarint64() throws IOException {
            long j;
            int i;
            long j2;
            long j3;
            byte b;
            int i2 = this.pos;
            int i3 = this.bufferSize;
            if (i3 != i2) {
                byte[] bArr = this.buffer;
                int i4 = i2 + 1;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.pos = i4;
                    return (long) b2;
                } else if (i3 - i4 >= 9) {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        int i6 = i5 + 1;
                        byte b4 = b3 ^ (bArr[i5] << 14);
                        if (b4 >= 0) {
                            i = i6;
                            j = (long) (b4 ^ 16256);
                        } else {
                            i5 = i6 + 1;
                            byte b5 = b4 ^ (bArr[i6] << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                long j4 = (long) b5;
                                int i7 = i5 + 1;
                                long j5 = j4 ^ (((long) bArr[i5]) << 28);
                                if (j5 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    i = i7 + 1;
                                    long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                    if (j6 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i7 = i + 1;
                                        j5 = j6 ^ (((long) bArr[i]) << 42);
                                        if (j5 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i = i7 + 1;
                                            j6 = j5 ^ (((long) bArr[i7]) << 49);
                                            if (j6 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i7 = i + 1;
                                                j = (j6 ^ (((long) bArr[i]) << 56)) ^ 71499008037633920L;
                                                if (j < 0) {
                                                    i = i7 + 1;
                                                }
                                                i = i7;
                                            }
                                        }
                                    }
                                    j = j6 ^ j2;
                                }
                                j = j3 ^ j5;
                                i = i7;
                            }
                        }
                        this.pos = i;
                        return j;
                    }
                    j = (long) b;
                    this.pos = i;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public final long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int readRawLittleEndian32() throws IOException {
            int i = this.pos;
            if (this.bufferSize - i < 4) {
                refillBuffer(4);
                i = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        public final long readRawLittleEndian64() throws IOException {
            int i = this.pos;
            if (this.bufferSize - i < 8) {
                refillBuffer(8);
                i = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public final void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        public final int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int i2 = i + this.totalBytesRetired + this.pos;
                int i3 = this.currentLimit;
                if (i2 <= i3) {
                    this.currentLimit = i2;
                    recomputeBufferSizeAfterLimit();
                    return i3;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            this.bufferSize += this.bufferSizeAfterLimit;
            int i = this.totalBytesRetired;
            int i2 = this.bufferSize;
            int i3 = i + i2;
            int i4 = this.currentLimit;
            if (i3 > i4) {
                this.bufferSizeAfterLimit = i3 - i4;
                this.bufferSize = i2 - this.bufferSizeAfterLimit;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        public final void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        public final int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.totalBytesRetired + this.pos);
        }

        public final boolean isAtEnd() throws IOException {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        public final int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        private void refillBuffer(int i) throws IOException {
            if (tryRefillBuffer(i)) {
                return;
            }
            if (i > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private boolean tryRefillBuffer(int i) throws IOException {
            while (this.pos + i > this.bufferSize) {
                int i2 = this.sizeLimit;
                int i3 = this.totalBytesRetired;
                int i4 = this.pos;
                if (i > (i2 - i3) - i4 || i3 + i4 + i > this.currentLimit) {
                    return false;
                }
                RefillCallback refillCallback2 = this.refillCallback;
                if (refillCallback2 != null) {
                    refillCallback2.onRefill();
                }
                int i5 = this.pos;
                if (i5 > 0) {
                    int i6 = this.bufferSize;
                    if (i6 > i5) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i5, bArr, 0, i6 - i5);
                    }
                    this.totalBytesRetired += i5;
                    this.bufferSize -= i5;
                    this.pos = 0;
                }
                InputStream inputStream = this.input;
                byte[] bArr2 = this.buffer;
                int i7 = this.bufferSize;
                int read = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.sizeLimit - this.totalBytesRetired) - this.bufferSize));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.bufferSize += read;
                    recomputeBufferSizeAfterLimit();
                    if (this.bufferSize >= i) {
                        return true;
                    }
                }
            }
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }

        public final byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i = this.pos;
            this.pos = i + 1;
            return bArr[i];
        }

        public final byte[] readRawBytes(int i) throws IOException {
            int i2 = this.pos;
            if (i > this.bufferSize - i2 || i <= 0) {
                return readRawBytesSlowPath(i, false);
            }
            int i3 = i + i2;
            this.pos = i3;
            return Arrays.copyOfRange(this.buffer, i2, i3);
        }

        private byte[] readRawBytesSlowPath(int i, boolean z) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (readRawBytesSlowPathOneChunk != null) {
                return z ? (byte[]) readRawBytesSlowPathOneChunk.clone() : readRawBytesSlowPathOneChunk;
            }
            int i2 = this.pos;
            int i3 = this.bufferSize;
            int i4 = i3 - i2;
            this.totalBytesRetired += i3;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - i4);
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, i2, bArr, 0, i4);
            for (byte[] next : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(next, 0, bArr, i4, next.length);
                i4 += next.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i) throws IOException {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i >= 0) {
                int i2 = this.totalBytesRetired + this.pos + i;
                if (i2 - this.sizeLimit <= 0) {
                    int i3 = this.currentLimit;
                    if (i2 <= i3) {
                        int i4 = this.bufferSize - this.pos;
                        int i5 = i - i4;
                        if (i5 >= 4096 && i5 > this.input.available()) {
                            return null;
                        }
                        byte[] bArr = new byte[i];
                        System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
                        this.totalBytesRetired += this.bufferSize;
                        this.pos = 0;
                        this.bufferSize = 0;
                        while (i4 < i) {
                            int read = this.input.read(bArr, i4, i - i4);
                            if (read != -1) {
                                this.totalBytesRetired += read;
                                i4 += read;
                            } else {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    skipRawBytes((i3 - this.totalBytesRetired) - this.pos);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                byte[] bArr = new byte[Math.min(i, 4096)];
                int i2 = 0;
                while (i2 < bArr.length) {
                    int read = this.input.read(bArr, i2, bArr.length - i2);
                    if (read != -1) {
                        this.totalBytesRetired += read;
                        i2 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i -= bArr.length;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private ByteString readBytesSlowPath(int i) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i2 = this.pos;
            int i3 = this.bufferSize;
            int i4 = i3 - i2;
            this.totalBytesRetired += i3;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - i4);
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, i2, bArr, 0, i4);
            for (byte[] next : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(next, 0, bArr, i4, next.length);
                i4 += next.length;
            }
            return ByteString.wrap(bArr);
        }

        public final void skipRawBytes(int i) throws IOException {
            int i2 = this.bufferSize;
            int i3 = this.pos;
            if (i > i2 - i3 || i < 0) {
                skipRawBytesSlowPath(i);
            } else {
                this.pos = i3 + i;
            }
        }

        private void skipRawBytesSlowPath(int i) throws IOException {
            if (i >= 0) {
                int i2 = this.totalBytesRetired;
                int i3 = this.pos;
                int i4 = i2 + i3 + i;
                int i5 = this.currentLimit;
                if (i4 <= i5) {
                    int i6 = 0;
                    if (this.refillCallback == null) {
                        this.totalBytesRetired = i2 + i3;
                        this.bufferSize = 0;
                        this.pos = 0;
                        i6 = this.bufferSize - i3;
                        while (i6 < i) {
                            try {
                                long j = (long) (i - i6);
                                long skip = this.input.skip(j);
                                if (skip >= 0 && skip <= j) {
                                    if (skip == 0) {
                                        break;
                                    }
                                    i6 += (int) skip;
                                } else {
                                    throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                                }
                            } catch (Throwable th) {
                                this.totalBytesRetired += i6;
                                recomputeBufferSizeAfterLimit();
                                throw th;
                            }
                        }
                        this.totalBytesRetired += i6;
                        recomputeBufferSizeAfterLimit();
                    }
                    if (i6 < i) {
                        int i7 = this.bufferSize;
                        int i8 = i7 - this.pos;
                        this.pos = i7;
                        refillBuffer(1);
                        while (true) {
                            int i9 = i - i8;
                            int i10 = this.bufferSize;
                            if (i9 > i10) {
                                i8 += i10;
                                this.pos = i10;
                                refillBuffer(1);
                            } else {
                                this.pos = i9;
                                return;
                            }
                        }
                    }
                } else {
                    skipRawBytes((i5 - i2) - i3);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }
    }

    static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private boolean immutable;
        private Iterable<ByteBuffer> input;
        private Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i, boolean z) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i;
            this.input = iterable;
            this.iterator = this.input.iterator();
            this.immutable = z;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i == 0) {
                this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0;
                this.currentByteBufferStartPos = 0;
                this.currentByteBufferLimit = 0;
                this.currentAddress = 0;
                return;
            }
            tryGetNextByteBuffer();
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (this.iterator.hasNext()) {
                tryGetNextByteBuffer();
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void tryGetNextByteBuffer() {
            this.currentByteBuffer = this.iterator.next();
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            this.currentByteBufferPos = (long) this.currentByteBuffer.position();
            this.currentByteBufferStartPos = this.currentByteBufferPos;
            this.currentByteBufferLimit = (long) this.currentByteBuffer.limit();
            this.currentAddress = UnsafeUtil.addressOffset(this.currentByteBuffer);
            long j = this.currentByteBufferPos;
            long j2 = this.currentAddress;
            this.currentByteBufferPos = j + j2;
            this.currentByteBufferStartPos += j2;
            this.currentByteBufferLimit += j2;
        }

        public final int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            this.lastTag = readRawVarint32();
            if (WireFormat.getTagFieldNumber(this.lastTag) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public final void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public final int getLastTag() {
            return this.lastTag;
        }

        public final boolean skipField(int i) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeRawVarint32(i);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeRawVarint32(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final void skipMessage() throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }

        public final void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
            int readTag;
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag, codedOutputStream));
        }

        public final double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public final float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public final long readUInt64() throws IOException {
            return readRawVarint64();
        }

        public final long readInt64() throws IOException {
            return readRawVarint64();
        }

        public final int readInt32() throws IOException {
            return readRawVarint32();
        }

        public final long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final boolean readBool() throws IOException {
            return readRawVarint64() != 0;
        }

        public final String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j3, bArr, 0, j);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.UTF_8);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j3 - this.currentByteBufferStartPos), readRawVarint32);
                    this.currentByteBufferPos += j;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                readRawBytesTo(bArr, 0, readRawVarint32);
                return Utf8.decodeUtf8(bArr, 0, readRawVarint32);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.recursionDepth < this.recursionLimit) {
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
                this.recursionDepth--;
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        @Deprecated
        public final void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
            readGroup(i, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public final void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                T t = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return t;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }

        public final ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    if (!this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j);
                        this.currentByteBufferPos += j;
                        return ByteString.wrap(bArr);
                    }
                    int i = (int) (j3 - this.currentAddress);
                    ByteString wrap = ByteString.wrap(slice(i, readRawVarint32 + i));
                    this.currentByteBufferPos += j;
                    return wrap;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteString.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public final ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j = (long) readRawVarint32;
                if (j <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j);
                        this.currentByteBufferPos += j;
                        return ByteBuffer.wrap(bArr);
                    }
                    this.currentByteBufferPos += j;
                    long j2 = this.currentByteBufferPos;
                    long j3 = this.currentAddress;
                    return slice((int) ((j2 - j3) - j), (int) (j2 - j3));
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public final int readEnum() throws IOException {
            return readRawVarint32();
        }

        public final int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public final long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public final int readSInt32() throws IOException {
            return decodeZigZag32(readRawVarint32());
        }

        public final long readSInt64() throws IOException {
            return decodeZigZag64(readRawVarint64());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r4) >= 0) goto L_0x0087;
         */
        public final int readRawVarint32() throws IOException {
            byte b;
            long j = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j) {
                long j2 = j + 1;
                byte b2 = UnsafeUtil.getByte(j);
                if (b2 >= 0) {
                    this.currentByteBufferPos++;
                    return b2;
                } else if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j3 = j2 + 1;
                    byte b3 = b2 ^ (UnsafeUtil.getByte(j2) << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        long j4 = j3 + 1;
                        byte b4 = b3 ^ (UnsafeUtil.getByte(j3) << 14);
                        if (b4 >= 0) {
                            b = b4 ^ 16256;
                        } else {
                            j3 = j4 + 1;
                            byte b5 = b4 ^ (UnsafeUtil.getByte(j4) << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                j4 = j3 + 1;
                                byte b6 = UnsafeUtil.getByte(j3);
                                b = (b5 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    j3 = j4 + 1;
                                    if (UnsafeUtil.getByte(j4) < 0) {
                                        j4 = j3 + 1;
                                        if (UnsafeUtil.getByte(j3) < 0) {
                                            j3 = j4 + 1;
                                            if (UnsafeUtil.getByte(j4) < 0) {
                                                j4 = j3 + 1;
                                                if (UnsafeUtil.getByte(j3) < 0) {
                                                    j3 = j4 + 1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        j3 = j4;
                    }
                    this.currentByteBufferPos = j3;
                    return b;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public final long readRawVarint64() throws IOException {
            long j;
            long j2;
            long j3;
            long j4;
            byte b;
            long j5 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j5) {
                long j6 = j5 + 1;
                byte b2 = UnsafeUtil.getByte(j5);
                if (b2 >= 0) {
                    this.currentByteBufferPos++;
                    return (long) b2;
                } else if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j7 = j6 + 1;
                    byte b3 = b2 ^ (UnsafeUtil.getByte(j6) << 7);
                    if (b3 < 0) {
                        b = b3 ^ Byte.MIN_VALUE;
                    } else {
                        j = j7 + 1;
                        byte b4 = b3 ^ (UnsafeUtil.getByte(j7) << 14);
                        if (b4 >= 0) {
                            j2 = (long) (b4 ^ 16256);
                        } else {
                            j7 = j + 1;
                            byte b5 = b4 ^ (UnsafeUtil.getByte(j) << 21);
                            if (b5 < 0) {
                                b = b5 ^ -2080896;
                            } else {
                                j = j7 + 1;
                                long j8 = ((long) b5) ^ (((long) UnsafeUtil.getByte(j7)) << 28);
                                if (j8 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    long j9 = j + 1;
                                    long j10 = j8 ^ (((long) UnsafeUtil.getByte(j)) << 35);
                                    if (j10 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j = j9 + 1;
                                        j8 = j10 ^ (((long) UnsafeUtil.getByte(j9)) << 42);
                                        if (j8 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = j + 1;
                                            j10 = j8 ^ (((long) UnsafeUtil.getByte(j)) << 49);
                                            if (j10 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j = j9 + 1;
                                                j2 = (j10 ^ (((long) UnsafeUtil.getByte(j9)) << 56)) ^ 71499008037633920L;
                                                if (j2 < 0) {
                                                    long j11 = 1 + j;
                                                    if (((long) UnsafeUtil.getByte(j)) >= 0) {
                                                        j = j11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    j2 = j10 ^ j3;
                                    j = j9;
                                }
                                j2 = j8 ^ j4;
                            }
                        }
                        this.currentByteBufferPos = j;
                        return j2;
                    }
                    j2 = (long) b;
                    j = j7;
                    this.currentByteBufferPos = j;
                    return j2;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public final long readRawVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= ((long) (readRawByte & Byte.MAX_VALUE)) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public final int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j;
            return ((UnsafeUtil.getByte(j + 3) & 255) << 24) | (UnsafeUtil.getByte(j) & 255) | ((UnsafeUtil.getByte(1 + j) & 255) << 8) | ((UnsafeUtil.getByte(2 + j) & 255) << 16);
        }

        public final long readRawLittleEndian64() throws IOException {
            if (currentRemaining() < 8) {
                return (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48) | ((((long) readRawByte()) & 255) << 56);
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = 8 + j;
            long j2 = ((((long) UnsafeUtil.getByte(4 + j)) & 255) << 32) | ((((long) UnsafeUtil.getByte(2 + j)) & 255) << 16) | (((long) UnsafeUtil.getByte(j)) & 255) | ((((long) UnsafeUtil.getByte(1 + j)) & 255) << 8) | ((((long) UnsafeUtil.getByte(3 + j)) & 255) << 24) | ((((long) UnsafeUtil.getByte(5 + j)) & 255) << 40);
            return ((((long) UnsafeUtil.getByte(j + 7)) & 255) << 56) | ((((long) UnsafeUtil.getByte(6 + j)) & 255) << 48) | j2;
        }

        public final void enableAliasing(boolean z) {
            this.enableAliasing = z;
        }

        public final void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        public final int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int totalBytesRead2 = i + getTotalBytesRead();
                int i2 = this.currentLimit;
                if (totalBytesRead2 <= i2) {
                    this.currentLimit = totalBytesRead2;
                    recomputeBufferSizeAfterLimit();
                    return i2;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private void recomputeBufferSizeAfterLimit() {
            this.totalBufferSize += this.bufferSizeAfterCurrentLimit;
            int i = this.totalBufferSize;
            int i2 = i - this.startOffset;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                this.bufferSizeAfterCurrentLimit = i2 - i3;
                this.totalBufferSize = i - this.bufferSizeAfterCurrentLimit;
                return;
            }
            this.bufferSizeAfterCurrentLimit = 0;
        }

        public final void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        public final int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        public final boolean isAtEnd() throws IOException {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        public final int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        public final byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j;
            return UnsafeUtil.getByte(j);
        }

        public final byte[] readRawBytes(int i) throws IOException {
            if (i >= 0) {
                long j = (long) i;
                if (j <= currentRemaining()) {
                    byte[] bArr = new byte[i];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j);
                    this.currentByteBufferPos += j;
                    return bArr;
                }
            }
            if (i >= 0 && i <= remaining()) {
                byte[] bArr2 = new byte[i];
                readRawBytesTo(bArr2, 0, i);
                return bArr2;
            } else if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private void readRawBytesTo(byte[] bArr, int i, int i2) throws IOException {
            if (i2 >= 0 && i2 <= remaining()) {
                int i3 = i2;
                while (i3 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(i3, (int) currentRemaining());
                    long j = (long) min;
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (long) ((i2 - i3) + i), j);
                    i3 -= min;
                    this.currentByteBufferPos += j;
                }
            } else if (i2 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i2 != 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public final void skipRawBytes(int i) throws IOException {
            if (i >= 0 && ((long) i) <= (((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                while (i > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(i, (int) currentRemaining());
                    i -= min;
                    this.currentByteBufferPos += (long) min;
                }
            } else if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void skipRawVarint() throws IOException {
            int i = 0;
            while (i < 10) {
                if (readRawByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0027, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
            throw com.google.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
            r3.currentByteBuffer.position(r0);
            r3.currentByteBuffer.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0029 */
        private ByteBuffer slice(int i, int i2) throws IOException {
            int position = this.currentByteBuffer.position();
            int limit = this.currentByteBuffer.limit();
            this.currentByteBuffer.position(i);
            this.currentByteBuffer.limit(i2);
            ByteBuffer slice = this.currentByteBuffer.slice();
            this.currentByteBuffer.position(position);
            this.currentByteBuffer.limit(limit);
            return slice;
        }
    }
}
