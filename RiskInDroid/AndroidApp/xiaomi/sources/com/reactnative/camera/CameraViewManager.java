package com.reactnative.camera;

import _m_j.ctd;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.cameraview.AspectRatio;
import java.util.ArrayList;
import java.util.Map;

public class CameraViewManager extends ViewGroupManager<ctd> {
    public String getName() {
        return "RNCamera";
    }

    public enum Events {
        EVENT_CAMERA_READY("onCameraReady"),
        EVENT_ON_MOUNT_ERROR("onMountError"),
        EVENT_ON_BAR_CODE_READ("onBarCodeRead"),
        EVENT_ON_FACES_DETECTED("onFacesDetected"),
        EVENT_ON_FACE_DETECTION_ERROR("onFaceDetectionError");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    public void onDropViewInstance(ctd ctd) {
        ctd.stop();
        super.onDropViewInstance((View) ctd);
    }

    /* access modifiers changed from: protected */
    public ctd createViewInstance(ThemedReactContext themedReactContext) {
        return new ctd(themedReactContext);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        for (Events events : Events.values()) {
            builder.put(events.toString(), MapBuilder.of("registrationName", events.toString()));
        }
        return builder.build();
    }

    @ReactProp(name = "type")
    public void setType(ctd ctd, int i) {
        ctd.setFacing(i);
    }

    @ReactProp(name = "ratio")
    public void setRatio(ctd ctd, String str) {
        ctd.setAspectRatio(AspectRatio.parse(str));
    }

    @ReactProp(name = "flashMode")
    public void setFlashMode(ctd ctd, int i) {
        ctd.setFlash(i);
    }

    @ReactProp(name = "autoFocus")
    public void setAutoFocus(ctd ctd, boolean z) {
        ctd.setAutoFocus(z);
    }

    @ReactProp(name = "focusDepth")
    public void setFocusDepth(ctd ctd, float f) {
        ctd.setFocusDepth(f);
    }

    @ReactProp(name = "zoom")
    public void setZoom(ctd ctd, float f) {
        ctd.setZoom(f);
    }

    @ReactProp(name = "whiteBalance")
    public void setWhiteBalance(ctd ctd, int i) {
        ctd.setWhiteBalance(i);
    }

    @ReactProp(name = "barCodeTypes")
    public void setBarCodeTypes(ctd ctd, ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList arrayList = new ArrayList(readableArray.size());
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(readableArray.getString(i));
            }
            ctd.setBarCodeTypes(arrayList);
        }
    }

    @ReactProp(name = "barCodeScannerEnabled")
    public void setBarCodeScanning(ctd ctd, boolean z) {
        ctd.setShouldScanBarCodes(z);
    }

    @ReactProp(name = "useCamera2Api")
    public void setUseCamera2Api(ctd ctd, boolean z) {
        ctd.setUsingCamera2Api(z);
    }

    @ReactProp(name = "faceDetectorEnabled")
    public void setFaceDetecting(ctd ctd, boolean z) {
        ctd.setShouldDetectFaces(z);
    }

    @ReactProp(name = "faceDetectionMode")
    public void setFaceDetectionMode(ctd ctd, int i) {
        ctd.setFaceDetectionMode(i);
    }

    @ReactProp(name = "faceDetectionLandmarks")
    public void setFaceDetectionLandmarks(ctd ctd, int i) {
        ctd.setFaceDetectionLandmarks(i);
    }

    @ReactProp(name = "faceDetectionClassifications")
    public void setFaceDetectionClassifications(ctd ctd, int i) {
        ctd.setFaceDetectionClassifications(i);
    }
}
