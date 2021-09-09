package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

public final class ViewConfigurationCompat {
    static final ViewConfigurationVersionImpl IMPL;

    interface ViewConfigurationVersionImpl {
        boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration);
    }

    static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl {
        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return true;
        }

        BaseViewConfigurationVersionImpl() {
        }
    }

    static class HoneycombViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl {
        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return false;
        }

        HoneycombViewConfigurationVersionImpl() {
        }
    }

    static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl {
        IcsViewConfigurationVersionImpl() {
        }

        public boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
            return ViewConfigurationCompatICS.hasPermanentMenuKey(viewConfiguration);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsViewConfigurationVersionImpl();
        } else if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombViewConfigurationVersionImpl();
        } else {
            IMPL = new BaseViewConfigurationVersionImpl();
        }
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return IMPL.hasPermanentMenuKey(viewConfiguration);
    }

    private ViewConfigurationCompat() {
    }
}
