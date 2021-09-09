package com.swmansion.gesturehandler.react;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;

@ReactModule(name = "GestureHandlerRootView")
public class RNGestureHandlerRootViewManager extends ViewGroupManager<RNGestureHandlerRootView> {
    public String getName() {
        return "GestureHandlerRootView";
    }

    /* access modifiers changed from: protected */
    public RNGestureHandlerRootView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNGestureHandlerRootView(themedReactContext);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onGestureHandlerEvent", MapBuilder.of("registrationName", "onGestureHandlerEvent"), "onGestureHandlerStateChange", MapBuilder.of("registrationName", "onGestureHandlerStateChange"));
    }

    public void onDropViewInstance(RNGestureHandlerRootView rNGestureHandlerRootView) {
        if (rNGestureHandlerRootView.f5769O000000o != null) {
            rNGestureHandlerRootView.f5769O000000o.O000000o();
        }
    }
}
