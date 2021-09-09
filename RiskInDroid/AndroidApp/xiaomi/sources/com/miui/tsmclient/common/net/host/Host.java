package com.miui.tsmclient.common.net.host;

import java.io.File;

public abstract class Host {
    private static int sStagingIndex = -1;

    public abstract String getAuthType();

    public abstract String getOnlineHost();

    public abstract String getServiceId();

    public abstract String getStagingHost();

    protected static int getStagingIndex() {
        if (sStagingIndex == -1) {
            if (new File("/data/system/tsmconfig/tsm_auth_server_staging").exists()) {
                sStagingIndex = 0;
            } else if (new File("/data/system/tsmconfig/tsm_auth_server_staging1").exists()) {
                sStagingIndex = 1;
            } else if (new File("/data/system/tsmconfig/tsm_auth_server_staging2").exists()) {
                sStagingIndex = 2;
            } else if (new File("/data/system/tsmconfig/tsm_auth_server_staging3").exists()) {
                sStagingIndex = 3;
            } else if (new File("/data/system/tsmconfig/preview_tsm_auth_server_staging").exists()) {
                sStagingIndex = 4;
            }
        }
        return sStagingIndex;
    }

    public static void setStagingIndex(int i) {
        sStagingIndex = i;
    }
}
