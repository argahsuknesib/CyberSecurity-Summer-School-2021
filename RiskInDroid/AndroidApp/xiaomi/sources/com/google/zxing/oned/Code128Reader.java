package com.google.zxing.oned;

import android.support.v4.app.NotificationCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

public final class Code128Reader extends OneDReader {
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int i = nextSet;
        boolean z = false;
        int i2 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                if (i2 == 5) {
                    float f = 0.25f;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float patternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], 0.7f);
                        if (patternMatchVariance < f) {
                            i3 = i4;
                            f = patternMatchVariance;
                        }
                    }
                    if (i3 < 0 || !bitArray.isRange(Math.max(0, i - ((nextSet - i) / 2)), i, false)) {
                        i += iArr[0] + iArr[1];
                        int i5 = i2 - 1;
                        System.arraycopy(iArr, 2, iArr, 0, i5);
                        iArr[i5] = 0;
                        iArr[i2] = 0;
                        i2--;
                    } else {
                        return new int[]{i, nextSet, i3};
                    }
                } else {
                    i2++;
                }
                iArr[i2] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float patternMatchVariance = patternMatchVariance(iArr, iArr2[i3], 0.7f);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e1, code lost:
        if (r5 != false) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0133, code lost:
        if (r5 != false) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0135, code lost:
        r5 = false;
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x013f A[PHI: r19 10  PHI: (r19v13 boolean) = (r19v18 boolean), (r19v20 boolean) binds: [B:64:0x010e, B:42:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0149 A[PHI: r6 r19 10  PHI: (r6v12 boolean) = (r6v13 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean), (r6v2 boolean) binds: [B:81:0x0148, B:64:0x010e, B:65:0x0112, B:69:0x011e, B:68:0x011a, B:42:0x00c1, B:43:0x00c6, B:47:0x00d3, B:46:0x00ce] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r19v10 boolean) = (r19v11 boolean), (r19v18 boolean), (r19v18 boolean), (r19v18 boolean), (r19v18 boolean), (r19v20 boolean), (r19v20 boolean), (r19v20 boolean), (r19v20 boolean) binds: [B:81:0x0148, B:64:0x010e, B:65:0x0112, B:69:0x011e, B:68:0x011a, B:42:0x00c1, B:43:0x00c6, B:47:0x00d3, B:46:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    public final Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        BitArray bitArray2 = bitArray;
        Map<DecodeHintType, ?> map2 = map;
        boolean z6 = map2 != null && map2.containsKey(DecodeHintType.ASSUME_GS1);
        int[] findStartPattern = findStartPattern(bitArray);
        int i2 = findStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i2));
        switch (i2) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int i3 = 6;
        int[] iArr = new int[6];
        int i4 = i2;
        char c2 = c;
        boolean z7 = false;
        boolean z8 = false;
        int i5 = 0;
        boolean z9 = false;
        int i6 = 0;
        int i7 = 0;
        boolean z10 = true;
        int i8 = findStartPattern[0];
        int i9 = findStartPattern[1];
        boolean z11 = false;
        while (!z8) {
            int decodeCode = decodeCode(bitArray2, iArr, i9);
            arrayList.add(Byte.valueOf((byte) decodeCode));
            if (decodeCode != 106) {
                z10 = true;
            }
            if (decodeCode != 106) {
                i7++;
                i4 += i7 * decodeCode;
            }
            int i10 = i9;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += iArr[i11];
            }
            switch (decodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c2) {
                        case 'c':
                            if (decodeCode >= 100) {
                                if (decodeCode != 106) {
                                    z10 = false;
                                }
                                if (decodeCode == 106) {
                                    z = z7;
                                    z2 = false;
                                    z8 = true;
                                    break;
                                } else {
                                    switch (decodeCode) {
                                        case 100:
                                            z3 = z7;
                                            c2 = 'd';
                                            break;
                                        case 101:
                                            z3 = z7;
                                            c2 = 'e';
                                            break;
                                        case 102:
                                            if (z6) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append(29);
                                                }
                                            }
                                        default:
                                            z3 = z7;
                                            break;
                                    }
                                    z2 = false;
                                    break;
                                }
                            } else {
                                if (decodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(decodeCode);
                            }
                            z3 = z7;
                            z2 = false;
                        case 'd':
                            if (decodeCode < 96) {
                                if (z7 == z9) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + NotificationCompat.FLAG_HIGH_PRIORITY));
                                }
                                z2 = false;
                                z = false;
                                break;
                            } else {
                                if (decodeCode != 106) {
                                    z10 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 96:
                                        case 97:
                                        default:
                                            z5 = z7;
                                            z4 = false;
                                            break;
                                        case 98:
                                            z = z7;
                                            c2 = 'e';
                                            z4 = true;
                                            break;
                                        case 99:
                                            z5 = z7;
                                            c2 = 'c';
                                            z4 = false;
                                            break;
                                        case 100:
                                            if (z9 || !z7) {
                                                if (z9) {
                                                }
                                                z2 = false;
                                                z = true;
                                                break;
                                            }
                                            z2 = false;
                                            z9 = true;
                                            z = false;
                                            break;
                                        case 101:
                                            z5 = z7;
                                            c2 = 'e';
                                            z4 = false;
                                            break;
                                        case 102:
                                            if (z6) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append(29);
                                                }
                                            }
                                            z5 = z7;
                                            z4 = false;
                                            break;
                                    }
                                }
                                z8 = true;
                                z5 = z7;
                                z4 = false;
                            }
                            break;
                        case 'e':
                            if (decodeCode < 64) {
                                if (z7 == z9) {
                                    sb.append((char) (decodeCode + 32));
                                } else {
                                    sb.append((char) (decodeCode + 32 + NotificationCompat.FLAG_HIGH_PRIORITY));
                                }
                            } else if (decodeCode >= 96) {
                                if (decodeCode != 106) {
                                    z10 = false;
                                }
                                if (decodeCode != 106) {
                                    switch (decodeCode) {
                                        case 98:
                                            z = z7;
                                            c2 = 'd';
                                            z4 = true;
                                            break;
                                        case 100:
                                            z5 = z7;
                                            c2 = 'd';
                                            z4 = false;
                                            break;
                                        case 101:
                                            if (z9 || !z7) {
                                                if (z9) {
                                                }
                                                z2 = false;
                                                z = true;
                                                break;
                                            }
                                            z2 = false;
                                            z9 = true;
                                            z = false;
                                            break;
                                        case 102:
                                            if (z6) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append(29);
                                                }
                                            }
                                            z5 = z7;
                                            z4 = false;
                                            break;
                                    }
                                }
                                z8 = true;
                                z5 = z7;
                                z4 = false;
                            } else if (z7 == z9) {
                                sb.append((char) (decodeCode - 64));
                            } else {
                                sb.append((char) (decodeCode + 64));
                            }
                            z2 = false;
                            z = false;
                            break;
                        default:
                            z3 = z7;
                            z2 = false;
                            break;
                    }
                    if (z11) {
                        c2 = c2 == 'e' ? 'd' : 'e';
                    }
                    z11 = z2;
                    z7 = z;
                    i3 = 6;
                    i8 = i9;
                    i9 = i10;
                    int i12 = i6;
                    i6 = decodeCode;
                    i5 = i12;
                    break;
            }
            while (!z8) {
            }
        }
        int i13 = i9 - i8;
        int nextUnset = bitArray2.getNextUnset(i9);
        if (!bitArray2.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i8) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        } else if ((i4 - (i7 * i5)) % 103 == i5) {
            int length = sb.length();
            if (length != 0) {
                if (length > 0 && z10) {
                    if (c2 == 'c') {
                        sb.delete(length - 2, length);
                    } else {
                        sb.delete(length - 1, length);
                    }
                }
                float f = ((float) (findStartPattern[1] + findStartPattern[0])) / 2.0f;
                float f2 = ((float) i8) + (((float) i13) / 2.0f);
                int size = arrayList.size();
                byte[] bArr = new byte[size];
                for (int i14 = 0; i14 < size; i14++) {
                    bArr[i14] = ((Byte) arrayList.get(i14)).byteValue();
                }
                float f3 = (float) i;
                return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f, f3), new ResultPoint(f2, f3)}, BarcodeFormat.CODE_128);
            }
            throw NotFoundException.getNotFoundInstance();
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
