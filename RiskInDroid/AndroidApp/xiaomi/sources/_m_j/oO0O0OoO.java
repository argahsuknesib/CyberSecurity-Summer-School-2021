package _m_j;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class oO0O0OoO {

    /* renamed from: O000000o  reason: collision with root package name */
    protected o0OOoOO0 f2283O000000o;
    protected int[] O00000Oo = new int[10];
    String O00000o;
    protected float[] O00000o0 = new float[10];
    private int O00000oO;

    public abstract void O000000o(View view, float f);

    public String toString() {
        String str = this.O00000o;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.O00000oO; i++) {
            str = str + "[" + this.O00000Oo[i] + " , " + decimalFormat.format((double) this.O00000o0[i]) + "] ";
        }
        return str;
    }

    public final float O000000o(float f) {
        return (float) this.f2283O000000o.O000000o((double) f);
    }

    public final float O00000Oo(float f) {
        return (float) this.f2283O000000o.O00000Oo((double) f);
    }

    public void O000000o(int i, float f) {
        int[] iArr = this.O00000Oo;
        if (iArr.length < this.O00000oO + 1) {
            this.O00000Oo = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.O00000o0;
            this.O00000o0 = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.O00000Oo;
        int i2 = this.O00000oO;
        iArr2[i2] = i;
        this.O00000o0[i2] = f;
        this.O00000oO = i2 + 1;
    }

    public void O000000o(int i) {
        int i2 = this.O00000oO;
        if (i2 != 0) {
            int[] iArr = this.O00000Oo;
            float[] fArr = this.O00000o0;
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i2 - 1;
            int i3 = 2;
            iArr2[1] = 0;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int i7 = iArr[i6];
                    int i8 = i5;
                    int i9 = i8;
                    while (i8 < i6) {
                        if (iArr[i8] <= i7) {
                            O000O00o.O000000o(iArr, fArr, i9, i8);
                            i9++;
                        }
                        i8++;
                    }
                    O000O00o.O000000o(iArr, fArr, i9, i6);
                    int i10 = i3 + 1;
                    iArr2[i3] = i9 - 1;
                    int i11 = i10 + 1;
                    iArr2[i10] = i5;
                    int i12 = i11 + 1;
                    iArr2[i11] = i6;
                    i3 = i12 + 1;
                    iArr2[i12] = i9 + 1;
                }
            }
            int i13 = 1;
            for (int i14 = 1; i14 < this.O00000oO; i14++) {
                int[] iArr3 = this.O00000Oo;
                if (iArr3[i14 - 1] != iArr3[i14]) {
                    i13++;
                }
            }
            double[] dArr = new double[i13];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, i13, 1);
            int i15 = 0;
            for (int i16 = 0; i16 < this.O00000oO; i16++) {
                if (i16 > 0) {
                    int[] iArr4 = this.O00000Oo;
                    if (iArr4[i16] == iArr4[i16 - 1]) {
                    }
                }
                double d = (double) this.O00000Oo[i16];
                Double.isNaN(d);
                dArr[i15] = d * 0.01d;
                dArr2[i15][0] = (double) this.O00000o0[i16];
                i15++;
            }
            this.f2283O000000o = o0OOoOO0.O000000o(i, dArr, dArr2);
        }
    }

    static class O00000o0 extends oO0O0OoO {
        O00000o0() {
        }

        public final void O000000o(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(O000000o(f));
            }
        }
    }

    static class O000000o extends oO0O0OoO {
        O000000o() {
        }

        public final void O000000o(View view, float f) {
            view.setAlpha(O000000o(f));
        }
    }

    static class O0000Oo extends oO0O0OoO {
        O0000Oo() {
        }

        public final void O000000o(View view, float f) {
            view.setRotation(O000000o(f));
        }
    }

    static class O0000o00 extends oO0O0OoO {
        O0000o00() {
        }

        public final void O000000o(View view, float f) {
            view.setRotationX(O000000o(f));
        }
    }

    static class O0000o0 extends oO0O0OoO {
        O0000o0() {
        }

        public final void O000000o(View view, float f) {
            view.setRotationY(O000000o(f));
        }
    }

    static class O0000O0o extends oO0O0OoO {
        O0000O0o() {
        }

        public final void O000000o(View view, float f) {
            view.setPivotX(O000000o(f));
        }
    }

    static class O0000OOo extends oO0O0OoO {
        O0000OOo() {
        }

        public final void O000000o(View view, float f) {
            view.setPivotY(O000000o(f));
        }
    }

    static class O00000o extends oO0O0OoO {
        public final void O000000o(View view, float f) {
        }

        O00000o() {
        }
    }

    static class O0000o extends oO0O0OoO {
        O0000o() {
        }

        public final void O000000o(View view, float f) {
            view.setScaleX(O000000o(f));
        }
    }

    static class O00oOooO extends oO0O0OoO {
        O00oOooO() {
        }

        public final void O000000o(View view, float f) {
            view.setScaleY(O000000o(f));
        }
    }

    static class O000O0OO extends oO0O0OoO {
        O000O0OO() {
        }

        public final void O000000o(View view, float f) {
            view.setTranslationX(O000000o(f));
        }
    }

    static class O000O0o0 extends oO0O0OoO {
        O000O0o0() {
        }

        public final void O000000o(View view, float f) {
            view.setTranslationY(O000000o(f));
        }
    }

    static class O000O0o extends oO0O0OoO {
        O000O0o() {
        }

        public final void O000000o(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(O000000o(f));
            }
        }
    }

    static class O00000Oo extends oO0O0OoO {
        String O00000oO;
        SparseArray<ConstraintAttribute> O00000oo;
        float[] O0000O0o;

        public O00000Oo(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.O00000oO = str.split(",")[1];
            this.O00000oo = sparseArray;
        }

        public final void O000000o(int i) {
            int size = this.O00000oo.size();
            int O000000o2 = this.O00000oo.valueAt(0).O000000o();
            double[] dArr = new double[size];
            this.O0000O0o = new float[O000000o2];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, O000000o2);
            for (int i2 = 0; i2 < size; i2++) {
                double keyAt = (double) this.O00000oo.keyAt(i2);
                Double.isNaN(keyAt);
                dArr[i2] = keyAt * 0.01d;
                this.O00000oo.valueAt(i2).O000000o(this.O0000O0o);
                int i3 = 0;
                while (true) {
                    float[] fArr = this.O0000O0o;
                    if (i3 >= fArr.length) {
                        break;
                    }
                    dArr2[i2][i3] = (double) fArr[i3];
                    i3++;
                }
            }
            this.f2283O000000o = o0OOoOO0.O000000o(i, dArr, dArr2);
        }

        public final void O000000o(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public final void O000000o(int i, ConstraintAttribute constraintAttribute) {
            this.O00000oo.append(i, constraintAttribute);
        }

        public final void O000000o(View view, float f) {
            this.f2283O000000o.O000000o((double) f, this.O0000O0o);
            this.O00000oo.valueAt(0).O000000o(view, this.O0000O0o);
        }
    }

    static class O0000Oo0 extends oO0O0OoO {
        boolean O00000oO = false;

        O0000Oo0() {
        }

        public final void O000000o(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(O000000o(f));
            } else if (!this.O00000oO) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.O00000oO = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(O000000o(f)));
                    } catch (IllegalAccessException e) {
                        Log.e("SplineSet", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("SplineSet", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    static class O000O00o {
        static void O000000o(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }
}
