package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;

public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    private String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;
    private String mImageFormat;
    private String mImageId;
    private int mImageSizeBytes;
    private int mLineIncrementPx;
    private int mLoopCount;
    private final Matrix mMatrix = new Matrix();
    private final Paint mPaint = new Paint(1);
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();
    private ScalingUtils.ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mTextGravity = 80;
    private int mWidthPx;

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1;
        invalidateSelf();
    }

    public void setTextGravity(int i) {
        this.mTextGravity = i;
        invalidateSelf();
    }

    public void setControllerId(String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setImageId(String str) {
        this.mImageId = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.mWidthPx = i;
        this.mHeightPx = i2;
        invalidateSelf();
    }

    public void setAnimationInfo(int i, int i2) {
        this.mFrameCount = i;
        this.mLoopCount = i2;
        invalidateSelf();
    }

    public void setImageSize(int i) {
        this.mImageSizeBytes = i;
    }

    public void setImageFormat(String str) {
        this.mImageFormat = str;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 7, 7);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(-26624);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        String str = this.mImageId;
        if (str != null) {
            addDebugText(canvas, "IDs: %s, %s", this.mControllerId, str);
        } else {
            addDebugText(canvas, "ID: %s", this.mControllerId);
        }
        addDebugText(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        addDebugText(canvas, "I: %dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx));
        addDebugText(canvas, "I: %d KiB", Integer.valueOf(this.mImageSizeBytes / 1024));
        String str2 = this.mImageFormat;
        if (str2 != null) {
            addDebugText(canvas, "i format: %s", str2);
        }
        int i = this.mFrameCount;
        if (i > 0) {
            addDebugText(canvas, "anim: f %d, l %d", Integer.valueOf(i), Integer.valueOf(this.mLoopCount));
        }
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        if (scaleType != null) {
            addDebugText(canvas, "scale: %s", scaleType);
        }
        long j = this.mFinalImageTimeMs;
        if (j >= 0) {
            addDebugText(canvas, "t: %d ms", Long.valueOf(j));
        }
    }

    private void prepareDebugTextParameters(Rect rect, int i, int i2) {
        int min = Math.min(40, Math.max(12, Math.min(rect.width() / i2, rect.height() / i)));
        this.mPaint.setTextSize((float) min);
        this.mLineIncrementPx = min + 8;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx *= -1;
        }
        this.mStartTextXPx = rect.left + 10;
        this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : rect.top + 10 + 12;
    }

    private void addDebugText(Canvas canvas, String str, Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), (float) this.mCurrentTextXPx, (float) this.mCurrentTextYPx, this.mPaint);
        }
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int determineOverlayColor(int i, int i2, ScalingUtils.ScaleType scaleType) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i > 0 && i2 > 0) {
            if (scaleType != null) {
                Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.mMatrix.reset();
                scaleType.getTransform(this.mMatrix, this.mRect, i, i2, 0.0f, 0.0f);
                RectF rectF = this.mRectF;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = (float) i;
                rectF.bottom = (float) i2;
                this.mMatrix.mapRect(rectF);
                width = Math.min(width, (int) this.mRectF.width());
                height = Math.min(height, (int) this.mRectF.height());
            }
            float f = (float) width;
            float f2 = f * 0.1f;
            float f3 = f * 0.5f;
            float f4 = (float) height;
            float f5 = 0.1f * f4;
            float f6 = f4 * 0.5f;
            int abs = Math.abs(i - width);
            int abs2 = Math.abs(i2 - height);
            float f7 = (float) abs;
            if (f7 < f2 && ((float) abs2) < f5) {
                return 1716301648;
            }
            if (f7 >= f3 || ((float) abs2) >= f6) {
                return 1727284022;
            }
            return 1728026624;
        }
        return 1727284022;
    }

    public void setFinalImageTimeMs(long j) {
        this.mFinalImageTimeMs = j;
    }

    public void onFinalImageSet(long j) {
        this.mFinalImageTimeMs = j;
        invalidateSelf();
    }
}
