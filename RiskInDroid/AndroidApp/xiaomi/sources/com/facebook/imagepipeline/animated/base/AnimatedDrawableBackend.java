package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;

public interface AnimatedDrawableBackend {
    void dropCaches();

    AnimatedDrawableBackend forNewBounds(Rect rect);

    AnimatedImageResult getAnimatedImageResult();

    int getDurationMs();

    int getDurationMsForFrame(int i);

    int getFrameCount();

    int getFrameForPreview();

    int getFrameForTimestampMs(int i);

    AnimatedDrawableFrameInfo getFrameInfo(int i);

    int getHeight();

    int getLoopCount();

    int getMemoryUsage();

    CloseableReference<Bitmap> getPreDecodedFrame(int i);

    int getRenderedHeight();

    int getRenderedWidth();

    int getTimestampMsForFrame(int i);

    int getWidth();

    boolean hasPreDecodedFrame(int i);

    void renderFrame(int i, Canvas canvas);
}
