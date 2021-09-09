package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.react_native_orientation;

import android.app.Activity;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.Map;

public class OrientationModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private String getOrientationString(int i) {
        return i == 2 ? "LANDSCAPE" : i == 1 ? "PORTRAIT" : i == 0 ? "UNKNOWN" : "null";
    }

    public String getName() {
        return "Orientation";
    }

    public void onHostDestroy() {
    }

    public OrientationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void getOrientation(Callback callback) {
        int i = getReactApplicationContext().getResources().getConfiguration().orientation;
        String orientationString = getOrientationString(i);
        if (orientationString == "null") {
            callback.invoke(Integer.valueOf(i), null);
            return;
        }
        callback.invoke(null, orientationString);
    }

    @ReactMethod
    public void lockToPortrait() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(1);
        }
    }

    @ReactMethod
    public void lockToLandscape() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(6);
        }
    }

    @ReactMethod
    public void lockToLandscapeLeft() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(0);
        }
    }

    @ReactMethod
    public void lockToLandscapeRight() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(8);
        }
    }

    @ReactMethod
    public void unlockAllOrientations() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(4);
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        String orientationString = getOrientationString(getReactApplicationContext().getResources().getConfiguration().orientation);
        if (orientationString == "null") {
            hashMap.put("initialOrientation", null);
        } else {
            hashMap.put("initialOrientation", orientationString);
        }
        return hashMap;
    }

    public void onHostResume() {
        if (getCurrentActivity() == null) {
            FLog.e("ReactNative", "no activity to register receiver");
        }
    }

    public void onHostPause() {
        if (getCurrentActivity() == null) {
        }
    }
}
