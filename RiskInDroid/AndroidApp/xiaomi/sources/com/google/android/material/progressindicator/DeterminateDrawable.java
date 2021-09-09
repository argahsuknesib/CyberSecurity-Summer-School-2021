package com.google.android.material.progressindicator;

import _m_j.du;
import _m_j.dv;
import _m_j.dw;
import _m_j.jp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final du<DeterminateDrawable> INDICATOR_LENGTH_IN_LEVEL = new du<DeterminateDrawable>("indicatorLevel") {
        /* class com.google.android.material.progressindicator.DeterminateDrawable.AnonymousClass1 */

        public final float getValue(DeterminateDrawable determinateDrawable) {
            return determinateDrawable.getIndicatorFraction() * 10000.0f;
        }

        public final void setValue(DeterminateDrawable determinateDrawable, float f) {
            determinateDrawable.setIndicatorFraction(f / 10000.0f);
        }
    };
    private DrawingDelegate<S> drawingDelegate;
    private float indicatorFraction;
    private boolean skipAnimationOnLevelChange = false;
    private final dv springAnimator;
    private final dw springForce;

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

    DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate2) {
        super(context, baseProgressIndicatorSpec);
        setDrawingDelegate(drawingDelegate2);
        this.springForce = new dw();
        dw dwVar = this.springForce;
        dwVar.O00000Oo = 1.0d;
        dwVar.O00000o0 = false;
        dwVar.O000000o(50.0f);
        this.springAnimator = new dv(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimator.O0000ooO = this.springForce;
        setGrowFraction(1.0f);
    }

    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    /* access modifiers changed from: package-private */
    public final boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            this.springForce.O000000o(50.0f / systemAnimatorDurationScale);
        }
        return visibleInternal;
    }

    public final void jumpToCurrentState() {
        this.springAnimator.O00000Oo();
        setIndicatorFraction(((float) getLevel()) / 10000.0f);
    }

    /* access modifiers changed from: protected */
    public final boolean onLevelChange(int i) {
        if (this.skipAnimationOnLevelChange) {
            this.springAnimator.O00000Oo();
            setIndicatorFraction(((float) i) / 10000.0f);
        } else {
            dv dvVar = this.springAnimator;
            dvVar.O0000o0o = getIndicatorFraction() * 10000.0f;
            dvVar.O0000o = true;
            this.springAnimator.O000000o((float) i);
        }
        return true;
    }

    public final int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    public final int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    /* access modifiers changed from: package-private */
    public final void setLevelByFraction(float f) {
        setLevel((int) (f * 10000.0f));
    }

    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getGrowFraction());
            this.drawingDelegate.fillTrack(canvas, this.paint);
            Canvas canvas2 = canvas;
            this.drawingDelegate.fillIndicator(canvas2, this.paint, 0.0f, getIndicatorFraction(), MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], getAlpha()));
            canvas.restore();
        }
    }

    public final float getIndicatorFraction() {
        return this.indicatorFraction;
    }

    public final void setIndicatorFraction(float f) {
        this.indicatorFraction = f;
        invalidateSelf();
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
