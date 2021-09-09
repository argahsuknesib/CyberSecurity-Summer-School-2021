package _m_j;

import android.os.Build;
import android.view.Window;

public final class ezz {
    public static void O000000o(Window window) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Class<?> cls = window.getClass();
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_TRANSPARENT").getInt(cls2);
                cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE).invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                window.addFlags(67108864);
            } catch (Exception unused) {
            }
        }
    }
}
