package com.facebook.fresco.animation.factory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactoryImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;

@DoNotStrip
public class AnimatedFactoryV2Impl implements AnimatedFactory {
    private AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private DrawableFactory mAnimatedDrawableFactory;
    private AnimatedDrawableUtil mAnimatedDrawableUtil;
    private AnimatedImageFactory mAnimatedImageFactory;
    private final CountingMemoryCache<CacheKey, CloseableImage> mBackingCache;
    private final ExecutorSupplier mExecutorSupplier;
    private final PlatformBitmapFactory mPlatformBitmapFactory;

    @DoNotStrip
    public AnimatedFactoryV2Impl(PlatformBitmapFactory platformBitmapFactory, ExecutorSupplier executorSupplier, CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache) {
        this.mPlatformBitmapFactory = platformBitmapFactory;
        this.mExecutorSupplier = executorSupplier;
        this.mBackingCache = countingMemoryCache;
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        if (this.mAnimatedDrawableFactory == null) {
            this.mAnimatedDrawableFactory = createDrawableFactory();
        }
        return this.mAnimatedDrawableFactory;
    }

    public ImageDecoder getGifDecoder(final Bitmap.Config config) {
        return new ImageDecoder() {
            /* class com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.AnonymousClass1 */

            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeGif(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    public ImageDecoder getWebPDecoder(final Bitmap.Config config) {
        return new ImageDecoder() {
            /* class com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.AnonymousClass2 */

            public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
                return AnimatedFactoryV2Impl.this.getAnimatedImageFactory().decodeWebP(encodedImage, imageDecodeOptions, config);
            }
        };
    }

    private ExperimentalBitmapAnimationDrawableFactory createDrawableFactory() {
        AnonymousClass3 r7 = new Supplier<Integer>() {
            /* class com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.AnonymousClass3 */

            public Integer get() {
                return 2;
            }
        };
        return new ExperimentalBitmapAnimationDrawableFactory(getAnimatedDrawableBackendProvider(), UiThreadImmediateExecutorService.getInstance(), new DefaultSerialExecutorService(this.mExecutorSupplier.forDecode()), RealtimeSinceBootClock.get(), this.mPlatformBitmapFactory, this.mBackingCache, r7, new Supplier<Integer>() {
            /* class com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.AnonymousClass4 */

            public Integer get() {
                return 3;
            }
        });
    }

    public AnimatedDrawableUtil getAnimatedDrawableUtil() {
        if (this.mAnimatedDrawableUtil == null) {
            this.mAnimatedDrawableUtil = new AnimatedDrawableUtil();
        }
        return this.mAnimatedDrawableUtil;
    }

    public AnimatedImageFactory getAnimatedImageFactory() {
        if (this.mAnimatedImageFactory == null) {
            this.mAnimatedImageFactory = buildAnimatedImageFactory();
        }
        return this.mAnimatedImageFactory;
    }

    private AnimatedDrawableBackendProvider getAnimatedDrawableBackendProvider() {
        if (this.mAnimatedDrawableBackendProvider == null) {
            this.mAnimatedDrawableBackendProvider = new AnimatedDrawableBackendProvider() {
                /* class com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.AnonymousClass5 */

                public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                    return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect);
                }
            };
        }
        return this.mAnimatedDrawableBackendProvider;
    }

    private AnimatedImageFactory buildAnimatedImageFactory() {
        return new AnimatedImageFactoryImpl(new AnimatedDrawableBackendProvider() {
            /* class com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl.AnonymousClass6 */

            public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
                return new AnimatedDrawableBackendImpl(AnimatedFactoryV2Impl.this.getAnimatedDrawableUtil(), animatedImageResult, rect);
            }
        }, this.mPlatformBitmapFactory);
    }
}
