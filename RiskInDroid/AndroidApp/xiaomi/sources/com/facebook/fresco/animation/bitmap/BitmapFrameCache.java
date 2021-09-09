package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

public interface BitmapFrameCache {

    public interface FrameCacheListener {
        void onFrameCached(BitmapFrameCache bitmapFrameCache, int i);

        void onFrameEvicted(BitmapFrameCache bitmapFrameCache, int i);
    }

    void clear();

    boolean contains(int i);

    CloseableReference<Bitmap> getBitmapToReuseForFrame(int i, int i2, int i3);

    CloseableReference<Bitmap> getCachedFrame(int i);

    CloseableReference<Bitmap> getFallbackFrame(int i);

    int getSizeInBytes();

    void onFramePrepared(int i, CloseableReference<Bitmap> closeableReference, int i2);

    void onFrameRendered(int i, CloseableReference<Bitmap> closeableReference, int i2);

    void setFrameCacheListener(FrameCacheListener frameCacheListener);
}
