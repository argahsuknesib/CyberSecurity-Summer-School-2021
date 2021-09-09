package com.sina.weibo.sdk;

import _m_j.dbm;
import _m_j.dbn;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.network.intercept.CommonParamInterception;
import java.util.List;

public class WbSdk {
    private static AuthInfo authInfo = null;
    private static boolean init = false;

    public static void install(Context context, AuthInfo authInfo2) {
        if (init) {
            return;
        }
        if (authInfo2 == null || TextUtils.isEmpty(authInfo2.getAppKey()) || TextUtils.isEmpty(authInfo2.getRedirectUrl())) {
            throw new RuntimeException("please set right app info (appKey,redirect");
        }
        authInfo = authInfo2;
        CommonParamInterception.setAppKey(authInfo2.getAppKey());
        dbn.O000000o().O000000o(context, authInfo2.getAppKey());
        init = true;
    }

    public static void checkInit() {
        if (!init) {
            throw new RuntimeException("weibo sdk was not initall! please use: WbSdk.install() in your app Application or your main Activity. when you want to use weibo sdk function, make sure call WbSdk.install() before this function");
        }
    }

    public static AuthInfo getAuthInfo() {
        checkInit();
        return authInfo;
    }

    public static boolean isWbInstall(Context context) {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean supportMultiImage(Context context) {
        WbAppInfo O000000o2;
        if (!isWbInstall(context) || (O000000o2 = dbm.O000000o(context).O000000o()) == null || O000000o2.getSupportVersion() < 10772) {
            return false;
        }
        return true;
    }
}
