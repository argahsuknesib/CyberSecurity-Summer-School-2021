package com.facebook.react.jscexecutor;

import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.WritableNativeMap;

public class JSCExecutorFactory implements JavaScriptExecutorFactory {
    private final String mAppName;
    private final String mDeviceName;

    public String toString() {
        return "JSIExecutor+JSCRuntime";
    }

    public JSCExecutorFactory(String str, String str2) {
        this.mAppName = str;
        this.mDeviceName = str2;
    }

    public JavaScriptExecutor create() throws Exception {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("OwnerIdentity", "ReactNative");
        writableNativeMap.putString("AppIdentity", this.mAppName);
        writableNativeMap.putString("DeviceIdentity", this.mDeviceName);
        return new JSCExecutor(writableNativeMap);
    }

    public void startSamplingProfiler() {
        throw new UnsupportedOperationException("Starting sampling profiler not supported on " + toString());
    }

    public void stopSamplingProfiler(String str) {
        throw new UnsupportedOperationException("Stopping sampling profiler not supported on " + toString());
    }
}
