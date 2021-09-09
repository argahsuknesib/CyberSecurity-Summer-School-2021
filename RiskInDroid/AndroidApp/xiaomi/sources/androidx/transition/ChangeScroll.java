package androidx.transition;

import _m_j.ir;
import _m_j.is;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f3005O000000o = {"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void captureStartValues(is isVar) {
        O000000o(isVar);
    }

    public void captureEndValues(is isVar) {
        O000000o(isVar);
    }

    public String[] getTransitionProperties() {
        return f3005O000000o;
    }

    private static void O000000o(is isVar) {
        isVar.f1596O000000o.put("android:changeScroll:x", Integer.valueOf(isVar.O00000Oo.getScrollX()));
        isVar.f1596O000000o.put("android:changeScroll:y", Integer.valueOf(isVar.O00000Oo.getScrollY()));
    }

    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2 = null;
        if (isVar == null || isVar2 == null) {
            return null;
        }
        View view = isVar2.O00000Oo;
        int intValue = ((Integer) isVar.f1596O000000o.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) isVar2.f1596O000000o.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) isVar.f1596O000000o.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) isVar2.f1596O000000o.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            objectAnimator = ObjectAnimator.ofInt(view, "scrollX", intValue, intValue2);
        } else {
            objectAnimator = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            objectAnimator2 = ObjectAnimator.ofInt(view, "scrollY", intValue3, intValue4);
        }
        return ir.O000000o(objectAnimator, objectAnimator2);
    }
}
