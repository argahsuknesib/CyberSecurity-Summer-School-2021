package _m_j;

import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

public final class ieo extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f1241O000000o;
    private static final char[] O00000Oo = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    private static final int O00000o0;
    private final StringBuilder O00000o = new StringBuilder(20);
    private final int[] O00000oO = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f1241O000000o = iArr;
        O00000o0 = iArr[47];
    }

    private static int O000000o(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int round = Math.round((((float) iArr[i4]) * 9.0f) / ((float) i));
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                int i5 = i3;
                for (int i6 = 0; i6 < round; i6++) {
                    i5 = (i5 << 1) | 1;
                }
                i3 = i5;
            } else {
                i3 <<= round;
            }
        }
        return i3;
    }

    private static void O000000o(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != O00000Oo[i3 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        r8 = _m_j.ieo.O00000Oo[r9];
        r7.append(r8);
        r9 = r6.length;
        r12 = r4;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        if (r10 >= r9) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r9 = r1.O00000o0(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (r8 != '*') goto L_0x0189;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r7.deleteCharAt(r7.length() - 1);
        r8 = r6.length;
        r10 = 0;
        r12 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
        if (r10 >= r8) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        r12 = r12 + r6[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008e, code lost:
        if (r9 == r5) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        if (r1.O000000o(r9) == false) goto L_0x0184;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        if (r7.length() < 2) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        r1 = r7.length();
        O000000o(r7, r1 - 2, 20);
        O000000o(r7, r1 - 1, 15);
        r7.setLength(r7.length() - 2);
        r1 = r7.length();
        r5 = new java.lang.StringBuilder(r1);
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bf, code lost:
        if (r6 >= r1) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        r8 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        if (r8 < 'a') goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cb, code lost:
        if (r8 > 'd') goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cf, code lost:
        if (r6 >= (r1 - 1)) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d1, code lost:
        r6 = r6 + 1;
        r9 = r7.charAt(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dd, code lost:
        switch(r8) {
            case 97: goto L_0x0136;
            case 98: goto L_0x0100;
            case 99: goto L_0x00ef;
            case 100: goto L_0x00e3;
            default: goto L_0x00e0;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e0, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e3, code lost:
        if (r9 < 'A') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e5, code lost:
        if (r9 > 'Z') goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e7, code lost:
        r9 = r9 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ee, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ef, code lost:
        if (r9 < 'A') goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f1, code lost:
        if (r9 > 'O') goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f3, code lost:
        r9 = r9 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f6, code lost:
        if (r9 != 'Z') goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f8, code lost:
        r8 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ff, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0100, code lost:
        if (r9 < 'A') goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0104, code lost:
        if (r9 > 'E') goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0106, code lost:
        r9 = r9 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010b, code lost:
        if (r9 < 'F') goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010f, code lost:
        if (r9 > 'J') goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0111, code lost:
        r9 = r9 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0116, code lost:
        if (r9 < 'K') goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0118, code lost:
        if (r9 > 'O') goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011a, code lost:
        r9 = r9 + 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011f, code lost:
        if (r9 < 'P') goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
        if (r9 > 'S') goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0125, code lost:
        r9 = r9 + '+';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012a, code lost:
        if (r9 < 'T') goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x012c, code lost:
        if (r9 > 'Z') goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012e, code lost:
        r8 = 127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0135, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0136, code lost:
        if (r9 < 'A') goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0138, code lost:
        if (r9 > 'Z') goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013a, code lost:
        r9 = r9 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x013c, code lost:
        r8 = (char) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0142, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0143, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x014b, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x014c, code lost:
        r5.append(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x014f, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0152, code lost:
        r9 = (float) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017e, code lost:
        return new _m_j.idf(r5.toString(), null, new _m_j.idg[]{new _m_j.idg(((float) (r2[1] + r2[0])) / 2.0f, r9), new _m_j.idg(((float) r4) + (((float) r12) / 2.0f), r9)}, com.xiaomi.zxing.BarcodeFormat.CODE_93);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0183, code lost:
        throw com.xiaomi.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0188, code lost:
        throw com.xiaomi.zxing.NotFoundException.getNotFoundInstance();
     */
    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int O00000o02;
        idl idl2 = idl;
        int i2 = idl2.O00000Oo;
        int O00000o03 = idl2.O00000o0(0);
        Arrays.fill(this.O00000oO, 0);
        int[] iArr = this.O00000oO;
        int length = iArr.length;
        int i3 = O00000o03;
        boolean z = false;
        int i4 = 0;
        while (O00000o03 < i2) {
            if (idl2.O000000o(O00000o03) ^ z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else if (O000000o(iArr) == O00000o0) {
                    int[] iArr2 = {i3, O00000o03};
                    int O00000o04 = idl2.O00000o0(iArr2[1]);
                    int i6 = idl2.O00000Oo;
                    int[] iArr3 = this.O00000oO;
                    Arrays.fill(iArr3, 0);
                    StringBuilder sb = this.O00000o;
                    sb.setLength(0);
                    while (true) {
                        O000000o(idl2, O00000o04, iArr3);
                        int O000000o2 = O000000o(iArr3);
                        if (O000000o2 >= 0) {
                            int i7 = 0;
                            while (true) {
                                int[] iArr4 = f1241O000000o;
                                if (i7 >= iArr4.length) {
                                    throw NotFoundException.getNotFoundInstance();
                                } else if (iArr4[i7] == O000000o2) {
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        O00000o04 = O00000o02;
                    }
                } else {
                    i3 += iArr[0] + iArr[1];
                    int i8 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i8);
                    iArr[i8] = 0;
                    iArr[i5] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z = !z;
            }
            O00000o03++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
