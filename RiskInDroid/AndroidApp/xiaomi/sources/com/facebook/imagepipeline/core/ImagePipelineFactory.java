package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.time.SystemClock;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.HoneycombBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.MediaVariationsIndex;
import com.facebook.imagepipeline.cache.MediaVariationsIndexDatabase;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.NoOpMediaVariationsIndex;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.ArtDecoder;
import com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder;
import com.facebook.imagepipeline.platform.KitKatPurgeableDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;

public class ImagePipelineFactory {
    private static ImagePipelineFactory sInstance;
    private AnimatedFactory mAnimatedFactory;
    private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    private MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final ImagePipelineConfig mConfig;
    private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    private MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private ImageDecoder mImageDecoder;
    private ImagePipeline mImagePipeline;
    private BufferedDiskCache mMainBufferedDiskCache;
    private FileCache mMainFileCache;
    private MediaVariationsIndex mMediaVariationsIndex;
    private PlatformBitmapFactory mPlatformBitmapFactory;
    private PlatformDecoder mPlatformDecoder;
    private ProducerFactory mProducerFactory;
    private ProducerSequenceFactory mProducerSequenceFactory;
    private BufferedDiskCache mSmallImageBufferedDiskCache;
    private FileCache mSmallImageFileCache;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public static ImagePipelineFactory getInstance() {
        return (ImagePipelineFactory) Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    public static void initialize(Context context) {
        initialize(ImagePipelineConfig.newBuilder(context).build());
    }

    public static void initialize(ImagePipelineConfig imagePipelineConfig) {
        sInstance = new ImagePipelineFactory(imagePipelineConfig);
    }

    public static void shutDown() {
        ImagePipelineFactory imagePipelineFactory = sInstance;
        if (imagePipelineFactory != null) {
            imagePipelineFactory.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
            sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
            sInstance = null;
        }
    }

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        this.mConfig = (ImagePipelineConfig) Preconditions.checkNotNull(imagePipelineConfig);
        this.mThreadHandoffProducerQueue = new ThreadHandoffProducerQueue(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
    }

    private AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache());
        }
        return this.mAnimatedFactory;
    }

    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), getPlatformBitmapFactory(), this.mConfig.getExperiments().isExternalCreatedBitmapLogEnabled(), this.mConfig.getBitmapMemoryCacheTrimStrategy());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        if (this.mBitmapMemoryCache == null) {
            this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), getPlatformBitmapFactory());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public MemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        if (this.mEncodedMemoryCache == null) {
            this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    private ImageDecoder getImageDecoder() {
        ImageDecoder imageDecoder;
        if (this.mImageDecoder == null) {
            if (this.mConfig.getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.getImageDecoder();
            } else {
                AnimatedFactory animatedFactory = getAnimatedFactory();
                ImageDecoder imageDecoder2 = null;
                if (animatedFactory != null) {
                    imageDecoder2 = animatedFactory.getGifDecoder(this.mConfig.getBitmapConfig());
                    imageDecoder = animatedFactory.getWebPDecoder(this.mConfig.getBitmapConfig());
                } else {
                    imageDecoder = null;
                }
                if (this.mConfig.getImageDecoderConfig() == null) {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder());
                } else {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                    ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
                }
            }
        }
        return this.mImageDecoder;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.mMainBufferedDiskCache == null) {
            this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mMainBufferedDiskCache;
    }

    public FileCache getMainFileCache() {
        if (this.mMainFileCache == null) {
            this.mMainFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getMainDiskCacheConfig());
        }
        return this.mMainFileCache;
    }

    public ImagePipeline getImagePipeline() {
        if (this.mImagePipeline == null) {
            this.mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, Suppliers.of(Boolean.FALSE));
        }
        return this.mImagePipeline;
    }

    public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory poolFactory, PlatformDecoder platformDecoder) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new ArtBitmapFactory(poolFactory.getBitmapPool());
        }
        if (Build.VERSION.SDK_INT >= 11) {
            return new HoneycombBitmapFactory(new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory()), platformDecoder);
        }
        return new GingerbreadBitmapFactory();
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            this.mPlatformBitmapFactory = buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder());
        }
        return this.mPlatformBitmapFactory;
    }

    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools.O00000Oo(flexByteArrayPoolMaxNumThreads));
        } else if (!z || Build.VERSION.SDK_INT >= 19) {
            return new KitKatPurgeableDecoder(poolFactory.getFlexByteArrayPool());
        } else {
            return new GingerbreadPurgeableDecoder();
        }
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isWebpSupportEnabled());
        }
        return this.mPlatformDecoder;
    }

    private ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExperiments().isSmartResizingEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), getMediaVariationsIndex(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch());
        }
        return this.mProducerFactory;
    }

    private ProducerSequenceFactory getProducerSequenceFactory() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), z, this.mConfig.getExperiments().isPartialImageCachingEnabled());
        }
        return this.mProducerSequenceFactory;
    }

    public FileCache getSmallImageFileCache() {
        if (this.mSmallImageFileCache == null) {
            this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getSmallImageDiskCacheConfig());
        }
        return this.mSmallImageFileCache;
    }

    private BufferedDiskCache getSmallImageBufferedDiskCache() {
        if (this.mSmallImageBufferedDiskCache == null) {
            this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mSmallImageBufferedDiskCache;
    }

    public MediaVariationsIndex getMediaVariationsIndex() {
        if (this.mMediaVariationsIndex == null) {
            this.mMediaVariationsIndex = this.mConfig.getExperiments().getMediaVariationsIndexEnabled() ? new MediaVariationsIndexDatabase(this.mConfig.getContext(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), SystemClock.get()) : new NoOpMediaVariationsIndex();
        }
        return this.mMediaVariationsIndex;
    }
}
