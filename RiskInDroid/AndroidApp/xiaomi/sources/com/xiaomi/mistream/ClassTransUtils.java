package com.xiaomi.mistream;

import java.nio.ByteOrder;

public class ClassTransUtils {
    private static volatile ClassTransUtils instance;
    private String TAG = "ClassTransUtils";

    private ClassTransUtils() {
    }

    public static ClassTransUtils getInstance() {
        if (instance == null) {
            synchronized (ClassTransUtils.class) {
                if (instance == null) {
                    instance = new ClassTransUtils();
                }
            }
        }
        return instance;
    }

    public boolean testCPU() {
        return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public byte[] getBytes(short s, boolean z) {
        byte[] bArr = new byte[2];
        if (z) {
            for (int i = 1; i >= 0; i--) {
                bArr[i] = (byte) (s & 255);
                s = (short) (s >> 8);
            }
        } else {
            for (int i2 = 0; i2 < 2; i2++) {
                bArr[i2] = (byte) (s & 255);
                s = (short) (s >> 8);
            }
        }
        return bArr;
    }

    public byte[] getBytes(int i, boolean z) {
        byte[] bArr = new byte[4];
        if (z) {
            for (int i2 = 3; i2 >= 0; i2--) {
                bArr[i2] = (byte) (i & 255);
                i >>= 8;
            }
        } else {
            for (int i3 = 0; i3 < 4; i3++) {
                bArr[i3] = (byte) (i & 255);
                i >>= 8;
            }
        }
        return bArr;
    }

    public byte[] getBytes(long j, boolean z) {
        byte[] bArr = new byte[8];
        if (z) {
            for (int i = 7; i >= 0; i--) {
                bArr[i] = (byte) ((int) (j & 255));
                j >>= 8;
            }
        } else {
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[i2] = (byte) ((int) (j & 255));
                j >>= 8;
            }
        }
        return bArr;
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    public short getShort(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("byte array is null!");
        } else if (bArr.length <= 2) {
            int i = 0;
            if (z) {
                short s = 0;
                while (i < bArr.length) {
                    s = (short) (((short) (s << 8)) | (bArr[i] & 255));
                    i++;
                }
                return s;
            }
            for (int length = bArr.length - 1; length >= 0; length--) {
                i = (short) (((short) (i << 8)) | (bArr[length] & 255));
            }
            return i;
        } else {
            throw new IllegalArgumentException("byte array size > 2 !");
        }
    }

    public int getInt(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("byte array is null!");
        } else if (bArr.length <= 4) {
            int i = 0;
            if (z) {
                byte b = 0;
                while (i < bArr.length) {
                    b = (b << 8) | (bArr[i] & 255);
                    i++;
                }
                return b;
            }
            for (int length = bArr.length - 1; length >= 0; length--) {
                i = (i << 8) | (bArr[length] & 255);
            }
            return i;
        } else {
            throw new IllegalArgumentException("byte array size > 4 !");
        }
    }

    public long getLong(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("byte array is null!");
        } else if (bArr.length <= 8) {
            long j = 0;
            if (z) {
                for (byte b : bArr) {
                    j = (j << 8) | ((long) (b & 255));
                }
            } else {
                for (int length = bArr.length - 1; length >= 0; length--) {
                    j = (j << 8) | ((long) (bArr[length] & 255));
                }
            }
            return j;
        } else {
            throw new IllegalArgumentException("byte array size > 8 !");
        }
    }

    public byte[] getBytes(int i) {
        return getBytes(i, testCPU());
    }

    public byte[] getBytes(short s) {
        return getBytes(s, testCPU());
    }

    public byte[] getBytes(long j) {
        return getBytes(j, testCPU());
    }

    public int getInt(byte[] bArr) {
        return getInt(bArr, testCPU());
    }

    public short getShort(byte[] bArr) {
        return getShort(bArr, testCPU());
    }

    public long getLong(byte[] bArr) {
        return getLong(bArr, testCPU());
    }

    public short[] bytes2Shorts(byte[] bArr) {
        short[] sArr = new short[(bArr.length / 2)];
        for (int i = 0; i < sArr.length; i++) {
            byte[] bArr2 = new byte[2];
            for (int i2 = 0; i2 < 2; i2++) {
                bArr2[i2] = bArr[(i * 2) + i2];
            }
            sArr[i] = getShort(bArr2);
        }
        return sArr;
    }

    public byte[] shorts2Bytes(short[] sArr) {
        byte[] bArr = new byte[(sArr.length * 2)];
        for (int i = 0; i < sArr.length; i++) {
            byte[] bytes = getBytes(sArr[i]);
            for (int i2 = 0; i2 < 2; i2++) {
                bArr[(i * 2) + i2] = bytes[i2];
            }
        }
        return bArr;
    }

    public int[] bytes2Ints(byte[] bArr) {
        int[] iArr = new int[(bArr.length / 4)];
        for (int i = 0; i < iArr.length; i++) {
            byte[] bArr2 = new byte[4];
            for (int i2 = 0; i2 < 4; i2++) {
                bArr2[i2] = bArr[(i * 4) + i2];
            }
            iArr[i] = getInt(bArr2);
        }
        return iArr;
    }

    public byte[] ints2Bytes(int[] iArr) {
        byte[] bArr = new byte[(iArr.length * 4)];
        for (int i = 0; i < iArr.length; i++) {
            byte[] bytes = getBytes(iArr[i]);
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[(i * 4) + i2] = bytes[i2];
            }
        }
        return bArr;
    }

    public long[] bytes2Longs(byte[] bArr) {
        long[] jArr = new long[(bArr.length / 8)];
        for (int i = 0; i < jArr.length; i++) {
            byte[] bArr2 = new byte[8];
            for (int i2 = 0; i2 < 8; i2++) {
                bArr2[i2] = bArr[(i * 8) + i2];
            }
            jArr[i] = getLong(bArr2);
        }
        return jArr;
    }

    public byte[] longs2Bytes(long[] jArr) {
        byte[] bArr = new byte[(jArr.length * 8)];
        for (int i = 0; i < jArr.length; i++) {
            byte[] bytes = getBytes(jArr[i]);
            for (int i2 = 0; i2 < 8; i2++) {
                bArr[(i * 8) + i2] = bytes[i2];
            }
        }
        return bArr;
    }
}
