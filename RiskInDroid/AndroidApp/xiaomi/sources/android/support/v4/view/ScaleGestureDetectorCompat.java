package android.support.v4.view;

import android.os.Build;

public final class ScaleGestureDetectorCompat {
    static final ScaleGestureDetectorImpl IMPL;

    interface ScaleGestureDetectorImpl {
        boolean isQuickScaleEnabled(Object obj);

        void setQuickScaleEnabled(Object obj, boolean z);
    }

    static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorImpl {
        public boolean isQuickScaleEnabled(Object obj) {
            return false;
        }

        public void setQuickScaleEnabled(Object obj, boolean z) {
        }

        BaseScaleGestureDetectorImpl() {
        }
    }

    static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorImpl {
        ScaleGestureDetectorCompatKitKatImpl() {
        }

        public void setQuickScaleEnabled(Object obj, boolean z) {
            ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(obj, z);
        }

        public boolean isQuickScaleEnabled(Object obj) {
            return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(obj);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new ScaleGestureDetectorCompatKitKatImpl();
        } else {
            IMPL = new BaseScaleGestureDetectorImpl();
        }
    }

    private ScaleGestureDetectorCompat() {
    }

    public static void setQuickScaleEnabled(Object obj, boolean z) {
        IMPL.setQuickScaleEnabled(obj, z);
    }

    public static boolean isQuickScaleEnabled(Object obj) {
        return IMPL.isQuickScaleEnabled(obj);
    }
}
