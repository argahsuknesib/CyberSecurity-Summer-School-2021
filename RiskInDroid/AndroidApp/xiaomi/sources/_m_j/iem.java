package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Map;

public final class iem extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[][] f1239O000000o = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int O000000o(idl idl, int[] iArr, int i) throws NotFoundException {
        O000000o(idl, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = f1239O000000o;
            if (i3 >= iArr2.length) {
                break;
            }
            float O000000o2 = O000000o(iArr, iArr2[i3], 0.7f);
            if (O000000o2 < f) {
                i2 = i3;
                f = O000000o2;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0136, code lost:
        if (r11 != false) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0187, code lost:
        if (r11 != false) goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0189, code lost:
        r9 = false;
        r10 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0193 A[PHI: r19 10  PHI: (r19v12 boolean) = (r19v17 boolean), (r19v19 boolean) binds: [B:81:0x0163, B:59:0x0116] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x019f A[PHI: r5 r19 10  PHI: (r5v16 boolean) = (r5v5 boolean), (r5v17 boolean), (r5v5 boolean), (r5v5 boolean), (r5v5 boolean), (r5v5 boolean), (r5v5 boolean), (r5v5 boolean), (r5v5 boolean), (r5v5 boolean) binds: [B:43:0x00db, B:98:0x019e, B:81:0x0163, B:82:0x0167, B:86:0x0173, B:85:0x016f, B:59:0x0116, B:60:0x011b, B:64:0x0128, B:63:0x0123] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r19v9 boolean) = (r19v2 boolean), (r19v10 boolean), (r19v17 boolean), (r19v17 boolean), (r19v17 boolean), (r19v17 boolean), (r19v19 boolean), (r19v19 boolean), (r19v19 boolean), (r19v19 boolean) binds: [B:43:0x00db, B:98:0x019e, B:81:0x0163, B:82:0x0167, B:86:0x0173, B:85:0x016f, B:59:0x0116, B:60:0x011b, B:64:0x0128, B:63:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        char c;
        boolean z;
        idl idl2 = idl;
        Map<DecodeHintType, ?> map2 = map;
        int i2 = 1;
        int i3 = 0;
        boolean z2 = map2 != null && map2.containsKey(DecodeHintType.ASSUME_GS1);
        int i4 = idl2.O00000Oo;
        int O00000o0 = idl2.O00000o0(0);
        int i5 = 6;
        int[] iArr = new int[6];
        int i6 = O00000o0;
        boolean z3 = false;
        int i7 = 0;
        while (O00000o0 < i4) {
            if (idl2.O000000o(O00000o0) ^ z3) {
                iArr[i7] = iArr[i7] + i2;
            } else {
                if (i7 == 5) {
                    int i8 = -1;
                    float f = 0.25f;
                    for (int i9 = 103; i9 <= 105; i9++) {
                        float O000000o2 = O000000o(iArr, f1239O000000o[i9], 0.7f);
                        if (O000000o2 < f) {
                            f = O000000o2;
                            i8 = i9;
                        }
                    }
                    if (i8 < 0 || !idl2.O000000o(Math.max(i3, i6 - ((O00000o0 - i6) / 2)), i6)) {
                        i6 += iArr[0] + iArr[1];
                        System.arraycopy(iArr, 2, iArr, 0, 4);
                        iArr[4] = 0;
                        iArr[5] = 0;
                        i7--;
                    } else {
                        int[] iArr2 = new int[3];
                        iArr2[i3] = i6;
                        iArr2[i2] = O00000o0;
                        iArr2[2] = i8;
                        int i10 = iArr2[2];
                        ArrayList arrayList = new ArrayList(20);
                        arrayList.add(Byte.valueOf((byte) i10));
                        switch (i10) {
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
                        int i11 = iArr2[i3];
                        int[] iArr3 = new int[i5];
                        int i12 = i10;
                        char c2 = c;
                        int i13 = i11;
                        int i14 = iArr2[i2];
                        int i15 = 0;
                        boolean z4 = false;
                        boolean z5 = false;
                        boolean z6 = false;
                        boolean z7 = false;
                        int i16 = 0;
                        int i17 = 0;
                        boolean z8 = true;
                        while (!z4) {
                            int O000000o3 = O000000o(idl2, iArr3, i14);
                            arrayList.add(Byte.valueOf((byte) O000000o3));
                            if (O000000o3 != 106) {
                                z8 = true;
                            }
                            if (O000000o3 != 106) {
                                i17++;
                                i12 += i17 * O000000o3;
                            }
                            int i18 = i14;
                            for (int i19 = 0; i19 < i5; i19++) {
                                i18 += iArr3[i19];
                            }
                            switch (O000000o3) {
                                case 103:
                                case 104:
                                case 105:
                                    throw FormatException.getFormatInstance();
                                default:
                                    switch (c2) {
                                        case 'c':
                                            if (O000000o3 < 100) {
                                                if (O000000o3 < 10) {
                                                    sb.append('0');
                                                }
                                                sb.append(O000000o3);
                                            } else {
                                                if (O000000o3 != 106) {
                                                    z8 = false;
                                                }
                                                if (O000000o3 != 106) {
                                                    switch (O000000o3) {
                                                        case 100:
                                                            c2 = 'd';
                                                            break;
                                                        case 101:
                                                            c2 = 'e';
                                                            break;
                                                        case 102:
                                                            if (z2) {
                                                                if (sb.length() != 0) {
                                                                    sb.append(29);
                                                                    break;
                                                                } else {
                                                                    sb.append("]C1");
                                                                    break;
                                                                }
                                                            }
                                                            break;
                                                    }
                                                } else {
                                                    z4 = true;
                                                }
                                            }
                                            z = false;
                                            if (z7) {
                                                c2 = c2 == 'e' ? 'd' : 'e';
                                            }
                                            z7 = z;
                                            i13 = i14;
                                            i14 = i18;
                                            i5 = 6;
                                            int i20 = i16;
                                            i16 = O000000o3;
                                            i15 = i20;
                                        case 'd':
                                            if (O000000o3 < 96) {
                                                if (z6 == z5) {
                                                    sb.append((char) (O000000o3 + 32));
                                                } else {
                                                    sb.append((char) (O000000o3 + 32 + NotificationCompat.FLAG_HIGH_PRIORITY));
                                                }
                                                z = false;
                                                z6 = false;
                                                if (z7) {
                                                }
                                                z7 = z;
                                                i13 = i14;
                                                i14 = i18;
                                                i5 = 6;
                                                int i202 = i16;
                                                i16 = O000000o3;
                                                i15 = i202;
                                            } else {
                                                if (O000000o3 != 106) {
                                                    z8 = false;
                                                }
                                                if (O000000o3 != 106) {
                                                    switch (O000000o3) {
                                                        case 96:
                                                        case 97:
                                                        default:
                                                            z = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i2022 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i2022;
                                                            break;
                                                        case 98:
                                                            c2 = 'e';
                                                            z = true;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i20222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i20222;
                                                            break;
                                                        case 99:
                                                            c2 = 'c';
                                                            z = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i202222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i202222;
                                                            break;
                                                        case 100:
                                                            if (z5 || !z6) {
                                                                if (z5) {
                                                                }
                                                                z = false;
                                                                z6 = true;
                                                                if (z7) {
                                                                }
                                                                z7 = z;
                                                                i13 = i14;
                                                                i14 = i18;
                                                                i5 = 6;
                                                                int i2022222 = i16;
                                                                i16 = O000000o3;
                                                                i15 = i2022222;
                                                            }
                                                            z = false;
                                                            z5 = true;
                                                            z6 = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i20222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i20222222;
                                                            break;
                                                        case 101:
                                                            c2 = 'e';
                                                            z = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i202222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i202222222;
                                                            break;
                                                        case 102:
                                                            if (z2) {
                                                                if (sb.length() == 0) {
                                                                    sb.append("]C1");
                                                                } else {
                                                                    sb.append(29);
                                                                }
                                                            }
                                                            z = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i2022222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i2022222222;
                                                            break;
                                                    }
                                                }
                                                z4 = true;
                                                z = false;
                                                if (z7) {
                                                }
                                                z7 = z;
                                                i13 = i14;
                                                i14 = i18;
                                                i5 = 6;
                                                int i20222222222 = i16;
                                                i16 = O000000o3;
                                                i15 = i20222222222;
                                            }
                                            break;
                                        case 'e':
                                            if (O000000o3 < 64) {
                                                if (z6 == z5) {
                                                    sb.append((char) (O000000o3 + 32));
                                                } else {
                                                    sb.append((char) (O000000o3 + 32 + NotificationCompat.FLAG_HIGH_PRIORITY));
                                                }
                                            } else if (O000000o3 >= 96) {
                                                if (O000000o3 != 106) {
                                                    z8 = false;
                                                }
                                                if (O000000o3 != 106) {
                                                    switch (O000000o3) {
                                                        case 98:
                                                            c2 = 'd';
                                                            z = true;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i202222222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i202222222222;
                                                            break;
                                                        case 100:
                                                            c2 = 'd';
                                                            z = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i2022222222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i2022222222222;
                                                            break;
                                                        case 101:
                                                            if (z5 || !z6) {
                                                                if (z5) {
                                                                }
                                                                z = false;
                                                                z6 = true;
                                                                if (z7) {
                                                                }
                                                                z7 = z;
                                                                i13 = i14;
                                                                i14 = i18;
                                                                i5 = 6;
                                                                int i20222222222222 = i16;
                                                                i16 = O000000o3;
                                                                i15 = i20222222222222;
                                                            }
                                                            z = false;
                                                            z5 = true;
                                                            z6 = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i202222222222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i202222222222222;
                                                            break;
                                                        case 102:
                                                            if (z2) {
                                                                if (sb.length() == 0) {
                                                                    sb.append("]C1");
                                                                } else {
                                                                    sb.append(29);
                                                                }
                                                            }
                                                            z = false;
                                                            if (z7) {
                                                            }
                                                            z7 = z;
                                                            i13 = i14;
                                                            i14 = i18;
                                                            i5 = 6;
                                                            int i2022222222222222 = i16;
                                                            i16 = O000000o3;
                                                            i15 = i2022222222222222;
                                                            break;
                                                    }
                                                }
                                                z4 = true;
                                                z = false;
                                                if (z7) {
                                                }
                                                z7 = z;
                                                i13 = i14;
                                                i14 = i18;
                                                i5 = 6;
                                                int i20222222222222222 = i16;
                                                i16 = O000000o3;
                                                i15 = i20222222222222222;
                                            } else if (z6 == z5) {
                                                sb.append((char) (O000000o3 - 64));
                                            } else {
                                                sb.append((char) (O000000o3 + 64));
                                            }
                                            z = false;
                                            z6 = false;
                                            if (z7) {
                                            }
                                            z7 = z;
                                            i13 = i14;
                                            i14 = i18;
                                            i5 = 6;
                                            int i202222222222222222 = i16;
                                            i16 = O000000o3;
                                            i15 = i202222222222222222;
                                            break;
                                    }
                                    break;
                            }
                            while (!z4) {
                            }
                        }
                        int i21 = i14 - i13;
                        int O00000o = idl2.O00000o(i14);
                        if (!idl2.O000000o(O00000o, Math.min(idl2.O00000Oo, ((O00000o - i13) / 2) + O00000o))) {
                            throw NotFoundException.getNotFoundInstance();
                        } else if ((i12 - (i17 * i15)) % 103 == i15) {
                            int length = sb.length();
                            if (length != 0) {
                                if (length > 0 && z8) {
                                    if (c2 == 'c') {
                                        sb.delete(length - 2, length);
                                    } else {
                                        sb.delete(length - 1, length);
                                    }
                                }
                                float f2 = ((float) (iArr2[1] + iArr2[0])) / 2.0f;
                                float f3 = ((float) i13) + (((float) i21) / 2.0f);
                                int size = arrayList.size();
                                byte[] bArr = new byte[size];
                                for (int i22 = 0; i22 < size; i22++) {
                                    bArr[i22] = ((Byte) arrayList.get(i22)).byteValue();
                                }
                                float f4 = (float) i;
                                return new idf(sb.toString(), bArr, new idg[]{new idg(f2, f4), new idg(f3, f4)}, BarcodeFormat.CODE_128);
                            }
                            throw NotFoundException.getNotFoundInstance();
                        } else {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                } else {
                    i7++;
                }
                iArr[i7] = 1;
                z3 = !z3;
            }
            O00000o0++;
            i2 = 1;
            i3 = 0;
            i5 = 6;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
