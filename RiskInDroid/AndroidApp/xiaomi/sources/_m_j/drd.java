package _m_j;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

@TargetApi(14)
public class drd {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f14865O000000o = "drd";

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

    private static O00000Oo[] O00000Oo(String str) {
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

    private static void O000000o(ArrayList<O00000Oo> arrayList, char c, float[] fArr) {
        arrayList.add(new O00000Oo(c, fArr, (byte) 0));
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14866O000000o;
        boolean O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005e A[Catch:{ NumberFormatException -> 0x0082 }, LOOP:1: B:8:0x002d->B:28:0x005e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0067 A[Catch:{ NumberFormatException -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0078 A[Catch:{ NumberFormatException -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a A[Catch:{ NumberFormatException -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0061 A[SYNTHETIC] */
    private static float[] O00000o0(String str) {
        int i;
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
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
                                o000000o.f14866O000000o = i4;
                                i = o000000o.f14866O000000o;
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
                o000000o.f14866O000000o = i4;
                i = o000000o.f14866O000000o;
                if (i2 < i) {
                }
                if (!o000000o.O00000Oo) {
                }
            }
            return Arrays.copyOf(fArr, i3);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + jdn.f1779O000000o, e);
        }
    }

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public char f14867O000000o;
        public float[] O00000Oo;

        /* synthetic */ O00000Oo(char c, float[] fArr, byte b) {
            this(c, fArr);
        }

        private O00000Oo(char c, float[] fArr) {
            this.f14867O000000o = c;
            this.O00000Oo = fArr;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public static void O000000o(O00000Oo[] o00000OoArr, Path path) {
            int i;
            char c;
            int i2;
            int i3;
            float[] fArr;
            int i4;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            int i5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            O00000Oo[] o00000OoArr2 = o00000OoArr;
            Path path2 = path;
            float[] fArr2 = new float[6];
            char c2 = 0;
            char c3 = 'm';
            int i6 = 0;
            while (i6 < o00000OoArr2.length) {
                char c4 = o00000OoArr2[i6].f14867O000000o;
                float[] fArr3 = o00000OoArr2[i6].O00000Oo;
                float f14 = fArr2[c2];
                float f15 = fArr2[1];
                float f16 = fArr2[2];
                float f17 = fArr2[3];
                float f18 = fArr2[4];
                float f19 = fArr2[5];
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
                        path2.moveTo(f18, f19);
                        f14 = f18;
                        f16 = f14;
                        f15 = f19;
                        f17 = f15;
                        i = 2;
                        break;
                }
                float f20 = f18;
                float f21 = f19;
                int i7 = 0;
                float f22 = f14;
                float f23 = f15;
                while (i7 < fArr3.length) {
                    if (c4 != 'A') {
                        if (c4 == 'C') {
                            i3 = i7;
                            fArr = fArr3;
                            c = c4;
                            i2 = i6;
                            int i8 = i3 + 2;
                            int i9 = i3 + 3;
                            int i10 = i3 + 4;
                            int i11 = i3 + 5;
                            path.cubicTo(fArr[i3 + 0], fArr[i3 + 1], fArr[i8], fArr[i9], fArr[i10], fArr[i11]);
                            f22 = fArr[i10];
                            f23 = fArr[i11];
                            float f24 = fArr[i8];
                            f17 = fArr[i9];
                            f16 = f24;
                        } else if (c4 == 'H') {
                            i3 = i7;
                            fArr = fArr3;
                            c = c4;
                            i2 = i6;
                            int i12 = i3 + 0;
                            path2.lineTo(fArr[i12], f23);
                            f22 = fArr[i12];
                        } else if (c4 == 'Q') {
                            i3 = i7;
                            fArr = fArr3;
                            c = c4;
                            i2 = i6;
                            int i13 = i3 + 0;
                            int i14 = i3 + 1;
                            int i15 = i3 + 2;
                            int i16 = i3 + 3;
                            path2.quadTo(fArr[i13], fArr[i14], fArr[i15], fArr[i16]);
                            float f25 = fArr[i13];
                            float f26 = fArr[i14];
                            f22 = fArr[i15];
                            f23 = fArr[i16];
                            f16 = f25;
                            f17 = f26;
                        } else if (c4 == 'V') {
                            i3 = i7;
                            fArr = fArr3;
                            c = c4;
                            i2 = i6;
                            int i17 = i3 + 0;
                            path2.lineTo(f22, fArr[i17]);
                            f23 = fArr[i17];
                        } else if (c4 != 'a') {
                            if (c4 != 'c') {
                                if (c4 == 'h') {
                                    i2 = i6;
                                    int i18 = i7 + 0;
                                    path2.rLineTo(fArr3[i18], 0.0f);
                                    f22 += fArr3[i18];
                                } else if (c4 != 'q') {
                                    if (c4 == 'v') {
                                        f6 = f23;
                                        i2 = i6;
                                        int i19 = i7 + 0;
                                        path2.rLineTo(0.0f, fArr3[i19]);
                                        f7 = fArr3[i19];
                                    } else if (c4 != 'L') {
                                        if (c4 == 'M') {
                                            i2 = i6;
                                            int i20 = i7 + 0;
                                            f22 = fArr3[i20];
                                            int i21 = i7 + 1;
                                            f23 = fArr3[i21];
                                            if (i7 > 0) {
                                                path2.lineTo(fArr3[i20], fArr3[i21]);
                                            } else {
                                                path2.moveTo(fArr3[i20], fArr3[i21]);
                                            }
                                        } else if (c4 == 'S') {
                                            float f27 = f23;
                                            i2 = i6;
                                            float f28 = f22;
                                            if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                                f8 = (f27 * 2.0f) - f17;
                                                f9 = (f28 * 2.0f) - f16;
                                            } else {
                                                f8 = f27;
                                                f9 = f28;
                                            }
                                            int i22 = i7 + 0;
                                            int i23 = i7 + 1;
                                            int i24 = i7 + 2;
                                            int i25 = i7 + 3;
                                            path.cubicTo(f9, f8, fArr3[i22], fArr3[i23], fArr3[i24], fArr3[i25]);
                                            float f29 = fArr3[i22];
                                            float f30 = fArr3[i23];
                                            f22 = fArr3[i24];
                                            f23 = fArr3[i25];
                                            f16 = f29;
                                            f17 = f30;
                                        } else if (c4 == 'T') {
                                            float f31 = f23;
                                            i2 = i6;
                                            float f32 = f22;
                                            if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                                f31 = (f31 * 2.0f) - f17;
                                                f32 = (f32 * 2.0f) - f16;
                                            }
                                            int i26 = i7 + 0;
                                            int i27 = i7 + 1;
                                            path2.quadTo(f32, f31, fArr3[i26], fArr3[i27]);
                                            f22 = fArr3[i26];
                                            f23 = fArr3[i27];
                                            f17 = f31;
                                            i3 = i7;
                                            fArr = fArr3;
                                            c = c4;
                                            f16 = f32;
                                        } else if (c4 == 'l') {
                                            f6 = f23;
                                            i2 = i6;
                                            int i28 = i7 + 0;
                                            int i29 = i7 + 1;
                                            path2.rLineTo(fArr3[i28], fArr3[i29]);
                                            f22 += fArr3[i28];
                                            f7 = fArr3[i29];
                                        } else if (c4 == 'm') {
                                            i2 = i6;
                                            int i30 = i7 + 0;
                                            f22 += fArr3[i30];
                                            int i31 = i7 + 1;
                                            f23 += fArr3[i31];
                                            if (i7 > 0) {
                                                path2.rLineTo(fArr3[i30], fArr3[i31]);
                                            } else {
                                                path2.rMoveTo(fArr3[i30], fArr3[i31]);
                                            }
                                        } else if (c4 != 's') {
                                            if (c4 == 't') {
                                                if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                                                    f12 = f22 - f16;
                                                    f13 = f23 - f17;
                                                } else {
                                                    f13 = 0.0f;
                                                    f12 = 0.0f;
                                                }
                                                int i32 = i7 + 0;
                                                int i33 = i7 + 1;
                                                path2.rQuadTo(f12, f13, fArr3[i32], fArr3[i33]);
                                                float f33 = f12 + f22;
                                                float f34 = f13 + f23;
                                                f22 += fArr3[i32];
                                                f23 += fArr3[i33];
                                                f17 = f34;
                                                f16 = f33;
                                            }
                                            i3 = i7;
                                            fArr = fArr3;
                                            c = c4;
                                            i2 = i6;
                                        } else {
                                            if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                                                f10 = f23 - f17;
                                                f11 = f22 - f16;
                                            } else {
                                                f11 = 0.0f;
                                                f10 = 0.0f;
                                            }
                                            int i34 = i7 + 0;
                                            int i35 = i7 + 1;
                                            int i36 = i7 + 2;
                                            int i37 = i7 + 3;
                                            f5 = f23;
                                            i5 = i6;
                                            float f35 = f22;
                                            path.rCubicTo(f11, f10, fArr3[i34], fArr3[i35], fArr3[i36], fArr3[i37]);
                                            f = f35 + fArr3[i34];
                                            f2 = f5 + fArr3[i35];
                                            f4 = fArr3[i36] + f35;
                                            f3 = fArr3[i37];
                                        }
                                        f21 = f23;
                                        f20 = f22;
                                    } else {
                                        i2 = i6;
                                        int i38 = i7 + 0;
                                        int i39 = i7 + 1;
                                        path2.lineTo(fArr3[i38], fArr3[i39]);
                                        f22 = fArr3[i38];
                                        f23 = fArr3[i39];
                                    }
                                    f23 = f6 + f7;
                                } else {
                                    float f36 = f23;
                                    i2 = i6;
                                    float f37 = f22;
                                    int i40 = i7 + 0;
                                    int i41 = i7 + 1;
                                    int i42 = i7 + 2;
                                    int i43 = i7 + 3;
                                    path2.rQuadTo(fArr3[i40], fArr3[i41], fArr3[i42], fArr3[i43]);
                                    float f38 = f36 + fArr3[i41];
                                    f16 = fArr3[i40] + f37;
                                    f22 = fArr3[i42] + f37;
                                    f17 = f38;
                                    i3 = i7;
                                    fArr = fArr3;
                                    c = c4;
                                    f23 = f36 + fArr3[i43];
                                }
                                i3 = i7;
                                fArr = fArr3;
                                c = c4;
                            } else {
                                f5 = f23;
                                i5 = i6;
                                float f39 = f22;
                                int i44 = i7 + 2;
                                int i45 = i7 + 3;
                                int i46 = i7 + 4;
                                int i47 = i7 + 5;
                                path.rCubicTo(fArr3[i7 + 0], fArr3[i7 + 1], fArr3[i44], fArr3[i45], fArr3[i46], fArr3[i47]);
                                f = f39 + fArr3[i44];
                                f2 = f5 + fArr3[i45];
                                f4 = fArr3[i46] + f39;
                                f3 = fArr3[i47];
                            }
                            f17 = f2;
                            f16 = f;
                            i3 = i7;
                            fArr = fArr3;
                            c = c4;
                            f23 = f5 + f3;
                            f22 = f4;
                        } else {
                            float f40 = f23;
                            i4 = i6;
                            float f41 = f22;
                            int i48 = i7 + 5;
                            float f42 = fArr3[i48] + f41;
                            int i49 = i7 + 6;
                            float f43 = fArr3[i49] + f40;
                            float f44 = fArr3[i7 + 0];
                            float f45 = fArr3[i7 + 1];
                            float f46 = fArr3[i7 + 2];
                            boolean z = fArr3[i7 + 3] != 0.0f;
                            boolean z2 = fArr3[i7 + 4] != 0.0f;
                            i3 = i7;
                            float f47 = f46;
                            fArr = fArr3;
                            c = c4;
                            O000000o(path, f41, f40, f42, f43, f44, f45, f47, z, z2);
                            f22 = f41 + fArr[i48];
                            f23 = f40 + fArr[i49];
                        }
                        i7 = i3 + i;
                        fArr3 = fArr;
                        i6 = i2;
                        c3 = c;
                        c4 = c3;
                    } else {
                        i3 = i7;
                        fArr = fArr3;
                        c = c4;
                        i4 = i6;
                        int i50 = i3 + 5;
                        int i51 = i3 + 6;
                        O000000o(path, f22, f23, fArr[i50], fArr[i51], fArr[i3 + 0], fArr[i3 + 1], fArr[i3 + 2], fArr[i3 + 3] != 0.0f, fArr[i3 + 4] != 0.0f);
                        f22 = fArr[i50];
                        f23 = fArr[i51];
                    }
                    f17 = f23;
                    f16 = f22;
                    i7 = i3 + i;
                    fArr3 = fArr;
                    i6 = i2;
                    c3 = c;
                    c4 = c3;
                }
                int i52 = i6;
                fArr2[0] = f22;
                fArr2[1] = f23;
                fArr2[2] = f16;
                fArr2[3] = f17;
                fArr2[4] = f20;
                fArr2[5] = f21;
                i6 = i52 + 1;
                c3 = o00000OoArr[i52].f14867O000000o;
                c2 = 0;
                o00000OoArr2 = o00000OoArr;
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
                if (d23 == 0.0d) {
                    Log.w(drd.f14865O000000o, " Points are coincident");
                    return;
                }
                double d24 = (1.0d / d23) - 0.25d;
                if (d24 < 0.0d) {
                    Log.w(drd.f14865O000000o, "Points are too far apart ".concat(String.valueOf(d23)));
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
