package _m_j;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public abstract class oO0OoOO0 {

    /* renamed from: O000000o  reason: collision with root package name */
    protected ConstraintAttribute f2289O000000o;
    String O00000Oo;
    public int O00000o = 0;
    int O00000o0 = 0;
    ArrayList<O000O0o0> O00000oO = new ArrayList<>();
    private o0OOoOO0 O00000oo;
    private O00000o0 O0000O0o;

    public abstract void O000000o(View view, float f);

    static class O000O0o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2292O000000o;
        float O00000Oo;
        float O00000o;
        float O00000o0;

        public O000O0o0(int i, float f, float f2, float f3) {
            this.f2292O000000o = i;
            this.O00000Oo = f3;
            this.O00000o0 = f2;
            this.O00000o = f;
        }
    }

    public String toString() {
        String str = this.O00000Oo;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<O000O0o0> it = this.O00000oO.iterator();
        while (it.hasNext()) {
            O000O0o0 next = it.next();
            str = str + "[" + next.f2292O000000o + " , " + decimalFormat.format((double) next.O00000Oo) + "] ";
        }
        return str;
    }

    public final float O000000o(float f) {
        O00000o0 o00000o0 = this.O0000O0o;
        if (o00000o0.O0000OOo != null) {
            o00000o0.O0000OOo.O000000o((double) f, o00000o0.O0000Oo0);
        } else {
            o00000o0.O0000Oo0[0] = (double) o00000o0.O00000oO[0];
            o00000o0.O0000Oo0[1] = (double) o00000o0.O00000Oo[0];
        }
        return (float) (o00000o0.O0000Oo0[0] + (o00000o0.f2291O000000o.O000000o((double) f) * o00000o0.O0000Oo0[1]));
    }

    public final float O00000Oo(float f) {
        return (float) this.O0000O0o.O000000o(f);
    }

    public final void O000000o(int i, int i2, int i3, float f, float f2, float f3, ConstraintAttribute constraintAttribute) {
        this.O00000oO.add(new O000O0o0(i, f, f2, f3));
        if (i3 != -1) {
            this.O00000o = i3;
        }
        this.O00000o0 = i2;
        this.f2289O000000o = constraintAttribute;
    }

    @TargetApi(19)
    public final void O00000o0(float f) {
        int i;
        int size = this.O00000oO.size();
        if (size != 0) {
            Collections.sort(this.O00000oO, new Comparator<O000O0o0>() {
                /* class _m_j.oO0OoOO0.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return Integer.compare(((O000O0o0) obj).f2292O000000o, ((O000O0o0) obj2).f2292O000000o);
                }
            });
            double[] dArr = new double[size];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, 2);
            this.O0000O0o = new O00000o0(this.O00000o0, this.O00000o, size);
            Iterator<O000O0o0> it = this.O00000oO.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                O000O0o0 next = it.next();
                double d = (double) next.O00000o;
                Double.isNaN(d);
                dArr[i2] = d * 0.01d;
                dArr2[i2][0] = (double) next.O00000Oo;
                dArr2[i2][1] = (double) next.O00000o0;
                O00000o0 o00000o0 = this.O0000O0o;
                int i3 = next.f2292O000000o;
                float f2 = next.O00000o;
                float f3 = next.O00000o0;
                float f4 = next.O00000Oo;
                double[] dArr3 = o00000o0.O00000o0;
                double d2 = (double) i3;
                Double.isNaN(d2);
                dArr3[i2] = d2 / 100.0d;
                o00000o0.O00000o[i2] = f2;
                o00000o0.O00000oO[i2] = f3;
                o00000o0.O00000Oo[i2] = f4;
                i2++;
            }
            O00000o0 o00000o02 = this.O0000O0o;
            o00000o02.O0000OoO = f;
            double[][] dArr4 = (double[][]) Array.newInstance(double.class, o00000o02.O00000o0.length, 2);
            o00000o02.O0000Oo0 = new double[(o00000o02.O00000Oo.length + 1)];
            o00000o02.O0000Oo = new double[(o00000o02.O00000Oo.length + 1)];
            if (o00000o02.O00000o0[0] > 0.0d) {
                o00000o02.f2291O000000o.O000000o(0.0d, o00000o02.O00000o[0]);
            }
            int length = o00000o02.O00000o0.length - 1;
            if (o00000o02.O00000o0[length] < 1.0d) {
                o00000o02.f2291O000000o.O000000o(1.0d, o00000o02.O00000o[length]);
            }
            for (int i4 = 0; i4 < dArr4.length; i4++) {
                dArr4[i4][0] = (double) o00000o02.O00000oO[i4];
                for (int i5 = 0; i5 < o00000o02.O00000Oo.length; i5++) {
                    dArr4[i5][1] = (double) o00000o02.O00000Oo[i5];
                }
                o00000o02.f2291O000000o.O000000o(o00000o02.O00000o0[i4], o00000o02.O00000o[i4]);
            }
            o0OOo000 o0ooo000 = o00000o02.f2291O000000o;
            double d3 = 0.0d;
            for (float f5 : o0ooo000.O00000Oo) {
                double d4 = (double) f5;
                Double.isNaN(d4);
                d3 += d4;
            }
            double d5 = 0.0d;
            for (int i6 = 1; i6 < o0ooo000.O00000Oo.length; i6++) {
                int i7 = i6 - 1;
                double d6 = (double) ((o0ooo000.O00000Oo[i7] + o0ooo000.O00000Oo[i6]) / 2.0f);
                Double.isNaN(d6);
                d5 += (o0ooo000.O00000o0[i6] - o0ooo000.O00000o0[i7]) * d6;
            }
            int i8 = 0;
            while (i8 < o0ooo000.O00000Oo.length) {
                float[] fArr = o0ooo000.O00000Oo;
                double d7 = (double) fArr[i8];
                Double.isNaN(d7);
                fArr[i8] = (float) (d7 * (d3 / d5));
                i8++;
                o0ooo000 = o0ooo000;
            }
            o0OOo000 o0ooo0002 = o0ooo000;
            o0ooo0002.O00000o[0] = 0.0d;
            for (int i9 = 1; i9 < o0ooo0002.O00000Oo.length; i9++) {
                int i10 = i9 - 1;
                double d8 = o0ooo0002.O00000o0[i9] - o0ooo0002.O00000o0[i10];
                double[] dArr5 = o0ooo0002.O00000o;
                double d9 = dArr5[i10];
                double d10 = (double) ((o0ooo0002.O00000Oo[i10] + o0ooo0002.O00000Oo[i9]) / 2.0f);
                Double.isNaN(d10);
                dArr5[i9] = d9 + (d8 * d10);
            }
            o0ooo0002.O0000O0o = true;
            if (o00000o02.O00000o0.length > 1) {
                i = 0;
                o00000o02.O0000OOo = o0OOoOO0.O000000o(0, o00000o02.O00000o0, dArr4);
            } else {
                i = 0;
                o00000o02.O0000OOo = null;
            }
            this.O00000oo = o0OOoOO0.O000000o(i, dArr, dArr2);
        }
    }

    static class O00000o extends oO0OoOO0 {
        O00000o() {
        }

        public final void O000000o(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(O000000o(f));
            }
        }
    }

    static class O000000o extends oO0OoOO0 {
        O000000o() {
        }

        public final void O000000o(View view, float f) {
            view.setAlpha(O000000o(f));
        }
    }

    static class O0000Oo0 extends oO0OoOO0 {
        O0000Oo0() {
        }

        public final void O000000o(View view, float f) {
            view.setRotation(O000000o(f));
        }
    }

    static class O0000Oo extends oO0OoOO0 {
        O0000Oo() {
        }

        public final void O000000o(View view, float f) {
            view.setRotationX(O000000o(f));
        }
    }

    static class O0000o00 extends oO0OoOO0 {
        O0000o00() {
        }

        public final void O000000o(View view, float f) {
            view.setRotationY(O000000o(f));
        }
    }

    static class O0000O0o extends oO0OoOO0 {
        public final void O000000o(View view, float f) {
        }

        O0000O0o() {
        }
    }

    static class O0000o0 extends oO0OoOO0 {
        O0000o0() {
        }

        public final void O000000o(View view, float f) {
            view.setScaleX(O000000o(f));
        }
    }

    static class O0000o extends oO0OoOO0 {
        O0000o() {
        }

        public final void O000000o(View view, float f) {
            view.setScaleY(O000000o(f));
        }
    }

    static class O00oOooO extends oO0OoOO0 {
        O00oOooO() {
        }

        public final void O000000o(View view, float f) {
            view.setTranslationX(O000000o(f));
        }
    }

    static class O000O00o extends oO0OoOO0 {
        O000O00o() {
        }

        public final void O000000o(View view, float f) {
            view.setTranslationY(O000000o(f));
        }
    }

    static class O000O0OO extends oO0OoOO0 {
        O000O0OO() {
        }

        public final void O000000o(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(O000000o(f));
            }
        }
    }

    static class O00000Oo extends oO0OoOO0 {
        float[] O00000oo = new float[1];

        O00000Oo() {
        }

        public final void O000000o(View view, float f) {
            this.O00000oo[0] = O000000o(f);
            this.f2289O000000o.O000000o(view, this.O00000oo);
        }
    }

    static class O0000OOo extends oO0OoOO0 {
        boolean O00000oo = false;

        O0000OOo() {
        }

        public final void O000000o(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(O000000o(f));
            } else if (!this.O00000oo) {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.O00000oo = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(O000000o(f)));
                    } catch (IllegalAccessException e) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e("KeyCycleOscillator", "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        o0OOo000 f2291O000000o = new o0OOo000();
        float[] O00000Oo;
        float[] O00000o;
        double[] O00000o0;
        float[] O00000oO;
        float[] O00000oo;
        int O0000O0o;
        o0OOoOO0 O0000OOo;
        double[] O0000Oo;
        double[] O0000Oo0;
        float O0000OoO;
        public HashMap<String, ConstraintAttribute> O0000Ooo = new HashMap<>();
        private final int O0000o00;

        O00000o0(int i, int i2, int i3) {
            this.O0000O0o = i;
            this.O0000o00 = i2;
            this.f2291O000000o.O00000oO = i;
            this.O00000Oo = new float[i3];
            this.O00000o0 = new double[i3];
            this.O00000o = new float[i3];
            this.O00000oO = new float[i3];
            this.O00000oo = new float[i3];
        }

        public final double O000000o(float f) {
            o0OOoOO0 o0ooooo0 = this.O0000OOo;
            if (o0ooooo0 != null) {
                double d = (double) f;
                o0ooooo0.O00000Oo(d, this.O0000Oo);
                this.O0000OOo.O000000o(d, this.O0000Oo0);
            } else {
                double[] dArr = this.O0000Oo;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d2 = (double) f;
            double O000000o2 = this.f2291O000000o.O000000o(d2);
            double O00000Oo2 = this.f2291O000000o.O00000Oo(d2);
            double[] dArr2 = this.O0000Oo;
            return dArr2[0] + (O000000o2 * dArr2[1]) + (O00000Oo2 * this.O0000Oo0[1]);
        }
    }
}
