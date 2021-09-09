package _m_j;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class ck {
    public static void O000000o(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }
}
