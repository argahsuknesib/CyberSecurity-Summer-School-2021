package _m_j;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class cd {
    @Deprecated
    public static boolean O000000o(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean O000000o(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof bt) {
            return ((bt) viewParent).onStartNestedScroll(view, view2, i, i2);
        }
        if (i2 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        } else if (viewParent instanceof bs) {
            return ((bs) viewParent).onStartNestedScroll(view, view2, i);
        } else {
            return false;
        }
    }

    public static void O000000o(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof bu) {
            ((bu) viewParent2).onNestedScroll(view, i, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent2 instanceof bt) {
            ((bt) viewParent2).onNestedScroll(view, i, i2, i3, i4, i5);
        } else if (i5 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                } catch (AbstractMethodError e) {
                    AbstractMethodError abstractMethodError = e;
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", abstractMethodError);
                }
            } else if (viewParent2 instanceof bs) {
                ((bs) viewParent2).onNestedScroll(view, i, i2, i3, i4);
            }
        }
    }

    public static void O000000o(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof bt) {
            ((bt) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
        } else if (i3 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
                }
            } else if (viewParent instanceof bs) {
                ((bs) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }
    }

    public static boolean O000000o(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        } else if (viewParent instanceof bs) {
            return ((bs) viewParent).onNestedFling(view, f, f2, z);
        } else {
            return false;
        }
    }

    public static boolean O000000o(ViewParent viewParent, View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        } else if (viewParent instanceof bs) {
            return ((bs) viewParent).onNestedPreFling(view, f, f2);
        } else {
            return false;
        }
    }
}
