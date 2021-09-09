package com.miui.tsmclient.common.net;

public interface IHttpLifecycleListener {
    void onStart(String str);

    void onStop(String str, int i);
}
