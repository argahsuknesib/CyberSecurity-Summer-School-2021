package com.miui.tsmclient.common.net.host;

import com.miui.tsmclient.util.EnvironmentConfig;

public class ActivityHost extends BaseHost {
    private static String ACTIVITY_SERVICE_STAGING = "http://staging.tsmactivity.pay.xiaomi.com/";
    private static String SERVICE_ID = "tsm-activity-api";

    public String getOnlineHost() {
        return "https://tsmactivity.pay.xiaomi.com/";
    }

    static {
        if (EnvironmentConfig.isStaging()) {
            int stagingIndex = getStagingIndex();
            if (stagingIndex == 1) {
                ACTIVITY_SERVICE_STAGING = "http://staging1.tsmactivity.pay.xiaomi.com/";
                SERVICE_ID = "tsm-activity-api-1";
            } else if (stagingIndex == 2) {
                ACTIVITY_SERVICE_STAGING = "http://staging2.tsmactivity.pay.xiaomi.com/";
                SERVICE_ID = "tsm-activity-api-2";
            } else if (stagingIndex != 3) {
                ACTIVITY_SERVICE_STAGING = "http://staging.tsmactivity.pay.xiaomi.com/";
                SERVICE_ID = "tsm-activity-api";
            } else {
                ACTIVITY_SERVICE_STAGING = "http://staging3.tsmactivity.pay.xiaomi.com/";
                SERVICE_ID = "tsm-activity-api-3";
            }
        }
    }

    public String getStagingHost() {
        return ACTIVITY_SERVICE_STAGING;
    }

    public String getServiceId() {
        return SERVICE_ID;
    }
}
