package com.google.protobuf;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import java.io.IOException;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class WireFormat {
    static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);

    enum Utf8Validation {
        LOOSE {
            /* access modifiers changed from: package-private */
            public final Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.readString();
            }
        },
        STRICT {
            /* access modifiers changed from: package-private */
            public final Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.readStringRequireUtf8();
            }
        },
        LAZY {
            /* access modifiers changed from: package-private */
            public final Object readString(CodedInputStream codedInputStream) throws IOException {
                return codedInputStream.readBytes();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Object readString(CodedInputStream codedInputStream) throws IOException;
    }

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    public static int getTagWireType(int i) {
        return i & 7;
    }

    static int makeTag(int i, int i2) {
        return (i << 3) | i2;
    }

    private WireFormat() {
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }

        /* access modifiers changed from: package-private */
        public final Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(JavaType.LONG, 0),
        UINT64(JavaType.LONG, 0),
        INT32(JavaType.INT, 0),
        FIXED64(JavaType.LONG, 1),
        FIXED32(JavaType.INT, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        GROUP(JavaType.MESSAGE, 3) {
            public final boolean isPackable() {
                return false;
            }
        },
        MESSAGE(JavaType.MESSAGE, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            public final boolean isPackable() {
                return false;
            }
        },
        UINT32(JavaType.INT, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(JavaType.INT, 5),
        SFIXED64(JavaType.LONG, 1),
        SINT32(JavaType.INT, 0),
        SINT64(JavaType.LONG, 0);
        
        private final JavaType javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        private FieldType(JavaType javaType2, int i) {
            this.javaType = javaType2;
            this.wireType = i;
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }
    }

    /* renamed from: com.google.protobuf.WireFormat$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType = new int[FieldType.values().length];

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
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.DOUBLE.ordinal()] = 1;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FLOAT.ordinal()] = 2;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT64.ordinal()] = 3;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT64.ordinal()] = 4;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.INT32.ordinal()] = 5;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED64.ordinal()] = 6;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.FIXED32.ordinal()] = 7;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BOOL.ordinal()] = 8;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.BYTES.ordinal()] = 9;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.UINT32.ordinal()] = 10;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 11;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 12;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT32.ordinal()] = 13;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SINT64.ordinal()] = 14;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.STRING.ordinal()] = 15;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.GROUP.ordinal()] = 16;
            $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.MESSAGE.ordinal()] = 17;
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static Object readPrimitiveField(CodedInputStream codedInputStream, FieldType fieldType, Utf8Validation utf8Validation) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.readDouble());
            case 2:
                return Float.valueOf(codedInputStream.readFloat());
            case 3:
                return Long.valueOf(codedInputStream.readInt64());
            case 4:
                return Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return Integer.valueOf(codedInputStream.readFixed32());
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Boolean.valueOf(codedInputStream.readBool());
            case 9:
                return codedInputStream.readBytes();
            case 10:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 11:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 13:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 14:
                return Long.valueOf(codedInputStream.readSInt64());
            case GmsLogger.MAX_PII_TAG_LENGTH:
                return utf8Validation.readString(codedInputStream);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
