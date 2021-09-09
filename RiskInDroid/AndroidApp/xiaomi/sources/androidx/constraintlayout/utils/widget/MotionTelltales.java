package androidx.constraintlayout.utils.widget;

import _m_j.o;
import _m_j.oO00O00o;
import _m_j.oO0O0OoO;
import _m_j.oO0O0o0o;
import _m_j.oO0Oo0O0;
import _m_j.oO0OoOO0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.xiaomi.smarthome.R;

public class MotionTelltales extends MockView {
    MotionLayout O00000Oo;
    Matrix O00000o = new Matrix();
    float[] O00000o0 = new float[2];
    int O00000oO = 0;
    int O00000oo = -65281;
    float O0000O0o = 0.25f;
    private Paint O0000OOo = new Paint();

    public MotionTelltales(Context context) {
        super(context);
        O000000o(context, null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.telltales_tailColor, R.attr.telltales_tailScale, R.attr.telltales_velocityMode});
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.O00000oo = obtainStyledAttributes.getColor(index, this.O00000oo);
                } else if (index == 2) {
                    this.O00000oO = obtainStyledAttributes.getInt(index, this.O00000oO);
                } else if (index == 1) {
                    this.O0000O0o = obtainStyledAttributes.getFloat(index, this.O0000O0o);
                }
            }
        }
        this.O0000OOo.setColor(this.O00000oo);
        this.O0000OOo.setStrokeWidth(5.0f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setText(CharSequence charSequence) {
        this.f2798O000000o = charSequence.toString();
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postInvalidate();
    }

    public void onDraw(Canvas canvas) {
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float[] fArr;
        float[] fArr2;
        oO0O0OoO oo0o0ooo;
        oO0O0OoO oo0o0ooo2;
        oO0O0OoO oo0o0ooo3;
        int i6;
        oO0O0OoO oo0o0ooo4;
        MotionTelltales motionTelltales = this;
        super.onDraw(canvas);
        getMatrix().invert(motionTelltales.O00000o);
        if (motionTelltales.O00000Oo == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.O00000Oo = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int i7 = 5;
        float[] fArr3 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i8 = 0;
        while (i8 < i7) {
            float f2 = fArr3[i8];
            int i9 = 0;
            while (i9 < i7) {
                float f3 = fArr3[i9];
                MotionLayout motionLayout = motionTelltales.O00000Oo;
                float[] fArr4 = motionTelltales.O00000o0;
                int i10 = motionTelltales.O00000oO;
                float f4 = motionLayout.O00000o;
                float f5 = motionLayout.O0000o0;
                if (motionLayout.O00000o0 != null) {
                    float signum = Math.signum(motionLayout.O0000o0O - motionLayout.O0000o0);
                    float interpolation = motionLayout.O00000o0.getInterpolation(motionLayout.O0000o0 + 1.0E-5f);
                    f = motionLayout.O00000o0.getInterpolation(motionLayout.O0000o0);
                    f4 = (signum * ((interpolation - f) / 1.0E-5f)) / motionLayout.O0000Ooo;
                } else {
                    f = f5;
                }
                if (motionLayout.O00000o0 instanceof oO0O0o0o) {
                    f4 = ((oO0O0o0o) motionLayout.O00000o0).O000000o();
                }
                float f6 = f4;
                oO0Oo0O0 oo0oo0o0 = motionLayout.O0000OoO.get(motionTelltales);
                if ((i10 & 1) == 0) {
                    int width2 = getWidth();
                    int height2 = getHeight();
                    float O000000o2 = oo0oo0o0.O000000o(f, oo0oo0o0.O0000o0O);
                    oO0OoOO0 oo0oooo0 = null;
                    oO0O0OoO oo0o0ooo5 = oo0oo0o0.O0000o == null ? null : oo0oo0o0.O0000o.get("translationX");
                    fArr = fArr3;
                    if (oo0oo0o0.O0000o == null) {
                        i5 = i10;
                        oo0o0ooo = null;
                    } else {
                        oo0o0ooo = oo0oo0o0.O0000o.get("translationY");
                        i5 = i10;
                    }
                    i4 = i8;
                    if (oo0oo0o0.O0000o == null) {
                        i3 = i9;
                        oo0o0ooo2 = null;
                    } else {
                        oo0o0ooo2 = oo0oo0o0.O0000o.get("rotation");
                        i3 = i9;
                    }
                    i2 = height;
                    if (oo0oo0o0.O0000o == null) {
                        i = width;
                        oo0o0ooo3 = null;
                    } else {
                        oo0o0ooo3 = oo0oo0o0.O0000o.get("scaleX");
                        i = width;
                    }
                    if (oo0oo0o0.O0000o == null) {
                        i6 = width2;
                        oo0o0ooo4 = null;
                    } else {
                        oo0o0ooo4 = oo0oo0o0.O0000o.get("scaleY");
                        i6 = width2;
                    }
                    oO0OoOO0 oo0oooo02 = oo0oo0o0.O0000oO0 == null ? null : oo0oo0o0.O0000oO0.get("translationX");
                    oO0OoOO0 oo0oooo03 = oo0oo0o0.O0000oO0 == null ? null : oo0oo0o0.O0000oO0.get("translationY");
                    oO0OoOO0 oo0oooo04 = oo0oo0o0.O0000oO0 == null ? null : oo0oo0o0.O0000oO0.get("rotation");
                    oO0OoOO0 oo0oooo05 = oo0oo0o0.O0000oO0 == null ? null : oo0oo0o0.O0000oO0.get("scaleX");
                    if (oo0oo0o0.O0000oO0 != null) {
                        oo0oooo0 = oo0oo0o0.O0000oO0.get("scaleY");
                    }
                    oO0OoOO0 oo0oooo06 = oo0oooo0;
                    o oVar = new o();
                    oVar.O000000o();
                    oVar.O000000o(oo0o0ooo2, O000000o2);
                    oVar.O000000o(oo0o0ooo5, oo0o0ooo, O000000o2);
                    oVar.O00000Oo(oo0o0ooo3, oo0o0ooo4, O000000o2);
                    oVar.O000000o(oo0oooo04, O000000o2);
                    oVar.O000000o(oo0oooo02, oo0oooo03, O000000o2);
                    oVar.O00000Oo(oo0oooo05, oo0oooo06, O000000o2);
                    oO0OoOO0 oo0oooo07 = oo0oooo06;
                    if (oo0oo0o0.O0000OOo != null) {
                        if (oo0oo0o0.O0000o00.length > 0) {
                            double d = (double) O000000o2;
                            oo0oo0o0.O0000OOo.O000000o(d, oo0oo0o0.O0000o00);
                            oo0oo0o0.O0000OOo.O00000Oo(d, oo0oo0o0.O0000o0);
                            oO00O00o.O000000o(f3, f2, fArr4, oo0oo0o0.O0000Ooo, oo0oo0o0.O0000o0);
                        }
                        oVar.O000000o(f3, f2, i6, height2, fArr4);
                        fArr2 = fArr4;
                    } else if (oo0oo0o0.O0000O0o != null) {
                        double O000000o3 = (double) oo0oo0o0.O000000o(O000000o2, oo0oo0o0.O0000o0O);
                        oo0oo0o0.O0000O0o[0].O00000Oo(O000000o3, oo0oo0o0.O0000o0);
                        oo0oo0o0.O0000O0o[0].O000000o(O000000o3, oo0oo0o0.O0000o00);
                        float f7 = oo0oo0o0.O0000o0O[0];
                        for (int i11 = 0; i11 < oo0oo0o0.O0000o0.length; i11++) {
                            double[] dArr = oo0oo0o0.O0000o0;
                            double d2 = dArr[i11];
                            double d3 = (double) f7;
                            Double.isNaN(d3);
                            dArr[i11] = d2 * d3;
                        }
                        oO00O00o.O000000o(f3, f2, fArr4, oo0oo0o0.O0000Ooo, oo0oo0o0.O0000o0);
                        fArr2 = fArr4;
                        oVar.O000000o(f3, f2, i6, height2, fArr4);
                    } else {
                        fArr2 = fArr4;
                        oO0OoOO0 oo0oooo08 = oo0oooo05;
                        float f8 = oo0oo0o0.O00000oO.O00000oo - oo0oo0o0.O00000o.O00000oo;
                        float f9 = oo0oo0o0.O00000oO.O0000O0o - oo0oo0o0.O00000o.O0000O0o;
                        oO0OoOO0 oo0oooo09 = oo0oooo02;
                        float f10 = (oo0oo0o0.O00000oO.O0000Oo0 - oo0oo0o0.O00000o.O0000Oo0) + f9;
                        fArr2[0] = (f8 * (1.0f - f3)) + (((oo0oo0o0.O00000oO.O0000OOo - oo0oo0o0.O00000o.O0000OOo) + f8) * f3);
                        fArr2[1] = (f9 * (1.0f - f2)) + (f10 * f2);
                        oVar.O000000o();
                        oVar.O000000o(oo0o0ooo2, O000000o2);
                        oVar.O000000o(oo0o0ooo5, oo0o0ooo, O000000o2);
                        oVar.O00000Oo(oo0o0ooo3, oo0o0ooo4, O000000o2);
                        oVar.O000000o(oo0oooo04, O000000o2);
                        oVar.O000000o(oo0oooo09, oo0oooo03, O000000o2);
                        oVar.O00000Oo(oo0oooo08, oo0oooo07, O000000o2);
                        oVar.O000000o(f3, f2, i6, height2, fArr2);
                    }
                } else {
                    i = width;
                    i2 = height;
                    fArr = fArr3;
                    i4 = i8;
                    i5 = i10;
                    fArr2 = fArr4;
                    i3 = i9;
                    oo0oo0o0.O000000o(f, f3, f2, fArr2);
                }
                if (i5 < 2) {
                    fArr2[0] = fArr2[0] * f6;
                    fArr2[1] = fArr2[1] * f6;
                }
                motionTelltales = this;
                motionTelltales.O00000o.mapVectors(motionTelltales.O00000o0);
                width = i;
                float f11 = ((float) width) * f3;
                height = i2;
                float f12 = ((float) height) * f2;
                float[] fArr5 = motionTelltales.O00000o0;
                float f13 = fArr5[0];
                float f14 = motionTelltales.O0000O0o;
                float f15 = f12 - (fArr5[1] * f14);
                motionTelltales.O00000o.mapVectors(fArr5);
                canvas.drawLine(f11, f12, f11 - (f13 * f14), f15, motionTelltales.O0000OOo);
                i9 = i3 + 1;
                fArr3 = fArr;
                i8 = i4;
                i7 = 5;
            }
            i8++;
            i7 = 5;
        }
    }
}
