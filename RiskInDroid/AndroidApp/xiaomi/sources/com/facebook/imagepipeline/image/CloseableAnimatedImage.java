package com.facebook.imagepipeline.image;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;

public class CloseableAnimatedImage extends CloseableImage {
    private AnimatedImageResult mImageResult;

    public boolean isStateful() {
        return true;
    }

    public CloseableAnimatedImage(AnimatedImageResult animatedImageResult) {
        this.mImageResult = animatedImageResult;
    }

    public synchronized int getWidth() {
        if (isClosed()) {
            return 0;
        }
        return this.mImageResult.getImage().getWidth();
    }

    public synchronized int getHeight() {
        if (isClosed()) {
            return 0;
        }
        return this.mImageResult.getImage().getHeight();
    }

    public void close() {
        synchronized (this) {
            if (this.mImageResult != null) {
                AnimatedImageResult animatedImageResult = this.mImageResult;
                this.mImageResult = null;
                animatedImageResult.dispose();
            }
        }
    }

    public synchronized boolean isClosed() {
        return this.mImageResult == null;
    }

    public synchronized int getSizeInBytes() {
        if (isClosed()) {
            return 0;
        }
        return this.mImageResult.getImage().getSizeInBytes();
    }

    public synchronized AnimatedImageResult getImageResult() {
        return this.mImageResult;
    }

    public synchronized AnimatedImage getImage() {
        if (isClosed()) {
            return null;
        }
        return this.mImageResult.getImage();
    }
}
