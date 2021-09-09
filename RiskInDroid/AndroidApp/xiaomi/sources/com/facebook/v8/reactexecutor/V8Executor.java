package com.facebook.v8.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;

public class V8Executor extends JavaScriptExecutor {
    private static native HybridData initHybrid(String str);

    public String getName() {
        return "V8Executor";
    }

    static {
        SoLoader.loadLibrary("v8executor");
    }

    V8Executor(String str) {
        super(initHybrid(str));
    }
}
