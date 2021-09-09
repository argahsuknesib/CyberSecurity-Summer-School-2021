package com.facebook.react.views.art;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaNode;

@ReactModule(name = "ARTSurfaceView")
public class ARTSurfaceViewManager extends BaseViewManager<ARTSurfaceView, ARTSurfaceViewShadowNode> {
    private static final YogaMeasureFunction MEASURE_FUNCTION = new YogaMeasureFunction() {
        /* class com.facebook.react.views.art.ARTSurfaceViewManager.AnonymousClass1 */

        public final long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            throw new IllegalStateException("SurfaceView should have explicit width and height set");
        }
    };

    public String getName() {
        return "ARTSurfaceView";
    }

    public void setBackgroundColor(ARTSurfaceView aRTSurfaceView, int i) {
    }

    public ARTSurfaceViewShadowNode createShadowNodeInstance() {
        ARTSurfaceViewShadowNode aRTSurfaceViewShadowNode = new ARTSurfaceViewShadowNode();
        aRTSurfaceViewShadowNode.setMeasureFunction(MEASURE_FUNCTION);
        return aRTSurfaceViewShadowNode;
    }

    public Class<ARTSurfaceViewShadowNode> getShadowNodeClass() {
        return ARTSurfaceViewShadowNode.class;
    }

    /* access modifiers changed from: protected */
    public ARTSurfaceView createViewInstance(ThemedReactContext themedReactContext) {
        return new ARTSurfaceView(themedReactContext);
    }

    public void updateExtraData(ARTSurfaceView aRTSurfaceView, Object obj) {
        ((ARTSurfaceViewShadowNode) obj).setupSurfaceTextureListener(aRTSurfaceView);
    }
}
