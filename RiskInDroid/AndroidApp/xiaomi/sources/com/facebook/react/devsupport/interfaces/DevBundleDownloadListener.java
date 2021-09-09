package com.facebook.react.devsupport.interfaces;

import com.facebook.react.bridge.NativeDeltaClient;

public interface DevBundleDownloadListener {
    void onFailure(Exception exc);

    void onProgress(String str, Integer num, Integer num2);

    void onSuccess(NativeDeltaClient nativeDeltaClient);
}
