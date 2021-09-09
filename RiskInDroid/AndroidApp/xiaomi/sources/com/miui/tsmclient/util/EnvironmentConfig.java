package com.miui.tsmclient.util;

import android.content.Context;
import android.text.TextUtils;
import com.miui.tsmclient.account.IMiOAuth;
import com.miui.tsmclient.common.net.host.Host;
import com.miui.tsmclient.database.ProviderAuthorities;
import java.io.File;
import java.lang.ref.WeakReference;

public class EnvironmentConfig {
    private static WeakReference<Context> mContextRef;
    private static String sClientId;
    private static boolean sIsLoginAuth = true;
    private static boolean sIsStaging = new File("/data/system/xiaomi_account_preview").exists();
    private static IMiOAuth sMiOAuth;
    private static NfcFeatureImpl sSupportNfcFeature;

    public static void initialize(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            sIsLoginAuth = false;
            sClientId = str;
            initialize(context);
            return;
        }
        throw new IllegalArgumentException("client id must be set!");
    }

    public static void initialize(Context context) {
        if (context != null) {
            mContextRef = new WeakReference<>(context);
            sSupportNfcFeature = new NfcFeatureImpl(context);
            ProviderAuthorities.init(context);
            return;
        }
        throw new IllegalArgumentException("context can't be null!");
    }

    public static boolean isLoginAuth() {
        return sIsLoginAuth;
    }

    public static void setStaging(boolean z) {
        sIsStaging = z;
    }

    public static void setStagingIndex(int i) {
        Host.setStagingIndex(i);
    }

    public static boolean isSupportNfc() {
        return sSupportNfcFeature.isSupportNfc();
    }

    public static boolean isSupportNfc(Context context) {
        if (sSupportNfcFeature == null) {
            sSupportNfcFeature = new NfcFeatureImpl(context);
        }
        return sSupportNfcFeature.isSupportNfc();
    }

    public static boolean isStaging() {
        return sIsStaging;
    }

    public static Context getContext() {
        WeakReference<Context> weakReference = mContextRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String getClientId() {
        return sClientId;
    }

    public static void setMiOAuth(IMiOAuth iMiOAuth) {
        sMiOAuth = iMiOAuth;
    }

    public static IMiOAuth getMiOAuth() {
        return sMiOAuth;
    }

    private EnvironmentConfig() {
    }
}
