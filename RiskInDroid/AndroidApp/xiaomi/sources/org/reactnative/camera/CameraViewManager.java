package org.reactnative.camera;

import _m_j.jlt;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;
import java.util.ArrayList;
import java.util.Map;

public class CameraViewManager extends ViewGroupManager<jlt> {
    public String getName() {
        return "RNCamera";
    }

    public enum Events {
        EVENT_CAMERA_READY("onCameraReady"),
        EVENT_ON_MOUNT_ERROR("onMountError"),
        EVENT_ON_BAR_CODE_READ("onBarCodeRead"),
        EVENT_ON_FACES_DETECTED("onFacesDetected"),
        EVENT_ON_BARCODES_DETECTED("onGoogleVisionBarcodesDetected"),
        EVENT_ON_FACE_DETECTION_ERROR("onFaceDetectionError"),
        EVENT_ON_BARCODE_DETECTION_ERROR("onGoogleVisionBarcodeDetectionError"),
        EVENT_ON_TEXT_RECOGNIZED("onTextRecognized"),
        EVENT_ON_PICTURE_TAKEN("onPictureTaken"),
        EVENT_ON_PICTURE_SAVED("onPictureSaved");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    public void onDropViewInstance(jlt jlt) {
        jlt.onHostDestroy();
        super.onDropViewInstance((View) jlt);
    }

    /* access modifiers changed from: protected */
    public jlt createViewInstance(ThemedReactContext themedReactContext) {
        return new jlt(themedReactContext);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        for (Events events : Events.values()) {
            builder.put(events.toString(), MapBuilder.of("registrationName", events.toString()));
        }
        return builder.build();
    }

    @ReactProp(name = "type")
    public void setType(jlt jlt, int i) {
        jlt.setFacing(i);
    }

    @ReactProp(name = "cameraId")
    public void setCameraId(jlt jlt, String str) {
        jlt.setCameraId(str);
    }

    @ReactProp(name = "ratio")
    public void setRatio(jlt jlt, String str) {
        jlt.setAspectRatio(AspectRatio.parse(str));
    }

    @ReactProp(name = "flashMode")
    public void setFlashMode(jlt jlt, int i) {
        jlt.setFlash(i);
    }

    @ReactProp(name = "exposure")
    public void setExposureCompensation(jlt jlt, float f) {
        jlt.setExposureCompensation(f);
    }

    @ReactProp(name = "autoFocus")
    public void setAutoFocus(jlt jlt, boolean z) {
        jlt.setAutoFocus(z);
    }

    @ReactProp(name = "focusDepth")
    public void setFocusDepth(jlt jlt, float f) {
        jlt.setFocusDepth(f);
    }

    @ReactProp(name = "autoFocusPointOfInterest")
    public void setAutoFocusPointOfInterest(jlt jlt, ReadableMap readableMap) {
        if (readableMap != null) {
            jlt.setAutoFocusPointOfInterest((float) readableMap.getDouble("x"), (float) readableMap.getDouble("y"));
        }
    }

    @ReactProp(name = "zoom")
    public void setZoom(jlt jlt, float f) {
        jlt.setZoom(f);
    }

    @ReactProp(name = "whiteBalance")
    public void setWhiteBalance(jlt jlt, int i) {
        jlt.setWhiteBalance(i);
    }

    @ReactProp(name = "pictureSize")
    public void setPictureSize(jlt jlt, String str) {
        jlt.setPictureSize(str.equals("None") ? null : Size.parse(str));
    }

    @ReactProp(name = "barCodeTypes")
    public void setBarCodeTypes(jlt jlt, ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList arrayList = new ArrayList(readableArray.size());
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(readableArray.getString(i));
            }
            jlt.setBarCodeTypes(arrayList);
        }
    }

    @ReactProp(name = "barCodeScannerEnabled")
    public void setBarCodeScanning(jlt jlt, boolean z) {
        jlt.setShouldScanBarCodes(z);
    }

    @ReactProp(name = "useCamera2Api")
    public void setUseCamera2Api(jlt jlt, boolean z) {
        jlt.setUsingCamera2Api(z);
    }

    @ReactProp(name = "playSoundOnCapture")
    public void setPlaySoundOnCapture(jlt jlt, boolean z) {
        jlt.setPlaySoundOnCapture(Boolean.valueOf(z));
    }

    @ReactProp(name = "faceDetectorEnabled")
    public void setFaceDetecting(jlt jlt, boolean z) {
        jlt.setShouldDetectFaces(z);
    }

    @ReactProp(name = "faceDetectionMode")
    public void setFaceDetectionMode(jlt jlt, int i) {
        jlt.setFaceDetectionMode(i);
    }

    @ReactProp(name = "faceDetectionLandmarks")
    public void setFaceDetectionLandmarks(jlt jlt, int i) {
        jlt.setFaceDetectionLandmarks(i);
    }

    @ReactProp(name = "faceDetectionClassifications")
    public void setFaceDetectionClassifications(jlt jlt, int i) {
        jlt.setFaceDetectionClassifications(i);
    }

    @ReactProp(name = "trackingEnabled")
    public void setTracking(jlt jlt, boolean z) {
        jlt.setTracking(z);
    }

    @ReactProp(name = "googleVisionBarcodeDetectorEnabled")
    public void setGoogleVisionBarcodeDetecting(jlt jlt, boolean z) {
        jlt.setShouldGoogleDetectBarcodes(z);
    }

    @ReactProp(name = "googleVisionBarcodeType")
    public void setGoogleVisionBarcodeType(jlt jlt, int i) {
        jlt.setGoogleVisionBarcodeType(i);
    }

    @ReactProp(name = "googleVisionBarcodeMode")
    public void setGoogleVisionBarcodeMode(jlt jlt, int i) {
        jlt.setGoogleVisionBarcodeMode(i);
    }

    @ReactProp(name = "textRecognizerEnabled")
    public void setTextRecognizing(jlt jlt, boolean z) {
        jlt.setShouldRecognizeText(z);
    }
}
