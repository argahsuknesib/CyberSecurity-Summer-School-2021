package com.miui.tsmclient.common.net.host;

import java.io.File;

public class AssetsHost extends BaseHost {
    private static String ASSETS_SERVICE_STAGING = "http://staging1.sf.pay.xiaomi.com/";

    public String getOnlineHost() {
        return "https://sf.pay.xiaomi.com/";
    }

    public String getServiceId() {
        return "tsm-assets";
    }

    static {
        if (new File("/data/system/tsmconfig").exists()) {
            int stagingIndex = getStagingIndex();
            if (stagingIndex == 1) {
                ASSETS_SERVICE_STAGING = "http://staging1.sf.pay.xiaomi.com/";
            } else if (stagingIndex == 2) {
                ASSETS_SERVICE_STAGING = "http://staging2.sf.pay.xiaomi.com/";
            } else if (stagingIndex == 3) {
                ASSETS_SERVICE_STAGING = "http://staging3.sf.pay.xiaomi.com/";
            } else if (stagingIndex != 4) {
                ASSETS_SERVICE_STAGING = "http://staging.sf.pay.xiaomi.com";
            } else {
                ASSETS_SERVICE_STAGING = "https://preview.sf.pay.xiaomi.com/";
            }
        }
    }

    public String getStagingHost() {
        return ASSETS_SERVICE_STAGING;
    }
}
