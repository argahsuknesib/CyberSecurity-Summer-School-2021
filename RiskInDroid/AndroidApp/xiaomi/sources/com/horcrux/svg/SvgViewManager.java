package com.horcrux.svg;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

class SvgViewManager extends ReactViewManager {
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();
    private static final SparseArray<SvgView> mTagToSvgView = new SparseArray<>();

    public String getName() {
        return "RNSVGSvgView";
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    SvgViewManager() {
    }

    static void setSvgView(int i, SvgView svgView) {
        mTagToSvgView.put(i, svgView);
        Runnable runnable = mTagToRunnable.get(i);
        if (runnable != null) {
            runnable.run();
            mTagToRunnable.delete(i);
        }
    }

    static void runWhenViewIsAvailable(int i, Runnable runnable) {
        mTagToRunnable.put(i, runnable);
    }

    static SvgView getSvgViewByTag(int i) {
        return mTagToSvgView.get(i);
    }

    public SvgView createViewInstance(ThemedReactContext themedReactContext) {
        return new SvgView(themedReactContext);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.facebook.react.uimanager.ViewGroupManager.updateExtraData(android.view.ViewGroup, java.lang.Object):void
     arg types: [com.facebook.react.views.view.ReactViewGroup, java.lang.Object]
     candidates:
      com.horcrux.svg.SvgViewManager.updateExtraData(android.view.View, java.lang.Object):void
      com.horcrux.svg.SvgViewManager.updateExtraData(com.facebook.react.views.view.ReactViewGroup, java.lang.Object):void
      com.facebook.react.uimanager.ViewGroupManager.updateExtraData(android.view.View, java.lang.Object):void
      com.facebook.react.uimanager.ViewManager.updateExtraData(android.view.View, java.lang.Object):void
      com.facebook.react.uimanager.ViewGroupManager.updateExtraData(android.view.ViewGroup, java.lang.Object):void */
    public void updateExtraData(ReactViewGroup reactViewGroup, Object obj) {
        super.updateExtraData((ViewGroup) reactViewGroup, obj);
        reactViewGroup.invalidate();
    }

    public void onDropViewInstance(ReactViewGroup reactViewGroup) {
        super.onDropViewInstance((View) reactViewGroup);
        mTagToSvgView.remove(reactViewGroup.getId());
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(SvgView svgView, Integer num) {
        svgView.setTintColor(num);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(SvgView svgView, Integer num) {
        svgView.setTintColor(num);
    }

    @ReactProp(name = "minX")
    public void setMinX(SvgView svgView, float f) {
        svgView.setMinX(f);
    }

    @ReactProp(name = "minY")
    public void setMinY(SvgView svgView, float f) {
        svgView.setMinY(f);
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(SvgView svgView, float f) {
        svgView.setVbWidth(f);
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(SvgView svgView, float f) {
        svgView.setVbHeight(f);
    }

    @ReactProp(name = "bbWidth")
    public void setBbWidth(SvgView svgView, Dynamic dynamic) {
        svgView.setBbWidth(dynamic);
    }

    @ReactProp(name = "bbHeight")
    public void setBbHeight(SvgView svgView, Dynamic dynamic) {
        svgView.setBbHeight(dynamic);
    }

    @ReactProp(name = "align")
    public void setAlign(SvgView svgView, String str) {
        svgView.setAlign(str);
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(SvgView svgView, int i) {
        svgView.setMeetOrSlice(i);
    }
}
