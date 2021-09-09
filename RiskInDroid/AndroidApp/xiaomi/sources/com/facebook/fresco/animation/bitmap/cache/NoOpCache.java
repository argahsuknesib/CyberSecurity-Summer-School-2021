package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;

public class NoOpCache implements BitmapFrameCache {
    public void clear() {
    }

    public boolean contains(int i) {
        return false;
    }

    public CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3) {
        return null;
    }

    public CloseableReference<Bitmap> getCachedFrame(int i) {
        return null;
    }

    public CloseableReference<Bitmap> getFallbackFrame(int i) {
        return null;
    }

    public int getSizeInBytes() {
        return 0;
    }

    public void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    public void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2) {
    }

    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
    }
}
