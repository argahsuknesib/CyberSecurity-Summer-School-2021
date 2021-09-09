package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.WriterException;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class ihn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[][] f1300O000000o = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] O00000Oo = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] O00000o = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int[][] O00000o0 = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, NotificationCompat.FLAG_HIGH_PRIORITY, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    private static boolean O000000o(int i) {
        return i == -1;
    }

    private static void O000000o(int i, int i2, ihk ihk) throws WriterException {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (O000000o(ihk.O000000o(i4, i2))) {
                ihk.O000000o(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void O00000Oo(int i, int i2, ihk ihk) throws WriterException {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (O000000o(ihk.O000000o(i, i4))) {
                ihk.O000000o(i, i4, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void O00000o0(int i, int i2, ihk ihk) {
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                ihk.O000000o(i + i4, i2 + i3, f1300O000000o[i3][i4]);
            }
        }
    }

    static void O000000o(idl idl, ErrorCorrectionLevel errorCorrectionLevel, ihd ihd, int i, ihk ihk) throws WriterException {
        int i2;
        ihd ihd2 = ihd;
        int i3 = i;
        ihk ihk2 = ihk;
        int i4 = 0;
        while (true) {
            i2 = -1;
            if (i4 >= ihk2.O00000o0) {
                break;
            }
            for (int i5 = 0; i5 < ihk2.O00000Oo; i5++) {
                ihk2.f1297O000000o[i4][i5] = -1;
            }
            i4++;
        }
        int length = f1300O000000o[0].length;
        O00000o0(0, 0, ihk2);
        O00000o0(ihk2.O00000Oo - length, 0, ihk2);
        O00000o0(0, ihk2.O00000Oo - length, ihk2);
        O000000o(0, 7, ihk2);
        O000000o(ihk2.O00000Oo - 8, 7, ihk2);
        O000000o(0, ihk2.O00000Oo - 8, ihk2);
        O00000Oo(7, 0, ihk2);
        O00000Oo((ihk2.O00000o0 - 7) - 1, 0, ihk2);
        O00000Oo(7, ihk2.O00000o0 - 7, ihk2);
        if (ihk2.O000000o(8, ihk2.O00000o0 - 8) != 0) {
            ihk2.O000000o(8, ihk2.O00000o0 - 8, 1);
            if (ihd2.f1290O000000o >= 2) {
                int i6 = ihd2.f1290O000000o - 1;
                int[][] iArr = O00000o0;
                int[] iArr2 = iArr[i6];
                int length2 = iArr[i6].length;
                int i7 = 0;
                while (i7 < length2) {
                    int i8 = 0;
                    while (i8 < length2) {
                        int i9 = iArr2[i7];
                        int i10 = iArr2[i8];
                        if (!(i10 == i2 || i9 == i2 || !O000000o(ihk2.O000000o(i10, i9)))) {
                            int i11 = i10 - 2;
                            int i12 = i9 - 2;
                            for (int i13 = 0; i13 < 5; i13++) {
                                for (int i14 = 0; i14 < 5; i14++) {
                                    ihk2.O000000o(i11 + i14, i12 + i13, O00000Oo[i13][i14]);
                                }
                            }
                        }
                        i8++;
                        i2 = -1;
                    }
                    i7++;
                    i2 = -1;
                }
            }
            int i15 = 8;
            while (i15 < ihk2.O00000Oo - 8) {
                int i16 = i15 + 1;
                int i17 = i16 % 2;
                if (O000000o(ihk2.O000000o(i15, 6))) {
                    ihk2.O000000o(i15, 6, i17);
                }
                if (O000000o(ihk2.O000000o(6, i15))) {
                    ihk2.O000000o(6, i15, i17);
                }
                i15 = i16;
            }
            idl idl2 = new idl();
            if (i3 >= 0 && i3 < 8) {
                int bits = (errorCorrectionLevel.getBits() << 3) | i3;
                idl2.O00000Oo(bits, 5);
                idl2.O00000Oo(O000000o(bits, 1335), 10);
                idl idl3 = new idl();
                idl3.O00000Oo(21522, 15);
                if (idl2.O00000Oo == idl3.O00000Oo) {
                    for (int i18 = 0; i18 < idl2.f1213O000000o.length; i18++) {
                        int[] iArr3 = idl2.f1213O000000o;
                        iArr3[i18] = iArr3[i18] ^ idl3.f1213O000000o[i18];
                    }
                    if (idl2.O00000Oo == 15) {
                        for (int i19 = 0; i19 < idl2.O00000Oo; i19++) {
                            boolean O000000o2 = idl2.O000000o((idl2.O00000Oo - 1) - i19);
                            int[][] iArr4 = O00000o;
                            ihk2.O000000o(iArr4[i19][0], iArr4[i19][1], O000000o2);
                            if (i19 < 8) {
                                ihk2.O000000o((ihk2.O00000Oo - i19) - 1, 8, O000000o2);
                            } else {
                                ihk2.O000000o(8, (ihk2.O00000o0 - 7) + (i19 - 8), O000000o2);
                            }
                        }
                        O000000o(ihd2, ihk2);
                        O000000o(idl, i3, ihk2);
                        return;
                    }
                    throw new WriterException("should not happen but we got: " + idl2.O00000Oo);
                }
                throw new IllegalArgumentException("Sizes don't match");
            }
            throw new WriterException("Invalid mask pattern");
        }
        throw new WriterException();
    }

    private static void O000000o(ihd ihd, ihk ihk) throws WriterException {
        if (ihd.f1290O000000o >= 7) {
            idl idl = new idl();
            idl.O00000Oo(ihd.f1290O000000o, 6);
            idl.O00000Oo(O000000o(ihd.f1290O000000o, 7973), 12);
            if (idl.O00000Oo == 18) {
                int i = 0;
                int i2 = 17;
                while (i < 6) {
                    int i3 = i2;
                    for (int i4 = 0; i4 < 3; i4++) {
                        boolean O000000o2 = idl.O000000o(i3);
                        i3--;
                        ihk.O000000o(i, (ihk.O00000o0 - 11) + i4, O000000o2);
                        ihk.O000000o((ihk.O00000o0 - 11) + i4, i, O000000o2);
                    }
                    i++;
                    i2 = i3;
                }
                return;
            }
            throw new WriterException("should not happen but we got: " + idl.O00000Oo);
        }
    }

    private static void O000000o(idl idl, int i, ihk ihk) throws WriterException {
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = ihk.O00000Oo - 1;
        int i7 = ihk.O00000o0 - 1;
        int i8 = 0;
        int i9 = -1;
        while (i6 > 0) {
            if (i6 == 6) {
                i6--;
            }
            while (i7 >= 0 && i7 < ihk.O00000o0) {
                int i10 = i8;
                for (int i11 = 0; i11 < 2; i11++) {
                    int i12 = i6 - i11;
                    if (O000000o(ihk.O000000o(i12, i7))) {
                        if (i10 < idl.O00000Oo) {
                            z = idl.O000000o(i10);
                            i10++;
                        } else {
                            z = false;
                        }
                        if (i != -1) {
                            switch (i) {
                                case 0:
                                    i3 = i7 + i12;
                                    i2 = i3 & 1;
                                    break;
                                case 1:
                                    i2 = i7 & 1;
                                    break;
                                case 2:
                                    i2 = i12 % 3;
                                    break;
                                case 3:
                                    i2 = (i7 + i12) % 3;
                                    break;
                                case 4:
                                    i5 = i7 / 2;
                                    i4 = i12 / 3;
                                    i3 = i5 + i4;
                                    i2 = i3 & 1;
                                    break;
                                case 5:
                                    int i13 = i7 * i12;
                                    i2 = (i13 % 3) + (i13 & 1);
                                    break;
                                case 6:
                                    int i14 = i7 * i12;
                                    i2 = ((i14 & 1) + (i14 % 3)) & 1;
                                    break;
                                case 7:
                                    i5 = (i7 * i12) % 3;
                                    i4 = (i7 + i12) & 1;
                                    i3 = i5 + i4;
                                    i2 = i3 & 1;
                                    break;
                                default:
                                    throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
                            }
                            if (i2 == 0) {
                                z = !z;
                            }
                        }
                        ihk.O000000o(i12, i7, z);
                    }
                }
                i7 += i9;
                i8 = i10;
            }
            i9 = -i9;
            i7 += i9;
            i6 -= 2;
        }
        if (i8 != idl.O00000Oo) {
            throw new WriterException("Not all bits consumed: " + i8 + '/' + idl.O00000Oo);
        }
    }

    private static int O000000o(int i, int i2) {
        if (i2 != 0) {
            int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i2);
            int i3 = i << (numberOfLeadingZeros - 1);
            while (32 - Integer.numberOfLeadingZeros(i3) >= numberOfLeadingZeros) {
                i3 ^= i2 << ((32 - Integer.numberOfLeadingZeros(i3)) - numberOfLeadingZeros);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }
}
