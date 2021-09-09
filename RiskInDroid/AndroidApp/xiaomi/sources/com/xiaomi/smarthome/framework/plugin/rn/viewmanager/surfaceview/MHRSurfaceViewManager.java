package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.surfaceview;

import _m_j.gdo;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.art.ARTSurfaceView;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

@ReactModule(name = "MHRSurfaceView")
public class MHRSurfaceViewManager extends BaseViewManager<ARTSurfaceView, gdo> {
    private static final YogaMeasureFunction MEASURE_FUNCTION = $$Lambda$MHRSurfaceViewManager$WuyLZe086Eis1O33FwASRRQUuPU.INSTANCE;

    public String getName() {
        return "MHRSurfaceView";
    }

    public void setBackgroundColor(ARTSurfaceView aRTSurfaceView, int i) {
    }

    static /* synthetic */ long lambda$static$0(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        throw new IllegalStateException("SurfaceView should have explicit width and height set");
    }

    public gdo createShadowNodeInstance() {
        gdo gdo = new gdo();
        gdo.setMeasureFunction(MEASURE_FUNCTION);
        return gdo;
    }

    public Class<gdo> getShadowNodeClass() {
        return gdo.class;
    }

    /* access modifiers changed from: protected */
    public ARTSurfaceView createViewInstance(ThemedReactContext themedReactContext) {
        return new ARTSurfaceView(themedReactContext);
    }

    public void updateExtraData(ARTSurfaceView aRTSurfaceView, Object obj) {
        aRTSurfaceView.setSurfaceTextureListener((gdo) obj);
    }
}
