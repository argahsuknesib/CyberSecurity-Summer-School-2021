package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name = "RNSScreenContainer")
public class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> {
    public String getName() {
        return "RNSScreenContainer";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenContainer createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenContainer(themedReactContext);
    }

    public void addView(ScreenContainer screenContainer, View view, int i) {
        if (view instanceof Screen) {
            screenContainer.O000000o((Screen) view, i);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens");
    }

    public void removeViewAt(ScreenContainer screenContainer, int i) {
        screenContainer.O000000o(i);
    }

    public int getChildCount(ScreenContainer screenContainer) {
        return screenContainer.getScreenCount();
    }

    public View getChildAt(ScreenContainer screenContainer, int i) {
        return screenContainer.O00000Oo(i);
    }
}
