package com.facebook.fresco.animation.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegateWithInactivityCheck;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.fresco.animation.bitmap.BitmapFrameRenderer;
import com.facebook.fresco.animation.bitmap.cache.FrescoFrameCache;
import com.facebook.fresco.animation.bitmap.cache.KeepLastFrameCache;
import com.facebook.fresco.animation.bitmap.cache.NoOpCache;
import com.facebook.fresco.animation.bitmap.preparation.BitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.DefaultBitmapFramePreparer;
import com.facebook.fresco.animation.bitmap.preparation.FixedNumberBitmapFramePreparationStrategy;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendAnimationInformation;
import com.facebook.fresco.animation.bitmap.wrapper.AnimatedDrawableBackendFrameRenderer;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedFrameCache;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class ExperimentalBitmapAnimationDrawableFactory implements DrawableFactory {
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final Supplier<Integer> mCachingStrategySupplier;
    private final ExecutorService mExecutorServiceForFramePreparing;
    private final MonotonicClock mMonotonicClock;
    private final Supplier<Integer> mNumberOfFramesToPrepareSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;
    private final ScheduledExecutorService mScheduledExecutorServiceForUiThread;

    public ExperimentalBitmapAnimationDrawableFactory(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, ScheduledExecutorService scheduledExecutorService, ExecutorService executorService, MonotonicClock monotonicClock, PlatformBitmapFactory platformBitmapFactory, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, Supplier<Integer> supplier, Supplier<Integer> supplier2) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mScheduledExecutorServiceForUiThread = scheduledExecutorService;
        this.mExecutorServiceForFramePreparing = executorService;
        this.mMonotonicClock = monotonicClock;
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mBackingCache = countingMemoryCache;
        this.mCachingStrategySupplier = supplier;
        this.mNumberOfFramesToPrepareSupplier = supplier2;
    }

    public boolean supportsImageType(CloseableImage closeableImage) {
        return closeableImage instanceof CloseableAnimatedImage;
    }

    public AnimatedDrawable2 createDrawable(CloseableImage closeableImage) {
        return new AnimatedDrawable2(createAnimationBackend(((CloseableAnimatedImage) closeableImage).getImageResult()));
    }

    private AnimationBackend createAnimationBackend(AnimatedImageResult animatedImageResult) {
        BitmapFramePreparer bitmapFramePreparer;
        FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy;
        AnimatedDrawableBackend createAnimatedDrawableBackend = createAnimatedDrawableBackend(animatedImageResult);
        BitmapFrameCache createBitmapFrameCache = createBitmapFrameCache(animatedImageResult);
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = new AnimatedDrawableBackendFrameRenderer(createBitmapFrameCache, createAnimatedDrawableBackend);
        int intValue = this.mNumberOfFramesToPrepareSupplier.get().intValue();
        if (intValue > 0) {
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy2 = new FixedNumberBitmapFramePreparationStrategy(intValue);
            bitmapFramePreparer = createBitmapFramePreparer(animatedDrawableBackendFrameRenderer);
            fixedNumberBitmapFramePreparationStrategy = fixedNumberBitmapFramePreparationStrategy2;
        } else {
            fixedNumberBitmapFramePreparationStrategy = null;
            bitmapFramePreparer = null;
        }
        return AnimationBackendDelegateWithInactivityCheck.createForBackend(new BitmapAnimationBackend(this.mPlatformBitmapFactory, createBitmapFrameCache, new AnimatedDrawableBackendAnimationInformation(createAnimatedDrawableBackend), animatedDrawableBackendFrameRenderer, fixedNumberBitmapFramePreparationStrategy, bitmapFramePreparer), this.mMonotonicClock, this.mScheduledExecutorServiceForUiThread);
    }

    private BitmapFramePreparer createBitmapFramePreparer(BitmapFrameRenderer bitmapFrameRenderer) {
        return new DefaultBitmapFramePreparer(this.mPlatformBitmapFactory, bitmapFrameRenderer, Bitmap.Config.ARGB_8888, this.mExecutorServiceForFramePreparing);
    }

    private AnimatedDrawableBackend createAnimatedDrawableBackend(AnimatedImageResult animatedImageResult) {
        AnimatedImage image = animatedImageResult.getImage();
        return this.mAnimatedDrawableBackendProvider.get(animatedImageResult, new Rect(0, 0, image.getWidth(), image.getHeight()));
    }

    private BitmapFrameCache createBitmapFrameCache(AnimatedImageResult animatedImageResult) {
        int intValue = this.mCachingStrategySupplier.get().intValue();
        if (intValue == 1) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), true);
        }
        if (intValue == 2) {
            return new FrescoFrameCache(createAnimatedFrameCache(animatedImageResult), false);
        }
        if (intValue != 3) {
            return new NoOpCache();
        }
        return new KeepLastFrameCache();
    }

    private AnimatedFrameCache createAnimatedFrameCache(AnimatedImageResult animatedImageResult) {
        return new AnimatedFrameCache(new AnimationFrameCacheKey(animatedImageResult.hashCode()), this.mBackingCache);
    }

    public static class AnimationFrameCacheKey implements CacheKey {
        private final String mAnimationUriString;

        public AnimationFrameCacheKey(int i) {
            this.mAnimationUriString = "anim://".concat(String.valueOf(i));
        }

        public boolean containsUri(Uri uri) {
            return uri.toString().startsWith(this.mAnimationUriString);
        }

        public String getUriString() {
            return this.mAnimationUriString;
        }
    }
}
