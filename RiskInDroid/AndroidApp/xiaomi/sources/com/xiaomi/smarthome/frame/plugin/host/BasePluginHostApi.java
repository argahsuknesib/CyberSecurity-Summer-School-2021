package com.xiaomi.smarthome.frame.plugin.host;

import android.content.Context;
import android.os.Bundle;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;

public abstract class BasePluginHostApi extends XmPluginHostApi {
    public abstract void bleSpecOperation(String str, int i, String str2, Callback<Bundle> callback);

    public abstract void disConnectCamera();

    public abstract void disableCameraAutoDisconnect(DeviceStat deviceStat);

    public abstract void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2, Callback<Bundle> callback);

    public abstract void enableCameraAutoDisconnect(DeviceStat deviceStat);

    public abstract void login(Context context, int i);

    public abstract void preConnectCamera();

    public abstract boolean shouldStartInCameraProcess(String str);
}
