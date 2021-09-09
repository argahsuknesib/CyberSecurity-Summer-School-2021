package androidx.transition;

import _m_j.cb;
import _m_j.ih;
import _m_j.ij;
import _m_j.ik;
import _m_j.in;
import _m_j.io;
import _m_j.ir;
import _m_j.is;
import _m_j.iy;
import _m_j.jd;
import _m_j.n;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f2994O000000o = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> O00000Oo = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        /* class androidx.transition.ChangeBounds.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        private Rect f2995O000000o = new Rect();

        public final /* synthetic */ Object get(Object obj) {
            ((Drawable) obj).copyBounds(this.f2995O000000o);
            return new PointF((float) this.f2995O000000o.left, (float) this.f2995O000000o.top);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            Drawable drawable = (Drawable) obj;
            PointF pointF = (PointF) obj2;
            drawable.copyBounds(this.f2995O000000o);
            this.f2995O000000o.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2995O000000o);
        }
    };
    private static final Property<O000000o, PointF> O00000o = new Property<O000000o, PointF>(PointF.class, "bottomRight") {
        /* class androidx.transition.ChangeBounds.AnonymousClass4 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            O000000o o000000o = (O000000o) obj;
            PointF pointF = (PointF) obj2;
            o000000o.O00000o0 = Math.round(pointF.x);
            o000000o.O00000o = Math.round(pointF.y);
            o000000o.O00000oo++;
            if (o000000o.O00000oO == o000000o.O00000oo) {
                o000000o.O000000o();
            }
        }
    };
    private static final Property<O000000o, PointF> O00000o0 = new Property<O000000o, PointF>(PointF.class, "topLeft") {
        /* class androidx.transition.ChangeBounds.AnonymousClass3 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            O000000o o000000o = (O000000o) obj;
            PointF pointF = (PointF) obj2;
            o000000o.f3000O000000o = Math.round(pointF.x);
            o000000o.O00000Oo = Math.round(pointF.y);
            o000000o.O00000oO++;
            if (o000000o.O00000oO == o000000o.O00000oo) {
                o000000o.O000000o();
            }
        }
    };
    private static final Property<View, PointF> O00000oO = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* class androidx.transition.ChangeBounds.AnonymousClass5 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            jd.O000000o(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> O00000oo = new Property<View, PointF>(PointF.class, "topLeft") {
        /* class androidx.transition.ChangeBounds.AnonymousClass6 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            jd.O000000o(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> O0000O0o = new Property<View, PointF>(PointF.class, "position") {
        /* class androidx.transition.ChangeBounds.AnonymousClass7 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            View view = (View) obj;
            PointF pointF = (PointF) obj2;
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            jd.O000000o(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static ik O0000OoO = new ik();
    private int[] O0000OOo = new int[2];
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;

    public ChangeBounds() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
     arg types: [android.content.res.TypedArray, android.content.res.XmlResourceParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean */
    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O00000o);
        boolean O000000o2 = n.O000000o(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        this.O0000Oo0 = O000000o2;
    }

    public String[] getTransitionProperties() {
        return f2994O000000o;
    }

    private void O000000o(is isVar) {
        View view = isVar.O00000Oo;
        if (cb.O000O0oO(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            isVar.f1596O000000o.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            isVar.f1596O000000o.put("android:changeBounds:parent", isVar.O00000Oo.getParent());
            if (this.O0000Oo) {
                isVar.O00000Oo.getLocationInWindow(this.O0000OOo);
                isVar.f1596O000000o.put("android:changeBounds:windowX", Integer.valueOf(this.O0000OOo[0]));
                isVar.f1596O000000o.put("android:changeBounds:windowY", Integer.valueOf(this.O0000OOo[1]));
            }
            if (this.O0000Oo0) {
                isVar.f1596O000000o.put("android:changeBounds:clip", cb.O000OO00(view));
            }
        }
    }

    public void captureStartValues(is isVar) {
        O000000o(isVar);
    }

    public void captureEndValues(is isVar) {
        O000000o(isVar);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iy.O000000o(android.view.ViewGroup, boolean):void
     arg types: [android.view.ViewGroup, int]
     candidates:
      _m_j.iy.O000000o(android.view.ViewGroup, int):int
      _m_j.iy.O000000o(android.view.ViewGroup, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jd.O000000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.jd.O000000o(android.view.View, int):void
      _m_j.jd.O000000o(android.view.View, android.graphics.Matrix):void
      _m_j.jd.O000000o(android.view.View, float):void */
    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        boolean z;
        int i;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator2;
        is matchedTransitionValues;
        is isVar3 = isVar;
        is isVar4 = isVar2;
        if (isVar3 == null || isVar4 == null) {
            return null;
        }
        Map<String, Object> map = isVar3.f1596O000000o;
        Map<String, Object> map2 = isVar4.f1596O000000o;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = isVar4.O00000Oo;
        if (!this.O0000Oo || ((matchedTransitionValues = getMatchedTransitionValues(viewGroup2, true)) != null ? viewGroup3 == matchedTransitionValues.O00000Oo : viewGroup2 == viewGroup3)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Rect rect2 = (Rect) isVar3.f1596O000000o.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) isVar4.f1596O000000o.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            View view3 = view2;
            Rect rect4 = (Rect) isVar3.f1596O000000o.get("android:changeBounds:clip");
            Rect rect5 = (Rect) isVar4.f1596O000000o.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.O0000Oo0) {
                view = view3;
                jd.O000000o(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animator = ih.O000000o(view, O0000O0o, getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6));
                    } else {
                        final O000000o o000000o = new O000000o(view);
                        ObjectAnimator O000000o2 = ih.O000000o(o000000o, O00000o0, getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6));
                        ObjectAnimator O000000o3 = ih.O000000o(o000000o, O00000o, getPathMotion().getPath((float) i7, (float) i9, (float) i8, (float) i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(O000000o2, O000000o3);
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            /* class androidx.transition.ChangeBounds.AnonymousClass8 */
                            private O000000o mViewBounds = o000000o;
                        });
                        animator = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    animator = ih.O000000o(view, O00000oO, getPathMotion().getPath((float) i7, (float) i9, (float) i8, (float) i10));
                } else {
                    animator = ih.O000000o(view, O00000oo, getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6));
                }
            } else {
                view = view3;
                jd.O000000o(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                if (i3 == i4 && i5 == i6) {
                    objectAnimator = null;
                } else {
                    objectAnimator = ih.O000000o(view, O0000O0o, getPathMotion().getPath((float) i3, (float) i5, (float) i4, (float) i6));
                }
                if (rect7 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i2, i2, i13, i14) : rect6;
                if (!rect.equals(rect8)) {
                    cb.O000000o(view, rect);
                    ik ikVar = O0000OoO;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect8;
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", ikVar, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i15 = i4;
                    final int i16 = i6;
                    final int i17 = i8;
                    final int i18 = i10;
                    objectAnimator2.addListener(new AnimatorListenerAdapter() {
                        /* class androidx.transition.ChangeBounds.AnonymousClass9 */
                        private boolean O0000OOo;

                        public final void onAnimationCancel(Animator animator) {
                            this.O0000OOo = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (!this.O0000OOo) {
                                cb.O000000o(view4, rect9);
                                jd.O000000o(view4, i15, i16, i17, i18);
                            }
                        }
                    });
                } else {
                    objectAnimator2 = null;
                }
                animator = ir.O000000o(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                iy.O000000o(viewGroup4, true);
                addListener(new io() {
                    /* class androidx.transition.ChangeBounds.AnonymousClass10 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    boolean f2996O000000o = false;

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.iy.O000000o(android.view.ViewGroup, boolean):void
                     arg types: [android.view.ViewGroup, int]
                     candidates:
                      _m_j.iy.O000000o(android.view.ViewGroup, int):int
                      _m_j.iy.O000000o(android.view.ViewGroup, boolean):void */
                    public final void onTransitionCancel(Transition transition) {
                        iy.O000000o(viewGroup4, false);
                        this.f2996O000000o = true;
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.iy.O000000o(android.view.ViewGroup, boolean):void
                     arg types: [android.view.ViewGroup, int]
                     candidates:
                      _m_j.iy.O000000o(android.view.ViewGroup, int):int
                      _m_j.iy.O000000o(android.view.ViewGroup, boolean):void */
                    public final void onTransitionEnd(Transition transition) {
                        if (!this.f2996O000000o) {
                            iy.O000000o(viewGroup4, false);
                        }
                        transition.removeListener(this);
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.iy.O000000o(android.view.ViewGroup, boolean):void
                     arg types: [android.view.ViewGroup, int]
                     candidates:
                      _m_j.iy.O000000o(android.view.ViewGroup, int):int
                      _m_j.iy.O000000o(android.view.ViewGroup, boolean):void */
                    public final void onTransitionPause(Transition transition) {
                        iy.O000000o(viewGroup4, false);
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.iy.O000000o(android.view.ViewGroup, boolean):void
                     arg types: [android.view.ViewGroup, int]
                     candidates:
                      _m_j.iy.O000000o(android.view.ViewGroup, int):int
                      _m_j.iy.O000000o(android.view.ViewGroup, boolean):void */
                    public final void onTransitionResume(Transition transition) {
                        iy.O000000o(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) isVar3.f1596O000000o.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) isVar3.f1596O000000o.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) isVar4.f1596O000000o.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) isVar4.f1596O000000o.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.O0000OOo);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float O00000o02 = jd.O00000o0(view2);
        jd.O000000o(view2, 0.0f);
        jd.O000000o(viewGroup).O000000o(bitmapDrawable);
        PathMotion pathMotion = getPathMotion();
        int[] iArr = this.O0000OOo;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, ij.O000000o(O00000Oo, pathMotion.getPath((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1]))));
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f = O00000o02;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            /* class androidx.transition.ChangeBounds.AnonymousClass2 */

            public final void onAnimationEnd(Animator animator) {
                jd.O000000o(viewGroup5).O00000Oo(bitmapDrawable2);
                jd.O000000o(view5, f);
            }
        });
        return ofPropertyValuesHolder;
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f3000O000000o;
        int O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        private View O0000O0o;

        O000000o(View view) {
            this.O0000O0o = view;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            jd.O000000o(this.O0000O0o, this.f3000O000000o, this.O00000Oo, this.O00000o0, this.O00000o);
            this.O00000oO = 0;
            this.O00000oo = 0;
        }
    }
}
