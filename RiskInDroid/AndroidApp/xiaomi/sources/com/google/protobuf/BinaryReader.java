package com.google.protobuf;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

abstract class BinaryReader implements Reader {
    public abstract int getTotalBytesRead();

    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    /* synthetic */ BinaryReader(AnonymousClass1 r1) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private BinaryReader() {
    }

    static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.bufferIsImmutable = z;
            this.buffer = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        public final int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        public final int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            this.tag = readVarint32();
            int i = this.tag;
            if (i == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(i);
        }

        public final int getTag() {
            return this.tag;
        }

        public final boolean skipField() throws IOException {
            int i;
            if (isAtEnd() || (i = this.tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            } else if (tagWireType == 1) {
                skipBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipGroup();
                return true;
            } else if (tagWireType == 5) {
                skipBytes(4);
                return true;
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public final double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        public final float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        public final long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        public final long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        public final int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public final long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        public final int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        public final boolean readBool() throws IOException {
            requireWireType(0);
            if (readVarint32() != 0) {
                return true;
            }
            return false;
        }

        public final String readString() throws IOException {
            return readStringInternal(false);
        }

        public final String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public final String readStringInternal(boolean z) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return "";
            }
            requireBytes(readVarint32);
            if (z) {
                byte[] bArr = this.buffer;
                int i = this.pos;
                if (!Utf8.isValidUtf8(bArr, i, i + readVarint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.buffer, this.pos, readVarint32, Internal.UTF_8);
            this.pos += readVarint32;
            return str;
        }

        public final <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        public final <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return readMessage(schema, extensionRegistryLite);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            int i2 = this.pos + readVarint32;
            this.limit = i2;
            try {
                T newInstance = schema.newInstance();
                schema.mergeFrom(newInstance, this, extensionRegistryLite);
                schema.makeImmutable(newInstance);
                if (this.pos == i2) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.limit = i;
            }
        }

        public final <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        public final <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return readGroup(schema, extensionRegistryLite);
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                T newInstance = schema.newInstance();
                schema.mergeFrom(newInstance, this, extensionRegistryLite);
                schema.makeImmutable(newInstance);
                if (this.tag == this.endGroupTag) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.endGroupTag = i;
            }
        }

