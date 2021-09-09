package _m_j;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;

public final class ejk {
    public static boolean O000000o(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }
}
