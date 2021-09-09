package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;

public interface BitmapFramePreparationStrategy {
    void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i);
}
