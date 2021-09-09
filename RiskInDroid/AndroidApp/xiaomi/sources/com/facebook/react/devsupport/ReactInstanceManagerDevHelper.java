package com.facebook.react.devsupport;

import android.app.Activity;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeDeltaClient;

public interface ReactInstanceManagerDevHelper {
    Activity getCurrentActivity();

    JavaScriptExecutorFactory getJavaScriptExecutorFactory();

    void onJSBundleLoadedFromServer(NativeDeltaClient nativeDeltaClient);

    void onReloadWithJSDebugger(JavaJSExecutor.Factory factory);

    void toggleElementInspector();
}
