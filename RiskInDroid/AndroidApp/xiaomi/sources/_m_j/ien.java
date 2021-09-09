package _m_j;

import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

public final class ien extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f1240O000000o;
    static final int O00000Oo;
    private final boolean O00000o;
    private final boolean O00000o0;
    private final StringBuilder O00000oO;
    private final int[] O00000oo;

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42};
        f1240O000000o = iArr;
        O00000Oo = iArr[39];
    }

    public ien() {
        this(false);
    }

    public ien(boolean z) {
        this(z, (byte) 0);
    }

    private ien(boolean z, byte b) {
        this.O00000o0 = z;
        this.O00000o = false;
        this.O00000oO = new StringBuilder(20);
        this.O00000oo = new int[9];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
        r8 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".charAt(r9);
        r4.append(r8);
        r9 = r2.length;
        r11 = r6;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        if (r10 >= r9) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
        r11 = r11 + r2[r10];
        r10 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        r9 = r1.O00000o0(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        if (r8 != '*') goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0085, code lost:
        r4.setLength(r4.length() - r12);
        r1 = r2.length;
        r8 = 0;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        if (r8 >= r1) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        r10 = r10 + r2[r8];
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0098, code lost:
        r1 = (r9 - r6) - r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        if (r9 == r7) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        if ((r1 * 2) < r10) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a6, code lost:
        throw com.xiaomi.zxing.NotFoundException.getNotFoundInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ab, code lost:
        if (r0.O00000o0 == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        r1 = r4.length() - r12;
        r7 = 0;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b6, code lost:
        if (r7 >= r1) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b8, code lost:
        r8 = r8 + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(r0.O00000oO.charAt(r7));
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cf, code lost:
        if (r4.charAt(r1) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(r8 % 43)) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        r4.setLength(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d9, code lost:
        throw com.xiaomi.zxing.ChecksumException.getChecksumInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00de, code lost:
        if (r4.length() == 0) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
        if (r0.O00000o == false) goto L_0x016e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e4, code lost:
        r1 = r4.length();
        r7 = new java.lang.StringBuilder(r1);
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ee, code lost:
        if (r8 >= r1) goto L_0x0168;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f0, code lost:
        r9 = r4.charAt(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        if (r9 == '+') goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fc, code lost:
        if (r9 == '$') goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fe, code lost:
        if (r9 == '%') goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0100, code lost:
        if (r9 != '/') goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0103, code lost:
        r7.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0107, code lost:
        r8 = r8 + 1;
        r15 = r4.charAt(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0111, code lost:
        if (r9 == '$') goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0113, code lost:
        if (r9 == '%') goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0115, code lost:
        if (r9 == '+') goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0117, code lost:
        if (r9 == '/') goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0119, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011b, code lost:
        if (r15 < 'A') goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011f, code lost:
        if (r15 > 'O') goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0121, code lost:
        r15 = r15 - ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0124, code lost:
        if (r15 != 'Z') goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0126, code lost:
        r3 = ':';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012d, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x012e, code lost:
        if (r15 < 'A') goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0130, code lost:
        if (r15 > 'Z') goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0132, code lost:
        r15 = r15 + ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0139, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013a, code lost:
        if (r15 < 'A') goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x013e, code lost:
        if (r15 > 'E') goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0140, code lost:
        r15 = r15 - '&';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0145, code lost:
        if (r15 < 'F') goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0149, code lost:
        if (r15 > 'W') goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014b, code lost:
        r15 = r15 - 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0152, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0153, code lost:
        if (r15 < 'A') goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0155, code lost:
        if (r15 > 'Z') goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0157, code lost:
        r15 = r15 - '@';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0159, code lost:
        r3 = (char) r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015a, code lost:
        r7.append(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015d, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0167, code lost:
        throw com.xiaomi.zxing.FormatException.getFormatInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0168, code lost:
        r3 = 1;
        r1 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016e, code lost:
        r3 = 1;
        r1 = r4.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0173, code lost:
        r8 = (float) r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x019f, code lost:
        return new _m_j.idf(r1, null, new _m_j.idg[]{new _m_j.idg(((float) (r5[r3] + r5[0])) / 2.0f, r8), new _m_j.idg(((float) r6) + (((float) r10) / 2.0f), r8)}, com.xiaomi.zxing.BarcodeFormat.CODE_39);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a4, code lost:
        throw com.xiaomi.zxing.NotFoundException.getNotFoundInstance();
     */
    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int O00000o02;
        idl idl2 = idl;
        int[] iArr = this.O00000oo;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.O00000oO;
        sb.setLength(0);
        int i2 = idl2.O00000Oo;
        int O00000o03 = idl2.O00000o0(0);
        int length = iArr.length;
        int i3 = O00000o03;
        boolean z = false;
        int i4 = 0;
        while (O00000o03 < i2) {
            int i5 = 1;
            if (idl2.O000000o(O00000o03) ^ z) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                int i6 = length - 1;
                if (i4 != i6) {
                    i4++;
                } else if (O000000o(iArr) != O00000Oo || !idl2.O000000o(Math.max(0, i3 - ((O00000o03 - i3) / 2)), i3)) {
                    i3 += iArr[0] + iArr[1];
                    int i7 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i6] = 0;
                    i4--;
                } else {
                    int[] iArr2 = {i3, O00000o03};
                    int O00000o04 = idl2.O00000o0(iArr2[1]);
                    int i8 = idl2.O00000Oo;
                    while (true) {
                        O000000o(idl2, O00000o04, iArr);
                        int O000000o2 = O000000o(iArr);
                        if (O000000o2 >= 0) {
                            int i9 = 0;
                            while (true) {
                                int[] iArr3 = f1240O000000o;
                                if (i9 >= iArr3.length) {
                                    throw NotFoundException.getNotFoundInstance();
                                } else if (iArr3[i9] == O000000o2) {
                                    break;
                                } else {
                                    i9++;
                                    i5 = 1;
                                }
                            }
                        } else {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        O00000o04 = O00000o02;
                        i5 = 1;
                    }
                }
                iArr[i4] = 1;
                z = !z;
            }
            O00000o03++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int O000000o(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }
}
