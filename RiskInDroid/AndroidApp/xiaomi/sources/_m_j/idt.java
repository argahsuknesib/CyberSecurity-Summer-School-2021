package _m_j;

import com.xiaomi.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class idt extends idr {
    private idm O00000Oo;

    private static int O000000o(int i, int i2) {
        if (i < 2) {
            return 2;
        }
        return i > i2 ? i2 : i;
    }

    public idt(ida ida) {
        super(ida);
    }

    public final idm O000000o() throws NotFoundException {
        idm idm = this.O00000Oo;
        if (idm != null) {
            return idm;
        }
        ida ida = this.f1203O000000o;
        int i = ida.f1206O000000o;
        int i2 = ida.O00000Oo;
        if (i < 40 || i2 < 40) {
            this.O00000Oo = super.O000000o();
        } else {
            byte[] O000000o2 = ida.O000000o();
            int i3 = i >> 3;
            if ((i & 7) != 0) {
                i3++;
            }
            int i4 = i2 >> 3;
            if ((i2 & 7) != 0) {
                i4++;
            }
            int[][] iArr = (int[][]) Array.newInstance(int.class, i4, i3);
            int i5 = 0;
            while (true) {
                int i6 = 8;
                if (i5 >= i4) {
                    break;
                }
                int i7 = i5 << 3;
                int i8 = i2 - 8;
                if (i7 > i8) {
                    i7 = i8;
                }
                int i9 = 0;
                while (i9 < i3) {
                    int i10 = i9 << 3;
                    int i11 = i - 8;
                    if (i10 <= i11) {
                        i11 = i10;
                    }
                    int i12 = (i7 * i) + i11;
                    byte b = 255;
                    int i13 = 0;
                    int i14 = 0;
                    byte b2 = 0;
                    while (i13 < i6) {
                        byte b3 = b;
                        int i15 = 0;
                        byte b4 = b2;
                        int i16 = i14;
                        byte b5 = b4;
                        while (i15 < i6) {
                            byte b6 = O000000o2[i12 + i15] & 255;
                            i16 += b6;
                            if (b6 < b3) {
                                b3 = b6;
                            }
                            if (b6 > b5) {
                                b5 = b6;
                            }
                            i15++;
                            i6 = 8;
                        }
                        if (b5 - b3 <= 24) {
                            i13++;
                            i12 += i;
                            b = b3;
                            i6 = 8;
                            int i17 = i16;
                            b2 = b5;
                            i14 = i17;
                        }
                        while (true) {
                            i13++;
                            i12 += i;
                            if (i13 >= 8) {
                                break;
                            }
                            int i18 = 0;
                            for (int i19 = 8; i18 < i19; i19 = 8) {
                                i16 += O000000o2[i12 + i18] & 255;
                                i18++;
                            }
                        }
                        i13++;
                        i12 += i;
                        b = b3;
                        i6 = 8;
                        int i172 = i16;
                        b2 = b5;
                        i14 = i172;
                    }
                    int i20 = i14 >> 6;
                    if (b2 - b <= 24) {
                        i20 = b / 2;
                        if (i5 > 0 && i9 > 0) {
                            int i21 = i5 - 1;
                            int i22 = i9 - 1;
                            int i23 = ((iArr[i21][i9] + (iArr[i5][i22] * 2)) + iArr[i21][i22]) / 4;
                            if (b < i23) {
                                i20 = i23;
                            }
                        }
                    }
                    iArr[i5][i9] = i20;
                    i9++;
                    i6 = 8;
                }
                i5++;
            }
            idm idm2 = new idm(i, i2);
            for (int i24 = 0; i24 < i4; i24++) {
                int i25 = i24 << 3;
                int i26 = i2 - 8;
                if (i25 > i26) {
                    i25 = i26;
                }
                for (int i27 = 0; i27 < i3; i27++) {
                    int i28 = i27 << 3;
                    int i29 = i - 8;
                    if (i28 > i29) {
                        i28 = i29;
                    }
                    int O000000o3 = O000000o(i27, i3 - 3);
                    int O000000o4 = O000000o(i24, i4 - 3);
                    int i30 = -2;
                    int i31 = 0;
                    for (int i32 = 2; i30 <= i32; i32 = 2) {
                        int[] iArr2 = iArr[O000000o4 + i30];
                        i31 += iArr2[O000000o3 - 2] + iArr2[O000000o3 - 1] + iArr2[O000000o3] + iArr2[O000000o3 + 1] + iArr2[O000000o3 + 2];
                        i30++;
                    }
                    int i33 = i31 / 25;
                    int i34 = (i25 * i) + i28;
                    int i35 = 0;
                    while (true) {
                        if (i35 >= 8) {
                            break;
                        }
                        int i36 = i2;
                        int i37 = 0;
                        for (int i38 = 8; i37 < i38; i38 = 8) {
                            byte[] bArr = O000000o2;
                            if ((O000000o2[i34 + i37] & 255) <= i33) {
                                idm2.O00000Oo(i28 + i37, i25 + i35);
                            }
                            i37++;
                            O000000o2 = bArr;
                        }
                        i35++;
                        i34 += i;
                        i2 = i36;
                    }
                }
            }
            this.O00000Oo = idm2;
        }
        return this.O00000Oo;
    }

    public final icx O000000o(ida ida) {
        return new idt(ida);
    }
}
