package com.facebook.react.views.text.frescosupport;

import android.view.View;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

@ReactModule(name = "RCTTextInlineImage")
public class FrescoBasedReactTextInlineImageViewManager extends ViewManager<View, FrescoBasedReactTextInlineImageShadowNode> {
    private final Object mCallerContext;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;

    public String getName() {
        return "RCTTextInlineImage";
    }

    public void updateExtraData(View view, Object obj) {
    }

    public FrescoBasedReactTextInlineImageViewManager() {
        this(null, null);
    }

    public FrescoBasedReactTextInlineImageViewManager(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj) {
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mCallerContext = obj;
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("RCTTextInlineImage doesn't map into a native view");
    }

    public FrescoBasedReactTextInlineImageShadowNode createShadowNodeInstance() {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mDraweeControllerBuilder;
        if (abstractDraweeControllerBuilder == null) {
            abstractDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        }
        return new FrescoBasedReactTextInlineImageShadowNode(abstractDraweeControllerBuilder, this.mCallerContext);
    }

    public Class<FrescoBasedReactTextInlineImageShadowNode> getShadowNodeClass() {
        return FrescoBasedReactTextInlineImageShadowNode.class;
    }
}
