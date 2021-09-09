package com.otaliastudios.cameraview;

import java.util.Arrays;
import java.util.List;

public enum Gesture {
    PINCH(GestureAction.ZOOM, GestureAction.EXPOSURE_CORRECTION),
    TAP(GestureAction.FOCUS, GestureAction.FOCUS_WITH_MARKER, GestureAction.CAPTURE),
    LONG_TAP(GestureAction.FOCUS, GestureAction.FOCUS_WITH_MARKER, GestureAction.CAPTURE),
    SCROLL_HORIZONTAL(GestureAction.ZOOM, GestureAction.EXPOSURE_CORRECTION),
    SCROLL_VERTICAL(GestureAction.ZOOM, GestureAction.EXPOSURE_CORRECTION);
    
    private List<GestureAction> mControls;

    private Gesture(GestureAction... gestureActionArr) {
        this.mControls = Arrays.asList(gestureActionArr);
    }

    /* access modifiers changed from: package-private */
    public final boolean isAssignableTo(GestureAction gestureAction) {
        return gestureAction == GestureAction.NONE || this.mControls.contains(gestureAction);
    }
}
