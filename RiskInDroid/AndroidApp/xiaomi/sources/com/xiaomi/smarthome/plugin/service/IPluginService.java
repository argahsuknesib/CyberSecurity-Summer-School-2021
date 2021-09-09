package com.xiaomi.smarthome.plugin.service;

import android.app.Notification;
import android.app.Service;

public interface IPluginService {
    Service getHostService();

    void startForegroundForPlugin(int i, Notification notification);

    void stopForegroundForPlugin(boolean z);

    void stopSelfForPlugin();

    void stopSelfForPlugin(int i);

    boolean stopSelfResultForPlugin(int i);
}
