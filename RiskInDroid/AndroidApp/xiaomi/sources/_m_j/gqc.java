package _m_j;

import android.os.Build;
import android.view.View;

public final class gqc {
    public static void O000000o(boolean z, View view) {
        if (z) {
            O000000o(view);
        } else {
            O00000Oo(view);
        }
    }

    private static void O000000o(View view) {
        view.setSystemUiVisibility(Build.VERSION.SDK_INT < 23 ? 1280 : 9472);
    }

    private static void O00000Oo(View view) {
        view.setSystemUiVisibility(Build.VERSION.SDK_INT < 23 ? 5380 : 13572);
    }
}
