package com.xiaomi.shopviews.adapter.bigvision;

import _m_j.dpc;
import _m_j.euu;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.xiaomi.smarthome.R;

public class GravityImageVirtualView extends ImageView implements dpc {
    private int mDrawableHeight;
    private int mDrawableWidth;
    private boolean mEnablePanoramaMode;
    private boolean mEnableScrollbar;
    private int mHeight;
    private boolean mInvertScrollDirection;
    private float mMaxOffset;
    private O000000o mOnPanoramaScrollListener;
    private byte mOrientation;
    private Paint mScrollbarPaint;
    private int mWidth;
    private float mXProgress;
    private float mYProgress;

    public interface O000000o {
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
    }

    public GravityImageVirtualView(Context context) {
        this(context, null);
    }

    public GravityImageVirtualView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GravityImageVirtualView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOrientation = -1;
        super.setScaleType(ImageView.ScaleType.CENTER_CROP);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.piv_enablePanoramaMode, R.attr.piv_invertScrollDirection, R.attr.piv_show_scrollbar});
        this.mEnablePanoramaMode = obtainStyledAttributes.getBoolean(0, true);
        this.mInvertScrollDirection = obtainStyledAttributes.getBoolean(1, false);
        this.mEnableScrollbar = obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.recycle();
        if (this.mEnableScrollbar) {
            initScrollbarPaint();
        }
    }

    private void initScrollbarPaint() {
        this.mScrollbarPaint = new Paint(1);
        this.mScrollbarPaint.setColor(-1);
        this.mScrollbarPaint.setStrokeWidth(dp2px(1.5f));
    }

    public void updateProgress(float f, float f2) {
        if (this.mEnablePanoramaMode) {
            if (this.mInvertScrollDirection) {
                f = -f;
            }
            this.mXProgress = f;
            if (this.mInvertScrollDirection) {
                f2 = -f2;
            }
            this.mYProgress = f2;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mWidth = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        this.mHeight = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (getDrawable() != null) {
            this.mDrawableWidth = getDrawable().getIntrinsicWidth();
            this.mDrawableHeight = getDrawable().getIntrinsicHeight();
            int i3 = this.mDrawableWidth;
            int i4 = this.mHeight;
            int i5 = i3 * i4;
            int i6 = this.mDrawableHeight;
            int i7 = this.mWidth;
            if (i5 > i6 * i7) {
                this.mMaxOffset = Math.abs(((((float) i3) * (((float) i4) / ((float) i6))) - ((float) i7)) * 0.5f);
            } else if (i3 * i4 < i6 * i7) {
                this.mMaxOffset = Math.abs(((((float) i6) * (((float) i7) / ((float) i3))) - ((float) i4)) * 0.5f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.mEnablePanoramaMode || getDrawable() == null || isInEditMode()) {
            super.onDraw(canvas);
            return;
        }
        float f = this.mMaxOffset;
        float f2 = this.mXProgress * f;
        canvas.save();
        canvas.translate(f * this.mYProgress, f2);
        super.onDraw(canvas);
        canvas.restore();
    }

    private float dp2px(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public void setEnablePanoramaMode(boolean z) {
        this.mEnablePanoramaMode = z;
    }

    public boolean isPanoramaModeEnabled() {
        return this.mEnablePanoramaMode;
    }

    public void setInvertScrollDirection(boolean z) {
        if (this.mInvertScrollDirection != z) {
            this.mInvertScrollDirection = z;
        }
    }

    public boolean isInvertScrollDirection() {
        return this.mInvertScrollDirection;
    }

    public void setEnableScrollbar(boolean z) {
        if (this.mEnableScrollbar != z) {
            this.mEnableScrollbar = z;
            if (this.mEnableScrollbar) {
                initScrollbarPaint();
            } else {
                this.mScrollbarPaint = null;
            }
        }
    }

    public boolean isScrollbarEnabled() {
        return this.mEnableScrollbar;
    }

    public byte getOrientation() {
        return this.mOrientation;
    }

    public byte setOrientation(byte b) {
        this.mOrientation = b;
        return b;
    }

    public void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    public void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    public void setOnPanoramaScrollListener(O000000o o000000o) {
        this.mOnPanoramaScrollListener = o000000o;
    }

    public void setGyroscopeObserver(euu euu) {
        if (euu != null && !euu.f15836O000000o.contains(this)) {
            euu.f15836O000000o.addFirst(this);
        }
    }
}
