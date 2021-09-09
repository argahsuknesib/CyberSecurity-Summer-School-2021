package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public class PipelineDraweeControllerFactory {
    private DrawableFactory mAnimatedDrawableFactory;
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    private DeferredReleaser mDeferredReleaser;
    private ImmutableList<DrawableFactory> mDrawableFactories;
    private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private Resources mResources;
    private Executor mUiThreadExecutor;

    public void init(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList, Supplier<Boolean> supplier) {
        this.mResources = resources;
        this.mDeferredReleaser = deferredReleaser;
        this.mAnimatedDrawableFactory = drawableFactory;
        this.mUiThreadExecutor = executor;
        this.mMemoryCache = memoryCache;
        this.mDrawableFactories = immutableList;
        this.mDebugOverlayEnabledSupplier = supplier;
    }

    public PipelineDraweeController newController(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj) {
        return newController(supplier, str, cacheKey, obj, null, null);
    }

    public PipelineDraweeController newController(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        Preconditions.checkState(this.mResources != null, "init() not called");
        PipelineDraweeController internalCreateController = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories, immutableList, supplier, str, cacheKey, obj);
        Supplier<Boolean> supplier2 = this.mDebugOverlayEnabledSupplier;
        if (supplier2 != null) {
            internalCreateController.setDrawDebugOverlay(supplier2.get().booleanValue());
        }
        internalCreateController.setImageOriginListener(imageOriginListener);
        return internalCreateController;
    }

    /* access modifiers changed from: protected */
    public PipelineDraweeController internalCreateController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList, ImmutableList<DrawableFactory> immutableList2, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj) {
        PipelineDraweeController pipelineDraweeController = new PipelineDraweeController(resources, deferredReleaser, drawableFactory, executor, memoryCache, supplier, str, cacheKey, obj, immutableList);
        pipelineDraweeController.setCustomDrawableFactories(immutableList2);
        return pipelineDraweeController;
    }
}
