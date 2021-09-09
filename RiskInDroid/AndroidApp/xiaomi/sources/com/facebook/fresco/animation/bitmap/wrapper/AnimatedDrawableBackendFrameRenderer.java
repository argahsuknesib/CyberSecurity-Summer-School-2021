package com.facebook.fresco.animation.bitmap.wrapper;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;

public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    private AnimatedDrawableBackend mAnimatedDrawableBackend;
    private AnimatedImageCompositor mAnimatedImageCompositor;
    public final BitmapFrameCache mBitmapFrameCache;
    private final AnimatedImageCompositor.Callback mCallback = new AnimatedImageCompositor.Callback() {
        /* class com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer.AnonymousClass1 */

        public void onIntermediateResult(int i, Bitmap bitmap) {
        }

        public CloseableReference<Bitmap> getCachedBitmap(int i) {
            return AnimatedDrawableBackendFrameRenderer.this.mBitmapFrameCache.getCachedFrame(i);
        }
    };

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache bitmapFrameCache, AnimatedDrawableBackend animatedDrawableBackend) {
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimatedDrawableBackend = animatedDrawableBackend;
        this.mAnimatedImageCompositor = new AnimatedImageCompositor(this.mAnimatedDrawableBackend, this.mCallback);
    }

    public void setBounds(Rect rect) {
        AnimatedDrawableBackend forNewBounds = this.mAnimatedDrawableBackend.forNewBounds(rect);
        if (forNewBounds != this.mAnimatedDrawableBackend) {
            this.mAnimatedDrawableBackend = forNewBounds;
            this.mAnimatedImageCompositor = new AnimatedImageCompositor(this.mAnimatedDrawableBackend, this.mCallback);
        }
    }

    public int getIntrinsicWidth() {
        return this.mAnimatedDrawableBackend.getWidth();
    }

    public int getIntrinsicHeight() {
        return this.mAnimatedDrawableBackend.getHeight();
    }

    public boolean renderFrame(int i, Bitmap bitmap) {
        this.mAnimatedImageCompositor.renderFrame(i, bitmap);
        return true;
    }
}
