package com.xiaomi.account.openauth;

import java.io.File;

public class XiaomiOAuthConstants {
    public static final String OAUTH2_API_HOST = (USE_PREVIEW ? "open.account.preview.n.xiaomi.net" : "open.account.xiaomi.com");
    public static final String OAUTH2_API_URL_BASE = (USE_PREVIEW ? "http://open.account.preview.n.xiaomi.net" : "https://open.account.xiaomi.com");
    public static final String OAUTH2_HOST;
    private static final boolean USE_PREVIEW;
    @Deprecated
    public static final int VERSION_MAJOR = 1;
    @Deprecated
    public static final int VERSION_MINOR = 82;

    static {
        boolean exists = new File("/data/system/oauth_staging_preview").exists();
        USE_PREVIEW = exists;
        OAUTH2_HOST = exists ? "http://account.preview.n.xiaomi.net" : "https://account.xiaomi.com";
    }
}
