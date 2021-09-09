package org.reactnative.camera;

import _m_j.jlr;
import _m_j.jlt;
import android.content.pm.PackageInfo;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;
import com.xiaomi.zxing.BarcodeFormat;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.reactnative.camera.utils.ScopedContext;
import org.reactnative.facedetector.RNFaceDetector;

public class CameraModule extends ReactContextBaseJavaModule {
    public static final Map<String, Object> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new HashMap<String, Object>() {
        /* class org.reactnative.camera.CameraModule.AnonymousClass1 */

        {
            put("aztec", BarcodeFormat.AZTEC.toString());
            put("ean13", BarcodeFormat.EAN_13.toString());
            put("ean8", BarcodeFormat.EAN_8.toString());
            put("qr", BarcodeFormat.QR_CODE.toString());
            put("pdf417", BarcodeFormat.PDF_417.toString());
            put("upc_e", BarcodeFormat.UPC_E.toString());
            put("datamatrix", BarcodeFormat.DATA_MATRIX.toString());
            put("code39", BarcodeFormat.CODE_39.toString());
            put("code93", BarcodeFormat.CODE_93.toString());
            put("interleaved2of5", BarcodeFormat.ITF.toString());
            put("codabar", BarcodeFormat.CODABAR.toString());
            put("code128", BarcodeFormat.CODE_128.toString());
            put("maxicode", BarcodeFormat.MAXICODE.toString());
            put("rss14", BarcodeFormat.RSS_14.toString());
            put("rssexpanded", BarcodeFormat.RSS_EXPANDED.toString());
            put("upc_a", BarcodeFormat.UPC_A.toString());
            put("upc_ean", BarcodeFormat.UPC_EAN_EXTENSION.toString());
        }
    });
    private ScopedContext mScopedContext;

    public String getName() {
        return "RNCameraModule";
    }

    public CameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mScopedContext = new ScopedContext(reactApplicationContext);
    }

    public ScopedContext getScopedContext() {
        return this.mScopedContext;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass2 */

            {
                put("Type", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass4 */

                    {
                        put("front", 1);
                        put("back", 0);
                    }
                }));
                put("FlashMode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass5 */

                    {
                        put("off", 0);
                        put("on", 1);
                        put("auto", 3);
                        put("torch", 2);
                    }
                }));
                put("AutoFocus", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass6 */

                    {
                        put("on", Boolean.TRUE);
                        put("off", Boolean.FALSE);
                    }
                }));
                put("WhiteBalance", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass7 */

                    {
                        put("auto", 0);
                        put("cloudy", 1);
                        put("sunny", 2);
                        put("shadow", 3);
                        put("fluorescent", 4);
                        put("incandescent", 5);
                    }
                }));
                put("VideoQuality", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass8 */

                    {
                        put("2160p", 0);
                        put("1080p", 1);
                        put("720p", 2);
                        put("480p", 3);
                        put("4:3", 4);
                    }
                }));
                put("BarCodeType", CameraModule.VALID_BARCODE_TYPES);
                put("FaceDetection", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1 */

                    {
                        put("Mode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                            {
                                put("fast", Integer.valueOf(RNFaceDetector.O00000oo));
                                put("accurate", Integer.valueOf(RNFaceDetector.O00000oO));
                            }
                        }));
                        put("Landmarks", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1.AnonymousClass3 */

                            {
                                put("all", Integer.valueOf(RNFaceDetector.O00000o0));
                                put("none", Integer.valueOf(RNFaceDetector.O00000o));
                            }
                        }));
                        put("Classifications", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1.AnonymousClass2 */

                            {
                                put("all", Integer.valueOf(RNFaceDetector.f15479O000000o));
                                put("none", Integer.valueOf(RNFaceDetector.O00000Oo));
                            }
                        }));
                    }
                }));
                put("GoogleVisionBarcodeDetection", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass2 */

                    {
                        put("BarcodeType", jlr.O00000Oo);
                        put("BarcodeMode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass9 */

                            {
                                put("NORMAL", 0);
                                put("ALTERNATE", 1);
                                put("INVERTED", 2);
                            }
                        }));
                    }
                }));
                put("Orientation", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class org.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass3 */

                    {
                        put("auto", 0);
                        put("portrait", 1);
                        put("portraitUpsideDown", 2);
                        put("landscapeLeft", 3);
                        put("landscapeRight", 4);
                    }
                }));
            }
        });
    }

    @ReactMethod
    public void pausePreview(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass4 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i);
                    if (jlt.isCameraOpened()) {
                        jlt.pausePreview();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void resumePreview(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass5 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i);
                    if (jlt.isCameraOpened()) {
                        jlt.resumePreview();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void takePicture(ReadableMap readableMap, int i, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final File file = this.mScopedContext.f15478O000000o;
        final int i2 = i;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass6 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i2);
                try {
                    if (jlt.isCameraOpened()) {
                        jlt.O000000o(readableMap2, promise2, file);
                    } else {
                        promise2.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    promise2.reject("E_TAKE_PICTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void record(ReadableMap readableMap, int i, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final File file = this.mScopedContext.f15478O000000o;
        final int i2 = i;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass7 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i2);
                    if (jlt.isCameraOpened()) {
                        jlt.O00000Oo(readableMap2, promise2, file);
                    } else {
                        promise2.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    promise2.reject("E_CAPTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void stopRecording(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass8 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i);
                    if (jlt.isCameraOpened()) {
                        jlt.stopRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void getSupportedRatios(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass9 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i);
                    WritableArray createArray = Arguments.createArray();
                    if (jlt.isCameraOpened()) {
                        for (AspectRatio aspectRatio : jlt.getSupportedAspectRatios()) {
                            createArray.pushString(aspectRatio.toString());
                        }
                        promise.resolve(createArray);
                        return;
                    }
                    promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @ReactMethod
    public void getCameraIds(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass10 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    WritableArray createArray = Arguments.createArray();
                    for (Properties next : ((jlt) nativeViewHierarchyManager.resolveView(i)).getCameraIds()) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("id", next.getProperty("id"));
                        writableNativeMap.putInt("type", Integer.valueOf(next.getProperty("type")).intValue());
                        createArray.pushMap(writableNativeMap);
                    }
                    promise.resolve(createArray);
                } catch (Exception e) {
                    e.printStackTrace();
                    promise.reject("E_CAMERA_FAILED", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void getAvailablePictureSizes(final String str, final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class org.reactnative.camera.CameraModule.AnonymousClass3 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    jlt jlt = (jlt) nativeViewHierarchyManager.resolveView(i);
                    WritableArray createArray = Arguments.createArray();
                    if (jlt.isCameraOpened()) {
                        for (Size size : jlt.getAvailablePictureSizes(AspectRatio.parse(str))) {
                            createArray.pushString(size.toString());
                        }
                        promise.resolve(createArray);
                        return;
                    }
                    promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                } catch (Exception unused) {
                    promise.reject("E_CAMERA_BAD_VIEWTAG", "getAvailablePictureSizesAsync: Expected a Camera component");
                }
            }
        });
    }

    @ReactMethod
    public void checkIfRecordAudioPermissionsAreDefined(Promise promise) {
        try {
            PackageInfo packageInfo = getCurrentActivity().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 4096);
            if (packageInfo.requestedPermissions != null) {
                for (String equals : packageInfo.requestedPermissions) {
                    if (equals.equals("android.permission.RECORD_AUDIO")) {
                        promise.resolve(Boolean.TRUE);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promise.resolve(Boolean.FALSE);
    }
}
