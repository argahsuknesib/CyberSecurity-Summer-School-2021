package androidx.transition;

import _m_j.cb;
import _m_j.ik;
import _m_j.is;
import _m_j.jd;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f3001O000000o = {"android:clipBounds:clip"};

    public String[] getTransitionProperties() {
        return f3001O000000o;
    }

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void O000000o(is isVar) {
        View view = isVar.O00000Oo;
        if (view.getVisibility() != 8) {
            Rect O000OO00 = cb.O000OO00(view);
            isVar.f1596O000000o.put("android:clipBounds:clip", O000OO00);
            if (O000OO00 == null) {
                isVar.f1596O000000o.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public void captureStartValues(is isVar) {
        O000000o(isVar);
    }

    public void captureEndValues(is isVar) {
        O000000o(isVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        ObjectAnimator objectAnimator = null;
        if (isVar != null && isVar2 != null && isVar.f1596O000000o.containsKey("android:clipBounds:clip") && isVar2.f1596O000000o.containsKey("android:clipBounds:clip")) {
            Rect rect = (Rect) isVar.f1596O000000o.get("android:clipBounds:clip");
            Rect rect2 = (Rect) isVar2.f1596O000000o.get("android:clipBounds:clip");
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = isVar.f1596O000000o.get("android:clipBounds:bounds");
            } else if (rect2 == null) {
                rect2 = isVar2.f1596O000000o.get("android:clipBounds:bounds");
            }
            if (rect.equals(rect2)) {
                return null;
            }
            cb.O000000o(isVar2.O00000Oo, rect);
            objectAnimator = ObjectAnimator.ofObject(isVar2.O00000Oo, jd.O00000Oo, new ik(new Rect()), rect, rect2);
            if (z) {
                final View view = isVar2.O00000Oo;
                objectAnimator.addListener(new AnimatorListenerAdapter() {
                    /* class androidx.transition.ChangeClipBounds.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        cb.O000000o(view, (Rect) null);
                    }
                });
            }
        }
        return objectAnimator;
    }
}
