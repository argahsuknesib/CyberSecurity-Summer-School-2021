package _m_j;

import com.xiaomi.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

public final class idv {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f1219O000000o = Charset.defaultCharset().name();
    private static final boolean O00000Oo = ("SJIS".equalsIgnoreCase(f1219O000000o) || "EUC_JP".equalsIgnoreCase(f1219O000000o));

    public static String O000000o(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte[] bArr2 = bArr;
        Map<DecodeHintType, ?> map2 = map;
        if (map2 != null && map2.containsKey(DecodeHintType.CHARACTER_SET)) {
            return map2.get(DecodeHintType.CHARACTER_SET).toString();
        }
        int length = bArr2.length;
        int i = 0;
        boolean z = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = true;
        boolean z3 = true;
        boolean z4 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i3 < length && (z2 || z3 || z4)) {
            byte b = bArr2[i3] & 255;
            if (z4) {
                if (i4 > 0) {
                    if ((b & 128) != 0) {
                        i4--;
                    }
                } else if ((b & 128) != 0) {
                    if ((b & 64) != 0) {
                        i4++;
                        if ((b & 32) == 0) {
                            i6++;
                        } else {
                            i4++;
                            if ((b & 16) == 0) {
                                i7++;
                            } else {
                                i4++;
                                if ((b & 8) == 0) {
                                    i8++;
                                }
                            }
                        }
                    }
                }
                z4 = false;
            }
            if (z2) {
                if (b > Byte.MAX_VALUE && b < 160) {
                    z2 = false;
                } else if (b > 159 && (b < 192 || b == 215 || b == 247)) {
                    i10++;
                }
            }
            if (z3) {
                if (i5 > 0) {
                    if (b >= 64 && b != Byte.MAX_VALUE && b <= 252) {
                        i5--;
                    }
                } else if (!(b == 128 || b == 160 || b > 239)) {
                    if (b <= 160 || b >= 224) {
                        if (b > Byte.MAX_VALUE) {
                            i5++;
                            int i13 = i11 + 1;
                            if (i13 > i) {
                                i = i13;
                                i11 = i;
                            } else {
                                i11 = i13;
                            }
                        } else {
                            i11 = 0;
                        }
                        i12 = 0;
                    } else {
                        i2++;
                        int i14 = i12 + 1;
                        if (i14 > i9) {
                            i9 = i14;
                            i12 = i9;
                        } else {
                            i12 = i14;
                        }
                        i11 = 0;
                    }
                }
                z3 = false;
            }
            i3++;
            bArr2 = bArr;
        }
        if (z4 && i4 > 0) {
            z4 = false;
        }
        if (z3 && i5 > 0) {
            z3 = false;
        }
        if (z4 && (z || i6 + i7 + i8 > 0)) {
            return "UTF8";
        }
        if (z3 && (O00000Oo || i9 >= 3 || i >= 3)) {
            return "SJIS";
        }
        if (!z2 || !z3) {
            if (z2) {
                return "ISO8859_1";
            }
            if (z3) {
                return "SJIS";
            }
            if (z4) {
                return "UTF8";
            }
            return f1219O000000o;
        } else if ((i9 != 2 || i2 != 2) && i10 * 10 < length) {
            return "ISO8859_1";
        } else {
            return "SJIS";
        }
    }
}
