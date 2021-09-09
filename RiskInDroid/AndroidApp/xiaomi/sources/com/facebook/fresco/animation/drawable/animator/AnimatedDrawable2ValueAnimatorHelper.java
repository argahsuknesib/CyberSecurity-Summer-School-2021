package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;

@TargetApi(11)
public class AnimatedDrawable2ValueAnimatorHelper {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [long, int]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    public static ValueAnimator createValueAnimator(AnimatedDrawable2 animatedDrawable2, int i) {
        ValueAnimator createValueAnimator = createValueAnimator(animatedDrawable2);
        if (createValueAnimator == null) {
            return null;
        }
        createValueAnimator.setRepeatCount((int) Math.max(((long) i) / animatedDrawable2.getLoopDurationMs(), 1L));
        return createValueAnimator;
    }

    public static ValueAnimator createValueAnimator(AnimatedDrawable2 animatedDrawable2) {
        int loopCount = animatedDrawable2.getLoopCount();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, (int) animatedDrawable2.getLoopDurationMs());
        valueAnimator.setDuration(animatedDrawable2.getLoopDurationMs());
        if (loopCount == 0) {
            loopCount = -1;
        }
        valueAnimator.setRepeatCount(loopCount);
        valueAnimator.setRepeatMode(1);
        valueAnimator.setInterpolator(null);
        valueAnimator.addUpdateListener(createAnimatorUpdateListener(animatedDrawable2));
        return valueAnimator;
    }

    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(final AnimatedDrawable2 animatedDrawable2) {
        return new ValueAnimator.AnimatorUpdateListener() {
            /* class com.facebook.fresco.animation.drawable.animator.AnimatedDrawable2ValueAnimatorHelper.AnonymousClass1 */

            @TargetApi(11)
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatedDrawable2.setLevel(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        };
    }

    private AnimatedDrawable2ValueAnimatorHelper() {
    }
}
