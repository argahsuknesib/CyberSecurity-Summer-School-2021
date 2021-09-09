package com.facebook.react.views.scroll;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name = "AndroidHorizontalScrollContentView")
public class ReactHorizontalScrollContainerViewManager extends ViewGroupManager<ReactHorizontalScrollContainerView> {
    public String getName() {
        return "AndroidHorizontalScrollContentView";
    }

    public ReactHorizontalScrollContainerView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactHorizontalScrollContainerView(themedReactContext);
    }
}
