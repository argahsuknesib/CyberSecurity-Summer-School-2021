package _m_j;

public final class gro {
    public static float O000000o(float f, float[] fArr, float[] fArr2) {
        if (fArr.length == fArr2.length) {
            int length = fArr.length;
            if (f <= fArr[0]) {
                return fArr2[0];
            }
            for (int i = 1; i < length; i++) {
                float f2 = fArr[i];
                if (f <= f2) {
                    int i2 = i - 1;
                    float f3 = fArr[i2];
                    float f4 = fArr2[i];
                    float f5 = fArr2[i2];
                    return f5 + ((f4 - f5) * ((f - f3) / (f2 - f3)));
                }
            }
            return fArr2[length - 1];
        }
        throw new IllegalArgumentException("Range and values arrays must be of the same size");
    }
}
