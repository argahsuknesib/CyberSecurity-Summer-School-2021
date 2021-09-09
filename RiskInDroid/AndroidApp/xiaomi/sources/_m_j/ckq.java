package _m_j;

import android.app.Activity;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;

public final class ckq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f13970O000000o;

    public static int O000000o(Activity activity) {
        if (activity != null && Build.VERSION.SDK_INT >= 28) {
            int i = f13970O000000o;
            if (i != 0) {
                return i;
            }
            try {
                WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                if (rootWindowInsets != null) {
                    DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
                    if (displayCutout != null) {
                        f13970O000000o = displayCutout.getSafeInsetTop();
                        cki.O00000oo("DisplayUtils", "WindowInsets top is:" + f13970O000000o);
                        return f13970O000000o;
                    }
                    cki.O00000oo("DisplayUtils", "DisplayCutout is null");
                } else {
                    cki.O00000oo("DisplayUtils", "windowInsets is null");
                }
            } catch (Exception e) {
                cki.O00000oO("DisplayUtils", "error:" + e.toString());
            }
        }
        return 0;
    }
}
