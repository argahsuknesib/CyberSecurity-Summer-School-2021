package _m_j;

import java.lang.reflect.Array;

final class igo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final float[][] f1276O000000o = ((float[][]) Array.newInstance(float.class, ige.f1268O000000o.length, 8));

    static {
        int i;
        for (int i2 = 0; i2 < ige.f1268O000000o.length; i2++) {
            int i3 = ige.f1268O000000o[i2];
            int i4 = i3 & 1;
            int i5 = i3;
            int i6 = 0;
            while (i6 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i5 & 1;
                    if (i != i4) {
                        break;
                    }
                    f += 1.0f;
                    i5 >>= 1;
                }
                f1276O000000o[i2][(8 - i6) - 1] = f / 17.0f;
                i6++;
                i4 = i;
            }
        }
    }

    static int O000000o(int[] iArr) {
        float O000000o2 = (float) idw.O000000o(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (O000000o2 / 34.0f) + ((((float) i3) * O000000o2) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        long j = 0;
        int i4 = 0;
        while (i4 < 8) {
            long j2 = j;
            for (int i5 = 0; i5 < iArr2[i4]; i5++) {
                j2 = (j2 << 1) | ((long) (i4 % 2 == 0 ? 1 : 0));
            }
            i4++;
            j = j2;
        }
        int i6 = (int) j;
        int i7 = -1;
        if (ige.O000000o(i6) == -1) {
            i6 = -1;
        }
        if (i6 != -1) {
            return i6;
        }
        int O000000o3 = idw.O000000o(iArr);
        float[] fArr = new float[8];
        for (int i8 = 0; i8 < 8; i8++) {
            fArr[i8] = ((float) iArr[i8]) / ((float) O000000o3);
        }
        int i9 = 0;
        float f = Float.MAX_VALUE;
        while (true) {
            float[][] fArr2 = f1276O000000o;
            if (i9 >= fArr2.length) {
                return i7;
            }
            float[] fArr3 = fArr2[i9];
            float f2 = 0.0f;
            for (int i10 = 0; i10 < 8; i10++) {
                float f3 = fArr3[i10] - fArr[i10];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i7 = ige.f1268O000000o[i9];
                f = f2;
            }
            i9++;
        }
    }
}
