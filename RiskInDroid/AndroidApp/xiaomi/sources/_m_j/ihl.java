package _m_j;

import _m_j.ihd;
import com.xiaomi.zxing.EncodeHintType;
import com.xiaomi.zxing.WriterException;
import com.xiaomi.zxing.common.CharacterSetECI;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.xiaomi.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class ihl {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f1298O000000o = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX WARNING: Removed duplicated region for block: B:113:0x00e1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d2 A[LOOP:1: B:46:0x00a7->B:59:0x00d2, LOOP_END] */
    public static iho O000000o(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        String str2;
        Mode mode;
        int i;
        int i2;
        CharacterSetECI characterSetECIByName;
        if (map == null || !map.containsKey(EncodeHintType.CHARACTER_SET)) {
            str2 = "ISO-8859-1";
        } else {
            str2 = map.get(EncodeHintType.CHARACTER_SET).toString();
        }
        int i3 = 0;
        if (!"Shift_JIS".equals(str2) || !O000000o(str)) {
            int i4 = 0;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                if (i4 < str.length()) {
                    char charAt = str.charAt(i4);
                    if (charAt < '0' || charAt > '9') {
                        if (O000000o(charAt) == -1) {
                            mode = Mode.BYTE;
                            break;
                        }
                        z = true;
                    } else {
                        z2 = true;
                    }
                    i4++;
                } else if (z) {
                    mode = Mode.ALPHANUMERIC;
                } else if (z2) {
                    mode = Mode.NUMERIC;
                } else {
                    mode = Mode.BYTE;
                }
            }
        } else {
            mode = Mode.KANJI;
        }
        idl idl = new idl();
        if (mode == Mode.BYTE && !"ISO-8859-1".equals(str2) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2)) != null) {
            idl.O00000Oo(Mode.ECI.getBits(), 4);
            idl.O00000Oo(characterSetECIByName.getValue(), 8);
        }
        idl.O00000Oo(mode.getBits(), 4);
        idl idl2 = new idl();
        int i5 = AnonymousClass1.f1299O000000o[mode.ordinal()];
        if (i5 == 1) {
            int length = str.length();
            while (i3 < length) {
                int charAt2 = str.charAt(i3) - '0';
                int i6 = i3 + 2;
                if (i6 < length) {
                    idl2.O00000Oo((charAt2 * 100) + ((str.charAt(i3 + 1) - '0') * 10) + (str.charAt(i6) - '0'), 10);
                    i = i3 + 3;
                } else {
                    i = i3 + 1;
                    if (i < length) {
                        idl2.O00000Oo((charAt2 * 10) + (str.charAt(i) - '0'), 7);
                        i = i6;
                    } else {
                        idl2.O00000Oo(charAt2, 4);
                    }
                }
            }
        } else if (i5 == 2) {
            int length2 = str.length();
            while (i3 < length2) {
                int O000000o2 = O000000o(str.charAt(i3));
                if (O000000o2 != -1) {
                    int i7 = i3 + 1;
                    if (i7 < length2) {
                        int O000000o3 = O000000o(str.charAt(i7));
                        if (O000000o3 != -1) {
                            idl2.O00000Oo((O000000o2 * 45) + O000000o3, 11);
                            i3 += 2;
                        } else {
                            throw new WriterException();
                        }
                    } else {
                        idl2.O00000Oo(O000000o2, 6);
                        i3 = i7;
                    }
                } else {
                    throw new WriterException();
                }
            }
        } else if (i5 == 3) {
            try {
                byte[] bytes = str.getBytes(str2);
                int length3 = bytes.length;
                while (i3 < length3) {
                    idl2.O00000Oo(bytes[i3], 8);
                    i3++;
                }
            } catch (UnsupportedEncodingException e) {
                throw new WriterException(e);
            }
        } else if (i5 == 4) {
            try {
                byte[] bytes2 = str.getBytes("Shift_JIS");
                int length4 = bytes2.length;
                while (i3 < length4) {
                    byte b = ((bytes2[i3] & 255) << 8) | (bytes2[i3 + 1] & 255);
                    byte b2 = 33088;
                    if (b < 33088 || b > 40956) {
                        if (b < 57408 || b > 60351) {
                            i2 = -1;
                            if (i2 == -1) {
                                idl2.O00000Oo(((i2 >> 8) * 192) + (i2 & 255), 13);
                                i3 += 2;
                            } else {
                                throw new WriterException("Invalid byte sequence");
                            }
                        } else {
                            b2 = 49472;
                        }
                    }
                    i2 = b - b2;
                    if (i2 == -1) {
                    }
                }
            } catch (UnsupportedEncodingException e2) {
                throw new WriterException(e2);
            }
        } else {
            throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
        ihd O000000o4 = O000000o(idl.O00000Oo + mode.getCharacterCountBits(O000000o(idl.O00000Oo + mode.getCharacterCountBits(ihd.O00000Oo(1)) + idl2.O00000Oo, errorCorrectionLevel)) + idl2.O00000Oo, errorCorrectionLevel);
        idl idl3 = new idl();
        idl3.O000000o(idl);
        int O000000o5 = mode == Mode.BYTE ? idl2.O000000o() : str.length();
        int characterCountBits = mode.getCharacterCountBits(O000000o4);
        int i8 = 1 << characterCountBits;
        if (O000000o5 < i8) {
            idl3.O00000Oo(O000000o5, characterCountBits);
            idl3.O000000o(idl2);
            ihd.O00000Oo O000000o6 = O000000o4.O000000o(errorCorrectionLevel);
            int O00000Oo = O000000o4.O00000o0 - O000000o6.O00000Oo();
            O000000o(O00000Oo, idl3);
            idl O000000o7 = O000000o(idl3, O000000o4.O00000o0, O00000Oo, O000000o6.O000000o());
            iho iho = new iho();
            iho.O00000Oo = errorCorrectionLevel;
            iho.f1301O000000o = mode;
            iho.O00000o0 = O000000o4;
            int O000000o8 = O000000o4.O000000o();
            ihk ihk = new ihk(O000000o8, O000000o8);
            int O000000o9 = O000000o(O000000o7, errorCorrectionLevel, O000000o4, ihk);
            iho.O00000o = O000000o9;
            ihn.O000000o(O000000o7, errorCorrectionLevel, O000000o4, O000000o9, ihk);
            iho.O00000oO = ihk;
            return iho;
        }
        throw new WriterException(O000000o5 + " is bigger than " + (i8 - 1));
    }

    private static int O000000o(int i) {
        int[] iArr = f1298O000000o;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static boolean O000000o(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                byte b = bytes[i] & 255;
                if ((b < 129 || b > 159) && (b < 224 || b > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int O000000o(idl idl, ErrorCorrectionLevel errorCorrectionLevel, ihd ihd, ihk ihk) throws WriterException {
        ihk ihk2 = ihk;
        boolean z = false;
        int i = -1;
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        while (i2 < 8) {
            ihn.O000000o(idl, errorCorrectionLevel, ihd, i2, ihk2);
            int O000000o2 = ihm.O000000o(ihk2, true) + ihm.O000000o(ihk2, z);
            byte[][] bArr = ihk2.f1297O000000o;
            int i4 = ihk2.O00000Oo;
            int i5 = ihk2.O00000o0;
            int i6 = 0;
            int i7 = 0;
            while (i6 < i5 - 1) {
                int i8 = i7;
                int i9 = 0;
                while (i9 < i4 - 1) {
                    byte b = bArr[i6][i9];
                    int i10 = i9 + 1;
                    if (b == bArr[i6][i10]) {
                        int i11 = i6 + 1;
                        if (b == bArr[i11][i9] && b == bArr[i11][i10]) {
                            i8++;
                        }
                    }
                    i9 = i10;
                }
                i6++;
                i7 = i8;
            }
            int i12 = O000000o2 + (i7 * 3);
            byte[][] bArr2 = ihk2.f1297O000000o;
            int i13 = ihk2.O00000Oo;
            int i14 = ihk2.O00000o0;
            int i15 = 0;
            int i16 = 0;
            while (i15 < i14) {
                int i17 = i16;
                for (int i18 = 0; i18 < i13; i18++) {
                    byte[] bArr3 = bArr2[i15];
                    int i19 = i18 + 6;
                    if (i19 < i13 && bArr3[i18] == 1 && bArr3[i18 + 1] == 0 && bArr3[i18 + 2] == 1 && bArr3[i18 + 3] == 1 && bArr3[i18 + 4] == 1 && bArr3[i18 + 5] == 0 && bArr3[i19] == 1 && (ihm.O000000o(bArr3, i18 - 4, i18) || ihm.O000000o(bArr3, i18 + 7, i18 + 11))) {
                        i17++;
                    }
                    int i20 = i15 + 6;
                    if (i20 < i14 && bArr2[i15][i18] == 1 && bArr2[i15 + 1][i18] == 0 && bArr2[i15 + 2][i18] == 1 && bArr2[i15 + 3][i18] == 1 && bArr2[i15 + 4][i18] == 1 && bArr2[i15 + 5][i18] == 0 && bArr2[i20][i18] == 1 && (ihm.O000000o(bArr2, i18, i15 - 4, i15) || ihm.O000000o(bArr2, i18, i15 + 7, i15 + 11))) {
                        i17++;
                    }
                }
                i15++;
                i16 = i17;
            }
            int i21 = i12 + (i16 * 40);
            byte[][] bArr4 = ihk2.f1297O000000o;
            int i22 = ihk2.O00000Oo;
            int i23 = ihk2.O00000o0;
            int i24 = 0;
            int i25 = 0;
            while (i24 < i23) {
                byte[] bArr5 = bArr4[i24];
                int i26 = i25;
                for (int i27 = 0; i27 < i22; i27++) {
                    if (bArr5[i27] == 1) {
                        i26++;
                    }
                }
                i24++;
                i25 = i26;
            }
            int i28 = ihk2.O00000o0 * ihk2.O00000Oo;
            int abs = i21 + (((Math.abs((i25 * 2) - i28) * 10) / i28) * 10);
            if (abs < i3) {
                i = i2;
                i3 = abs;
            }
            i2++;
            z = false;
        }
        return i;
    }

    private static ihd O000000o(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            ihd O00000Oo = ihd.O00000Oo(i2);
            if (O00000Oo.O00000o0 - O00000Oo.O000000o(errorCorrectionLevel).O00000Oo() >= (i + 7) / 8) {
                return O00000Oo;
            }
        }
        throw new WriterException("Data too big");
    }

    private static idl O000000o(idl idl, int i, int i2, int i3) throws WriterException {
        char c;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (idl.O000000o() == i5) {
            ArrayList<ihj> arrayList = new ArrayList<>(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i7 < i6) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                if (i7 < i6) {
                    int i11 = i4 % i6;
                    int i12 = i6 - i11;
                    int i13 = i4 / i6;
                    int i14 = i13 + 1;
                    int i15 = i5 / i6;
                    int i16 = i15 + 1;
                    int i17 = i13 - i15;
                    int i18 = i14 - i16;
                    if (i17 != i18) {
                        throw new WriterException("EC bytes mismatch");
                    } else if (i6 != i12 + i11) {
                        throw new WriterException("RS blocks mismatch");
                    } else if (i4 == ((i15 + i17) * i12) + ((i16 + i18) * i11)) {
                        if (i7 < i12) {
                            c = 0;
                            iArr[0] = i15;
                            iArr2[0] = i17;
                        } else {
                            c = 0;
                            iArr[0] = i16;
                            iArr2[0] = i18;
                        }
                        int i19 = iArr[c];
                        byte[] bArr = new byte[i19];
                        idl.O000000o(i8 * 8, bArr, i19);
                        byte[] O000000o2 = O000000o(bArr, iArr2[c]);
                        arrayList.add(new ihj(bArr, O000000o2));
                        i9 = Math.max(i9, i19);
                        i10 = Math.max(i10, O000000o2.length);
                        i8 += iArr[c];
                        i7++;
                    } else {
                        throw new WriterException("Total bytes mismatch");
                    }
                } else {
                    throw new WriterException("Block ID too large");
                }
            }
            if (i5 == i8) {
                idl idl2 = new idl();
                for (int i20 = 0; i20 < i9; i20++) {
                    for (ihj ihj : arrayList) {
                        byte[] bArr2 = ihj.f1296O000000o;
                        if (i20 < bArr2.length) {
                            idl2.O00000Oo(bArr2[i20], 8);
                        }
                    }
                }
                for (int i21 = 0; i21 < i10; i21++) {
                    for (ihj ihj2 : arrayList) {
                        byte[] bArr3 = ihj2.O00000Oo;
                        if (i21 < bArr3.length) {
                            idl2.O00000Oo(bArr3[i21], 8);
                        }
                    }
                }
                if (i4 == idl2.O000000o()) {
                    return idl2;
                }
                throw new WriterException("Interleaving error: " + i4 + " and " + idl2.O000000o() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static byte[] O000000o(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        ieb ieb = new ieb(idy.O00000oO);
        if (i != 0) {
            int length2 = iArr.length - i;
            if (length2 > 0) {
                idz O000000o2 = ieb.O000000o(i);
                int[] iArr2 = new int[length2];
                System.arraycopy(iArr, 0, iArr2, 0, length2);
                int[] iArr3 = new idz(ieb.f1226O000000o, iArr2).O000000o(i, 1).O00000o0(O000000o2)[1].f1222O000000o;
                int length3 = i - iArr3.length;
                for (int i3 = 0; i3 < length3; i3++) {
                    iArr[length2 + i3] = 0;
                }
                System.arraycopy(iArr3, 0, iArr, length2 + length3, iArr3.length);
                byte[] bArr2 = new byte[i];
                for (int i4 = 0; i4 < i; i4++) {
                    bArr2[i4] = (byte) iArr[length + i4];
                }
                return bArr2;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }

    /* renamed from: _m_j.ihl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1299O000000o = new int[Mode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f1299O000000o[Mode.NUMERIC.ordinal()] = 1;
            f1299O000000o[Mode.ALPHANUMERIC.ordinal()] = 2;
            f1299O000000o[Mode.BYTE.ordinal()] = 3;
            try {
                f1299O000000o[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static void O000000o(int i, idl idl) throws WriterException {
        int i2 = i * 8;
        if (idl.O00000Oo <= i2) {
            for (int i3 = 0; i3 < 4 && idl.O00000Oo < i2; i3++) {
                idl.O000000o(false);
            }
            int i4 = idl.O00000Oo & 7;
            if (i4 > 0) {
                while (i4 < 8) {
                    idl.O000000o(false);
                    i4++;
                }
            }
            int O000000o2 = i - idl.O000000o();
            for (int i5 = 0; i5 < O000000o2; i5++) {
                idl.O00000Oo((i5 & 1) == 0 ? 236 : 17, 8);
            }
            if (idl.O00000Oo != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + idl.O00000Oo + " > " + i2);
    }
}
