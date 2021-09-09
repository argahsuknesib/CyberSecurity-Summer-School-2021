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
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.xiaomi.smarthome.R;

public final class coy extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public final boolean f14176O000000o;
    public final O000000o O00000Oo;
    public SmartTabLayout.O0000OOo O00000o;
    public cox O00000o0;
    private final int O00000oO;
    private final int O00000oo;
    private final int O0000O0o;
    private final int O0000OOo;
    private final RectF O0000Oo = new RectF();
    private final Paint O0000Oo0;
    private final boolean O0000OoO;
    private final boolean O0000Ooo;
    private final Paint O0000o;
    private final int O0000o0;
    private final int O0000o00;
    private final int O0000o0O;
    private final float O0000o0o;
    private final Paint O0000oO;
    private final int O0000oO0;
    private final float O0000oOO;
    private final boolean O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private float O0000ooO;

    public coy(Context context, AttributeSet attributeSet) {
        super(context);
        int i;
        int[] iArr;
        int[] iArr2;
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i2 = typedValue.data;
        float f2 = 0.0f * f;
        int O000000o2 = O000000o(i2, (byte) 38);
        int i3 = (int) f2;
        int O000000o3 = O000000o(i2, (byte) 38);
        int O000000o4 = O000000o(i2, (byte) 32);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.stl_clickable, R.attr.stl_customTabTextLayoutId, R.attr.stl_customTabTextViewId, R.attr.stl_defaultTabBackground, R.attr.stl_defaultTabTextAllCaps, R.attr.stl_defaultTabTextColor, R.attr.stl_defaultTabTextHorizontalPadding, R.attr.stl_defaultTabTextMinWidth, R.attr.stl_defaultTabTextSize, R.attr.stl_distributeEvenly, R.attr.stl_dividerColor, R.attr.stl_dividerColors, R.attr.stl_dividerThickness, R.attr.stl_drawDecorationAfterTab, R.attr.stl_indicatorAlwaysInCenter, R.attr.stl_indicatorColor, R.attr.stl_indicatorColors, R.attr.stl_indicatorCornerRadius, R.attr.stl_indicatorGravity, R.attr.stl_indicatorInFront, R.attr.stl_indicatorInterpolation, R.attr.stl_indicatorThickness, R.attr.stl_indicatorWidth, R.attr.stl_indicatorWithoutPadding, R.attr.stl_overlineColor, R.attr.stl_overlineThickness, R.attr.stl_titleOffset, R.attr.stl_underlineColor, R.attr.stl_underlineThickness});
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
        this.O00000Oo = new O000000o((byte) 0);
        O000000o o000000o = this.O00000Oo;
        o000000o.f14177O000000o = iArr;
        o000000o.O00000Oo = iArr2;
        this.O00000oO = dimensionPixelSize2;
        this.O00000oo = color2;
        this.O0000O0o = dimensionPixelSize3;
        this.O0000OOo = color3;
        this.O0000Oo0 = new Paint(1);
        this.f14176O000000o = z;
        this.O0000OoO = z2;
        this.O0000Ooo = z3;
        this.O0000o00 = dimensionPixelSize;
        this.O0000o0 = layoutDimension;
        this.O0000o = new Paint(1);
        this.O0000o0o = f3;
        this.O0000o0O = i7;
        this.O0000oOO = 0.5f;
        this.O0000oO = new Paint(1);
        int i8 = dimensionPixelSize4;
        this.O0000oO.setStrokeWidth((float) i8);
        this.O0000oO0 = i8;
        this.O0000oOo = z4;
        this.O00000o0 = cox.O000000o(i6);
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

    private static int O000000o(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i)) * f) + (((float) Color.red(i2)) * f2)), (int) ((((float) Color.green(i)) * f) + (((float) Color.green(i2)) * f2)), (int) ((((float) Color.blue(i)) * f) + (((float) Color.blue(i2)) * f2)));
    }

    public final void O000000o(int i, float f) {
        int i2;
        this.O0000oo = i;
        this.O0000ooO = f;
        if (f == 0.0f && this.O0000oo0 != (i2 = this.O0000oo)) {
            this.O0000oo0 = i2;
        }
        invalidate();
    }

    private SmartTabLayout.O0000OOo O000000o() {
        SmartTabLayout.O0000OOo o0000OOo = this.O00000o;
        return o0000OOo != null ? o0000OOo : this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (!this.O0000oOo) {
            O000000o(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.O0000oOo) {
            O000000o(canvas);
        }
    }

    private void O000000o(Canvas canvas) {
        int i;
        int i2;
        Canvas canvas2 = canvas;
        int height = getHeight();
        int width = getWidth();
        int childCount = getChildCount();
        SmartTabLayout.O0000OOo O000000o2 = O000000o();
        boolean O0000Oo02 = coz.O0000Oo0(this);
        if (this.O0000Ooo) {
            O000000o(canvas2, width);
            O00000Oo(canvas2, width, height);
        }
        if (childCount > 0) {
            View childAt = getChildAt(this.O0000oo);
            int O000000o3 = coz.O000000o(childAt, this.O0000OoO);
            int O00000Oo2 = coz.O00000Oo(childAt, this.O0000OoO);
            if (!O0000Oo02) {
                int i3 = O000000o3;
                O000000o3 = O00000Oo2;
                O00000Oo2 = i3;
            }
            int O000000o4 = O000000o2.O000000o(this.O0000oo);
            float f = (float) this.O0000o00;
            if (this.O0000ooO > 0.0f && this.O0000oo < getChildCount() - 1) {
                int O000000o5 = O000000o2.O000000o(this.O0000oo + 1);
                if (O000000o4 != O000000o5) {
                    O000000o4 = O000000o(O000000o5, O000000o4, this.O0000ooO);
                }
                float O000000o6 = this.O00000o0.O000000o(this.O0000ooO);
                float O00000Oo3 = this.O00000o0.O00000Oo(this.O0000ooO);
                float O00000o02 = this.O00000o0.O00000o0(this.O0000ooO);
                View childAt2 = getChildAt(this.O0000oo + 1);
                int O000000o7 = coz.O000000o(childAt2, this.O0000OoO);
                int O00000Oo4 = coz.O00000Oo(childAt2, this.O0000OoO);
                if (O0000Oo02) {
                    i = (int) ((((float) O00000Oo4) * O00000Oo3) + ((1.0f - O00000Oo3) * ((float) O00000Oo2)));
                    i2 = (int) ((((float) O000000o7) * O000000o6) + ((1.0f - O000000o6) * ((float) O000000o3)));
                } else {
                    i = (int) ((((float) O000000o7) * O000000o6) + ((1.0f - O000000o6) * ((float) O00000Oo2)));
                    i2 = (int) ((((float) O00000Oo4) * O00000Oo3) + ((1.0f - O00000Oo3) * ((float) O000000o3)));
                }
                f *= O00000o02;
                O000000o3 = i2;
                O00000Oo2 = i;
            }
            O000000o(canvas, O00000Oo2, O000000o3, height, f, O000000o4);
        }
        if (!this.O0000Ooo) {
            O000000o(canvas2, width);
            O00000Oo(canvas2, getWidth(), height);
        }
        O000000o(canvas2, height, childCount);
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
    private void O000000o(Canvas canvas, int i, int i2) {
        int i3 = i;
        if (this.O0000oO0 > 0) {
            int min = (int) (Math.min(Math.max(0.0f, this.O0000oOO), 1.0f) * ((float) i3));
            SmartTabLayout.O0000OOo O000000o2 = O000000o();
            int i4 = (i3 - min) / 2;
            int i5 = min + i4;
            boolean O0000Oo02 = coz.O0000Oo0(this);
            for (int i6 = 0; i6 < i2 - 1; i6++) {
                View childAt = getChildAt(i6);
                int O00000Oo2 = coz.O00000Oo(childAt, false);
                int O0000O0o2 = coz.O0000O0o(childAt);
                int i7 = O0000Oo02 ? O00000Oo2 - O0000O0o2 : O00000Oo2 + O0000O0o2;
                this.O0000oO.setColor(O000000o2.O00000Oo(i6));
                float f = (float) i7;
                canvas.drawLine(f, (float) i4, f, (float) i5, this.O0000oO);
            }
        }
    }

    private void O000000o(Canvas canvas, int i, int i2, int i3, float f, int i4) {
        float f2;
        float f3;
        int i5 = this.O0000o00;
        if (i5 > 0 && this.O0000o0 != 0) {
            int i6 = this.O0000o0O;
            if (i6 == 1) {
                f2 = (float) i5;
                f3 = f2 / 2.0f;
            } else if (i6 != 2) {
                f3 = ((float) i3) - (((float) i5) / 2.0f);
            } else {
                f2 = (float) i3;
                f3 = f2 / 2.0f;
            }
            float f4 = f / 2.0f;
            float f5 = f3 - f4;
            float f6 = f3 + f4;
            this.O0000o.setColor(i4);
            if (this.O0000o0 == -1) {
                this.O0000Oo.set((float) i, f5, (float) i2, f6);
            } else {
                float abs = ((float) (Math.abs(i - i2) - this.O0000o0)) / 2.0f;
                this.O0000Oo.set(((float) i) + abs, f5, ((float) i2) - abs, f6);
            }
            float f7 = this.O0000o0o;
            if (f7 > 0.0f) {
                canvas.drawRoundRect(this.O0000Oo, f7, f7, this.O0000o);
            } else {
                canvas.drawRect(this.O0000Oo, this.O0000o);
            }
        }
    }

    private void O000000o(Canvas canvas, int i) {
        if (this.O00000oO > 0) {
            this.O0000Oo0.setColor(this.O00000oo);
            canvas.drawRect(0.0f, 0.0f, (float) i, (float) this.O00000oO, this.O0000Oo0);
        }
    }

    private void O00000Oo(Canvas canvas, int i, int i2) {
        if (this.O0000O0o > 0) {
            this.O0000Oo0.setColor(this.O0000OOo);
            canvas.drawRect(0.0f, (float) (i2 - this.O0000O0o), (float) i, (float) i2, this.O0000Oo0);
        }
    }

    public static class O000000o implements SmartTabLayout.O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public int[] f14177O000000o;
        public int[] O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final int O000000o(int i) {
            int[] iArr = this.f14177O000000o;
            return iArr[i % iArr.length];
        }

        public final int O00000Oo(int i) {
            int[] iArr = this.O00000Oo;
            return iArr[i % iArr.length];
        }
    }
}
