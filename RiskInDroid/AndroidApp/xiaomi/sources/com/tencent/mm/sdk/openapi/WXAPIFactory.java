package com.tencent.mm.sdk.openapi;

import android.content.Context;
import com.tencent.mm.sdk.b.b;

public class WXAPIFactory {
    private WXAPIFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, false);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        b.e("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + str + ", checkSignature = " + z);
        return new WXApiImplV10(context, str, z);
    }
}
