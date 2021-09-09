package _m_j;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

final class czi {
    static void O000000o(float f, float f2, O00000Oo[] o00000OoArr) {
        for (O00000Oo o00000Oo : o00000OoArr) {
            char c = o00000Oo.f14407O000000o;
            float[] fArr = o00000Oo.O00000Oo;
            int i = 2;
            switch (c) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
            }
            for (int i2 = 0; i2 < fArr.length; i2 += i) {
                if (c != 'A') {
                    if (c != 'C') {
                        if (c != 'H') {
                            if (c != 'Q') {
                                if (c != 'V') {
                                    if (c != 'a') {
                                        if (c != 'c') {
                                            if (c != 'h') {
                                                if (c != 'q') {
                                                    if (c != 'v') {
                                                        if (!(c == 'L' || c == 'M')) {
                                                            if (c != 'S') {
                                                                if (!(c == 'T' || c == 'l' || c == 'm')) {
                                                                    if (c != 's') {
                                                                        if (c != 't') {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        fArr[i2] = fArr[i2] * f;
                                                        int i3 = i2 + 1;
                                                        fArr[i3] = fArr[i3] * f2;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                fArr[i2] = fArr[i2] * f2;
                            }
                            fArr[i2] = fArr[i2] * f;
                            int i4 = i2 + 1;
                            fArr[i4] = fArr[i4] * f2;
                            int i5 = i2 + 2;
                            fArr[i5] = fArr[i5] * f;
                            int i6 = i2 + 3;
                            fArr[i6] = fArr[i6] * f2;
                        }
                        fArr[i2] = fArr[i2] * f;
                    }
                    fArr[i2] = fArr[i2] * f;
                    int i7 = i2 + 1;
                    fArr[i7] = fArr[i7] * f2;
                    int i8 = i2 + 2;
                    fArr[i8] = fArr[i8] * f;
                    int i9 = i2 + 3;
                    fArr[i9] = fArr[i9] * f2;
                    int i10 = i2 + 4;
                    fArr[i10] = fArr[i10] * f;
                    int i11 = i2 + 5;
                    fArr[i11] = fArr[i11] * f2;
                }
                fArr[i2] = fArr[i2] * f;
                int i12 = i2 + 1;
                fArr[i12] = fArr[i12] * f2;
                int i13 = i2 + 5;
                fArr[i13] = fArr[i13] * f;
                int i14 = i2 + 6;
                fArr[i14] = fArr[i14] * f2;
            }
        }
    }

    public static Path O000000o(String str) {
        Path path = new Path();
        O00000Oo[] O00000Oo2 = O00000Oo(str);
        if (O00000Oo2 == null) {
            return null;
        }
        try {
            O00000Oo.O000000o(O00000Oo2, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing ".concat(String.valueOf(str)), e);
        }
    }

    public static O00000Oo[] O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int O000000o2 = O000000o(str, i);
            String trim = str.substring(i2, O000000o2).trim();
            if (trim.length() > 0) {
                O000000o(arrayList, trim.charAt(0), O00000o0(trim));
            }
            i2 = O000000o2;
            i = O000000o2 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            O000000o(arrayList, str.charAt(i2), new float[0]);
        }
        return (O00000Oo[]) arrayList.toArray(new O00000Oo[arrayList.size()]);
    }

    private static int O000000o(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    private static void O000000o(List<O00000Oo> list, char c, float[] fArr) {
        list.add(new O00000Oo(c, fArr));
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14406O000000o;
        boolean O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[Catch:{ NumberFormatException -> 0x0094 }, LOOP:1: B:16:0x0037->B:36:0x0068, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071 A[Catch:{ NumberFormatException -> 0x0094 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0082 A[Catch:{ NumberFormatException -> 0x0094 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0084 A[Catch:{ NumberFormatException -> 0x0094 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x006b A[SYNTHETIC] */
    private static float[] O00000o0(String str) {
        int i;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            O000000o o000000o = new O000000o((byte) 0);
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                o000000o.O00000Oo = false;
                int i4 = i2;
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                while (i4 < str.length()) {
                    char charAt = str.charAt(i4);
                    if (charAt != ' ') {
                        if (charAt == 'E' || charAt == 'e') {
                            z = true;
                            if (!z3) {
                                i4++;
                            } else {
                                o000000o.f14406O000000o = i4;
                                i = o000000o.f14406O000000o;
                                if (i2 < i) {
                                    fArr[i3] = Float.parseFloat(str.substring(i2, i));
                                    i3++;
                                }
                                i2 = !o000000o.O00000Oo ? i : i + 1;
                            }
                        } else {
                            switch (charAt) {
                                case ',':
                                    break;
                                case '-':
                                    if (i4 != i2 && !z) {
                                        o000000o.O00000Oo = true;
                                        break;
                                    }
                                    z = false;
                                    break;
                                case '.':
                                    if (z2) {
                                        o000000o.O00000Oo = true;
                                        break;
                                    } else {
                                        z = false;
                                        z2 = true;
                                        break;
                                    }
                                default:
                                    z = false;
                                    break;
                            }
                            if (!z3) {
                            }
                        }
                    }
                    z = false;
                    z3 = true;
                    if (!z3) {
                    }
                }
                o000000o.f14406O000000o = i4;
                i = o000000o.f14406O000000o;
                if (i2 < i) {
                }
                if (!o000000o.O00000Oo) {
                }
            }
            int i5 = i3 - 0;
            float[] fArr2 = new float[i5];
            System.arraycopy(fArr, 0, fArr2, 0, Math.min(i5, fArr.length - 0));
            return fArr2;
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + jdn.f1779O000000o, e);
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        char f14407O000000o;
        float[] O00000Oo;

        O00000Oo(char c, float[] fArr) {
            this.f14407O000000o = c;
            this.O00000Oo = fArr;
        }

        /* JADX WARN: Failed to insert an additional move for type inference into block B:139:0x03fc */
        /* JADX WARN: Failed to insert an additional move for type inference into block B:145:0x03fc */
        /* JADX WARN: Failed to insert an additional move for type inference into block B:143:0x03fc */
        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX INFO: additional move instructions added (2) to help type inference */
        /* JADX WARN: Type inference failed for: r30v1 */
        /* JADX WARN: Type inference failed for: r30v6 */
        /* JADX WARN: Type inference failed for: r30v7 */
        /* JADX WARN: Type inference failed for: r30v8 */
        /* JADX WARN: Type inference failed for: r30v9 */
        /* JADX WARN: Type inference failed for: r26v8 */
        /* JADX WARN: Type inference failed for: r30v10 */
        /* JADX WARN: Type inference failed for: r30v12 */
        /* JADX WARN: Type inference failed for: r26v14 */
        /* JADX WARN: Type inference failed for: r30v19 */
        /* JADX WARN: Type inference failed for: r30v20 */
        /* JADX WARN: Type inference failed for: r30v23 */
        /* JADX WARN: Type inference failed for: r30v24 */
        /* JADX WARN: Type inference failed for: r30v25 */
        /* JADX WARN: Type inference failed for: r26v26 */
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        public static void O000000o(O00000Oo[] o00000OoArr, Path path) {
            int i;
            O00000Oo o00000Oo;
            Object obj;
            int i2;
            char c;
            float[] fArr;
            int i3;
            float[] fArr2;
            float[] fArr3;
            int i4;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float[] fArr4;
            ? r30;
            int i5;
            float[] fArr5;
            Object obj2;
            float f6;
            float f7;
            Object obj3;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            O00000Oo[] o00000OoArr2 = o00000OoArr;
            Path path2 = path;
            float[] fArr6 = new float[6];
            int length = o00000OoArr2.length;
            char c2 = 0;
            char c3 = 'm';
            int i6 = 0;
            while (i6 < length) {
                O00000Oo o00000Oo2 = o00000OoArr2[i6];
                char c4 = o00000Oo2.f14407O000000o;
                float[] fArr7 = o00000Oo2.O00000Oo;
                float f15 = fArr6[c2];
                float f16 = fArr6[1];
                float f17 = fArr6[2];
                float f18 = fArr6[3];
                float f19 = fArr6[4];
                float f20 = fArr6[5];
                switch (c4) {
                    case 'A':
                    case 'a':
                        i = 7;
                        break;
                    case 'C':
                    case 'c':
                        i = 6;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        i = 1;
                        break;
                    case 'L':
                    case 'M':
                    case 'T':
                    case 'l':
                    case 'm':
                    case 't':
                    default:
                        i = 2;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        i = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path2.moveTo(f19, f20);
                        f15 = f19;
                        f17 = f15;
                        f16 = f20;
                        f18 = f16;
                        i = 2;
                        break;
                }
                float f21 = f19;
                float f22 = f20;
                int i7 = 0;
                float f23 = f15;
                char c5 = c3;
                float f24 = f18;
                float f25 = f16;
                while (i7 < fArr7.length) {
                    if (c4 != 'A') {
                        if (c4 == 'C') {
                            fArr = fArr7;
                            c = c4;
                            o00000Oo = o00000Oo2;
                            i3 = i6;
                            obj = fArr6;
                            i2 = length;
                            int i8 = i7 + 2;
                            int i9 = i7 + 3;
                            int i10 = i7 + 4;
                            int i11 = i7 + 5;
                            path.cubicTo(fArr[i7 + 0], fArr[i7 + 1], fArr[i8], fArr[i9], fArr[i10], fArr[i11]);
                            f23 = fArr[i10];
                            f25 = fArr[i11];
                            float f26 = fArr[i8];
                            f24 = fArr[i9];
                            f17 = f26;
                        } else if (c4 == 'H') {
                            fArr = fArr7;
                            c = c4;
                            o00000Oo = o00000Oo2;
                            i3 = i6;
                            obj = fArr6;
                            i2 = length;
                            int i12 = i7 + 0;
                            path2.lineTo(fArr[i12], f25);
                            f23 = fArr[i12];
                        } else if (c4 == 'Q') {
                            fArr = fArr7;
                            c = c4;
                            o00000Oo = o00000Oo2;
                            i3 = i6;
                            obj = fArr6;
                            i2 = length;
                            int i13 = i7 + 0;
                            int i14 = i7 + 1;
                            int i15 = i7 + 2;
                            int i16 = i7 + 3;
                            path2.quadTo(fArr[i13], fArr[i14], fArr[i15], fArr[i16]);
                            float f27 = fArr[i13];
                            f24 = fArr[i14];
                            float f28 = fArr[i15];
                            f25 = fArr[i16];
                            f17 = f27;
                            f23 = f28;
                        } else if (c4 == 'V') {
                            fArr = fArr7;
                            c = c4;
                            o00000Oo = o00000Oo2;
                            i3 = i6;
                            obj = fArr6;
                            i2 = length;
                            int i17 = i7 + 0;
                            path2.lineTo(f23, fArr[i17]);
                            f25 = fArr[i17];
                        } else if (c4 != 'a') {
                            if (c4 != 'c') {
                                if (c4 == 'h') {
                                    fArr = fArr7;
                                    obj = fArr6;
                                    i2 = length;
                                    int i18 = i7 + 0;
                                    path2.rLineTo(fArr[i18], 0.0f);
                                    f23 += fArr[i18];
                                } else if (c4 != 'q') {
                                    if (c4 == 'v') {
                                        fArr5 = fArr7;
                                        obj2 = fArr6;
                                        i2 = length;
                                        f6 = f25;
                                        int i19 = i7 + 0;
                                        path2.rLineTo(0.0f, fArr5[i19]);
                                        f7 = fArr5[i19];
                                    } else if (c4 != 'L') {
                                        if (c4 == 'M') {
                                            fArr = fArr7;
                                            Object obj4 = fArr6;
                                            i2 = length;
                                            int i20 = i7 + 0;
                                            f23 = fArr[i20];
                                            int i21 = i7 + 1;
                                            f25 = fArr[i21];
                                            if (i7 > 0) {
                                                path2.lineTo(fArr[i20], fArr[i21]);
                                                obj = obj4;
                                            } else {
                                                path2.moveTo(fArr[i20], fArr[i21]);
                                                obj3 = obj4;
                                            }
                                        } else if (c4 == 'S') {
                                            fArr = fArr7;
                                            obj = fArr6;
                                            i2 = length;
                                            float f29 = f25;
                                            float f30 = f23;
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                f8 = (f29 * 2.0f) - f24;
                                                f9 = (f30 * 2.0f) - f17;
                                            } else {
                                                f9 = f30;
                                                f8 = f29;
                                            }
                                            int i22 = i7 + 0;
                                            int i23 = i7 + 1;
                                            int i24 = i7 + 2;
                                            int i25 = i7 + 3;
                                            path.cubicTo(f9, f8, fArr[i22], fArr[i23], fArr[i24], fArr[i25]);
                                            float f31 = fArr[i22];
                                            f24 = fArr[i23];
                                            f23 = fArr[i24];
                                            f25 = fArr[i25];
                                            f17 = f31;
                                        } else if (c4 == 'T') {
                                            fArr = fArr7;
                                            obj = fArr6;
                                            i2 = length;
                                            float f32 = f25;
                                            float f33 = f23;
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f10 = (f33 * 2.0f) - f17;
                                                f32 = (f32 * 2.0f) - f24;
                                            } else {
                                                f10 = f33;
                                            }
                                            int i26 = i7 + 0;
                                            int i27 = i7 + 1;
                                            path2.quadTo(f10, f32, fArr[i26], fArr[i27]);
                                            float f34 = fArr[i26];
                                            f25 = fArr[i27];
                                            f17 = f10;
                                            c = c4;
                                            o00000Oo = o00000Oo2;
                                            i3 = i6;
                                            f24 = f32;
                                            f23 = f34;
                                        } else if (c4 == 'l') {
                                            fArr5 = fArr7;
                                            obj2 = fArr6;
                                            i2 = length;
                                            f6 = f25;
                                            int i28 = i7 + 0;
                                            int i29 = i7 + 1;
                                            path2.rLineTo(fArr5[i28], fArr5[i29]);
                                            f23 += fArr5[i28];
                                            f7 = fArr5[i29];
                                        } else if (c4 == 'm') {
                                            fArr = fArr7;
                                            Object obj5 = fArr6;
                                            i2 = length;
                                            int i30 = i7 + 0;
                                            f23 += fArr[i30];
                                            int i31 = i7 + 1;
                                            f25 += fArr[i31];
                                            if (i7 > 0) {
                                                path2.rLineTo(fArr[i30], fArr[i31]);
                                                obj = obj5;
                                            } else {
                                                path2.rMoveTo(fArr[i30], fArr[i31]);
                                                obj3 = obj5;
                                            }
                                        } else if (c4 == 's') {
                                            if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                                f12 = f23 - f17;
                                                f11 = f25 - f24;
                                            } else {
                                                f12 = 0.0f;
                                                f11 = 0.0f;
                                            }
                                            int i32 = i7 + 0;
                                            int i33 = i7 + 1;
                                            int i34 = i7 + 2;
                                            int i35 = i7 + 3;
                                            i5 = length;
                                            f = f25;
                                            r30 = fArr6;
                                            float f35 = f23;
                                            fArr4 = fArr7;
                                            path.rCubicTo(f12, f11, fArr7[i32], fArr7[i33], fArr7[i34], fArr7[i35]);
                                            f2 = f35 + fArr4[i32];
                                            f3 = f + fArr4[i33];
                                            f5 = fArr4[i34] + f35;
                                            f4 = fArr4[i35];
                                        } else if (c4 != 't') {
                                            fArr = fArr7;
                                            c = c4;
                                            o00000Oo = o00000Oo2;
                                            i3 = i6;
                                            obj = fArr6;
                                            i2 = length;
                                        } else {
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f13 = f23 - f17;
                                                f14 = f25 - f24;
                                            } else {
                                                f14 = 0;
                                                f13 = 0;
                                            }
                                            int i36 = i7 + 0;
                                            int i37 = i7 + 1;
                                            path2.rQuadTo(f13, f14, fArr7[i36], fArr7[i37]);
                                            float f36 = f13 + f23;
                                            f24 = f14 + f25;
                                            f23 += fArr7[i36];
                                            f25 += fArr7[i37];
                                            fArr = fArr7;
                                            c = c4;
                                            o00000Oo = o00000Oo2;
                                            i3 = i6;
                                            obj = fArr6;
                                            i2 = length;
                                            f17 = f36;
                                        }
                                        f22 = f25;
                                        f21 = f23;
                                        obj = obj3;
                                    } else {
                                        fArr = fArr7;
                                        obj = fArr6;
                                        i2 = length;
                                        int i38 = i7 + 0;
                                        int i39 = i7 + 1;
                                        path2.lineTo(fArr[i38], fArr[i39]);
                                        f23 = fArr[i38];
                                        f25 = fArr[i39];
                                    }
                                    f25 = f6 + f7;
                                    obj = obj2;
                                    fArr = fArr5;
                                } else {
                                    fArr = fArr7;
                                    obj = fArr6;
                                    i2 = length;
                                    float f37 = f25;
                                    float f38 = f23;
                                    int i40 = i7 + 0;
                                    int i41 = i7 + 1;
                                    int i42 = i7 + 2;
                                    int i43 = i7 + 3;
                                    path2.rQuadTo(fArr[i40], fArr[i41], fArr[i42], fArr[i43]);
                                    float f39 = f37 + fArr[i41];
                                    f17 = fArr[i40] + f38;
                                    f23 = fArr[i42] + f38;
                                    f24 = f39;
                                    c = c4;
                                    o00000Oo = o00000Oo2;
                                    i3 = i6;
                                    f25 = fArr[i43] + f37;
                                }
                                c = c4;
                                o00000Oo = o00000Oo2;
                                i3 = i6;
                            } else {
                                fArr4 = fArr7;
                                r30 = fArr6;
                                i5 = length;
                                f = f25;
                                float f40 = f23;
                                int i44 = i7 + 2;
                                int i45 = i7 + 3;
                                int i46 = i7 + 4;
                                int i47 = i7 + 5;
                                path.rCubicTo(fArr4[i7 + 0], fArr4[i7 + 1], fArr4[i44], fArr4[i45], fArr4[i46], fArr4[i47]);
                                f2 = f40 + fArr4[i44];
                                f3 = f + fArr4[i45];
                                f5 = fArr4[i46] + f40;
                                f4 = fArr4[i47];
                            }
                            f17 = f2;
                            c = c4;
                            o00000Oo = o00000Oo2;
                            i3 = i6;
                            f23 = f5;
                            float f41 = f3;
                            f25 = f4 + f;
                            f24 = f41;
                        } else {
                            fArr2 = fArr7;
                            fArr3 = fArr6;
                            i4 = length;
                            float f42 = f25;
                            float f43 = f23;
                            int i48 = i7 + 5;
                            int i49 = i7 + 6;
                            c = c4;
                            o00000Oo = o00000Oo2;
                            i3 = i6;
                            O000000o(path, f43, f42, fArr2[i48] + f43, fArr2[i49] + f42, fArr2[i7 + 0], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f, fArr2[i7 + 4] != 0.0f);
                            f23 = f43 + fArr2[i48];
                            f25 = f42 + fArr2[i49];
                        }
                        i7 += i;
                        i6 = i3;
                        fArr7 = fArr;
                        c5 = c;
                        c4 = c5;
                        length = i2;
                        fArr6 = obj;
                        o00000Oo2 = o00000Oo;
                    } else {
                        fArr2 = fArr7;
                        c = c4;
                        o00000Oo = o00000Oo2;
                        i3 = i6;
                        fArr3 = fArr6;
                        i4 = length;
                        int i50 = i7 + 5;
                        int i51 = i7 + 6;
                        O000000o(path, f23, f25, fArr2[i50], fArr2[i51], fArr2[i7 + 0], fArr2[i7 + 1], fArr2[i7 + 2], fArr2[i7 + 3] != 0.0f, fArr2[i7 + 4] != 0.0f);
                        f23 = fArr2[i50];
                        f25 = fArr2[i51];
                    }
                    f24 = f25;
                    f17 = f23;
                    i7 += i;
                    i6 = i3;
                    fArr7 = fArr;
                    c5 = c;
                    c4 = c5;
                    length = i2;
                    fArr6 = obj;
                    o00000Oo2 = o00000Oo;
                }
                float[] fArr8 = fArr6;
                fArr8[0] = f23;
                fArr8[1] = f25;
                fArr8[2] = f17;
                fArr8[3] = f24;
                fArr8[4] = f21;
                fArr8[5] = f22;
                c3 = o00000Oo2.f14407O000000o;
                i6++;
                c2 = 0;
                o00000OoArr2 = o00000OoArr;
                length = length;
                fArr6 = fArr8;
            }
        }

        private static void O000000o(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            float f8 = f;
            float f9 = f3;
            float f10 = f5;
            float f11 = f6;
            float f12 = f7;
            while (true) {
                double radians = Math.toRadians((double) f12);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d3 = (double) f8;
                Double.isNaN(d3);
                double d4 = d3 * cos;
                double d5 = d3;
                double d6 = (double) f2;
                Double.isNaN(d6);
                double d7 = (double) f10;
                Double.isNaN(d7);
                double d8 = (d4 + (d6 * sin)) / d7;
                double d9 = (double) (-f8);
                Double.isNaN(d9);
                Double.isNaN(d6);
                double d10 = (d9 * sin) + (d6 * cos);
                double d11 = d6;
                double d12 = (double) f11;
                Double.isNaN(d12);
                float f13 = f10;
                float f14 = f11;
                double d13 = (double) f9;
                Double.isNaN(d13);
                double d14 = d10 / d12;
                double d15 = (double) f4;
                Double.isNaN(d15);
                Double.isNaN(d7);
                double d16 = ((d13 * cos) + (d15 * sin)) / d7;
                double d17 = (double) (-f9);
                Double.isNaN(d17);
                Double.isNaN(d15);
                Double.isNaN(d12);
                double d18 = ((d17 * sin) + (d15 * cos)) / d12;
                double d19 = d8 - d16;
                double d20 = d14 - d18;
                double d21 = (d8 + d16) / 2.0d;
                double d22 = (d14 + d18) / 2.0d;
                double d23 = (d19 * d19) + (d20 * d20);
                if (d23 != 0.0d) {
                    double d24 = (1.0d / d23) - 0.25d;
                    if (d24 < 0.0d) {
                        float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
                        f10 = f13 * sqrt;
                        f11 = f14 * sqrt;
                        f8 = f;
                        f9 = f3;
                        f12 = f7;
                    } else {
                        double sqrt2 = Math.sqrt(d24);
                        double d25 = d19 * sqrt2;
                        double d26 = sqrt2 * d20;
                        double d27 = d7;
                        boolean z3 = z2;
                        if (z == z3) {
                            d2 = d21 - d26;
                            d = d22 + d25;
                        } else {
                            d2 = d21 + d26;
                            d = d22 - d25;
                        }
                        double d28 = sin;
                        double atan2 = Math.atan2(d14 - d, d8 - d2);
                        double atan22 = Math.atan2(d18 - d, d16 - d2) - atan2;
                        if (z3 != (atan22 >= 0.0d)) {
                            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
                        }
                        Double.isNaN(d27);
                        double d29 = d2 * d27;
                        Double.isNaN(d12);
                        double d30 = d * d12;
                        O000000o(path, (d29 * cos) - (d30 * d28), (d29 * d28) + (d30 * cos), d27, d12, d5, d11, radians, atan2, atan22);
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        private static void O000000o(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = (double) ceil;
            Double.isNaN(d18);
            double d19 = d9 / d18;
            double d20 = d5;
            double d21 = d6;
            double d22 = d17;
            double d23 = d14;
            int i = 0;
            double d24 = d8;
            while (i < ceil) {
                double d25 = d24 + d19;
                double sin3 = Math.sin(d25);
                double cos3 = Math.cos(d25);
                double d26 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                double d27 = d2 + (d10 * sin * cos3) + (d16 * sin3);
                double d28 = (d12 * sin3) - (d13 * cos3);
                double d29 = (sin3 * d15) + (cos3 * d16);
                double d30 = d25 - d24;
                double tan = Math.tan(d30 / 2.0d);
                double sin4 = (Math.sin(d30) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                int i2 = ceil;
                double d31 = cos;
                path.rLineTo(0.0f, 0.0f);
                float f = (float) (d21 + (d22 * sin4));
                float f2 = (float) (d26 - (sin4 * d28));
                path.cubicTo((float) (d20 + (d23 * sin4)), f, f2, (float) (d27 - (sin4 * d29)), (float) d26, (float) d27);
                i++;
                d19 = d19;
                ceil = i2;
                sin = sin;
                d21 = d27;
                d15 = d15;
                d24 = d25;
                d22 = d29;
                d23 = d28;
                cos = d31;
                d10 = d3;
                d20 = d26;
            }
        }
    }
}
