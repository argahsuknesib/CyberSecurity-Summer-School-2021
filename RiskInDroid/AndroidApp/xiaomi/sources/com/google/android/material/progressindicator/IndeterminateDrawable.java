package com.google.android.material.progressindicator;

import _m_j.jp;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.os.Build;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;

    public final /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    public final /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public final /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public final /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    public final /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    public final /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public final /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    public final /* bridge */ /* synthetic */ void registerAnimationCallback(jp.O000000o o000000o) {
        super.registerAnimationCallback(o000000o);
    }

    public final /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public final /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    public final /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2, boolean z3) {
        return super.setVisible(z, z2, z3);
    }

    public final /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public final /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public final /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(jp.O000000o o000000o) {
        return super.unregisterAnimationCallback(o000000o);
    }

    IndeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate2, IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(drawingDelegate2);
        setAnimatorDelegate(indeterminateAnimatorDelegate);
    }

    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new IndeterminateDrawable<>(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec), linearProgressIndicatorSpec.indeterminateAnimationType == 0 ? new LinearIndeterminateContiguousAnimatorDelegate(linearProgressIndicatorSpec) : new LinearIndeterminateDisjointAnimatorDelegate(context, linearProgressIndicatorSpec));
    }

    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new IndeterminateDrawable<>(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec), new CircularIndeterminateAnimatorDelegate(circularProgressIndicatorSpec));
    }

    /* access modifiers changed from: package-private */
    public final boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        if (!isRunning()) {
            this.animatorDelegate.cancelAnimatorImmediately();
        }
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (z && (z3 || (Build.VERSION.SDK_INT <= 21 && systemAnimatorDurationScale > 0.0f))) {
            this.animatorDelegate.startAnimator();
        }
        return visibleInternal;
    }

    public final int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public final int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getGrowFraction());
            this.drawingDelegate.fillTrack(canvas, this.paint);
            for (int i = 0; i < this.animatorDelegate.segmentColors.length; i++) {
                int i2 = i * 2;
                this.drawingDelegate.fillIndicator(canvas, this.paint, this.animatorDelegate.segmentPositions[i2], this.animatorDelegate.segmentPositions[i2 + 1], this.animatorDelegate.segmentColors[i]);
            }
            canvas.restore();
        }
    }

    /* access modifiers changed from: package-private */
    public final IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    /* access modifiers changed from: package-private */
    public final void setAnimatorDelegate(IndeterminateAnimatorDelegate<ObjectAnimator> indeterminateAnimatorDelegate) {
        this.animatorDelegate = indeterminateAnimatorDelegate;
        indeterminateAnimatorDelegate.registerDrawable(this);
    }

    /* access modifiers changed from: package-private */
    public final DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    /* access modifiers changed from: package-private */
    public final void setDrawingDelegate(DrawingDelegate<S> drawingDelegate2) {
        this.drawingDelegate = drawingDelegate2;
        drawingDelegate2.registerDrawable(this);
    }
}
