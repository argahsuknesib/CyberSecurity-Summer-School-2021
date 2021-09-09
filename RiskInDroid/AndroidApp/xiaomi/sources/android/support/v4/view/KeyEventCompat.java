package android.support.v4.view;

import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.View;

public final class KeyEventCompat {
    static final KeyEventVersionImpl IMPL;

    interface KeyEventVersionImpl {
        boolean isCtrlPressed(KeyEvent keyEvent);

        boolean metaStateHasModifiers(int i, int i2);

        boolean metaStateHasNoModifiers(int i);

        int normalizeMetaState(int i);
    }

    static class BaseKeyEventVersionImpl implements KeyEventVersionImpl {
        public boolean isCtrlPressed(KeyEvent keyEvent) {
            return false;
        }

        public int normalizeMetaState(int i) {
            if ((i & 192) != 0) {
                i |= 1;
            }
            if ((i & 48) != 0) {
                i |= 2;
            }
            return i & 247;
        }

        BaseKeyEventVersionImpl() {
        }

        private static int metaStateFilterDirectionalModifiers(int i, int i2, int i3, int i4, int i5) {
            int i6;
            boolean z = true;
            boolean z2 = (i2 & i3) != 0;
            int i7 = i4 | i5;
            if ((i2 & i7) == 0) {
                z = false;
            }
            if (z2) {
                if (!z) {
                    i6 = i7 ^ -1;
                } else {
                    throw new IllegalArgumentException("bad arguments");
                }
            } else if (!z) {
                return i;
            } else {
                i6 = i3 ^ -1;
            }
            return i & i6;
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            if (metaStateFilterDirectionalModifiers(metaStateFilterDirectionalModifiers(normalizeMetaState(i) & 247, i2, 1, 64, NotificationCompat.FLAG_HIGH_PRIORITY), i2, 2, 16, 32) == i2) {
                return true;
            }
            return false;
        }

        public boolean metaStateHasNoModifiers(int i) {
            return (normalizeMetaState(i) & 247) == 0;
        }
    }

    static class HoneycombKeyEventVersionImpl extends BaseKeyEventVersionImpl {
        HoneycombKeyEventVersionImpl() {
        }

        public int normalizeMetaState(int i) {
            return KeyEventCompatHoneycomb.normalizeMetaState(i);
        }

        public boolean metaStateHasModifiers(int i, int i2) {
            return KeyEventCompatHoneycomb.metaStateHasModifiers(i, i2);
        }

        public boolean metaStateHasNoModifiers(int i) {
            return KeyEventCompatHoneycomb.metaStateHasNoModifiers(i);
        }

        public boolean isCtrlPressed(KeyEvent keyEvent) {
            return KeyEventCompatHoneycomb.isCtrlPressed(keyEvent);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            IMPL = new HoneycombKeyEventVersionImpl();
        } else {
            IMPL = new BaseKeyEventVersionImpl();
        }
    }

    public static int normalizeMetaState(int i) {
        return IMPL.normalizeMetaState(i);
    }

    public static boolean metaStateHasModifiers(int i, int i2) {
        return IMPL.metaStateHasModifiers(i, i2);
    }

    public static boolean metaStateHasNoModifiers(int i) {
        return IMPL.metaStateHasNoModifiers(i);
    }

    public static boolean hasModifiers(KeyEvent keyEvent, int i) {
        return IMPL.metaStateHasModifiers(keyEvent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyEvent) {
        return IMPL.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    @Deprecated
    public static void startTracking(KeyEvent keyEvent) {
        keyEvent.startTracking();
    }

    @Deprecated
    public static boolean isTracking(KeyEvent keyEvent) {
        return keyEvent.isTracking();
    }

    @Deprecated
    public static Object getKeyDispatcherState(View view) {
        return view.getKeyDispatcherState();
    }

    @Deprecated
    public static boolean dispatch(KeyEvent keyEvent, KeyEvent.Callback callback, Object obj, Object obj2) {
        return keyEvent.dispatch(callback, (KeyEvent.DispatcherState) obj, obj2);
    }

    public static boolean isCtrlPressed(KeyEvent keyEvent) {
        return IMPL.isCtrlPressed(keyEvent);
    }

    private KeyEventCompat() {
    }
}
