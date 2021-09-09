package com.miui.tsmclient.net;

public class TSMAuthContants {
    @Deprecated
    public static final String URL_CREATE_ORDER = "api/%s/sporder/create";

    public enum ActionType {
        ISSUE,
        RECHARGE
    }

    public enum BusinessType {
        sptc,
        sbt,
        st_daily
    }

    public enum PayModeType {
        PREPAY,
        POSTPAY
    }

    public static class SyncOperation {
        private SyncOperation() {
        }
    }
}
