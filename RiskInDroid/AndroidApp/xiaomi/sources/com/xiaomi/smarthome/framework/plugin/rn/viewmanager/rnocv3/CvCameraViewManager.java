package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3;

import _m_j.gdc;
import _m_j.gsy;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class CvCameraViewManager extends SimpleViewManager<gdc> {
    private static final String TAG = "CvCameraViewManager";

    public String getName() {
        return "CvCameraView";
    }

    /* access modifiers changed from: protected */
    public gdc createViewInstance(ThemedReactContext themedReactContext) {
        return new gdc(themedReactContext);
    }

    public Map<String, Integer> getCommandsMap() {
        gsy.O000000o(3, TAG, "View manager getCommandsMap:");
        return MapBuilder.of("setOverlay", 1);
    }

    public void receiveCommand(gdc gdc, int i, ReadableArray readableArray) {
        if (i == 1) {
            gdc.setOverlay(readableArray.getMap(0));
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), getClass().getSimpleName()));
        }
    }

    @ReactProp(name = "facing")
    public void setFacing(gdc gdc, String str) {
        int i = str.equals("front") ? 1 : -1;
        if (gdc.O00000o != i) {
            gdc.O00000o = i;
            gdc.O00000o();
            gdc.setCameraIndex(gdc.O00000o);
            gdc.O00000o0();
        }
    }

    @ReactProp(name = "cvinvoke")
    public void setCvInvoke(gdc gdc, ReadableMap readableMap) {
        gdc.setCvInvokeGroup(readableMap);
    }

    @ReactProp(name = "faceClassifier")
    public void setFaceClassifier(gdc gdc, String str) {
        gdc.O000000o(str, whichOne.FACE_CLASSIFIER);
    }

    @ReactProp(name = "eyesClassifier")
    public void setEyesClassifier(gdc gdc, String str) {
        gdc.O000000o(str, whichOne.EYES_CLASSIFIER);
    }

    @ReactProp(name = "noseClassifier")
    public void setNoseClassifier(gdc gdc, String str) {
        gdc.O000000o(str, whichOne.NOSE_CLASSIFIER);
    }

    @ReactProp(name = "mouthClassifier")
    public void setMouthClassifier(gdc gdc, String str) {
        gdc.O000000o(str, whichOne.MOUTH_CLASSIFIER);
    }

    @ReactProp(name = "landmarksModel")
    public void setLandmarksModel(gdc gdc, String str) {
        gdc.setLandmarksModel(str);
    }

    @ReactProp(name = "overlayInterval")
    public void setOverlayInterval(gdc gdc, int i) {
        gdc.setOverlayInterval(i);
    }
}
