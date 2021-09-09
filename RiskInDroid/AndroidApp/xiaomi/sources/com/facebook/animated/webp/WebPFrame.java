package com.facebook.animated.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;

public class WebPFrame implements AnimatedImageFrame {
    @DoNotStrip
    private long mNativeContext;

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeIsBlendWithPreviousFrame();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    private native boolean nativeShouldDisposeToBackgroundColor();

    @DoNotStrip
    WebPFrame(long j) {
        this.mNativeContext = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    public void dispose() {
        nativeDispose();
    }

    public void renderFrame(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    public int getDurationMs() {
        return nativeGetDurationMs();
    }

    public int getWidth() {
        return nativeGetWidth();
    }

    public int getHeight() {
        return nativeGetHeight();
    }

    public int getXOffset() {
        return nativeGetXOffset();
    }

    public int getYOffset() {
        return nativeGetYOffset();
    }

    public boolean shouldDisposeToBackgroundColor() {
        return nativeShouldDisposeToBackgroundColor();
    }

    public boolean isBlendWithPreviousFrame() {
        return nativeIsBlendWithPreviousFrame();
    }
}
