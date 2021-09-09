package com.mibi.sdk.channel.wxpay;

import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WxResultHelper {
    private static IWxResultInterceptor sInterceptor;
    private static String sWxAppId;

    private WxResultHelper() {
    }

    public static void setInterceptor(IWxResultInterceptor iWxResultInterceptor) {
        sInterceptor = iWxResultInterceptor;
    }

    static boolean intercept(BaseResp baseResp) {
        IWxResultInterceptor iWxResultInterceptor = sInterceptor;
        if (iWxResultInterceptor != null) {
            return iWxResultInterceptor.intercept(baseResp);
        }
        return false;
    }

    public static void removeInterceptor() {
        sInterceptor = null;
    }

    public static IWxResultInterceptor getInterceptor() {
        return sInterceptor;
    }

    public static void setWxAppId(String str) {
        sWxAppId = str;
    }

    static String getWxAppId() {
        return sWxAppId;
    }
}
