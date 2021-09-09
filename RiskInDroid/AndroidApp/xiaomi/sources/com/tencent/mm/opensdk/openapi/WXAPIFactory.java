package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory {
    private WXAPIFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, false);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        Log.d("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + str + ", checkSignature = " + z);
        return new WXApiImplV10(context, str, z);
    }
}
