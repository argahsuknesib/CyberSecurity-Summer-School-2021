package net.qiujuer.genius.ui.widget;

import _m_j.izj;
import _m_j.izq;
import _m_j.izr;
import _m_j.izs;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class Loading extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f15411O000000o = 1;
    public static int O00000Oo = 2;
    private boolean O00000o;
    private izr O00000o0;
    private boolean O00000oO;

    public Loading(Context context) {
        super(context);
        O000000o(null, R.attr.gLoadingStyle);
    }

    public Loading(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(attributeSet, R.attr.gLoadingStyle);
    }

    public Loading(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet, i);
    }

    private void O000000o(AttributeSet attributeSet, int i) {
        Context context = getContext();
        Resources resources = getResources();
        if (attributeSet == null) {
            setProgressStyle(f15411O000000o);
            return;
        }
        int i2 = (int) (resources.getDisplayMetrics().density * 2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.gAutoRun, R.attr.gBackgroundColor, R.attr.gBackgroundLineSize, R.attr.gForegroundColor, R.attr.gForegroundLineSize, R.attr.gProgressFloat, R.attr.gProgressStyle}, i, 2132738385);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(2, i2);
        int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(4, i2);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
        int defaultColor = colorStateList != null ? colorStateList.getDefaultColor() : 0;
        int resourceId = obtainStyledAttributes.getResourceId(3, R.array.g_default_loading_fg);
        int i3 = obtainStyledAttributes.getInt(6, 1);
        boolean z = obtainStyledAttributes.getBoolean(0, true);
        float f = obtainStyledAttributes.getFloat(5, 0.0f);
        obtainStyledAttributes.recycle();
        setProgressStyle(i3);
        setAutoRun(z);
        setProgress(f);
        setBackgroundLineSize(dimensionPixelOffset);
        setForegroundLineSize(dimensionPixelOffset2);
        setBackgroundColor(defaultColor);
        if (!isInEditMode()) {
            String resourceTypeName = resources.getResourceTypeName(resourceId);
            char c = 65535;
            try {
                int hashCode = resourceTypeName.hashCode();
                if (hashCode != 93090393) {
                    if (hashCode == 94842723) {
                        if (resourceTypeName.equals("color")) {
                            c = 0;
                        }
                    }
                } else if (resourceTypeName.equals("array")) {
                    c = 1;
                }
                if (c == 0) {
                    setForegroundColor(resources.getColor(resourceId));
                } else if (c != 1) {
                    setForegroundColor(resources.getIntArray(R.array.g_default_loading_fg));
                } else {
                    setForegroundColor(resources.getIntArray(resourceId));
                }
            } catch (Exception unused) {
                setForegroundColor(resources.getIntArray(R.array.g_default_loading_fg));
            }
        }
    }

    private void O000000o() {
        this.O00000o0.start();
        this.O00000oO = false;
    }

    public void setBackgroundLineSize(int i) {
        this.O00000o0.O00000Oo((float) i);
        invalidate();
        requestLayout();
    }

    public void setForegroundLineSize(int i) {
        this.O00000o0.O00000o0((float) i);
        invalidate();
        requestLayout();
    }

    public float getBackgroundLineSize() {
        return this.O00000o0.O00000Oo();
    }

    public float getForegroundLineSize() {
        return this.O00000o0.O00000o0();
    }

    public void setBackgroundColor(int i) {
        this.O00000o0.O000000o(i);
        invalidate();
    }

    public void setBackgroundColorRes(int i) {
        ColorStateList O00000Oo2 = izj.O00000Oo(getResources(), i);
        if (O00000Oo2 == null) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(O00000Oo2.getDefaultColor());
        }
    }

    public int getBackgroundColor() {
        return this.O00000o0.O00000o();
    }

    public void setForegroundColor(int i) {
        setForegroundColor(new int[]{i});
    }

    public void setForegroundColor(int[] iArr) {
        izr izr = this.O00000o0;
        if (iArr != null) {
            izr.O00000o = iArr;
            izr.O00000oO = -1;
            izr.O00000oO();
        }
        invalidate();
    }

    public int[] getForegroundColor() {
        return this.O00000o0.O00000o;
    }

    public float getProgress() {
        return this.O00000o0.O00000oo();
    }

    public void setProgress(float f) {
        this.O00000o0.O00000o(f);
        invalidate();
    }

    public void setAutoRun(boolean z) {
        this.O00000o = z;
    }

    public void setProgressStyle(int i) {
        izr izr;
        if (i == f15411O000000o) {
            Resources resources = getResources();
            izr = new izq(resources.getDimensionPixelOffset(R.dimen.g_loading_minSize), resources.getDimensionPixelOffset(R.dimen.g_loading_maxSize));
        } else {
            izr = i == O00000Oo ? new izs() : null;
        }
        if (izr != null) {
            izr.setCallback(this);
            this.O00000o0 = izr;
            invalidate();
            requestLayout();
            return;
        }
        throw new NullPointerException("LoadingDrawable is null, You can only set the STYLE_CIRCLE and STYLE_LINE parameters.");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int intrinsicHeight = this.O00000o0.getIntrinsicHeight() + getPaddingTop() + getPaddingBottom();
        int intrinsicWidth = this.O00000o0.getIntrinsicWidth() + getPaddingLeft() + getPaddingRight();
        if (mode != 1073741824) {
            size = mode == Integer.MIN_VALUE ? Math.min(size, intrinsicWidth) : intrinsicWidth;
        }
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(size2, intrinsicHeight) : intrinsicHeight;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O00000o0.setBounds(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), i2 - getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.O00000o0 || super.verifyDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.O00000o0.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        O000000o(i);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        O000000o(i);
    }

    private void O000000o(int i) {
        izr izr = this.O00000o0;
        if (izr != null) {
            if (i == 0) {
                if (this.O00000oO) {
                    O000000o();
                }
            } else if (izr.isRunning()) {
                this.O00000oO = true;
                this.O00000o0.stop();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.O00000o && this.O00000o0.O00000oo() == 0.0f) {
            if (getVisibility() == 0) {
                this.O00000o0.start();
            } else {
                this.O00000oO = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O00000o0.stop();
    }
}
