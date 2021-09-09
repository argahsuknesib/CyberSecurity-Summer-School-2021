package _m_j;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class dos {
    public static int O000000o(boolean z, int i, int i2, int i3, int i4) {
        if (!z) {
            return i3;
        }
        return ((i2 - i4) - (i3 - i)) + i;
    }

    public static boolean O000000o() {
        if (Build.VERSION.SDK_INT < 17 || 1 != TextUtils.getLayoutDirectionFromLocale(Locale.getDefault())) {
            return false;
        }
        return true;
    }
}
