package android.support.v4.view;

import android.os.Build;
import android.view.MotionEvent;

public final class MotionEventCompat {
    static final MotionEventVersionImpl IMPL;

    interface MotionEventVersionImpl {
        float getAxisValue(MotionEvent motionEvent, int i);

        float getAxisValue(MotionEvent motionEvent, int i, int i2);

        int getButtonState(MotionEvent motionEvent);
    }

    static class BaseMotionEventVersionImpl implements MotionEventVersionImpl {
        public float getAxisValue(MotionEvent motionEvent, int i) {
            return 0.0f;
        }

        public float getAxisValue(MotionEvent motionEvent, int i, int i2) {
            return 0.0f;
        }

        public int getButtonState(MotionEvent motionEvent) {
            return 0;
        }

        BaseMotionEventVersionImpl() {
        }
    }

    static class HoneycombMr1MotionEventVersionImpl extends BaseMotionEventVersionImpl {
        HoneycombMr1MotionEventVersionImpl() {
        }

        public float getAxisValue(MotionEvent motionEvent, int i) {
            return MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, i);
        }

        public float getAxisValue(MotionEvent motionEvent, int i, int i2) {
            return MotionEventCompatHoneycombMr1.getAxisValue(motionEvent, i, i2);
        }
    }

    static class ICSMotionEventVersionImpl extends HoneycombMr1MotionEventVersionImpl {
        ICSMotionEventVersionImpl() {
        }

        public int getButtonState(MotionEvent motionEvent) {
            return MotionEventCompatICS.getButtonState(motionEvent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new ICSMotionEventVersionImpl();
        } else if (Build.VERSION.SDK_INT >= 12) {
            IMPL = new HoneycombMr1MotionEventVersionImpl();
        } else {
            IMPL = new BaseMotionEventVersionImpl();
        }
    }

    public static int getActionMasked(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int getActionIndex(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    @Deprecated
    public static int findPointerIndex(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    @Deprecated
    public static int getPointerId(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    @Deprecated
    public static float getX(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    @Deprecated
    public static float getY(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    @Deprecated
    public static int getPointerCount(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    @Deprecated
    public static int getSource(MotionEvent motionEvent) {
        return motionEvent.getSource();
    }

    public static boolean isFromSource(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static float getAxisValue(MotionEvent motionEvent, int i) {
        return IMPL.getAxisValue(motionEvent, i);
    }

    public static float getAxisValue(MotionEvent motionEvent, int i, int i2) {
        return IMPL.getAxisValue(motionEvent, i, i2);
    }

    public static int getButtonState(MotionEvent motionEvent) {
        return IMPL.getButtonState(motionEvent);
    }

    private MotionEventCompat() {
    }
}
