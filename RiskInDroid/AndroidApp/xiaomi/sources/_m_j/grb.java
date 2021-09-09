package _m_j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

public final class grb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f18175O000000o = {16843828};

    public static void O000000o(View view) {
        if (view instanceof grc) {
            view.setOnApplyWindowInsetsListener(new O000000o());
            view.setSystemUiVisibility(1280);
        }
    }

    public static void O000000o(View view, Object obj, int i) {
        WindowInsets windowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        view.dispatchApplyWindowInsets(windowInsets);
    }

    public static void O000000o(ViewGroup.MarginLayoutParams marginLayoutParams, Object obj, int i) {
        WindowInsets windowInsets = (WindowInsets) obj;
        if (i == 3) {
            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
        } else if (i == 5) {
            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        marginLayoutParams.leftMargin = windowInsets.getSystemWindowInsetLeft();
        marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
        marginLayoutParams.rightMargin = windowInsets.getSystemWindowInsetRight();
        marginLayoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
    }

    public static int O000000o(Object obj) {
        if (obj != null) {
            return ((WindowInsets) obj).getSystemWindowInsetTop();
        }
        return 0;
    }

    public static Drawable O000000o(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f18175O000000o);
        try {
            return obtainStyledAttributes.getDrawable(0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static class O000000o implements View.OnApplyWindowInsetsListener {
        O000000o() {
        }

        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((grc) view).O000000o(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }
}
