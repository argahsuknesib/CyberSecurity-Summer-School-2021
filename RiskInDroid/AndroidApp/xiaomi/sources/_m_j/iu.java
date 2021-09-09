package _m_j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.transition.Transition;
import com.xiaomi.smarthome.R;

public final class iu {
    public static Animator O000000o(View view, is isVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5;
        float f6;
        is isVar2 = isVar;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) isVar2.O00000Oo.getTag(R.id.transition_position);
        if (iArr != null) {
            f5 = ((float) (iArr[0] - i)) + translationX;
            f6 = ((float) (iArr[1] - i2)) + translationY;
        } else {
            f5 = f;
            f6 = f2;
        }
        int round = i + Math.round(f5 - translationX);
        int round2 = i2 + Math.round(f6 - translationY);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        if (f5 == f3 && f6 == f4) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f6, f4));
        O000000o o000000o = new O000000o(view, isVar2.O00000Oo, round, round2, translationX, translationY);
        transition.addListener(o000000o);
        ofPropertyValuesHolder.addListener(o000000o);
        hw.O000000o(ofPropertyValuesHolder, o000000o);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    static class O000000o extends AnimatorListenerAdapter implements Transition.O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final View f1628O000000o;
        private final View O00000Oo;
        private final int O00000o;
        private final int O00000o0;
        private int[] O00000oO = ((int[]) this.f1628O000000o.getTag(R.id.transition_position));
        private float O00000oo;
        private float O0000O0o;
        private final float O0000OOo;
        private final float O0000Oo0;

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionPause(Transition transition) {
        }

        public final void onTransitionResume(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }

        O000000o(View view, View view2, int i, int i2, float f, float f2) {
            this.O00000Oo = view;
            this.f1628O000000o = view2;
            this.O00000o0 = i - Math.round(this.O00000Oo.getTranslationX());
            this.O00000o = i2 - Math.round(this.O00000Oo.getTranslationY());
            this.O0000OOo = f;
            this.O0000Oo0 = f2;
            if (this.O00000oO != null) {
                this.f1628O000000o.setTag(R.id.transition_position, null);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            if (this.O00000oO == null) {
                this.O00000oO = new int[2];
            }
            this.O00000oO[0] = Math.round(((float) this.O00000o0) + this.O00000Oo.getTranslationX());
            this.O00000oO[1] = Math.round(((float) this.O00000o) + this.O00000Oo.getTranslationY());
            this.f1628O000000o.setTag(R.id.transition_position, this.O00000oO);
        }

        public final void onAnimationPause(Animator animator) {
            this.O00000oo = this.O00000Oo.getTranslationX();
            this.O0000O0o = this.O00000Oo.getTranslationY();
            this.O00000Oo.setTranslationX(this.O0000OOo);
            this.O00000Oo.setTranslationY(this.O0000Oo0);
        }

        public final void onAnimationResume(Animator animator) {
            this.O00000Oo.setTranslationX(this.O00000oo);
            this.O00000Oo.setTranslationY(this.O0000O0o);
        }

        public final void onTransitionEnd(Transition transition) {
            this.O00000Oo.setTranslationX(this.O0000OOo);
            this.O00000Oo.setTranslationY(this.O0000Oo0);
            transition.removeListener(this);
        }
    }
}
