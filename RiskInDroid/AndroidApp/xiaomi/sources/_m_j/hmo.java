package _m_j;

import android.os.Bundle;
import com.facebook.react.ReactInstanceManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;

public interface hmo {
    void downloadRnExtModules(fkv<Integer, Integer> fkv);

    void finishRnActivity();

    DeviceStat getDeviceStat();

    byte getInitStatus();

    ReactInstanceManager getInstanceManager();

    void initBridgeCallback(IBridgeCallback iBridgeCallback);

    void initRNDevice(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, Bundle bundle);

    void initRNRuntime();

    boolean isConfigPlugin();

    boolean isRNProccess();

    boolean multiRNRuntimeReuseEnable();

    boolean needTracePluginOpen(int i, String str);

    void onFullScreen(boolean z);

    void preloadRNResource();

    boolean processReuseEnableWithModel(String str);

    void reportDownloadRes(String str, String str2, String str3, int i, long j);

    void reportInstallDetailRes(String str, String str2, int i);

    void reportInstallRes(String str, String str2, int i);

    void reportOpenPluginError(String str, int i);

    void setDialogThemePlugin(boolean z);

    void tracePluginOpen(String str, PluginPackageInfo pluginPackageInfo, String str2);
}
