package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;

public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
    private final Set<ControllerListener> mBoundControllerListeners;
    private final Context mContext;
    private final ImagePipeline mImagePipeline;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        this(context, null);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, DraweeConfig draweeConfig) {
        this(context, ImagePipelineFactory.getInstance(), draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, DraweeConfig draweeConfig) {
        this(context, imagePipelineFactory, null, draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, Set<ControllerListener> set, DraweeConfig draweeConfig) {
        this.mContext = context;
        this.mImagePipeline = imagePipelineFactory.getImagePipeline();
        if (draweeConfig == null || draweeConfig.getPipelineDraweeControllerFactory() == null) {
            this.mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        } else {
            this.mPipelineDraweeControllerFactory = draweeConfig.getPipelineDraweeControllerFactory();
        }
        this.mPipelineDraweeControllerFactory.init(context.getResources(), DeferredReleaser.getInstance(), imagePipelineFactory.getAnimatedDrawableFactory(context), UiThreadImmediateExecutorService.getInstance(), this.mImagePipeline.getBitmapMemoryCache(), draweeConfig != null ? draweeConfig.getCustomDrawableFactories() : null, draweeConfig != null ? draweeConfig.getDebugOverlayEnabledSupplier() : null);
        this.mBoundControllerListeners = set;
    }

    public PipelineDraweeControllerBuilder get() {
        return new PipelineDraweeControllerBuilder(this.mContext, this.mPipelineDraweeControllerFactory, this.mImagePipeline, this.mBoundControllerListeners);
    }
}
