package com.nineoldandroids.view;

import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.WeakHashMap;

public abstract class ViewPropertyAnimator {
    private static final WeakHashMap<View, ViewPropertyAnimator> ANIMATORS = new WeakHashMap<>(0);

    public abstract ViewPropertyAnimator alpha(float f);

    public abstract ViewPropertyAnimator alphaBy(float f);

    public abstract void cancel();

    public abstract long getDuration();

    public abstract long getStartDelay();

    public abstract ViewPropertyAnimator rotation(float f);

    public abstract ViewPropertyAnimator rotationBy(float f);

    public abstract ViewPropertyAnimator rotationX(float f);

    public abstract ViewPropertyAnimator rotationXBy(float f);

    public abstract ViewPropertyAnimator rotationY(float f);

    public abstract ViewPropertyAnimator rotationYBy(float f);

    public abstract ViewPropertyAnimator scaleX(float f);

    public abstract ViewPropertyAnimator scaleXBy(float f);

    public abstract ViewPropertyAnimator scaleY(float f);

    public abstract ViewPropertyAnimator scaleYBy(float f);

    public abstract ViewPropertyAnimator setDuration(long j);

    public abstract ViewPropertyAnimator setInterpolator(Interpolator interpolator);

    public abstract ViewPropertyAnimator setListener(Animator.AnimatorListener animatorListener);

    public abstract ViewPropertyAnimator setStartDelay(long j);

    public abstract void start();

    public abstract ViewPropertyAnimator translationX(float f);

    public abstract ViewPropertyAnimator translationXBy(float f);

    public abstract ViewPropertyAnimator translationY(float f);

    public abstract ViewPropertyAnimator translationYBy(float f);

    public abstract ViewPropertyAnimator x(float f);

    public abstract ViewPropertyAnimator xBy(float f);

    public abstract ViewPropertyAnimator y(float f);

    public abstract ViewPropertyAnimator yBy(float f);

    public static ViewPropertyAnimator animate(View view) {
        ViewPropertyAnimator viewPropertyAnimator = ANIMATORS.get(view);
        if (viewPropertyAnimator == null) {
            int intValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            if (intValue >= 14) {
                viewPropertyAnimator = new ViewPropertyAnimatorICS(view);
            } else if (intValue >= 11) {
                viewPropertyAnimator = new ViewPropertyAnimatorHC(view);
            } else {
                viewPropertyAnimator = new ViewPropertyAnimatorPreHC(view);
            }
            ANIMATORS.put(view, viewPropertyAnimator);
        }
        return viewPropertyAnimator;
    }
}
