package com.tutk.IOTC;

public class Packet {
    public static final int byteToInt(int i, int i2, int i3) {
        return (int) (((long) (i >> i3)) & (4294967295 >> (32 - i2)));
    }

    public static final short byteArrayToShort(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = (bArr[i] & 255) << 8;
            i3 = bArr[i + 1] & 255;
        } else {
            i2 = bArr[i] & 255;
            i3 = (bArr[i + 1] & 255) << 8;
        }
        return (short) (i3 | i2);
    }

    public static final int byteArrayToInt(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
            i2 = bArr[i + 3] & 255;
        } else {
            b = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
            i2 = (bArr[i + 3] & 255) << 24;
        }
        return i2 | b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    public static int byteArrayToInt_Little(byte[] bArr) {
        byte b;
        int i;
        while (true) {
            if (bArr.length == 2) {
                b = bArr[0] & 255;
                i = (bArr[1] & 255) << 8;
                break;
            } else if (bArr.length == 4) {
                b = (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
                i = (bArr[3] & 255) << 24;
                break;
            }
        }
        return i | b;
    }

    public static int byteArrayToInt_Little(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static short byteArrayToShort_Little(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    public static final long byteArrayToLong(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
            i2 = bArr[i + 7] & 255;
        } else {
            b = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
            i2 = (bArr[i + 7] & 255) << 56;
        }
        return (long) (i2 | b);
    }

    public static final byte[] shortToByteArray(short s, boolean z) {
        if (z) {
            return new byte[]{(byte) (s >>> 8), (byte) s};
        }
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }

    public static final byte[] intToByteArray(int i, boolean z) {
        if (z) {
            return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
        }
        return new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24)};
    }

    public static byte[] intToByteArray_Little(int i) {
        return new byte[]{(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24)};
    }

    public static byte[] shortToByteArray_Little(short s) {
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }
}
