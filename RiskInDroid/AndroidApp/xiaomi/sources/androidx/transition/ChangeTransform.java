package androidx.transition;

import _m_j.cb;
import _m_j.hw;
import _m_j.hz;
import _m_j.ib;
import _m_j.id;
import _m_j.ie;
import _m_j.ig;
import _m_j.ij;
import _m_j.in;
import _m_j.io;
import _m_j.is;
import _m_j.jd;
import _m_j.n;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
    private static final String[] O00000Oo = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    private static final Property<O00000Oo, PointF> O00000o = new Property<O00000Oo, PointF>(PointF.class, "translations") {
        /* class androidx.transition.ChangeTransform.AnonymousClass2 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            O00000Oo o00000Oo = (O00000Oo) obj;
            PointF pointF = (PointF) obj2;
            o00000Oo.O00000o0 = pointF.x;
            o00000Oo.O00000o = pointF.y;
            o00000Oo.O000000o();
        }
    };
    private static final Property<O00000Oo, float[]> O00000o0 = new Property<O00000Oo, float[]>(float[].class, "nonTranslations") {
        /* class androidx.transition.ChangeTransform.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            return null;
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            O00000Oo o00000Oo = (O00000Oo) obj;
            float[] fArr = (float[]) obj2;
            System.arraycopy(fArr, 0, o00000Oo.O00000Oo, 0, fArr.length);
            o00000Oo.O000000o();
        }
    };
    private static final boolean O00000oO = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f3006O000000o = true;
    private boolean O00000oo = true;
    private Matrix O0000O0o = new Matrix();

    public ChangeTransform() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean
     arg types: [android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int]
     candidates:
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, float):float
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, int):int
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme, java.lang.String, int):_m_j.i
      _m_j.n.O000000o(android.content.res.TypedArray, org.xmlpull.v1.XmlPullParser, java.lang.String, int, boolean):boolean */
    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, in.O0000O0o);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f3006O000000o = n.O000000o(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.O00000oo = n.O000000o(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }

    public String[] getTransitionProperties() {
        return O00000Oo;
    }

    private void O000000o(is isVar) {
        View view = isVar.O00000Oo;
        if (view.getVisibility() != 8) {
            isVar.f1596O000000o.put("android:changeTransform:parent", view.getParent());
            isVar.f1596O000000o.put("android:changeTransform:transforms", new O00000o0(view));
            Matrix matrix = view.getMatrix();
            isVar.f1596O000000o.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
            if (this.O00000oo) {
                Matrix matrix2 = new Matrix();
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                jd.O000000o(viewGroup, matrix2);
                matrix2.preTranslate((float) (-viewGroup.getScrollX()), (float) (-viewGroup.getScrollY()));
                isVar.f1596O000000o.put("android:changeTransform:parentMatrix", matrix2);
                isVar.f1596O000000o.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
                isVar.f1596O000000o.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
            }
        }
    }

    public void captureStartValues(is isVar) {
        O000000o(isVar);
        if (!O00000oO) {
            ((ViewGroup) isVar.O00000Oo.getParent()).startViewTransition(isVar.O00000Oo);
        }
    }

    public void captureEndValues(is isVar) {
        O000000o(isVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r1 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0157  */
    public Animator createAnimator(ViewGroup viewGroup, is isVar, is isVar2) {
        boolean z;
        Matrix matrix;
        Matrix matrix2;
        Matrix matrix3;
        Matrix matrix4;
        Matrix matrix5;
        is isVar3 = isVar;
        is isVar4 = isVar2;
        ObjectAnimator objectAnimator = null;
        if (isVar3 != null && isVar4 != null && isVar3.f1596O000000o.containsKey("android:changeTransform:parent") && isVar4.f1596O000000o.containsKey("android:changeTransform:parent")) {
            ViewGroup viewGroup2 = (ViewGroup) isVar3.f1596O000000o.get("android:changeTransform:parent");
            ViewGroup viewGroup3 = (ViewGroup) isVar4.f1596O000000o.get("android:changeTransform:parent");
            if (this.O00000oo) {
                if (isValidTarget(viewGroup2)) {
                }
                boolean z2 = false;
                if (!z2) {
                    z = true;
                    matrix = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:intermediateMatrix");
                    if (matrix != null) {
                        isVar3.f1596O000000o.put("android:changeTransform:matrix", matrix);
                    }
                    matrix2 = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:intermediateParentMatrix");
                    if (matrix2 != null) {
                        isVar3.f1596O000000o.put("android:changeTransform:parentMatrix", matrix2);
                    }
                    if (z) {
                        Matrix matrix6 = (Matrix) isVar4.f1596O000000o.get("android:changeTransform:parentMatrix");
                        isVar4.O00000Oo.setTag(R.id.parent_matrix, matrix6);
                        Matrix matrix7 = this.O0000O0o;
                        matrix7.reset();
                        matrix6.invert(matrix7);
                        Matrix matrix8 = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:matrix");
                        if (matrix8 == null) {
                            matrix8 = new Matrix();
                            isVar3.f1596O000000o.put("android:changeTransform:matrix", matrix8);
                        }
                        matrix8.postConcat((Matrix) isVar3.f1596O000000o.get("android:changeTransform:parentMatrix"));
                        matrix8.postConcat(matrix7);
                    }
                    matrix3 = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:matrix");
                    matrix4 = (Matrix) isVar4.f1596O000000o.get("android:changeTransform:matrix");
                    if (matrix3 == null) {
                        matrix3 = ig.f1264O000000o;
                    }
                    if (matrix4 == null) {
                        matrix4 = ig.f1264O000000o;
                    }
                    matrix5 = matrix4;
                    if (!matrix3.equals(matrix5)) {
                        View view = isVar4.O00000Oo;
                        O000000o(view);
                        float[] fArr = new float[9];
                        matrix3.getValues(fArr);
                        float[] fArr2 = new float[9];
                        matrix5.getValues(fArr2);
                        O00000Oo o00000Oo = new O00000Oo(view, fArr);
                        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(o00000Oo, PropertyValuesHolder.ofObject(O00000o0, new hz(new float[9]), fArr, fArr2), ij.O000000o(O00000o, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
                        final boolean z3 = z;
                        final Matrix matrix9 = matrix5;
                        final View view2 = view;
                        final O00000o0 o00000o0 = (O00000o0) isVar4.f1596O000000o.get("android:changeTransform:transforms");
                        final O00000Oo o00000Oo2 = o00000Oo;
                        AnonymousClass3 r0 = new AnimatorListenerAdapter() {
                            /* class androidx.transition.ChangeTransform.AnonymousClass3 */
                            private boolean O0000O0o;
                            private Matrix O0000OOo = new Matrix();

                            public final void onAnimationCancel(Animator animator) {
                                this.O0000O0o = true;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                if (!this.O0000O0o) {
                                    if (!z3 || !ChangeTransform.this.f3006O000000o) {
                                        view2.setTag(R.id.transition_transform, null);
                                        view2.setTag(R.id.parent_matrix, null);
                                    } else {
                                        O000000o(matrix9);
                                    }
                                }
                                jd.O00000o0(view2, null);
                                o00000o0.O000000o(view2);
                            }

                            public final void onAnimationPause(Animator animator) {
                                O000000o(o00000Oo2.f3009O000000o);
                            }

                            public final void onAnimationResume(Animator animator) {
                                ChangeTransform.O000000o(view2);
                            }

                            private void O000000o(Matrix matrix) {
                                this.O0000OOo.set(matrix);
                                view2.setTag(R.id.transition_transform, this.O0000OOo);
                                o00000o0.O000000o(view2);
                            }
                        };
                        ofPropertyValuesHolder.addListener(r0);
                        hw.O000000o(ofPropertyValuesHolder, r0);
                        objectAnimator = ofPropertyValuesHolder;
                    }
                    if (!z && objectAnimator != null && this.f3006O000000o) {
                        O000000o(viewGroup, isVar, isVar2);
                    } else if (!O00000oO) {
                        viewGroup2.endViewTransition(isVar3.O00000Oo);
                    }
                }
            }
            z = false;
            matrix = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:intermediateMatrix");
            if (matrix != null) {
            }
            matrix2 = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:intermediateParentMatrix");
            if (matrix2 != null) {
            }
            if (z) {
            }
            matrix3 = (Matrix) isVar3.f1596O000000o.get("android:changeTransform:matrix");
            matrix4 = (Matrix) isVar4.f1596O000000o.get("android:changeTransform:matrix");
            if (matrix3 == null) {
            }
            if (matrix4 == null) {
            }
            matrix5 = matrix4;
            if (!matrix3.equals(matrix5)) {
            }
            if (!z) {
            }
            if (!O00000oO) {
            }
        }
        return objectAnimator;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jd.O000000o(android.view.View, float):void
     arg types: [android.view.View, int]
     candidates:
      _m_j.jd.O000000o(android.view.View, int):void
      _m_j.jd.O000000o(android.view.View, android.graphics.Matrix):void
      _m_j.jd.O000000o(android.view.View, float):void */
    private void O000000o(ViewGroup viewGroup, is isVar, is isVar2) {
        ib ibVar;
        View view = isVar2.O00000Oo;
        Matrix matrix = new Matrix((Matrix) isVar2.f1596O000000o.get("android:changeTransform:parentMatrix"));
        jd.O00000Oo(viewGroup, matrix);
        if (Build.VERSION.SDK_INT == 28) {
            ibVar = id.O000000o(view, viewGroup, matrix);
        } else {
            ibVar = ie.O000000o(view, viewGroup, matrix);
        }
        if (ibVar != null) {
            ibVar.O000000o((ViewGroup) isVar.f1596O000000o.get("android:changeTransform:parent"), isVar.O00000Oo);
            Transition transition = this;
            while (transition.mParent != null) {
                transition = transition.mParent;
            }
            transition.addListener(new O000000o(view, ibVar));
            if (O00000oO) {
                if (isVar.O00000Oo != isVar2.O00000Oo) {
                    jd.O000000o(isVar.O00000Oo, 0.0f);
                }
                jd.O000000o(view, 1.0f);
            }
        }
    }

    static void O000000o(View view) {
        O000000o(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    static void O000000o(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        cb.O0000OoO(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final float f3010O000000o;
        final float O00000Oo;
        final float O00000o;
        final float O00000o0;
        final float O00000oO;
        final float O00000oo;
        final float O0000O0o;
        final float O0000OOo;

        O00000o0(View view) {
            this.f3010O000000o = view.getTranslationX();
            this.O00000Oo = view.getTranslationY();
            this.O00000o0 = cb.O0000oOo(view);
            this.O00000o = view.getScaleX();
            this.O00000oO = view.getScaleY();
            this.O00000oo = view.getRotationX();
            this.O0000O0o = view.getRotationY();
            this.O0000OOo = view.getRotation();
        }

        public final void O000000o(View view) {
            ChangeTransform.O000000o(view, this.f3010O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof O00000o0)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            if (o00000o0.f3010O000000o == this.f3010O000000o && o00000o0.O00000Oo == this.O00000Oo && o00000o0.O00000o0 == this.O00000o0 && o00000o0.O00000o == this.O00000o && o00000o0.O00000oO == this.O00000oO && o00000o0.O00000oo == this.O00000oo && o00000o0.O0000O0o == this.O0000O0o && o00000o0.O0000OOo == this.O0000OOo) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            float f = this.f3010O000000o;
            int i = 0;
            int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.O00000Oo;
            int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.O00000o0;
            int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.O00000o;
            int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.O00000oO;
            int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.O00000oo;
            int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.O0000O0o;
            int floatToIntBits7 = (floatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.O0000OOo;
            if (f8 != 0.0f) {
                i = Float.floatToIntBits(f8);
            }
            return floatToIntBits7 + i;
        }
    }

    static class O000000o extends io {

        /* renamed from: O000000o  reason: collision with root package name */
        private View f3008O000000o;
        private ib O00000Oo;

        O000000o(View view, ib ibVar) {
            this.f3008O000000o = view;
            this.O00000Oo = ibVar;
        }

        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            View view = this.f3008O000000o;
            if (Build.VERSION.SDK_INT == 28) {
                if (!id.O00000o0) {
                    try {
                        id.O000000o();
                        Method declaredMethod = id.f1205O000000o.getDeclaredMethod("removeGhost", View.class);
                        id.O00000Oo = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
                    }
                    id.O00000o0 = true;
                }
                if (id.O00000Oo != null) {
                    try {
                        id.O00000Oo.invoke(null, view);
                    } catch (IllegalAccessException unused) {
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2.getCause());
                    }
                }
            } else {
                ie.O000000o(view);
            }
            this.f3008O000000o.setTag(R.id.transition_transform, null);
            this.f3008O000000o.setTag(R.id.parent_matrix, null);
        }

        public final void onTransitionPause(Transition transition) {
            this.O00000Oo.setVisibility(4);
        }

        public final void onTransitionResume(Transition transition) {
            this.O00000Oo.setVisibility(0);
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final Matrix f3009O000000o = new Matrix();
        final float[] O00000Oo;
        float O00000o;
        float O00000o0;
        private final View O00000oO;

        O00000Oo(View view, float[] fArr) {
            this.O00000oO = view;
            this.O00000Oo = (float[]) fArr.clone();
            float[] fArr2 = this.O00000Oo;
            this.O00000o0 = fArr2[2];
            this.O00000o = fArr2[5];
            O000000o();
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            float[] fArr = this.O00000Oo;
            fArr[2] = this.O00000o0;
            fArr[5] = this.O00000o;
            this.f3009O000000o.setValues(fArr);
            jd.O00000o0(this.O00000oO, this.f3009O000000o);
        }
    }
}
