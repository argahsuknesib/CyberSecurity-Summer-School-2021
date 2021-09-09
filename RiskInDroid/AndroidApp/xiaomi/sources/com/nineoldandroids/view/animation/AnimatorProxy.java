package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);
    private static final WeakHashMap<View, AnimatorProxy> PROXIES = new WeakHashMap<>();
    private final RectF mAfter = new RectF();
    private float mAlpha = 1.0f;
    private final RectF mBefore = new RectF();
    private final Camera mCamera = new Camera();
    private boolean mHasPivot;
    private float mPivotX;
    private float mPivotY;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private float mScaleX = 1.0f;
    private float mScaleY = 1.0f;
    private final Matrix mTempMatrix = new Matrix();
    private float mTranslationX;
    private float mTranslationY;
    private final WeakReference<View> mView;

    public static AnimatorProxy wrap(View view) {
        AnimatorProxy animatorProxy = PROXIES.get(view);
        if (animatorProxy != null && animatorProxy == view.getAnimation()) {
            return animatorProxy;
        }
        AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
        PROXIES.put(view, animatorProxy2);
        return animatorProxy2;
    }

    private AnimatorProxy(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.mView = new WeakReference<>(view);
    }

    public final float getAlpha() {
        return this.mAlpha;
    }

    public final void setAlpha(float f) {
        if (this.mAlpha != f) {
            this.mAlpha = f;
            View view = this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public final float getPivotX() {
        return this.mPivotX;
    }

    public final void setPivotX(float f) {
        if (!this.mHasPivot || this.mPivotX != f) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotX = f;
            invalidateAfterUpdate();
        }
    }

    public final float getPivotY() {
        return this.mPivotY;
    }

    public final void setPivotY(float f) {
        if (!this.mHasPivot || this.mPivotY != f) {
            prepareForUpdate();
            this.mHasPivot = true;
            this.mPivotY = f;
            invalidateAfterUpdate();
        }
    }

    public final float getRotation() {
        return this.mRotationZ;
    }

    public final void setRotation(float f) {
        if (this.mRotationZ != f) {
            prepareForUpdate();
            this.mRotationZ = f;
            invalidateAfterUpdate();
        }
    }

    public final float getRotationX() {
        return this.mRotationX;
    }

    public final void setRotationX(float f) {
        if (this.mRotationX != f) {
            prepareForUpdate();
            this.mRotationX = f;
            invalidateAfterUpdate();
        }
    }

    public final float getRotationY() {
        return this.mRotationY;
    }

    public final void setRotationY(float f) {
        if (this.mRotationY != f) {
            prepareForUpdate();
            this.mRotationY = f;
            invalidateAfterUpdate();
        }
    }

    public final float getScaleX() {
        return this.mScaleX;
    }

    public final void setScaleX(float f) {
        if (this.mScaleX != f) {
            prepareForUpdate();
            this.mScaleX = f;
            invalidateAfterUpdate();
        }
    }

    public final float getScaleY() {
        return this.mScaleY;
    }

    public final void setScaleY(float f) {
        if (this.mScaleY != f) {
            prepareForUpdate();
            this.mScaleY = f;
            invalidateAfterUpdate();
        }
    }

    public final int getScrollX() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public final void setScrollX(int i) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    public final int getScrollY() {
        View view = this.mView.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public final void setScrollY(int i) {
        View view = this.mView.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    public final float getTranslationX() {
        return this.mTranslationX;
    }

    public final void setTranslationX(float f) {
        if (this.mTranslationX != f) {
            prepareForUpdate();
            this.mTranslationX = f;
            invalidateAfterUpdate();
        }
    }

    public final float getTranslationY() {
        return this.mTranslationY;
    }

    public final void setTranslationY(float f) {
        if (this.mTranslationY != f) {
            prepareForUpdate();
            this.mTranslationY = f;
            invalidateAfterUpdate();
        }
    }

    public final float getX() {
        View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.mTranslationX;
    }

    public final void setX(float f) {
        View view = this.mView.get();
        if (view != null) {
            setTranslationX(f - ((float) view.getLeft()));
        }
    }

    public final float getY() {
        View view = this.mView.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.mTranslationY;
    }

    public final void setY(float f) {
        View view = this.mView.get();
        if (view != null) {
            setTranslationY(f - ((float) view.getTop()));
        }
    }

    private void prepareForUpdate() {
        View view = this.mView.get();
        if (view != null) {
            computeRect(this.mBefore, view);
        }
    }

    private void invalidateAfterUpdate() {
        View view = this.mView.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.mAfter;
            computeRect(rectF, view);
            rectF.union(this.mBefore);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    private void computeRect(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.mTempMatrix;
        matrix.reset();
        transformMatrix(matrix, view);
        this.mTempMatrix.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    private void transformMatrix(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.mHasPivot;
        float f = z ? this.mPivotX : width / 2.0f;
        float f2 = z ? this.mPivotY : height / 2.0f;
        float f3 = this.mRotationX;
        float f4 = this.mRotationY;
        float f5 = this.mRotationZ;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.mCamera;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.mScaleX;
        float f7 = this.mScaleY;
        if (!(f6 == 1.0f && f7 == 1.0f)) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.mTranslationX, this.mTranslationY);
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f, Transformation transformation) {
        View view = this.mView.get();
        if (view != null) {
            transformation.setAlpha(this.mAlpha);
            transformMatrix(transformation.getMatrix(), view);
        }
    }
}
