package android.support.v4.view.accessibility;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

@TargetApi(19)
@RequiresApi(19)
class AccessibilityNodeProviderCompatKitKat {

    interface AccessibilityNodeInfoBridge {
        Object createAccessibilityNodeInfo(int i);

        List<Object> findAccessibilityNodeInfosByText(String str, int i);

        Object findFocus(int i);

        boolean performAction(int i, int i2, Bundle bundle);
    }

    AccessibilityNodeProviderCompatKitKat() {
    }

    public static Object newAccessibilityNodeProviderBridge(final AccessibilityNodeInfoBridge accessibilityNodeInfoBridge) {
        return new AccessibilityNodeProvider() {
            /* class android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AnonymousClass1 */

            public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
                return (AccessibilityNodeInfo) accessibilityNodeInfoBridge.createAccessibilityNodeInfo(i);
            }

            public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
                return accessibilityNodeInfoBridge.findAccessibilityNodeInfosByText(str, i);
            }

            public final boolean performAction(int i, int i2, Bundle bundle) {
                return accessibilityNodeInfoBridge.performAction(i, i2, bundle);
            }

            public final AccessibilityNodeInfo findFocus(int i) {
                return (AccessibilityNodeInfo) accessibilityNodeInfoBridge.findFocus(i);
            }
        };
    }
}
