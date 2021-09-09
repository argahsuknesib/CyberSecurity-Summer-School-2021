package com.facebook.react.views.unimplementedview;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

@ReactModule(name = "UnimplementedNativeView")
public class ReactUnimplementedViewManager extends ViewGroupManager<ReactUnimplementedView> {
    public String getName() {
        return "UnimplementedNativeView";
    }

    /* access modifiers changed from: protected */
    public ReactUnimplementedView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactUnimplementedView(themedReactContext);
    }

    @ReactProp(name = "name")
    public void setName(ReactUnimplementedView reactUnimplementedView, String str) {
        reactUnimplementedView.setName(str);
    }
}
