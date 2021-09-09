package com.xiaomi.aaccodec;

import android.support.v4.app.NotificationCompat;

public class G711 {
    private static byte[] aLawCompressTable;
    private static short[] aLawDecompressTable = {-5504, -5248, -6016, -5760, -4480, -4224, -4992, -4736, -7552, -7296, -8064, -7808, -6528, -6272, -7040, -6784, -2752, -2624, -3008, -2880, -2240, -2112, -2496, -2368, -3776, -3648, -4032, -3904, -3264, -3136, -3520, -3392, -22016, -20992, -24064, -23040, -17920, -16896, -19968, -18944, -30208, -29184, -32256, -31232, -26112, -25088, -28160, -27136, -11008, -10496, -12032, -11520, -8960, -8448, -9984, -9472, -15104, -14592, -16128, -15616, -13056, -12544, -14080, -13568, -344, -328, -376, -360, -280, -264, -312, -296, -472, -456, -504, -488, -408, -392, -440, -424, -88, -72, -120, -104, -24, -8, -56, -40, -216, -200, -248, -232, -152, -136, -184, -168, -1376, -1312, -1504, -1440, -1120, -1056, -1248, -1184, -1888, -1824, -2016, -1952, -1632, -1568, -1760, -1696, -688, -656, -752, -720, -560, -528, -624, -592, -944, -912, -1008, -976, -816, -784, -880, -848, 5504, 5248, 6016, 5760, 4480, 4224, 4992, 4736, 7552, 7296, 8064, 7808, 6528, 6272, 7040, 6784, 2752, 2624, 3008, 2880, 2240, 2112, 2496, 2368, 3776, 3648, 4032, 3904, 3264, 3136, 3520, 3392, 22016, 20992, 24064, 23040, 17920, 16896, 19968, 18944, 30208, 29184, 32256, 31232, 26112, 25088, 28160, 27136, 11008, 10496, 12032, 11520, 8960, 8448, 9984, 9472, 15104, 14592, 16128, 15616, 13056, 12544, 14080, 13568, 344, 328, 376, 360, 280, 264, 312, 296, 472, 456, 504, 488, 408, 392, 440, 424, 88, 72, 120, 104, 24, 8, 56, 40, 216, 200, 248, 232, 152, 136, 184, 168, 1376, 1312, 1504, 1440, 1120, 1056, 1248, 1184, 1888, 1824, 2016, 1952, 1632, 1568, 1760, 1696, 688, 656, 752, 720, 560, 528, 624, 592, 944, 912, 1008, 976, 816, 784, 880, 848};

    static {
        byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
        // fill-array-data instruction
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        bArr[3] = 2;
        bArr[4] = 3;
        bArr[5] = 3;
        bArr[6] = 3;
        bArr[7] = 3;
        bArr[8] = 4;
        bArr[9] = 4;
        bArr[10] = 4;
        bArr[11] = 4;
        bArr[12] = 4;
        bArr[13] = 4;
        bArr[14] = 4;
        bArr[15] = 4;
        bArr[16] = 5;
        bArr[17] = 5;
        bArr[18] = 5;
        bArr[19] = 5;
        bArr[20] = 5;
        bArr[21] = 5;
        bArr[22] = 5;
        bArr[23] = 5;
        bArr[24] = 5;
        bArr[25] = 5;
        bArr[26] = 5;
        bArr[27] = 5;
        bArr[28] = 5;
        bArr[29] = 5;
        bArr[30] = 5;
        bArr[31] = 5;
        bArr[32] = 6;
        bArr[33] = 6;
        bArr[34] = 6;
        bArr[35] = 6;
        bArr[36] = 6;
        bArr[37] = 6;
        bArr[38] = 6;
        bArr[39] = 6;
        bArr[40] = 6;
        bArr[41] = 6;
        bArr[42] = 6;
        bArr[43] = 6;
        bArr[44] = 6;
        bArr[45] = 6;
        bArr[46] = 6;
        bArr[47] = 6;
        bArr[48] = 6;
        bArr[49] = 6;
        bArr[50] = 6;
        bArr[51] = 6;
        bArr[52] = 6;
        bArr[53] = 6;
        bArr[54] = 6;
        bArr[55] = 6;
        bArr[56] = 6;
        bArr[57] = 6;
        bArr[58] = 6;
        bArr[59] = 6;
        bArr[60] = 6;
        bArr[61] = 6;
        bArr[62] = 6;
        bArr[63] = 6;
        bArr[64] = 7;
        bArr[65] = 7;
        bArr[66] = 7;
        bArr[67] = 7;
        bArr[68] = 7;
        bArr[69] = 7;
        bArr[70] = 7;
        bArr[71] = 7;
        bArr[72] = 7;
        bArr[73] = 7;
        bArr[74] = 7;
        bArr[75] = 7;
        bArr[76] = 7;
        bArr[77] = 7;
        bArr[78] = 7;
        bArr[79] = 7;
        bArr[80] = 7;
        bArr[81] = 7;
        bArr[82] = 7;
        bArr[83] = 7;
        bArr[84] = 7;
        bArr[85] = 7;
        bArr[86] = 7;
        bArr[87] = 7;
        bArr[88] = 7;
        bArr[89] = 7;
        bArr[90] = 7;
        bArr[91] = 7;
        bArr[92] = 7;
        bArr[93] = 7;
        bArr[94] = 7;
        bArr[95] = 7;
        bArr[96] = 7;
        bArr[97] = 7;
        bArr[98] = 7;
        bArr[99] = 7;
        bArr[100] = 7;
        bArr[101] = 7;
        bArr[102] = 7;
        bArr[103] = 7;
        bArr[104] = 7;
        bArr[105] = 7;
        bArr[106] = 7;
        bArr[107] = 7;
        bArr[108] = 7;
        bArr[109] = 7;
        bArr[110] = 7;
        bArr[111] = 7;
        bArr[112] = 7;
        bArr[113] = 7;
        bArr[114] = 7;
        bArr[115] = 7;
        bArr[116] = 7;
        bArr[117] = 7;
        bArr[118] = 7;
        bArr[119] = 7;
        bArr[120] = 7;
        bArr[121] = 7;
        bArr[122] = 7;
        bArr[123] = 7;
        bArr[124] = 7;
        bArr[125] = 7;
        bArr[126] = 7;
        bArr[127] = 7;
        aLawCompressTable = bArr;
    }

    public static byte[] encode(byte[] bArr, int i, int i2) {
        int i3 = i2 / 2;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i + 1;
            bArr2[i4] = linearToALawSample((short) ((bArr[i] & 255) | (bArr[i5] << 8)));
            i4++;
            i = i5 + 1;
        }
        return bArr2;
    }

    private static byte linearToALawSample(short s) {
        int i;
        int i2 = ((s ^ -1) >> 8) & NotificationCompat.FLAG_HIGH_PRIORITY;
        if (i2 != 128) {
            s = (short) (-s);
        }
        if (s > 32635) {
            s = 32635;
        }
        if (s >= 256) {
            byte b = aLawCompressTable[(s >> 8) & 127];
            i = ((s >> (b + 3)) & 15) | (b << 4);
        } else {
            i = s >> 4;
        }
        return (byte) (i ^ (i2 ^ 85));
    }

    public static int decode(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            short s = aLawDecompressTable[bArr[i4 + i] & 255];
            int i5 = i3 + 1;
            bArr2[i3] = (byte) s;
            i3 = i5 + 1;
            bArr2[i5] = (byte) (s >> 8);
        }
        return i3;
    }
}
