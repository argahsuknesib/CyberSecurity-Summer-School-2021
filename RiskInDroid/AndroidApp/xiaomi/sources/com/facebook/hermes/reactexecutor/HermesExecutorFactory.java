package com.facebook.hermes.reactexecutor;

import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;

public class HermesExecutorFactory implements JavaScriptExecutorFactory {
    private final RuntimeConfig mConfig;

    public void startSamplingProfiler() {
    }

    public void stopSamplingProfiler(String str) {
    }

    public String toString() {
        return "JSIExecutor+HermesRuntime";
    }

    public HermesExecutorFactory() {
        this(null);
    }

    public HermesExecutorFactory(RuntimeConfig runtimeConfig) {
        this.mConfig = runtimeConfig;
    }

    public JavaScriptExecutor create() {
        return new HermesExecutor(this.mConfig);
    }
}
