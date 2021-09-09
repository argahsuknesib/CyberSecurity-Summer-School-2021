package com.xiaomi.smarthome.plugin.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class PluginBaseService extends Service implements IPluginService {
    Service mPluginHostService;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public Service getHostService() {
        return this.mPluginHostService;
    }

    public void attach(Context context, Service service) {
        attachBaseContext(context);
        this.mPluginHostService = service;
    }

    public void stopSelfForPlugin() {
        Service service = this.mPluginHostService;
        if (service != null) {
            service.stopSelf();
        }
    }

    public void stopSelfForPlugin(int i) {
        Service service = this.mPluginHostService;
        if (service != null) {
            service.stopSelf(i);
        }
    }

    public boolean stopSelfResultForPlugin(int i) {
        Service service = this.mPluginHostService;
        if (service != null) {
            return service.stopSelfResult(i);
        }
        return false;
    }

    public void startForegroundForPlugin(int i, Notification notification) {
        Service service = this.mPluginHostService;
        if (service != null) {
            service.startForeground(i, notification);
        }
    }

    public void stopForegroundForPlugin(boolean z) {
        Service service = this.mPluginHostService;
        if (service != null) {
            service.stopForeground(z);
        }
    }
}
