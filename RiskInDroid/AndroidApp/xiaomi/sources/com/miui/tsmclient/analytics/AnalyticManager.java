package com.miui.tsmclient.analytics;

import android.content.Context;
import android.content.Intent;
import com.miui.tsmclient.util.DeviceUtils;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import java.util.HashMap;
import java.util.Map;

public class AnalyticManager {
    private static volatile AnalyticManager sInstance;
    private int mClientVersionCode;
    private String mClientVersionName;
    private Context mContext;

    public void recordPageEnd(String str) {
    }

    public void recordPageStart(String str) {
    }

    public void setNetworkAccessEnabled(boolean z) {
    }

    public void setStatisticsEnabled(boolean z) {
    }

    public static AnalyticManager getInstance() {
        if (sInstance == null) {
            synchronized (AnalyticManager.class) {
                if (sInstance == null) {
                    AnalyticManager analyticManager = new AnalyticManager();
                    sInstance = analyticManager;
                    analyticManager.init(EnvironmentConfig.getContext());
                }
            }
        }
        return sInstance;
    }

    private AnalyticManager() {
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
            this.mClientVersionCode = DeviceUtils.getAppVersionCode(this.mContext);
            this.mClientVersionName = DeviceUtils.getAppVersionName(this.mContext);
            return;
        }
        throw new IllegalArgumentException("context can not be null");
    }

    public void recordEvent(String str, String str2) {
        recordEvent(str, str2, null);
    }

    public void recordEvent(String str, String str2, Map<String, String> map) {
        if (!EnvironmentConfig.isStaging() && map == null) {
            new HashMap();
        }
    }

    public void bugReport(Context context, String str, long j) {
        if (!EnvironmentConfig.isStaging()) {
            LogUtils.d("RomVersion:" + DeviceUtils.getRomVersion());
            Intent intent = new Intent("com.miui.klo.COMMON_LOG");
            intent.setPackage("com.miui.klo.bugreport");
            intent.putExtra("name", str);
            intent.putExtra("logcatCmd", "*:V");
            context.sendBroadcast(intent);
        }
    }
}
