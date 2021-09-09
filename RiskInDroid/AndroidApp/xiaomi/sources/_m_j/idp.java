package _m_j;

import com.xiaomi.zxing.NotFoundException;

public final class idp extends ids {
    public final idm O000000o(idm idm, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException {
        return O000000o(idm, i, i2, idu.O000000o(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    public final idm O000000o(idm idm, int i, int i2, idu idu) throws NotFoundException {
        idm idm2 = idm;
        int i3 = i;
        int i4 = i2;
        idu idu2 = idu;
        if (i3 <= 0 || i4 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        idm idm3 = new idm(i3, i4);
        float[] fArr = new float[(i3 * 2)];
        int i5 = 0;
        while (i5 < i4) {
            int length = fArr.length;
            float f = ((float) i5) + 0.5f;
            for (int i6 = 0; i6 < length; i6 += 2) {
                fArr[i6] = ((float) (i6 / 2)) + 0.5f;
                fArr[i6 + 1] = f;
            }
            int length2 = fArr.length;
            float f2 = idu2.f1218O000000o;
            float f3 = idu2.O00000Oo;
            float f4 = idu2.O00000o0;
            float f5 = idu2.O00000o;
            float f6 = idu2.O00000oO;
            float f7 = idu2.O00000oo;
            float f8 = idu2.O0000O0o;
            float f9 = idu2.O0000OOo;
            float f10 = idu2.O0000Oo0;
            for (int i7 = 0; i7 < length2; i7 += 2) {
                float f11 = fArr[i7];
                int i8 = i7 + 1;
                float f12 = fArr[i8];
                float f13 = (f4 * f11) + (f7 * f12) + f10;
                fArr[i7] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
                fArr[i8] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
            }
            int i9 = idm2.f1214O000000o;
            int i10 = idm2.O00000Oo;
            boolean z = true;
            for (int i11 = 0; i11 < fArr.length && z; i11 += 2) {
                int i12 = (int) fArr[i11];
                int i13 = i11 + 1;
                int i14 = (int) fArr[i13];
                if (i12 < -1 || i12 > i9 || i14 < -1 || i14 > i10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i12 == -1) {
                    fArr[i11] = 0.0f;
                } else if (i12 == i9) {
                    fArr[i11] = (float) (i9 - 1);
                } else {
                    z = false;
                    if (i14 != -1) {
                        fArr[i13] = 0.0f;
                    } else if (i14 == i10) {
                        fArr[i13] = (float) (i10 - 1);
                    }
                    z = true;
                }
                z = true;
                if (i14 != -1) {
                }
                z = true;
            }
            boolean z2 = true;
            for (int length3 = fArr.length - 2; length3 >= 0 && z2; length3 -= 2) {
                int i15 = (int) fArr[length3];
                int i16 = length3 + 1;
                int i17 = (int) fArr[i16];
                if (i15 < -1 || i15 > i9 || i17 < -1 || i17 > i10) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (i15 == -1) {
                    fArr[length3] = 0.0f;
                } else if (i15 == i9) {
                    fArr[length3] = (float) (i9 - 1);
                } else {
                    z2 = false;
                    if (i17 != -1) {
                        fArr[i16] = 0.0f;
                    } else if (i17 == i10) {
                        fArr[i16] = (float) (i10 - 1);
                    }
                    z2 = true;
                }
                z2 = true;
                if (i17 != -1) {
                }
                z2 = true;
            }
            int i18 = 0;
            while (i18 < length) {
                try {
                    if (idm2.O000000o((int) fArr[i18], (int) fArr[i18 + 1])) {
                        idm3.O00000Oo(i18 / 2, i5);
                    }
                    i18 += 2;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            i5++;
            i4 = i2;
            idu2 = idu;
        }
        return idm3;
    }
}
