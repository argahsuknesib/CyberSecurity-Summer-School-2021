package _m_j;

import _m_j.bh;
import _m_j.cl;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class cb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final AtomicInteger f13580O000000o = new AtomicInteger(1);
    private static Field O00000Oo;
    private static Field O00000o;
    private static boolean O00000o0;
    private static boolean O00000oO;
    private static WeakHashMap<View, String> O00000oo;
    private static WeakHashMap<View, ce> O0000O0o = null;
    private static Method O0000OOo;
    private static boolean O0000Oo = false;
    private static Field O0000Oo0;
    private static ThreadLocal<Rect> O0000OoO;
    private static final int[] O0000Ooo = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    private static O000000o O0000o00 = new O000000o();

    public interface O0000OOo {
        boolean O000000o();
    }

    private static Rect O00000Oo() {
        if (O0000OoO == null) {
            O0000OoO = new ThreadLocal<>();
        }
        Rect rect = O0000OoO.get();
        if (rect == null) {
            rect = new Rect();
            O0000OoO.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static void O000000o(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            O0000O0o.O000000o(view, context, iArr, attributeSet, typedArray, i, 0);
        }
    }

    @Deprecated
    public static boolean O000000o(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean O00000Oo(View view, int i) {
        return view.canScrollVertically(i);
    }

    @Deprecated
    public static int O000000o(View view) {
        return view.getOverScrollMode();
    }

    @Deprecated
    public static void O00000o0(View view, int i) {
        view.setOverScrollMode(i);
    }

    public static void O000000o(View view, bh bhVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (bhVar == null && (O000Oo0(view) instanceof bh.O000000o)) {
            bhVar = new bh();
        }
        if (bhVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = bhVar.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    @SuppressLint({"InlinedApi"})
    public static int O00000Oo(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static void O00000o(View view, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setImportantForAutofill(i);
        }
    }

    public static boolean O00000o0(View view) {
        return O000Oo0(view) != null;
    }

    public static bh O00000o(View view) {
        View.AccessibilityDelegate O000Oo0 = O000Oo0(view);
        if (O000Oo0 == null) {
            return null;
        }
        if (O000Oo0 instanceof bh.O000000o) {
            return ((bh.O000000o) O000Oo0).f12965O000000o;
        }
        return new bh(O000Oo0);
    }

    private static bh O000Oo00(View view) {
        bh O00000o2 = O00000o(view);
        if (O00000o2 == null) {
            O00000o2 = new bh();
        }
        O000000o(view, O00000o2);
        return O00000o2;
    }

    private static View.AccessibilityDelegate O000Oo0(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        return O000Oo0O(view);
    }

    private static View.AccessibilityDelegate O000Oo0O(View view) {
        if (O0000Oo) {
            return null;
        }
        if (O0000Oo0 == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                O0000Oo0 = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                O0000Oo = true;
                return null;
            }
        }
        try {
            Object obj = O0000Oo0.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            O0000Oo = true;
            return null;
        }
    }

    public static boolean O00000oO(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasTransientState();
        }
        return false;
    }

    public static void O000000o(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setHasTransientState(z);
        }
    }

    public static void O00000oo(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidate();
        }
    }

    public static void O000000o(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        } else {
            view.postInvalidate(i, i2, i3, i4);
        }
    }

    public static void O000000o(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay());
        }
    }

    public static void O000000o(View view, Runnable runnable, long j) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimationDelayed(runnable, j);
        } else {
            view.postDelayed(runnable, ValueAnimator.getFrameDelay() + j);
        }
    }

    public static int O0000O0o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getImportantForAccessibility();
        }
        return 0;
    }

    public static void O00000oO(View view, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (i == 4) {
                i = 2;
            }
        }
        view.setImportantForAccessibility(i);
    }

    public static boolean O000000o(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.performAccessibilityAction(i, bundle);
        }
        return false;
    }

    public static void O000000o(View view, cl.O000000o o000000o, co coVar) {
        if (coVar == null) {
            O00000oo(view, o000000o.O000000o());
            return;
        }
        O000000o(view, new cl.O000000o(null, o000000o.O000OOOo, null, coVar, o000000o.O000OOo0));
    }

    private static void O000000o(View view, cl.O000000o o000000o) {
        if (Build.VERSION.SDK_INT >= 21) {
            O000Oo00(view);
            O000000o(o000000o.O000000o(), view);
            O000Oo0o(view).add(o000000o);
            O0000OoO(view, 0);
        }
    }

    public static void O00000oo(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            O000000o(i, view);
            O0000OoO(view, 0);
        }
    }

    private static void O000000o(int i, View view) {
        List<cl.O000000o> O000Oo0o = O000Oo0o(view);
        for (int i2 = 0; i2 < O000Oo0o.size(); i2++) {
            if (O000Oo0o.get(i2).O000000o() == i) {
                O000Oo0o.remove(i2);
                return;
            }
        }
    }

    private static List<cl.O000000o> O000Oo0o(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    @Deprecated
    public static float O0000OOo(View view) {
        return view.getAlpha();
    }

    @Deprecated
    public static void O0000O0o(View view, int i) {
        view.setLayerType(i, null);
    }

    public static void O000000o(View view, Paint paint) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setLayerPaint(paint);
            return;
        }
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public static int O0000Oo0(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static ViewParent O0000Oo(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getParentForAccessibility();
        }
        return view.getParent();
    }

    @Deprecated
    public static int O000000o(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    @Deprecated
    public static int O000000o(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    private static int O000OoO0(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.getAccessibilityLiveRegion();
        }
        return 0;
    }

    public static void O0000OOo(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    public static int O0000OoO(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingStart();
        }
        return view.getPaddingLeft();
    }

    public static int O0000Ooo(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getPaddingEnd();
        }
        return view.getPaddingRight();
    }

    public static void O00000Oo(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    @Deprecated
    public static float O0000o00(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float O0000o0(View view) {
        return view.getTranslationY();
    }

    public static int O0000o0O(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumWidth();
        }
        if (!O00000o0) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                O00000Oo = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            O00000o0 = true;
        }
        Field field = O00000Oo;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static int O0000o0o(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getMinimumHeight();
        }
        if (!O00000oO) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                O00000o = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            O00000oO = true;
        }
        Field field = O00000o;
        if (field == null) {
            return 0;
        }
        try {
            return ((Integer) field.get(view)).intValue();
        } catch (Exception unused2) {
            return 0;
        }
    }

    public static ce O0000o(View view) {
        if (O0000O0o == null) {
            O0000O0o = new WeakHashMap<>();
        }
        ce ceVar = O0000O0o.get(view);
        if (ceVar != null) {
            return ceVar;
        }
        ce ceVar2 = new ce(view);
        O0000O0o.put(view, ceVar2);
        return ceVar2;
    }

    @Deprecated
    public static void O000000o(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void O00000Oo(View view, float f) {
        view.setTranslationY(f);
    }

    @Deprecated
    public static void O00000o0(View view, float f) {
        view.setAlpha(f);
    }

    @Deprecated
    public static void O00000o(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void O0000oO0(View view) {
        view.setRotationX(0.0f);
    }

    @Deprecated
    public static void O00000oO(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void O00000oo(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void O0000O0o(View view, float f) {
        view.setScaleY(f);
    }

    @Deprecated
    public static void O0000OOo(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static void O0000Oo0(View view, float f) {
        view.setPivotY(f);
    }

    @Deprecated
    public static float O0000oO(View view) {
        return view.getScaleX();
    }

    public static void O0000Oo(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setElevation(f);
        }
    }

    public static float O0000oOO(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static void O0000OoO(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(f);
        }
    }

    public static float O0000oOo(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTranslationZ();
        }
        return 0.0f;
    }

    public static void O000000o(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (O00000oo == null) {
            O00000oo = new WeakHashMap<>();
        }
        O00000oo.put(view, str);
    }

    public static String O0000oo0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = O00000oo;
        if (weakHashMap == null) {
            return null;
        }
        return weakHashMap.get(view);
    }

    public static int O0000oo(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getWindowSystemUiVisibility();
        }
        return 0;
    }

    public static void O0000ooO(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else if (Build.VERSION.SDK_INT >= 16) {
            view.requestFitSystemWindows();
        }
    }

    @Deprecated
    public static void O000000o(ViewGroup viewGroup) {
        if (O0000OOo == null) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                O0000OOo = cls.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            O0000OOo.setAccessible(true);
        }
        try {
            O0000OOo.invoke(viewGroup, Boolean.TRUE);
        } catch (IllegalAccessException e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (IllegalArgumentException e3) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e3);
        } catch (InvocationTargetException e4) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e4);
        }
    }

    public static boolean O0000ooo(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.getFitsSystemWindows();
        }
        return false;
    }

    @Deprecated
    public static void O00000Oo(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    public static void O000000o(View view, final bw bwVar) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (bwVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                /* class _m_j.cb.AnonymousClass1 */

                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return bw.this.onApplyWindowInsets(view, ci.O000000o(windowInsets)).O00000oO();
                }
            });
        }
    }

    public static ci O000000o(View view, ci ciVar) {
        WindowInsets O00000oO2;
        if (Build.VERSION.SDK_INT >= 21 && (O00000oO2 = ciVar.O00000oO()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(O00000oO2);
            if (!onApplyWindowInsets.equals(O00000oO2)) {
                return ci.O000000o(onApplyWindowInsets);
            }
        }
        return ciVar;
    }

    public static ci O00000Oo(View view, ci ciVar) {
        WindowInsets O00000oO2;
        return (Build.VERSION.SDK_INT < 21 || (O00000oO2 = ciVar.O00000oO()) == null || view.dispatchApplyWindowInsets(O00000oO2).equals(O00000oO2)) ? ciVar : ci.O000000o(O00000oO2);
    }

    public static ci O00oOooO(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ci.O000000o(O00000o.O000000o(view));
        }
        return null;
    }

    public static ci O000000o(View view, ci ciVar, Rect rect) {
        return Build.VERSION.SDK_INT >= 21 ? O00000o0.O000000o(view, ciVar, rect) : ciVar;
    }

    public static boolean O00oOooo(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            return view.hasOverlappingRendering();
        }
        return true;
    }

    public static boolean O000O00o(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.isPaddingRelative();
        }
        return false;
    }

    public static void O000000o(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static ColorStateList O000O0OO(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (view instanceof ca) {
            return ((ca) view).getSupportBackgroundTintList();
        }
        return null;
    }

    public static void O000000o(View view, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof ca) {
            ((ca) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode O000O0Oo(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintMode();
        }
        if (view instanceof ca) {
            return ((ca) view).getSupportBackgroundTintMode();
        }
        return null;
    }

    public static void O000000o(View view, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        } else if (view instanceof ca) {
            ((ca) view).setSupportBackgroundTintMode(mode);
        }
    }

    public static void O00000o0(View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setNestedScrollingEnabled(z);
        } else if (view instanceof bo) {
            ((bo) view).setNestedScrollingEnabled(z);
        }
    }

    public static boolean O00oOoOo(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isNestedScrollingEnabled();
        }
        if (view instanceof bo) {
            return ((bo) view).isNestedScrollingEnabled();
        }
        return false;
    }

    public static void O000O0o0(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.stopNestedScroll();
        } else if (view instanceof bo) {
            ((bo) view).stopNestedScroll();
        }
    }

    public static boolean O000O0o(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.isInLayout();
        }
        return false;
    }

    public static boolean O000O0oO(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isLaidOut();
        }
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static float O000O0oo(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static void O0000Ooo(View view, float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setZ(f);
        }
    }

    public static void O0000Oo0(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect O00000Oo2 = O00000Oo();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                O00000Oo2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !O00000Oo2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            O0000Ooo(view, i);
            if (z && O00000Oo2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(O00000Oo2);
            }
        } else {
            O0000Ooo(view, i);
        }
    }

    private static void O0000Ooo(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            O00O0Oo(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                O00O0Oo((View) parent);
            }
        }
    }

    public static void O0000Oo(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
        } else if (Build.VERSION.SDK_INT >= 21) {
            Rect O00000Oo2 = O00000Oo();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                O00000Oo2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !O00000Oo2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            O0000o00(view, i);
            if (z && O00000Oo2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(O00000Oo2);
            }
        } else {
            O0000o00(view, i);
        }
    }

    private static void O0000o00(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            O00O0Oo(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                O00O0Oo((View) parent);
            }
        }
    }

    private static void O00O0Oo(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void O000000o(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static Rect O000OO00(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return view.getClipBounds();
        }
        return null;
    }

    public static boolean O000OO0o(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }

    public static boolean O000OO(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }

    public static void O000000o(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.setScrollIndicators(i, 3);
        }
    }

    public static void O000000o(View view, by byVar) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 24) {
            if (byVar != null) {
                obj = byVar.f13399O000000o;
            } else {
                obj = null;
            }
            view.setPointerIcon((PointerIcon) obj);
        }
    }

    public static Display O000OOOo(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getDisplay();
        }
        if (O000OO0o(view)) {
            return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        }
        return null;
    }

    public static int O000000o() {
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i = f13580O000000o.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f13580O000000o.compareAndSet(i, i2));
        return i;
    }

    static boolean O000000o(View view, KeyEvent keyEvent) {
        int indexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        O0000Oo0 O000000o2 = O0000Oo0.O000000o(view);
        if (O000000o2.O00000o0 == null || O000000o2.O00000o0.get() != keyEvent) {
            O000000o2.O00000o0 = new WeakReference<>(keyEvent);
            WeakReference weakReference = null;
            SparseArray<WeakReference<View>> O000000o3 = O000000o2.O000000o();
            if (keyEvent.getAction() == 1 && (indexOfKey = O000000o3.indexOfKey(keyEvent.getKeyCode())) >= 0) {
                weakReference = O000000o3.valueAt(indexOfKey);
                O000000o3.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = O000000o3.get(keyEvent.getKeyCode());
            }
            if (weakReference != null) {
                View view2 = (View) weakReference.get();
                if (view2 != null && O000OO0o(view2)) {
                    O0000Oo0.O00000Oo(view2);
                }
                return true;
            }
        }
        return false;
    }

    static boolean O00000Oo(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        O0000Oo0 O000000o2 = O0000Oo0.O000000o(view);
        if (keyEvent.getAction() == 0) {
            if (O000000o2.O00000Oo != null) {
                O000000o2.O00000Oo.clear();
            }
            if (!O0000Oo0.f13584O000000o.isEmpty()) {
                synchronized (O0000Oo0.f13584O000000o) {
                    if (O000000o2.O00000Oo == null) {
                        O000000o2.O00000Oo = new WeakHashMap<>();
                    }
                    for (int size = O0000Oo0.f13584O000000o.size() - 1; size >= 0; size--) {
                        View view2 = (View) O0000Oo0.f13584O000000o.get(size).get();
                        if (view2 == null) {
                            O0000Oo0.f13584O000000o.remove(size);
                        } else {
                            O000000o2.O00000Oo.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                O000000o2.O00000Oo.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View O000000o3 = O000000o2.O000000o(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (O000000o3 != null && !KeyEvent.isModifierKey(keyCode)) {
                O000000o2.O000000o().put(keyCode, new WeakReference(O000000o3));
            }
        }
        if (O000000o3 != null) {
            return true;
        }
        return false;
    }

    public static boolean O000OOoO(View view) {
        Boolean O00000Oo2 = O00000o0().O00000Oo(view);
        if (O00000Oo2 == null) {
            return false;
        }
        return O00000Oo2.booleanValue();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000Oo.O000000o(java.lang.Boolean, java.lang.Boolean):boolean
     arg types: [java.lang.Boolean, java.lang.Boolean]
     candidates:
      _m_j.cb.O00000Oo.O000000o(java.lang.Boolean, java.lang.Boolean):boolean
      _m_j.cb.O00000Oo.O000000o(android.view.View, java.lang.Boolean):void
      _m_j.cb.O00000Oo.O000000o(java.lang.Boolean, java.lang.Boolean):boolean */
    public static void O000OOoo(View view) {
        O00000Oo<Boolean> O00000o02 = O00000o0();
        Boolean bool = Boolean.TRUE;
        if (O00000o02.O000000o()) {
            O00000o02.O000000o(view, bool);
        } else if (O00000Oo.O00000Oo() && O00000o02.O000000o(O00000o02.O00000Oo(view), bool)) {
            O000Oo00(view);
            view.setTag(O00000o02.f13583O000000o, bool);
            O0000OoO(view, 0);
        }
    }

    private static O00000Oo<Boolean> O00000o0() {
        return new O00000Oo<Boolean>(Boolean.class) {
            /* class _m_j.cb.AnonymousClass4 */

            /* access modifiers changed from: package-private */
            public final /* synthetic */ void O000000o(View view, Object obj) {
                view.setAccessibilityHeading(((Boolean) obj).booleanValue());
            }

            /* access modifiers changed from: package-private */
            public final /* bridge */ /* synthetic */ boolean O000000o(Object obj, Object obj2) {
                return !O000000o((Boolean) obj, (Boolean) obj2);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object O000000o(View view) {
                return Boolean.valueOf(view.isAccessibilityHeading());
            }
        };
    }

    static abstract class O00000Oo<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f13583O000000o;
        private final Class<T> O00000Oo;
        private final int O00000o0;

        /* access modifiers changed from: package-private */
        public abstract T O000000o(View view);

        /* access modifiers changed from: package-private */
        public abstract void O000000o(View view, T t);

        O00000Oo(int i, Class<T> cls, int i2) {
            this(i, cls, 28, (byte) 0);
        }

        O00000Oo(int i, Class<T> cls, int i2, byte b) {
            this.f13583O000000o = i;
            this.O00000Oo = cls;
            this.O00000o0 = i2;
        }

        /* access modifiers changed from: package-private */
        public final T O00000Oo(View view) {
            if (O000000o()) {
                return O000000o(view);
            }
            if (!O00000Oo()) {
                return null;
            }
            T tag = view.getTag(this.f13583O000000o);
            if (this.O00000Oo.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return Build.VERSION.SDK_INT >= this.O00000o0;
        }

        static boolean O00000Oo() {
            return Build.VERSION.SDK_INT >= 19;
        }

        /* access modifiers changed from: package-private */
        public boolean O000000o(T t, T t2) {
            return !t2.equals(t);
        }

        static boolean O000000o(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }
    }

    static void O0000OoO(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = O000OOo(view) != null;
            if (O000OoO0(view) != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    static class O000000o implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: O000000o  reason: collision with root package name */
        private WeakHashMap<View, Boolean> f13582O000000o = new WeakHashMap<>();

        public final void onViewDetachedFromWindow(View view) {
        }

        O000000o() {
        }

        public final void onGlobalLayout() {
            for (Map.Entry next : this.f13582O000000o.entrySet()) {
                View view = (View) next.getKey();
                boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
                boolean z = view.getVisibility() == 0;
                if (booleanValue != z) {
                    if (z) {
                        cb.O0000OoO(view, 16);
                    }
                    this.f13582O000000o.put(view, Boolean.valueOf(z));
                }
            }
        }

        public final void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    static class O0000Oo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final ArrayList<WeakReference<View>> f13584O000000o = new ArrayList<>();
        WeakHashMap<View, Boolean> O00000Oo = null;
        private SparseArray<WeakReference<View>> O00000o = null;
        WeakReference<KeyEvent> O00000o0 = null;

        O0000Oo0() {
        }

        /* access modifiers changed from: package-private */
        public final SparseArray<WeakReference<View>> O000000o() {
            if (this.O00000o == null) {
                this.O00000o = new SparseArray<>();
            }
            return this.O00000o;
        }

        static O0000Oo0 O000000o(View view) {
            O0000Oo0 o0000Oo0 = (O0000Oo0) view.getTag(R.id.tag_unhandled_key_event_manager);
            if (o0000Oo0 != null) {
                return o0000Oo0;
            }
            O0000Oo0 o0000Oo02 = new O0000Oo0();
            view.setTag(R.id.tag_unhandled_key_event_manager, o0000Oo02);
            return o0000Oo02;
        }

        /* access modifiers changed from: package-private */
        public final View O000000o(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.O00000Oo;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View O000000o2 = O000000o(viewGroup.getChildAt(childCount), keyEvent);
                        if (O000000o2 != null) {
                            return O000000o2;
                        }
                    }
                }
                if (O00000Oo(view)) {
                    return view;
                }
            }
            return null;
        }

        static boolean O00000Oo(View view) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((O0000OOo) arrayList.get(size)).O000000o()) {
                    return true;
                }
            }
            return false;
        }
    }

    static class O00000o0 {
        static ci O000000o(View view, ci ciVar, Rect rect) {
            WindowInsets O00000oO = ciVar.O00000oO();
            if (O00000oO != null) {
                return ci.O000000o(view.computeSystemWindowInsets(O00000oO, rect));
            }
            rect.setEmpty();
            return ciVar;
        }
    }

    static class O00000o {
        public static WindowInsets O000000o(View view) {
            return view.getRootWindowInsets();
        }
    }

    static class O0000O0o {
        static void O000000o(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void O000000o(View view, cl clVar) {
        view.onInitializeAccessibilityNodeInfo(clVar.f13980O000000o);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    public static int O000000o(View view, CharSequence charSequence, co coVar) {
        List<cl.O000000o> O000Oo0o = O000Oo0o(view);
        int i = 0;
        int i2 = -1;
        while (true) {
            int[] iArr = O0000Ooo;
            if (i < iArr.length && i2 == -1) {
                int i3 = iArr[i];
                boolean z = true;
                for (int i4 = 0; i4 < O000Oo0o.size(); i4++) {
                    z &= O000Oo0o.get(i4).O000000o() != i3;
                }
                if (z) {
                    i2 = i3;
                }
                i++;
            } else if (i2 != -1) {
                O000000o(view, new cl.O000000o(i2, charSequence, coVar));
            }
        }
        if (i2 != -1) {
        }
        return i2;
    }

    public static boolean O000OOo0(View view) {
        Boolean bool = (Boolean) new O00000Oo<Boolean>(Boolean.class) {
            /* class _m_j.cb.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public final /* synthetic */ void O000000o(View view, Object obj) {
                view.setScreenReaderFocusable(((Boolean) obj).booleanValue());
            }

            /* access modifiers changed from: package-private */
            public final /* bridge */ /* synthetic */ boolean O000000o(Object obj, Object obj2) {
                return !O000000o((Boolean) obj, (Boolean) obj2);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object O000000o(View view) {
                return Boolean.valueOf(view.isScreenReaderFocusable());
            }
        }.O00000Oo(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static CharSequence O000OOo(View view) {
        return (CharSequence) new O00000Oo<CharSequence>(CharSequence.class) {
            /* class _m_j.cb.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            public final /* synthetic */ void O000000o(View view, Object obj) {
                view.setAccessibilityPaneTitle((CharSequence) obj);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ boolean O000000o(Object obj, Object obj2) {
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            }

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object O000000o(View view) {
                return view.getAccessibilityPaneTitle();
            }
        }.O00000Oo(view);
    }
}
