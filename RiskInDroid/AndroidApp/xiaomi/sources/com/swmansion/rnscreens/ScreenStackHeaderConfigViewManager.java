package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

@ReactModule(name = "RNSScreenStackHeaderConfig")
public class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> {
    public String getName() {
        return "RNSScreenStackHeaderConfig";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenStackHeaderConfig createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenStackHeaderConfig(themedReactContext);
    }

    public void addView(ScreenStackHeaderConfig screenStackHeaderConfig, View view, int i) {
        if (view instanceof ScreenStackHeaderSubview) {
            screenStackHeaderConfig.f5791O000000o.add(i, (ScreenStackHeaderSubview) view);
            screenStackHeaderConfig.O00000Oo();
            return;
        }
        throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
    }

    public int getChildCount(ScreenStackHeaderConfig screenStackHeaderConfig) {
        return screenStackHeaderConfig.getConfigSubviewsCount();
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ScreenStackHeaderConfig screenStackHeaderConfig) {
        super.onAfterUpdateTransaction((View) screenStackHeaderConfig);
        screenStackHeaderConfig.O000000o();
    }

    @ReactProp(name = "title")
    public void setTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        screenStackHeaderConfig.setTitle(str);
    }

    @ReactProp(name = "titleFontFamily")
    public void setTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        screenStackHeaderConfig.setTitleFontFamily(str);
    }

    @ReactProp(name = "titleFontSize")
    public void setTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, float f) {
        screenStackHeaderConfig.setTitleFontSize(f);
    }

    @ReactProp(customType = "Color", name = "titleColor")
    public void setTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.setTitleColor(i);
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.setBackgroundColor(i);
    }

    @ReactProp(name = "hideShadow")
    public void setHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setHideShadow(z);
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setGestureEnabled(z);
    }

    @ReactProp(name = "hideBackButton")
    public void setHideBackButton(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setHideBackButton(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.setTintColor(i);
    }

    @ReactProp(name = "hidden")
    public void setHidden(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setHidden(z);
    }

    public void removeViewAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.f5791O000000o.remove(i);
        screenStackHeaderConfig.O00000Oo();
    }

    public View getChildAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        return screenStackHeaderConfig.f5791O000000o.get(i);
    }
}
