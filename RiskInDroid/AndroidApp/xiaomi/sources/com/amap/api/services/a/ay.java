package com.amap.api.services.a;

public class ay {

    /* renamed from: a  reason: collision with root package name */
    private static int f3291a = 4;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.ay.a(int[], boolean):byte[]
     arg types: [int[], int]
     candidates:
      com.amap.api.services.a.ay.a(byte[], byte[]):byte[]
      com.amap.api.services.a.ay.a(byte[], boolean):int[]
      com.amap.api.services.a.ay.a(int[], int[]):int[]
      com.amap.api.services.a.ay.a(int[], boolean):byte[] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.amap.api.services.a.ay.a(byte[], boolean):int[]
     arg types: [byte[], int]
     candidates:
      com.amap.api.services.a.ay.a(byte[], byte[]):byte[]
      com.amap.api.services.a.ay.a(int[], boolean):byte[]
      com.amap.api.services.a.ay.a(int[], int[]):int[]
      com.amap.api.services.a.ay.a(byte[], boolean):int[] */
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i = f3291a;
        int i2 = i - (length % i);
        byte[] bArr3 = new byte[(((length / i) + 1) * i)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < bArr3.length) {
            bArr3[length] = (byte) i2;
            length++;
        }
        return a(a(a(bArr3, true), a(bArr2, false)), false);
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = (52 / (length + 1)) + 6;
        int i2 = iArr[length];
        int i3 = 0;
        while (true) {
            int i4 = i - 1;
            if (i <= 0) {
                return iArr;
            }
            i3 -= 1640531527;
            int i5 = (i3 >>> 2) & 3;
            int i6 = i2;
            int i7 = 0;
            while (i7 < length) {
                int i8 = i7 + 1;
                int i9 = iArr[i8];
                i6 = ((((i6 >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i6 << 4))) ^ ((i9 ^ i3) + (i6 ^ iArr2[(i7 & 3) ^ i5]))) + iArr[i7];
                iArr[i7] = i6;
                i7 = i8;
            }
            int i10 = iArr[0];
            i2 = iArr[length] + ((((i6 >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i6 << 4))) ^ ((i10 ^ i3) + (iArr2[i5 ^ (i7 & 3)] ^ i6)));
            iArr[length] = i2;
            i = i4;
        }
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr = new int[(bArr.length >>> 2)];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static byte[] a(int[] iArr, boolean z) {
        int i;
        int length = iArr.length << 2;
        if (z) {
            i = iArr[iArr.length - 1];
            if (i > length) {
                return null;
            }
        } else {
            i = length;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
        }
        return bArr;
    }
}
