package com.google.protobuf;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

final class ArrayDecoders {
    ArrayDecoders() {
    }

    static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;

        Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        Registers(ExtensionRegistryLite extensionRegistryLite) {
            if (extensionRegistryLite != null) {
                this.extensionRegistry = extensionRegistryLite;
                return;
            }
            throw new NullPointerException();
        }
    }

    static int decodeVarint32(byte[] bArr, int i, Registers registers) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return decodeVarint32(b, bArr, i2, registers);
        }
        registers.int1 = b;
        return i2;
    }

    static int decodeVarint32(int i, byte[] bArr, int i2, Registers registers) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            registers.int1 = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            registers.int1 = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            registers.int1 = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            registers.int1 = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                registers.int1 = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int decodeVarint64(byte[] bArr, int i, Registers registers) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            return decodeVarint64(j, bArr, i2, registers);
        }
        registers.long1 = j;
        return i2;
    }

    static int decodeVarint64(long j, byte[] bArr, int i, Registers registers) {
        int i2 = i + 1;
        byte b = bArr[i];
        long j2 = (j & 127) | (((long) (b & Byte.MAX_VALUE)) << 7);
        int i3 = 7;
        while (b < 0) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            i3 += 7;
            j2 |= ((long) (b2 & Byte.MAX_VALUE)) << i3;
            byte b3 = b2;
            i2 = i4;
            b = b3;
        }
        registers.long1 = j2;
        return i2;
    }

    static int decodeFixed32(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long decodeFixed64(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double decodeDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i));
    }

    static float decodeFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i));
    }

    static int decodeString(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i2 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = new String(bArr, decodeVarint32, i2, Internal.UTF_8);
            return decodeVarint32 + i2;
        }
    }

    static int decodeStringRequireUtf8(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i2 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        } else {
            registers.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i2);
            return decodeVarint32 + i2;
        }
    }

    static int decodeBytes(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1;
        if (i2 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i2 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        } else if (i2 == 0) {
            registers.object1 = ByteString.EMPTY;
            return decodeVarint32;
        } else {
            registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, i2);
            return decodeVarint32 + i2;
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r8v4, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    static int decodeMessageField(Schema schema, byte[] bArr, int i, int i2, Registers registers) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = decodeVarint32(b, bArr, i3, registers);
            b2 = registers.int1;
        }
        byte b3 = i3;
        if (b2 < 0 || b2 > i2 - b3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        Object newInstance = schema.newInstance();
        int i4 = b2 + b3;
        schema.mergeFrom(newInstance, bArr, b3, i4, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return i4;
    }

    static int decodeGroupField(Schema schema, byte[] bArr, int i, int i2, int i3, Registers registers) throws IOException {
        MessageSchema messageSchema = (MessageSchema) schema;
        Object newInstance = messageSchema.newInstance();
        int parseProto2Message = messageSchema.parseProto2Message(newInstance, bArr, i, i2, i3, registers);
        messageSchema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return parseProto2Message;
    }

    static int decodeVarint32List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        intArrayList.addInt(registers.int1);
        while (decodeVarint32 < i3) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return decodeVarint32;
    }

    static int decodeVarint64List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i2, registers);
        longArrayList.addLong(registers.long1);
        while (decodeVarint64 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return decodeVarint64;
    }

    static int decodeFixed32List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, i4, registers);
            if (i != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            i4 = decodeVarint32 + 4;
        }
        return i4;
    }

    static int decodeFixed64List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, i4, registers);
            if (i != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            i4 = decodeVarint32 + 8;
        }
        return i4;
    }

    static int decodeFloatList(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i2));
        int i4 = i2 + 4;
        while (i4 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, i4, registers);
            if (i != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            i4 = decodeVarint32 + 4;
        }
        return i4;
    }

    static int decodeDoubleList(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i2));
        int i4 = i2 + 8;
        while (i4 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, i4, registers);
            if (i != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            i4 = decodeVarint32 + 8;
        }
        return i4;
    }

    static int decodeBoolList(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i2, registers);
        booleanArrayList.addBoolean(registers.long1 != 0);
        while (decodeVarint64 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        return decodeVarint64;
    }

    static int decodeSInt32List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (decodeVarint32 < i3) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return decodeVarint32;
    }

    static int decodeSInt64List(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i2, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (decodeVarint64 < i3) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return decodeVarint64;
    }

    static int decodePackedVarint32List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedVarint64List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed32List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFixed64List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedFloatList(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedDoubleList(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedBoolList(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt32List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static int decodePackedSInt64List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i2 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i2) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == i2) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[EDGE_INSN: B:21:0x0043->B:17:0x0043 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    static int decodeStringList(int r4, byte[] r5, int r6, int r7, com.google.protobuf.Internal.ProtobufList<?> r8, com.google.protobuf.ArrayDecoders.Registers r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            int r6 = decodeVarint32(r5, r6, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x0044
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0010
            r8.add(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
        L_0x001a:
            int r6 = r6 + r0
        L_0x001b:
            if (r6 >= r7) goto L_0x0043
            int r0 = decodeVarint32(r5, r6, r9)
            int r2 = r9.int1
            if (r4 != r2) goto L_0x0043
            int r6 = decodeVarint32(r5, r0, r9)
            int r0 = r9.int1
            if (r0 < 0) goto L_0x003e
            if (r0 != 0) goto L_0x0033
            r8.add(r1)
            goto L_0x001b
        L_0x0033:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.Internal.UTF_8
            r2.<init>(r5, r6, r0, r3)
            r8.add(r2)
            goto L_0x001a
        L_0x003e:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            throw r4
        L_0x0043:
            return r6
        L_0x0044:
            com.google.protobuf.InvalidProtocolBufferException r4 = com.google.protobuf.InvalidProtocolBufferException.negativeSize()
            goto L_0x004a
        L_0x0049:
            throw r4
        L_0x004a:
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.ArrayDecoders.decodeStringList(int, byte[], int, int, com.google.protobuf.Internal$ProtobufList, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r2 = r7 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (com.google.protobuf.Utf8.isValidUtf8(r6, r7, r2) == false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r9.add(new java.lang.String(r6, r7, r0, com.google.protobuf.Internal.UTF_8));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        throw com.google.protobuf.InvalidProtocolBufferException.invalidUtf8();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[EDGE_INSN: B:28:0x0058->B:23:0x0058 ?: BREAK  , SYNTHETIC] */
    static int decodeStringListRequireUtf8(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int i4;
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i5 = registers.int1;
        if (i5 >= 0) {
            if (i5 == 0) {
                protobufList.add("");
                while (true) {
                    if (decodeVarint32 < i3) {
                        break;
                    }
                    int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
                    if (i == registers.int1) {
                        decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
                        int i6 = registers.int1;
                        if (i6 >= 0) {
                            if (i6 != 0) {
                                break;
                            }
                            protobufList.add("");
                            protobufList.add("");
                        }
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                    break;
                }
                return decodeVarint32;
            }
            i4 = decodeVarint32 + i5;
            if (Utf8.isValidUtf8(bArr, decodeVarint32, i4)) {
                protobufList.add(new String(bArr, decodeVarint32, i5, Internal.UTF_8));
            } else {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            decodeVarint32 = i4;
            while (true) {
                if (decodeVarint32 < i3) {
                }
                protobufList.add("");
            }
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.negativeSize();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x004c A[EDGE_INSN: B:30:0x004c->B:22:0x004c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    static int decodeBytesList(int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i2, registers);
        int i4 = registers.int1;
        if (i4 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        } else if (i4 <= bArr.length - decodeVarint32) {
            if (i4 == 0) {
                protobufList.add(ByteString.EMPTY);
                while (true) {
                    if (decodeVarint32 < i3) {
                        break;
                    }
                    int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
                    if (i == registers.int1) {
                        decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
                        i4 = registers.int1;
                        if (i4 >= 0) {
                            if (i4 <= bArr.length - decodeVarint32) {
                                if (i4 != 0) {
                                    protobufList.add(ByteString.copyFrom(bArr, decodeVarint32, i4));
                                    break;
                                }
                                protobufList.add(ByteString.EMPTY);
                                protobufList.add(ByteString.EMPTY);
                            }
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        throw InvalidProtocolBufferException.negativeSize();
                    }
                    break;
                }
                return decodeVarint32;
            }
            protobufList.add(ByteString.copyFrom(bArr, decodeVarint32, i4));
            decodeVarint32 += i4;
            while (true) {
                if (decodeVarint32 < i3) {
                }
                protobufList.add(ByteString.EMPTY);
            }
            return decodeVarint32;
        } else {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    static int decodeMessageList(Schema<?> schema, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int decodeMessageField = decodeMessageField(schema, bArr, i2, i3, registers);
        protobufList.add(registers.object1);
        while (decodeMessageField < i3) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (i != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, i3, registers);
            protobufList.add(registers.object1);
        }
        return decodeMessageField;
    }

    static int decodeGroupList(Schema schema, int i, byte[] bArr, int i2, int i3, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i4 = (i & -8) | 4;
        int decodeGroupField = decodeGroupField(schema, bArr, i2, i3, i4, registers);
        protobufList.add(registers.object1);
        while (decodeGroupField < i3) {
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, registers);
            if (i != registers.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema, bArr, decodeVarint32, i3, i4, registers);
            protobufList.add(registers.object1);
        }
        return decodeGroupField;
    }

    static int decodeExtensionOrUnknownField(int i, byte[] bArr, int i2, int i3, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i, bArr, i2, i3, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i, bArr, i2, i3, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01f1, code lost:
        if (r9 != 18) goto L_0x0200;
     */
    static int decodeExtension(int i, byte[] bArr, int i2, int i3, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        int i4;
        LongArrayList longArrayList;
        Object valueOf;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i5 = i >>> 3;
        Object obj = null;
        if (!generatedExtension.descriptor.isRepeated() || !generatedExtension.descriptor.isPacked()) {
            if (generatedExtension.getLiteType() != WireFormat.FieldType.ENUM) {
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                    case 1:
                        valueOf = Double.valueOf(decodeDouble(bArr, i2));
                        i2 += 8;
                        break;
                    case 2:
                        obj = Float.valueOf(decodeFloat(bArr, i2));
                        i2 += 4;
                        break;
                    case 3:
                    case 4:
                        i2 = decodeVarint64(bArr, i2, registers);
                        obj = Long.valueOf(registers.long1);
                        break;
                    case 5:
                    case 6:
                        i2 = decodeVarint32(bArr, i2, registers);
                        obj = Integer.valueOf(registers.int1);
                        break;
                    case 7:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        valueOf = Long.valueOf(decodeFixed64(bArr, i2));
                        i2 += 8;
                        break;
                    case 9:
                    case 10:
                        obj = Integer.valueOf(decodeFixed32(bArr, i2));
                        i2 += 4;
                        break;
                    case 11:
                        i2 = decodeVarint64(bArr, i2, registers);
                        obj = Boolean.valueOf(registers.long1 != 0);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                        i2 = decodeVarint32(bArr, i2, registers);
                        obj = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                        break;
                    case 13:
                        i2 = decodeVarint64(bArr, i2, registers);
                        obj = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        i2 = decodeBytes(bArr, i2, registers);
                        obj = registers.object1;
                        break;
                    case 16:
                        i2 = decodeString(bArr, i2, registers);
                        obj = registers.object1;
                        break;
                    case 17:
                        i2 = decodeGroupField(Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass()), bArr, i2, i3, (i5 << 3) | 4, registers);
                        obj = registers.object1;
                        break;
                    case 18:
                        i2 = decodeMessageField(Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass()), bArr, i2, i3, registers);
                        obj = registers.object1;
                        break;
                }
            } else {
                i2 = decodeVarint32(bArr, i2, registers);
                if (generatedExtension.descriptor.getEnumType().findValueByNumber(registers.int1) == null) {
                    UnknownFieldSetLite unknownFieldSetLite = extendableMessage.unknownFields;
                    if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                        unknownFieldSetLite = UnknownFieldSetLite.newInstance();
                        extendableMessage.unknownFields = unknownFieldSetLite;
                    }
                    SchemaUtil.storeUnknownEnum(i5, registers.int1, unknownFieldSetLite, unknownFieldSchema);
                    return i2;
                }
                obj = Integer.valueOf(registers.int1);
            }
            i4 = i2;
            Object obj2 = obj;
            if (generatedExtension.isRepeated()) {
                fieldSet.addRepeatedField(generatedExtension.descriptor, obj2);
                return i4;
            }
            int i6 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()];
            if (i6 != 17) {
                longArrayList = obj2;
            }
            Object field = fieldSet.getField(generatedExtension.descriptor);
            longArrayList = obj2;
            if (field != null) {
                longArrayList = Internal.mergeMessage(field, obj2);
            }
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    i4 = decodePackedDoubleList(bArr, i2, doubleArrayList, registers);
                    longArrayList = doubleArrayList;
                    break;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    i4 = decodePackedFloatList(bArr, i2, floatArrayList, registers);
                    longArrayList = floatArrayList;
                    break;
                case 3:
                case 4:
                    LongArrayList longArrayList2 = new LongArrayList();
                    i4 = decodePackedVarint64List(bArr, i2, longArrayList2, registers);
                    longArrayList = longArrayList2;
                    break;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    i4 = decodePackedVarint32List(bArr, i2, intArrayList, registers);
                    longArrayList = intArrayList;
                    break;
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    LongArrayList longArrayList3 = new LongArrayList();
                    i4 = decodePackedFixed64List(bArr, i2, longArrayList3, registers);
                    longArrayList = longArrayList3;
                    break;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    i4 = decodePackedFixed32List(bArr, i2, intArrayList2, registers);
                    longArrayList = intArrayList2;
                    break;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    i4 = decodePackedBoolList(bArr, i2, booleanArrayList, registers);
                    longArrayList = booleanArrayList;
                    break;
                case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                    IntArrayList intArrayList3 = new IntArrayList();
                    i4 = decodePackedSInt32List(bArr, i2, intArrayList3, registers);
                    longArrayList = intArrayList3;
                    break;
                case 13:
                    LongArrayList longArrayList4 = new LongArrayList();
                    i4 = decodePackedSInt64List(bArr, i2, longArrayList4, registers);
                    longArrayList = longArrayList4;
                    break;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    i4 = decodePackedVarint32List(bArr, i2, intArrayList4, registers);
                    UnknownFieldSetLite unknownFieldSetLite2 = extendableMessage.unknownFields;
                    if (unknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance()) {
                        unknownFieldSetLite2 = null;
                    }
                    UnknownFieldSetLite unknownFieldSetLite3 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i5, intArrayList4, generatedExtension.descriptor.getEnumType(), unknownFieldSetLite2, unknownFieldSchema);
                    if (unknownFieldSetLite3 != null) {
                        extendableMessage.unknownFields = unknownFieldSetLite3;
                    }
                    fieldSet.setField(generatedExtension.descriptor, intArrayList4);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.descriptor.getLiteType());
            }
            return i4;
        }
        fieldSet.setField(generatedExtension.descriptor, longArrayList);
        return i4;
    }

    /* renamed from: com.google.protobuf.ArrayDecoders$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[WireFormat.FieldType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|38) */
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static int decodeUnknownField(int i, byte[] bArr, int i2, int i3, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i) != 0) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                int decodeVarint64 = decodeVarint64(bArr, i2, registers);
                unknownFieldSetLite.storeField(i, Long.valueOf(registers.long1));
                return decodeVarint64;
            } else if (tagWireType == 1) {
                unknownFieldSetLite.storeField(i, Long.valueOf(decodeFixed64(bArr, i2)));
                return i2 + 8;
            } else if (tagWireType == 2) {
                int decodeVarint32 = decodeVarint32(bArr, i2, registers);
                int i4 = registers.int1;
                if (i4 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                } else if (i4 <= bArr.length - decodeVarint32) {
                    if (i4 == 0) {
                        unknownFieldSetLite.storeField(i, ByteString.EMPTY);
                    } else {
                        unknownFieldSetLite.storeField(i, ByteString.copyFrom(bArr, decodeVarint32, i4));
                    }
                    return decodeVarint32 + i4;
                } else {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } else if (tagWireType == 3) {
                UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int decodeVarint322 = decodeVarint32(bArr, i2, registers);
                    int i7 = registers.int1;
                    if (i7 == i5) {
                        i6 = i7;
                        i2 = decodeVarint322;
                        break;
                    }
                    i6 = i7;
                    i2 = decodeUnknownField(i7, bArr, decodeVarint322, i3, newInstance, registers);
                }
                if (i2 > i3 || i6 != i5) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
                unknownFieldSetLite.storeField(i, newInstance);
                return i2;
            } else if (tagWireType == 5) {
                unknownFieldSetLite.storeField(i, Integer.valueOf(decodeFixed32(bArr, i2)));
                return i2 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }

    static int skipField(int i, byte[] bArr, int i2, int i3, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i) != 0) {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                return decodeVarint64(bArr, i2, registers);
            }
            if (tagWireType == 1) {
                return i2 + 8;
            }
            if (tagWireType == 2) {
                return decodeVarint32(bArr, i2, registers) + registers.int1;
            }
            if (tagWireType == 3) {
                int i4 = (i & -8) | 4;
                int i5 = 0;
                while (i2 < i3) {
                    i2 = decodeVarint32(bArr, i2, registers);
                    i5 = registers.int1;
                    if (i5 == i4) {
                        break;
                    }
                    i2 = skipField(i5, bArr, i2, i3, registers);
                }
                if (i2 <= i3 && i5 == i4) {
                    return i2;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } else if (tagWireType == 5) {
                return i2 + 4;
            } else {
                throw InvalidProtocolBufferException.invalidTag();
            }
        } else {
            throw InvalidProtocolBufferException.invalidTag();
        }
    }
}
