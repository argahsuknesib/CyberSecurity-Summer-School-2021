package com.xiaomi.accountsdk.request.intercept;

public interface NetworkInterceptCallback {
    void onBegin(String str, String str2, String str3);

    void onException(String str, String str2, String str3, long j, Exception exc, Integer num);

    void onSuccess(String str, String str2, String str3, long j, int i, int i2);
}
