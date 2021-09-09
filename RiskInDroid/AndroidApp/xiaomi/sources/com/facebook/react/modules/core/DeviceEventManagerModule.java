package com.facebook.react.modules.core;

import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "DeviceEventManager")
public class DeviceEventManagerModule extends ReactContextBaseJavaModule {
    private final Runnable mInvokeDefaultBackPressRunnable;

    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(String str, Object obj);
    }

    public String getName() {
        return "DeviceEventManager";
    }

    public DeviceEventManagerModule(ReactApplicationContext reactApplicationContext, final DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        super(reactApplicationContext);
        this.mInvokeDefaultBackPressRunnable = new Runnable() {
            /* class com.facebook.react.modules.core.DeviceEventManagerModule.AnonymousClass1 */

            public void run() {
                UiThreadUtil.assertOnUiThread();
                defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
            }
        };
    }

    public void emitHardwareBackPressed() {
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("hardwareBackPress", null);
    }

    public void emitNewIntentReceived(Uri uri) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("url", uri.toString());
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("url", createMap);
    }

    @ReactMethod
    public void invokeDefaultBackPressHandler() {
        getReactApplicationContext().runOnUiQueueThread(this.mInvokeDefaultBackPressRunnable);
    }
}
