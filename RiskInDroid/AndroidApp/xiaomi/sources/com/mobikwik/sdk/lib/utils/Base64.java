package com.mobikwik.sdk.lib.utils;

import android.support.v4.app.NotificationCompat;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] DECODABET;
    private static final byte[] WEBSAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] WEBSAFE_DECODABET;

    static {
        byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
        // fill-array-data instruction
        bArr[0] = -9;
        bArr[1] = -9;
        bArr[2] = -9;
        bArr[3] = -9;
        bArr[4] = -9;
        bArr[5] = -9;
        bArr[6] = -9;
        bArr[7] = -9;
        bArr[8] = -9;
        bArr[9] = -5;
        bArr[10] = -5;
        bArr[11] = -9;
        bArr[12] = -9;
        bArr[13] = -5;
        bArr[14] = -9;
        bArr[15] = -9;
        bArr[16] = -9;
        bArr[17] = -9;
        bArr[18] = -9;
        bArr[19] = -9;
        bArr[20] = -9;
        bArr[21] = -9;
        bArr[22] = -9;
        bArr[23] = -9;
        bArr[24] = -9;
        bArr[25] = -9;
        bArr[26] = -9;
        bArr[27] = -9;
        bArr[28] = -9;
        bArr[29] = -9;
        bArr[30] = -9;
        bArr[31] = -9;
        bArr[32] = -5;
        bArr[33] = -9;
        bArr[34] = -9;
        bArr[35] = -9;
        bArr[36] = -9;
        bArr[37] = -9;
        bArr[38] = -9;
        bArr[39] = -9;
        bArr[40] = -9;
        bArr[41] = -9;
        bArr[42] = -9;
        bArr[43] = 62;
        bArr[44] = -9;
        bArr[45] = -9;
        bArr[46] = -9;
        bArr[47] = 63;
        bArr[48] = 52;
        bArr[49] = 53;
        bArr[50] = 54;
        bArr[51] = 55;
        bArr[52] = 56;
        bArr[53] = 57;
        bArr[54] = 58;
        bArr[55] = 59;
        bArr[56] = 60;
        bArr[57] = 61;
        bArr[58] = -9;
        bArr[59] = -9;
        bArr[60] = -9;
        bArr[61] = -1;
        bArr[62] = -9;
        bArr[63] = -9;
        bArr[64] = -9;
        bArr[65] = 0;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = 11;
        bArr[77] = 12;
        bArr[78] = 13;
        bArr[79] = 14;
        bArr[80] = 15;
        bArr[81] = 16;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        bArr[91] = -9;
        bArr[92] = -9;
        bArr[93] = -9;
        bArr[94] = -9;
        bArr[95] = -9;
        bArr[96] = -9;
        bArr[97] = 26;
        bArr[98] = 27;
        bArr[99] = 28;
        bArr[100] = 29;
        bArr[101] = 30;
        bArr[102] = 31;
        bArr[103] = 32;
        bArr[104] = 33;
        bArr[105] = 34;
        bArr[106] = 35;
        bArr[107] = 36;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 43;
        bArr[115] = 44;
        bArr[116] = 45;
        bArr[117] = 46;
        bArr[118] = 47;
        bArr[119] = 48;
        bArr[120] = 49;
        bArr[121] = 50;
        bArr[122] = 51;
        bArr[123] = -9;
        bArr[124] = -9;
        bArr[125] = -9;
        bArr[126] = -9;
        bArr[127] = -9;
        DECODABET = bArr;
        byte[] bArr2 = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
        // fill-array-data instruction
        bArr2[0] = -9;
        bArr2[1] = -9;
        bArr2[2] = -9;
        bArr2[3] = -9;
        bArr2[4] = -9;
        bArr2[5] = -9;
        bArr2[6] = -9;
        bArr2[7] = -9;
        bArr2[8] = -9;
        bArr2[9] = -5;
        bArr2[10] = -5;
        bArr2[11] = -9;
        bArr2[12] = -9;
        bArr2[13] = -5;
        bArr2[14] = -9;
        bArr2[15] = -9;
        bArr2[16] = -9;
        bArr2[17] = -9;
        bArr2[18] = -9;
        bArr2[19] = -9;
        bArr2[20] = -9;
        bArr2[21] = -9;
        bArr2[22] = -9;
        bArr2[23] = -9;
        bArr2[24] = -9;
        bArr2[25] = -9;
        bArr2[26] = -9;
        bArr2[27] = -9;
        bArr2[28] = -9;
        bArr2[29] = -9;
        bArr2[30] = -9;
        bArr2[31] = -9;
        bArr2[32] = -5;
        bArr2[33] = -9;
        bArr2[34] = -9;
        bArr2[35] = -9;
        bArr2[36] = -9;
        bArr2[37] = -9;
        bArr2[38] = -9;
        bArr2[39] = -9;
        bArr2[40] = -9;
        bArr2[41] = -9;
        bArr2[42] = -9;
        bArr2[43] = -9;
        bArr2[44] = -9;
        bArr2[45] = 62;
        bArr2[46] = -9;
        bArr2[47] = -9;
        bArr2[48] = 52;
        bArr2[49] = 53;
        bArr2[50] = 54;
        bArr2[51] = 55;
        bArr2[52] = 56;
        bArr2[53] = 57;
        bArr2[54] = 58;
        bArr2[55] = 59;
        bArr2[56] = 60;
        bArr2[57] = 61;
        bArr2[58] = -9;
        bArr2[59] = -9;
        bArr2[60] = -9;
        bArr2[61] = -1;
        bArr2[62] = -9;
        bArr2[63] = -9;
        bArr2[64] = -9;
        bArr2[65] = 0;
        bArr2[66] = 1;
        bArr2[67] = 2;
        bArr2[68] = 3;
        bArr2[69] = 4;
        bArr2[70] = 5;
        bArr2[71] = 6;
        bArr2[72] = 7;
        bArr2[73] = 8;
        bArr2[74] = 9;
        bArr2[75] = 10;
        bArr2[76] = 11;
        bArr2[77] = 12;
        bArr2[78] = 13;
        bArr2[79] = 14;
        bArr2[80] = 15;
        bArr2[81] = 16;
        bArr2[82] = 17;
        bArr2[83] = 18;
        bArr2[84] = 19;
        bArr2[85] = 20;
        bArr2[86] = 21;
        bArr2[87] = 22;
        bArr2[88] = 23;
        bArr2[89] = 24;
        bArr2[90] = 25;
        bArr2[91] = -9;
        bArr2[92] = -9;
        bArr2[93] = -9;
        bArr2[94] = -9;
        bArr2[95] = 63;
        bArr2[96] = -9;
        bArr2[97] = 26;
        bArr2[98] = 27;
        bArr2[99] = 28;
        bArr2[100] = 29;
        bArr2[101] = 30;
        bArr2[102] = 31;
        bArr2[103] = 32;
        bArr2[104] = 33;
        bArr2[105] = 34;
        bArr2[106] = 35;
        bArr2[107] = 36;
        bArr2[108] = 37;
        bArr2[109] = 38;
        bArr2[110] = 39;
        bArr2[111] = 40;
        bArr2[112] = 41;
        bArr2[113] = 42;
        bArr2[114] = 43;
        bArr2[115] = 44;
        bArr2[116] = 45;
        bArr2[117] = 46;
        bArr2[118] = 47;
        bArr2[119] = 48;
        bArr2[120] = 49;
        bArr2[121] = 50;
        bArr2[122] = 51;
        bArr2[123] = -9;
        bArr2[124] = -9;
        bArr2[125] = -9;
        bArr2[126] = -9;
        bArr2[127] = -9;
        WEBSAFE_DECODABET = bArr2;
    }

    private Base64() {
    }

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes();
        return decode(bytes, 0, bytes.length);
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, 0, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i, int i2) {
        return decode(bArr, i, i2, DECODABET);
    }

    public static byte[] decode(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = i2;
        byte[] bArr3 = bArr2;
        byte[] bArr4 = new byte[(((i3 * 3) / 4) + 2)];
        byte[] bArr5 = new byte[4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i7 = i4 + i;
            byte b = (byte) (bArr[i7] & Byte.MAX_VALUE);
            byte b2 = bArr3[b];
            if (b2 >= -5) {
                if (b2 >= -1) {
                    if (b == 61) {
                        int i8 = i3 - i4;
                        byte b3 = (byte) (bArr[(i3 - 1) + i] & Byte.MAX_VALUE);
                        if (i5 == 0 || i5 == 1) {
                            throw new Base64DecoderException("invalid padding byte '=' at byte offset ".concat(String.valueOf(i4)));
                        } else if ((i5 == 3 && i8 > 2) || (i5 == 4 && i8 > 1)) {
                            throw new Base64DecoderException("padding byte '=' falsely signals end of encoded value at offset ".concat(String.valueOf(i4)));
                        } else if (b3 != 61 && b3 != 10) {
                            throw new Base64DecoderException("encoded value has invalid trailing byte");
                        }
                    } else {
                        int i9 = i5 + 1;
                        bArr5[i5] = b;
                        if (i9 == 4) {
                            i6 += decode4to3(bArr5, 0, bArr4, i6, bArr3);
                            i5 = 0;
                        } else {
                            i5 = i9;
                        }
                    }
                }
                i4++;
            } else {
                throw new Base64DecoderException("Bad Base64 input character at " + i4 + ": " + ((int) bArr[i7]) + "(decimal)");
            }
        }
        if (i5 != 0) {
            if (i5 != 1) {
                bArr5[i5] = 61;
                i6 += decode4to3(bArr5, 0, bArr4, i6, bArr3);
            } else {
                throw new Base64DecoderException("single trailing character at offset " + (i3 - 1));
            }
        }
        byte[] bArr6 = new byte[i6];
        System.arraycopy(bArr4, 0, bArr6, 0, i6);
        return bArr6;
    }

    private static int decode4to3(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        int i3 = i + 2;
        if (bArr[i3] == 61) {
            bArr2[i2] = (byte) ((((bArr3[bArr[i + 1]] << 24) >>> 12) | ((bArr3[bArr[i]] << 24) >>> 6)) >>> 16);
            return 1;
        }
        int i4 = i + 3;
        if (bArr[i4] == 61) {
            int i5 = (bArr3[bArr[i + 1]] << 24) >>> 12;
            int i6 = ((bArr3[bArr[i3]] << 24) >>> 18) | i5 | ((bArr3[bArr[i]] << 24) >>> 6);
            bArr2[i2] = (byte) (i6 >>> 16);
            bArr2[i2 + 1] = (byte) (i6 >>> 8);
            return 2;
        }
        int i7 = (bArr3[bArr[i + 1]] << 24) >>> 12;
        int i8 = ((bArr3[bArr[i4]] << 24) >>> 24) | i7 | ((bArr3[bArr[i]] << 24) >>> 6) | ((bArr3[bArr[i3]] << 24) >>> 18);
        bArr2[i2] = (byte) (i8 >> 16);
        bArr2[i2 + 1] = (byte) (i8 >> 8);
        bArr2[i2 + 2] = (byte) i8;
        return 3;
    }

    public static byte[] decodeWebSafe(String str) {
        byte[] bytes = str.getBytes();
        return decodeWebSafe(bytes, 0, bytes.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr) {
        return decodeWebSafe(bArr, 0, bArr.length);
    }

    public static byte[] decodeWebSafe(byte[] bArr, int i, int i2) {
        return decode(bArr, i, i2, WEBSAFE_DECODABET);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mobikwik.sdk.lib.utils.Base64.encode(byte[], int, int, byte[], boolean):java.lang.String
     arg types: [byte[], int, int, byte[], int]
     candidates:
      com.mobikwik.sdk.lib.utils.Base64.encode(byte[], int, int, byte[], int):byte[]
      com.mobikwik.sdk.lib.utils.Base64.encode(byte[], int, int, byte[], boolean):java.lang.String */
    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length, ALPHABET, true);
    }

    public static String encode(byte[] bArr, int i, int i2, byte[] bArr2, boolean z) {
        byte[] encode = encode(bArr, i, i2, bArr2, Integer.MAX_VALUE);
        int length = encode.length;
        while (!z && length > 0 && encode[length - 1] == 61) {
            length--;
        }
        return new String(encode, 0, length);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = ((i2 + 2) / 3) * 4;
        byte[] bArr3 = new byte[(i4 + (i4 / i3))];
        int i5 = i2 - 2;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i5) {
            int i9 = ((bArr[i6 + i] << 24) >>> 8) | ((bArr[(i6 + 1) + i] << 24) >>> 16) | ((bArr[(i6 + 2) + i] << 24) >>> 24);
            bArr3[i7] = bArr2[i9 >>> 18];
            int i10 = i7 + 1;
            bArr3[i10] = bArr2[(i9 >>> 12) & 63];
            bArr3[i7 + 2] = bArr2[(i9 >>> 6) & 63];
            bArr3[i7 + 3] = bArr2[i9 & 63];
            i8 += 4;
            if (i8 == i3) {
                bArr3[i7 + 4] = 10;
                i8 = 0;
            } else {
                i10 = i7;
            }
            i6 += 3;
            i7 = i10 + 4;
        }
        if (i6 < i2) {
            encode3to4(bArr, i6 + i, i2 - i6, bArr3, i7, bArr2);
            if (i8 + 4 == i3) {
                bArr3[i7 + 4] = 10;
            }
        }
        return bArr3;
    }

    private static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3, byte[] bArr3) {
        int i4 = 0;
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        int i6 = i5 | i4;
        if (i2 == 1) {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i6 >>> 18];
            bArr2[i3 + 1] = bArr3[(i6 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i6 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i6 & 63];
            return bArr2;
        }
    }

    public static String encodeWebSafe(byte[] bArr, boolean z) {
        return encode(bArr, 0, bArr.length, WEBSAFE_ALPHABET, z);
    }
}
