package android.support.v4.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class AccessibilityEventCompat {
    private static final AccessibilityEventVersionImpl IMPL;

    interface AccessibilityEventVersionImpl {
        void appendRecord(AccessibilityEvent accessibilityEvent, Object obj);

        int getAction(AccessibilityEvent accessibilityEvent);

        int getContentChangeTypes(AccessibilityEvent accessibilityEvent);

        int getMovementGranularity(AccessibilityEvent accessibilityEvent);

        Object getRecord(AccessibilityEvent accessibilityEvent, int i);

        int getRecordCount(AccessibilityEvent accessibilityEvent);

        void setAction(AccessibilityEvent accessibilityEvent, int i);

        void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i);

        void setMovementGranularity(AccessibilityEvent accessibilityEvent, int i);
    }

    static class AccessibilityEventStubImpl implements AccessibilityEventVersionImpl {
        public void appendRecord(AccessibilityEvent accessibilityEvent, Object obj) {
        }

        public int getAction(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public int getMovementGranularity(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public Object getRecord(AccessibilityEvent accessibilityEvent, int i) {
            return null;
        }

        public int getRecordCount(AccessibilityEvent accessibilityEvent) {
            return 0;
        }

        public void setAction(AccessibilityEvent accessibilityEvent, int i) {
        }

        public void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        }

        public void setMovementGranularity(AccessibilityEvent accessibilityEvent, int i) {
        }

        AccessibilityEventStubImpl() {
        }
    }

    static class AccessibilityEventIcsImpl extends AccessibilityEventStubImpl {
        AccessibilityEventIcsImpl() {
        }

        public void appendRecord(AccessibilityEvent accessibilityEvent, Object obj) {
            AccessibilityEventCompatIcs.appendRecord(accessibilityEvent, obj);
        }

        public Object getRecord(AccessibilityEvent accessibilityEvent, int i) {
            return AccessibilityEventCompatIcs.getRecord(accessibilityEvent, i);
        }

        public int getRecordCount(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatIcs.getRecordCount(accessibilityEvent);
        }
    }

    static class AccessibilityEventJellyBeanImpl extends AccessibilityEventIcsImpl {
        AccessibilityEventJellyBeanImpl() {
        }

        public void setMovementGranularity(AccessibilityEvent accessibilityEvent, int i) {
            AccessibilityEventCompatJellyBean.setMovementGranularity(accessibilityEvent, i);
        }

        public int getMovementGranularity(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatJellyBean.getMovementGranularity(accessibilityEvent);
        }

        public void setAction(AccessibilityEvent accessibilityEvent, int i) {
            AccessibilityEventCompatJellyBean.setAction(accessibilityEvent, i);
        }

        public int getAction(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatJellyBean.getAction(accessibilityEvent);
        }
    }

    static class AccessibilityEventKitKatImpl extends AccessibilityEventJellyBeanImpl {
        AccessibilityEventKitKatImpl() {
        }

        public void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
            AccessibilityEventCompatKitKat.setContentChangeTypes(accessibilityEvent, i);
        }

        public int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
            return AccessibilityEventCompatKitKat.getContentChangeTypes(accessibilityEvent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityEventKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityEventJellyBeanImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityEventIcsImpl();
        } else {
            IMPL = new AccessibilityEventStubImpl();
        }
    }

    private AccessibilityEventCompat() {
    }

    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        return IMPL.getRecordCount(accessibilityEvent);
    }

    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        IMPL.appendRecord(accessibilityEvent, accessibilityRecordCompat.getImpl());
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int i) {
        return new AccessibilityRecordCompat(IMPL.getRecord(accessibilityEvent, i));
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        return new AccessibilityRecordCompat(accessibilityEvent);
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setContentChangeTypes(accessibilityEvent, i);
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return IMPL.getContentChangeTypes(accessibilityEvent);
    }

    public final void setMovementGranularity(AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setMovementGranularity(accessibilityEvent, i);
    }

    public final int getMovementGranularity(AccessibilityEvent accessibilityEvent) {
        return IMPL.getMovementGranularity(accessibilityEvent);
    }

    public final void setAction(AccessibilityEvent accessibilityEvent, int i) {
        IMPL.setAction(accessibilityEvent, i);
    }

    public final int getAction(AccessibilityEvent accessibilityEvent) {
        return IMPL.getAction(accessibilityEvent);
    }
}
