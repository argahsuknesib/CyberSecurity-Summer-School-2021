package com.google.android.material.progressindicator;

import _m_j.jp;
import _m_j.jr;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.color.MaterialColors;
import com.xiaomi.smarthome.R;
import java.util.Arrays;

final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> ANIMATION_FRACTION = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") {
        /* class com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.AnonymousClass2 */

        public final Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.getAnimationFraction());
        }

        public final void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f) {
            linearIndeterminateDisjointAnimatorDelegate.setAnimationFraction(f.floatValue());
        }
    };
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = {1267, 1000, 333, 0};
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = {533, 567, 850, 750};
    private float animationFraction;
    public ObjectAnimator animator;
    jp.O000000o animatorCompleteCallback = null;
    public boolean animatorCompleteEndRequested;
    public final BaseProgressIndicatorSpec baseSpec;
    public boolean dirtyColors;
    public int indicatorColorIndex = 0;
    private final Interpolator[] interpolatorArray;

    public LinearIndeterminateDisjointAnimatorDelegate(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolatorArray = new Interpolator[]{jr.O000000o(context, R.animator.linear_indeterminate_line1_head_interpolator), jr.O000000o(context, R.animator.linear_indeterminate_line1_tail_interpolator), jr.O000000o(context, R.animator.linear_indeterminate_line2_head_interpolator), jr.O000000o(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    public final void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            this.animator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator.setDuration(1800L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() {
                /* class com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.AnonymousClass1 */

                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex = (linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex + 1) % LinearIndeterminateDisjointAnimatorDelegate.this.baseSpec.indicatorColors.length;
                    LinearIndeterminateDisjointAnimatorDelegate.this.dirtyColors = true;
                }

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteEndRequested) {
                        LinearIndeterminateDisjointAnimatorDelegate.this.animator.setRepeatCount(-1);
                        LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteCallback.onAnimationEnd(LinearIndeterminateDisjointAnimatorDelegate.this.drawable);
                        LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteEndRequested = false;
                    }
                }
            });
        }
    }

    public final void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public final void requestCancelAnimatorAfterCurrentCycle() {
        if (this.drawable.isVisible()) {
            this.animatorCompleteEndRequested = true;
            this.animator.setRepeatCount(0);
            return;
        }
        cancelAnimatorImmediately();
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

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(long, long):long}
      ClspMth{java.lang.Math.max(float, float):float} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.min(float, float):float}
     arg types: [int, float]
     candidates:
      ClspMth{java.lang.Math.min(double, double):double}
      ClspMth{java.lang.Math.min(long, long):long}
      ClspMth{java.lang.Math.min(int, int):int}
      ClspMth{java.lang.Math.min(float, float):float} */
    private void updateSegmentPositions(int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            this.segmentPositions[i2] = Math.max(0.0f, Math.min(1.0f, this.interpolatorArray[i2].getInterpolation(getFractionInRange(i, DELAY_TO_MOVE_SEGMENT_ENDS[i2], DURATION_TO_MOVE_SEGMENT_ENDS[i2]))));
        }
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors) {
            Arrays.fill(this.segmentColors, MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[this.indicatorColorIndex], this.drawable.getAlpha()));
            this.dirtyColors = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.drawable.getAlpha());
        this.segmentColors[0] = compositeARGBWithAlpha;
        this.segmentColors[1] = compositeARGBWithAlpha;
    }

    public final float getAnimationFraction() {
        return this.animationFraction;
    }

    /* access modifiers changed from: package-private */
    public final void setAnimationFraction(float f) {
        this.animationFraction = f;
        updateSegmentPositions((int) (this.animationFraction * 1800.0f));
        maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }
}
