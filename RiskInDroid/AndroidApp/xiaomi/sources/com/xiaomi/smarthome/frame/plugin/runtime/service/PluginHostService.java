package com.xiaomi.smarthome.frame.plugin.runtime.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService;
import com.xiaomi.smarthome.plugin.service.PluginBaseService;

public abstract class PluginHostService extends Service {
    private XmPluginPackage mLoadedInfo;
    private PluginBaseService mPluginService;
    private Resources mResources;

    public void onCreate() {
        super.onCreate();
        StartServiceRecord startServiceRecord = PluginBridgeService.getStartServiceRecord(getClass().getName());
        if (startServiceRecord == null || startServiceRecord.intent == null) {
            exit();
            return;
        }
        Intent intent = startServiceRecord.intent;
        long longExtra = intent.getLongExtra("plugin_extra_packageId", 0);
        String stringExtra = intent.getStringExtra("plugin_extra_class");
        if (longExtra <= 0 || TextUtils.isEmpty(stringExtra)) {
            exit();
            return;
        }
        PluginPackageInfo O00000o0 = CoreApi.O000000o().O00000o0(longExtra);
        if (O00000o0 == null) {
            exit();
            return;
        }
        this.mLoadedInfo = PluginRuntimeManager.getInstance().getXmPluginPackage(O00000o0);
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage != null) {
            this.mResources = new Resources(xmPluginPackage.getAssetManager(), getResources().getDisplayMetrics(), getResources().getConfiguration());
            intent.setExtrasClassLoader(this.mLoadedInfo.classLoader);
            try {
                this.mPluginService = (PluginBaseService) this.mLoadedInfo.classLoader.loadClass(stringExtra).getConstructor(new Class[0]).newInstance(new Object[0]);
                this.mPluginService.attach(this, this);
            } catch (Throwable unused) {
                exit();
                return;
            }
        } else {
            try {
                this.mPluginService = (PluginBaseService) xmPluginPackage.classLoader.loadClass(stringExtra).getConstructor(new Class[0]).newInstance(new Object[0]);
                this.mPluginService.attach(this, this);
            } catch (Exception unused2) {
                exit();
                return;
            }
        }
        this.mPluginService.onCreate();
    }

    public Resources getResources() {
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public AssetManager getAssets() {
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage == null || xmPluginPackage.getAssetManager() == null) {
            return super.getAssets();
        }
        return this.mLoadedInfo.getAssetManager();
    }

    public ClassLoader getClassLoader() {
        XmPluginPackage xmPluginPackage = this.mLoadedInfo;
        if (xmPluginPackage == null) {
            return super.getClassLoader();
        }
        return xmPluginPackage.classLoader;
    }

    private void exit() {
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            return pluginBaseService.onBind(intent);
        }
        return null;
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        Intent intent2 = (Intent) intent.getParcelableExtra("plugin_extra_start_intent");
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            try {
                pluginBaseService.onStart(intent2, i);
            } catch (Exception unused) {
                exit();
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Intent intent2 = intent == null ? null : (Intent) intent.getParcelableExtra("plugin_extra_start_intent");
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService == null) {
            return 0;
        }
        try {
            return pluginBaseService.onStartCommand(intent2, i, i2);
        } catch (Exception unused) {
            exit();
            return 0;
        }
    }

    public void onDestroy() {
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            try {
                pluginBaseService.onDestroy();
            } catch (Exception unused) {
                exit();
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            try {
                pluginBaseService.onConfigurationChanged(configuration);
            } catch (Exception unused) {
                exit();
            }
        }
    }

    public void onLowMemory() {
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            try {
                pluginBaseService.onLowMemory();
            } catch (Exception unused) {
                exit();
            }
        }
    }

    public void onTrimMemory(int i) {
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            try {
                pluginBaseService.onTrimMemory(i);
            } catch (Exception unused) {
                exit();
            }
        }
    }

    public void onTaskRemoved(Intent intent) {
        PluginBaseService pluginBaseService = this.mPluginService;
        if (pluginBaseService != null) {
            try {
                pluginBaseService.onTaskRemoved(intent);
            } catch (Exception unused) {
                exit();
            }
        }
    }
}
