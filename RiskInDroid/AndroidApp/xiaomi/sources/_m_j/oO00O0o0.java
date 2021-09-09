package _m_j;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.android.exoplayer2.C;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;

public abstract class oO00O0o0 {
    private static float O0000OoO = 6.2831855f;

    /* renamed from: O000000o  reason: collision with root package name */
    protected o0OOoOO0 f2274O000000o;
    protected int O00000Oo = 0;
    protected float[][] O00000o = ((float[][]) Array.newInstance(float.class, 10, 3));
    protected int[] O00000o0 = new int[10];
    String O00000oO;
    protected boolean O00000oo = false;
    long O0000O0o;
    float O0000OOo = Float.NaN;
    private float[] O0000Oo = new float[3];
    private int O0000Oo0;

    public abstract boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00);

    public String toString() {
        String str = this.O00000oO;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.O0000Oo0; i++) {
            str = str + "[" + this.O00000o0[i] + " , " + decimalFormat.format(this.O00000o[i]) + "] ";
        }
        return str;
    }

    public final float O000000o(float f, long j, View view, oO0Ooo00 oo0ooo00) {
        long j2 = j;
        View view2 = view;
        oO0Ooo00 oo0ooo002 = oo0ooo00;
        this.f2274O000000o.O000000o((double) f, this.O0000Oo);
        float[] fArr = this.O0000Oo;
        float f2 = fArr[1];
        boolean z = false;
        if (f2 == 0.0f) {
            this.O00000oo = false;
            return fArr[2];
        }
        if (Float.isNaN(this.O0000OOo)) {
            String str = this.O00000oO;
            float f3 = Float.NaN;
            if (oo0ooo002.f2293O000000o.containsKey(view2)) {
                HashMap hashMap = oo0ooo002.f2293O000000o.get(view2);
                if (hashMap.containsKey(str)) {
                    float[] fArr2 = (float[]) hashMap.get(str);
                    if (fArr2.length > 0) {
                        f3 = fArr2[0];
                    }
                }
            }
            this.O0000OOo = f3;
            if (Float.isNaN(this.O0000OOo)) {
                this.O0000OOo = 0.0f;
            }
        }
        double d = (double) this.O0000OOo;
        double d2 = (double) (j2 - this.O0000O0o);
        Double.isNaN(d2);
        double d3 = (double) f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        this.O0000OOo = (float) ((d + ((d2 * 1.0E-9d) * d3)) % 1.0d);
        String str2 = this.O00000oO;
        float f4 = this.O0000OOo;
        if (!oo0ooo002.f2293O000000o.containsKey(view2)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str2, new float[]{f4});
            oo0ooo002.f2293O000000o.put(view2, hashMap2);
        } else {
            HashMap hashMap3 = oo0ooo002.f2293O000000o.get(view2);
            if (!hashMap3.containsKey(str2)) {
                hashMap3.put(str2, new float[]{f4});
                oo0ooo002.f2293O000000o.put(view2, hashMap3);
            } else {
                float[] fArr3 = (float[]) hashMap3.get(str2);
                if (fArr3.length <= 0) {
                    fArr3 = Arrays.copyOf(fArr3, 1);
                }
                fArr3[0] = f4;
                hashMap3.put(str2, fArr3);
            }
        }
        this.O0000O0o = j2;
        float f5 = this.O0000Oo[0];
        float O000000o2 = (O000000o(this.O0000OOo) * f5) + this.O0000Oo[2];
        if (!(f5 == 0.0f && f2 == 0.0f)) {
            z = true;
        }
        this.O00000oo = z;
        return O000000o2;
    }

    /* access modifiers changed from: protected */
    public final float O000000o(float f) {
        float abs;
        switch (this.O00000Oo) {
            case 1:
                return Math.signum(f * O0000OoO);
            case 2:
                abs = Math.abs(f);
                break;
            case 3:
                return (((f * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos((double) (f * O0000OoO));
            case 6:
                float abs2 = 1.0f - Math.abs(((f * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin((double) (f * O0000OoO));
        }
        return 1.0f - abs;
    }

    static oO00O0o0 O000000o(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new O00000Oo(str, sparseArray);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static oO00O0o0 O000000o(String str, long j) {
        char c;
        oO00O0o0 oo00o0o0;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 8;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 9;
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 10;
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                oo00o0o0 = new O000000o();
                break;
            case 1:
                oo00o0o0 = new O00000o0();
                break;
            case 2:
                oo00o0o0 = new O0000OOo();
                break;
            case 3:
                oo00o0o0 = new O0000Oo0();
                break;
            case 4:
                oo00o0o0 = new O0000Oo();
                break;
            case 5:
                oo00o0o0 = new O00000o();
                break;
            case 6:
                oo00o0o0 = new O0000o00();
                break;
            case 7:
                oo00o0o0 = new O0000o0();
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                oo00o0o0 = new O00oOooO();
                break;
            case 9:
                oo00o0o0 = new O000O00o();
                break;
            case 10:
                oo00o0o0 = new O000O0OO();
                break;
            case 11:
                oo00o0o0 = new O0000O0o();
                break;
            default:
                return null;
        }
        oo00o0o0.O0000O0o = j;
        return oo00o0o0;
    }

    public void O000000o(int i, float f, float f2, int i2, float f3) {
        int[] iArr = this.O00000o0;
        int i3 = this.O0000Oo0;
        iArr[i3] = i;
        float[][] fArr = this.O00000o;
        fArr[i3][0] = f;
        fArr[i3][1] = f2;
        fArr[i3][2] = f3;
        this.O00000Oo = Math.max(this.O00000Oo, i2);
        this.O0000Oo0++;
    }

    public void O000000o(int i) {
        int i2 = this.O0000Oo0;
        if (i2 == 0) {
            Log.e("SplineSet", "Error no points added to " + this.O00000oO);
            return;
        }
        O0000o.O000000o(this.O00000o0, this.O00000o, i2 - 1);
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int[] iArr = this.O00000o0;
            if (i3 >= iArr.length) {
                break;
            }
            if (iArr[i3] != iArr[i3 - 1]) {
                i4++;
            }
            i3++;
        }
        if (i4 == 0) {
            i4 = 1;
        }
        double[] dArr = new double[i4];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i4, 3);
        int i5 = 0;
        for (int i6 = 0; i6 < this.O0000Oo0; i6++) {
            if (i6 > 0) {
                int[] iArr2 = this.O00000o0;
                if (iArr2[i6] == iArr2[i6 - 1]) {
                }
            }
            double d = (double) this.O00000o0[i6];
            Double.isNaN(d);
            dArr[i5] = d * 0.01d;
            double[] dArr3 = dArr2[i5];
            float[][] fArr = this.O00000o;
            dArr3[0] = (double) fArr[i6][0];
            dArr2[i5][1] = (double) fArr[i6][1];
            dArr2[i5][2] = (double) fArr[i6][2];
            i5++;
        }
        this.f2274O000000o = o0OOoOO0.O000000o(i, dArr, dArr2);
    }

    static class O00000o0 extends oO00O0o0 {
        O00000o0() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(O000000o(f, j, view, oo0ooo00));
            }
            return this.O00000oo;
        }
    }

    static class O000000o extends oO00O0o0 {
        O000000o() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setAlpha(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O0000OOo extends oO00O0o0 {
        O0000OOo() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setRotation(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O0000Oo0 extends oO00O0o0 {
        O0000Oo0() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setRotationX(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O0000Oo extends oO00O0o0 {
        O0000Oo() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setRotationY(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O00000o extends oO00O0o0 {
        O00000o() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            return this.O00000oo;
        }

        public final boolean O000000o(View view, oO0Ooo00 oo0ooo00, float f, long j, double d, double d2) {
            view.setRotation(O000000o(f, j, view, oo0ooo00) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.O00000oo;
        }
    }

    static class O0000o00 extends oO00O0o0 {
        O0000o00() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setScaleX(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O0000o0 extends oO00O0o0 {
        O0000o0() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setScaleY(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O00oOooO extends oO00O0o0 {
        O00oOooO() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setTranslationX(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O000O00o extends oO00O0o0 {
        O000O00o() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            view.setTranslationY(O000000o(f, j, view, oo0ooo00));
            return this.O00000oo;
        }
    }

    static class O000O0OO extends oO00O0o0 {
        O000O0OO() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(O000000o(f, j, view, oo0ooo00));
            }
            return this.O00000oo;
        }
    }

    static class O00000Oo extends oO00O0o0 {
        SparseArray<ConstraintAttribute> O0000Oo;
        String O0000Oo0;
        SparseArray<float[]> O0000OoO = new SparseArray<>();
        float[] O0000Ooo;
        float[] O0000o00;

        public O00000Oo(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.O0000Oo0 = str.split(",")[1];
            this.O0000Oo = sparseArray;
        }

        public final void O000000o(int i) {
            int size = this.O0000Oo.size();
            int O000000o2 = this.O0000Oo.valueAt(0).O000000o();
            double[] dArr = new double[size];
            int i2 = O000000o2 + 2;
            this.O0000Ooo = new float[i2];
            this.O0000o00 = new float[O000000o2];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.O0000Oo.keyAt(i3);
                float[] valueAt = this.O0000OoO.valueAt(i3);
                double d = (double) keyAt;
                Double.isNaN(d);
                dArr[i3] = d * 0.01d;
                this.O0000Oo.valueAt(i3).O000000o(this.O0000Ooo);
                int i4 = 0;
                while (true) {
                    float[] fArr = this.O0000Ooo;
                    if (i4 >= fArr.length) {
                        break;
                    }
                    dArr2[i3][i4] = (double) fArr[i4];
                    i4++;
                }
                dArr2[i3][O000000o2] = (double) valueAt[0];
                dArr2[i3][O000000o2 + 1] = (double) valueAt[1];
            }
            this.f2274O000000o = o0OOoOO0.O000000o(i, dArr, dArr2);
        }

        public final void O000000o(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public final void O000000o(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.O0000Oo.append(i, constraintAttribute);
            this.O0000OoO.append(i, new float[]{f, f2});
            this.O00000Oo = Math.max(this.O00000Oo, i2);
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            this.f2274O000000o.O000000o((double) f, this.O0000Ooo);
            float[] fArr = this.O0000Ooo;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            double d = (double) this.O0000OOo;
            double d2 = (double) (j - this.O0000O0o);
            Double.isNaN(d2);
            double d3 = (double) f2;
            Double.isNaN(d3);
            Double.isNaN(d);
            this.O0000OOo = (float) ((d + ((d2 * 1.0E-9d) * d3)) % 1.0d);
            this.O0000O0o = j;
            float O000000o2 = O000000o(this.O0000OOo);
            this.O00000oo = false;
            for (int i = 0; i < this.O0000o00.length; i++) {
                this.O00000oo |= ((double) this.O0000Ooo[i]) != 0.0d;
                this.O0000o00[i] = (this.O0000Ooo[i] * O000000o2) + f3;
            }
            this.O0000Oo.valueAt(0).O000000o(view, this.O0000o00);
            if (f2 != 0.0f) {
                this.O00000oo = true;
            }
            return this.O00000oo;
        }
    }

    static class O0000O0o extends oO00O0o0 {
        boolean O0000Oo0 = false;

        O0000O0o() {
        }

        public final boolean O000000o(View view, float f, long j, oO0Ooo00 oo0ooo00) {
            View view2 = view;
            if (view2 instanceof MotionLayout) {
                ((MotionLayout) view2).setProgress(O000000o(f, j, view, oo0ooo00));
            } else if (this.O0000Oo0) {
                return false;
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.O0000Oo0 = true;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(O000000o(f, j, view, oo0ooo00)));
                    } catch (IllegalAccessException e) {
                        Log.e("SplineSet", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    }
                }
            }
            return this.O00000oo;
        }
    }

    static class O0000o {
        static void O000000o(int[] iArr, float[][] fArr, int i) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i;
            iArr2[1] = 0;
            int i2 = 2;
            while (i2 > 0) {
                int i3 = i2 - 1;
                int i4 = iArr2[i3];
                i2 = i3 - 1;
                int i5 = iArr2[i2];
                if (i4 < i5) {
                    int i6 = iArr[i5];
                    int i7 = i4;
                    int i8 = i7;
                    while (i7 < i5) {
                        if (iArr[i7] <= i6) {
                            O000000o(iArr, fArr, i8, i7);
                            i8++;
                        }
                        i7++;
                    }
                    O000000o(iArr, fArr, i8, i5);
                    int i9 = i2 + 1;
                    iArr2[i2] = i8 - 1;
                    int i10 = i9 + 1;
                    iArr2[i9] = i4;
                    int i11 = i10 + 1;
                    iArr2[i10] = i5;
                    i2 = i11 + 1;
                    iArr2[i11] = i8 + 1;
                }
            }
        }

        private static void O000000o(int[] iArr, float[][] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float[] fArr2 = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = fArr2;
        }
    }
}
