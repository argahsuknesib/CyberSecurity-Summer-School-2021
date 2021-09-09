package com.google.android.material.progressindicator;

import _m_j.eo;
import _m_j.jp;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> ANIMATION_FRACTION = new Property<CircularIndeterminateAnimatorDelegate, Float>(Float.class, "animationFraction") {
        /* class com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass3 */

        public final Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.getAnimationFraction());
        }

        public final void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f) {
            circularIndeterminateAnimatorDelegate.setAnimationFraction(f.floatValue());
        }
    };
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> COMPLETE_END_FRACTION = new Property<CircularIndeterminateAnimatorDelegate, Float>(Float.class, "completeEndFraction") {
        /* class com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass4 */

        public final Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.getCompleteEndFraction());
        }

        public final void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f) {
            circularIndeterminateAnimatorDelegate.setCompleteEndFraction(f.floatValue());
        }
    };
    private static final int[] DELAY_TO_COLLAPSE_IN_MS = {667, 2017, 3367, 4717};
    private static final int[] DELAY_TO_EXPAND_IN_MS = {0, 1350, 2700, 4050};
    private static final int[] DELAY_TO_FADE_IN_MS = {1000, 2350, 3700, 5050};
    private float animationFraction;
    private ObjectAnimator animator;
    jp.O000000o animatorCompleteCallback = null;
    public final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    public int indicatorColorIndexOffset = 0;
    private final eo interpolator;

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.baseSpec = circularProgressIndicatorSpec;
        this.interpolator = new eo();
    }

    /* access modifiers changed from: package-private */
    public final void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            this.animator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator.setDuration(5400L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass1 */

                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset = (circularIndeterminateAnimatorDelegate.indicatorColorIndexOffset + 4) % CircularIndeterminateAnimatorDelegate.this.baseSpec.indicatorColors.length;
                }
            });
        }
        if (this.completeEndAnimator == null) {
            this.completeEndAnimator = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, 0.0f, 1.0f);
            this.completeEndAnimator.setDuration(333L);
            this.completeEndAnimator.setInterpolator(this.interpolator);
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.AnonymousClass2 */

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate.this.cancelAnimatorImmediately();
                    CircularIndeterminateAnimatorDelegate.this.animatorCompleteCallback.onAnimationEnd(CircularIndeterminateAnimatorDelegate.this.drawable);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public final void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public final void requestCancelAnimatorAfterCurrentCycle() {
        if (!this.completeEndAnimator.isRunning()) {
            if (this.drawable.isVisible()) {
                this.completeEndAnimator.start();
            } else {
                cancelAnimatorImmediately();
            }
        }
    }

    public final void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    public final void registerAnimatorsCompleteCallback(jp.O000000o o000000o) {
        this.animatorCompleteCallback = o000000o;
    }

    public final void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }

    private void updateSegmentPositions(int i) {
        this.segmentPositions[0] = (this.animationFraction * 1520.0f) - 0.21875f;
        this.segmentPositions[1] = this.animationFraction * 1520.0f;
        for (int i2 = 0; i2 < 4; i2++) {
            float fractionInRange = getFractionInRange(i, DELAY_TO_EXPAND_IN_MS[i2], 667);
            float[] fArr = this.segmentPositions;
            fArr[1] = fArr[1] + (this.interpolator.getInterpolation(fractionInRange) * 250.0f);
            float fractionInRange2 = getFractionInRange(i, DELAY_TO_COLLAPSE_IN_MS[i2], 667);
            float[] fArr2 = this.segmentPositions;
            fArr2[0] = fArr2[0] + (this.interpolator.getInterpolation(fractionInRange2) * 250.0f);
        }
        float[] fArr3 = this.segmentPositions;
        fArr3[0] = fArr3[0] + ((this.segmentPositions[1] - this.segmentPositions[0]) * this.completeEndFraction);
        float[] fArr4 = this.segmentPositions;
        fArr4[0] = fArr4[0] / 360.0f;
        float[] fArr5 = this.segmentPositions;
        fArr5[1] = fArr5[1] / 360.0f;
    }

    private void maybeUpdateSegmentColors(int i) {
        int i2 = 0;
        while (i2 < 4) {
            float fractionInRange = getFractionInRange(i, DELAY_TO_FADE_IN_MS[i2], 333);
            if (fractionInRange < 0.0f || fractionInRange > 1.0f) {
                i2++;
            } else {
                int length = (i2 + this.indicatorColorIndexOffset) % this.baseSpec.indicatorColors.length;
                int length2 = (length + 1) % this.baseSpec.indicatorColors.length;
                int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[length], this.drawable.getAlpha());
                int compositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[length2], this.drawable.getAlpha());
                this.segmentColors[0] = ArgbEvaluatorCompat.getInstance().evaluate(this.interpolator.getInterpolation(fractionInRange), Integer.valueOf(compositeARGBWithAlpha), Integer.valueOf(compositeARGBWithAlpha2)).intValue();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.segmentColors[0] = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.completeEndFraction = 0.0f;
    }

    public final float getAnimationFraction() {
        return this.animationFraction;
    }

    /* access modifiers changed from: package-private */
    public final void setAnimationFraction(float f) {
        this.animationFraction = f;
        int i = (int) (this.animationFraction * 5400.0f);
        updateSegmentPositions(i);
        maybeUpdateSegmentColors(i);
        this.drawable.invalidateSelf();
    }

    public final float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    public final void setCompleteEndFraction(float f) {
        this.completeEndFraction = f;
    }
}
