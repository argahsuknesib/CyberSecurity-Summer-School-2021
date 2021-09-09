package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

public abstract class Util {
    public static final int dpToPx(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    public static final FrameLayout.LayoutParams createLayoutParams(int i, int i2) {
        return new FrameLayout.LayoutParams(i, i2);
    }

    public static final FrameLayout.LayoutParams createMatchParams() {
        return createLayoutParams(-1, -1);
    }

    public static final FrameLayout.LayoutParams createWrapParams() {
        return createLayoutParams(-2, -2);
    }

    public static final FrameLayout.LayoutParams createWrapMatchParams() {
        return createLayoutParams(-2, -1);
    }

    public static final FrameLayout.LayoutParams createMatchWrapParams() {
        return createLayoutParams(-1, -2);
    }
}
