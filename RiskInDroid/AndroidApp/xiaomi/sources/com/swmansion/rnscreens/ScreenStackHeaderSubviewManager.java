package com.swmansion.rnscreens;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;

@ReactModule(name = "RNSScreenStackHeaderSubview")
public class ScreenStackHeaderSubviewManager extends ReactViewManager {
    public String getName() {
        return "RNSScreenStackHeaderSubview";
    }

    static class O000000o extends LayoutShadowNode {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final void setLocalData(Object obj) {
            ScreenStackHeaderSubview.O000000o o000000o = (ScreenStackHeaderSubview.O000000o) obj;
            setStyleWidth((float) o000000o.f5795O000000o);
            setStyleHeight((float) o000000o.O00000Oo);
        }
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenStackHeaderSubview(themedReactContext);
    }

    public LayoutShadowNode createShadowNodeInstance(ReactApplicationContext reactApplicationContext) {
        return new O000000o((byte) 0);
    }

    @ReactProp(name = "type")
    public void setType(ScreenStackHeaderSubview screenStackHeaderSubview, String str) {
        if ("left".equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.LEFT);
        } else if ("center".equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.CENTER);
        } else if ("title".equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.TITLE);
        } else if ("right".equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.RIGHT);
        }
    }
}
