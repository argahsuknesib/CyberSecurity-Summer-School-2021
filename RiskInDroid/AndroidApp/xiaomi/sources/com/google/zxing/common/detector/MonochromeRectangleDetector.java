package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector {
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public final ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int max = Math.max(1, height / 256);
        int i3 = -max;
        int i4 = i2 / 2;
        int i5 = i2;
        int i6 = width;
        int i7 = i;
        int i8 = i3;
        int i9 = height;
        int i10 = max;
        int max2 = Math.max(1, width / 256);
        int i11 = -max2;
        int y = ((int) findCornerFromCenter(i5, 0, 0, i6, i7, i3, 0, i9, i4).getY()) - 1;
        int i12 = max2;
        int i13 = i / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i5, i11, 0, i6, i7, 0, y, i9, i13);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i5, i12, x, i6, i7, 0, y, i9, i13);
        int x2 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i5, 0, x, x2, i7, i10, y, i9, i4);
        return new ResultPoint[]{findCornerFromCenter(i5, 0, x, x2, i7, i8, y, ((int) findCornerFromCenter3.getY()) + 1, i2 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int[] iArr;
        int i10 = i;
        int i11 = i5;
        int i12 = i10;
        int i13 = i11;
        int[] iArr2 = null;
        int i14 = i8;
        while (i13 < i14 && i13 >= i7 && i12 < i4 && i12 >= i3) {
            if (i2 == 0) {
                iArr = blackWhiteRange(i13, i9, i3, i4, true);
            } else {
                iArr = blackWhiteRange(i12, i9, i7, i8, false);
            }
            if (iArr != null) {
                i13 += i6;
                i12 += i2;
                iArr2 = iArr;
            } else if (iArr2 != null) {
                char c = 1;
                if (i2 == 0) {
                    int i15 = i13 - i6;
                    if (iArr2[0] >= i10) {
                        return new ResultPoint((float) iArr2[1], (float) i15);
                    }
                    if (iArr2[1] <= i10) {
                        return new ResultPoint((float) iArr2[0], (float) i15);
                    }
                    if (i6 > 0) {
                        c = 0;
                    }
                    return new ResultPoint((float) iArr2[c], (float) i15);
                }
                int i16 = i12 - i2;
                if (iArr2[0] >= i11) {
                    return new ResultPoint((float) i16, (float) iArr2[1]);
                }
                if (iArr2[1] <= i11) {
                    return new ResultPoint((float) i16, (float) iArr2[0]);
                }
                float f = (float) i16;
                if (i2 < 0) {
                    c = 0;
                }
                return new ResultPoint(f, (float) iArr2[c]);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0035 A[EDGE_INSN: B:52:0x0035->B:16:0x0035 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x006f A[EDGE_INSN: B:65:0x006f->B:36:0x006f ?: BREAK  , SYNTHETIC] */
    private int[] blackWhiteRange(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7 = (i3 + i4) / 2;
        int i8 = i7;
        while (i8 >= i3) {
            if (z) {
                i6 = i8;
                while (true) {
                    i6--;
                    if (i6 < i3) {
                        break;
                    } else if (z) {
                        if (this.image.get(i6, i)) {
                            break;
                        }
                    } else if (this.image.get(i, i6)) {
                        break;
                    }
                }
                int i9 = i8 - i6;
                if (i6 < i3 || i9 > i2) {
                    break;
                }
                i8 = i6;
            } else {
                i6 = i8;
                while (true) {
                    i6--;
                    if (i6 < i3) {
                    }
                }
                int i92 = i8 - i6;
                i8 = i6;
            }
            i8--;
        }
        int i10 = i8 + 1;
        while (i7 < i4) {
            if (z) {
                i5 = i7;
                while (true) {
                    i5++;
                    if (i5 >= i4) {
                        break;
                    } else if (z) {
                        if (this.image.get(i5, i)) {
                            break;
                        }
                    } else if (this.image.get(i, i5)) {
                        break;
                    }
                }
                int i11 = i5 - i7;
                if (i5 >= i4 || i11 > i2) {
                    break;
                }
                i7 = i5;
            } else {
                i5 = i7;
                while (true) {
                    i5++;
                    if (i5 >= i4) {
                    }
                }
                int i112 = i5 - i7;
                i7 = i5;
            }
            i7++;
        }
        int i12 = i7 - 1;
        if (i12 <= i10) {
            return null;
        }
        return new int[]{i10, i12};
    }
}
