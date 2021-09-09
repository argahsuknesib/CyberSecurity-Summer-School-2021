package _m_j;

import _m_j.iz;
import android.animation.LayoutTransition;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class iy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1647O000000o = true;
    private static Method O00000Oo;
    private static boolean O00000o0;

    public static ix O000000o(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new iw(viewGroup) : (iv) ja.O00000o0(viewGroup);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    public static void O000000o(ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
            return;
        }
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 18) {
            if (iz.f1655O000000o == null) {
                iz.AnonymousClass1 r0 = new LayoutTransition() {
                    /* class _m_j.iz.AnonymousClass1 */

                    public final boolean isChangingLayout() {
                        return true;
                    }
                };
                iz.f1655O000000o = r0;
                r0.setAnimator(2, null);
                iz.f1655O000000o.setAnimator(0, null);
                iz.f1655O000000o.setAnimator(1, null);
                iz.f1655O000000o.setAnimator(3, null);
                iz.f1655O000000o.setAnimator(4, null);
            }
            if (z) {
                LayoutTransition layoutTransition2 = viewGroup.getLayoutTransition();
                if (layoutTransition2 != null) {
                    if (layoutTransition2.isRunning()) {
                        if (!iz.O00000oO) {
                            try {
                                Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                                iz.O00000o = declaredMethod;
                                declaredMethod.setAccessible(true);
                            } catch (NoSuchMethodException unused) {
                                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
                            }
                            iz.O00000oO = true;
                        }
                        if (iz.O00000o != null) {
                            try {
                                iz.O00000o.invoke(layoutTransition2, new Object[0]);
                            } catch (IllegalAccessException unused2) {
                                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
                            } catch (InvocationTargetException unused3) {
                                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
                            }
                        }
                    }
                    if (layoutTransition2 != iz.f1655O000000o) {
                        viewGroup.setTag(R.id.transition_layout_save, layoutTransition2);
                    }
                }
                viewGroup.setLayoutTransition(iz.f1655O000000o);
                return;
            }
            viewGroup.setLayoutTransition(null);
            if (!iz.O00000o0) {
                try {
                    Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                    iz.O00000Oo = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused4) {
                    Log.i("ViewGroupUtilsApi14", "Failed to access mLayoutSuppressed field by reflection");
                }
                iz.O00000o0 = true;
            }
            if (iz.O00000Oo != null) {
                try {
                    boolean z3 = iz.O00000Oo.getBoolean(viewGroup);
                    if (z3) {
                        try {
                            iz.O00000Oo.setBoolean(viewGroup, false);
                        } catch (IllegalAccessException unused5) {
                            z2 = z3;
                        }
                    }
                    z2 = z3;
                } catch (IllegalAccessException unused6) {
                    Log.i("ViewGroupUtilsApi14", "Failed to get mLayoutSuppressed field by reflection");
                    if (z2) {
                    }
                    layoutTransition = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
                    if (layoutTransition == null) {
                    }
                }
            }
            if (z2) {
                viewGroup.requestLayout();
            }
            layoutTransition = (LayoutTransition) viewGroup.getTag(R.id.transition_layout_save);
            if (layoutTransition == null) {
                viewGroup.setTag(R.id.transition_layout_save, null);
                viewGroup.setLayoutTransition(layoutTransition);
            }
        } else if (f1647O000000o) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused7) {
                f1647O000000o = false;
            }
        }
    }

    static int O000000o(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i);
        }
        if (!O00000o0) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                O00000Oo = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            O00000o0 = true;
        }
        Method method = O00000Oo;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i;
    }
}
