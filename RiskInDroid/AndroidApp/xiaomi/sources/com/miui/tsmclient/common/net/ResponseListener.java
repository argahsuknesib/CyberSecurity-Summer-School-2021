package com.miui.tsmclient.common.net;

public interface ResponseListener<T> {
    void onFailed(int i, String str, Object obj);

    void onSuccess(Object obj);
}
