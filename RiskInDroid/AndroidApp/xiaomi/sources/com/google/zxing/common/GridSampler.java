package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

    public static void setGridSampler(GridSampler gridSampler2) {
        gridSampler = gridSampler2;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0075  */
    protected static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) throws NotFoundException {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        boolean z = true;
        for (int i = 0; i < fArr.length && z; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = i + 1;
            int i4 = (int) fArr[i3];
            if (i2 < -1 || i2 > width || i4 < -1 || i4 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
            } else if (i2 == width) {
                fArr[i] = (float) (width - 1);
            } else {
                z = false;
                if (i4 != -1) {
                    fArr[i3] = 0.0f;
                } else if (i4 == height) {
                    fArr[i3] = (float) (height - 1);
                }
                z = true;
            }
            z = true;
            if (i4 != -1) {
            }
            z = true;
        }
        boolean z2 = true;
        for (int length = fArr.length - 2; length >= 0 && z2; length -= 2) {
            int i5 = (int) fArr[length];
            int i6 = length + 1;
            int i7 = (int) fArr[i6];
            if (i5 < -1 || i5 > width || i7 < -1 || i7 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i5 == -1) {
                fArr[length] = 0.0f;
            } else if (i5 == width) {
                fArr[length] = (float) (width - 1);
            } else {
                z2 = false;
                if (i7 != -1) {
                    fArr[i6] = 0.0f;
                } else if (i7 == height) {
                    fArr[i6] = (float) (height - 1);
                }
                z2 = true;
            }
            z2 = true;
            if (i7 != -1) {
            }
            z2 = true;
        }
    }
}
