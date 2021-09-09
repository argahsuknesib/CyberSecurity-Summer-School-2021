package com.google.android.cameraview;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;

abstract class DisplayOrientationDetector {
    static final SparseIntArray DISPLAY_ORIENTATIONS;
    Display mDisplay;
    public int mLastKnownDeviceOrientation = 0;
    private int mLastKnownDisplayOrientation = 0;
    private final OrientationEventListener mOrientationEventListener;

    public abstract void onDisplayOrientationChanged(int i, int i2);

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        DISPLAY_ORIENTATIONS = sparseIntArray;
        sparseIntArray.put(0, 0);
        DISPLAY_ORIENTATIONS.put(1, 90);
        DISPLAY_ORIENTATIONS.put(2, 180);
        DISPLAY_ORIENTATIONS.put(3, 270);
    }

    public DisplayOrientationDetector(Context context) {
        this.mOrientationEventListener = new OrientationEventListener(context) {
            /* class com.google.android.cameraview.DisplayOrientationDetector.AnonymousClass1 */
            private int mLastKnownRotation = -1;

            /* JADX WARNING: Removed duplicated region for block: B:22:0x0035  */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0046  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x004b  */
            /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
            public void onOrientationChanged(int i) {
                int i2;
                int rotation;
                if (i != -1 && DisplayOrientationDetector.this.mDisplay != null) {
                    boolean z = false;
                    if (i <= 315 && i >= 45) {
                        if (i > 45 && i < 135) {
                            i2 = 90;
                            if (DisplayOrientationDetector.this.mLastKnownDeviceOrientation != i2) {
                            }
                            rotation = DisplayOrientationDetector.this.mDisplay.getRotation();
                            if (this.mLastKnownRotation != rotation) {
                            }
                            if (!z) {
                            }
                        } else if (i > 135 && i < 225) {
                            i2 = 180;
                            if (DisplayOrientationDetector.this.mLastKnownDeviceOrientation != i2) {
                            }
                            rotation = DisplayOrientationDetector.this.mDisplay.getRotation();
                            if (this.mLastKnownRotation != rotation) {
                            }
                            if (!z) {
                            }
                        } else if (i > 225 && i < 315) {
                            i2 = 270;
                            if (DisplayOrientationDetector.this.mLastKnownDeviceOrientation != i2) {
                                DisplayOrientationDetector.this.mLastKnownDeviceOrientation = i2;
                                z = true;
                            }
                            rotation = DisplayOrientationDetector.this.mDisplay.getRotation();
                            if (this.mLastKnownRotation != rotation) {
                                this.mLastKnownRotation = rotation;
                                z = true;
                            }
                            if (!z) {
                                DisplayOrientationDetector.this.dispatchOnDisplayOrientationChanged(DisplayOrientationDetector.DISPLAY_ORIENTATIONS.get(rotation));
                                return;
                            }
                            return;
                        }
                    }
                    i2 = 0;
                    if (DisplayOrientationDetector.this.mLastKnownDeviceOrientation != i2) {
                    }
                    rotation = DisplayOrientationDetector.this.mDisplay.getRotation();
                    if (this.mLastKnownRotation != rotation) {
                    }
                    if (!z) {
                    }
                }
            }
        };
    }

    public void enable(Display display) {
        this.mDisplay = display;
        this.mOrientationEventListener.enable();
        dispatchOnDisplayOrientationChanged(DISPLAY_ORIENTATIONS.get(display.getRotation()));
    }

    public void disable() {
        this.mOrientationEventListener.disable();
        this.mDisplay = null;
    }

    public int getLastKnownDisplayOrientation() {
        return this.mLastKnownDisplayOrientation;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDisplayOrientationChanged(int i) {
        this.mLastKnownDisplayOrientation = i;
        onDisplayOrientationChanged(i, this.mLastKnownDeviceOrientation);
    }
}
