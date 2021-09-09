package androidx.transition;

import _m_j.cb;
import _m_j.in;
import _m_j.io;
import _m_j.is;
import _m_j.jd;
import _m_j.n;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;

public class Fade extends Visibility {
    public Fade(int i) {
        setMode(i);
    }

    public Fade() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
     arg types: [android.content.res.TypedArray, android.content.res.XmlResourceParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int */
    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O00000oo);
        setMode(n.O000000o(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }

    public void captureStartValues(is isVar) {
        super.captureStartValues(isVar);
        isVar.f1596O000000o.put("android:fade:transitionAlpha", Float.valueOf(jd.O00000o0(isVar.O00000Oo)));
    }

    private Animator O000000o(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        jd.O000000o(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, jd.f1771O000000o, f2);
        ofFloat.addListener(new O000000o(view));
        addListener(new io() {
            /* class androidx.transition.Fade.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.jd.O000000o(android.view.View, float):void
             arg types: [android.view.View, int]
             candidates:
              _m_j.jd.O000000o(android.view.View, int):void
              _m_j.jd.O000000o(android.view.View, android.graphics.Matrix):void
              _m_j.jd.O000000o(android.view.View, float):void */
            public final void onTransitionEnd(Transition transition) {
                jd.O000000o(view, 1.0f);
                jd.O00000oO(view);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        float f = 0.0f;
        float O000000o2 = O000000o(isVar, 0.0f);
        if (O000000o2 != 1.0f) {
            f = O000000o2;
        }
        return O000000o(view, f, 1.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        jd.O00000o(view);
        return O000000o(view, O000000o(isVar, 1.0f), 0.0f);
    }

    private static float O000000o(is isVar, float f) {
        Float f2;
        return (isVar == null || (f2 = (Float) isVar.f1596O000000o.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    static class O000000o extends AnimatorListenerAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        private final View f3013O000000o;
        private boolean O00000Oo = false;

        O000000o(View view) {
            this.f3013O000000o = view;
        }

        public final void onAnimationStart(Animator animator) {
            if (cb.O00oOooo(this.f3013O000000o) && this.f3013O000000o.getLayerType() == 0) {
                this.O00000Oo = true;
                this.f3013O000000o.setLayerType(2, null);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jd.O000000o(android.view.View, float):void
         arg types: [android.view.View, int]
         candidates:
          _m_j.jd.O000000o(android.view.View, int):void
          _m_j.jd.O000000o(android.view.View, android.graphics.Matrix):void
          _m_j.jd.O000000o(android.view.View, float):void */
        public final void onAnimationEnd(Animator animator) {
            jd.O000000o(this.f3013O000000o, 1.0f);
            if (this.O00000Oo) {
                this.f3013O000000o.setLayerType(0, null);
            }
        }
    }
}
