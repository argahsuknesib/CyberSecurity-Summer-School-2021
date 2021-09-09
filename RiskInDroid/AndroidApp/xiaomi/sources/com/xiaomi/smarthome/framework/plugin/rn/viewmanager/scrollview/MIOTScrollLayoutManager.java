package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.scrollview;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

@ReactModule(name = "MIOTAndroidScrollLayout")
public class MIOTScrollLayoutManager extends ReactViewManager {
    public String getName() {
        return "MIOTAndroidScrollLayout";
    }

    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new MIOTScrollLayout(themedReactContext);
    }

    @ReactProp(name = "headerHeight")
    public void setHeaderHeight(MIOTScrollLayout mIOTScrollLayout, int i) {
        mIOTScrollLayout.setHeaderHeight((int) (((float) i) * DisplayMetricsHolder.getScreenDisplayMetrics().density));
    }

    @ReactProp(name = "scaleIndices")
    public void setScaleIndices(MIOTScrollLayout mIOTScrollLayout, ReadableArray readableArray) {
        int size = readableArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        mIOTScrollLayout.setScaleIndices(iArr);
    }

    @ReactProp(name = "startScales")
    public void setStartScales(MIOTScrollLayout mIOTScrollLayout, ReadableArray readableArray) {
        int size = readableArray.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = readableArray.getDouble(i);
        }
        mIOTScrollLayout.setStartScales(dArr);
    }

    @ReactProp(name = "endScales")
    public void setEndScales(MIOTScrollLayout mIOTScrollLayout, ReadableArray readableArray) {
        int size = readableArray.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = readableArray.getDouble(i);
        }
        mIOTScrollLayout.setEndScales(dArr);
    }
}
