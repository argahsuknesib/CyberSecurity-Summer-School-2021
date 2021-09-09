package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name = "RCTVirtualText")
public class ReactVirtualTextViewManager extends BaseViewManager<View, ReactVirtualTextShadowNode> {
    public String getName() {
        return "RCTVirtualText";
    }

    public void updateExtraData(View view, Object obj) {
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("Attempt to create a native view for RCTVirtualText");
    }

    public Class<ReactVirtualTextShadowNode> getShadowNodeClass() {
        return ReactVirtualTextShadowNode.class;
    }

    public ReactVirtualTextShadowNode createShadowNodeInstance() {
        return new ReactVirtualTextShadowNode();
    }
}
