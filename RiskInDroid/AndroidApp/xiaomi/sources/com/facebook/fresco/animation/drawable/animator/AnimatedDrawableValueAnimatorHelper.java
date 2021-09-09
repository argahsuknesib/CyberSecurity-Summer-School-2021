package com.facebook.fresco.animation.drawable.animator;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;

public class AnimatedDrawableValueAnimatorHelper {
    public static ValueAnimator createValueAnimator(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 11 && (drawable instanceof AnimatedDrawable2)) {
            return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable, i);
        }
        return null;
    }

    public static ValueAnimator createValueAnimator(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 11 && (drawable instanceof AnimatedDrawable2)) {
            return AnimatedDrawable2ValueAnimatorHelper.createValueAnimator((AnimatedDrawable2) drawable);
        }
        return null;
    }

    public static ValueAnimator.AnimatorUpdateListener createAnimatorUpdateListener(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 11 && (drawable instanceof AnimatedDrawable2)) {
            return AnimatedDrawable2ValueAnimatorHelper.createAnimatorUpdateListener((AnimatedDrawable2) drawable);
        }
        return null;
    }

    private AnimatedDrawableValueAnimatorHelper() {
    }
}
