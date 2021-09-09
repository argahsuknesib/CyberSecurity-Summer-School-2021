package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;

@ReactModule(name = "RCTRawText")
public class ReactRawTextManager extends ViewManager<View, ReactRawTextShadowNode> {
    public String getName() {
        return "RCTRawText";
    }

    public void updateExtraData(View view, Object obj) {
    }

    public ReactTextView createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("Attempt to create a native view for RCTRawText");
    }

    public Class<ReactRawTextShadowNode> getShadowNodeClass() {
        return ReactRawTextShadowNode.class;
    }

    public ReactRawTextShadowNode createShadowNodeInstance() {
        return new ReactRawTextShadowNode();
    }
}
