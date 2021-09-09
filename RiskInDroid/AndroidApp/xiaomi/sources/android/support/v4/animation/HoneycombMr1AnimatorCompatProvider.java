package android.support.v4.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.view.View;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

@TargetApi(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
@RequiresApi(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
class HoneycombMr1AnimatorCompatProvider implements AnimatorProvider {
    private TimeInterpolator mDefaultInterpolator;

    HoneycombMr1AnimatorCompatProvider() {
    }

    public ValueAnimatorCompat emptyValueAnimator() {
        return new HoneycombValueAnimatorCompat(ValueAnimator.ofFloat(0.0f, 1.0f));
    }

    static class HoneycombValueAnimatorCompat implements ValueAnimatorCompat {
        final Animator mWrapped;

        public HoneycombValueAnimatorCompat(Animator animator) {
            this.mWrapped = animator;
        }

        public void setTarget(View view) {
            this.mWrapped.setTarget(view);
        }

        public void addListener(AnimatorListenerCompat animatorListenerCompat) {
            this.mWrapped.addListener(new AnimatorListenerCompatWrapper(animatorListenerCompat, this));
        }

        public void setDuration(long j) {
            this.mWrapped.setDuration(j);
        }

        public void start() {
            this.mWrapped.start();
        }

        public void cancel() {
            this.mWrapped.cancel();
        }

        public void addUpdateListener(final AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            Animator animator = this.mWrapped;
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class android.support.v4.animation.HoneycombMr1AnimatorCompatProvider.HoneycombValueAnimatorCompat.AnonymousClass1 */

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        animatorUpdateListenerCompat.onAnimationUpdate(HoneycombValueAnimatorCompat.this);
                    }
                });
            }
        }

        public float getAnimatedFraction() {
            return ((ValueAnimator) this.mWrapped).getAnimatedFraction();
        }
    }

    static class AnimatorListenerCompatWrapper implements Animator.AnimatorListener {
        final ValueAnimatorCompat mValueAnimatorCompat;
        final AnimatorListenerCompat mWrapped;

        public AnimatorListenerCompatWrapper(AnimatorListenerCompat animatorListenerCompat, ValueAnimatorCompat valueAnimatorCompat) {
            this.mWrapped = animatorListenerCompat;
            this.mValueAnimatorCompat = valueAnimatorCompat;
        }

        public void onAnimationStart(Animator animator) {
            this.mWrapped.onAnimationStart(this.mValueAnimatorCompat);
        }

        public void onAnimationEnd(Animator animator) {
            this.mWrapped.onAnimationEnd(this.mValueAnimatorCompat);
        }

        public void onAnimationCancel(Animator animator) {
            this.mWrapped.onAnimationCancel(this.mValueAnimatorCompat);
        }

        public void onAnimationRepeat(Animator animator) {
            this.mWrapped.onAnimationRepeat(this.mValueAnimatorCompat);
        }
    }

    public void clearInterpolator(View view) {
        if (this.mDefaultInterpolator == null) {
            this.mDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.mDefaultInterpolator);
    }
}
