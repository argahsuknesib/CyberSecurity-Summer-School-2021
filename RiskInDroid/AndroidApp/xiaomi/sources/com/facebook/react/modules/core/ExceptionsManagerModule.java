package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.ExceptionDataHelper;
import com.facebook.react.util.JSStackTrace;

@ReactModule(name = "ExceptionsManager")
public class ExceptionsManagerModule extends BaseJavaModule {
    private final DevSupportManager mDevSupportManager;

    public String getName() {
        return "ExceptionsManager";
    }

    public ExceptionsManagerModule(DevSupportManager devSupportManager) {
        this.mDevSupportManager = devSupportManager;
    }

    @ReactMethod
    public void reportFatalException(String str, ReadableArray readableArray, int i) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", i);
        javaOnlyMap.putBoolean("isFatal", true);
        reportException(javaOnlyMap);
    }

    @ReactMethod
    public void reportSoftException(String str, ReadableArray readableArray, int i) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString("message", str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt("id", i);
        javaOnlyMap.putBoolean("isFatal", false);
        reportException(javaOnlyMap);
    }

    @ReactMethod
    public void reportException(ReadableMap readableMap) {
        String string = readableMap.hasKey("message") ? readableMap.getString("message") : "";
        ReadableArray array = readableMap.hasKey("stack") ? readableMap.getArray("stack") : Arguments.createArray();
        int i = readableMap.hasKey("id") ? readableMap.getInt("id") : -1;
        boolean z = readableMap.hasKey("isFatal") ? readableMap.getBoolean("isFatal") : false;
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.showNewJSError(string, array, i);
            return;
        }
        String extraDataAsJson = ExceptionDataHelper.getExtraDataAsJson(readableMap);
        if (!z) {
            FLog.e("ReactNative", JSStackTrace.format(string, array));
            if (extraDataAsJson != null) {
                FLog.d("ReactNative", "extraData: %s", extraDataAsJson);
                return;
            }
            return;
        }
        throw new JavascriptException(JSStackTrace.format(string, array)).setExtraDataAsJson(extraDataAsJson);
    }

    @ReactMethod
    public void updateExceptionMessage(String str, ReadableArray readableArray, int i) {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.updateJSError(str, readableArray, i);
        }
    }

    @ReactMethod
    public void dismissRedbox() {
        if (this.mDevSupportManager.getDevSupportEnabled()) {
            this.mDevSupportManager.hideRedboxDialog();
        }
    }
}
