package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;

final class DecodedBitStreamParser {
    private static final String[] SETS = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\u001c\u001d\u001e￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\u001c\u001d\u001e￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\u001c\u001d\u001e￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a￺￼￼\u001b￻\u001c\u001d\u001e\u001f ¢£¤¥¦§©­®¶￷ ￲￳￹￸", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(byte[] bArr, int i) {
        String str;
        StringBuilder sb = new StringBuilder(144);
        if (i == 2 || i == 3) {
            if (i == 2) {
                str = new DecimalFormat("0000000000".substring(0, getPostCode2Length(bArr))).format((long) getPostCode2(bArr));
            } else {
                str = getPostCode3(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String format = decimalFormat.format((long) getCountry(bArr));
            String format2 = decimalFormat.format((long) getServiceClass(bArr));
            sb.append(getMessage(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, str + 29 + format + 29 + format2 + 29);
            } else {
                sb.insert(0, str + 29 + format + 29 + format2 + 29);
            }
        } else if (i == 4) {
            sb.append(getMessage(bArr, 1, 93));
        } else if (i == 5) {
            sb.append(getMessage(bArr, 1, 77));
        }
        return new DecoderResult(bArr, sb.toString(), null, String.valueOf(i));
    }

    private static int getBit(int i, byte[] bArr) {
        int i2 = i - 1;
        return ((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0 ? 0 : 1;
    }

    private static int getInt(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int i = 0;
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                i += getBit(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
            }
            return i;
        }
        throw new IllegalArgumentException();
    }

    private static int getCountry(byte[] bArr) {
        return getInt(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int getServiceClass(byte[] bArr) {
        return getInt(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }

    private static int getPostCode2Length(byte[] bArr) {
        return getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static int getPostCode2(byte[] bArr) {
        return getInt(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static String getPostCode3(byte[] bArr) {
        return String.valueOf(new char[]{SETS[0].charAt(getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32})), SETS[0].charAt(getInt(bArr, new byte[]{33, 34, 35, 36, 25, 26})), SETS[0].charAt(getInt(bArr, new byte[]{27, 28, 29, 30, 19, 20})), SETS[0].charAt(getInt(bArr, new byte[]{21, 22, 23, 24, 13, 14})), SETS[0].charAt(getInt(bArr, new byte[]{15, 16, 17, 18, 7, 8})), SETS[0].charAt(getInt(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private static String getMessage(byte[] bArr, int i, int i2) {
        int i3;
        StringBuilder sb = new StringBuilder();
        int i4 = i;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (i4 < i + i2) {
            char charAt = SETS[i5].charAt(bArr[i4]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i7 = i5;
                    i5 = charAt - 65520;
                    i3 = 1;
                    break;
                case 65525:
                    i3 = 2;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65526:
                    i3 = 3;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65527:
                    i5 = 0;
                    i3 = -1;
                    break;
                case 65528:
                    i5 = 1;
                    i3 = -1;
                    break;
                case 65529:
                    i3 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = i8 + 1;
                    int i10 = i9 + 1;
                    int i11 = i10 + 1;
                    i4 = i11 + 1;
                    sb.append(new DecimalFormat("000000000").format((long) ((bArr[i8] << 24) + (bArr[i9] << 18) + (bArr[i10] << 12) + (bArr[i11] << 6) + bArr[i4])));
                    break;
            }
            int i12 = i3 - 1;
            if (i3 == 0) {
                i5 = i7;
            }
            i4++;
            i6 = i12;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
