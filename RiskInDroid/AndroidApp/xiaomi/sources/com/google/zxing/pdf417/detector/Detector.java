package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Detector {
    private static final int[] INDEXES_START_PATTERN = {0, 4, 1, 5};
    private static final int[] INDEXES_STOP_PATTERN = {6, 2, 7, 3};
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private Detector() {
    }

    public static PDF417DetectorResult detect(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, boolean z) throws NotFoundException {
        BitMatrix blackMatrix = binaryBitmap.getBlackMatrix();
        List<ResultPoint[]> detect = detect(z, blackMatrix);
        if (detect.isEmpty()) {
            blackMatrix = blackMatrix.clone();
            blackMatrix.rotate180();
            detect = detect(z, blackMatrix);
        }
        return new PDF417DetectorResult(blackMatrix, detect);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r4.hasNext() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r5 = (com.google.zxing.ResultPoint[]) r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r5[1] == null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r3 = (int) java.lang.Math.max((float) r3, r5[1].getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (r5[3] == null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].getY());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r5 == false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r4 = r0.iterator();
     */
    private static List<ResultPoint[]> detect(boolean z, BitMatrix bitMatrix) {
        int i;
        float f;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        loop0:
        while (true) {
            int i3 = 0;
            boolean z2 = false;
            while (true) {
                if (i2 >= bitMatrix.getHeight()) {
                    break loop0;
                }
                ResultPoint[] findVertices = findVertices(bitMatrix, i2, i3);
                if (findVertices[0] != null || findVertices[3] != null) {
                    arrayList.add(findVertices);
                    if (!z) {
                        break loop0;
                    }
                    if (findVertices[2] != null) {
                        i = (int) findVertices[2].getX();
                        f = findVertices[2].getY();
                    } else {
                        i = (int) findVertices[4].getX();
                        f = findVertices[4].getY();
                    }
                    i2 = (int) f;
                    i3 = i;
                    z2 = true;
                } else {
                    break;
                }
            }
            i2 += 5;
        }
        return arrayList;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix, int i, int i2) {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, START_PATTERN), INDEXES_START_PATTERN);
        if (resultPointArr[4] != null) {
            i2 = (int) resultPointArr[4].getX();
            i = (int) resultPointArr[4].getY();
        }
        copyToResult(resultPointArr, findRowsWithPattern(bitMatrix, height, width, i, i2, STOP_PATTERN), INDEXES_STOP_PATTERN);
        return resultPointArr;
    }

    private static void copyToResult(ResultPoint[] resultPointArr, ResultPoint[] resultPointArr2, int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            resultPointArr[iArr[i]] = resultPointArr2[i];
        }
    }

    private static ResultPoint[] findRowsWithPattern(BitMatrix bitMatrix, int i, int i2, int i3, int i4, int[] iArr) {
        boolean z;
        int i5;
        int[] iArr2;
        int i6 = i;
        ResultPoint[] resultPointArr = new ResultPoint[4];
        int[] iArr3 = new int[iArr.length];
        int i7 = i3;
        while (true) {
            if (i7 >= i6) {
                z = false;
                break;
            }
            int[] findGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, false, iArr, iArr3);
            if (findGuardPattern != null) {
                while (true) {
                    iArr2 = findGuardPattern;
                    if (i7 <= 0) {
                        break;
                    }
                    i7--;
                    findGuardPattern = findGuardPattern(bitMatrix, i4, i7, i2, false, iArr, iArr3);
                    if (findGuardPattern == null) {
                        i7++;
                        break;
                    }
                }
                float f = (float) i7;
                resultPointArr[0] = new ResultPoint((float) iArr2[0], f);
                resultPointArr[1] = new ResultPoint((float) iArr2[1], f);
                z = true;
            } else {
                i7 += 5;
            }
        }
        int i8 = i7 + 1;
        if (z) {
            int[] iArr4 = {(int) resultPointArr[0].getX(), (int) resultPointArr[1].getX()};
            int i9 = i8;
            int i10 = 0;
            while (true) {
                if (i9 >= i6) {
                    i5 = i10;
                    break;
                }
                i5 = i10;
                int[] findGuardPattern2 = findGuardPattern(bitMatrix, iArr4[0], i9, i2, false, iArr, iArr3);
                if (findGuardPattern2 == null || Math.abs(iArr4[0] - findGuardPattern2[0]) >= 5 || Math.abs(iArr4[1] - findGuardPattern2[1]) >= 5) {
                    if (i5 > 25) {
                        break;
                    }
                    i10 = i5 + 1;
                } else {
                    iArr4 = findGuardPattern2;
                    i10 = 0;
                }
                i9++;
            }
            i8 = i9 - (i5 + 1);
            float f2 = (float) i8;
            resultPointArr[2] = new ResultPoint((float) iArr4[0], f2);
            resultPointArr[3] = new ResultPoint((float) iArr4[1], f2);
        }
        if (i8 - i7 < 10) {
            Arrays.fill(resultPointArr, (Object) null);
        }
        return resultPointArr;
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i, int i2, int i3, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i4 = 0;
        while (bitMatrix.get(i, i2) && i > 0) {
            int i5 = i4 + 1;
            if (i4 >= 3) {
                break;
            }
            i--;
            i4 = i5;
        }
        int length = iArr.length;
        int i6 = i;
        boolean z2 = z;
        int i7 = 0;
        while (true) {
            boolean z3 = true;
            if (i < i3) {
                if (bitMatrix.get(i, i2) != z2) {
                    iArr2[i7] = iArr2[i7] + 1;
                } else {
                    if (i7 != length - 1) {
                        i7++;
                    } else if (patternMatchVariance(iArr2, iArr, 0.8f) < 0.42f) {
                        return new int[]{i6, i};
                    } else {
                        i6 += iArr2[0] + iArr2[1];
                        int i8 = i7 - 1;
                        System.arraycopy(iArr2, 2, iArr2, 0, i8);
                        iArr2[i8] = 0;
                        iArr2[i7] = 0;
                        i7--;
                    }
                    iArr2[i7] = 1;
                    if (z2) {
                        z3 = false;
                    }
                    z2 = z3;
                }
                i++;
            } else if (i7 != length - 1 || patternMatchVariance(iArr2, iArr, 0.8f) >= 0.42f) {
                return null;
            } else {
                return new int[]{i6, i - 1};
            }
        }
    }

    private static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = (float) i;
        float f3 = f2 / ((float) i2);
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = ((float) iArr2[i4]) * f3;
            float f7 = (float) i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }
}
