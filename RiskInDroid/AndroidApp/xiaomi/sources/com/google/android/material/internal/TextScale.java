package com.google.android.material.internal;

import _m_j.is;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import java.util.Map;

public class TextScale extends Transition {
    public void captureStartValues(is isVar) {
        captureValues(isVar);
    }

    public void captureEndValues(is isVar) {
        captureValues(isVar);
    }

    private void captureValues(is isVar) {
        if (isVar.O00000Oo instanceof TextView) {
            isVar.f1596O000000o.put("android:textscale:scale", Float.valueOf(((TextView) isVar.O00000Oo).getScaleX()));
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        if (isVar == null || isVar2 == null || !(isVar.O00000Oo instanceof TextView) || !(isVar2.O00000Oo instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) isVar2.O00000Oo;
        Map<String, Object> map = isVar.f1596O000000o;
        Map<String, Object> map2 = isVar2.f1596O000000o;
        float f = 1.0f;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.internal.TextScale.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
