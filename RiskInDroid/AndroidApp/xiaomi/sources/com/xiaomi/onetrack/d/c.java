package com.xiaomi.onetrack.d;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.onetrack.h.q;
import java.io.UnsupportedEncodingException;

public class c {
    private static char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] c;

    static {
        byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
        // fill-array-data instruction
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[9] = -1;
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = -1;
        bArr[13] = -1;
        bArr[14] = -1;
        bArr[15] = -1;
        bArr[16] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[19] = -1;
        bArr[20] = -1;
        bArr[21] = -1;
        bArr[22] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[25] = -1;
        bArr[26] = -1;
        bArr[27] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[30] = -1;
        bArr[31] = -1;
        bArr[32] = -1;
        bArr[33] = -1;
        bArr[34] = -1;
        bArr[35] = -1;
        bArr[36] = -1;
        bArr[37] = -1;
        bArr[38] = -1;
        bArr[39] = -1;
        bArr[40] = -1;
        bArr[41] = -1;
        bArr[42] = -1;
        bArr[43] = 62;
        bArr[44] = -1;
        bArr[45] = -1;
        bArr[46] = -1;
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
        bArr[58] = -1;
        bArr[59] = -1;
        bArr[60] = -1;
        bArr[61] = -1;
        bArr[62] = -1;
        bArr[63] = -1;
        bArr[64] = -1;
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
        bArr[91] = -1;
        bArr[92] = -1;
        bArr[93] = -1;
        bArr[94] = -1;
        bArr[95] = -1;
        bArr[96] = -1;
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
        bArr[123] = -1;
        bArr[124] = -1;
        bArr[125] = -1;
        bArr[126] = -1;
        bArr[127] = -1;
        c = bArr;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            byte b2 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(b[b2 >>> 2]);
                stringBuffer.append(b[(b2 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i3 = i2 + 1;
            byte b3 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(b[b2 >>> 2]);
                stringBuffer.append(b[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
                stringBuffer.append(b[(b3 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i4 = i3 + 1;
            byte b4 = bArr[i3] & 255;
            stringBuffer.append(b[b2 >>> 2]);
            stringBuffer.append(b[((b2 & 3) << 4) | ((b3 & 240) >>> 4)]);
            stringBuffer.append(b[((b3 & 15) << 2) | ((b4 & 192) >>> 6)]);
            stringBuffer.append(b[b4 & 63]);
            i = i4;
        }
        return stringBuffer.toString();
    }

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (UnsupportedEncodingException e) {
            q.b(q.a("Base64Util"), "decode e", e);
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0086 A[LOOP:0: B:1:0x000d->B:33:0x0086, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092 A[EDGE_INSN: B:36:0x0092->B:34:0x0092 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0092 A[EDGE_INSN: B:39:0x0092->B:34:0x0092 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092 A[EDGE_INSN: B:40:0x0092->B:34:0x0092 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0092 A[EDGE_INSN: B:42:0x0092->B:34:0x0092 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A[LOOP:2: B:8:0x0023->B:11:0x0030, LOOP_START, PHI: r5 10  PHI: (r5v1 int) = (r5v0 int), (r5v9 int) binds: [B:7:0x0021, B:11:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    private static byte[] b(String str) throws UnsupportedEncodingException {
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i = 0;
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                b2 = c[bytes[i]];
                if (i2 >= length || b2 != -1) {
                    if (b2 != -1) {
                        break;
                    }
                    while (true) {
                        int i3 = i2 + 1;
                        b3 = c[bytes[i2]];
                        if (i3 >= length || b3 != -1) {
                            if (b3 != -1) {
                                break;
                            }
                            stringBuffer.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
                            while (true) {
                                int i4 = i3 + 1;
                                byte b6 = bytes[i3];
                                if (b6 == 61) {
                                    return stringBuffer.toString().getBytes("iso8859-1");
                                }
                                b4 = c[b6];
                                if (i4 >= length || b4 != -1) {
                                    if (b4 != -1) {
                                        break;
                                    }
                                    stringBuffer.append((char) (((b3 & 15) << 4) | ((b4 & 60) >>> 2)));
                                    while (true) {
                                        int i5 = i4 + 1;
                                        byte b7 = bytes[i4];
                                        if (b7 == 61) {
                                            return stringBuffer.toString().getBytes("iso8859-1");
                                        }
                                        b5 = c[b7];
                                        if (i5 >= length || b5 != -1) {
                                            if (b5 != -1) {
                                                break;
                                            }
                                            stringBuffer.append((char) (b5 | ((b4 & 3) << 6)));
                                            i = i5;
                                        } else {
                                            i4 = i5;
                                        }
                                    }
                                    if (b5 != -1) {
                                    }
                                } else {
                                    i3 = i4;
                                }
                            }
                            if (b4 != -1) {
                            }
                        } else {
                            i2 = i3;
                        }
                    }
                    if (b3 != -1) {
                    }
                } else {
                    i = i2;
                }
            }
            if (b2 != -1) {
            }
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }

    public static byte[] a() {
        return new byte[]{84, 123, 100, 101, 118, 33, 80, 100, 101, 116, 116, 37, 94, 52, 77, 73};
    }
}
