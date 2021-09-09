package com.facebook.drawee;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerFactory;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public class ExtendPipelineControllerFactory extends PipelineDraweeControllerFactory {
    public PipelineDraweeController internalCreateController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList, ImmutableList<DrawableFactory> immutableList2, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj) {
        ExtendPipelineController extendPipelineController = new ExtendPipelineController(resources, deferredReleaser, drawableFactory, executor, memoryCache, supplier, str, cacheKey, obj, immutableList);
        extendPipelineController.setCustomDrawableFactories(immutableList2);
        return extendPipelineController;
    }
}
