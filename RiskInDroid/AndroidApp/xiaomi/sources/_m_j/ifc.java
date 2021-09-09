package _m_j;

import com.xiaomi.zxing.NotFoundException;

public abstract class ifc extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final int[] f1255O000000o = new int[4];
    protected final int[] O00000Oo = new int[8];
    protected final float[] O00000o = new float[4];
    protected final float[] O00000o0 = new float[4];
    protected final int[] O00000oO;
    protected final int[] O00000oo;

    protected ifc() {
        int[] iArr = this.O00000Oo;
        this.O00000oO = new int[(iArr.length / 2)];
        this.O00000oo = new int[(iArr.length / 2)];
    }

    protected static int O000000o(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (O000000o(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static void O000000o(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    protected static void O00000Oo(int[] iArr, float[] fArr) {
        float f = fArr[0];
        int i = 0;
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    protected static boolean O000000o(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = ((float) i) / ((float) ((iArr[2] + i) + iArr[3]));
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i2 = Integer.MIN_VALUE;
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 > i2) {
                    i2 = i4;
                }
                if (i4 < i3) {
                    i3 = i4;
                }
            }
            if (i2 < i3 * 10) {
                return true;
            }
        }
        return false;
    }
}
