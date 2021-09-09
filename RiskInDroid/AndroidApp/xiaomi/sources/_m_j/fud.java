package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.plugin.IBridgeCallback;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.framework.plugin.rn.LoadingBaseActivity;
import com.xiaomi.smarthome.framework.plugin.rn.PluginRNActivity;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;

@RouterService
public class fud implements hmo {
    private static final fud INSTANCE = new fud();

    @cug
    public static fud provideInstance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwy.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.os.Bundle, boolean):void
     arg types: [com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.os.Bundle, int]
     candidates:
      _m_j.fwy.O000000o(long, long, java.lang.String, int, int):void
      _m_j.fwy.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, int, boolean):void
      _m_j.fwy.O000000o(com.xiaomi.smarthome.device.api.DeviceStat, com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo, com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo, android.os.Bundle, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0276  */
    public void initRNDevice(DeviceStat deviceStat, PluginPackageInfo pluginPackageInfo, PluginDeviceInfo pluginDeviceInfo, Bundle bundle) {
        int i;
        int i2;
        fwy fwy;
        int i3;
        fwy fwy2;
        DeviceStat deviceStat2 = deviceStat;
        fwz O000000o2 = fwz.O000000o();
        gbu.O00000oo("RNRuntimeManager initRNDevice()");
        boolean O000000o3 = gbt.O000000o();
        O000000o2.O00000Oo().O00000o();
        fwz.O000000o(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, deviceStat2.did, bundle);
        if (O000000o3) {
            boolean O00000Oo = gbt.O00000Oo(deviceStat2.model);
            gbu.O00000oo("RNRuntimeManager initRNDevice,supportMultiRNRuntimeReuse:".concat(String.valueOf(O00000Oo)));
            if (O00000Oo) {
                fwv fwv = new fwv(deviceStat2.model, deviceStat2.did, Long.valueOf(pluginPackageInfo.O00000Oo()));
                fxa O000000o4 = fxa.O000000o();
                fwy = O000000o4.O00000Oo.get(fwv);
                if (fwy == null) {
                    gbu.O00000oo("ReuseManager getCache(),pluginBundleKey=" + fwv + ",value:null");
                } else {
                    gbu.O00000oo("ReuseManager getCache(),pluginBundleKey=" + fwv + ",value:" + fwy);
                }
                gbu.O00000oo("ReuseManager getCache,get over,mReuseProcessMap.size()=" + O000000o4.O00000Oo.size());
                gbu.O00000oo("RNRuntimeManager initRNDevice(),getCache result=".concat(String.valueOf(fwy)));
                if (fwy != null) {
                    i3 = 1;
                    if (fwy == null || !gbt.O00000Oo() || O00000Oo) {
                        i2 = i3;
                        fwy2 = fwy;
                    } else {
                        fwv fwv2 = new fwv(deviceStat2.model, deviceStat2.did, Long.valueOf(pluginPackageInfo.O00000Oo()));
                        fxa O000000o5 = fxa.O000000o();
                        fwy2 = O000000o5.O00000Oo.get(fwv2);
                        if (fwy2 == null) {
                            gbu.O00000oo("ReuseManager getAndRemoveCache(),pluginBundleKey=" + fwv2 + ",value:null");
                        } else {
                            O000000o5.O00000Oo.remove(fwv2);
                            gbu.O00000oo("ReuseManager getAndRemoveCache(),pluginBundleKey=" + fwv2 + ",value:" + fwy2);
                        }
                        gbu.O00000oo("ReuseManager getAndRemoveCache,get over,mReuseProcessMap.size()=" + O000000o5.O00000Oo.size());
                        gbu.O00000oo("RNRuntimeManager initRNDevice(),getAndRemoveCache result=".concat(String.valueOf(fwy2)));
                        i2 = fwy2 != null ? 2 : i3;
                    }
                    if (fwy2 == null) {
                        gbu.O00000oo("RNRuntimeManager initRNDevice(),getCache hit");
                        O000000o2.f17357O000000o = fwy2;
                        fxa.O000000o().O00000o = O000000o2.O00000Oo();
                        fxb fxb = O000000o2.O00000o0;
                        fxb.O00000o++;
                        fxb.O000000o();
                        gau gau = r6;
                        gau gau2 = new gau(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, deviceStat2.did, 1, O00000Oo ? 1 : 0, 1, fxa.O000000o().f17359O000000o, fxa.O000000o().O00000Oo.size());
                        O000000o2.O00000Oo = gau;
                    } else {
                        fwy fwy3 = fxa.O000000o().O00000o0;
                        if (fwy3 == null) {
                            gbu.O00000oo("RNRuntimeManager initRNDevice(),getCache not hit,getClear null reInit()");
                            fwy3 = fwz.O00000o0(true);
                            i = 2;
                        } else {
                            gbu.O00000oo("RNRuntimeManager initRNDevice(),getCache not hit,getClear hit");
                            i = 1;
                        }
                        O000000o2.f17357O000000o = fwy3;
                        fxa.O000000o().O00000o = O000000o2.O00000Oo();
                        fxa.O000000o().O000000o(null);
                        if (O00000Oo) {
                            fxb fxb2 = O000000o2.O00000o0;
                            fxb2.O00000oO++;
                            fxb2.O00000Oo();
                            fxb2.O000000o();
                            O000000o2.O00000Oo = new gau(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, deviceStat2.did, 1, 1, 0, fxa.O000000o().f17359O000000o, fxa.O000000o().O00000Oo.size());
                        } else {
                            fxb fxb3 = O000000o2.O00000o0;
                            fxb3.O00000oo++;
                            fxb3.O00000Oo();
                            fxb3.O000000o();
                            O000000o2.O00000Oo = new gau(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, deviceStat2.did, 1, 0, 0, fxa.O000000o().f17359O000000o, fxa.O000000o().O00000Oo.size());
                        }
                        O000000o2.O00000Oo.O0000Ooo = gax.O000000o(bundle);
                        O000000o2.O00000Oo.O0000o00 = i2;
                        O000000o2.O00000Oo.O0000o0 = i;
                        O000000o2.O00000Oo.O0000o0O = gbt.O00000Oo() ? 1 : 0;
                        int i4 = !hyy.O000000o() ? 2 : 1;
                        DisplayMetrics windowDisplayMetrics = DisplayMetricsHolder.getWindowDisplayMetrics();
                        DisplayMetrics screenDisplayMetrics = DisplayMetricsHolder.getScreenDisplayMetrics();
                        if (i4 != O000000o2.O00000Oo().O000O00o || ((!hyy.O000000o() && windowDisplayMetrics.widthPixels > windowDisplayMetrics.heightPixels) || (!hyy.O000000o() && screenDisplayMetrics.widthPixels > screenDisplayMetrics.heightPixels))) {
                            gbu.O00000oo("RNRuntimeManager currentDimensionType is not equal getCurrentRNRuntime().getDimensionType() reinitialize RNRuntime");
                            O000000o2.f17357O000000o = fwz.O00000o0(true);
                            fxa.O000000o().O00000o = O000000o2.O00000Oo();
                        }
                        O000000o2.O00000Oo().O00oOooo = i2;
                        O000000o2.O00000Oo().O000000o(deviceStat, pluginPackageInfo, pluginDeviceInfo, bundle, true);
                    }
                }
            } else {
                fwy = null;
            }
            i3 = 0;
            if (fwy == null) {
            }
            i2 = i3;
            fwy2 = fwy;
            if (fwy2 == null) {
            }
        } else {
            fxb fxb4 = O000000o2.O00000o0;
            fxb4.O00000o0++;
            fxb4.O00000Oo();
            fxb4.O000000o();
            O000000o2.O00000Oo = new gau(pluginPackageInfo.O00000Oo(), pluginPackageInfo.O000000o(), deviceStat2.model, deviceStat2.did, 0, gbt.O00000Oo(deviceStat2.model) ? 1 : 0, 0, gbt.O00000o0(), 0);
            i2 = 0;
        }
        i = 0;
        O000000o2.O00000Oo.O0000Ooo = gax.O000000o(bundle);
        O000000o2.O00000Oo.O0000o00 = i2;
        O000000o2.O00000Oo.O0000o0 = i;
        O000000o2.O00000Oo.O0000o0O = gbt.O00000Oo() ? 1 : 0;
        if (!hyy.O000000o()) {
        }
        DisplayMetrics windowDisplayMetrics2 = DisplayMetricsHolder.getWindowDisplayMetrics();
        DisplayMetrics screenDisplayMetrics2 = DisplayMetricsHolder.getScreenDisplayMetrics();
        gbu.O00000oo("RNRuntimeManager currentDimensionType is not equal getCurrentRNRuntime().getDimensionType() reinitialize RNRuntime");
        O000000o2.f17357O000000o = fwz.O00000o0(true);
        fxa.O000000o().O00000o = O000000o2.O00000Oo();
        O000000o2.O00000Oo().O00oOooo = i2;
        O000000o2.O00000Oo().O000000o(deviceStat, pluginPackageInfo, pluginDeviceInfo, bundle, true);
    }

    public void initRNRuntime() {
        fwz O000000o2 = fwz.O000000o();
        gbu.O00000oo("RNRuntimeManager init()");
        O000000o2.O00000Oo().O000000o(true);
    }

    public byte getInitStatus() {
        return fwz.O000000o().O00000Oo().O0000oOO;
    }

    public void preloadRNResource() {
        fwy O00000Oo = fwz.O000000o().O00000Oo();
        try {
            Class<?> cls = Class.forName(PluginRNActivity.class.getCanonicalName());
            gsy.O00000Oo("RNRuntimeTAG", "preload class:" + cls.getCanonicalName());
        } catch (ClassNotFoundException e) {
            gsy.O00000Oo("RNRuntimeTAG", "preloadRNActivityClass:" + Log.getStackTraceString(e));
        }
        if (LoadingBaseActivity.preloadContentView()) {
            gsy.O00000Oo("RNRuntimeTAG", "preload LoadingBaseActivity contentView finished");
        }
        Observable.just(0).subscribeOn(Schedulers.io()).map(new Function<Integer, Boolean>() {
            /* class _m_j.fwy.AnonymousClass3 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return O000000o();
            }

            private static Boolean O000000o() throws Exception {
                try {
                    gsy.O00000Oo("RNRuntimeTAG", "preloadRNResource, pre downloadRnExtModules");
                    ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000Oo();
                    gat.O000000o();
                } catch (RemoteException e) {
                    gsy.O000000o(6, "RNRuntimeTAG", "preloadRNResource, pre downloadRnExtModules" + Log.getStackTraceString(e));
                }
                return Boolean.TRUE;
            }
        }).subscribe();
    }

    public void reportOpenPluginError(String str, int i) {
        gav.O000000o(str, i);
    }

    public void tracePluginOpen(String str, PluginPackageInfo pluginPackageInfo, String str2) {
        gav.O000000o(str, pluginPackageInfo, str2);
    }

    public boolean needTracePluginOpen(int i, String str) {
        return gax.O000000o(i, str);
    }

    public void downloadRnExtModules(fkv<Integer, Integer> fkv) {
        fxy.O000000o().O000000o(fkv);
    }

    public void initBridgeCallback(IBridgeCallback iBridgeCallback) {
        fwz.O000000o().O00000Oo().O0000oOo = iBridgeCallback;
    }

    public void finishRnActivity() {
        gbu.O00000oo("CoreBridgeImpl-->closeCurrentPage()...");
        fwz.O000000o().O00000Oo().O00000o();
    }

    public boolean isRNProccess() {
        return fwz.O000000o().O00000Oo().O0000OoO != null;
    }

    public boolean processReuseEnableWithModel(String str) {
        boolean O000000o2 = gbt.O000000o(str);
        gbu.O00000oo("CoreBridgeImpl processReuseEnableWithModel()-->processReuseEnable:".concat(String.valueOf(O000000o2)));
        return O000000o2;
    }

    public boolean multiRNRuntimeReuseEnable() {
        return gbt.O000000o();
    }

    public DeviceStat getDeviceStat() {
        return fwz.O000000o().O00000Oo().O0000o00;
    }

    public void onFullScreen(boolean z) {
        fwy O00000Oo = fwz.O000000o().O00000Oo();
        if (O00000Oo.O0000OOo == null) {
            return;
        }
        if (z) {
            O00000Oo.O0000OOo.getWindow().clearFlags(2048);
            O00000Oo.O0000OOo.getWindow().setFlags(1024, 1024);
            return;
        }
        O00000Oo.O0000OOo.getWindow().clearFlags(1024);
    }

    public ReactInstanceManager getInstanceManager() {
        return fwz.O000000o().O00000Oo().O0000O0o;
    }

    public boolean isConfigPlugin() {
        return fwz.O000000o().O00000Oo().O00000o0();
    }

    public void setDialogThemePlugin(boolean z) {
        gbs.O000000o(z);
    }

    public void reportDownloadRes(String str, String str2, String str3, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("task_type", str);
        hashMap.put("device_model", str2);
        hashMap.put("url", str3);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("cost", Long.valueOf(j));
        hashMap.put("sdk_level", 10058);
        hashMap.put("tip", "6.0.0.0.152");
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_download_plugin_sdk", hashMap);
    }

    public void reportInstallRes(String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("task_type", str);
        hashMap.put("device_model", str2);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("sdk_level", 10058);
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_install_plugin_sdk", hashMap);
    }

    public void reportInstallDetailRes(String str, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("task_type", str);
        hashMap.put("device_model", str2);
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("sdk_level", 10058);
        PluginHostApi.instance().statReport("rn_plugin_framework", "rn_install_plugin_sdk_detail", hashMap);
    }
}
