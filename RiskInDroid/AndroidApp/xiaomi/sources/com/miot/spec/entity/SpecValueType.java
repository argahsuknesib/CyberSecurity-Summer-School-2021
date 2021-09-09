package com.miot.spec.entity;

import com.google.android.exoplayer2.C;
import com.miot.spec.exception.NotSupportValueException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public enum SpecValueType {
    BOOL((byte) 0, 1, 0, 0),
    UINT8((byte) 1, 1, 0, 255),
    INT8((byte) 2, 1, -128, 127),
    UINT16((byte) 3, 2, 0, 65535),
    INT16((byte) 4, 2, -32768, 32767),
    UINT32((byte) 5, 4, 0, 4294967295L),
    INT32((byte) 6, 4, -2147483648L, 2147483647L),
    UINT64((byte) 7, 8, 0, Long.MAX_VALUE),
    INT64((byte) 8, 8, Long.MIN_VALUE, Long.MAX_VALUE),
    FLOAT((byte) 9, 4, 0, 0),
    STRING((byte) 10, 0, 0, 0);
    
    private byte bitValue;
    private int byteLength;
    private long valueMax;
    private long valueMin;

    public final byte value() {
        return this.bitValue;
    }

    public final int byteLength() {
        return this.byteLength;
    }

    public static SpecValueType convert2ValueType(int i) {
        switch (i) {
            case 0:
                return BOOL;
            case 1:
                return UINT8;
            case 2:
                return INT8;
            case 3:
                return UINT16;
            case 4:
                return INT16;
            case 5:
                return UINT32;
            case 6:
                return INT32;
            case 7:
                return UINT64;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return INT64;
            case 9:
                return FLOAT;
            case 10:
                return STRING;
            default:
                throw new UnsupportedOperationException("SpecValueType:unsupport bitvalue ".concat(String.valueOf(i)));
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static SpecValueType convert2ValueType(String str) {
        char c;
        switch (str.hashCode()) {
            case -891985903:
                if (str.equals("string")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -844996865:
                if (str.equals("uint16")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -844996807:
                if (str.equals("uint32")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -844996712:
                if (str.equals("uint64")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3029738:
                if (str.equals("bool")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3237417:
                if (str.equals("int8")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 97526364:
                if (str.equals("float")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case 100359764:
                if (str.equals("int16")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 100359822:
                if (str.equals("int32")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 100359917:
                if (str.equals("int64")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case 111289374:
                if (str.equals("uint8")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return BOOL;
            case 1:
                return UINT8;
            case 2:
                return INT8;
            case 3:
                return UINT16;
            case 4:
                return INT16;
            case 5:
                return UINT32;
            case 6:
                return INT32;
            case 7:
                return UINT64;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return INT64;
            case 9:
                return FLOAT;
            case 10:
                return STRING;
            default:
                throw new UnsupportedOperationException("SpecValueType:unsupport value type ".concat(String.valueOf(str)));
        }
    }

    private SpecValueType(byte b, int i, long j, long j2) {
        this.bitValue = b;
        this.byteLength = i;
        this.valueMin = j;
        this.valueMax = j2;
    }

    public final long getMaxValue() {
        return this.valueMax;
    }

    /* renamed from: com.miot.spec.entity.SpecValueType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f5249O000000o = new int[SpecValueType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f5249O000000o[SpecValueType.INT8.ordinal()] = 1;
            f5249O000000o[SpecValueType.UINT8.ordinal()] = 2;
            f5249O000000o[SpecValueType.UINT16.ordinal()] = 3;
            f5249O000000o[SpecValueType.INT16.ordinal()] = 4;
            f5249O000000o[SpecValueType.INT32.ordinal()] = 5;
            f5249O000000o[SpecValueType.UINT32.ordinal()] = 6;
            f5249O000000o[SpecValueType.UINT64.ordinal()] = 7;
            f5249O000000o[SpecValueType.INT64.ordinal()] = 8;
            f5249O000000o[SpecValueType.BOOL.ordinal()] = 9;
            f5249O000000o[SpecValueType.FLOAT.ordinal()] = 10;
            try {
                f5249O000000o[SpecValueType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    public final boolean isValueValid(Object obj) throws NotSupportValueException {
        long j;
        switch (AnonymousClass1.f5249O000000o[ordinal()]) {
            case 1:
            case 2:
                if (obj instanceof Byte) {
                    j = (long) ((Byte) obj).byteValue();
                    if (obj instanceof Short) {
                        j = (long) ((Short) obj).shortValue();
                    }
                    if (obj instanceof Integer) {
                        j = (long) ((Integer) obj).intValue();
                    }
                    if (obj instanceof Long) {
                        j = ((Long) obj).longValue();
                        break;
                    }
                }
                break;
            case 3:
            case 4:
                j = Long.MIN_VALUE;
                if (obj instanceof Short) {
                }
                if (obj instanceof Integer) {
                }
                if (obj instanceof Long) {
                }
                break;
            case 5:
            case 6:
                j = Long.MIN_VALUE;
                if (obj instanceof Integer) {
                }
                if (obj instanceof Long) {
                }
                break;
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                j = Long.MIN_VALUE;
                if (obj instanceof Long) {
                }
                break;
            case 9:
            case 10:
            case 11:
                return true;
            default:
                j = Long.MIN_VALUE;
                break;
        }
        if (j != Long.MIN_VALUE && j >= this.valueMin && j <= this.valueMax) {
            return true;
        }
        throw new NotSupportValueException("the value " + obj + ",should belong【 " + this.valueMin + "," + this.valueMax + "】");
    }

    public static Object convertBytes2Value(SpecValueType specValueType, byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        switch (AnonymousClass1.f5249O000000o[specValueType.ordinal()]) {
            case 1:
                return Byte.valueOf(order.get());
            case 2:
                return Byte.valueOf(order.get());
            case 3:
                return Short.valueOf(order.getShort());
            case 4:
                return Short.valueOf(order.getShort());
            case 5:
                return Integer.valueOf(order.getInt());
            case 6:
                return Integer.valueOf(order.getInt());
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return Long.valueOf(order.getLong());
            case 9:
                boolean z = true;
                if (order.get() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 10:
                return Float.valueOf(order.getFloat());
            case 11:
                return new String(bArr);
            default:
                return null;
        }
    }
}
