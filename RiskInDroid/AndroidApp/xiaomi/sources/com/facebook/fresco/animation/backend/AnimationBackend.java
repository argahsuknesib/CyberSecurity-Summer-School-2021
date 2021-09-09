package com.facebook.fresco.animation.backend;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public interface AnimationBackend extends AnimationInformation {
    void clear();

    boolean drawFrame(Drawable drawable, Canvas canvas, int i);

    int getIntrinsicHeight();

    int getIntrinsicWidth();

    int getSizeInBytes();

    void setAlpha(int i);

    void setBounds(Rect rect);

    void setColorFilter(ColorFilter colorFilter);
}
