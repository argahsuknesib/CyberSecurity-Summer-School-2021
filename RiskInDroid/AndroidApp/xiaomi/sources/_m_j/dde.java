package _m_j;

import android.os.Build;
import android.view.Window;

public final class dde {
    public static void O000000o(Window window) {
        if (window != null && Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(1280);
            window.setStatusBarColor(0);
        }
    }
}
