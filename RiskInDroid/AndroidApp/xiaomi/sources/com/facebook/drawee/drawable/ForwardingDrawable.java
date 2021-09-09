package com.facebook.drawee.drawable;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class ForwardingDrawable extends Drawable implements Drawable.Callback, DrawableParent, TransformAwareDrawable, TransformCallback {
    private static final Matrix sTempTransform = new Matrix();
    private Drawable mCurrentDelegate;
    private final DrawableProperties mDrawableProperties = new DrawableProperties();
    protected TransformCallback mTransformCallback;

    public ForwardingDrawable(Drawable drawable) {
        this.mCurrentDelegate = drawable;
        DrawableUtils.setCallbacks(this.mCurrentDelegate, this, this);
    }

    public Drawable setCurrent(Drawable drawable) {
        Drawable currentWithoutInvalidate = setCurrentWithoutInvalidate(drawable);
        invalidateSelf();
        return currentWithoutInvalidate;
    }

    /* access modifiers changed from: protected */
    public Drawable setCurrentWithoutInvalidate(Drawable drawable) {
        Drawable drawable2 = this.mCurrentDelegate;
        DrawableUtils.setCallbacks(drawable2, null, null);
        DrawableUtils.setCallbacks(drawable, null, null);
        DrawableUtils.setDrawableProperties(drawable, this.mDrawableProperties);
        DrawableUtils.copyProperties(drawable, this);
        DrawableUtils.setCallbacks(drawable, this, this);
        this.mCurrentDelegate = drawable;
        return drawable2;
    }

    public int getOpacity() {
        return this.mCurrentDelegate.getOpacity();
    }

    public void setAlpha(int i) {
        this.mDrawableProperties.setAlpha(i);
        this.mCurrentDelegate.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawableProperties.setColorFilter(colorFilter);
        this.mCurrentDelegate.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.mDrawableProperties.setDither(z);
        this.mCurrentDelegate.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawableProperties.setFilterBitmap(z);
        this.mCurrentDelegate.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.mCurrentDelegate.setVisible(z, z2);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.mCurrentDelegate.setBounds(rect);
    }

    public Drawable.ConstantState getConstantState() {
        return this.mCurrentDelegate.getConstantState();
    }

    public boolean isStateful() {
        return this.mCurrentDelegate.isStateful();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return this.mCurrentDelegate.setState(iArr);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.mCurrentDelegate.setLevel(i);
    }

    public void draw(Canvas canvas) {
        this.mCurrentDelegate.draw(canvas);
    }

    public int getIntrinsicWidth() {
        return this.mCurrentDelegate.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mCurrentDelegate.getIntrinsicHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mCurrentDelegate.getPadding(rect);
    }

    public Drawable mutate() {
        this.mCurrentDelegate.mutate();
        return this;
    }

    public Drawable getCurrent() {
        return this.mCurrentDelegate;
    }

    public Drawable setDrawable(Drawable drawable) {
        return setCurrent(drawable);
    }

    public Drawable getDrawable() {
        return getCurrent();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public void setTransformCallback(TransformCallback transformCallback) {
        this.mTransformCallback = transformCallback;
    }

    /* access modifiers changed from: protected */
    public void getParentTransform(Matrix matrix) {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getTransform(matrix);
        } else {
            matrix.reset();
        }
    }

    public void getTransform(Matrix matrix) {
        getParentTransform(matrix);
    }

    public void getRootBounds(RectF rectF) {
        TransformCallback transformCallback = this.mTransformCallback;
        if (transformCallback != null) {
            transformCallback.getRootBounds(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public void getTransformedBounds(RectF rectF) {
        getParentTransform(sTempTransform);
        rectF.set(getBounds());
        sTempTransform.mapRect(rectF);
    }

    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        this.mCurrentDelegate.setHotspot(f, f2);
    }
}
