package com.facebook.react.uimanager;

import android.view.ViewGroup;
import android.widget.FrameLayout;

public class RootViewManager extends ViewGroupManager<ViewGroup> {
    public String getName() {
        return "RootView";
    }

    /* access modifiers changed from: protected */
    public ViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new FrameLayout(themedReactContext);
    }
}
