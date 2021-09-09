package com.reactnative.camera;

import _m_j.ctd;
import _m_j.cte;
import _m_j.ctr;
import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.cameraview.AspectRatio;
import com.google.zxing.BarcodeFormat;
import com.reactnative.camera.facedetector.RNFaceDetector;
import com.reactnative.camera.utils.ScopedContext;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CameraModule extends ReactContextBaseJavaModule {
    public static final Map<String, Object> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new HashMap<String, Object>() {
        /* class com.reactnative.camera.CameraModule.AnonymousClass1 */

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
            /* class com.reactnative.camera.CameraModule.AnonymousClass2 */

            {
                put("Type", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass2 */

                    {
                        put("front", 1);
                        put("back", 0);
                    }
                }));
                put("FlashMode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass3 */

                    {
                        put("off", 0);
                        put("on", 1);
                        put("auto", 3);
                        put("torch", 2);
                    }
                }));
                put("AutoFocus", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass4 */

                    {
                        put("on", Boolean.TRUE);
                        put("off", Boolean.FALSE);
                    }
                }));
                put("WhiteBalance", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass5 */

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
                    /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass6 */

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
                    /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1 */

                    {
                        put("Mode", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                            {
                                put("fast", Integer.valueOf(RNFaceDetector.O00000oo));
                                put("accurate", Integer.valueOf(RNFaceDetector.O00000oO));
                            }
                        }));
                        put("Landmarks", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1.AnonymousClass3 */

                            {
                                put("all", Integer.valueOf(RNFaceDetector.O00000o0));
                                put("none", Integer.valueOf(RNFaceDetector.O00000o));
                            }
                        }));
                        put("Classifications", Collections.unmodifiableMap(new HashMap<String, Object>() {
                            /* class com.reactnative.camera.CameraModule.AnonymousClass2.AnonymousClass1.AnonymousClass2 */

                            {
                                put("all", Integer.valueOf(RNFaceDetector.f5478O000000o));
                                put("none", Integer.valueOf(RNFaceDetector.O00000Oo));
                            }
                        }));
                    }
                }));
            }
        });
    }

    @ReactMethod
    public void takePicture(ReadableMap readableMap, int i, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final File file = this.mScopedContext.f5479O000000o;
        final int i2 = i;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.reactnative.camera.CameraModule.AnonymousClass3 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                ctd ctd = (ctd) nativeViewHierarchyManager.resolveView(i2);
                try {
                    if (Build.FINGERPRINT.contains("generic")) {
                        Bitmap O00000Oo2 = cte.O00000Oo(ctd.getWidth(), ctd.getHeight());
                        ByteBuffer allocate = ByteBuffer.allocate(O00000Oo2.getRowBytes() * O00000Oo2.getHeight());
                        O00000Oo2.copyPixelsToBuffer(allocate);
                        new ctr(allocate.array(), promise2, readableMap2).execute(new Void[0]);
                    } else if (ctd.isCameraOpened()) {
                        ctd.O000000o(readableMap2, promise2, file);
                    } else {
                        promise2.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception unused) {
                    promise2.reject("E_CAMERA_BAD_VIEWTAG", "takePictureAsync: Expected a Camera component");
                }
            }
        });
    }

    @ReactMethod
    public void record(ReadableMap readableMap, int i, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final File file = this.mScopedContext.f5479O000000o;
        final int i2 = i;
        final ReadableMap readableMap2 = readableMap;
        final Promise promise2 = promise;
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.reactnative.camera.CameraModule.AnonymousClass4 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ctd ctd = (ctd) nativeViewHierarchyManager.resolveView(i2);
                    if (ctd.isCameraOpened()) {
                        ctd.O00000Oo(readableMap2, promise2, file);
                    } else {
                        promise2.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception unused) {
                    promise2.reject("E_CAMERA_BAD_VIEWTAG", "recordAsync: Expected a Camera component");
                }
            }
        });
    }

    @ReactMethod
    public void stopRecording(final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.reactnative.camera.CameraModule.AnonymousClass5 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ctd ctd = (ctd) nativeViewHierarchyManager.resolveView(i);
                    if (ctd.isCameraOpened()) {
                        ctd.stopRecording();
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
            /* class com.reactnative.camera.CameraModule.AnonymousClass6 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ctd ctd = (ctd) nativeViewHierarchyManager.resolveView(i);
                    WritableArray createArray = Arguments.createArray();
                    if (ctd.isCameraOpened()) {
                        for (AspectRatio aspectRatio : ctd.getSupportedAspectRatios()) {
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
}