        public final ByteString readBytes() throws IOException {
            ByteString byteString;
            requireWireType(2);
            int readVarint32 = readVarint32();
            if (readVarint32 == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(readVarint32);
            if (this.bufferIsImmutable) {
                byteString = ByteString.wrap(this.buffer, this.pos, readVarint32);
            } else {
                byteString = ByteString.copyFrom(this.buffer, this.pos, readVarint32);
            }
            this.pos += readVarint32;
            return byteString;
        }

        public final int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public final int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        public final int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        public final long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        public final int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        public final long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        public final void readDoubleList(List<Double> list) throws IOException {
            int i;
            int i2;
            if (list instanceof DoubleArrayList) {
                DoubleArrayList doubleArrayList = (DoubleArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        doubleArrayList.addDouble(readDouble());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readFloatList(List<Float> list) throws IOException {
            int i;
            int i2;
            if (list instanceof FloatArrayList) {
                FloatArrayList floatArrayList = (FloatArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType == 5) {
                    do {
                        floatArrayList.addFloat(readFloat());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Float.valueOf(readFloat()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readUInt64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readUInt64());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(readVarint64());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readInt64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readInt64());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(readVarint64());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readInt32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readInt32());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readFixed64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        longArrayList.addLong(readFixed64());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        longArrayList.addLong(readLittleEndian64_NoCheck());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readFixed32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                } else if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(readFixed32());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readFixed32()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readBoolList(List<Boolean> list) throws IOException {
            int i;
            int i2;
            if (list instanceof BooleanArrayList) {
                BooleanArrayList booleanArrayList = (BooleanArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        booleanArrayList.addBoolean(readBool());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        booleanArrayList.addBoolean(readVarint32() != 0);
                    }
                    requirePosition(readVarint32);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Boolean.valueOf(readBool()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(readVarint322);
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readStringList(List<String> list) throws IOException {
            readStringListInternal(list, false);
        }

        public final void readStringListRequireUtf8(List<String> list) throws IOException {
            readStringListInternal(list, true);
        }

        public final void readStringListInternal(List<String> list, boolean z) throws IOException {
            int i;
            int i2;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            } else if (!(list instanceof LazyStringList) || z) {
                do {
                    list.add(readStringInternal(z));
                    if (!isAtEnd()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
            } else {
                LazyStringList lazyStringList = (LazyStringList) list;
                do {
                    lazyStringList.add(readBytes());
                    if (!isAtEnd()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i2;
            }
        }

        public final <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        public final <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) == 2) {
                int i2 = this.tag;
                do {
                    list.add(readMessage(schema, extensionRegistryLite));
                    if (!isAtEnd()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == i2);
                this.pos = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public final <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        public final <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) == 3) {
                int i2 = this.tag;
                do {
                    list.add(readGroup(schema, extensionRegistryLite));
                    if (!isAtEnd()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == i2);
                this.pos = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public final void readBytesList(List<ByteString> list) throws IOException {
            int i;
            if (WireFormat.getTagWireType(this.tag) == 2) {
                do {
                    list.add(readBytes());
                    if (!isAtEnd()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (readVarint32() == this.tag);
                this.pos = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        public final void readUInt32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readUInt32());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readUInt32()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readEnumList(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readEnum());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(readVarint32());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readEnum()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readSFixed32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed32Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        intArrayList.addInt(readLittleEndian32_NoCheck());
                    }
                } else if (tagWireType == 5) {
                    do {
                        intArrayList.addInt(readSFixed32());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed32Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                } else if (tagWireType2 == 5) {
                    do {
                        list.add(Integer.valueOf(readSFixed32()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readSFixed64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 1) {
                    do {
                        longArrayList.addLong(readSFixed64());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = readVarint32();
                    verifyPackedFixed64Length(readVarint32);
                    int i3 = this.pos + readVarint32;
                    while (this.pos < i3) {
                        longArrayList.addLong(readLittleEndian64_NoCheck());
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = readVarint32();
                    verifyPackedFixed64Length(readVarint322);
                    int i4 = this.pos + readVarint322;
                    while (this.pos < i4) {
                        list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readSInt32List(List<Integer> list) throws IOException {
            int i;
            int i2;
            if (list instanceof IntArrayList) {
                IntArrayList intArrayList = (IntArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        intArrayList.addInt(readSInt32());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        intArrayList.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Integer.valueOf(readSInt32()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        public final void readSInt64List(List<Long> list) throws IOException {
            int i;
            int i2;
            if (list instanceof LongArrayList) {
                LongArrayList longArrayList = (LongArrayList) list;
                int tagWireType = WireFormat.getTagWireType(this.tag);
                if (tagWireType == 0) {
                    do {
                        longArrayList.addLong(readSInt64());
                        if (!isAtEnd()) {
                            i2 = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i2;
                } else if (tagWireType == 2) {
                    int readVarint32 = this.pos + readVarint32();
                    while (this.pos < readVarint32) {
                        longArrayList.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            } else {
                int tagWireType2 = WireFormat.getTagWireType(this.tag);
                if (tagWireType2 == 0) {
                    do {
                        list.add(Long.valueOf(readSInt64()));
                        if (!isAtEnd()) {
                            i = this.pos;
                        } else {
                            return;
                        }
                    } while (readVarint32() == this.tag);
                    this.pos = i;
                } else if (tagWireType2 == 2) {
                    int readVarint322 = this.pos + readVarint32();
                    while (this.pos < readVarint322) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                } else {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(2:20|36)(3:31|21|22)) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
            if (skipField() != false) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            throw new com.google.protobuf.InvalidProtocolBufferException("Unable to parse map entry.");
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
        public final <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            int readVarint32 = readVarint32();
            requireBytes(readVarint32);
            int i = this.limit;
            this.limit = this.pos + readVarint32;
            try {
                K k = metadata.defaultKey;
                V v = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(k, v);
                        return;
                    } else if (fieldNumber == 1) {
                        k = readField(metadata.keyType, null, null);
                    } else if (fieldNumber == 2) {
                        v = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                    } else if (!skipField()) {
                        throw new InvalidProtocolBufferException("Unable to parse map entry.");
                    }
                }
            } finally {
                this.limit = i;
            }
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case GmsLogger.MAX_PII_TAG_LENGTH:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readVarint32() throws IOException {
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
                } else if (i2 - i3 < 9) {
                    return (int) readVarint64SlowPath();
                } else {
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
                                                    if (bArr[i5] < 0) {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
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
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public final long readVarint64() throws IOException {
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
                } else if (i3 - i4 < 9) {
                    return readVarint64SlowPath();
                } else {
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
                                                    if (((long) bArr[i7]) < 0) {
                                                        throw InvalidProtocolBufferException.malformedVarint();
                                                    }
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
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private long readVarint64SlowPath() throws IOException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readByte = readByte();
                j |= ((long) (readByte & Byte.MAX_VALUE)) << i;
                if ((readByte & 128) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private byte readByte() throws IOException {
            int i = this.pos;
            if (i != this.limit) {
                byte[] bArr = this.buffer;
                this.pos = i + 1;
                return bArr[i];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        private long readLittleEndian64_NoCheck() {
            int i = this.pos;
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        private void skipVarint() throws IOException {
            int i = this.limit;
            int i2 = this.pos;
            if (i - i2 >= 10) {
                byte[] bArr = this.buffer;
                int i3 = 0;
                while (i3 < 10) {
                    int i4 = i2 + 1;
                    if (bArr[i2] >= 0) {
                        this.pos = i4;
                        return;
                    } else {
                        i3++;
                        i2 = i4;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            int i = 0;
            while (i < 10) {
                if (readByte() < 0) {
                    i++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipBytes(int i) throws IOException {
            requireBytes(i);
            this.pos += i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:3:0x0018  */
        private void skipGroup() throws IOException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
                while (getFieldNumber() != Integer.MAX_VALUE) {
                    while (getFieldNumber() != Integer.MAX_VALUE) {
                    }
                }
            }
            if (this.tag == this.endGroupTag) {
                this.endGroupTag = i;
                return;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void requireBytes(int i) throws IOException {
            if (i < 0 || i > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != i) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void verifyPackedFixed64Length(int i) throws IOException {
            requireBytes(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed32Length(int i) throws IOException {
            requireBytes(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void requirePosition(int i) throws IOException {
            if (this.pos != i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* renamed from: com.google.protobuf.BinaryReader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
        }
    }
}
