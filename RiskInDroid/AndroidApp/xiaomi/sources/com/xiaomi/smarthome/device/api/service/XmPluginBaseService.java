package com.xiaomi.smarthome.device.api.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaomi.plugin.core.XmPluginPackage;

@Deprecated
public class XmPluginBaseService extends Service {
    IXmPluginHostService mHostService;
    XmPluginPackage mPluginPackage;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void attach(IXmPluginHostService iXmPluginHostService, XmPluginPackage xmPluginPackage) {
        this.mHostService = iXmPluginHostService;
        this.mPluginPackage = xmPluginPackage;
    }
}
