package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs;
import android.support.v4.view.accessibility.AccessibilityManagerCompatKitKat;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

public final class AccessibilityManagerCompat {
    private static final AccessibilityManagerVersionImpl IMPL;

    interface AccessibilityManagerVersionImpl {
        boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener);

        boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener);

        List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i);

        List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager);

        boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager);

        AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilityStateChangeListener);

        AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(TouchExplorationStateChangeListener touchExplorationStateChangeListener);

        boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener);

        boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener);
    }

    public interface AccessibilityStateChangeListener {
        void onAccessibilityStateChanged(boolean z);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean z);
    }

    static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl {
        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return false;
        }

        public boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return false;
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return false;
        }

        public AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return null;
        }

        public AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return null;
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return false;
        }

        public boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return false;
        }

        AccessibilityManagerStubImpl() {
        }

        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return Collections.emptyList();
        }

        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return Collections.emptyList();
        }
    }

    static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl {
        AccessibilityManagerIcsImpl() {
        }

        public AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper newAccessibilityStateChangeListener(final AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerWrapper(accessibilityStateChangeListener, new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge() {
                /* class android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerIcsImpl.AnonymousClass1 */

                public void onAccessibilityStateChanged(boolean z) {
                    accessibilityStateChangeListener.onAccessibilityStateChanged(z);
                }
            });
        }

        public boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, newAccessibilityStateChangeListener(accessibilityStateChangeListener));
        }

        public boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
            return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, newAccessibilityStateChangeListener(accessibilityStateChangeListener));
        }

        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
            return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, i);
        }

        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
        }

        public boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
            return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
        }
    }

    static class AccessibilityManagerKitKatImpl extends AccessibilityManagerIcsImpl {
        AccessibilityManagerKitKatImpl() {
        }

        public AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper newTouchExplorationStateChangeListener(final TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return new AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener, new AccessibilityManagerCompatKitKat.TouchExplorationStateChangeListenerBridge() {
                /* class android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerKitKatImpl.AnonymousClass1 */

                public void onTouchExplorationStateChanged(boolean z) {
                    touchExplorationStateChangeListener.onTouchExplorationStateChanged(z);
                }
            });
        }

        public boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return AccessibilityManagerCompatKitKat.addTouchExplorationStateChangeListener(accessibilityManager, newTouchExplorationStateChangeListener(touchExplorationStateChangeListener));
        }

        public boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
            return AccessibilityManagerCompatKitKat.removeTouchExplorationStateChangeListener(accessibilityManager, newTouchExplorationStateChangeListener(touchExplorationStateChangeListener));
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityManagerKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityManagerIcsImpl();
        } else {
            IMPL = new AccessibilityManagerStubImpl();
        }
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        return IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListener);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager accessibilityManager, AccessibilityStateChangeListener accessibilityStateChangeListener) {
        return IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListener);
    }

    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager accessibilityManager) {
        return IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }

    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager accessibilityManager, int i) {
        return IMPL.getEnabledAccessibilityServiceList(accessibilityManager, i);
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager) {
        return IMPL.isTouchExplorationEnabled(accessibilityManager);
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return IMPL.addTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return IMPL.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    private AccessibilityManagerCompat() {
    }
}
