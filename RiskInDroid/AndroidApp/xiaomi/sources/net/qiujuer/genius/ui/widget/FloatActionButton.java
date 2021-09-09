package net.qiujuer.genius.ui.widget;

import _m_j.izh;
import _m_j.izj;
import _m_j.izx;
import _m_j.jac;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class FloatActionButton extends ImageView implements izx.O00000o, izx.O00000o0 {
    private ColorStateList mBackgroundColor;
    private int mShadowRadius;
    private izx mTouchDrawable;

    public FloatActionButton(Context context) {
        this(context, null);
    }

    public FloatActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.gFloatActionButtonStyle);
    }

    public FloatActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 2132738383);
    }

    @TargetApi(21)
    public FloatActionButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(FloatActionButton.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FloatActionButton.class.getName());
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            Context context = getContext();
            Resources resources = getResources();
            float f = resources.getDisplayMetrics().density;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842766, R.attr.gBackgroundColor, R.attr.gInterceptEvent, R.attr.gTouchColor, R.attr.gTouchDurationRate, R.attr.shadowAlpha, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius}, i, i2);
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
            int color = obtainStyledAttributes.getColor(3, 805306368);
            boolean z = obtainStyledAttributes.getBoolean(0, true);
            int i3 = obtainStyledAttributes.getInt(6, -16777216);
            float dimension = obtainStyledAttributes.getDimension(7, 0.0f * f);
            float dimension2 = obtainStyledAttributes.getDimension(8, 1.8f * f);
            float dimension3 = obtainStyledAttributes.getDimension(9, f * 3.75f);
            int i4 = obtainStyledAttributes.getInt(5, 32);
            float f2 = obtainStyledAttributes.getFloat(8, 1.0f);
            int i5 = obtainStyledAttributes.getInt(2, 1);
            obtainStyledAttributes.recycle();
            setEnabled(z);
            if (colorStateList == null) {
                colorStateList = izj.O00000Oo(resources, R.color.g_default_float_action_bg);
            }
            float max = Math.max(dimension, dimension2);
            double d = (double) dimension3;
            Double.isNaN(d);
            this.mShadowRadius = (int) (d + 0.5d);
            this.mShadowRadius = (int) (((float) this.mShadowRadius) + max);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new O000000o(this.mShadowRadius, izh.O00000o0(i3, 112)));
            Paint paint = shapeDrawable.getPaint();
            if (!isInEditMode()) {
                paint.setShadowLayer(((float) this.mShadowRadius) - max, dimension, dimension2, izh.O00000o0(i3, i4));
            }
            izj.O000000o(this, shapeDrawable);
            setBackgroundColor(colorStateList);
            this.mTouchDrawable = new izx(new jac(), ColorStateList.valueOf(color));
            this.mTouchDrawable.setCallback(this);
            izx izx = this.mTouchDrawable;
            izx.O00000oO = i5;
            izx.O000000o(f2);
            this.mTouchDrawable.O00000Oo(f2);
            setLayerType(1, paint);
            int i6 = this.mShadowRadius;
            setPadding(Math.max(i6, getPaddingLeft()), Math.max(i6, getPaddingTop()), Math.max(i6, getPaddingRight()), Math.max(i6, getPaddingBottom()));
        }
    }

    public void setLayerType(int i, Paint paint) {
        super.setLayerType(1, paint);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.mBackgroundColor;
        if (colorStateList != null) {
            setBackgroundColor(colorStateList.getColorForState(getDrawableState(), this.mBackgroundColor.getDefaultColor()));
        }
    }

    public void setBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList != null && this.mBackgroundColor != colorStateList) {
            this.mBackgroundColor = colorStateList;
            setBackgroundColor(this.mBackgroundColor.getColorForState(getDrawableState(), this.mBackgroundColor.getDefaultColor()));
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(izj.O000000o(getResources(), i));
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(izh.O00000o0(i, 255));
        }
    }

    public void setTouchColor(int i) {
        this.mTouchDrawable.O00000Oo(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(Math.max(this.mShadowRadius, i), Math.max(this.mShadowRadius, i2), Math.max(this.mShadowRadius, i3), Math.max(this.mShadowRadius, i4));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            int i5 = this.mShadowRadius;
            izx.setBounds(i5, i5, getWidth() - this.mShadowRadius, getHeight() - this.mShadowRadius);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        izx izx = this.mTouchDrawable;
        return (izx != null && drawable == izx) || super.verifyDrawable(drawable);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        izx izx = this.mTouchDrawable;
        if (onTouchEvent && izx != null && isEnabled()) {
            izx.O000000o(motionEvent);
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            izx.draw(canvas);
        }
        super.onDraw(canvas);
    }

    public boolean performClick() {
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            return izx.O000000o(this) && super.performClick();
        }
        return super.performClick();
    }

    public boolean performLongClick() {
        izx izx = this.mTouchDrawable;
        if (izx != null) {
            return izx.O000000o(this) && super.performLongClick();
        }
        return super.performLongClick();
    }

    public void postPerformClick() {
        if (!post(new Runnable() {
            /* class net.qiujuer.genius.ui.widget.FloatActionButton.AnonymousClass1 */

            public final void run() {
                FloatActionButton.this.performClick();
            }
        })) {
            performClick();
        }
    }

    public void postPerformLongClick() {
        if (!post(new Runnable() {
            /* class net.qiujuer.genius.ui.widget.FloatActionButton.AnonymousClass2 */

            public final void run() {
                FloatActionButton.this.performLongClick();
            }
        })) {
            performLongClick();
        }
    }

    public izx getTouchDrawable() {
        return this.mTouchDrawable;
    }

    static class O000000o extends Shape {

        /* renamed from: O000000o  reason: collision with root package name */
        private Paint f15408O000000o;
        private float O00000Oo;
        private float O00000o;
        private float O00000o0;
        private int O00000oO;
        private int O00000oo;
        private RectF O0000O0o = new RectF();

        O000000o(int i, int i2) {
            this.O00000oO = i;
            this.O00000oo = i2;
            this.f15408O000000o = new Paint(1);
            this.f15408O000000o.setStyle(Paint.Style.FILL);
            this.f15408O000000o.setAntiAlias(true);
            this.f15408O000000o.setDither(true);
        }

        /* access modifiers changed from: protected */
        public final void onResize(float f, float f2) {
            super.onResize(f, f2);
            this.O0000O0o.set(0.0f, 0.0f, f, f2);
            this.O00000Oo = f / 2.0f;
            this.O00000o0 = f2 / 2.0f;
            this.O00000o = Math.min(this.O00000Oo, this.O00000o0);
            this.f15408O000000o.setShader(new RadialGradient(this.O00000Oo, this.O00000o0, this.O00000o, new int[]{this.O00000oo, 16777215}, new float[]{0.65f, 1.0f}, Shader.TileMode.CLAMP));
        }

        public final void draw(Canvas canvas, Paint paint) {
            canvas.drawCircle(this.O00000Oo, this.O00000o0, this.O00000o, this.f15408O000000o);
            canvas.drawCircle(this.O00000Oo, this.O00000o0, this.O00000o - ((float) this.O00000oO), paint);
        }
    }
}
