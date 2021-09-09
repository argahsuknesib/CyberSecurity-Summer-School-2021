package com.otaliastudios.cameraview;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class GestureAction extends Enum<GestureAction> {
    private static final /* synthetic */ GestureAction[] $VALUES;
    public static final GestureAction CAPTURE = new GestureAction("CAPTURE", 3, 3);
    static final GestureAction DEFAULT_LONG_TAP;
    static final GestureAction DEFAULT_PINCH;
    static final GestureAction DEFAULT_SCROLL_HORIZONTAL;
    static final GestureAction DEFAULT_SCROLL_VERTICAL;
    static final GestureAction DEFAULT_TAP;
    public static final GestureAction EXPOSURE_CORRECTION = new GestureAction("EXPOSURE_CORRECTION", 5, 5);
    public static final GestureAction FOCUS = new GestureAction("FOCUS", 1, 1);
    public static final GestureAction FOCUS_WITH_MARKER = new GestureAction("FOCUS_WITH_MARKER", 2, 2);
    public static final GestureAction NONE = new GestureAction("NONE", 0, 0);
    public static final GestureAction ZOOM = new GestureAction("ZOOM", 4, 4);
    private int value;

    public static GestureAction valueOf(String str) {
        return (GestureAction) Enum.valueOf(GestureAction.class, str);
    }

    public static GestureAction[] values() {
        return (GestureAction[]) $VALUES.clone();
    }

    static {
        GestureAction gestureAction = NONE;
        $VALUES = new GestureAction[]{gestureAction, FOCUS, FOCUS_WITH_MARKER, CAPTURE, ZOOM, EXPOSURE_CORRECTION};
        DEFAULT_PINCH = gestureAction;
        DEFAULT_TAP = gestureAction;
        DEFAULT_LONG_TAP = gestureAction;
        DEFAULT_SCROLL_HORIZONTAL = gestureAction;
        DEFAULT_SCROLL_VERTICAL = gestureAction;
    }

    private GestureAction(String str, int i, int i2) {
        this.value = i2;
    }

    /* access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    static GestureAction fromValue(int i) {
        for (GestureAction gestureAction : values()) {
            if (gestureAction.value() == i) {
                return gestureAction;
            }
        }
        return null;
    }
}
