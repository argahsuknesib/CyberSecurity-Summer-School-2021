package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.blurview;

import _m_j.gcb;
import android.view.View;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.modal.ReactModalHostView;

public class BlurViewManager extends SimpleViewManager<gcb> {
    private static ThemedReactContext context;

    public String getName() {
        return "BlurView";
    }

    public gcb createViewInstance(ThemedReactContext themedReactContext) {
        context = themedReactContext;
        gcb gcb = new gcb(themedReactContext);
        gcb.setBlurRadius(10);
        gcb.setDownsampleFactor(10);
        return gcb;
    }

    @ReactProp(defaultInt = 10, name = "blurRadius")
    public void setRadius(gcb gcb, int i) {
        gcb.setBlurRadius(i);
        gcb.invalidate();
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public void setColor(gcb gcb, int i) {
        gcb.setOverlayColor(i);
        gcb.invalidate();
    }

    @ReactProp(defaultInt = 10, name = "downsampleFactor")
    public void setDownsampleFactor(gcb gcb, int i) {
        gcb.setDownsampleFactor(i);
    }

    @ReactProp(name = "viewRef")
    public void setViewRef(gcb gcb, int i) {
        View findViewById;
        ThemedReactContext themedReactContext = context;
        if (themedReactContext != null && themedReactContext.getCurrentActivity() != null && (findViewById = context.getCurrentActivity().findViewById(i)) != null) {
            if (findViewById instanceof ReactModalHostView) {
                gcb.setmIsBlurReactModalHostView(true);
            } else {
                gcb.setmIsBlurReactModalHostView(false);
            }
            gcb.setBlurredView(findViewById);
        }
    }

    public void onDropViewInstance(gcb gcb) {
        super.onDropViewInstance((View) gcb);
        if (gcb.O00000o0 != null) {
            gcb.O00000o0.O00000o0();
            gcb.O00000o0 = null;
        }
        if (gcb.O00000Oo != null) {
            gcb.O00000Oo.O00000Oo();
            gcb.O00000Oo = null;
        }
    }
}
