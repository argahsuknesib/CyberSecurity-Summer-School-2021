package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;

public abstract class DelegatingAnimatedDrawableBackend implements AnimatedDrawableBackend {
    private final AnimatedDrawableBackend mAnimatedDrawableBackend;

    public DelegatingAnimatedDrawableBackend(AnimatedDrawableBackend animatedDrawableBackend) {
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
    }

    /* access modifiers changed from: protected */
    public AnimatedDrawableBackend getDelegate() {
        return this.mAnimatedDrawableBackend;
    }

    public AnimatedImageResult getAnimatedImageResult() {
        return this.mAnimatedDrawableBackend.getAnimatedImageResult();
    }

    public int getDurationMs() {
        return this.mAnimatedDrawableBackend.getDurationMs();
    }

    public int getFrameCount() {
        return this.mAnimatedDrawableBackend.getFrameCount();
    }

    public int getLoopCount() {
        return this.mAnimatedDrawableBackend.getLoopCount();
    }

    public int getWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public int getHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    public int getRenderedWidth() {
        return this.mAnimatedDrawableBackend.getRenderedWidth();
    }

    public int getRenderedHeight() {
        return this.mAnimatedDrawableBackend.getRenderedHeight();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        return this.mAnimatedDrawableBackend.getFrameInfo(i);
    }

    public void renderFrame(int i, Canvas canvas) {
        this.mAnimatedDrawableBackend.renderFrame(i, canvas);
    }

    public int getFrameForTimestampMs(int i) {
        return this.mAnimatedDrawableBackend.getFrameForTimestampMs(i);
    }

    public int getTimestampMsForFrame(int i) {
        return this.mAnimatedDrawableBackend.getTimestampMsForFrame(i);
    }

    public int getDurationMsForFrame(int i) {
        return this.mAnimatedDrawableBackend.getDurationMsForFrame(i);
    }

    public int getFrameForPreview() {
        return this.mAnimatedDrawableBackend.getFrameForPreview();
    }

    public int getMemoryUsage() {
        return this.mAnimatedDrawableBackend.getMemoryUsage();
    }

    public CloseableReference<Bitmap> getPreDecodedFrame(int i) {
        return this.mAnimatedDrawableBackend.getPreDecodedFrame(i);
    }

    public boolean hasPreDecodedFrame(int i) {
        return this.mAnimatedDrawableBackend.hasPreDecodedFrame(i);
    }

    public void dropCaches() {
        this.mAnimatedDrawableBackend.dropCaches();
    }
}
