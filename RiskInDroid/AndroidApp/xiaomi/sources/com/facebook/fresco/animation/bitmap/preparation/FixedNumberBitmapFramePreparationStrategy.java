package com.facebook.fresco.animation.bitmap.preparation;

import com.facebook.common.logging.FLog;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;

public class FixedNumberBitmapFramePreparationStrategy implements BitmapFramePreparationStrategy {
    private static final Class<?> TAG = FixedNumberBitmapFramePreparationStrategy.class;
    private final int mFramesToPrepare;

    public FixedNumberBitmapFramePreparationStrategy() {
        this(3);
    }

    public FixedNumberBitmapFramePreparationStrategy(int i) {
        this.mFramesToPrepare = i;
    }

    public void prepareFrames(BitmapFramePreparer bitmapFramePreparer, BitmapFrameCache bitmapFrameCache, AnimationBackend animationBackend, int i) {
        int i2 = 1;
        while (i2 <= this.mFramesToPrepare) {
            int frameCount = (i + i2) % animationBackend.getFrameCount();
            if (FLog.isLoggable(2)) {
                FLog.v(TAG, "Preparing frame %d, last drawn: %d", Integer.valueOf(frameCount), Integer.valueOf(i));
            }
            if (bitmapFramePreparer.prepareFrame(bitmapFrameCache, animationBackend, frameCount)) {
                i2++;
            } else {
                return;
            }
        }
    }
}
