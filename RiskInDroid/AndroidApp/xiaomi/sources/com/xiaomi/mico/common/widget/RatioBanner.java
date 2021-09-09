package com.xiaomi.mico.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.xiaomi.smarthome.R;
import com.youth.banner.Banner;
import com.youth.banner.view.BannerViewPager;
import java.lang.reflect.Field;

public class RatioBanner extends Banner {
    private boolean hasCorner;
    private boolean isVisible;
    private boolean mIsFirstTimeAttachedToWindow;
    private boolean mNeedDSetFirstLayoutField;
    private Paint mPaint;
    private Path mPath;
    private float mRatio;
    private float rect_adius;
    private final RectF roundRect;

    public interface OnStateChange {
        boolean isActivate();

        void onActivate();

        void onDeactivate();
    }

    private void init() {
    }

    public RatioBanner(Context context) {
        this(context, null);
    }

    public RatioBanner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 2.5f;
        this.mIsFirstTimeAttachedToWindow = true;
        this.roundRect = new RectF();
        this.rect_adius = 12.0f;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_ratio});
            this.mRatio = obtainStyledAttributes.getFloat(0, 2.5f);
            obtainStyledAttributes.recycle();
        }
        this.mPath = new Path();
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.rect_adius *= getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (((float) size) / this.mRatio), 1073741824));
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mNeedDSetFirstLayoutField) {
            this.mNeedDSetFirstLayoutField = false;
            try {
                Field declaredField = Banner.class.getDeclaredField("viewPager");
                declaredField.setAccessible(true);
                Field declaredField2 = ViewPager.class.getDeclaredField("mFirstLayout");
                declaredField2.setAccessible(true);
                declaredField2.set((BannerViewPager) declaredField.get(this), Boolean.FALSE);
            } catch (Exception unused) {
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mIsFirstTimeAttachedToWindow) {
            this.mNeedDSetFirstLayoutField = true;
        }
        this.mIsFirstTimeAttachedToWindow = false;
    }

    public void setCorner(float f) {
        this.hasCorner = true;
        init();
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.hasCorner) {
            this.roundRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            draw28(canvas);
        } else {
            draw27(canvas);
        }
    }

    private void draw27(Canvas canvas) {
        if (this.hasCorner) {
            canvas.saveLayer(this.roundRect, null, 31);
            super.draw(canvas);
            canvas.drawPath(genPath(), this.mPaint);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    private void draw28(Canvas canvas) {
        if (this.hasCorner) {
            canvas.save();
            canvas.clipPath(genPath());
            super.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 28) {
            dispatchDraw28(canvas);
        } else {
            dispatchDraw27(canvas);
        }
    }

    private void dispatchDraw27(Canvas canvas) {
        canvas.saveLayer(this.roundRect, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(genPath(), this.mPaint);
        canvas.restore();
    }

    private void dispatchDraw28(Canvas canvas) {
        canvas.save();
        canvas.clipPath(genPath());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.isVisible = z;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.roundRect.set(0.0f, 0.0f, (float) i, (float) i2);
    }

    private Path genPath() {
        this.mPath.reset();
        Path path = this.mPath;
        RectF rectF = this.roundRect;
        float f = this.rect_adius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        return this.mPath;
    }

    public boolean isInvisible() {
        return !this.isVisible;
    }
}
