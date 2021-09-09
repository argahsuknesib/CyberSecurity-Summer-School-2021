package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

final class DecodedBitStreamParser {
    private static final BigInteger[] EXP900;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

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
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004e  */
    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != 913) {
                switch (i2) {
                    case 900:
                        i = textCompaction(iArr, i3, sb);
                        break;
                    case 901:
                        i = byteCompaction(i2, iArr, charset, i3, sb);
                        break;
                    case 902:
                        i = numericCompaction(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i = i3 + 1;
                                break;
                            case 926:
                                i = i3 + 2;
                                break;
                            case 927:
                                i = i3 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i3]).name());
                                break;
                            case 928:
                                i = decodeMacroBlock(iArr, i3, pDF417ResultMetadata);
                                break;
                            default:
                                i = textCompaction(iArr, i3 - 1, sb);
                                break;
                        }
                }
            } else {
                i = i3 + 1;
                sb.append((char) iArr[i3]);
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult(null, sb.toString(), null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            int i4 = iArr[textCompaction] == 923 ? textCompaction + 1 : -1;
            while (textCompaction < iArr[0]) {
                int i5 = iArr[textCompaction];
                if (i5 == 922) {
                    textCompaction++;
                    pDF417ResultMetadata.setLastSegment(true);
                } else if (i5 == 923) {
                    int i6 = textCompaction + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb2);
                            pDF417ResultMetadata.setFileName(sb2.toString());
                            continue;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb3);
                            pDF417ResultMetadata.setSegmentCount(Integer.parseInt(sb3.toString()));
                            continue;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb4);
                            pDF417ResultMetadata.setTimestamp(Long.parseLong(sb4.toString()));
                            continue;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb5);
                            pDF417ResultMetadata.setSender(sb5.toString());
                            continue;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            textCompaction = textCompaction(iArr, i6 + 1, sb6);
                            pDF417ResultMetadata.setAddressee(sb6.toString());
                            continue;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb7);
                            pDF417ResultMetadata.setFileSize(Long.parseLong(sb7.toString()));
                            continue;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            textCompaction = numericCompaction(iArr, i6 + 1, sb8);
                            pDF417ResultMetadata.setChecksum(Integer.parseInt(sb8.toString()));
                            continue;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i4 != -1) {
                int i7 = textCompaction - i4;
                if (pDF417ResultMetadata.isLastSegment()) {
                    i7--;
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOfRange(iArr, i4, i7 + i4));
            }
            return textCompaction;
        }
        throw FormatException.getFormatInstance();
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != 913) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            break;
                        default:
                            switch (i4) {
                            }
                        case 901:
                        case 902:
                            i = i3 - 1;
                            z = true;
                            break;
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = 913;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00de A[PHI: r1 10  PHI: (r1v5 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode) = (r1v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode), (r1v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode), (r1v2 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode), (r1v20 com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode) binds: [B:55:0x00cd, B:44:0x00ac, B:33:0x0085, B:19:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        char c;
        Mode mode;
        int i2;
        char c2;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = Mode.ALPHA;
        Mode mode4 = mode2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            switch (mode4) {
                case ALPHA:
                    if (i4 >= 26) {
                        if (i4 == 900) {
                            mode4 = Mode.ALPHA;
                        } else if (i4 != 913) {
                            switch (i4) {
                                case 26:
                                    c = ' ';
                                    break;
                                case 27:
                                    mode4 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode4 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c = 0;
                                    Mode mode5 = mode;
                                    mode3 = mode4;
                                    mode4 = mode5;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    } else {
                        i2 = i4 + 65;
                        c = (char) i2;
                        break;
                    }
                case LOWER:
                    if (i4 >= 26) {
                        if (i4 == 900) {
                            mode4 = Mode.ALPHA;
                        } else if (i4 != 913) {
                            switch (i4) {
                                case 27:
                                    mode = Mode.ALPHA_SHIFT;
                                    c = 0;
                                    Mode mode52 = mode;
                                    mode3 = mode4;
                                    mode4 = mode52;
                                    break;
                                case 28:
                                    mode4 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c = 0;
                                    Mode mode522 = mode;
                                    mode3 = mode4;
                                    mode4 = mode522;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    } else {
                        i2 = i4 + 97;
                        c = (char) i2;
                        break;
                    }
                case MIXED:
                    if (i4 >= 25) {
                        if (i4 == 900) {
                            mode4 = Mode.ALPHA;
                        } else if (i4 != 913) {
                            switch (i4) {
                                case 25:
                                    mode4 = Mode.PUNCT;
                                    break;
                                case 27:
                                    mode4 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode4 = Mode.ALPHA;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c = 0;
                                    Mode mode5222 = mode;
                                    mode3 = mode4;
                                    mode4 = mode5222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    } else {
                        c = MIXED_CHARS[i4];
                        break;
                    }
                    break;
                case PUNCT:
                    if (i4 >= 29) {
                        if (i4 == 29) {
                            mode4 = Mode.ALPHA;
                        } else if (i4 == 900) {
                            mode4 = Mode.ALPHA;
                        } else if (i4 == 913) {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    } else {
                        c = PUNCT_CHARS[i4];
                        break;
                    }
                case ALPHA_SHIFT:
                    if (i4 >= 26) {
                        if (i4 == 26) {
                            mode4 = mode3;
                            c = ' ';
                            break;
                        } else {
                            if (i4 == 900) {
                                mode4 = Mode.ALPHA;
                                c = 0;
                                break;
                            }
                            mode4 = mode3;
                            c = 0;
                        }
                    } else {
                        c2 = (char) (i4 + 65);
                        c = c2;
                        mode4 = mode3;
                        break;
                    }
                case PUNCT_SHIFT:
                    if (i4 >= 29) {
                        if (i4 == 29) {
                            mode4 = Mode.ALPHA;
                        } else if (i4 != 900) {
                            if (i4 == 913) {
                                sb.append((char) iArr2[i3]);
                            }
                            mode4 = mode3;
                        } else {
                            mode4 = Mode.ALPHA;
                        }
                        c = 0;
                        break;
                    } else {
                        c2 = PUNCT_CHARS[i4];
                        c = c2;
                        mode4 = mode3;
                        break;
                    }
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        long j;
        int i4;
        int i5;
        int i6 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        long j2 = 900;
        int i7 = 6;
        if (i6 == 901) {
            int[] iArr2 = new int[6];
            int i8 = i2 + 1;
            int i9 = iArr[i2];
            boolean z = false;
            while (true) {
                i5 = 0;
                long j3 = 0;
                while (i4 < iArr[0] && !z) {
                    int i10 = i5 + 1;
                    iArr2[i5] = i9;
                    j3 = (j3 * j) + ((long) i9);
                    int i11 = i4 + 1;
                    i9 = iArr[i4];
                    if (i9 != 928) {
                        switch (i9) {
                            case 900:
                            case 901:
                            case 902:
                                break;
                            default:
                                switch (i9) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        if (i10 % 5 != 0 || i10 <= 0) {
                                            z = z;
                                            i4 = i11;
                                            i5 = i10;
                                            j = 900;
                                            i7 = 6;
                                        } else {
                                            int i12 = 0;
                                            while (i12 < i7) {
                                                byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i12) * 8))));
                                                i12++;
                                                i7 = 6;
                                                z = z;
                                            }
                                            i8 = i11;
                                            j2 = 900;
                                        }
                                }
                                break;
                        }
                    }
                    i4 = i11 - 1;
                    i5 = i10;
                    j = 900;
                    i7 = 6;
                    z = true;
                }
            }
            if (i4 == iArr[0] && i9 < 900) {
                iArr2[i5] = i9;
                i5++;
            }
            for (int i13 = 0; i13 < i5; i13++) {
                byteArrayOutputStream.write((byte) iArr2[i13]);
            }
            i3 = i4;
        } else if (i6 != 924) {
            i3 = i2;
        } else {
            i3 = i2;
            boolean z2 = false;
            while (true) {
                int i14 = 0;
                long j4 = 0;
                while (i3 < iArr[0] && !z2) {
                    int i15 = i3 + 1;
                    int i16 = iArr[i3];
                    if (i16 < 900) {
                        i14++;
                        j4 = (j4 * 900) + ((long) i16);
                    } else {
                        if (i16 != 928) {
                            switch (i16) {
                                default:
                                    switch (i16) {
                                    }
                                case 900:
                                case 901:
                                case 902:
                                    i3 = i15 - 1;
                                    z2 = true;
                                    break;
                            }
                            if (i14 % 5 == 0 && i14 > 0) {
                                for (int i17 = 0; i17 < 6; i17++) {
                                    byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i17) * 8))));
                                }
                            }
                        }
                        i3 = i15 - 1;
                        z2 = true;
                        if (i14 % 5 == 0) {
                        }
                    }
                    i3 = i15;
                    if (i14 % 5 == 0) {
                    }
                }
            }
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
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
            } else {
                if (!(i4 == 900 || i4 == 901 || i4 == 928)) {
                    switch (i4) {
                    }
                }
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
