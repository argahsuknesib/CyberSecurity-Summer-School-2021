package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    public final Animator createAppear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, 0.0f, alpha, 0.35f, 1.0f, alpha);
    }

    public final Animator createDisappear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeThroughAnimator(view, alpha, 0.0f, 0.0f, 0.35f, alpha);
    }

    private static Animator createFadeThroughAnimator(final View view, float f, float f2, float f3, float f4, final float f5) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final View view2 = view;
        final float f6 = f;
        final float f7 = f2;
        final float f8 = f3;
        final float f9 = f4;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.transition.FadeThroughProvider.AnonymousClass1 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view2.setAlpha(TransitionUtils.lerp(f6, f7, f8, f9, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.transition.FadeThroughProvider.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                view.setAlpha(f5);
            }
        });
        return ofFloat;
    }
}
