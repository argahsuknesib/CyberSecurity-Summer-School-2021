package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.R;

public class FadingEdgeLayout extends ConstraintLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f10368O000000o = {0, -16777216};
    private static final int[] O00000Oo = {-16777216, 0};
    private boolean O00000o;
    private boolean O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private Paint O0000OoO;
    private Paint O0000Ooo;
    private Rect O0000o;
    private Paint O0000o0;
    private Paint O0000o00;
    private Rect O0000o0O;
    private Rect O0000o0o;
    private int O0000oO;
    private Rect O0000oO0;

    public FadingEdgeLayout(Context context) {
        super(context);
        O000000o(null);
    }

    public FadingEdgeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet);
    }

    public FadingEdgeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        int applyDimension = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        if (attributeSet != null) {
            boolean z = false;
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.fel_edge, R.attr.fel_size_bottom, R.attr.fel_size_left, R.attr.fel_size_right, R.attr.fel_size_top}, 0, 0);
            int i = obtainStyledAttributes.getInt(0, 0);
            this.O00000o0 = (i & 1) == 1;
            this.O00000o = (i & 2) == 2;
            this.O00000oO = (i & 4) == 4;
            if ((i & 8) == 8) {
                z = true;
            }
            this.O00000oo = z;
            this.O0000O0o = obtainStyledAttributes.getDimensionPixelSize(4, applyDimension);
            this.O0000OOo = obtainStyledAttributes.getDimensionPixelSize(1, applyDimension);
            this.O0000Oo0 = obtainStyledAttributes.getDimensionPixelSize(2, applyDimension);
            this.O0000Oo = obtainStyledAttributes.getDimensionPixelSize(3, applyDimension);
            if (this.O00000o0 && this.O0000O0o > 0) {
                this.O0000oO |= 1;
            }
            if (this.O00000oO && this.O0000Oo0 > 0) {
                this.O0000oO |= 4;
            }
            if (this.O00000o && this.O0000OOo > 0) {
                this.O0000oO |= 2;
            }
            if (this.O00000oo && this.O0000Oo > 0) {
                this.O0000oO |= 8;
            }
            obtainStyledAttributes.recycle();
        } else {
            this.O0000Oo = applyDimension;
            this.O0000Oo0 = applyDimension;
            this.O0000OOo = applyDimension;
            this.O0000O0o = applyDimension;
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.O0000OoO = new Paint(1);
        this.O0000OoO.setXfermode(porterDuffXfermode);
        this.O0000Ooo = new Paint(1);
        this.O0000Ooo.setXfermode(porterDuffXfermode);
        this.O0000o00 = new Paint(1);
        this.O0000o00.setXfermode(porterDuffXfermode);
        this.O0000o0 = new Paint(1);
        this.O0000o0.setXfermode(porterDuffXfermode);
        this.O0000o0O = new Rect();
        this.O0000o = new Rect();
        this.O0000o0o = new Rect();
        this.O0000oO0 = new Rect();
    }

    public final void setFadeEdges$1d54120b(boolean z) {
        if (this.O00000o0) {
            this.O00000o0 = false;
            this.O0000oO |= 1;
        }
        if (this.O00000oO != z) {
            this.O00000oO = z;
            this.O0000oO |= 4;
        }
        if (this.O00000o) {
            this.O00000o = false;
            this.O0000oO |= 2;
        }
        if (!this.O00000oo) {
            this.O00000oo = true;
            this.O0000oO |= 8;
        }
        if (this.O0000oO != 0) {
            invalidate();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (getPaddingLeft() != i) {
            this.O0000oO |= 4;
        }
        if (getPaddingTop() != i2) {
            this.O0000oO |= 1;
        }
        if (getPaddingRight() != i3) {
            this.O0000oO |= 8;
        }
        if (getPaddingBottom() != i4) {
            this.O0000oO |= 2;
        }
        super.setPadding(i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.O0000oO |= 4;
            this.O0000oO |= 8;
        }
        if (i2 != i4) {
            this.O0000oO |= 1;
            this.O0000oO |= 2;
        }
    }

    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        boolean z = this.O00000o0 || this.O00000o || this.O00000oO || this.O00000oo;
        if (getVisibility() == 8 || width == 0 || height == 0 || !z) {
            super.dispatchDraw(canvas);
            return;
        }
        int i = this.O0000oO;
        if ((i & 1) == 1) {
            this.O0000oO = i & -2;
            int min = Math.min(this.O0000O0o, (getHeight() - getPaddingTop()) - getPaddingBottom());
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i2 = min + paddingTop;
            this.O0000o0O.set(paddingLeft, paddingTop, getWidth() - getPaddingRight(), i2);
            float f = (float) paddingLeft;
            this.O0000OoO.setShader(new LinearGradient(f, (float) paddingTop, f, (float) i2, f10368O000000o, (float[]) null, Shader.TileMode.CLAMP));
        }
        int i3 = this.O0000oO;
        if ((i3 & 4) == 4) {
            this.O0000oO = i3 & -5;
            int min2 = Math.min(this.O0000Oo0, (getWidth() - getPaddingLeft()) - getPaddingRight());
            int paddingLeft2 = getPaddingLeft();
            int paddingTop2 = getPaddingTop();
            int i4 = min2 + paddingLeft2;
            this.O0000o.set(paddingLeft2, paddingTop2, i4, getHeight() - getPaddingBottom());
            float f2 = (float) paddingTop2;
            this.O0000o00.setShader(new LinearGradient((float) paddingLeft2, f2, (float) i4, f2, f10368O000000o, (float[]) null, Shader.TileMode.CLAMP));
        }
        int i5 = this.O0000oO;
        if ((i5 & 2) == 2) {
            this.O0000oO = i5 & -3;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int min3 = Math.min(this.O0000OOo, height2);
            int paddingLeft3 = getPaddingLeft();
            int paddingTop3 = (getPaddingTop() + height2) - min3;
            int i6 = min3 + paddingTop3;
            this.O0000o0o.set(paddingLeft3, paddingTop3, getWidth() - getPaddingRight(), i6);
            float f3 = (float) paddingLeft3;
            this.O0000Ooo.setShader(new LinearGradient(f3, (float) paddingTop3, f3, (float) i6, O00000Oo, (float[]) null, Shader.TileMode.CLAMP));
        }
        int i7 = this.O0000oO;
        if ((i7 & 8) == 8) {
            this.O0000oO = i7 & -9;
            int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int min4 = Math.min(this.O0000Oo, width2);
            int paddingLeft4 = (getPaddingLeft() + width2) - min4;
            int paddingTop4 = getPaddingTop();
            int i8 = min4 + paddingLeft4;
            this.O0000oO0.set(paddingLeft4, paddingTop4, i8, getHeight() - getPaddingBottom());
            float f4 = (float) paddingTop4;
            this.O0000o0.setShader(new LinearGradient((float) paddingLeft4, f4, (float) i8, f4, O00000Oo, (float[]) null, Shader.TileMode.CLAMP));
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
        super.dispatchDraw(canvas);
        if (this.O00000o0 && this.O0000O0o > 0) {
            canvas.drawRect(this.O0000o0O, this.O0000OoO);
        }
        if (this.O00000o && this.O0000OOo > 0) {
            canvas.drawRect(this.O0000o0o, this.O0000Ooo);
        }
        if (this.O00000oO && this.O0000Oo0 > 0) {
            canvas.drawRect(this.O0000o, this.O0000o00);
        }
        if (this.O00000oo && this.O0000Oo > 0) {
            canvas.drawRect(this.O0000oO0, this.O0000o0);
        }
        canvas.restoreToCount(saveLayer);
    }
}
