package org.apache.commons.codec.binary;

import android.support.v4.app.NotificationCompat;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class BinaryCodec implements BinaryDecoder, BinaryEncoder {
    private static final int[] BITS = {1, 2, 4, 8, 16, 32, 64, NotificationCompat.FLAG_HIGH_PRIORITY};
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final char[] EMPTY_CHAR_ARRAY = new char[0];

    public byte[] encode(byte[] bArr) {
        return toAsciiBytes(bArr);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return toAsciiChars((byte[]) obj);
        }
        throw new EncoderException("argument not a byte array");
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return EMPTY_BYTE_ARRAY;
        }
        if (obj instanceof byte[]) {
            return fromAscii((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return fromAscii((char[]) obj);
        }
        if (obj instanceof String) {
            return fromAscii(((String) obj).toCharArray());
        }
        throw new DecoderException("argument not a byte array");
    }

    public byte[] decode(byte[] bArr) {
        return fromAscii(bArr);
    }

    public byte[] toByteArray(String str) {
        if (str == null) {
            return EMPTY_BYTE_ARRAY;
        }
        return fromAscii(str.toCharArray());
    }

    public static byte[] fromAscii(char[] cArr) {
        if (cArr == null || cArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[(cArr.length >> 3)];
        int length = cArr.length - 1;
        int i = 0;
        while (i < bArr.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 >= iArr.length) {
                    break;
                }
                if (cArr[length - i2] == '1') {
                    bArr[i] = (byte) (iArr[i2] | bArr[i]);
                }
                i2++;
            }
            i++;
            length -= 8;
        }
        return bArr;
    }

    public static byte[] fromAscii(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[(bArr.length >> 3)];
        int length = bArr.length - 1;
        int i = 0;
        while (i < bArr2.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 >= iArr.length) {
                    break;
                }
                if (bArr[length - i2] == 49) {
                    bArr2[i] = (byte) (iArr[i2] | bArr2[i]);
                }
                i2++;
            }
            i++;
            length -= 8;
        }
        return bArr2;
    }

    private static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static byte[] toAsciiBytes(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[(bArr.length << 3)];
        int length = bArr2.length - 1;
        int i = 0;
        while (i < bArr.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 >= iArr.length) {
                    break;
                }
                if ((iArr[i2] & bArr[i]) == 0) {
                    bArr2[length - i2] = 48;
                } else {
                    bArr2[length - i2] = 49;
                }
                i2++;
            }
            i++;
            length -= 8;
        }
        return bArr2;
    }

    public static char[] toAsciiChars(byte[] bArr) {
        if (isEmpty(bArr)) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[(bArr.length << 3)];
        int length = cArr.length - 1;
        int i = 0;
        while (i < bArr.length) {
            int i2 = 0;
            while (true) {
                int[] iArr = BITS;
                if (i2 >= iArr.length) {
                    break;
                }
                if ((iArr[i2] & bArr[i]) == 0) {
                    cArr[length - i2] = '0';
                } else {
                    cArr[length - i2] = '1';
                }
                i2++;
            }
            i++;
            length -= 8;
        }
        return cArr;
    }

    public static String toAsciiString(byte[] bArr) {
        return new String(toAsciiChars(bArr));
    }
}
