package _m_j;

import android.content.SharedPreferences;
import android.os.Build;

public final class ess {
    public static void O000000o(SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT > 8) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}
