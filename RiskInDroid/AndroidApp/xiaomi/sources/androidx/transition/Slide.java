package androidx.transition;

import _m_j.cb;
import _m_j.im;
import _m_j.in;
import _m_j.is;
import _m_j.iu;
import _m_j.n;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final TimeInterpolator f3015O000000o = new DecelerateInterpolator();
    private static final TimeInterpolator O00000Oo = new AccelerateInterpolator();
    private static final O000000o O00000oO = new O00000Oo() {
        /* class androidx.transition.Slide.AnonymousClass1 */

        public final float O000000o(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final O000000o O00000oo = new O00000Oo() {
        /* class androidx.transition.Slide.AnonymousClass2 */

        public final float O000000o(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (cb.O0000Oo0(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() + ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() - ((float) viewGroup.getWidth());
        }
    };
    private static final O000000o O0000O0o = new O00000o0() {
        /* class androidx.transition.Slide.AnonymousClass3 */

        public final float O00000Oo(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - ((float) viewGroup.getHeight());
        }
    };
    private static final O000000o O0000OOo = new O00000Oo() {
        /* class androidx.transition.Slide.AnonymousClass4 */

        public final float O000000o(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private static final O000000o O0000Oo = new O00000o0() {
        /* class androidx.transition.Slide.AnonymousClass6 */

        public final float O00000Oo(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + ((float) viewGroup.getHeight());
        }
    };
    private static final O000000o O0000Oo0 = new O00000Oo() {
        /* class androidx.transition.Slide.AnonymousClass5 */

        public final float O000000o(ViewGroup viewGroup, View view) {
            boolean z = true;
            if (cb.O0000Oo0(viewGroup) != 1) {
                z = false;
            }
            if (z) {
                return view.getTranslationX() - ((float) viewGroup.getWidth());
            }
            return view.getTranslationX() + ((float) viewGroup.getWidth());
        }
    };
    private int O00000o = 80;
    private O000000o O00000o0 = O0000Oo;

    interface O000000o {
        float O000000o(ViewGroup viewGroup, View view);

        float O00000Oo(ViewGroup viewGroup, View view);
    }

    static abstract class O00000Oo implements O000000o {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final float O00000Oo(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    static abstract class O00000o0 implements O000000o {
        private O00000o0() {
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }

        public final float O000000o(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        O000000o(80);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O0000OOo);
        int O000000o2 = n.O000000o(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        O000000o(O000000o2);
    }

    private static void O000000o(is isVar) {
        int[] iArr = new int[2];
        isVar.O00000Oo.getLocationOnScreen(iArr);
        isVar.f1596O000000o.put("android:slide:screenPosition", iArr);
    }

    public void captureStartValues(is isVar) {
        super.captureStartValues(isVar);
        O000000o(isVar);
    }

    public void captureEndValues(is isVar) {
        super.captureEndValues(isVar);
        O000000o(isVar);
    }

    private void O000000o(int i) {
        if (i == 3) {
            this.O00000o0 = O00000oO;
        } else if (i == 5) {
            this.O00000o0 = O0000OOo;
        } else if (i == 48) {
            this.O00000o0 = O0000O0o;
        } else if (i == 80) {
            this.O00000o0 = O0000Oo;
        } else if (i == 8388611) {
            this.O00000o0 = O00000oo;
        } else if (i == 8388613) {
            this.O00000o0 = O0000Oo0;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.O00000o = i;
        im imVar = new im();
        imVar.f1458O000000o = i;
        setPropagation(imVar);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        if (isVar2 == null) {
            return null;
        }
        int[] iArr = (int[]) isVar2.f1596O000000o.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return iu.O000000o(view, isVar2, iArr[0], iArr[1], this.O00000o0.O000000o(viewGroup, view), this.O00000o0.O00000Oo(viewGroup, view), translationX, translationY, f3015O000000o, this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        if (isVar == null) {
            return null;
        }
        int[] iArr = (int[]) isVar.f1596O000000o.get("android:slide:screenPosition");
        return iu.O000000o(view, isVar, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.O00000o0.O000000o(viewGroup, view), this.O00000o0.O00000Oo(viewGroup, view), O00000Oo, this);
    }
}
