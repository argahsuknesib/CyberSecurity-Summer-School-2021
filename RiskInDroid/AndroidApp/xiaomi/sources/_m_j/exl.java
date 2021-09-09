package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.shopviews.widget.smarttab.SmartTabLayout;
import com.xiaomi.smarthome.R;

public final class exl extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public SmartTabLayout.O0000OOo f15921O000000o;
    public final O000000o O00000Oo;
    public final boolean O00000o;
    public exk O00000o0;
    private final Paint O00000oO;
    private final int O00000oo;
    private final int O0000O0o;
    private final float O0000OOo;
    private final int O0000Oo;
    private final Paint O0000Oo0;
    private final boolean O0000OoO;
    private final float O0000Ooo;
    private final int O0000o;
    private final boolean O0000o0;
    private final int O0000o00;
    private final Paint O0000o0O;
    private final RectF O0000o0o = new RectF();
    private final boolean O0000oO;
    private final int O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private final int O0000oo;
    private float O0000oo0;
    private final int O0000ooO;

    public exl(Context context, AttributeSet attributeSet) {
        super(context);
        int i;
        int[] iArr;
        int[] iArr2;
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i2 = typedValue.data;
        float f2 = f * 0.0f;
        int O000000o2 = O000000o(i2, (byte) 38);
        int i3 = (int) f2;
        int O000000o3 = O000000o(i2, (byte) 38);
        int O000000o4 = O000000o(i2, (byte) 32);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mi_stl_clickable, R.attr.mi_stl_customTabTextLayoutId, R.attr.mi_stl_customTabTextViewId, R.attr.mi_stl_defaultTabBackground, R.attr.mi_stl_defaultTabTextAllCaps, R.attr.mi_stl_defaultTabTextColor, R.attr.mi_stl_defaultTabTextHorizontalPadding, R.attr.mi_stl_defaultTabTextMinWidth, R.attr.mi_stl_defaultTabTextSize, R.attr.mi_stl_distributeEvenly, R.attr.mi_stl_dividerColor, R.attr.mi_stl_dividerColors, R.attr.mi_stl_dividerThickness, R.attr.mi_stl_drawDecorationAfterTab, R.attr.mi_stl_indicatorAlwaysInCenter, R.attr.mi_stl_indicatorColor, R.attr.mi_stl_indicatorColors, R.attr.mi_stl_indicatorCornerRadius, R.attr.mi_stl_indicatorGravity, R.attr.mi_stl_indicatorInFront, R.attr.mi_stl_indicatorInterpolation, R.attr.mi_stl_indicatorThickness, R.attr.mi_stl_indicatorWidth, R.attr.mi_stl_indicatorWithoutPadding, R.attr.mi_stl_overlineColor, R.attr.mi_stl_overlineThickness, R.attr.mi_stl_titleOffset, R.attr.mi_stl_underlineColor, R.attr.mi_stl_underlineThickness});
        boolean z = obtainStyledAttributes.getBoolean(14, false);
        boolean z2 = obtainStyledAttributes.getBoolean(23, false);
        boolean z3 = obtainStyledAttributes.getBoolean(19, false);
        int i4 = obtainStyledAttributes.getInt(20, 0);
        int i5 = obtainStyledAttributes.getInt(18, 0);
        int i6 = i4;
        int color = obtainStyledAttributes.getColor(15, -13388315);
        int i7 = i5;
        int resourceId = obtainStyledAttributes.getResourceId(16, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(21, (int) (8.0f * f));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(22, -1);
        float dimension = obtainStyledAttributes.getDimension(17, f2);
        int color2 = obtainStyledAttributes.getColor(24, O000000o2);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(25, i3);
        int color3 = obtainStyledAttributes.getColor(27, O000000o3);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(28, (int) (2.0f * f));
        int color4 = obtainStyledAttributes.getColor(10, O000000o4);
        float f3 = dimension;
        int resourceId2 = obtainStyledAttributes.getResourceId(11, -1);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(12, (int) (f * 1.0f));
        boolean z4 = obtainStyledAttributes.getBoolean(13, false);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            i = 1;
            iArr = new int[]{color};
        } else {
            i = 1;
            iArr = getResources().getIntArray(resourceId);
        }
        if (resourceId2 == -1) {
            iArr2 = new int[i];
            iArr2[0] = color4;
        } else {
            iArr2 = getResources().getIntArray(resourceId2);
        }
        O000000o o000000o = new O000000o((byte) 0);
        this.O00000Oo = o000000o;
        o000000o.O00000Oo = iArr;
        this.O00000Oo.f15922O000000o = iArr2;
        this.O0000ooO = dimensionPixelSize2;
        this.O0000oo = color2;
        this.O0000O0o = dimensionPixelSize3;
        this.O00000oo = color3;
        this.O00000oO = new Paint(1);
        this.O00000o = z;
        this.O0000oO = z2;
        this.O0000o0 = z3;
        this.O0000o = dimensionPixelSize;
        this.O0000oO0 = layoutDimension;
        this.O0000o0O = new Paint(1);
        this.O0000Ooo = f3;
        this.O0000o00 = i7;
        this.O0000OOo = 0.0f;
        Paint paint = new Paint(1);
        this.O0000Oo0 = paint;
        int i8 = dimensionPixelSize4;
        paint.setStrokeWidth((float) i8);
        this.O0000Oo = i8;
        this.O0000OoO = z4;
        this.O00000o0 = exk.O000000o(i6);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [float, int]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x015b  */
    private void O000000o(Canvas canvas) {
        int i;
        int i2;
        float f;
        float f2;
        float f3;
        float f4;
        Canvas canvas2 = canvas;
        int height = getHeight();
        int width = getWidth();
        int childCount = getChildCount();
        SmartTabLayout.O0000OOo O000000o2 = O000000o();
        boolean O0000OOo2 = exm.O0000OOo(this);
        if (this.O0000o0) {
            O000000o(canvas2, width);
            O000000o(canvas2, width, height);
        }
        if (childCount > 0) {
            View childAt = getChildAt(this.O0000oOo);
            int O00000Oo2 = exm.O00000Oo(childAt, this.O0000oO);
            int O000000o3 = exm.O000000o(childAt, this.O0000oO);
            if (!O0000OOo2) {
                int i3 = O00000Oo2;
                O00000Oo2 = O000000o3;
                O000000o3 = i3;
            }
            int O00000Oo3 = O000000o2.O00000Oo(this.O0000oOo);
            float f5 = (float) this.O0000o;
            if (this.O0000oo0 > 0.0f && this.O0000oOo < getChildCount() - 1) {
                int O00000Oo4 = O000000o2.O00000Oo(this.O0000oOo + 1);
                if (O00000Oo3 != O00000Oo4) {
                    float f6 = this.O0000oo0;
                    float f7 = 1.0f - f6;
                    O00000Oo3 = Color.rgb((int) ((((float) Color.red(O00000Oo4)) * f6) + (((float) Color.red(O00000Oo3)) * f7)), (int) ((((float) Color.green(O00000Oo4)) * f6) + (((float) Color.green(O00000Oo3)) * f7)), (int) ((f6 * ((float) Color.blue(O00000Oo4))) + (f7 * ((float) Color.blue(O00000Oo3)))));
                }
                float O000000o4 = this.O00000o0.O000000o(this.O0000oo0);
                float O00000Oo5 = this.O00000o0.O00000Oo(this.O0000oo0);
                float O00000o02 = this.O00000o0.O00000o0(this.O0000oo0);
                View childAt2 = getChildAt(this.O0000oOo + 1);
                int O00000Oo6 = exm.O00000Oo(childAt2, this.O0000oO);
                int O000000o5 = exm.O000000o(childAt2, this.O0000oO);
                if (O0000OOo2) {
                    i = (int) ((((float) O00000Oo6) * O000000o4) + ((1.0f - O000000o4) * ((float) i)));
                    i2 = (int) ((((float) O000000o5) * O00000Oo5) + ((1.0f - O00000Oo5) * ((float) i2)));
                } else {
                    i2 = (int) ((((float) O00000Oo6) * O000000o4) + ((1.0f - O000000o4) * ((float) i2)));
                    i = (int) ((((float) O000000o5) * O00000Oo5) + ((1.0f - O00000Oo5) * ((float) i)));
                }
                f5 *= O00000o02;
            }
            int i4 = this.O0000o;
            if (i4 > 0 && this.O0000oO0 != 0) {
                int i5 = this.O0000o00;
                if (i5 == 1) {
                    f4 = (float) i4;
                } else if (i5 != 2) {
                    float f8 = ((float) height) - (((float) i4) / 2.0f);
                    float f9 = f5 / 2.0f;
                    float f10 = f8 + f9;
                    f = f8 - f9;
                    f2 = f10;
                    this.O0000o0O.setColor(O00000Oo3);
                    if (this.O0000oO0 != -1) {
                        this.O0000o0o.set((float) i2, f, (float) i, f2);
                    } else {
                        float abs = ((float) (Math.abs(i2 - i) - this.O0000oO0)) / 2.0f;
                        this.O0000o0o.set(((float) i2) + abs, f, ((float) i) - abs, f2);
                    }
                    f3 = this.O0000Ooo;
                    if (f3 <= 0.0f) {
                        canvas2.drawRoundRect(this.O0000o0o, f3, f3, this.O0000o0O);
                    } else {
                        canvas2.drawRect(this.O0000o0o, this.O0000o0O);
                    }
                } else {
                    f4 = (float) height;
                }
                float f11 = f4 / 2.0f;
                float f12 = f5 / 2.0f;
                f = f11 - f12;
                f2 = f11 + f12;
                this.O0000o0O.setColor(O00000Oo3);
                if (this.O0000oO0 != -1) {
                }
                f3 = this.O0000Ooo;
                if (f3 <= 0.0f) {
                }
            }
        }
        if (!this.O0000o0) {
            O000000o(canvas2, width);
            O000000o(canvas2, getWidth(), height);
        }
        if (this.O0000Oo > 0) {
            int min = (int) (Math.min(Math.max(0.0f, this.O0000OOo), 1.0f) * ((float) height));
            SmartTabLayout.O0000OOo O000000o6 = O000000o();
            int i6 = (height - min) / 2;
            int i7 = i6 + min;
            boolean O0000OOo3 = exm.O0000OOo(this);
            for (int i8 = 0; i8 < childCount - 1; i8++) {
                View childAt3 = getChildAt(i8);
                int O000000o7 = exm.O000000o(childAt3, false);
                int O000000o8 = exm.O000000o(childAt3);
                int i9 = O0000OOo3 ? O000000o7 - O000000o8 : O000000o7 + O000000o8;
                this.O0000Oo0.setColor(O000000o6.O000000o(i8));
                float f13 = (float) i9;
                canvas.drawLine(f13, (float) i6, f13, (float) i7, this.O0000Oo0);
            }
        }
    }

    private void O000000o(Canvas canvas, int i) {
        if (this.O0000ooO > 0) {
            this.O00000oO.setColor(this.O0000oo);
            canvas.drawRect(0.0f, 0.0f, (float) i, (float) this.O0000ooO, this.O00000oO);
        }
    }

    private void O000000o(Canvas canvas, int i, int i2) {
        if (this.O0000O0o > 0) {
            this.O00000oO.setColor(this.O00000oo);
            canvas.drawRect(0.0f, (float) (i2 - this.O0000O0o), (float) i, (float) i2, this.O00000oO);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Color.argb(int, int, int, int):int}
     arg types: [byte, int, int, int]
     candidates:
      ClspMth{android.graphics.Color.argb(float, float, float, float):int}
      ClspMth{android.graphics.Color.argb(int, int, int, int):int} */
    private static int O000000o(int i, byte b) {
        return Color.argb((int) b, Color.red(i), Color.green(i), Color.blue(i));
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.O0000OoO) {
            O000000o(canvas);
        }
    }

    private SmartTabLayout.O0000OOo O000000o() {
        SmartTabLayout.O0000OOo o0000OOo = this.f15921O000000o;
        return o0000OOo != null ? o0000OOo : this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (!this.O0000OoO) {
            O000000o(canvas);
        }
    }

    public final void O000000o(int i, float f) {
        int i2;
        this.O0000oOo = i;
        this.O0000oo0 = f;
        if (f == 0.0f && this.O0000oOO != (i2 = this.O0000oOo)) {
            this.O0000oOO = i2;
        }
        invalidate();
    }

    public static class O000000o implements SmartTabLayout.O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int[] f15922O000000o;
        public int[] O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final int O000000o(int i) {
            int[] iArr = this.f15922O000000o;
            return iArr[i % iArr.length];
        }

        public final int O00000Oo(int i) {
            int[] iArr = this.O00000Oo;
            return iArr[i % iArr.length];
        }
    }
}
