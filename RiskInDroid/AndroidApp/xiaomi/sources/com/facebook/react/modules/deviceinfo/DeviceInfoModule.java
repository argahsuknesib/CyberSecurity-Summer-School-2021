package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "DeviceInfo")
public class DeviceInfoModule extends BaseJavaModule implements LifecycleEventListener, TurboModule {
    private float mFontScale;
    private ReactApplicationContext mReactApplicationContext;

    public String getName() {
        return "DeviceInfo";
    }

    public void invalidate() {
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        this((Context) reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    public DeviceInfoModule(Context context) {
        this.mReactApplicationContext = null;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.mFontScale = context.getResources().getConfiguration().fontScale;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("Dimensions", DisplayMetricsHolder.getDisplayMetricsMap((double) this.mFontScale));
        return hashMap;
    }

    public void onHostResume() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext != null) {
            float f = reactApplicationContext.getResources().getConfiguration().fontScale;
            if (this.mFontScale != f) {
                this.mFontScale = f;
                emitUpdateDimensionsEvent();
            }
        }
    }

    public void emitUpdateDimensionsEvent() {
        ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
        if (reactApplicationContext != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", DisplayMetricsHolder.getDisplayMetricsNativeMap((double) this.mFontScale));
        }
    }
}
