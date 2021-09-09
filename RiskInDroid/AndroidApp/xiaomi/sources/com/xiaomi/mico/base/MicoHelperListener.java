package com.xiaomi.mico.base;

import com.tencent.mm.opensdk.openapi.IWXAPI;

public interface MicoHelperListener {
    IWXAPI getIWXAPI();

    void jumpSmartHome(String str, String str2);

    void login();

    void onTokenExpired(String str);
}
