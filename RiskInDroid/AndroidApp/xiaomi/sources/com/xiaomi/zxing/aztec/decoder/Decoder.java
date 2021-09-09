package com.xiaomi.zxing.aztec.decoder;

import _m_j.idi;
import _m_j.idm;
import _m_j.ido;
import _m_j.idy;
import _m_j.iea;
import _m_j.jdn;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;

public final class Decoder {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f12110O000000o = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] O00000Oo = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] O00000o = {"", "\r", "\r\n", ". ", ", ", ": ", "!", jdn.f1779O000000o, "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] O00000o0 = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] O00000oO = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private idi O00000oo;

    enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int O000000o(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    public final ido O000000o(idi idi) throws FormatException {
        this.O00000oo = idi;
        boolean[] O00000Oo2 = O00000Oo(O000000o(idi.O00000o));
        return new ido(O00000o0(O00000Oo2), O000000o(O00000Oo2), null, null);
    }

    private static String O000000o(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        Table table2 = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table3 = table;
        int i = 0;
        while (i < length) {
            if (table2 == Table.BINARY) {
                if (length - i < 5) {
                    break;
                }
                int O000000o2 = O000000o(zArr, i, 5);
                int i2 = i + 5;
                if (O000000o2 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    O000000o2 = O000000o(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i3 = i2;
                int i4 = 0;
                while (true) {
                    if (i4 >= O000000o2) {
                        i = i3;
                        break;
                    } else if (length - i3 < 8) {
                        i = length;
                        break;
                    } else {
                        sb.append((char) O000000o(zArr, i3, 8));
                        i3 += 8;
                        i4++;
                    }
                }
            } else {
                int i5 = table2 == Table.DIGIT ? 4 : 5;
                if (length - i < i5) {
                    break;
                }
                int O000000o3 = O000000o(zArr, i, i5);
                i += i5;
                String O000000o4 = O000000o(table2, O000000o3);
                if (O000000o4.startsWith("CTRL_")) {
                    Table O000000o5 = O000000o(O000000o4.charAt(5));
                    if (O000000o4.charAt(6) == 'L') {
                        table2 = O000000o5;
                        table3 = table2;
                    } else {
                        table2 = O000000o5;
                    }
                } else {
                    sb.append(O000000o4);
                }
            }
            table2 = table3;
        }
        return sb.toString();
    }

    private static Table O000000o(char c) {
        if (c == 'B') {
            return Table.BINARY;
        }
        if (c == 'D') {
            return Table.DIGIT;
        }
        if (c == 'P') {
            return Table.PUNCT;
        }
        if (c == 'L') {
            return Table.LOWER;
        }
        if (c != 'M') {
            return Table.UPPER;
        }
        return Table.MIXED;
    }

    /* renamed from: com.xiaomi.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f12111O000000o = new int[Table.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f12111O000000o[Table.UPPER.ordinal()] = 1;
            f12111O000000o[Table.LOWER.ordinal()] = 2;
            f12111O000000o[Table.MIXED.ordinal()] = 3;
            f12111O000000o[Table.PUNCT.ordinal()] = 4;
            f12111O000000o[Table.DIGIT.ordinal()] = 5;
        }
    }

    private static String O000000o(Table table, int i) {
        int i2 = AnonymousClass1.f12111O000000o[table.ordinal()];
        if (i2 == 1) {
            return f12110O000000o[i];
        }
        if (i2 == 2) {
            return O00000Oo[i];
        }
        if (i2 == 3) {
            return O00000o0[i];
        }
        if (i2 == 4) {
            return O00000o[i];
        }
        if (i2 == 5) {
            return O00000oO[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] O00000Oo(boolean[] zArr) throws FormatException {
        idy idy;
        int i = 8;
        if (this.O00000oo.O00000o0 <= 2) {
            i = 6;
            idy = idy.O00000o0;
        } else if (this.O00000oo.O00000o0 <= 8) {
            idy = idy.O0000O0o;
        } else if (this.O00000oo.O00000o0 <= 22) {
            i = 10;
            idy = idy.O00000Oo;
        } else {
            i = 12;
            idy = idy.f1221O000000o;
        }
        int i2 = this.O00000oo.O00000Oo;
        int length = zArr.length / i;
        if (length >= i2) {
            int i3 = length - i2;
            int[] iArr = new int[length];
            int length2 = zArr.length % i;
            int i4 = 0;
            while (i4 < length) {
                iArr[i4] = O000000o(zArr, length2, i);
                i4++;
                length2 += i;
            }
            try {
                new iea(idy).O000000o(iArr, i3);
                int i5 = (1 << i) - 1;
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = iArr[i7];
                    if (i8 == 0 || i8 == i5) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i8 == 1 || i8 == i5 - 1) {
                        i6++;
                    }
                }
                boolean[] zArr2 = new boolean[((i2 * i) - i6)];
                int i9 = 0;
                for (int i10 = 0; i10 < i2; i10++) {
                    int i11 = iArr[i10];
                    if (i11 == 1 || i11 == i5 - 1) {
                        Arrays.fill(zArr2, i9, (i9 + i) - 1, i11 > 1);
                        i9 += i - 1;
                    } else {
                        int i12 = i - 1;
                        while (i12 >= 0) {
                            int i13 = i9 + 1;
                            zArr2[i9] = ((1 << i12) & i11) != 0;
                            i12--;
                            i9 = i13;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e) {
                throw FormatException.getFormatInstance(e);
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private boolean[] O000000o(idm idm) {
        idm idm2 = idm;
        boolean z = this.O00000oo.f1210O000000o;
        int i = this.O00000oo.O00000o0;
        int i2 = (z ? 11 : 14) + (i * 4);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[O000000o(i, z)];
        int i3 = 2;
        if (z) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < i) {
            int i11 = ((i - i9) * 4) + (z ? 9 : 12);
            int i12 = i9 * 2;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 * 2;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i10 + i15 + i16] = idm2.O000000o(iArr[i17], iArr[i18]);
                    int i19 = iArr[i18];
                    int i20 = i13 - i16;
                    zArr[(i11 * 2) + i10 + i15 + i16] = idm2.O000000o(i19, iArr[i20]);
                    int i21 = i13 - i14;
                    zArr[(i11 * 4) + i10 + i15 + i16] = idm2.O000000o(iArr[i20], iArr[i21]);
                    zArr[(i11 * 6) + i10 + i15 + i16] = idm2.O000000o(iArr[i21], iArr[i17]);
                    i16++;
                    i = i;
                    z = z;
                    i3 = 2;
                }
                i14++;
                i3 = 2;
            }
            i10 += i11 * 8;
            i9++;
            i3 = 2;
        }
        return zArr;
    }

    private static int O000000o(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte O000000o(boolean[] zArr, int i) {
        int O000000o2;
        int length = zArr.length - i;
        if (length >= 8) {
            O000000o2 = O000000o(zArr, i, 8);
        } else {
            O000000o2 = O000000o(zArr, i, length) << (8 - length);
        }
        return (byte) O000000o2;
    }

    private static byte[] O00000o0(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = O000000o(zArr, i * 8);
        }
        return bArr;
    }
}
