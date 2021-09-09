package com.xiaomi.zxing.pdf417.decoder;

import _m_j.ido;
import _m_j.igg;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.common.CharacterSetECI;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

public final class DecodedBitStreamParser {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f12117O000000o = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] O00000Oo = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] O00000o;
    private static final Charset O00000o0 = Charset.forName("ISO-8859-1");

    enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        O00000o = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        O00000o[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = O00000o;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    public static ido O000000o(int[] iArr, String str) throws FormatException {
        int i;
        int i2 = 2;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = O00000o0;
        int i3 = iArr[1];
        igg igg = new igg();
        while (i2 < iArr[0]) {
            if (i3 != 913) {
                switch (i3) {
                    case 900:
                        i = O000000o(iArr, i2, sb);
                        break;
                    case 901:
                        i = O000000o(i3, iArr, charset, i2, sb);
                        break;
                    case 902:
                        i = O00000Oo(iArr, i2, sb);
                        break;
                    default:
                        switch (i3) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i = i2 + 1;
                                break;
                            case 926:
                                i = i2 + 2;
                                break;
                            case 927:
                                Charset forName = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i2]).name());
                                i = i2 + 1;
                                charset = forName;
                                break;
                            case 928:
                                i = O000000o(iArr, i2, igg);
                                break;
                            default:
                                i = O000000o(iArr, i2 - 1, sb);
                                break;
                        }
                }
            } else {
                sb.append((char) iArr[i2]);
                i = i2 + 1;
            }
            if (i < iArr.length) {
                int i4 = i + 1;
                i3 = iArr[i];
                i2 = i4;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            ido ido = new ido(null, sb.toString(), null, str);
            ido.O0000O0o = igg;
            return ido;
        }
        throw FormatException.getFormatInstance();
    }

    private static int O000000o(int[] iArr, int i, igg igg) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            igg.f1269O000000o = Integer.parseInt(O000000o(iArr2, 2));
            StringBuilder sb = new StringBuilder();
            int O000000o2 = O000000o(iArr, i2, sb);
            igg.O00000Oo = sb.toString();
            if (iArr[O000000o2] == 923) {
                int i4 = O000000o2 + 1;
                int[] iArr3 = new int[(iArr[0] - i4)];
                boolean z = false;
                int i5 = 0;
                while (i4 < iArr[0] && !z) {
                    int i6 = i4 + 1;
                    int i7 = iArr[i4];
                    if (i7 < 900) {
                        iArr3[i5] = i7;
                        i4 = i6;
                        i5++;
                    } else if (i7 == 922) {
                        igg.O00000o = true;
                        i4 = i6 + 1;
                        z = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                igg.O00000o0 = Arrays.copyOf(iArr3, i5);
                return i4;
            } else if (iArr[O000000o2] != 922) {
                return O000000o2;
            } else {
                igg.O00000o = true;
                return O000000o2 + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static int O000000o(int[] iArr, int i, StringBuilder sb) {
        char c;
        int i2;
        Mode mode;
        StringBuilder sb2 = sb;
        int[] iArr2 = new int[((iArr[0] - i) * 2)];
        int[] iArr3 = new int[((iArr[0] - i) * 2)];
        int i3 = i;
        boolean z = false;
        int i4 = 0;
        while (i3 < iArr[0] && !z) {
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            if (i6 < 900) {
                iArr2[i4] = i6 / 30;
                iArr2[i4 + 1] = i6 % 30;
                i4 += 2;
            } else if (i6 != 913) {
                if (i6 != 928) {
                    switch (i6) {
                        case 900:
                            iArr2[i4] = 900;
                            i4++;
                            break;
                        default:
                            switch (i6) {
                            }
                        case 901:
                        case 902:
                            i3 = i5 - 1;
                            z = true;
                            break;
                    }
                }
                i3 = i5 - 1;
                z = true;
            } else {
                iArr2[i4] = 913;
                i3 = i5 + 1;
                iArr3[i4] = iArr[i5];
                i4++;
            }
            i3 = i5;
        }
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = Mode.ALPHA;
        Mode mode4 = mode2;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = iArr2[i7];
            switch (mode4) {
                case ALPHA:
                    if (i8 >= 26) {
                        if (i8 != 26) {
                            if (i8 != 27) {
                                if (i8 != 28) {
                                    if (i8 != 29) {
                                        if (i8 == 913) {
                                            sb2.append((char) iArr3[i7]);
                                        } else if (i8 == 900) {
                                            mode = Mode.ALPHA;
                                        }
                                        c = 0;
                                        break;
                                    } else {
                                        mode = Mode.PUNCT_SHIFT;
                                        mode3 = mode4;
                                    }
                                } else {
                                    mode = Mode.MIXED;
                                }
                            } else {
                                mode = Mode.LOWER;
                            }
                            mode4 = mode;
                            c = 0;
                        }
                        c = ' ';
                        break;
                    } else {
                        i2 = i8 + 65;
                        c = (char) i2;
                        break;
                    }
                case LOWER:
                    if (i8 >= 26) {
                        if (i8 != 26) {
                            if (i8 == 27) {
                                mode = Mode.ALPHA_SHIFT;
                            } else {
                                if (i8 != 28) {
                                    if (i8 != 29) {
                                        if (i8 == 913) {
                                            sb2.append((char) iArr3[i7]);
                                        } else if (i8 == 900) {
                                            mode = Mode.ALPHA;
                                        }
                                        c = 0;
                                        break;
                                    } else {
                                        mode = Mode.PUNCT_SHIFT;
                                    }
                                } else {
                                    mode = Mode.MIXED;
                                }
                                mode4 = mode;
                                c = 0;
                            }
                            mode3 = mode4;
                            mode4 = mode;
                            c = 0;
                        }
                        c = ' ';
                        break;
                    } else {
                        i2 = i8 + 97;
                        c = (char) i2;
                        break;
                    }
                case MIXED:
                    if (i8 < 25) {
                        c = O00000Oo[i8];
                        break;
                    } else {
                        if (i8 != 25) {
                            if (i8 != 26) {
                                if (i8 != 27) {
                                    if (i8 != 28) {
                                        if (i8 != 29) {
                                            if (i8 == 913) {
                                                sb2.append((char) iArr3[i7]);
                                            } else if (i8 == 900) {
                                                mode = Mode.ALPHA;
                                            }
                                            c = 0;
                                            break;
                                        } else {
                                            mode = Mode.PUNCT_SHIFT;
                                            mode3 = mode4;
                                        }
                                    } else {
                                        mode = Mode.ALPHA;
                                    }
                                } else {
                                    mode = Mode.LOWER;
                                }
                            }
                            c = ' ';
                            break;
                        } else {
                            mode = Mode.PUNCT;
                        }
                        mode4 = mode;
                        c = 0;
                    }
                case PUNCT:
                    if (i8 < 29) {
                        c = f12117O000000o[i8];
                        break;
                    } else {
                        if (i8 != 29) {
                            if (i8 == 913) {
                                sb2.append((char) iArr3[i7]);
                            } else if (i8 == 900) {
                                mode = Mode.ALPHA;
                            }
                            c = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA;
                        }
                        mode4 = mode;
                        c = 0;
                    }
                case ALPHA_SHIFT:
                    if (i8 < 26) {
                        c = (char) (i8 + 65);
                        mode4 = mode3;
                        break;
                    } else if (i8 == 26) {
                        mode4 = mode3;
                        c = ' ';
                        break;
                    } else {
                        if (i8 == 900) {
                            mode = Mode.ALPHA;
                            mode4 = mode;
                            c = 0;
                            break;
                        }
                        mode4 = mode3;
                        c = 0;
                    }
                case PUNCT_SHIFT:
                    if (i8 < 29) {
                        c = f12117O000000o[i8];
                        mode4 = mode3;
                        break;
                    } else {
                        if (i8 != 29) {
                            if (i8 == 913) {
                                sb2.append((char) iArr3[i7]);
                            } else if (i8 == 900) {
                                mode = Mode.ALPHA;
                            }
                            mode4 = mode3;
                            c = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA;
                        }
                        mode4 = mode;
                        c = 0;
                    }
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb2.append(c);
            }
        }
        return i3;
    }

    private static int O000000o(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        long j;
        int i4;
        int i5;
        int i6 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = 922;
        int i8 = 923;
        int i9 = 928;
        long j2 = 900;
        if (i6 == 901) {
            int[] iArr2 = new int[6];
            int i10 = i2 + 1;
            int i11 = iArr[i2];
            boolean z = false;
            loop0:
            while (true) {
                i4 = 0;
                long j3 = 0;
                while (i3 < iArr[0] && !z) {
                    int i12 = i4 + 1;
                    iArr2[i4] = i11;
                    j3 = (j3 * j) + ((long) i11);
                    int i13 = i3 + 1;
                    i11 = iArr[i3];
                    if (i11 == 900 || i11 == 901 || i11 == 902 || i11 == 924 || i11 == 928 || i11 == i8 || i11 == i7) {
                        i3 = i13 - 1;
                        i4 = i12;
                        i7 = 922;
                        i8 = 923;
                        j = 900;
                        z = true;
                    } else if (i12 % 5 != 0 || i12 <= 0) {
                        i3 = i13;
                        i4 = i12;
                        i7 = 922;
                        i8 = 923;
                        j = 900;
                    } else {
                        int i14 = 0;
                        while (i14 < 6) {
                            byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i14) * 8))));
                            i14++;
                            i7 = 922;
                            i8 = 923;
                        }
                        i10 = i13;
                        j2 = 900;
                    }
                }
            }
            if (i3 != iArr[0] || i11 >= 900) {
                i5 = i4;
            } else {
                i5 = i4 + 1;
                iArr2[i4] = i11;
            }
            for (int i15 = 0; i15 < i5; i15++) {
                byteArrayOutputStream.write((byte) iArr2[i15]);
            }
        } else if (i6 == 924) {
            int i16 = i2;
            int i17 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (i16 < iArr[0] && !z2) {
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                if (i19 < 900) {
                    i17++;
                    j4 = (j4 * 900) + ((long) i19);
                    i16 = i18;
                } else {
                    if (i19 != 900 && i19 != 901 && i19 != 902 && i19 != 924 && i19 != i9) {
                        if (i19 != 923) {
                            if (i19 != 922) {
                                i16 = i18;
                            }
                            i16 = i18 - 1;
                            z2 = true;
                        }
                    }
                    i16 = i18 - 1;
                    z2 = true;
                }
                if (i17 % 5 == 0 && i17 > 0) {
                    int i20 = 0;
                    for (int i21 = 6; i20 < i21; i21 = 6) {
                        byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i20) * 8))));
                        i20++;
                    }
                    i17 = 0;
                    j4 = 0;
                }
                i9 = 928;
            }
            i3 = i16;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int O00000Oo(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == 900 || i4 == 901 || i4 == 924 || i4 == 928 || i4 == 923 || i4 == 922) {
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(O000000o(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String O000000o(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(O00000o[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
