package com.miui.tsmclient.common.net.host;

public class AuthHost extends BaseHost {
    private static String SERVER_ONLINE = "https://preview.tsmapi.pay.xiaomi.com/";
    private static String SERVER_STAGING = "http://staging.tsmapi.pay.xiaomi.com/";
    private static String SERVICE_ID = "tsm-auth";

    static {
        int stagingIndex = getStagingIndex();
        if (stagingIndex == 1) {
            SERVER_STAGING = "http://staging1.tsmapi.pay.xiaomi.com/";
        } else if (stagingIndex == 2) {
            SERVER_STAGING = "http://staging2.tsmapi.pay.xiaomi.com/";
        } else if (stagingIndex == 3) {
            SERVER_STAGING = "http://staging3.tsmapi.pay.xiaomi.com/";
        } else if (stagingIndex != 4) {
            SERVER_STAGING = "http://staging.tsmapi.pay.xiaomi.com/";
        }
    }

    public String getStagingHost() {
        return SERVER_STAGING;
    }

    public String getOnlineHost() {
        return SERVER_ONLINE;
    }

    public String getServiceId() {
        return SERVICE_ID;
    }
}
