package com.xiaomi.youpin.common.util.blur;

import java.util.concurrent.Callable;

final class JavaBlurProcess {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final short[] f12057O000000o = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    private static final byte[] O00000Oo = {9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    public static void O000000o(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i6;
        int i11 = i7 - 1;
        int i12 = i8 - 1;
        int i13 = (i9 * 2) + 1;
        short s = f12057O000000o[i9];
        byte b = O00000Oo[i9];
        int[] iArr2 = new int[i13];
        if (i10 == 1) {
            int i14 = (i5 * i8) / i4;
            int i15 = ((i5 + 1) * i8) / i4;
            while (i14 < i15) {
                int i16 = i7 * i14;
                int i17 = 0;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                while (i17 <= i9) {
                    iArr2[i17] = iArr[i16];
                    i17++;
                    j += (long) (((iArr[i16] >>> 16) & 255) * i17);
                    j2 += (long) (((iArr[i16] >>> 8) & 255) * i17);
                    j3 += (long) ((iArr[i16] & 255) * i17);
                    j4 += (long) ((iArr[i16] >>> 16) & 255);
                    j5 += (long) ((iArr[i16] >>> 8) & 255);
                    j6 += (long) (iArr[i16] & 255);
                }
                int i18 = i16;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                for (int i19 = 1; i19 <= i9; i19++) {
                    if (i19 <= i11) {
                        i18++;
                    }
                    iArr2[i19 + i9] = iArr[i18];
                    int i20 = (i9 + 1) - i19;
                    j += (long) (((iArr[i18] >>> 16) & 255) * i20);
                    j2 += (long) (((iArr[i18] >>> 8) & 255) * i20);
                    j3 += (long) ((iArr[i18] & 255) * i20);
                    j7 += (long) ((iArr[i18] >>> 16) & 255);
                    j8 += (long) ((iArr[i18] >>> 8) & 255);
                    j9 += (long) (iArr[i18] & 255);
                }
                int i21 = i9 > i11 ? i11 : i9;
                int i22 = i21;
                int i23 = i21 + i16;
                int i24 = i16;
                int i25 = i9;
                int i26 = 0;
                while (i26 < i7) {
                    int i27 = i15;
                    int i28 = i26;
                    long j10 = j7;
                    long j11 = (long) s;
                    iArr[i24] = (int) (((long) (iArr[i24] & -16777216)) | ((((j * j11) >>> b) & 255) << 16) | ((((j2 * j11) >>> b) & 255) << 8) | (((j11 * j3) >>> b) & 255));
                    i24++;
                    long j12 = j - j4;
                    long j13 = j2 - j5;
                    long j14 = j3 - j6;
                    int i29 = (i25 + i13) - i9;
                    if (i29 >= i13) {
                        i29 -= i13;
                    }
                    long j15 = j4 - ((long) ((iArr2[i29] >>> 16) & 255));
                    long j16 = j5 - ((long) ((iArr2[i29] >>> 8) & 255));
                    long j17 = j6 - ((long) (iArr2[i29] & 255));
                    if (i22 < i11) {
                        i23++;
                        i22++;
                    }
                    iArr2[i29] = iArr[i23];
                    long j18 = j10 + ((long) ((iArr[i23] >>> 16) & 255));
                    long j19 = j8 + ((long) ((iArr[i23] >>> 8) & 255));
                    long j20 = j9 + ((long) (iArr[i23] & 255));
                    j = j12 + j18;
                    j2 = j13 + j19;
                    j3 = j14 + j20;
                    i25++;
                    if (i25 >= i13) {
                        i25 = 0;
                    }
                    j4 = j15 + ((long) ((iArr2[i25] >>> 16) & 255));
                    j5 = j16 + ((long) ((iArr2[i25] >>> 8) & 255));
                    j6 = j17 + ((long) (iArr2[i25] & 255));
                    j7 = j18 - ((long) ((iArr2[i25] >>> 16) & 255));
                    j8 = j19 - ((long) ((iArr2[i25] >>> 8) & 255));
                    j9 = j20 - ((long) (iArr2[i25] & 255));
                    i26 = i28 + 1;
                    i7 = i;
                    i15 = i27;
                }
                i14++;
                i7 = i;
            }
        } else if (i10 == 2) {
            int i30 = (i5 * i) / i4;
            int i31 = ((i5 + 1) * i) / i4;
            while (i30 < i31) {
                int i32 = 0;
                long j21 = 0;
                long j22 = 0;
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                long j26 = 0;
                while (i32 <= i9) {
                    iArr2[i32] = iArr[i30];
                    i32++;
                    j21 += (long) (((iArr[i30] >>> 16) & 255) * i32);
                    j22 += (long) (((iArr[i30] >>> 8) & 255) * i32);
                    j23 += (long) ((iArr[i30] & 255) * i32);
                    j24 += (long) ((iArr[i30] >>> 16) & 255);
                    j25 += (long) ((iArr[i30] >>> 8) & 255);
                    j26 += (long) (iArr[i30] & 255);
                    i31 = i31;
                }
                int i33 = i31;
                int i34 = i30;
                int i35 = 1;
                long j27 = 0;
                long j28 = 0;
                long j29 = 0;
                while (i35 <= i9) {
                    if (i35 <= i12) {
                        i34 += i;
                    }
                    iArr2[i35 + i9] = iArr[i34];
                    int i36 = (i9 + 1) - i35;
                    j21 += (long) (((iArr[i34] >>> 16) & 255) * i36);
                    j22 += (long) (((iArr[i34] >>> 8) & 255) * i36);
                    j23 += (long) ((iArr[i34] & 255) * i36);
                    j27 += (long) ((iArr[i34] >>> 16) & 255);
                    j28 += (long) ((iArr[i34] >>> 8) & 255);
                    j29 += (long) (iArr[i34] & 255);
                    i35++;
                    i13 = i13;
                }
                int i37 = i13;
                int i38 = i9 > i12 ? i12 : i9;
                int i39 = i9;
                int i40 = i38;
                int i41 = (i38 * i) + i30;
                int i42 = 0;
                int i43 = i30;
                while (i42 < i8) {
                    int i44 = i30;
                    int i45 = i42;
                    long j30 = (long) s;
                    iArr[i43] = (int) (((long) (iArr[i43] & -16777216)) | ((((j21 * j30) >>> b) & 255) << 16) | ((((j22 * j30) >>> b) & 255) << 8) | (((j30 * j23) >>> b) & 255));
                    i43 += i;
                    long j31 = j21 - j24;
                    long j32 = j22 - j25;
                    long j33 = j23 - j26;
                    int i46 = (i39 + i37) - i3;
                    int i47 = i37;
                    if (i46 >= i47) {
                        i46 -= i47;
                    }
                    long j34 = j24 - ((long) ((iArr2[i46] >>> 16) & 255));
                    long j35 = j25 - ((long) ((iArr2[i46] >>> 8) & 255));
                    long j36 = j26 - ((long) (iArr2[i46] & 255));
                    if (i40 < i12) {
                        i41 += i;
                        i40++;
                    }
                    iArr2[i46] = iArr[i41];
                    long j37 = j27 + ((long) ((iArr[i41] >>> 16) & 255));
                    long j38 = j28 + ((long) ((iArr[i41] >>> 8) & 255));
                    long j39 = j29 + ((long) (iArr[i41] & 255));
                    j21 = j31 + j37;
                    j22 = j32 + j38;
                    j23 = j33 + j39;
                    i39++;
                    if (i39 >= i47) {
                        i39 = 0;
                    }
                    j24 = j34 + ((long) ((iArr2[i39] >>> 16) & 255));
                    j25 = j35 + ((long) ((iArr2[i39] >>> 8) & 255));
                    j26 = j36 + ((long) (iArr2[i39] & 255));
                    j27 = j37 - ((long) ((iArr2[i39] >>> 16) & 255));
                    j28 = j38 - ((long) ((iArr2[i39] >>> 8) & 255));
                    j29 = j39 - ((long) (iArr2[i39] & 255));
                    i42 = i45 + 1;
                    i37 = i47;
                    i30 = i44;
                    i8 = i2;
                }
                i30++;
                i9 = i3;
                i31 = i33;
                i13 = i37;
                i8 = i2;
            }
        }
    }

    static class BlurTask implements Callable<Void> {
        private final int _coreIndex;
        private final int _h;
        private final int _radius;
        private final int _round;
        private final int[] _src;
        private final int _totalCores;
        private final int _w;

        public BlurTask(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
            this._src = iArr;
            this._w = i;
            this._h = i2;
            this._radius = i3;
            this._totalCores = i4;
            this._coreIndex = i5;
            this._round = i6;
        }

        public Void call() throws Exception {
            JavaBlurProcess.O000000o(this._src, this._w, this._h, this._radius, this._totalCores, this._coreIndex, this._round);
            return null;
        }
    }
}
