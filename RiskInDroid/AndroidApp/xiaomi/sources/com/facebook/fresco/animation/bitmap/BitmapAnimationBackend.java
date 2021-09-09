package com.facebook.fresco.animation.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.backend.AnimationInformation;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.InactivityListener {
    private static final Class<?> TAG = BitmapAnimationBackend.class;
    private final AnimationInformation mAnimationInformation;
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    private final BitmapFrameCache mBitmapFrameCache;
    private final BitmapFramePreparationStrategy mBitmapFramePreparationStrategy;
    private final BitmapFramePreparer mBitmapFramePreparer;
    private final BitmapFrameRenderer mBitmapFrameRenderer;
    private int mBitmapHeight;
    private int mBitmapWidth;
    private Rect mBounds;
    private FrameListener mFrameListener;
    private final Paint mPaint;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    public interface FrameListener {
        void onDrawFrameStart(BitmapAnimationBackend bitmapAnimationBackend, int i);

        void onFrameDrawn(BitmapAnimationBackend bitmapAnimationBackend, int i, int i2);

        void onFrameDropped(BitmapAnimationBackend bitmapAnimationBackend, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBitmapFrameCache = bitmapFrameCache;
        this.mAnimationInformation = animationInformation;
        this.mBitmapFrameRenderer = bitmapFrameRenderer;
        this.mBitmapFramePreparationStrategy = bitmapFramePreparationStrategy;
        this.mBitmapFramePreparer = bitmapFramePreparer;
        this.mPaint = new Paint(6);
        updateBitmapDimensions();
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
    }

    public void setFrameListener(FrameListener frameListener) {
        this.mFrameListener = frameListener;
    }

    public int getFrameCount() {
        return this.mAnimationInformation.getFrameCount();
    }

    public int getFrameDurationMs(int i) {
        return this.mAnimationInformation.getFrameDurationMs(i);
    }

    public int getLoopCount() {
        return this.mAnimationInformation.getLoopCount();
    }

    public boolean drawFrame(Drawable drawable, Canvas canvas, int i) {
        BitmapFramePreparer bitmapFramePreparer;
        FrameListener frameListener;
        FrameListener frameListener2 = this.mFrameListener;
        if (frameListener2 != null) {
            frameListener2.onDrawFrameStart(this, i);
        }
        boolean drawFrameOrFallback = drawFrameOrFallback(canvas, i, 0);
        if (!drawFrameOrFallback && (frameListener = this.mFrameListener) != null) {
            frameListener.onFrameDropped(this, i);
        }
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.mBitmapFramePreparationStrategy;
        if (!(bitmapFramePreparationStrategy == null || (bitmapFramePreparer = this.mBitmapFramePreparer) == null)) {
            bitmapFramePreparationStrategy.prepareFrames(bitmapFramePreparer, this.mBitmapFrameCache, this, i);
        }
        return drawFrameOrFallback;
    }

    private boolean drawFrameOrFallback(Canvas canvas, int i, int i2) {
        boolean z;
        while (true) {
            int i3 = 3;
            CloseableReference<Bitmap> closeableReference = null;
            if (i2 == 0) {
                closeableReference = this.mBitmapFrameCache.getCachedFrame(i);
                z = drawBitmapAndCache(i, closeableReference, canvas, 0);
                i3 = 1;
            } else if (i2 == 1) {
                closeableReference = this.mBitmapFrameCache.getBitmapToReuseForFrame(i, this.mBitmapWidth, this.mBitmapHeight);
                z = renderFrameInBitmap(i, closeableReference) && drawBitmapAndCache(i, closeableReference, canvas, 1);
                i3 = 2;
            } else if (i2 == 2) {
                closeableReference = this.mPlatformBitmapFactory.createBitmap(this.mBitmapWidth, this.mBitmapHeight, this.mBitmapConfig);
                z = renderFrameInBitmap(i, closeableReference) && drawBitmapAndCache(i, closeableReference, canvas, 2);
            } else if (i2 != 3) {
                CloseableReference.closeSafely((CloseableReference<?>) null);
                return false;
            } else {
                try {
                    closeableReference = this.mBitmapFrameCache.getFallbackFrame(i);
                    z = drawBitmapAndCache(i, closeableReference, canvas, 3);
                    i3 = -1;
                } catch (RuntimeException e) {
                    FLog.w(TAG, "Failed to create frame bitmap", e);
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    return false;
                } catch (Throwable th) {
                    CloseableReference.closeSafely(closeableReference);
                    throw th;
                }
            }
            CloseableReference.closeSafely(closeableReference);
            if (z || i3 == -1) {
                return z;
            }
            i2 = i3;
        }
        return z;
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setBounds(Rect rect) {
        this.mBounds = rect;
        this.mBitmapFrameRenderer.setBounds(rect);
        updateBitmapDimensions();
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getSizeInBytes() {
        return this.mBitmapFrameCache.getSizeInBytes();
    }

    public void clear() {
        this.mBitmapFrameCache.clear();
    }

    public void onInactive() {
        clear();
    }

    private void updateBitmapDimensions() {
        this.mBitmapWidth = this.mBitmapFrameRenderer.getIntrinsicWidth();
        int i = -1;
        if (this.mBitmapWidth == -1) {
            Rect rect = this.mBounds;
            this.mBitmapWidth = rect == null ? -1 : rect.width();
        }
        this.mBitmapHeight = this.mBitmapFrameRenderer.getIntrinsicHeight();
        if (this.mBitmapHeight == -1) {
            Rect rect2 = this.mBounds;
            if (rect2 != null) {
                i = rect2.height();
            }
            this.mBitmapHeight = i;
        }
    }

    private boolean renderFrameInBitmap(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        boolean renderFrame = this.mBitmapFrameRenderer.renderFrame(i, closeableReference.get());
        if (!renderFrame) {
            CloseableReference.closeSafely(closeableReference);
        }
        return renderFrame;
    }

    private boolean drawBitmapAndCache(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.isValid(closeableReference)) {
            return false;
        }
        if (this.mBounds == null) {
            canvas.drawBitmap(closeableReference.get(), 0.0f, 0.0f, this.mPaint);
        } else {
            canvas.drawBitmap(closeableReference.get(), (Rect) null, this.mBounds, this.mPaint);
        }
        if (i2 != 3) {
            this.mBitmapFrameCache.onFrameRendered(i, closeableReference, i2);
        }
        FrameListener frameListener = this.mFrameListener;
        if (frameListener == null) {
            return true;
        }
        frameListener.onFrameDrawn(this, i, i2);
        return true;
    }
}
