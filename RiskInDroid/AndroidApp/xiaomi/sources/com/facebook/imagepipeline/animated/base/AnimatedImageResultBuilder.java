package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

public class AnimatedImageResultBuilder {
    private List<CloseableReference<Bitmap>> mDecodedFrames;
    private int mFrameForPreview;
    private final AnimatedImage mImage;
    private CloseableReference<Bitmap> mPreviewBitmap;

    AnimatedImageResultBuilder(AnimatedImage animatedImage) {
        this.mImage = animatedImage;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    public CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public AnimatedImageResultBuilder setPreviewBitmap(CloseableReference<Bitmap> closeableReference) {
        this.mPreviewBitmap = CloseableReference.cloneOrNull(closeableReference);
        return this;
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int i) {
        this.mFrameForPreview = i;
        return this;
    }

    public List<CloseableReference<Bitmap>> getDecodedFrames() {
        return CloseableReference.cloneOrNull(this.mDecodedFrames);
    }

    public AnimatedImageResultBuilder setDecodedFrames(List<CloseableReference<Bitmap>> list) {
        this.mDecodedFrames = CloseableReference.cloneOrNull(list);
        return this;
    }

    public AnimatedImageResult build() {
        try {
            return new AnimatedImageResult(this);
        } finally {
            CloseableReference.closeSafely(this.mPreviewBitmap);
            this.mPreviewBitmap = null;
            CloseableReference.closeSafely(this.mDecodedFrames);
            this.mDecodedFrames = null;
        }
    }
}
