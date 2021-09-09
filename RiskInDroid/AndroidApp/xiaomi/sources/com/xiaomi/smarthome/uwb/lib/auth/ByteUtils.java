package com.xiaomi.smarthome.uwb.lib.auth;

import java.util.Arrays;

public class ByteUtils {
    public static final byte[] EMPTY_BYTES = new byte[0];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean getBit(byte b, int i, boolean z) {
        return z ? (b & (1 << i)) != 0 : (b & (1 << (7 - i))) != 0;
    }

    public static int ubyteToInt(byte b) {
        return b & 255;
    }

    public static byte[] getNonEmptyByte(byte[] bArr) {
        return bArr != null ? bArr : EMPTY_BYTES;
    }

    public static String getText(byte[] bArr) {
        return new String(bArr);
    }

    public static byte[] getBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        if (i >= 0 && i < bArr.length && i2 >= 0 && i2 < bArr.length) {
            if (i > i2) {
                return null;
            }
            bArr2 = new byte[((i2 - i) + 1)];
            for (int i3 = i; i3 <= i2; i3++) {
                bArr2[i3 - i] = bArr[i3];
            }
        }
        return bArr2;
    }

    public static boolean byteEquals(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || (length = bArr.length) != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean byteEquals(byte[] bArr, int i, byte[] bArr2) {
        int length;
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || i < 0 || i >= bArr.length || (length = (bArr2.length + i) - 1) < 0 || length >= bArr.length) {
            return false;
        }
        for (int i2 = i; i2 <= length; i2++) {
            if (bArr[i2] != bArr2[i2 - i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean getBit(byte b, int i) {
        return getBit(b, i, true);
    }

    public static String byteToStringLittleEndian(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty(bArr)) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[length])));
            }
        }
        return sb.toString();
    }

    public static String byteToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty(bArr)) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
            }
        }
        return sb.toString();
    }

    public static byte[] stringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[((length + 1) / 2)];
        int i = 0;
        while (i < length) {
            try {
                bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, Math.min(2, length - i) + i), 16);
                i += 2;
            } catch (Exception e) {
                e.printStackTrace();
                return EMPTY_BYTES;
            }
        }
        return bArr;
    }

    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean isAllFF(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        for (int i = 0; i < length; i++) {
            if (ubyteToInt(bArr[i]) != 255) {
                return false;
            }
        }
        return true;
    }

    public static byte[] fillBeforeBytes(byte[] bArr, int i, byte b) {
        int length = bArr != null ? bArr.length : 0;
        if (length >= i) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        int i2 = i - 1;
        int i3 = length - 1;
        while (i2 >= 0) {
            if (i3 >= 0) {
                bArr2[i2] = bArr[i3];
            } else {
                bArr2[i2] = b;
            }
            i2--;
            i3--;
        }
        return bArr2;
    }

    public static byte[] cutBeforeBytes(byte[] bArr, byte b) {
        if (isEmpty(bArr)) {
            return bArr;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != b) {
                return Arrays.copyOfRange(bArr, i, bArr.length);
            }
        }
        return EMPTY_BYTES;
    }

    public static byte[] cutAfterBytes(byte[] bArr, byte b) {
        if (isEmpty(bArr)) {
            return bArr;
        }
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != b) {
                return Arrays.copyOfRange(bArr, 0, length + 1);
            }
        }
        return EMPTY_BYTES;
    }

    public static boolean isNormalBytes(byte[] bArr) {
        return !isEmpty(bArr) && !isAllFF(bArr);
    }

    public static byte[] fromInt(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static byte[] fromLong(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (j >>> (i * 8)));
        }
        return bArr;
    }

    public static byte[] fromLongLittleEndian(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[7 - i] = (byte) ((int) (j >>> (i * 8)));
        }
        return bArr;
    }

    public static byte[] fromShort(short s) {
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }

    public static int toInt(byte[] bArr) {
        int i = 0;
        if (bArr.length != 4) {
            return 0;
        }
        int i2 = 0;
        while (i < 4) {
            int i3 = i + 1;
            i2 = (int) (((long) i2) + (((1 << (i3 * 8)) - 1) & ((long) (bArr[i] << (i * 8)))));
            i = i3;
        }
        return i2;
    }

    public static boolean isSameElement(byte[] bArr, byte b) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (b2 != b) {
                return false;
            }
        }
        return true;
    }

    public static void copy(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr != null && bArr2 != null && i >= 0) {
            while (i2 < bArr2.length && i < bArr.length) {
                bArr[i] = bArr2[i2];
                i++;
                i2++;
            }
        }
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        return equals(bArr, bArr2, Math.min(bArr.length, bArr2.length));
    }

    public static boolean equals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] get(byte[] bArr, int i) {
        return get(bArr, i, bArr.length - i);
    }

    public static byte[] get(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(HEX_DIGITS[(b & 240) >>> 4]);
            sb.append(HEX_DIGITS[b & 15]);
        }
        return sb.toString();
    }
}
