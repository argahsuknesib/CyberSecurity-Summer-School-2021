package _m_j;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.transition.Transition;
import android.transition.TransitionListenerAdapter;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public final class dfu extends Visibility {
    public final void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put("scale:scaleX", Float.valueOf(transitionValues.view.getScaleX()));
        transitionValues.values.put("scale:scaleY", Float.valueOf(transitionValues.view.getScaleY()));
    }

    private Animator O000000o(final View view, float f, float f2, TransitionValues transitionValues) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        float f3 = scaleX * f;
        float f4 = scaleX * f2;
        float f5 = f * scaleY;
        float f6 = f2 * scaleY;
        if (transitionValues != null) {
            Float f7 = (Float) transitionValues.values.get("scale:scaleX");
            Float f8 = (Float) transitionValues.values.get("scale:scaleY");
            if (!(f7 == null || f7.floatValue() == scaleX)) {
                f3 = f7.floatValue();
            }
            if (!(f8 == null || f8.floatValue() == scaleY)) {
                f5 = f8.floatValue();
            }
        }
        view.setScaleX(f3);
        view.setScaleY(f5);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, f3, f4), ObjectAnimator.ofFloat(view, View.SCALE_Y, f5, f6));
        addListener(new TransitionListenerAdapter() {
            /* class _m_j.dfu.AnonymousClass1 */

            public final void onTransitionEnd(Transition transition) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
                transition.removeListener(this);
            }
        });
        return animatorSet;
    }

    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return O000000o(view, 0.0f, 1.0f, transitionValues);
    }

    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return O000000o(view, 1.0f, 0.0f, transitionValues);
    }
}
