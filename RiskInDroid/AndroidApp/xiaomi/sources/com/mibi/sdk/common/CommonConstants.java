package com.mibi.sdk.common;

import java.io.File;

public class CommonConstants {
    public static final boolean ACCOUNT_PREVIEW = new File("/data/system/xiaomi_account_preview").exists();
    public static final boolean DEBUG = new File("/data/system/payment_debug").exists();
    public static final boolean SANDBOX = new File("/data/system/server_sandbox").exists();
    public static String SERVICE_ID = SERVICE_ID_DEFAULT;
    public static String SERVICE_ID_DEFAULT;
    public static final boolean STAGING = new File("/data/system/server_staging").exists();
    public static String TOKEN_TYPE = "AUTH_TOKEN";
    public static String URL_ACCOUNT_BASE;
    public static String URL_BASE = URL_BASE_DEFAULT;
    public static String URL_BASE_DEFAULT;
    public static String URL_WEB_BASE;

    public interface Mgc {
    }

    static {
        if (MiuiBuild.isInternationalBuild()) {
            if (SANDBOX) {
                URL_BASE_DEFAULT = "http://sandbox.hk.billapi.xiaomi.com";
                SERVICE_ID_DEFAULT = "hk_billcenter";
                URL_WEB_BASE = "http://sandbox.m.mibi.mi.com";
            } else if (STAGING) {
                URL_BASE_DEFAULT = "http://staging.hk.billapi.xiaomi.com";
                SERVICE_ID_DEFAULT = "shk_billcenter";
                URL_WEB_BASE = "http://m.staging.hk.mibi.xiaomi.com";
            } else {
                URL_BASE_DEFAULT = "https://hk.billapi.xiaomi.com";
                SERVICE_ID_DEFAULT = "hk_billcenter";
                URL_WEB_BASE = "https://m.hk.mibi.mi.com";
            }
        } else if (SANDBOX) {
            URL_BASE_DEFAULT = "http://sandbox.billapi.xiaomi.com";
            SERVICE_ID_DEFAULT = "billcenter";
            URL_WEB_BASE = "http://sandbox.m.mibi.mi.com";
        } else if (STAGING) {
            URL_BASE_DEFAULT = "http://staging.billapi.n.xiaomi.com";
            SERVICE_ID_DEFAULT = "sbillcenter_tmp";
            URL_WEB_BASE = "http://m.staging.mibi.n.xiaomi.com";
        } else {
            URL_BASE_DEFAULT = "https://billapi.xiaomi.com";
            SERVICE_ID_DEFAULT = "billcenter";
            URL_WEB_BASE = "https://m.mibi.mi.com";
        }
        if (ACCOUNT_PREVIEW) {
            URL_ACCOUNT_BASE = "http://account.preview.n.xiaomi.net/pass";
        } else {
            URL_ACCOUNT_BASE = "https://account.xiaomi.com/pass";
        }
    }

    public static void setServer(String str, String str2) {
        SERVICE_ID = str2;
        URL_BASE = str;
    }

    public static String getUrl(String str) {
        return Utils.joinUrl(URL_BASE, str);
    }

    public static String getWebUrl(String str) {
        return Utils.joinUrl(URL_WEB_BASE, str);
    }

    public static String getAccountBaseUrl(String str) {
        return Utils.joinUrl(URL_ACCOUNT_BASE, str);
    }
}
