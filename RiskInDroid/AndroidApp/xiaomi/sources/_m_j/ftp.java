package _m_j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.plugin.core.XmPluginPackage;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.frame.plugin.runtime.bridge.PluginBridgeService;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import org.json.JSONObject;

public final class ftp extends fcx {
    public final void O000000o(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, Bundle bundle) {
        hmq.O00000o0().initRNDevice(deviceStat, pluginPackageInfo, pluginDeviceInfo, bundle);
    }

    public final void O000000o() {
        hmq.O00000o0().initRNRuntime();
    }

    public final byte O00000Oo() {
        return hmq.O00000o0().getInitStatus();
    }

    public final Class O00000o0() {
        return hmq.O000000o().getLoadingRNActivityClass();
    }

    public final boolean O000000o(String str) {
        JSONObject O000000o2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (XmPluginHostApi.instance().getQrDebugModePackageName() != null) {
            return true;
        }
        fvo.O000000o();
        if (fvo.O00000oO() && (O000000o2 = fvu.O000000o(str)) != null && O000000o2.optBoolean(fvt.O00000o0)) {
            return true;
        }
        return false;
    }

    public final void O00000o() {
        hmq.O00000o0().preloadRNResource();
    }

    public final void O000000o(String str, String str2, String str3, int i, long j) {
        hmq.O00000o0().reportDownloadRes(str, str2, str3, i, j);
    }

    public final void O000000o(String str, String str2, int i) {
        hmq.O00000o0().reportInstallRes(str, str2, i);
    }

    public final void O00000Oo(String str, String str2, int i) {
        hmq.O00000o0().reportInstallDetailRes(str, str2, i);
    }

    public final void O000000o(String str, int i) {
        hmq.O00000o0().reportOpenPluginError(str, i);
    }

    public final void O000000o(String str, PluginPackageInfo pluginPackageInfo, String str2) {
        hmq.O00000o0().tracePluginOpen(str, pluginPackageInfo, str2);
    }

    public final boolean O000000o(int i, String str) {
        return hmq.O00000o0().needTracePluginOpen(i, str);
    }

    public final void O000000o(fkv<Integer, Integer> fkv) {
        hmq.O00000o0().downloadRnExtModules(fkv);
    }

    public final XmPluginPackage O000000o(PluginPackageInfo pluginPackageInfo) {
        return PluginRuntimeManager.getInstance().getXmPluginPackage(pluginPackageInfo);
    }

    public final void O000000o(boolean z, boolean z2, String str) {
        for (IClientApi onPluginChanged : fcy.O000000o().O00000o0()) {
            try {
                onPluginChanged.onPluginChanged(z, z2, null);
            } catch (Exception unused) {
            }
        }
    }

    public final PluginPackageInfo O00000Oo(String str) {
        return CoreApi.O000000o().O0000Oo(str);
    }

    public final ServerBean O00000oO() {
        return CoreApi.O000000o().O0000ooO();
    }

    public final void O000000o(DeviceStat deviceStat) {
        CameraRouterFactory.getRNCameraApi().initRNCameraFrameSender(deviceStat);
    }

    public final void O000000o(DeviceStat deviceStat, Intent intent) {
        CameraRouterFactory.getRNCameraApi().RNCameraStartRequestData(deviceStat, intent);
    }

    public final void O00000Oo(DeviceStat deviceStat) {
        CameraRouterFactory.getRNCameraApi().stopRNCameraPlay(deviceStat);
    }

    public final void O00000o0(DeviceStat deviceStat) {
        CameraRouterFactory.getRNCameraApi().stopRequestRNCameraData(deviceStat);
    }

    public final void O00000o(DeviceStat deviceStat) {
        CameraRouterFactory.getRNCameraApi().startRNCall(deviceStat);
    }

    public final void O00000oO(DeviceStat deviceStat) {
        CameraRouterFactory.getRNCameraApi().stopRNCall(deviceStat);
    }

    public final void O000000o(IBridgeCallback iBridgeCallback) {
        hmq.O00000o0().initBridgeCallback(iBridgeCallback);
    }

    public final void O00000oo() {
        hmq.O00000o0().finishRnActivity();
        gbu.O00000oo("CoreBridgeImpl-->finishRnActivity()...");
    }

    public final boolean O0000O0o() {
        return hmq.O00000o0().isRNProccess();
    }

    public final boolean O00000o0(String str) {
        return hmq.O00000o0().processReuseEnableWithModel(str);
    }

    public final boolean O0000OOo() {
        return hmq.O00000o0().multiRNRuntimeReuseEnable();
    }

    public final void O0000Oo0() {
        hmq.O00000o0().setDialogThemePlugin(false);
    }

    public final String O000000o(Context context) {
        return hsk.O000000o(context);
    }

    public final DeviceStat O00000o(String str) {
        return PluginBridgeService.getCachedDeviceStat(str);
    }

    public final XmPluginPackage O000000o(Activity activity) {
        if (activity instanceof PluginHostActivity) {
            return ((PluginHostActivity) activity).getXmPluginPackage();
        }
        return null;
    }
}
