package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;

public interface BitmapFramePreparer {
    boolean prepareFrame(BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i);
}
