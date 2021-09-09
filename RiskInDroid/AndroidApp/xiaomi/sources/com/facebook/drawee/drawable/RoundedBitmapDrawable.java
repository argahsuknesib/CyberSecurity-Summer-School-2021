package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class RoundedBitmapDrawable extends BitmapDrawable implements Rounded, TransformAwareDrawable {
    @VisibleForTesting
    final RectF mBitmapBounds;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private final Path mBorderPath;
    @VisibleForTesting
    final float[] mBorderRadii;
    private float mBorderWidth;
    @VisibleForTesting
    final Matrix mBoundsTransform;
    private final float[] mCornerRadii;
    @VisibleForTesting
    final RectF mDrawableBounds;
    @VisibleForTesting
    RectF mInsideBorderBounds;
    @VisibleForTesting
    float[] mInsideBorderRadii;
    @VisibleForTesting
    Matrix mInsideBorderTransform;
    @VisibleForTesting
    final Matrix mInverseParentTransform;
    private boolean mIsCircle;
    private boolean mIsPathDirty;
    private boolean mIsShaderTransformDirty;
    private WeakReference<Bitmap> mLastBitmap;
    private float mPadding;
    private final Paint mPaint;
    @VisibleForTesting
    final Matrix mParentTransform;
    private final Path mPath;
    @VisibleForTesting
    final Matrix mPrevBoundsTransform;
    @VisibleForTesting
    Matrix mPrevInsideBorderTransform;
    @VisibleForTesting
    final Matrix mPrevParentTransform;
    @VisibleForTesting
    final RectF mPrevRootBounds;
    private boolean mRadiiNonZero;
    @VisibleForTesting
    final RectF mRootBounds;
    private boolean mScaleDownInsideBorders;
    @VisibleForTesting
    final Matrix mTransform;
    private TransformCallback mTransformCallback;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap, Paint paint) {
        super(resources, bitmap);
        this.mIsCircle = false;
        this.mRadiiNonZero = false;
        this.mCornerRadii = new float[8];
        this.mBorderRadii = new float[8];
        this.mRootBounds = new RectF();
        this.mPrevRootBounds = new RectF();
        this.mBitmapBounds = new RectF();
        this.mDrawableBounds = new RectF();
        this.mBoundsTransform = new Matrix();
        this.mPrevBoundsTransform = new Matrix();
        this.mParentTransform = new Matrix();
        this.mPrevParentTransform = new Matrix();
        this.mInverseParentTransform = new Matrix();
        this.mTransform = new Matrix();
        this.mBorderWidth = 0.0f;
        this.mBorderColor = 0;
        this.mPadding = 0.0f;
        this.mScaleDownInsideBorders = false;
        this.mPath = new Path();
        this.mBorderPath = new Path();
        this.mIsPathDirty = true;
        this.mPaint = new Paint();
        this.mBorderPaint = new Paint(1);
        this.mIsShaderTransformDirty = true;
        if (paint != null) {
            this.mPaint.set(paint);
        }
        this.mPaint.setFlags(1);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
    }

    public static RoundedBitmapDrawable fromBitmapDrawable(Resources resources, BitmapDrawable bitmapDrawable) {
        return new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
    }

    public void setCircle(boolean z) {
        this.mIsCircle = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public void setRadius(float f) {
        boolean z = false;
        Preconditions.checkState(f >= 0.0f);
        Arrays.fill(this.mCornerRadii, f);
        if (f != 0.0f) {
            z = true;
        }
        this.mRadiiNonZero = z;
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.Arrays.fill(float[], float):void}
     arg types: [float[], int]
     candidates:
      ClspMth{java.util.Arrays.fill(double[], double):void}
      ClspMth{java.util.Arrays.fill(byte[], byte):void}
      ClspMth{java.util.Arrays.fill(long[], long):void}
      ClspMth{java.util.Arrays.fill(boolean[], boolean):void}
      ClspMth{java.util.Arrays.fill(char[], char):void}
      ClspMth{java.util.Arrays.fill(short[], short):void}
      ClspMth{java.util.Arrays.fill(java.lang.Object[], java.lang.Object):void}
      ClspMth{java.util.Arrays.fill(int[], int):void}
      ClspMth{java.util.Arrays.fill(float[], float):void} */
    public void setRadii(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.mCornerRadii, 0.0f);
            this.mRadiiNonZero = false;
        } else {
            Preconditions.checkArgument(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.mCornerRadii, 0, 8);
            this.mRadiiNonZero = false;
            for (int i = 0; i < 8; i++) {
                this.mRadiiNonZero |= fArr[i] > 0.0f;
            }
        }
        this.mIsPathDirty = true;
        invalidateSelf();
    }

    public float[] getRadii() {
        return this.mCornerRadii;
    }

    public void setBorder(int i, float f) {
        if (this.mBorderColor != i || this.mBorderWidth != f) {
            this.mBorderColor = i;
            this.mBorderWidth = f;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setPadding(float f) {
        if (this.mPadding != f) {
            this.mPadding = f;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public float getPadding() {
        return this.mPadding;
    }

    public void setScaleDownInsideBorders(boolean z) {
        if (this.mScaleDownInsideBorders != z) {
            this.mScaleDownInsideBorders = z;
            this.mIsPathDirty = true;
            invalidateSelf();
        }
    }

    public boolean getScaleDownInsideBorders() {
        return this.mScaleDownInsideBorders;
    }

    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            super.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        super.setColorFilter(colorFilter);
    }

    public void draw(Canvas canvas) {
        if (!shouldRound()) {
            super.draw(canvas);
            return;
        }
        updateTransform();
        updatePath();
        updatePaint();
        int save = canvas.save();
        canvas.concat(this.mInverseParentTransform);
        canvas.drawPath(this.mPath, this.mPaint);
        float f = this.mBorderWidth;
        if (f > 0.0f) {
            this.mBorderPaint.setStrokeWidth(f);
            this.mBorderPaint.setColor(DrawableUtils.multiplyColorAlpha(this.mBorderColor, this.mPaint.getAlpha()));
            canvas.drawPath(this.mBorderPath, this.mBorderPaint);
        }
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean shouldRound() {
        return (this.mIsCircle || this.mRadiiNonZero || this.mBorderWidth > 0.0f) && getBitmap() != null;
    }

    private void updateTransform() {
        Matrix matrix;
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(this.mParentTransform);
            this.mTransformCallback.getRootBounds(this.mRootBounds);
        } else {
            this.mParentTransform.reset();
            this.mRootBounds.set(getBounds());
        }
        this.mBitmapBounds.set(0.0f, 0.0f, (float) getBitmap().getWidth(), (float) getBitmap().getHeight());
        this.mDrawableBounds.set(getBounds());
        this.mBoundsTransform.setRectToRect(this.mBitmapBounds, this.mDrawableBounds, Matrix.ScaleToFit.FILL);
        if (this.mScaleDownInsideBorders) {
            RectF rectF = this.mInsideBorderBounds;
            if (rectF == null) {
                this.mInsideBorderBounds = new RectF(this.mRootBounds);
            } else {
                rectF.set(this.mRootBounds);
            }
            RectF rectF2 = this.mInsideBorderBounds;
            float f = this.mBorderWidth;
            rectF2.inset(f, f);
            if (this.mInsideBorderTransform == null) {
                this.mInsideBorderTransform = new Matrix();
            }
            this.mInsideBorderTransform.setRectToRect(this.mRootBounds, this.mInsideBorderBounds, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.mInsideBorderTransform;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.mParentTransform.equals(this.mPrevParentTransform) || !this.mBoundsTransform.equals(this.mPrevBoundsTransform) || ((matrix = this.mInsideBorderTransform) != null && !matrix.equals(this.mPrevInsideBorderTransform))) {
            this.mIsShaderTransformDirty = true;
            this.mParentTransform.invert(this.mInverseParentTransform);
            this.mTransform.set(this.mParentTransform);
            if (this.mScaleDownInsideBorders) {
                this.mTransform.postConcat(this.mInsideBorderTransform);
            }
            this.mTransform.preConcat(this.mBoundsTransform);
            this.mPrevParentTransform.set(this.mParentTransform);
            this.mPrevBoundsTransform.set(this.mBoundsTransform);
            if (this.mScaleDownInsideBorders) {
                Matrix matrix3 = this.mPrevInsideBorderTransform;
                if (matrix3 == null) {
                    this.mPrevInsideBorderTransform = new Matrix(this.mInsideBorderTransform);
                } else {
                    matrix3.set(this.mInsideBorderTransform);
                }
            } else {
                Matrix matrix4 = this.mPrevInsideBorderTransform;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (!this.mRootBounds.equals(this.mPrevRootBounds)) {
            this.mIsPathDirty = true;
            this.mPrevRootBounds.set(this.mRootBounds);
        }
    }

    private void updatePath() {
        float[] fArr;
        if (this.mIsPathDirty) {
            this.mBorderPath.reset();
            RectF rectF = this.mRootBounds;
            float f = this.mBorderWidth;
            rectF.inset(f / 2.0f, f / 2.0f);
            if (this.mIsCircle) {
                this.mBorderPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i = 0;
                while (true) {
                    fArr = this.mBorderRadii;
                    if (i >= fArr.length) {
                        break;
                    }
                    fArr[i] = (this.mCornerRadii[i] + this.mPadding) - (this.mBorderWidth / 2.0f);
                    i++;
                }
                this.mBorderPath.addRoundRect(this.mRootBounds, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.mRootBounds;
            float f2 = this.mBorderWidth;
            rectF2.inset((-f2) / 2.0f, (-f2) / 2.0f);
            this.mPath.reset();
            float f3 = this.mPadding + (this.mScaleDownInsideBorders ? this.mBorderWidth : 0.0f);
            this.mRootBounds.inset(f3, f3);
            if (this.mIsCircle) {
                this.mPath.addCircle(this.mRootBounds.centerX(), this.mRootBounds.centerY(), Math.min(this.mRootBounds.width(), this.mRootBounds.height()) / 2.0f, Path.Direction.CW);
            } else if (this.mScaleDownInsideBorders) {
                if (this.mInsideBorderRadii == null) {
                    this.mInsideBorderRadii = new float[8];
                }
                for (int i2 = 0; i2 < this.mBorderRadii.length; i2++) {
                    this.mInsideBorderRadii[i2] = this.mCornerRadii[i2] - this.mBorderWidth;
                }
                this.mPath.addRoundRect(this.mRootBounds, this.mInsideBorderRadii, Path.Direction.CW);
            } else {
                this.mPath.addRoundRect(this.mRootBounds, this.mCornerRadii, Path.Direction.CW);
            }
            float f4 = -f3;
            this.mRootBounds.inset(f4, f4);
            this.mPath.setFillType(Path.FillType.WINDING);
            this.mIsPathDirty = false;
        }
    }

    private void updatePaint() {
        Bitmap bitmap = getBitmap();
        WeakReference<Bitmap> weakReference = this.mLastBitmap;
        if (weakReference == null || weakReference.get() != bitmap) {
            this.mLastBitmap = new WeakReference<>(bitmap);
            Paint paint = this.mPaint;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.mIsShaderTransformDirty = true;
        }
        if (this.mIsShaderTransformDirty) {
            this.mPaint.getShader().setLocalMatrix(this.mTransform);
            this.mIsShaderTransformDirty = false;
        }
    }
}
