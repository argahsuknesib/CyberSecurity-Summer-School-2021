package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;

public interface DraweeController {
    Animatable getAnimatable();

    String getContentDescription();

    DraweeHierarchy getHierarchy();

    boolean isSameImageRequest(DraweeController draweeController);

    void onAttach();

    void onDetach();

    boolean onTouchEvent(MotionEvent motionEvent);

    void onViewportVisibilityHint(boolean z);

    void setContentDescription(String str);

    void setHierarchy(DraweeHierarchy draweeHierarchy);
}
