package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AspectRatioFrameLayout extends FrameLayout {
    public AspectRatioListener aspectRatioListener;
    private final AspectRatioUpdateDispatcher aspectRatioUpdateDispatcher;
    private int resizeMode;
    private float videoAspectRatio;

    public interface AspectRatioListener {
        void onAspectRatioUpdated(float f, float f2, boolean z);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResizeMode {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.resizeMode = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.resize_mode}, 0, 0);
            try {
                this.resizeMode = obtainStyledAttributes.getInt(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.aspectRatioUpdateDispatcher = new AspectRatioUpdateDispatcher();
    }

    public final void setAspectRatio(float f) {
        if (this.videoAspectRatio != f) {
            this.videoAspectRatio = f;
            requestLayout();
        }
    }

    public final void setAspectRatioListener(AspectRatioListener aspectRatioListener2) {
        this.aspectRatioListener = aspectRatioListener2;
    }

    public final int getResizeMode() {
        return this.resizeMode;
    }

    public final void setResizeMode(int i) {
        if (this.resizeMode != i) {
            this.resizeMode = i;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        float f;
        float f2;
        super.onMeasure(i, i2);
        if (this.videoAspectRatio > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f3 = (float) measuredWidth;
            float f4 = (float) measuredHeight;
            float f5 = f3 / f4;
            float f6 = (this.videoAspectRatio / f5) - 1.0f;
            if (Math.abs(f6) <= 0.01f) {
                this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f5, false);
                return;
            }
            int i3 = this.resizeMode;
            if (i3 != 0) {
                if (i3 == 1) {
                    f2 = this.videoAspectRatio;
                } else if (i3 != 2) {
                    if (i3 == 4) {
                        if (f6 <= 0.0f) {
                            f2 = this.videoAspectRatio;
                        }
                        f = this.videoAspectRatio;
                    }
                    this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f5, true);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                } else {
                    f = this.videoAspectRatio;
                }
                measuredHeight = (int) (f3 / f2);
                this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f5, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            if (f6 > 0.0f) {
                f2 = this.videoAspectRatio;
                measuredHeight = (int) (f3 / f2);
                this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f5, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            f = this.videoAspectRatio;
            measuredWidth = (int) (f4 * f);
            this.aspectRatioUpdateDispatcher.scheduleUpdate(this.videoAspectRatio, f5, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    final class AspectRatioUpdateDispatcher implements Runnable {
        private boolean aspectRatioMismatch;
        private boolean isScheduled;
        private float naturalAspectRatio;
        private float targetAspectRatio;

        private AspectRatioUpdateDispatcher() {
        }

        public final void scheduleUpdate(float f, float f2, boolean z) {
            this.targetAspectRatio = f;
            this.naturalAspectRatio = f2;
            this.aspectRatioMismatch = z;
            if (!this.isScheduled) {
                this.isScheduled = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public final void run() {
            this.isScheduled = false;
            if (AspectRatioFrameLayout.this.aspectRatioListener != null) {
                AspectRatioFrameLayout.this.aspectRatioListener.onAspectRatioUpdated(this.targetAspectRatio, this.naturalAspectRatio, this.aspectRatioMismatch);
            }
        }
    }
}
