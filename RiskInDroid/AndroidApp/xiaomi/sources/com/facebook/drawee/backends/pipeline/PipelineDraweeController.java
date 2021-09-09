package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.debug.listener.ImageLoadingTimeControllerListener;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Iterator;
import java.util.concurrent.Executor;

public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {
    private static final Class<?> TAG = PipelineDraweeController.class;
    public final DrawableFactory mAnimatedDrawableFactory;
    private CacheKey mCacheKey;
    private ImmutableList<DrawableFactory> mCustomDrawableFactories;
    private Supplier<DataSource<CloseableReference<CloseableImage>>> mDataSourceSupplier;
    private final DrawableFactory mDefaultDrawableFactory;
    private boolean mDrawDebugOverlay;
    private final ImmutableList<DrawableFactory> mGlobalDrawableFactories;
    private ImageOriginListener mImageOriginListener;
    private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    public final Resources mResources;

    public /* bridge */ /* synthetic */ Drawable createDrawable(Object obj) {
        return createDrawable((CloseableReference<CloseableImage>) ((CloseableReference) obj));
    }

    public /* bridge */ /* synthetic */ int getImageHash(Object obj) {
        return getImageHash((CloseableReference<CloseableImage>) ((CloseableReference) obj));
    }

    public /* bridge */ /* synthetic */ Object getImageInfo(Object obj) {
        return getImageInfo((CloseableReference<CloseableImage>) ((CloseableReference) obj));
    }

    public /* bridge */ /* synthetic */ void onImageLoadedFromCacheImmediately(String str, Object obj) {
        onImageLoadedFromCacheImmediately(str, (CloseableReference<CloseableImage>) ((CloseableReference) obj));
    }

    public /* bridge */ /* synthetic */ void releaseImage(Object obj) {
        releaseImage((CloseableReference<CloseableImage>) ((CloseableReference) obj));
    }

    public static boolean hasTransformableRotationAngle(CloseableStaticBitmap closeableStaticBitmap) {
        return (closeableStaticBitmap.getRotationAngle() == 0 || closeableStaticBitmap.getRotationAngle() == -1) ? false : true;
    }

    public static boolean hasTransformableExifOrientation(CloseableStaticBitmap closeableStaticBitmap) {
        if (closeableStaticBitmap.getExifOrientation() == 1 || closeableStaticBitmap.getExifOrientation() == 0) {
            return false;
        }
        return true;
    }

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj) {
        this(resources, deferredReleaser, drawableFactory, executor, memoryCache, supplier, str, cacheKey, obj, null);
    }

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, str, obj);
        this.mDefaultDrawableFactory = new DrawableFactory() {
            /* class com.facebook.drawee.backends.pipeline.PipelineDraweeController.AnonymousClass1 */

            public boolean supportsImageType(CloseableImage closeableImage) {
                return true;
            }

            public Drawable createDrawable(CloseableImage closeableImage) {
                if (closeableImage instanceof CloseableStaticBitmap) {
                    CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(PipelineDraweeController.this.mResources, closeableStaticBitmap.getUnderlyingBitmap());
                    if (PipelineDraweeController.hasTransformableRotationAngle(closeableStaticBitmap) || PipelineDraweeController.hasTransformableExifOrientation(closeableStaticBitmap)) {
                        return new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.getRotationAngle(), closeableStaticBitmap.getExifOrientation());
                    }
                    return bitmapDrawable;
                } else if (PipelineDraweeController.this.mAnimatedDrawableFactory == null || !PipelineDraweeController.this.mAnimatedDrawableFactory.supportsImageType(closeableImage)) {
                    return null;
                } else {
                    return PipelineDraweeController.this.mAnimatedDrawableFactory.createDrawable(closeableImage);
                }
            }
        };
        this.mResources = resources;
        this.mAnimatedDrawableFactory = drawableFactory;
        this.mMemoryCache = memoryCache;
        this.mCacheKey = cacheKey;
        this.mGlobalDrawableFactories = immutableList;
        init(supplier);
    }

    public void initialize(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        super.initialize(str, obj);
        init(supplier);
        this.mCacheKey = cacheKey;
        setCustomDrawableFactories(immutableList);
        setImageOriginListener(imageOriginListener);
    }

    public void setDrawDebugOverlay(boolean z) {
        this.mDrawDebugOverlay = z;
    }

    public void setCustomDrawableFactories(ImmutableList<DrawableFactory> immutableList) {
        this.mCustomDrawableFactories = immutableList;
    }

    public void setImageOriginListener(ImageOriginListener imageOriginListener) {
        synchronized (this) {
            this.mImageOriginListener = imageOriginListener;
        }
    }

    private void init(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier) {
        this.mDataSourceSupplier = supplier;
        maybeUpdateDebugOverlay(null);
    }

    /* access modifiers changed from: protected */
    public Resources getResources() {
        return this.mResources;
    }

    /* access modifiers changed from: protected */
    public CacheKey getCacheKey() {
        return this.mCacheKey;
    }

    public DataSource<CloseableReference<CloseableImage>> getDataSource() {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return this.mDataSourceSupplier.get();
    }

    /* access modifiers changed from: protected */
    public Drawable createDrawable(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        CloseableImage closeableImage = closeableReference.get();
        maybeUpdateDebugOverlay(closeableImage);
        Drawable maybeCreateDrawableFromFactories = maybeCreateDrawableFromFactories(this.mCustomDrawableFactories, closeableImage);
        if (maybeCreateDrawableFromFactories != null) {
            return maybeCreateDrawableFromFactories;
        }
        Drawable maybeCreateDrawableFromFactories2 = maybeCreateDrawableFromFactories(this.mGlobalDrawableFactories, closeableImage);
        if (maybeCreateDrawableFromFactories2 != null) {
            return maybeCreateDrawableFromFactories2;
        }
        Drawable createDrawable = this.mDefaultDrawableFactory.createDrawable(closeableImage);
        if (createDrawable != null) {
            return createDrawable;
        }
        throw new UnsupportedOperationException("Unrecognized image class: ".concat(String.valueOf(closeableImage)));
    }

    private Drawable maybeCreateDrawableFromFactories(ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        Drawable createDrawable;
        if (immutableList == null) {
            return null;
        }
        Iterator<DrawableFactory> it = immutableList.iterator();
        while (it.hasNext()) {
            DrawableFactory next = it.next();
            if (next.supportsImageType(closeableImage) && (createDrawable = next.createDrawable(closeableImage)) != null) {
                return createDrawable;
            }
        }
        return null;
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        super.setHierarchy(draweeHierarchy);
        maybeUpdateDebugOverlay(null);
    }

    public boolean isSameImageRequest(DraweeController draweeController) {
        if (draweeController instanceof PipelineDraweeController) {
            return Objects.equal(this.mCacheKey, ((PipelineDraweeController) draweeController).getCacheKey());
        }
        return false;
    }

    private void maybeUpdateDebugOverlay(CloseableImage closeableImage) {
        ScaleTypeDrawable activeScaleTypeDrawable;
        if (this.mDrawDebugOverlay) {
            if (getControllerOverlay() == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                addControllerListener(new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable));
                setControllerOverlay(debugControllerOverlayDrawable);
            }
            if (getControllerOverlay() instanceof DebugControllerOverlayDrawable) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable) getControllerOverlay();
                debugControllerOverlayDrawable2.setControllerId(getId());
                DraweeHierarchy hierarchy = getHierarchy();
                ScalingUtils.ScaleType scaleType = null;
                if (!(hierarchy == null || (activeScaleTypeDrawable = ScalingUtils.getActiveScaleTypeDrawable(hierarchy.getTopLevelDrawable())) == null)) {
                    scaleType = activeScaleTypeDrawable.getScaleType();
                }
                debugControllerOverlayDrawable2.setScaleType(scaleType);
                if (closeableImage != null) {
                    debugControllerOverlayDrawable2.setDimensions(closeableImage.getWidth(), closeableImage.getHeight());
                    debugControllerOverlayDrawable2.setImageSize(closeableImage.getSizeInBytes());
                    return;
                }
                debugControllerOverlayDrawable2.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public ImageInfo getImageInfo(CloseableReference<CloseableImage> closeableReference) {
        Preconditions.checkState(CloseableReference.isValid(closeableReference));
        return closeableReference.get();
    }

    /* access modifiers changed from: protected */
    public int getImageHash(CloseableReference<CloseableImage> closeableReference) {
        if (closeableReference != null) {
            return closeableReference.getValueHash();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void releaseImage(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference.closeSafely(closeableReference);
    }

    public void releaseDrawable(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).dropCaches();
        }
    }

    /* access modifiers changed from: protected */
    public CloseableReference<CloseableImage> getCachedImage() {
        CacheKey cacheKey;
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mMemoryCache;
        if (memoryCache == null || (cacheKey = this.mCacheKey) == null) {
            return null;
        }
        CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.drawee.controller.AbstractDraweeController.onImageLoadedFromCacheImmediately(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>]
     candidates:
      com.facebook.drawee.backends.pipeline.PipelineDraweeController.onImageLoadedFromCacheImmediately(java.lang.String, com.facebook.common.references.CloseableReference<com.facebook.imagepipeline.image.CloseableImage>):void
      com.facebook.drawee.controller.AbstractDraweeController.onImageLoadedFromCacheImmediately(java.lang.String, java.lang.Object):void */
    /* access modifiers changed from: protected */
    public void onImageLoadedFromCacheImmediately(String str, CloseableReference<CloseableImage> closeableReference) {
        super.onImageLoadedFromCacheImmediately(str, (Object) closeableReference);
        synchronized (this) {
            if (this.mImageOriginListener != null) {
                this.mImageOriginListener.onImageLoaded(str, 2, true);
            }
        }
    }

    public String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.mDataSourceSupplier).toString();
    }
}
