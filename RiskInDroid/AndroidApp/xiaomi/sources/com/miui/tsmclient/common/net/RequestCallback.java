package com.miui.tsmclient.common.net;

public interface RequestCallback<T> {
    void onFailed(ErrorInfo errorInfo);

    void onResponse(Object obj);
}
