package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;

public final class iel extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    static final char[] f1238O000000o = "0123456789-$:/.+ABCD".toCharArray();
    static final int[] O00000Oo = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    private static final char[] O00000o0 = {'A', 'B', 'C', 'D'};
    private final StringBuilder O00000o = new StringBuilder(20);
    private int[] O00000oO = new int[80];
    private int O00000oo = 0;

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException {
        idl idl2 = idl;
        Map<DecodeHintType, ?> map2 = map;
        Arrays.fill(this.O00000oO, 0);
        this.O00000oo = 0;
        int O00000o2 = idl2.O00000o(0);
        int i2 = idl2.O00000Oo;
        if (O00000o2 < i2) {
            int i3 = 1;
            int i4 = 0;
            boolean z = true;
            while (O00000o2 < i2) {
                if (idl2.O000000o(O00000o2) ^ z) {
                    i4++;
                } else {
                    O000000o(i4);
                    z = !z;
                    i4 = 1;
                }
                O00000o2++;
            }
            O000000o(i4);
            int i5 = 1;
            while (i5 < this.O00000oo) {
                int O00000Oo2 = O00000Oo(i5);
                if (O00000Oo2 != -1 && O000000o(O00000o0, f1238O000000o[O00000Oo2])) {
                    int i6 = 0;
                    for (int i7 = i5; i7 < i5 + 7; i7++) {
                        i6 += this.O00000oO[i7];
                    }
                    if (i5 == i3 || this.O00000oO[i5 - 1] >= i6 / 2) {
                        this.O00000o.setLength(0);
                        int i8 = i5;
                        while (true) {
                            int O00000Oo3 = O00000Oo(i8);
                            if (O00000Oo3 != -1) {
                                this.O00000o.append((char) O00000Oo3);
                                i8 += 8;
                                if ((this.O00000o.length() <= i3 || !O000000o(O00000o0, f1238O000000o[O00000Oo3])) && i8 < this.O00000oo) {
                                }
                            } else {
                                throw NotFoundException.getNotFoundInstance();
                            }
                        }
                        int i9 = i8 - 1;
                        int i10 = this.O00000oO[i9];
                        int i11 = 0;
                        for (int i12 = -8; i12 < -1; i12++) {
                            i11 += this.O00000oO[i8 + i12];
                        }
                        if (i8 >= this.O00000oo || i10 >= i11 / 2) {
                            int[] iArr = {0, 0, 0, 0};
                            int[] iArr2 = {0, 0, 0, 0};
                            int length = this.O00000o.length() - i3;
                            int i13 = i5;
                            int i14 = 0;
                            while (true) {
                                int i15 = O00000Oo[this.O00000o.charAt(i14)];
                                for (int i16 = 6; i16 >= 0; i16--) {
                                    int i17 = (i16 & 1) + ((i15 & 1) * 2);
                                    iArr[i17] = iArr[i17] + this.O00000oO[i13 + i16];
                                    iArr2[i17] = iArr2[i17] + i3;
                                    i15 >>= i3;
                                }
                                if (i14 >= length) {
                                    break;
                                }
                                i13 += 8;
                                i14++;
                            }
                            float[] fArr = new float[4];
                            float[] fArr2 = new float[4];
                            for (int i18 = 0; i18 < 2; i18++) {
                                fArr2[i18] = 0.0f;
                                int i19 = i18 + 2;
                                fArr2[i19] = ((((float) iArr[i18]) / ((float) iArr2[i18])) + (((float) iArr[i19]) / ((float) iArr2[i19]))) / 2.0f;
                                fArr[i18] = fArr2[i19];
                                fArr[i19] = ((((float) iArr[i19]) * 2.0f) + 1.5f) / ((float) iArr2[i19]);
                            }
                            int i20 = i5;
                            int i21 = 0;
                            loop8:
                            while (true) {
                                int i22 = O00000Oo[this.O00000o.charAt(i21)];
                                int i23 = 6;
                                while (i23 >= 0) {
                                    int i24 = (i23 & 1) + ((i22 & 1) * 2);
                                    float f = (float) this.O00000oO[i20 + i23];
                                    if (f >= fArr2[i24] && f <= fArr[i24]) {
                                        i22 >>= 1;
                                        i23--;
                                    }
                                }
                                if (i21 < length) {
                                    i20 += 8;
                                    i21++;
                                } else {
                                    for (int i25 = 0; i25 < this.O00000o.length(); i25++) {
                                        StringBuilder sb = this.O00000o;
                                        sb.setCharAt(i25, f1238O000000o[sb.charAt(i25)]);
                                    }
                                    if (O000000o(O00000o0, this.O00000o.charAt(0))) {
                                        StringBuilder sb2 = this.O00000o;
                                        if (!O000000o(O00000o0, sb2.charAt(sb2.length() - 1))) {
                                            throw NotFoundException.getNotFoundInstance();
                                        } else if (this.O00000o.length() > 3) {
                                            if (map2 == null || !map2.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                                                StringBuilder sb3 = this.O00000o;
                                                sb3.deleteCharAt(sb3.length() - 1);
                                                this.O00000o.deleteCharAt(0);
                                            }
                                            int i26 = 0;
                                            for (int i27 = 0; i27 < i5; i27++) {
                                                i26 += this.O00000oO[i27];
                                            }
                                            float f2 = (float) i26;
                                            while (i5 < i9) {
                                                i26 += this.O00000oO[i5];
                                                i5++;
                                            }
                                            float f3 = (float) i;
                                            return new idf(this.O00000o.toString(), null, new idg[]{new idg(f2, f3), new idg((float) i26, f3)}, BarcodeFormat.CODABAR);
                                        } else {
                                            throw NotFoundException.getNotFoundInstance();
                                        }
                                    } else {
                                        throw NotFoundException.getNotFoundInstance();
                                    }
                                }
                            }
                            throw NotFoundException.getNotFoundInstance();
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                i5 += 2;
                i3 = 1;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void O000000o(int i) {
        int[] iArr = this.O00000oO;
        int i2 = this.O00000oo;
        iArr[i2] = i;
        this.O00000oo = i2 + 1;
        int i3 = this.O00000oo;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.O00000oO = iArr2;
        }
    }

    private static boolean O000000o(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private int O00000Oo(int i) {
        int i2 = i + 7;
        if (i2 >= this.O00000oo) {
            return -1;
        }
        int[] iArr = this.O00000oO;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = NotificationCompat.FLAG_HIGH_PRIORITY;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = O00000Oo;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }
}
