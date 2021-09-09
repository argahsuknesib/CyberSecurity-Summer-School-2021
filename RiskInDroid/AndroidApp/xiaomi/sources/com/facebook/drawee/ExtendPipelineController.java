package com.facebook.drawee;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.generic.ExtendGenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.concurrent.Executor;

public class ExtendPipelineController extends PipelineDraweeController {
    public ExtendPipelineController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj) {
        super(resources, deferredReleaser, drawableFactory, executor, memoryCache, supplier, str, cacheKey, obj);
    }

    public ExtendPipelineController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList) {
        super(resources, deferredReleaser, drawableFactory, executor, memoryCache, supplier, str, cacheKey, obj, immutableList);
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        DraweeHierarchy hierarchy = getHierarchy();
        boolean z = hierarchy instanceof ExtendGenericDraweeHierarchy;
        if (z) {
            ((ExtendGenericDraweeHierarchy) hierarchy).setInitializing(true);
        }
        super.initialize(supplier, str, cacheKey, obj, immutableList, imageOriginListener);
        if (z) {
            ((ExtendGenericDraweeHierarchy) hierarchy).setInitializing(false);
        }
    }
}
