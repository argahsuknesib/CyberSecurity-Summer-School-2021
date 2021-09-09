package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3;

import _m_j.gdc;
import _m_j.gdf;
import _m_j.gdi;
import _m_j.gdj;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;

public class CvCameraModule extends ReactContextBaseJavaModule {
    private static final String TAG = "CvCameraModule";
    public ReadableMap mVideoOptions;

    public String getName() {
        return TAG;
    }

    public CvCameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void takePicture(final ReadableMap readableMap, final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.CvCameraModule.AnonymousClass1 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                gdc gdc = (gdc) nativeViewHierarchyManager.resolveView(i);
                try {
                    gdc.O0000O0o = new gdj(readableMap, promise);
                    gdc.O00000oo = true;
                } catch (Exception unused) {
                    promise.reject("E_CAMERA_BAD_VIEWTAG", "takePicture: Expected a Camera component");
                }
            }
        });
    }

    @ReactMethod
    public void initCamera(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.CvCameraModule.AnonymousClass2 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                gdc gdc = (gdc) nativeViewHierarchyManager.resolveView(i);
                try {
                    gdc.O0000Oo0 = new gdf(gdc, promise);
                    gdc.O0000Oo0.run();
                } catch (Exception unused) {
                    promise.reject("E_CAMERA_BAD_VIEWTAG", "initCamera: Expected a Camera component");
                }
            }
        });
    }

    @ReactMethod
    public void startRecording(final ReadableMap readableMap, final int i) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.CvCameraModule.AnonymousClass3 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                gdc gdc = (gdc) nativeViewHierarchyManager.resolveView(i);
                CvCameraModule cvCameraModule = CvCameraModule.this;
                cvCameraModule.mVideoOptions = readableMap;
                gdc.O0000OoO = cvCameraModule.mVideoOptions;
                gdc.O0000Oo = true;
            }
        });
    }

    @ReactMethod
    public void stopRecording(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.rnocv3.CvCameraModule.AnonymousClass4 */

            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                gdc gdc = (gdc) nativeViewHierarchyManager.resolveView(i);
                try {
                    gdc.O0000OOo = new gdi(CvCameraModule.this.mVideoOptions, promise);
                    gdc.O0000Oo = false;
                } catch (Exception unused) {
                    promise.reject("E_CAMERA_BAD_VIEWTAG", "stopRecording: Expected a Camera component");
                }
            }
        });
    }
}
