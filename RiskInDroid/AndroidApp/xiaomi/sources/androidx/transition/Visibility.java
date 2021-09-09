package androidx.transition;

import _m_j.hw;
import _m_j.in;
import _m_j.io;
import _m_j.ir;
import _m_j.is;
import _m_j.iy;
import _m_j.jd;
import _m_j.n;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.xiaomi.smarthome.R;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility extends Transition {
    private static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    private int mMode = 3;

    public Animator onAppear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, is isVar, is isVar2) {
        return null;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f3024O000000o;
        boolean O00000Oo;
        int O00000o;
        int O00000o0;
        ViewGroup O00000oO;
        ViewGroup O00000oo;

        O00000Oo() {
        }
    }

    public Visibility() {
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
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O00000oO);
        int O000000o2 = n.O000000o(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (O000000o2 != 0) {
            setMode(O000000o2);
        }
    }

    public void setMode(int i) {
        if ((i & -4) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(is isVar) {
        isVar.f1596O000000o.put("android:visibility:visibility", Integer.valueOf(isVar.O00000Oo.getVisibility()));
        isVar.f1596O000000o.put("android:visibility:parent", isVar.O00000Oo.getParent());
        int[] iArr = new int[2];
        isVar.O00000Oo.getLocationOnScreen(iArr);
        isVar.f1596O000000o.put("android:visibility:screenLocation", iArr);
    }

    public void captureStartValues(is isVar) {
        captureValues(isVar);
    }

    public void captureEndValues(is isVar) {
        captureValues(isVar);
    }

    public boolean isVisible(is isVar) {
        if (isVar == null) {
            return false;
        }
        int intValue = ((Integer) isVar.f1596O000000o.get("android:visibility:visibility")).intValue();
        View view = (View) isVar.f1596O000000o.get("android:visibility:parent");
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    private O00000Oo getVisibilityChangeInfo(is isVar, is isVar2) {
        O00000Oo o00000Oo = new O00000Oo();
        o00000Oo.f3024O000000o = false;
        o00000Oo.O00000Oo = false;
        if (isVar == null || !isVar.f1596O000000o.containsKey("android:visibility:visibility")) {
            o00000Oo.O00000o0 = -1;
            o00000Oo.O00000oO = null;
        } else {
            o00000Oo.O00000o0 = ((Integer) isVar.f1596O000000o.get("android:visibility:visibility")).intValue();
            o00000Oo.O00000oO = (ViewGroup) isVar.f1596O000000o.get("android:visibility:parent");
        }
        if (isVar2 == null || !isVar2.f1596O000000o.containsKey("android:visibility:visibility")) {
            o00000Oo.O00000o = -1;
            o00000Oo.O00000oo = null;
        } else {
            o00000Oo.O00000o = ((Integer) isVar2.f1596O000000o.get("android:visibility:visibility")).intValue();
            o00000Oo.O00000oo = (ViewGroup) isVar2.f1596O000000o.get("android:visibility:parent");
        }
        if (isVar == null || isVar2 == null) {
            if (isVar == null && o00000Oo.O00000o == 0) {
                o00000Oo.O00000Oo = true;
                o00000Oo.f3024O000000o = true;
            } else if (isVar2 == null && o00000Oo.O00000o0 == 0) {
                o00000Oo.O00000Oo = false;
                o00000Oo.f3024O000000o = true;
            }
        } else if (o00000Oo.O00000o0 == o00000Oo.O00000o && o00000Oo.O00000oO == o00000Oo.O00000oo) {
            return o00000Oo;
        } else {
            if (o00000Oo.O00000o0 != o00000Oo.O00000o) {
                if (o00000Oo.O00000o0 == 0) {
                    o00000Oo.O00000Oo = false;
                    o00000Oo.f3024O000000o = true;
                } else if (o00000Oo.O00000o == 0) {
                    o00000Oo.O00000Oo = true;
                    o00000Oo.f3024O000000o = true;
                }
            } else if (o00000Oo.O00000oo == null) {
                o00000Oo.O00000Oo = false;
                o00000Oo.f3024O000000o = true;
            } else if (o00000Oo.O00000oO == null) {
                o00000Oo.O00000Oo = true;
                o00000Oo.f3024O000000o = true;
            }
        }
        return o00000Oo;
    }

    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        O00000Oo visibilityChangeInfo = getVisibilityChangeInfo(isVar, isVar2);
        if (!visibilityChangeInfo.f3024O000000o) {
            return null;
        }
        if (visibilityChangeInfo.O00000oO == null && visibilityChangeInfo.O00000oo == null) {
            return null;
        }
        if (visibilityChangeInfo.O00000Oo) {
            return onAppear(viewGroup, isVar, visibilityChangeInfo.O00000o0, isVar2, visibilityChangeInfo.O00000o);
        }
        return onDisappear(viewGroup, isVar, visibilityChangeInfo.O00000o0, isVar2, visibilityChangeInfo.O00000o);
    }

    public Animator onAppear(ViewGroup viewGroup, is isVar, int i, is isVar2, int i2) {
        if ((this.mMode & 1) != 1 || isVar2 == null) {
            return null;
        }
        if (isVar == null) {
            View view = (View) isVar2.O00000Oo.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f3024O000000o) {
                return null;
            }
        }
        return onAppear(viewGroup, isVar2.O00000Oo, isVar, isVar2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0081, code lost:
        if (r10.mCanRemoveViews != false) goto L_0x0083;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
    public Animator onDisappear(final ViewGroup viewGroup, is isVar, int i, is isVar2, int i2) {
        View view;
        boolean z;
        boolean z2;
        if ((this.mMode & 2) != 2 || isVar == null) {
            return null;
        }
        final View view2 = isVar.O00000Oo;
        View view3 = isVar2 != null ? isVar2.O00000Oo : null;
        final View view4 = (View) view2.getTag(R.id.save_overlay_view);
        if (view4 != null) {
            view = null;
            z = true;
        } else {
            if (view3 == null || view3.getParent() == null) {
                if (view3 != null) {
                    view = null;
                    view4 = view3;
                }
                view4 = null;
                view = null;
                z2 = true;
                if (z2) {
                    if (view2.getParent() != null) {
                        if (view2.getParent() instanceof View) {
                            View view5 = (View) view2.getParent();
                            if (!getVisibilityChangeInfo(getTransitionValues(view5, true), getMatchedTransitionValues(view5, true)).f3024O000000o) {
                                view4 = ir.O000000o(viewGroup, view2, view5);
                            } else {
                                int id = view5.getId();
                                if (view5.getParent() == null) {
                                    if (id != -1) {
                                        if (viewGroup.findViewById(id) != null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    view4 = view2;
                }
                z = false;
            } else {
                if (i2 == 4 || view2 == view3) {
                    view4 = null;
                    view = view3;
                }
                view4 = null;
                view = null;
                z2 = true;
                if (z2) {
                }
                z = false;
            }
            z2 = false;
            if (z2) {
            }
            z = false;
        }
        if (view4 != null) {
            if (!z) {
                int[] iArr = (int[]) isVar.f1596O000000o.get("android:visibility:screenLocation");
                int i3 = iArr[0];
                int i4 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view4.offsetLeftAndRight((i3 - iArr2[0]) - view4.getLeft());
                view4.offsetTopAndBottom((i4 - iArr2[1]) - view4.getTop());
                iy.O000000o(viewGroup).O000000o(view4);
            }
            Animator onDisappear = onDisappear(viewGroup, view4, isVar, isVar2);
            if (!z) {
                if (onDisappear == null) {
                    iy.O000000o(viewGroup).O00000Oo(view4);
                } else {
                    view2.setTag(R.id.save_overlay_view, view4);
                    addListener(new io() {
                        /* class androidx.transition.Visibility.AnonymousClass1 */

                        public final void onTransitionPause(Transition transition) {
                            iy.O000000o(viewGroup).O00000Oo(view4);
                        }

                        public final void onTransitionResume(Transition transition) {
                            if (view4.getParent() == null) {
                                iy.O000000o(viewGroup).O000000o(view4);
                            } else {
                                Visibility.this.cancel();
                            }
                        }

                        public final void onTransitionEnd(Transition transition) {
                            view2.setTag(R.id.save_overlay_view, null);
                            iy.O000000o(viewGroup).O00000Oo(view4);
                            transition.removeListener(this);
                        }
                    });
                }
            }
            return onDisappear;
        } else if (view == null) {
            return null;
        } else {
            int visibility = view.getVisibility();
            jd.O000000o(view, 0);
            Animator onDisappear2 = onDisappear(viewGroup, view, isVar, isVar2);
            if (onDisappear2 != null) {
                O000000o o000000o = new O000000o(view, i2);
                onDisappear2.addListener(o000000o);
                hw.O000000o(onDisappear2, o000000o);
                addListener(o000000o);
            } else {
                jd.O000000o(view, visibility);
            }
            return onDisappear2;
        }
    }

    public boolean isTransitionRequired(is isVar, is isVar2) {
        if (isVar == null && isVar2 == null) {
            return false;
        }
        if (isVar != null && isVar2 != null && isVar2.f1596O000000o.containsKey("android:visibility:visibility") != isVar.f1596O000000o.containsKey("android:visibility:visibility")) {
            return false;
        }
        O00000Oo visibilityChangeInfo = getVisibilityChangeInfo(isVar, isVar2);
        if (!visibilityChangeInfo.f3024O000000o || (visibilityChangeInfo.O00000o0 != 0 && visibilityChangeInfo.O00000o != 0)) {
            return false;
        }
        return true;
    }

    static class O000000o extends AnimatorListenerAdapter implements hw.O000000o, Transition.O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f3023O000000o = false;
        private final View O00000Oo;
        private final ViewGroup O00000o;
        private final int O00000o0;
        private final boolean O00000oO;
        private boolean O00000oo;

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }

        O000000o(View view, int i) {
            this.O00000Oo = view;
            this.O00000o0 = i;
            this.O00000o = (ViewGroup) view.getParent();
            this.O00000oO = true;
            O000000o(true);
        }

        public final void onAnimationPause(Animator animator) {
            if (!this.f3023O000000o) {
                jd.O000000o(this.O00000Oo, this.O00000o0);
            }
        }

        public final void onAnimationResume(Animator animator) {
            if (!this.f3023O000000o) {
                jd.O000000o(this.O00000Oo, 0);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.f3023O000000o = true;
        }

        public final void onAnimationEnd(Animator animator) {
            O000000o();
        }

        public final void onTransitionEnd(Transition transition) {
            O000000o();
            transition.removeListener(this);
        }

        public final void onTransitionPause(Transition transition) {
            O000000o(false);
        }

        public final void onTransitionResume(Transition transition) {
            O000000o(true);
        }

        private void O000000o() {
            if (!this.f3023O000000o) {
                jd.O000000o(this.O00000Oo, this.O00000o0);
                ViewGroup viewGroup = this.O00000o;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            O000000o(false);
        }

        private void O000000o(boolean z) {
            ViewGroup viewGroup;
            if (this.O00000oO && this.O00000oo != z && (viewGroup = this.O00000o) != null) {
                this.O00000oo = z;
                iy.O000000o(viewGroup, z);
            }
        }
    }
}
