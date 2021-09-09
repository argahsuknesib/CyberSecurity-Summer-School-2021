package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.pdf;

import _m_j.gcu;
import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RCTPdfManager extends SimpleViewManager<gcu> {
    private Context context;
    private gcu pdfView;

    public String getName() {
        return "RCTPdf";
    }

    public void onDropViewInstance(gcu gcu) {
    }

    public RCTPdfManager(ReactApplicationContext reactApplicationContext) {
        this.context = reactApplicationContext;
    }

    public gcu createViewInstance(ThemedReactContext themedReactContext) {
        this.pdfView = new gcu(themedReactContext);
        return this.pdfView;
    }

    @ReactProp(name = "path")
    public void setPath(gcu gcu, String str) {
        gcu.setPath(str);
    }

    @ReactProp(name = "page")
    public void setPage(gcu gcu, int i) {
        gcu.setPage(i);
    }

    @ReactProp(name = "scale")
    public void setScale(gcu gcu, float f) {
        gcu.setScale(f);
    }

    @ReactProp(name = "minScale")
    public void setMinScale(gcu gcu, float f) {
        gcu.setMinScale(f);
    }

    @ReactProp(name = "maxScale")
    public void setMaxScale(gcu gcu, float f) {
        gcu.setMaxScale(f);
    }

    @ReactProp(name = "horizontal")
    public void setHorizontal(gcu gcu, boolean z) {
        gcu.setHorizontal(z);
    }

    @ReactProp(name = "spacing")
    public void setSpacing(gcu gcu, int i) {
        gcu.setSpacing(i);
    }

    @ReactProp(name = "password")
    public void setPassword(gcu gcu, String str) {
        gcu.setPassword(str);
    }

    @ReactProp(name = "enableAntialiasing")
    public void setEnableAntialiasing(gcu gcu, boolean z) {
        gcu.setEnableAntialiasing(z);
    }

    @ReactProp(name = "enableAnnotationRendering")
    public void setEnableAnnotationRendering(gcu gcu, boolean z) {
        gcu.setEnableAnnotationRendering(z);
    }

    @ReactProp(name = "enablePaging")
    public void setEnablePaging(gcu gcu, boolean z) {
        gcu.setEnablePaging(z);
    }

    @ReactProp(name = "fitPolicy")
    public void setFitPolycy(gcu gcu, int i) {
        gcu.setFitPolicy(i);
    }

    public void onAfterUpdateTransaction(gcu gcu) {
        super.onAfterUpdateTransaction((View) gcu);
        gcu.O00000oo();
    }
}
